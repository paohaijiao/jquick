package com.paohaijiao.javelin.visitor;

import com.paohaijiao.javelin.bean.JQuickExcelImport;
import com.paohaijiao.javelin.enums.JQuickExcelEnums;
import com.paohaijiao.javelin.parser.JQuickExcelBaseVisitor;
import com.paohaijiao.javelin.util.ReflectionUtils;
import org.antlr.v4.runtime.ParserRuleContext;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.*;
import java.util.stream.Collectors;

public class JQuickExcelCoreVisitor<Object> extends JQuickExcelBaseVisitor<Object> {
    protected JQuickExcelEnums type  = JQuickExcelEnums.IMPORT;
    protected JQuickExcelImport jQuickExcelImport  = new JQuickExcelImport();
    protected List<Map<String, Object>> currentList;
    protected String removeQuotes(String str) {
        return str.replaceAll("^\"|\"$", "");
    }
    protected Map<String, String> parseFormatSpec(String formatSpec) {
        Map<String, String> spec = new LinkedHashMap<>();
        spec.put("formatType", formatSpec.split("\\(")[0].toLowerCase());
        spec.put("pattern", formatSpec.replaceAll(".*\\(|\\)", ""));
        return spec;
    }
    protected Map<String, Integer> getSourcePosition(ParserRuleContext ctx) {
        Map<String, Integer> pos = new HashMap<>();
        pos.put("line", ctx.getStart().getLine());
        pos.put("column", ctx.getStart().getCharPositionInLine());
        return pos;
    }
    protected InputStream getInputStreamByFileName(String fileName) {
        try  {
            InputStream in = new FileInputStream(fileName);
            return in;
        } catch (Exception e) {
            e.printStackTrace();
        }return null;
    }
    protected Workbook getWorkbookByInputStream(InputStream input) {
        try  {
            Workbook workbook = new XSSFWorkbook(input);
            return workbook;
        } catch (Exception e) {
            e.printStackTrace();
        }return null;
    }
    protected void addReflectionInfo(String fullName,List<Object> args) {
        try {
            // 分离类名和方法名
            int lastDot = fullName.lastIndexOf('.');
            if (lastDot == -1) return;
            String className = fullName.substring(0, lastDot);
            String methodName = fullName.substring(lastDot + 1);
            Class<?> clazz = Class.forName(className);
            List<Method> methods = ReflectionUtils.getAllMethods(clazz);
            @SuppressWarnings("unchecked")
            Method matchedMethod = findBestMatchMethod(methods, methodName, args);

            if (matchedMethod != null) {
                Map<String, Object> reflectionInfo = new LinkedHashMap<>();
                reflectionInfo.put("declaringClass", matchedMethod.getDeclaringClass().getName());
                reflectionInfo.put("returnType", matchedMethod.getReturnType().getName());
                reflectionInfo.put("parameterTypes",
                        Arrays.stream(matchedMethod.getParameterTypes())
                                .map(Class::getName)
                                .collect(Collectors.toList()));

                functionCall.put("reflectionInfo", reflectionInfo);
            }
        } catch (Exception e) {
            // 反射信息获取失败不影响主流程
            functionCall.put("reflectionError", e.getMessage());
        }

    }
    protected Method findBestMatchMethod(List<Method> methods, String methodName, List<Map<String, Object>> args) {
        List<Method> candidates = methods.stream()
                .filter(m -> m.getName().equals(methodName))
                .collect(Collectors.toList());

        if (candidates.isEmpty()) return null;
        if (candidates.size() == 1) return candidates.get(0);
        // 简单参数数量匹配（实际应更复杂的类型匹配）
        for (Method method : candidates) {
            if (method.getParameterCount() == args.size()) {
                return method;
            }

        }
        return candidates.get(0);//default FirstOne
    }


}
