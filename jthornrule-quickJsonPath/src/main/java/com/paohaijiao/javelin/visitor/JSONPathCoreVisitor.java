package com.paohaijiao.javelin.visitor;

import com.paohaijiao.javelin.exception.Assert;
import com.paohaijiao.javelin.parser.JQuickJSONPathBaseVisitor;
import com.paohaijiao.javelin.obj.JSONObject;
import com.paohaijiao.javelin.parser.JQuickJSONPathParser;

import java.util.*;

public class JSONPathCoreVisitor extends JQuickJSONPathBaseVisitor<Object> {

    protected  Object rootJsonObject;
    protected Object currentJsonObject;
    private Deque<Map<String, Object>> variableStack = new ArrayDeque<>();

    public void pushScope() {
        variableStack.push(new HashMap<>());
    }

    public void popScope() {
        if (!variableStack.isEmpty()) {
            variableStack.pop();
        }
    }

    public void addVariable(String name, Object value) {
        if (!variableStack.isEmpty()) {
            variableStack.peek().put(name, value);
        }
    }

    protected Object visitDotField(JQuickJSONPathParser.IdentifierContext ctx, Object current) {
        String fieldName = ctx.getText();
        if (current instanceof JSONObject) {
            JSONObject jsonObj = (JSONObject) current;
            return jsonObj.has(fieldName) ? jsonObj.get(fieldName) : null;
        }
        else if (current instanceof List) {
            List<Object> results = new ArrayList<>();
            for (Object item : (List<?>) current) {
                if (item instanceof JSONObject) {
                    JSONObject jsonObj = (JSONObject) item;
                    if (jsonObj.has(fieldName)) {
                        results.add(jsonObj.get(fieldName));
                    }
                }
            }
            return results.isEmpty() ? null : results;
        }
        return null;
    }
    protected Object visitDotWildcard(Object current) {
        if (current instanceof JSONObject) {
            JSONObject jsonObj = (JSONObject) current;
            return new ArrayList<>(jsonObj.toMap().values());
        }
        else if (current instanceof List) {
            List<Object> results = new ArrayList<>();
            for (Object item : (List<?>) current) {
                if (item instanceof JSONObject) {
                    results.addAll(((JSONObject) item).toMap().values());
                }
            }
            return results.isEmpty() ? null : results;
        }
        return null;
    }
    protected boolean isTruthy(Object value) {
        if (value == null) {
            return false;
        }
        if (value instanceof Boolean) {
            return (Boolean) value;
        }
        if (value instanceof Number) {
            return ((Number) value).doubleValue() != 0;
        }
        if (value instanceof String) {
            return !((String) value).isEmpty();
        }
        if (value instanceof Collection) {
            return !((Collection<?>) value).isEmpty();
        }
        if (value instanceof Map) {
            return !((Map<?, ?>) value).isEmpty();
        }
        return true;
    }
    protected Object evaluateBinaryOperation(Object left, Object right, String operator) {
        // Handle null values
        if (left == null || right == null) {
            return handleNullComparison(left, right, operator);
        }
        if (left instanceof Number && right instanceof Number) {
            double leftNum = ((Number) left).doubleValue();
            double rightNum = ((Number) right).doubleValue();
            switch (operator) {
                case "<": return leftNum < rightNum;
                case ">": return leftNum > rightNum;
                case "<=": return leftNum <= rightNum;
                case ">=": return leftNum >= rightNum;
                case "==": return leftNum == rightNum;
                case "!=": return leftNum != rightNum;
            }
        }
        if (left instanceof String && right instanceof String) {
            int comparison = ((String) left).compareTo((String) right);
            switch (operator) {
                case "<": return comparison < 0;
                case ">": return comparison > 0;
                case "<=": return comparison <= 0;
                case ">=": return comparison >= 0;
                case "==": return comparison == 0;
                case "!=": return comparison != 0;
            }
        }
        if (operator.equals("&&")) {
            return isTruthy(left) && isTruthy(right);
        }
        if (operator.equals("||")) {
            return isTruthy(left) || isTruthy(right);
        }
        //regex match
        if (operator.equals("=~") && left instanceof String && right instanceof String) {
            String pattern = ((String) right).replaceAll("^/|/$", "");
            return ((String) left).matches(pattern);
        }
        if (operator.equals("in") && right instanceof List) {
            return ((List<?>) right).contains(left);
        }
        if (left instanceof Number && right instanceof Number) {
            double leftNum = ((Number) left).doubleValue();
            double rightNum = ((Number) right).doubleValue();
            switch (operator) {
                case "+": return leftNum + rightNum;
                case "-": return leftNum - rightNum;
                case "*": return leftNum * rightNum;
                case "/": return leftNum / rightNum;
                case "%": return leftNum % rightNum;
            }
        }
        return false;
    }
    private Object handleNullComparison(Object left, Object right, String operator) {
        if (operator.equals("==")) {
            return left == null && right == null;
        }
        if (operator.equals("!=")) {
            return left != null || right != null;
        }
        return false;
    }
    protected Object evaluateUnaryOperation(Object operand, String operator) {
        if (operand == null) {
            return false;
        }

        if (operator.equals("!")) {
            return !isTruthy(operand);
        }
        if (operator.equals("-") && operand instanceof Number) {
            return -((Number) operand).doubleValue();
        }

        return false;
    }
    protected Object handleWildcard() {
        if (currentJsonObject instanceof JSONObject) {
            JSONObject jsonObj = (JSONObject) currentJsonObject;
            return new ArrayList<>(jsonObj.toMap().values());
        }
        else if (currentJsonObject instanceof List) {
            return new ArrayList<>((List<?>) currentJsonObject);
        }
        return null;
    }
    protected Object handleIdentifierAccess(String identifier) {
        if (currentJsonObject instanceof JSONObject) {
            JSONObject jsonObj = (JSONObject) currentJsonObject;
            return jsonObj.has(identifier) ? jsonObj.get(identifier) : null;
        }
        else if (currentJsonObject instanceof List) {
            List<Object> results = new ArrayList<>();
            for (Object item : (List<?>) currentJsonObject) {
                if (item instanceof JSONObject) {
                    JSONObject jsonItem = (JSONObject) item;
                    if (jsonItem.has(identifier)) {
                        results.add(jsonItem.get(identifier));
                    }
                }
            }
            return results.isEmpty() ? null : results;
        }
        return null;
    }
    protected Object visitBracketNotation(JQuickJSONPathParser.SubscriptContext ctx, Object current) {
        if (current == null) {
            return null;
        }
        if (current instanceof JSONObject) {
            return visitSubscript(ctx);
        }
        else if (current instanceof List) {
            return visitSubscript(ctx);
        }
        return null;
    }
    protected Object visitWildcard() {
        return visitWildcard(this.currentJsonObject);
    }

