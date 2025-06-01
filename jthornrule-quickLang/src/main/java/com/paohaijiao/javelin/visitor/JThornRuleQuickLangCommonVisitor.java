package com.paohaijiao.javelin.visitor;

import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.TerminalNode;
import com.paohaijiao.javelin.parser.JThornRuleQuickLangParser;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class JThornRuleQuickLangCommonVisitor extends JThornRuleQuickLangCoreVisitor {

    @Override
    public Object visitRules(JThornRuleQuickLangParser.RulesContext ctx) {
        for(int i=0;i<ctx.rule_().size();i++){
            visitRule(ctx.rule_().get(i));
        }
        return null;
    }
    @Override
    public Object visitRule(JThornRuleQuickLangParser.RuleContext ctx) {
        if(null!=ctx.assignment()){
            return visitAssignment(ctx.assignment());
        }
        return null;
    }

    @Override
    public Object visitAssignment(JThornRuleQuickLangParser.AssignmentContext ctx) {
        if(null!=ctx.booleanExpr()){
            return visitBooleanExpr(ctx.booleanExpr());
        }
        return null;
    }
    @Override
    public Object visitElseIfStatment(JThornRuleQuickLangParser.ElseIfStatmentContext ctx) {
        return visitChildren(ctx); }

    @Override
    public Object visitElseAction(JThornRuleQuickLangParser.ElseActionContext ctx) {
        return visitChildren(ctx); }


    @Override
    public Object visitAction(JThornRuleQuickLangParser.ActionContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Boolean visitBooleanExpr(JThornRuleQuickLangParser.BooleanExprContext ctx) {
        Boolean left = (Boolean) visit(ctx.singgelBool(0));
        for (int i = 1; i < ctx.singgelBool().size(); i++) {
            Token op = ctx.getChild(TerminalNode.class, i * 2 - 1).getSymbol();
            Boolean right = (Boolean) visit(ctx.singgelBool(i));
            if (op.getType() == JThornRuleQuickLangParser.AND) {
                left = left && right;
            } else if (op.getType() == JThornRuleQuickLangParser.OR) {
                left = left || right;
            }
        }
        return left;
    }

    @Override
    public Boolean visitSinggelBool(JThornRuleQuickLangParser.SinggelBoolContext ctx) {
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
    public Boolean visitBool(JThornRuleQuickLangParser.BoolContext ctx) {
        return ctx.TRUE() != null; // 如果是TRUE返回true，否则返回false

    }

    @Override
    public Boolean visitNumberBool(JThornRuleQuickLangParser.NumberBoolContext ctx) {
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
    public Boolean visitStringBool(JThornRuleQuickLangParser.StringBoolContext ctx) {
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
    public Boolean visitDateBool(JThornRuleQuickLangParser.DateBoolContext ctx) {
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
    public Object visitNumber(JThornRuleQuickLangParser.NumberContext ctx) {
        // 情况 1: 直接是数字（INT 或 FLOAT）
        if (ctx.NUMBER() != null) {
            String numText = ctx.NUMBER().getText();
            if (numText.contains(".")) {
                return Double.parseDouble(numText); // 浮点数
            } else {
                return Integer.parseInt(numText);   // 整数
            }
        }
        if (ctx.variables() != null) {
            String varName = ctx.variables().id().getText();
            // 从运行时环境获取变量值（示例伪代码）
            //return resolveVariable(varName); // 需实现 resolveVariable 方法
        }

        throw new RuntimeException("Unsupported number format: " + ctx.getText());
    }

    @Override
    public Object visitString(JThornRuleQuickLangParser.StringContext ctx) {
        // 情况 1: 字符串字面量（如 "hello"）
        if (ctx.STRING() != null) {
            String text = ctx.STRING().getText();
            // 去掉首尾引号，并处理转义字符（如 \n, \t）
            return text.substring(1, text.length() - 1)
                    .replace("\\n", "\n")
                    .replace("\\t", "\t")
                    .replace("\\\"", "\"");
        }

        // 情况 2: 变量（如 ${var}）
        if (ctx.variables() != null) {
            String varName = ctx.variables().id().getText();
          //  return resolveVariable(varName); // 从变量存储中获取值
        }

        throw new RuntimeException("Invalid string: " + ctx.getText());
    }

    @Override
    public Object visitDate(JThornRuleQuickLangParser.DateContext ctx) {
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

    @Override
    public Object visitVariables(JThornRuleQuickLangParser.VariablesContext ctx) {
        return visitChildren(ctx);
    }
    @Override
    public Object visitId(JThornRuleQuickLangParser.IdContext ctx) {
        return ctx.ID().getText();
    }
}
