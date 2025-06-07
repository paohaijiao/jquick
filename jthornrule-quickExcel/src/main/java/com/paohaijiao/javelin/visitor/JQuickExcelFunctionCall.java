package com.paohaijiao.javelin.visitor;

import com.paohaijiao.javelin.parser.JQuickExcelLexer;
import com.paohaijiao.javelin.parser.JQuickExcelParser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.*;

public class JQuickExcelFunctionCall extends JQuickExcelCommonVisitor<Object> {
    @Override
    public Object visitSource(JQuickExcelParser.SourceContext ctx) {
        Map<String, Object> sourceInfo = new HashMap<>();
        if (ctx.functionCall() != null) {
            sourceInfo.put("type", "function");
            sourceInfo.put("value", visit(ctx.functionCall()));
        }
        else if (ctx.identifier() != null) {
            sourceInfo.put("type", "identifier");
            sourceInfo.put("value", ctx.identifier().getText());
        }
        else if (ctx.jsonPath() != null) {
            sourceInfo.put("type", "jsonPath");
            sourceInfo.put("value", ctx.jsonPath().getText());
        }
        else if (ctx.apiCall() != null) {
            sourceInfo.put("type", "api");
            sourceInfo.put("value", visit(ctx.apiCall()));
        }
        return sourceInfo;
    }
    @Override
    public Object visitFunctionArg(JQuickExcelParser.FunctionArgContext ctx) {
        if (ctx.STRING() != null) {
            return removeQuotes(ctx.STRING().getText());
        }
        if (ctx.NUMBER() != null) {
            String numStr = ctx.NUMBER().getText();
            try {
                return numStr.contains(".") ? Double.parseDouble(numStr) : Long.parseLong(numStr);
            } catch (NumberFormatException e) {
            }
        }
        if (ctx.BOOLEAN() != null) {
            return Boolean.parseBoolean(ctx.BOOLEAN().getText());
        }
        if (ctx.functionCall() != null) {
            return visit(ctx.functionCall());
        }
        if (ctx.jsonPath() != null) {
            return visit(ctx.jsonPath());
        }
        if (ctx.identifier() != null) {
            return visit(ctx.identifier());
        }
        if (ctx.quotedFunctionCall() != null) {
            return visit(ctx.quotedFunctionCall());
        }
        return null;
    }
    @Override
    public Object visitJsonPath(JQuickExcelParser.JsonPathContext ctx) {
        Map<String, Object> jsonPath = new LinkedHashMap<>();
        jsonPath.put("nodeType", "jsonPath");
        List<Object> pathComponents = new ArrayList<>();
        for (int i = 0; i < ctx.getChildCount(); i++) {
            ParseTree child = ctx.getChild(i);
            if (child instanceof TerminalNode) {
                continue;
            } else if (child instanceof JQuickExcelParser.JsonPathContext) {
                // 处理路径元素
                pathComponents.add(visitJsonPathElement((JQuickExcelParser.JsonPathContext) child));
            }
        }

        jsonPath.put("path", pathComponents);
        jsonPath.put("source", ctx.getText());
        jsonPath.put("sourcePosition", getSourcePosition(ctx));
        return jsonPath;
    }
    @Override
    public Object visitIdentifier(JQuickExcelParser.IdentifierContext ctx) {
        Map<String, Object> identifier = new HashMap<>();
        identifier.put("type", "identifier");
        String idName = ctx.ID().getText();
        identifier.put("value", idName);
        return identifier;
    }
    @Override
    public Object visitQuotedFunctionCall(JQuickExcelParser.QuotedFunctionCallContext ctx) {
        String quotedText = ctx.STRING().getText();
        String unquotedText = removeQuotes(quotedText);
        Map<String, Object> result = new LinkedHashMap<>();
        result.put("nodeType", "quotedFunctionCall");
        result.put("rawText", quotedText);
        result.put("content", unquotedText);
        result.put("sourcePosition", getSourcePosition(ctx));
        try {
            if (unquotedText.contains("(") && unquotedText.endsWith(")")) {
                JQuickExcelLexer lexer = new JQuickExcelLexer(CharStreams.fromString(unquotedText));
                JQuickExcelParser parser = new JQuickExcelParser(new CommonTokenStream(lexer));
                ParseTree tree = parser.functionCall();
                if (tree != null && parser.getNumberOfSyntaxErrors() == 0) {
                    Object parsedFunction = visit(tree);
                    result.put("parsedFunction", parsedFunction);
                    result.put("isFunction", true);
                }
            }
        } catch (Exception e) {
            result.put("parseError", e.getMessage());
        }

        return result;
    }
    @Override
    public Object visitParameter(JQuickExcelParser.ParameterContext ctx) {
        // 1. 创建参数结果容器
        Map<String, Object> parameter = new LinkedHashMap<>();
        parameter.put("nodeType", "apiParameter");

        // 2. 解析参数名
        String paramName = ctx.ID().getText();
        parameter.put("name", paramName);
        parameter.put("sourcePosition", getSourcePosition(ctx));

        // 3. 解析参数值（跳过=符号，取第三个子节点）
        ParseTree valueNode = ctx.getChild(2);
        Object paramValue = visit(valueNode);

        // 4. 根据值类型进行特殊处理
        if (valueNode instanceof JQuickExcelParser.FunctionCallContext) {
            parameter.put("valueType", "function");
            // 标记嵌套函数调用作为参数
            if (paramValue instanceof Map) {
                ((Map<String, Object>) paramValue).put("isParameter", true);
            }
        } else if (valueNode instanceof TerminalNode) {
            TerminalNode terminal = (TerminalNode) valueNode;
            switch (terminal.getSymbol().getType()) {
                case JQuickExcelLexer.STRING:
                    parameter.put("valueType", "string");
                    break;
                case JQuickExcelLexer.NUMBER:
                    parameter.put("valueType", "number");
                    break;
                case JQuickExcelLexer.BOOLEAN:
                    parameter.put("valueType", "boolean");
                    break;
            }
        }
        parameter.put("value", paramValue);
        return parameter;
    }
}
