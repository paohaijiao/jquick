package com.paohaijiao.javelin.visitor;

import okhttp3.OkHttpClient;
import com.paohaijiao.javelin.parser.JThornRuleQuickRestBaseVisitor;


import okhttp3.RequestBody;
import okhttp3.Headers;

public class JThornRuleQuickRestCoreVisitor extends JThornRuleQuickRestBaseVisitor {

    protected OkHttpClient client;
    protected String method = "GET";
    protected String url;
    protected final Headers.Builder headersBuilder = new Headers.Builder();
    protected RequestBody body;
    protected boolean followRedirects = false;
    protected String credentials;

}
