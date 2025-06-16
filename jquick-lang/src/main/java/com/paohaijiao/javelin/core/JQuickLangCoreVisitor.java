package com.paohaijiao.javelin.core;

import com.paohaijiao.javelin.param.ContextParams;
import com.paohaijiao.javelin.parser.JQuickLangBaseVisitor;
import com.paohaijiao.javelin.parser.JQuickLangParser;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class JQuickLangCoreVisitor extends JQuickLangBaseVisitor {
    protected ContextParams context;

    protected String removeQuotes(String quotedString) {
        return quotedString.substring(1, quotedString.length() - 1);
    }


    protected Date parseDate(String dateStr)  {
        try{
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            return sdf.parse(dateStr);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

    }

    protected Date parseDateTime(String datetimeStr)  {
        // 处理 yyyy-MM-dd HH:mm 或 yyyy-MM-dd HH:mm:ss 格式

        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            return sdf.parse(datetimeStr);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    protected Date parseDateTimeWithZone(String datetimeWithZoneStr) throws ParseException {
        // 处理带时区的时间 yyyy-MM-dd HH:mm+08:00
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mmXXX");
        return sdf.parse(datetimeWithZoneStr.replaceFirst("([+-]\\d{2}):(\\d{2})$", "$1$2"));
    }

    protected Date parseDateExpression(JQuickLangParser.DateContext ctx) throws ParseException {
        if (ctx.TIME() != null) {
            return parseDateTime(ctx.TIME().getText());
        } else if (ctx.DATE() != null) {
            return parseDate(ctx.DATE().getText());
        } else if (ctx.TIME_ZONE() != null) {
            return parseDateTimeWithZone(ctx.TIME_ZONE().getText());
        }
        throw new IllegalArgumentException("Unknown date expression");
    }
}