    protected Object visitWildcard(Object current) {
        if (current == null) {
            return null;
        }
        if (current instanceof JSONObject) {
            JSONObject jsonObj = (JSONObject) current;
            return new ArrayList<>(jsonObj.toMap().values());
        }
        else if (current instanceof List) {
            return current;
        }
        else if (current instanceof Map) {
            return new ArrayList<>(((Map<?, ?>) current).values());
        }
        return Collections.emptyList();
    }
    protected Object visitRecursiveField(JQuickJSONPathParser.IdentifierContext ctx, Object current) {
        String fieldName = ctx.getText();
        List<Object> results = new ArrayList<>();
        collectFieldValuesRecursively(current, fieldName, results);
        return results.isEmpty() ? null : results;
    }
    private void collectFieldValuesRecursively(Object node, String fieldName, List<Object> results) {
        if (node == null) {
            return;
        }
        if (node instanceof JSONObject) {
            JSONObject jsonObj = (JSONObject) node;
            if (jsonObj.has(fieldName)) {
                results.add(jsonObj.get(fieldName));
            }
            for (Object value : jsonObj.toMap().values()) {
                collectFieldValuesRecursively(value, fieldName, results);
            }
        }
        else if (node instanceof List) {
            for (Object item : (List<?>) node) {
                collectFieldValuesRecursively(item, fieldName, results);
            }
        }
    }
    protected Object visitRecursiveBracketNotation(JQuickJSONPathParser.SubscriptContext ctx, Object current) {
        List<Object> results = new ArrayList<>();
        collectBracketMatchesRecursively(current, ctx, results);
        return results.isEmpty() ? null : results;
    }

    /**
     * 递归收集所有匹配方括号表达式的结果
     */
    private void collectBracketMatchesRecursively(Object node, JQuickJSONPathParser.SubscriptContext ctx,
                                                  List<Object> results) {
        if (node == null) {
            return;
        }

        Object matchResult = visitSubscript(ctx);
        if (matchResult != null) {
            if (matchResult instanceof List) {
                results.addAll((List<?>) matchResult);
            } else {
                results.add(matchResult);
            }
        }
        if (node instanceof JSONObject) {
            JSONObject jsonObj = (JSONObject) node;
            for (Object value : jsonObj.toMap().values()) {
                collectBracketMatchesRecursively(value, ctx, results);
            }
        }
        else if (node instanceof List) {
            for (Object item : (List<?>) node) {
                collectBracketMatchesRecursively(item, ctx, results);
            }
        }
    }
    protected Object resolveIdentifier(String identifier)  {
        // 1. 处理字面量常量(true/false/null)
        if ("true".equals(identifier)) {
            return true;
        }
        if ("false".equals(identifier)) {
            return false;
        }
        if ("null".equals(identifier)) {
            return null;
        }
        if (variableStack != null && !variableStack.isEmpty()) {
            Map<String, Object> currentScope = variableStack.peek();
            if (currentScope.containsKey(identifier)) {
                return currentScope.get(identifier);
            }
        }
        Assert.throwNewException("无法解析标识符 '" + identifier + "'");
        return null;
    }
}
