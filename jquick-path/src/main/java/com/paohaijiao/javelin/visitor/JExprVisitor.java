package com.paohaijiao.javelin.visitor;

import com.paohaijiao.javelin.bean.JSlice;
import com.paohaijiao.javelin.exception.Assert;
import com.paohaijiao.javelin.function.JCallFunction;
import com.paohaijiao.javelin.parser.JQuickJSONPathParser;
import com.paohaijiao.javelin.util.ObjectConverter;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JExprVisitor extends JValueVisitor {
    @Override
    public Object visitNetestDotExpr(JQuickJSONPathParser.NetestDotExprContext ctx) {
        if(ctx.dotExpr() != null) return visit(ctx.dotExpr());
        return null;
    }
    @Override
    public Object visitBracketExpression(JQuickJSONPathParser.BracketExpressionContext ctx) {
        //obj['property'], array[0], obj[*] obj[1,2,3] (@.length-1)) ,?(@.price > 10),
        //multiple subscripts separated by commas
        Object target = visit(ctx.expr());
        Object subscript = null;
        if(null!=ctx.subscript()){
            subscript=visit(ctx.subscript());
        }
        return handleSubscript(target, subscript);
    }
    private Object handleSubscript(Object target,Object subscript) {
        if (target == null) {
            return null;
        }
        // Handle multiple subscripts case (comma-separated)
        //todo
        if (subscript instanceof Integer) {
            int index = (Integer)subscript;
            return this.getList(target).get(index);
        } else if (subscript instanceof String&&!"*".equals(((String)subscript).trim())) {
            String property =(String)subscript;
            property = property.substring(1, property.length() - 1); // Remove quotes
            return getProperty(target, property);
        } else if (subscript instanceof String&&(subscript).equals("*")) {
            return getAllProperties(target);
        } else if (subscript instanceof JSlice) {
            // Array slice (e.g., 1:3:2)
            JSlice slice = ObjectConverter.assign(subscript, JSlice.class);
            List<?> list=slice(getList(this.currentJsonObject),slice.getStart(),slice.getEnd(),slice.getStep());
            return list;
        }
        //else if (ctx.scriptExpression() != null) {
//            /$.store.books[?( (@.price * $.store.discount) > 15 )]
            // Script expression - evaluate the expression
//            return visit(ctx.scriptExpression().expr());
        //    return  null;
   //     }
        else if (subscript instanceof List) {//filter list
            return subscript;
        }

        return null;
    }
    @Override
    public Object visitFunctionCallExpression(JQuickJSONPathParser.FunctionCallExpressionContext ctx) {
        String functionName;
        if (ctx.expr() instanceof JQuickJSONPathParser.IdentifierExpressionContext) {
            functionName = ctx.expr().getText();
        } else {
            Object fnObj = visit(ctx.expr());
            functionName = fnObj != null ? fnObj.toString() : "";
        }
        List<Object> arguments = new ArrayList<>();
        if (ctx.exprList() != null) {
            for (JQuickJSONPathParser.ExprContext argCtx : ctx.exprList().expr()) {
                arguments.add(visit(argCtx));
            }
        }
        return new JCallFunction().callFunction(functionName, arguments.toArray());
    }

    @Override
    public Object visitMultiplicativeExpression(JQuickJSONPathParser.MultiplicativeExpressionContext ctx) {
        Object left = visit(ctx.expr(0));
        Object right = visit(ctx.expr(1));
        String operator = ctx.getChild(1).getText();
        Object object=evaluateBinaryOperation(left,right,operator);
        return object;
    }

    @Override
    public Object visitAdditiveExpression(JQuickJSONPathParser.AdditiveExpressionContext ctx) {
        Object left = visit(ctx.expr(0));
        Object right = visit(ctx.expr(1));
        String operator = ctx.getChild(1).getText();
        Object object=evaluateBinaryOperation(left,right,operator);
        return object;
    }

    @Override
    public Object visitComparisonExpression(JQuickJSONPathParser.ComparisonExpressionContext ctx) {
        Object left = visit(ctx.expr(0));
        Object right = visit(ctx.expr(1));
        String operator = ctx.getChild(1).getText();
        Object object=evaluateBinaryOperation(left,right,operator);
        return object;
    }
    @Override
    public Object visitEqualityExpression(JQuickJSONPathParser.EqualityExpressionContext ctx) {
        Object left = visit(ctx.expr(0));
        Object right = visit(ctx.expr(1));
        String operator = ctx.getChild(1).getText();
        Object object=evaluateBinaryOperation(left,right,operator);
        return object;
    }
    @Override
    public Object visitRegexExpression(JQuickJSONPathParser.RegexExpressionContext ctx) {
        Object left = visit(ctx.expr());
        if (left == null) {
            return false;
        }
        String regexPattern = ctx.regexLiteral().getText();
        String patternWithFlags = regexPattern.substring(1, regexPattern.length() - 1);
        int lastSlash = patternWithFlags.lastIndexOf('/');
        String pattern;
        int flags = 0;
        if (lastSlash >= 0) {
            pattern = patternWithFlags.substring(0, lastSlash);
            String flagsStr = patternWithFlags.substring(lastSlash + 1);
            flags = parseRegexFlags(flagsStr);
        } else {
            pattern = patternWithFlags;
        }

        try {
            Pattern compiledPattern = Pattern.compile(pattern, flags);
            Matcher matcher = compiledPattern.matcher(left.toString());
            return matcher.matches();
        } catch (Exception e) {
            throw new RuntimeException("Invalid regular expression pattern: " + pattern, e);
        }
    }
    @Override
    public Object visitInExpression(JQuickJSONPathParser.InExpressionContext ctx) {
        Object searchValue = visit(ctx.expr());
        List<Object> valueList = parseValueList(ctx.valueList());
        if (searchValue == null) {
            return valueList.contains(null);
        }
        for (Object listValue : valueList) {
            if (valuesEqual(searchValue, listValue)) {
                return true;
            }
        }
        return false;
    }
    @Override
    public Object visitLogicalAndExpression(JQuickJSONPathParser.LogicalAndExpressionContext ctx) {
        Object left = visit(ctx.expr(0));
        Object right = visit(ctx.expr(1));
        String operator = ctx.getChild(1).getText();
        Object object=evaluateBinaryOperation(left,right,operator);
        return object;
    }
    @Override
    public Object visitLogicalOrExpression(JQuickJSONPathParser.LogicalOrExpressionContext ctx) {
        Object left = visit(ctx.expr(0));
        Object right = visit(ctx.expr(1));
        String operator = ctx.getChild(1).getText();
        Object object=evaluateBinaryOperation(left,right,operator);
        return object;
    }
    @Override
    public Object visitLiteralExpression(JQuickJSONPathParser.LiteralExpressionContext ctx) {
        if(null!=ctx.literal()){
            return visitLiteral(ctx.literal());
        }
        Assert.throwNewException("Invalid literal expression");
        return null;
    }
    @Override
    public Object visitIdentifierExpression(JQuickJSONPathParser.IdentifierExpressionContext ctx) {
        if(null!=ctx.identifier()){
            return visitIdentifier(ctx.identifier());
        }
        Assert.throwNewException("Invalid identifier expression");
        return null;
    }
    @Override
    public Object visitRootExpression(JQuickJSONPathParser.RootExpressionContext ctx) {
        this.currentJsonObject=this.rootJsonObject;
        return this.rootJsonObject;
    }
    @Override
    public Object visitCurrentExpression(JQuickJSONPathParser.CurrentExpressionContext ctx) {
        return this.currentJsonObject;
    }

    @Override
    public Object visitParenthesizedExpression(JQuickJSONPathParser.ParenthesizedExpressionContext ctx) {
        return visit(ctx.expr());
    }

    @Override
    public Object visitNegationExpression(JQuickJSONPathParser.NegationExpressionContext ctx) {
        Object value=visit(ctx.expr());
        if (value instanceof Number) {
            if (value instanceof Integer) {
                return -((Integer) value);
            }
            if (value instanceof Long) {
                return -((Long) value);
            }
            if (value instanceof Float) {
                return -((Float) value);
            }
            if (value instanceof Double) {
                return -((Double) value);
            }
            if (value instanceof BigDecimal) {
                return ((BigDecimal) value).negate();
            }
            if (value instanceof BigInteger) {
                return ((BigInteger) value).negate();
            }
            return -((Number) value).doubleValue();
        }
        Assert.throwNewException("Cannot apply negation to non-numeric value: " +
                (value != null ? value.getClass().getSimpleName() : "null"));
        return null;
    }
    @Override
    public Object visitNotExpression(JQuickJSONPathParser.NotExpressionContext ctx) {
        Object value = visit(ctx.expr());
        if (value instanceof Boolean) {
            return !((Boolean) value);
        }
        if (value instanceof Number) {
            double num = ((Number) value).doubleValue();
            return num == 0 || Double.isNaN(num);
        }
        if (value instanceof String) {
            return ((String) value).isEmpty();
        }
        if (value instanceof Collection) {
            return ((Collection<?>) value).isEmpty();
        }
        if (value instanceof Map) {
            return ((Map<?, ?>) value).isEmpty();
        }
        if (value == null) {
            return true;
        }
        return false;
    }
    @Override
    public Object visitDirectDotExpression(JQuickJSONPathParser.DirectDotExpressionContext ctx) {
       // e.g., obj.property, $.*, @.field
        Object leftValue=new Object();
        String rightValue="";
        if (ctx.leftDotExpr() != null) {
            leftValue = visitLeftDotExpr(ctx.leftDotExpr());
        }
        if (ctx.rightDotExpr() != null) {
            rightValue = visitRightDotExpr(ctx.rightDotExpr());
        }
        if (rightValue.equals("*")) {
            return getAllProperties(leftValue);
        }
        return getProperty(leftValue, rightValue);
    }
    @Override
    public Object visitLeftDotExpr(JQuickJSONPathParser.LeftDotExprContext ctx) {
        if(null!=ctx.identifier()){
           return visitIdentifier(ctx.identifier());
        }else if("$".equals(ctx.getText())){
            return rootJsonObject;
        }else if("@".equals(ctx.getText())){
            return currentJsonObject;
        }else if(null!=ctx.literal()){
            return visitLiteral(ctx.literal());
        }else if(null!=ctx.expr()){
            return visit(ctx.expr());
        }
        Assert.throwNewException("Invalid expression");
        return null;
    }
    @Override
    public String visitRightDotExpr(JQuickJSONPathParser.RightDotExprContext ctx) {
        return ctx.getText();
    }

    @Override
    public Object visitChainedDotExpression(JQuickJSONPathParser.ChainedDotExpressionContext ctx) {
        //e.g., obj.property.subproperty
        Object currentValue = visit(ctx.dotExpr());
        String property = visitRightDotExpr(ctx.rightDotExpr());
        if (property.equals("*")) {
            return getAllProperties(currentValue);
        }
        return getProperty(currentValue, property);
    }
    private int parseRegexFlags(String flagsStr) {
        int flags = 0;
        for (char flag : flagsStr.toCharArray()) {
            switch (flag) {
                case 'i': flags |= Pattern.CASE_INSENSITIVE; break;
                case 'm': flags |= Pattern.MULTILINE; break;
                case 's': flags |= Pattern.DOTALL; break;
                case 'u': flags |= Pattern.UNICODE_CASE; break;
                case 'x': flags |= Pattern.COMMENTS; break;
                case 'd': flags |= Pattern.UNIX_LINES; break;
            }
        }
        return flags;
    }
    private List<Object> parseValueList(JQuickJSONPathParser.ValueListContext ctx) {
        List<Object> values = new ArrayList<>();
        for (JQuickJSONPathParser.LiteralContext literal : ctx.literal()) {
            values.add(visit(literal));
        }
        return values;
    }

    private boolean valuesEqual(Object a, Object b) {
        if (a == null || b == null) {
            return a == null && b == null;
        }
        if (a instanceof Number && b instanceof Number) {
            return Math.abs(((Number) a).doubleValue() - ((Number) b).doubleValue()) < 1e-10;
        }
        if (a instanceof String || b instanceof String) {
            return a.toString().equals(b.toString());
        }
        return a.equals(b);
    }

}
