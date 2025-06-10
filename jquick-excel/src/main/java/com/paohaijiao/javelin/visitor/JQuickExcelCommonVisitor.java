package com.paohaijiao.javelin.visitor;

import com.paohaijiao.javelin.enums.JQuickExcelEnums;
import com.paohaijiao.javelin.parser.JQuickExcelParser;
import com.paohaijiao.javelin.util.ReflectionUtils;

import java.util.ArrayList;
import java.util.List;

public class JQuickExcelCommonVisitor<Void> extends JQuickExcelCoreVisitor<Object> {
    protected String rangeStart =null;
    protected String rangeEnd =null;
    @Override
    public Void visitConfig(JQuickExcelParser.ConfigContext ctx) {
        if (ctx.importConfig() != null) {
            this.type= JQuickExcelEnums.IMPORT;
             visitImportConfig(ctx.importConfig());
        } else {
            this.type= JQuickExcelEnums.EXPORT;
            visitExportConfig(ctx.exportConfig());
        }
        return null;
    }
    @Override
    public String visitRangeOption(JQuickExcelParser.RangeOptionContext ctx) {
       //A1:D10 B:B
        String range=  ctx.STRING().getText().replaceAll("\"", "");
        String[] ranges=range.split(":");
        if(ranges.length==2){
            rangeStart=ranges[0];
            rangeEnd=ranges[1];
        }
        return range;
    }
    @Override
    public Object visitFunctionCall(JQuickExcelParser.FunctionCallContext ctx) {
        String functionName = ctx.ID().getText();
        boolean isPackageStyle = functionName.contains(".");
        List<Object> arguments = new ArrayList<>();
        if (ctx.functionArg() != null) {
            for (JQuickExcelParser.FunctionArgContext argCtx : ctx.functionArg()) {
                Object argValue = visit(argCtx);
                arguments.add(argValue);
            }
        }
        if (isPackageStyle) {
            String packageName=ReflectionUtils.getPackageName(functionName);
            String className=ReflectionUtils.getClassName(functionName);
            Object result2 = ReflectionUtils.preciseInvokeMethod(packageName, className, className, null, null);
            return result2;
        }else{
            return arguments;
        }
    }






//    @Override
//    public  Map<String, String> visitExportConfig(JQuickExcelParser.ExportConfigContext ctx) {
//        Map<String, String> exportConfig = new HashMap<>();
//        exportConfig.put("source", visit(ctx.source()));
//        exportConfig.put("file", removeQuotes(ctx.STRING().getText()));
//        if (ctx.exportOption() != null && !ctx.exportOption().isEmpty()) {
//            List<Map<String, Object>> options = new ArrayList<>();
//            for (JQuickExcelParser.ExportOptionContext option : ctx.exportOption()) {
//                options.add((Map<String, Object>) visit(option));
//            }
//            exportConfig.put("options", options);
//        }
//
//        return exportConfig;
//    }
//    @Override
//    public  Map<String, String>  visitSource(JQuickExcelParser.SourceContext ctx) {
//        Map<String, String> sourceInfo = new HashMap<>();
//        if (ctx.functionCall() != null) {
//            sourceInfo.put("type", "function");
//            sourceInfo.put("value", visit(ctx.functionCall()));
//        }
//        else if (ctx.identifier() != null) {
//            sourceInfo.put("type", "identifier");
//            sourceInfo.put("value", ctx.identifier().getText());
//        }
//        else if (ctx.jsonPath() != null) {
//            sourceInfo.put("type", "jsonPath");
//            sourceInfo.put("value", ctx.jsonPath().getText());
//        }
//        else if (ctx.apiCall() != null) {
//            sourceInfo.put("type", "api");
//            sourceInfo.put("value", visit(ctx.apiCall()));
//        }
//
//        return sourceInfo;
//    }
//    @Override
//    public  Map<String, String>  visitFunctionCall(JQuickExcelParser.FunctionCallContext ctx) {
//        Map<String, Object> functionCall = new HashMap<>();
//        functionCall.put("type", "functionCall");
//        String functionName = ctx.ID().getText();
//        functionCall.put("name", functionName);
//        List<Object> arguments = new ArrayList<>();
//        if (ctx.functionArg() != null) {
//            for (JQuickExcelParser.FunctionArgContext arg : ctx.functionArg()) {
//                arguments.add(visit(arg));
//            }
//        }
//        functionCall.put("args", arguments);
//
//        return functionCall;
//    }




    // 辅助方法：处理JSON路径元素
    private Object visitJsonPathElement(JQuickExcelParser.JsonPathContext ctx) {
        if (ctx.ID() != null) {
            // 属性访问形式: .property
//            return Map.of(
//                    "type", "property",
//                    "name", ctx.ID().getText()
//            );
        } else if (ctx.INTEGER() != null) {
            // 数组索引形式: [index]
            try {
//                return Map.of(
//                        "type", "index",
//                        "value", Integer.parseInt(ctx.INTEGER().getText())
//                );
            } catch (NumberFormatException e) {
           e.printStackTrace();
            }
        }
        return null;
    }



//    @Override
//    public Object visitApiCall(JQuickExcelParser.ApiCallContext ctx) {
//        Map<String, String> apiCall = new LinkedHashMap<>();
//        apiCall.put("nodeType", "apiCall");
//        String url = ctx.URL().getText();
//        apiCall.put("url", url);
//        Map<String, Object> parameters = new LinkedHashMap<>();
//        if (ctx.parameter() != null) {
//            for (JQuickExcelParser.ParameterContext paramCtx : ctx.parameter()) {
//                String paramName = paramCtx.ID().getText();
//                Object paramValue = visit(paramCtx.getChild(2)); // 跳过'='节点
//                parameters.put(paramName, paramValue);
//            }
//        }
//        apiCall.put("parameters", parameters);
//        apiCall.put("sourcePosition", getSourcePosition(ctx));
//        return apiCall;
//    }


}
