package com.paohaijiao.javelin.visitor;

import com.paohaijiao.javelin.obj.JSONObject;
import com.paohaijiao.javelin.parser.JQuickJSONPathParser;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class JSONPathCommonVisitor extends JRootAndPathVisitor {

    public JSONPathCommonVisitor(Object root) {
        this.rootJsonObject = root;
        this.currentJsonObject = rootJsonObject;
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
//            Object exprResult = visitExpr(exprCtx);
//            if (isTruthy(exprResult)) {
//                results.add(item);
//            }
        }
        Object obj= results.isEmpty() ? null : results;
        this.currentJsonObject=obj;
        return null;
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


//    @Override
//    public Object visitStringLiteral(JQuickJSONPathParser.StringLiteralContext ctx) {
//        Object current = currentJsonObject;
//        String key = ctx.getText().replaceAll("^[\"']|[\"']$", "");
//        if (current instanceof JSONObject) {
//            return ((JSONObject) current).has(key) ? ((JSONObject) current).get(key) : null;
//        } else if (current instanceof List) {
//            List<Object> results = new ArrayList<>();
//            for (Object item : (List<?>) current) {
//                if (item instanceof JSONObject && ((JSONObject) item).has(key)) {
//                    results.add(((JSONObject) item).get(key));
//                }
//            }
//            return results.isEmpty() ? null : results;
//        }
//        return null;
//    }


}
