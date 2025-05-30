package org.paohaijiao.jstark.visitor;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import org.paohaijiao.jstark.parser.JThornRuleQuickRestParser;

import java.util.Base64;

public class JThornRuleQuickRestCommonVisitor extends JThornRuleQuickRestCoreVisitor {

    public JThornRuleQuickRestCommonVisitor(){
        OkHttpClient client = new OkHttpClient();
        this.client = client;
    }

    @Override
    public Request visitCurlCommand(JThornRuleQuickRestParser.CurlCommandContext ctx) {
        for (JThornRuleQuickRestParser.OptionContext option : ctx.option()) {
            visitOption(option);
        }
        for (JThornRuleQuickRestParser.UrlContext urlCtx : ctx.url()) {
            this.url = urlCtx.getText().replaceAll("^['\"]|['\"]$", "");
        }
        Request.Builder requestBuilder = new Request.Builder()
                .url(url)
                .method(method, body);
        requestBuilder.headers(headersBuilder.build());
        if (credentials != null) {
            String auth = "Basic " + Base64.getEncoder().encodeToString(credentials.getBytes());
            requestBuilder.header("Authorization", auth);
        }
        return requestBuilder.build();
    }

    @Override
    public Object visitOption(JThornRuleQuickRestParser.OptionContext ctx) {
        if (ctx.requestMethod() != null) {
            visitRequestMethod(ctx.requestMethod());
        } else if (ctx.headerOption() != null) {
            visitHeaderOption(ctx.headerOption());
        } else if (ctx.dataOption() != null) {
            visitDataOption(ctx.dataOption());
        } else if (ctx.dataUrlEncodeOption() != null) {
            visitDataUrlEncodeOption(ctx.dataUrlEncodeOption());
        } else if (ctx.userOption() != null) {
            visitUserOption(ctx.userOption());
        } else if (ctx.locationOption() != null) {
            visitLocationOption(ctx.locationOption());
        } else if (ctx.otherOption() != null) {
            visitOtherOption(ctx.otherOption());
        }
        return null;
 }

    @Override
    public Void  visitRequestMethod(JThornRuleQuickRestParser.RequestMethodContext ctx) {
         this.method = ctx.method.getText();
         return null;
    }

    @Override
    public Void visitHeaderOption(JThornRuleQuickRestParser.HeaderOptionContext ctx) {
        String header = ctx.headerValue.getText().replaceAll("^['\"]|['\"]$", "");
        String[] parts = header.split(":", 2);
        if (parts.length == 2) {
            headersBuilder.add(parts[0].trim(), parts[1].trim());
        }
        return null;
    }

    @Override
    public Object visitDataOption(JThornRuleQuickRestParser.DataOptionContext ctx) {
        String data = ctx.dataValue.getText().replaceAll("^['\"]|['\"]$", "");
        body = RequestBody.create(data, MediaType.parse("application/x-www-form-urlencoded"));
        return body;
    }

    @Override
    public Object visitDataUrlEncodeOption(JThornRuleQuickRestParser.DataUrlEncodeOptionContext ctx) {
        String data;
        if (ctx.emptyData() != null) {
            data = "";
        } else {
            data = ctx.formData().getText().replaceAll("^['\"]|['\"]$", "");
        }
        body = RequestBody.create(data, MediaType.parse("application/x-www-form-urlencoded"));
        return body;
    }

    @Override
    public Object visitEmptyData(JThornRuleQuickRestParser.EmptyDataContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Object visitFormData(JThornRuleQuickRestParser.FormDataContext ctx) {
        return visitChildren(ctx); }

    @Override
    public Object visitUserOption(JThornRuleQuickRestParser.UserOptionContext ctx) {
        credentials = ctx.userValue.getText().replaceAll("^['\"]|['\"]$", "");
        return credentials;
    }

    @Override
    public Object visitLocationOption(JThornRuleQuickRestParser.LocationOptionContext ctx) {
        followRedirects = true;
        return followRedirects;
    }

    @Override
    public Object visitOtherOption(JThornRuleQuickRestParser.OtherOptionContext ctx) { return visitChildren(ctx); }

    @Override
    public String visitUrl(JThornRuleQuickRestParser.UrlContext ctx) {
        if(null!=ctx.STRING()){
            return ctx.STRING().getText();
        }
        if(null!=ctx.URL()){
            return ctx.URL().getText();
        }
        throw new IllegalArgumentException("Unknown boolean expression type");
    }

}
