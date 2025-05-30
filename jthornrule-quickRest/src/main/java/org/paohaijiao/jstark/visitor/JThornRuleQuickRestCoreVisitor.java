package org.paohaijiao.jstark.visitor;

import okhttp3.OkHttpClient;
import org.paohaijiao.jstark.parser.JThornRuleQuickRestBaseVisitor;
import org.paohaijiao.jstark.parser.JThornRuleQuickRestParser;


import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Headers;
import java.util.ArrayList;
import java.util.List;
import java.util.Base64;
public class JThornRuleQuickRestCoreVisitor extends JThornRuleQuickRestBaseVisitor {

    protected OkHttpClient client;
    protected String method = "GET";
    protected String url;
    protected final Headers.Builder headersBuilder = new Headers.Builder();
    protected RequestBody body;
    protected boolean followRedirects = false;
    protected String credentials;

}
