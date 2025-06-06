package com.paohaijiao.javelin.visitor;

import com.paohaijiao.javelin.bean.JFormParam;
import com.paohaijiao.javelin.bean.JHeaderParam;
import com.paohaijiao.javelin.bean.JProxryBean;
import com.paohaijiao.javelin.enums.JHttpMethod;
import com.paohaijiao.javelin.enums.JProxryType;
import com.paohaijiao.javelin.exception.Assert;
import com.paohaijiao.javelin.util.StringUtils;
import lombok.extern.slf4j.Slf4j;
import okhttp3.*;
import com.paohaijiao.javelin.parser.JThornRuleQuickRestParser;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.io.File;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.Arrays;
import java.util.Base64;
import java.util.concurrent.TimeUnit;

public class JThornRuleQuickRestCommonVisitor extends JThornRuleQuickRestCoreVisitor {

    public JThornRuleQuickRestCommonVisitor(){

    }

    @Override
    public Object visitCurlCommand(JThornRuleQuickRestParser.CurlCommandContext ctx) {
        for (JThornRuleQuickRestParser.OptionContext option : ctx.option()) {
            visitOption(option);
        }
        for (JThornRuleQuickRestParser.UrlContext urlCtx : ctx.url()) {
            this.url = urlCtx.getText().replaceAll("^['\"]|['\"]$", "");
        }
        Assert.notNull(this.method ,"必须显示指定httpMethod");
        this.client = getOkHttpClient();
        Request.Builder builder  = new Request.Builder().url(url);
        RequestBody body=null;
        if(null!=this.data){
            body=RequestBody.create(this.data, MediaType.parse(ContentType));
        }else{//MediaType.parse(ContentType)
            body=RequestBody.create("{}", MediaType.parse(ContentType));
        }
        if(JHttpMethod.requireNotHaveRequestBody(this.method)){
            builder.method(this.method, null);
        }else{
            builder.method(method, body);
        }
        headerList.forEach(e->{
            builder.addHeader(e.getKey(),e.getValue());
        });
        Request request=builder.build();
        MultipartBody.Builder mutiPartBuilder = new MultipartBody.Builder().setType(MultipartBody.FORM);
        for(JFormParam formParam:upLoadFileList){
            if(formParam.isFile()){
                String fileName=StringUtils.trim(formParam.getValue());
                File file = new File(fileName);
                RequestBody fileBody = RequestBody.create(file, MediaType.parse("application/octet-stream"));
                mutiPartBuilder.addFormDataPart(formParam.getKey(), file.getName(), fileBody);
            }else{
                mutiPartBuilder.addFormDataPart(formParam.getKey(), formParam.getValue()).build();
            }
        }
        if(upLoadFileList.size()>0){
            request=request.newBuilder().post(mutiPartBuilder.build()).build();
        }
        if (credentials != null) {
            String auth = "Basic " + Base64.getEncoder().encodeToString(credentials.getBytes());
            request=request.newBuilder().header("Authorization", auth).build();
        }

        try  {
            Response response = client.newCall(request).execute();
            if (!response.isSuccessful()){
                System.out.println("Cannot request the resource");
            };
            ResponseBody responseData = response.body();
            if (downLoadFileName != null) {
                downLoadFile(responseData);
            }
            return responseData.string();
        }catch (IOException e){
            e.printStackTrace();
        }
        return null;
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
        } else if (ctx.downloadOption() != null) {
            visitDownloadOption(ctx.downloadOption());
        }else if (ctx.uploadOption() != null) {
            visitUploadOption(ctx.uploadOption());
        }else if (ctx.proxryOption() != null) {
            visitProxryOption(ctx.proxryOption());
        }else if (ctx.socketOption() != null) {
            visitSocketOption(ctx.socketOption());
        }else if (ctx.http2Option() != null) {
            visitHttp2Option(ctx.http2Option());
        }else if (ctx.ignoreOption() != null) {
            visitIgnoreOption(ctx.ignoreOption());
        }
        return null;
    }

    /**
     * PASS
     * @param ctx the parse tree
     * @return
     */
    @Override
    public JHttpMethod visitRequestMethod(JThornRuleQuickRestParser.RequestMethodContext ctx) {
        this.method = ctx.method.getText();
        JHttpMethod method= JHttpMethod.codeOf(this.method);
        return method;
    }

    /**
     * PASS
     * @param ctx the parse tree
     * @return
     */
    @Override
    public Void visitHeaderOption(JThornRuleQuickRestParser.HeaderOptionContext ctx) {
        String header = ctx.headerValue.getText().replaceAll("^['\"]|['\"]$", "");
        String[] parts = header.split(":", 2);
        if (parts.length == 2) {
            JHeaderParam jHeaderParam = new JHeaderParam();
            jHeaderParam.setKey(parts[0]);
            jHeaderParam.setValue(parts[1]);
            headerList.add(jHeaderParam);
            if("Content-Type".equalsIgnoreCase(parts[0])) {
                this.ContentType=parts[1];
            }
        }
        return null;
    }

    /**
     * PASS
     * @param ctx the parse tree
     * @return
     */
    @Override
    public Object visitDataOption(JThornRuleQuickRestParser.DataOptionContext ctx) {
        String data = ctx.dataValue.getText().replaceAll("^['\"]|['\"]$", "");
        this.data=data;
        return null;
    }

    @Override
    public Object visitDataUrlEncodeOption(JThornRuleQuickRestParser.DataUrlEncodeOptionContext ctx) {
        String data;
        if (ctx.emptyData() != null) {
            data = "";
        } else {
            data = ctx.formData().getText().replaceAll("^['\"]|['\"]$", "");
        }
        this.ContentType="application/x-www-form-urlencoded";
        return null;
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
    public String visitDownloadOption(JThornRuleQuickRestParser.DownloadOptionContext ctx) {
        String fileName = StringUtils.trim(ctx.STRING().getText());
        this.downLoadFileName=fileName;
        return fileName;
    }
    public Object visitUploadOption(JThornRuleQuickRestParser.UploadOptionContext ctx) {
        if(null!=ctx.STRING()){
            String uploadOption = StringUtils.trim(ctx.STRING().getText());
            if(org.apache.commons.lang3.StringUtils.isNotBlank(uploadOption)){
                String[] option=uploadOption.split("=");
                if(option.length==2){
                    JFormParam upLoadFile=new JFormParam();
                    upLoadFile.setKey(option[0]);
                    String formValue=option[1];
                    upLoadFile.setFile(formValue.startsWith("@"));
                    upLoadFile.setValue(trimFileName(option[1]));
                    this.upLoadFileList.add(upLoadFile);
                }
            }
        }
        return null;
    }

    @Override
    public Object visitOtherOption(JThornRuleQuickRestParser.OtherOptionContext ctx) {
        return visitChildren(ctx);
    }
    @Override
    public String visitProxryOption(JThornRuleQuickRestParser.ProxryOptionContext ctx) {
        if(null!=ctx.STRING()){
            String proxryHost= StringUtils.trim(ctx.STRING().getText());
            if(org.apache.commons.lang3.StringUtils.isNotBlank(proxryHost)){
                String[] proxryAddr=proxryHost.trim().split(":");
                JProxryBean proxryBean=new JProxryBean();
                proxryBean.setType(JProxryType.HTTP);
                if(proxryAddr.length==2){
                    proxryBean.setHost(proxryAddr[0]);
                    proxryBean.setPort(Integer.parseInt(proxryAddr[1]));
                    this.jproxry=proxryBean;
                }else if(proxryAddr.length==1){
                    proxryBean.setHost(proxryAddr[0]);
                    proxryBean.setPort(80);
                    this.jproxry=proxryBean;
                }
            }
        }
        return null;
    }
    @Override
    public String visitSocketOption(JThornRuleQuickRestParser.SocketOptionContext ctx) {
        if(null!=ctx.STRING()){
            String proxryHost= StringUtils.trim(ctx.STRING().getText());
            if(org.apache.commons.lang3.StringUtils.isNotBlank(proxryHost)){
                String[] proxryAddr=proxryHost.trim().split(":");
                JProxryBean proxryBean=new JProxryBean();
                proxryBean.setType(JProxryType.HTTP);
                if(proxryAddr.length==2){
                    proxryBean.setHost(proxryAddr[0]);
                    proxryBean.setPort(Integer.parseInt(proxryAddr[1]));
                    this.jproxry=proxryBean;
                }else if(proxryAddr.length==1){
                    proxryBean.setHost(proxryAddr[0]);
                    proxryBean.setPort(80);
                    this.jproxry=proxryBean;
                }
            }
        }
        return null;
    }


    /**
     * PASS
     * @param ctx the parse tree
     * @return
     */
    @Override
    public String visitUrl(JThornRuleQuickRestParser.UrlContext ctx) {
        if(null!=ctx.STRING()){
            return ctx.STRING().getText();
        }
        throw new IllegalArgumentException("Unknown URL adress");
    }
    @Override
    public OkHttpClient visitHttp2Option(
            JThornRuleQuickRestParser.Http2OptionContext ctx) {
        OkHttpClient client = new OkHttpClient.Builder()
                .protocols(Arrays.asList(Protocol.HTTP_2, Protocol.HTTP_1_1))
                .build();
        return client;
    }
    @Override
    public Boolean visitIgnoreOption(JThornRuleQuickRestParser.IgnoreOptionContext ctx) {
        this.ignoreSsl=true;
        return this.ignoreSsl;
    }

}
