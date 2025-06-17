package com.paohaijiao.javelin.core;

import com.paohaijiao.javelin.param.ContextParams;
import com.paohaijiao.javelin.parser.JQuickLangBaseVisitor;
import com.paohaijiao.javelin.visitor.JQuickLangAssignVisitor;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class JQuickLangCoreVisitor extends JQuickLangBaseVisitor {
    protected ContextParams context;

    protected String removeQuotes(String quotedString) {
        return quotedString.substring(1, quotedString.length() - 1);
    }



}
