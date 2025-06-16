package com.paohaijiao.javelin.visitor;

import com.paohaijiao.javelin.param.ContextParams;
import com.paohaijiao.javelin.parser.JQuickLangParser;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.TerminalNode;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class JQuickLangCommonVisitor extends JQuickLangValueVisitor {
    public JQuickLangCommonVisitor(ContextParams context){
        this.context = context;
    }
    public JQuickLangCommonVisitor(){
        this.context = new ContextParams();
    }

    @Override
    public Object visitRule(JQuickLangParser.RuleContext ctx) {
        if(null!=ctx.assignment()){
            return visitAssignment(ctx.assignment());
        }
        return null;
    }

    @Override
    public Object visitAssignment(JQuickLangParser.AssignmentContext ctx) {
        if(null!=ctx.booleanExpr()){
            return visitBooleanExpr(ctx.booleanExpr());
        }
        return null;
    }
    @Override
    public Object visitElseIfStatment(JQuickLangParser.ElseIfStatmentContext ctx) {
        return visitChildren(ctx); }

    @Override
    public Object visitElseAction(JQuickLangParser.ElseActionContext ctx) {
        return visitChildren(ctx); }


    @Override
    public Object visitAction(JQuickLangParser.ActionContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Boolean visitBooleanExpr(JQuickLangParser.BooleanExprContext ctx) {
        Boolean left = (Boolean) visit(ctx.singgelBool(0));
        for (int i = 1; i < ctx.singgelBool().size(); i++) {
            Token op = ctx.getChild(TerminalNode.class, i * 2 - 1).getSymbol();
            Boolean right = (Boolean) visit(ctx.singgelBool(i));
            if (op.getType() == JQuickLangParser.AND) {
                left = left && right;
            } else if (op.getType() == JQuickLangParser.OR) {
                left = left || right;
            }
        }
        return left;
    }

    @Override
    public Boolean visitSinggelBool(JQuickLangParser.SinggelBoolContext ctx) {
        if (ctx.bool() != null) {
            return visitBool(ctx.bool());
        } else if (ctx.numberBool() != null) {
            return visitNumberBool(ctx.numberBool());
        } else if (ctx.stringBool() != null) {
            return visitStringBool(ctx.stringBool());
        } else if (ctx.dateBool() != null) {
            return visitDateBool(ctx.dateBool());
        }
        throw new IllegalArgumentException("Unknown boolean expression type");
    }

    @Override
    public Boolean visitBool(JQuickLangParser.BoolContext ctx) {
        return ctx.TRUE() != null; // 如果是TRUE返回true，否则返回false

    }

    @Override
    public Boolean visitNumberBool(JQuickLangParser.NumberBoolContext ctx) {
        // 实现数字比较逻辑
        double left = Double.parseDouble(ctx.number(0).getText());
        double right = Double.parseDouble(ctx.number(1).getText());
        if (null!=ctx.EQ()) {
            return left == right;
        }
        if (null!=ctx.GT()) {
            return left > right;
        }
        if (null!=ctx.GE()) {
            return left >= right;
        }
        if (null!=ctx.LT()) {
            return left < right;
        }
        if (null!=ctx.LE()) {
            return left <= right;
        }
        if (null!=ctx.NE()) {
            return left != right;
        }
        throw new IllegalArgumentException("Unknown comparison operator");
    }

    @Override
    public Boolean visitStringBool(JQuickLangParser.StringBoolContext ctx) {
        String left = removeQuotes(ctx.string(0).getText());
        String right = removeQuotes(ctx.string(1).getText());
        if (null!=ctx.CONTAIN()) {
            left.contains(right);
        }
        if (null!=ctx.START()) {
            return left.startsWith(right);
        }
        if (null!=ctx.NOTSTART()) {
            return !left.startsWith(right);
        }
        if (null!=ctx.END()) {
            return left.endsWith(right);
        }
        if (null!=ctx.NOTEND()) {
            return !left.endsWith(right);
        }
        throw new IllegalArgumentException("Unknown string operator");
    }

    @Override
    public Boolean visitDateBool(JQuickLangParser.DateBoolContext ctx) {
        // 1. 解析左右日期
        Date leftDate = parseDate(ctx.date(0).getText());
        Date rightDate = parseDate(ctx.date(1).getText());
        int comparison = leftDate.compareTo(rightDate);
        if (null!=ctx.GT()) {
            return comparison > 0;
        }
        if (null!=ctx.GE()) {
            return comparison >= 0;
        }
        if (null!=ctx.LT()) {
            return comparison < 0;
        }
        if (null!=ctx.LE()) {
            return comparison < 0;
        }
        if (null!=ctx.EQ()) {
            return comparison == 0;
        }
        if (null!=ctx.NE()) {
            return comparison != 0;
        }
        throw new IllegalArgumentException("Unknown date comparison operator: ");
    }

    @Override
    public Object visitNumber(JQuickLangParser.NumberContext ctx) {
        // 情况 1: 直接是数字（INT 或 FLOAT）
        if (ctx.NUMBER() != null) {
            String numText = ctx.NUMBER().getText();
            if (numText.contains(".")) {
                return Double.parseDouble(numText); // 浮点数
            } else {
                return Integer.parseInt(numText);   // 整数
            }
        }

        throw new RuntimeException("Unsupported number format: " + ctx.getText());
    }

    @Override
    public Object visitString(JQuickLangParser.StringContext ctx) {
        // 情况 1: 字符串字面量（如 "hello"）
        if (ctx.STRING() != null) {
            String text = ctx.STRING().getText();
            // 去掉首尾引号，并处理转义字符（如 \n, \t）
            return text.substring(1, text.length() - 1)
                    .replace("\\n", "\n")
                    .replace("\\t", "\t")
                    .replace("\\\"", "\"");
        }

        throw new RuntimeException("Invalid string: " + ctx.getText());
    }

    @Override
    public Object visitDate(JQuickLangParser.DateContext ctx) {
        // 情况 1: 日期字面量（如 2023-10-05）
        if (ctx.DATE() != null) {
            String dateText = ctx.DATE().getText();
            return LocalDate.parse(dateText, DateTimeFormatter.ISO_LOCAL_DATE);
        }

        // 情况 2: 时间字面量（如 14:30+08:00）
        if (ctx.TIME() != null) {
            String timeText = ctx.TIME().getText();
            // 解析时间（可能包含时区）
            if (timeText.contains("+") || timeText.contains("-")) {
                return ZonedDateTime.parse(timeText, DateTimeFormatter.ISO_OFFSET_TIME);
            } else {
                return LocalTime.parse(timeText, DateTimeFormatter.ISO_LOCAL_TIME);
            }
        }

        // 情况 3: 变量（如 ${dateVar}）
        if (ctx.variables() != null) {
            String varName = ctx.variables().id().getText();
//            Object value = resolveVariable(varName);
            // 确保变量是日期/时间类型
//            if (value instanceof LocalDate || value instanceof LocalTime || value instanceof ZonedDateTime) {
//                return value;
//            }
            throw new RuntimeException("Variable '" + varName + "' is not a date/time.");
        }

        throw new RuntimeException("Invalid date format: " + ctx.getText());
    }


}
