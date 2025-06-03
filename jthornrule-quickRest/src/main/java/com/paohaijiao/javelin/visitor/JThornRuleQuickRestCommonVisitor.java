package com.paohaijiao.javelin.visitor;

import com.paohaijiao.javelin.bean.JFormParam;
import com.paohaijiao.javelin.bean.JProxryBean;
import com.paohaijiao.javelin.enums.JHttpMethod;
import com.paohaijiao.javelin.enums.JProxryType;
import com.paohaijiao.javelin.util.StringUtils;
import lombok.extern.slf4j.Slf4j;
import okhttp3.*;
import com.paohaijiao.javelin.parser.JThornRuleQuickRestParser;

import java.io.File;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.Arrays;
import java.util.Base64;

@Slf4j
public class JThornRuleQuickRestCommonVisitor extends JThornRuleQuickRestCoreVisitor {

    public JThornRuleQuickRestCommonVisitor(){

    }

    @Override
    public ResponseBody visitCurlCommand(JThornRuleQuickRestParser.CurlCommandContext ctx) {
        for (JThornRuleQuickRestParser.OptionContext option : ctx.option()) {
            visitOption(option);
        }
        for (JThornRuleQuickRestParser.UrlContext urlCtx : ctx.url()) {
            this.url = urlCtx.getText().replaceAll("^['\"]|['\"]$", "");
        }
        OkHttpClient client = new OkHttpClient();
        Proxy proxy =null;
        if (jproxry != null) {
            proxy = new Proxy(JProxryType.HTTP.getCode().equals(jproxry.getType().getCode())?
                    Proxy.Type.HTTP:Proxy.Type.SOCKS,
                    new InetSocketAddress(jproxry.getHost(),jproxry.getPort()));
        }
        if (proxy != null) {
            client = new OkHttpClient.Builder()
                    .proxy(proxy)
                    .build();
        }
        this.client = client;
        Request.Builder builder  = new Request.Builder().url(url);
        builder.method(method, body);
        builder.headers(headersBuilder.build());
        Request request=builder.build();
        MultipartBody.Builder mutiPartBuilder = new MultipartBody.Builder()
                .setType(MultipartBody.FORM);
        for(JFormParam formParam:upLoadFileList){
            if(formParam.isFile()){
                File file = new File(formParam.getValue());
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
            return responseData;
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
        }
        return null;
 }

    @Override
    public JHttpMethod visitRequestMethod(JThornRuleQuickRestParser.RequestMethodContext ctx) {
         this.method = ctx.method.getText();
         JHttpMethod method= JHttpMethod.codeOf(this.method);
         return method;
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



    @Override
    public String visitUrl(JThornRuleQuickRestParser.UrlContext ctx) {
        if(null!=ctx.STRING()){
            return ctx.STRING().getText();
        }
        throw new IllegalArgumentException("Unknown boolean expression type");
    }
    @Override public OkHttpClient visitHttp2Option(
            JThornRuleQuickRestParser.Http2OptionContext ctx) {
        OkHttpClient client = new OkHttpClient.Builder()
                .protocols(Arrays.asList(Protocol.HTTP_2, Protocol.HTTP_1_1))
                .build();
        return client;
    }

}
