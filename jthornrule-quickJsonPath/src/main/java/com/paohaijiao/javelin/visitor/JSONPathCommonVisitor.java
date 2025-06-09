package com.paohaijiao.javelin.visitor;

import com.paohaijiao.javelin.bean.JSONPathResult;
import com.paohaijiao.javelin.obj.JSONArray;
import com.paohaijiao.javelin.obj.JSONObject;
import com.paohaijiao.javelin.parser.JQuickJSONPathParser;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class JSONPathCommonVisitor extends JSONPathCoreVisitor {

    public JSONPathCommonVisitor(Object root) {
        this.rootJsonObject = root;
        this.currentJsonObject = rootJsonObject;
    }


    @Override
    public Object visitSubscript(JQuickJSONPathParser.SubscriptContext ctx) {
        if (ctx.number() != null) {
            return visitNumber(ctx.number());
        } else if (ctx.stringLiteral() != null) {
            return visitStringLiteral(ctx.stringLiteral());
        } else if (ctx.slice() != null) {
            return visitSlice(ctx.slice());
        } else if (ctx.filterExpression() != null) {
            return visitFilterExpression(ctx.filterExpression());
        } else if (ctx.scriptExpression() != null) {
            return visitScriptExpression(ctx.scriptExpression());
        } else if (ctx.getText().equals("*")) {
            return visitWildcard();
        } else if (ctx.subscript() != null && ctx.getChild(0).getText().equals(",")) {
            // 处理多个 subscript 的情况（如 [1,2,3]）
            List<Object> results = new ArrayList<>();
            for (JQuickJSONPathParser.SubscriptContext subCtx : ctx.subscript()) {
                Object result = visitSubscript(subCtx);
                if (result != null) {
                    if (result instanceof List) {
                        results.addAll((List<?>) result);
                    } else {
                        results.add(result);
                    }
                }
            }
            return results;
        }
        return null;
    }

    @Override
    public Void visitFilterExpression(JQuickJSONPathParser.FilterExpressionContext ctx) {
        Object current = currentJsonObject;
        if (!(current instanceof List)) {
            return null;
        }
        List<?> list = (List<?>) current;
        List<Object> results = new ArrayList<>();
        JQuickJSONPathParser.ExprContext exprCtx = ctx.expr();
        for (Object item : list) {
            Object exprResult = visitExpr(exprCtx);
            if (isTruthy(exprResult)) {
                results.add(item);
            }
        }
        Object obj= results.isEmpty() ? null : results;
        this.currentJsonObject=obj;
        return null;
    }

    @Override
    public Object visitSlice(JQuickJSONPathParser.SliceContext ctx) {
        Object current = currentJsonObject;
        if (!(current instanceof List)) {
            return null;
        }
        List<?> list = (List<?>) current;
        int size = list.size();
        Integer start = ctx.getChildCount() > 0 && ctx.getChild(0) instanceof JQuickJSONPathParser.NumberContext ?
                Integer.parseInt(ctx.getChild(0).getText()) : null;
        Integer end = ctx.getChildCount() > 2 && ctx.getChild(2) instanceof JQuickJSONPathParser.NumberContext ?
                Integer.parseInt(ctx.getChild(2).getText()) : null;
        Integer step = ctx.getChildCount() > 4 && ctx.getChild(4) instanceof JQuickJSONPathParser.NumberContext ?
                Integer.parseInt(ctx.getChild(4).getText()) : 1;

        start = start != null ? (start < 0 ? size + start : start) : 0;
        end = end != null ? (end < 0 ? size + end : end) : size;
        start = Math.max(0, Math.min(start, size));
        end = Math.max(0, Math.min(end, size));
        List<Object> result = new ArrayList<>();
        if (step > 0) {
            for (int i = start; i < end; i += step) {
                result.add(list.get(i));
            }
        } else if (step < 0) {
            for (int i = end - 1; i >= start; i += step) {
                result.add(list.get(i));
            }
        }

        return result;
    }

    /**
     * ()
     *
     * @param ctx the parse tree
     * @return
     */
    @Override
    public Object visitScriptExpression(JQuickJSONPathParser.ScriptExpressionContext ctx) {
        JQuickJSONPathParser.ExprContext exprCtx = ctx.expr();
        return visit(exprCtx);
    }

    @Override
    public Object visitExpr(JQuickJSONPathParser.ExprContext ctx) {
        String text=ctx.getText();
        if (ctx.getChildCount() == 1) {  //literal,identifier or simple
            if(ctx.getText().equals("@")){
                return this.currentJsonObject;
            }
            if(ctx.getText().equals("$")){
                return this.rootJsonObject;
            }
            if(ctx.getText().equals("-")){
                return this.rootJsonObject;
            }
            if(ctx.getText().equals("!")){
                return this.rootJsonObject;
            }

        }
        if (ctx.getChildCount() == 3) {
            Object left = visit(ctx.getChild(0));
            Object right = visit(ctx.getChild(2));
            String operator = ctx.getChild(1).getText();
            return evaluateBinaryOperation(left, right, operator);
        }
        if (ctx.getChildCount() == 2) {
            Object operand = visit(ctx.getChild(1));
            String operator = ctx.getChild(0).getText();
            return evaluateUnaryOperation(operand, operator);
        }
        // Parentheses
        if (ctx.getChild(0).getText().equals("(")) {
            return visit(ctx.getChild(1));
        }

        return null;
    }

    @Override
    public JSONObject visitValueList(JQuickJSONPathParser.ValueListContext ctx) {
        JSONObject result = new JSONObject();
        List<Object> values = new ArrayList<>();
        for (JQuickJSONPathParser.LiteralContext literalCtx : ctx.literal()) {
            Object value = visitLiteral(literalCtx);
            if (value != null) {
                values.add(value);
            }
        }
        result.put("values", values);
        return result;
    }

    @Override
    public Pattern visitRegexLiteral(JQuickJSONPathParser.RegexLiteralContext ctx) {
        String regexText = ctx.getText();
        int lastSlash = regexText.lastIndexOf('/');
        String pattern = regexText.substring(1, lastSlash);
        String flags = regexText.substring(lastSlash + 1);
        int javaFlags = 0;
        if (!flags.isEmpty()) {
            for (char flag : flags.toCharArray()) {
                switch (flag) {
                    case 'i':
                        javaFlags |= Pattern.CASE_INSENSITIVE;
                        break;
                    case 'm':
                        javaFlags |= Pattern.MULTILINE;
                        break;
                    case 's':
                        javaFlags |= Pattern.DOTALL;
                        break;
                }
            }
        }

        try {
            return Pattern.compile(pattern, javaFlags);
        } catch (PatternSyntaxException e) {
            throw new RuntimeException("Invalid regular expression: " + pattern, e);
        }
    }

    @Override
    public List<Object> visitExprList(JQuickJSONPathParser.ExprListContext ctx) {
        List<Object> results = new ArrayList<>();
        for (JQuickJSONPathParser.ExprContext exprCtx : ctx.expr()) {
            Object result = visit(exprCtx);
            results.add(result);
        }
        return results;
    }

    @Override
    public Object visitIdentifier(JQuickJSONPathParser.IdentifierContext ctx) {
        String identifier = ctx.getText();
        if (identifier.equals("*")) {
            return handleWildcard();
        }
        return handleIdentifierAccess(identifier);
    }

    @Override
    public Object visitLiteral(JQuickJSONPathParser.LiteralContext ctx) {
        if (ctx.stringLiteral() != null) {
            String text = ctx.stringLiteral().getText();
            return text.substring(1, text.length() - 1);
        } else if (ctx.number() != null) {
            String numText = ctx.number().getText();
            try {
                if (numText.contains(".")) {
                    return Double.parseDouble(numText);
                } else {
                    return Integer.parseInt(numText);
                }
            } catch (NumberFormatException e) {
                return null;
            }
        } else if (ctx.getText().equals("true")) {
            return true;
        } else if (ctx.getText().equals("false")) {
            return false;
        } else if (ctx.getText().equals("null")) {
            return null;
        }
        return null;
    }

    @Override
    public Object visitStringLiteral(JQuickJSONPathParser.StringLiteralContext ctx) {
        Object current = currentJsonObject;
        String key = ctx.getText().replaceAll("^[\"']|[\"']$", "");
        if (current instanceof JSONObject) {
            return ((JSONObject) current).has(key) ? ((JSONObject) current).get(key) : null;
        } else if (current instanceof List) {
            List<Object> results = new ArrayList<>();
            for (Object item : (List<?>) current) {
                if (item instanceof JSONObject && ((JSONObject) item).has(key)) {
                    results.add(((JSONObject) item).get(key));
                }
            }
            return results.isEmpty() ? null : results;
        }
        return null;
    }

    @Override
    public Object visitNumber(JQuickJSONPathParser.NumberContext ctx) {
        Object current = currentJsonObject;
        if (!(current instanceof List)) {
            return null;
        }
        List<?> list = (List<?>) current;
        int index = Integer.parseInt(ctx.getText());
        return index >= 0 && index < list.size() ? list.get(index) : null;
    }
}
