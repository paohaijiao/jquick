package com.paohaijiao.javelin.visitor;

import com.paohaijiao.javelin.parser.JQuickJSONPathParser;
import org.antlr.v4.runtime.tree.ParseTree;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class JExprVisitor extends JValueVisitor {
    @Override
    public Object visitDotExpression(JQuickJSONPathParser.DotExpressionContext ctx) {
        try {
            Object target = evaluateLeftSide(ctx);
            String property = ctx.getChild(2).getText();
            if (property.equals("*")) {
                return getAllProperties(target);
            } else {
                return getProperty(target, property);
            }
        } catch (Exception e) {
           // throw new EvaluationException("Error evaluating dot expression: " + ctx.getText(), e);
        }
        return null;
    }
    private Object evaluateLeftSide(JQuickJSONPathParser.DotExpressionContext ctx) {
        ParseTree leftChild = ctx.getChild(0);
        if (leftChild instanceof JQuickJSONPathParser.IdentifierContext) {
            return resolveIdentifier(((JQuickJSONPathParser.IdentifierContext) leftChild).getText());
        } else if (leftChild.getText().equals("$")) {
            return rootJsonObject;
        } else if (leftChild.getText().equals("@")) {
            return currentJsonObject;
        } else if (leftChild instanceof JQuickJSONPathParser.LiteralContext) {
            return visitLiteral((JQuickJSONPathParser.LiteralContext) leftChild);
        } else if (leftChild instanceof JQuickJSONPathParser.ExprContext) {
            return visit(((JQuickJSONPathParser.ExprContext) leftChild));
        } else {
            return visit(leftChild);
        }
    }

    private Object getProperty(Object target, String property) {
        if (target == null) {
            return null;
        }

        if (target instanceof Map) {
            return ((Map<?, ?>) target).get(property);
        } else if (target instanceof List) {
            try {
                int index = Integer.parseInt(property);
                return ((List<?>) target).get(index);
            } catch (NumberFormatException e) {
              e.printStackTrace();
            }
        } else {
            try {
                Field field = target.getClass().getField(property);
                return field.get(target);
            } catch (Exception e) {
//                throw new IllegalAccessException("Cannot access property '" + property + "' on object of type " +
//                        target.getClass().getName());
            }
        }
        return null;
    }

    private List<Object> getAllProperties(Object target) {
        List<Object> results = new ArrayList<>();
        if (target instanceof Map) {
            results.addAll(((Map<?, ?>) target).values());
        } else if (target instanceof List) {
            results.addAll((List<?>) target);
        } else {
            for (Field field : target.getClass().getFields()) {
                try {
                    results.add(field.get(target));
                } catch (IllegalAccessException e) {
                }
            }
        }
        return results;
    }

}
