package com.paohaijiao.javelin.visitor;

import com.paohaijiao.javelin.bean.JFormParam;
import com.paohaijiao.javelin.bean.JHeaderParam;
import com.paohaijiao.javelin.bean.JProxryBean;
import okhttp3.OkHttpClient;
import com.paohaijiao.javelin.parser.JThornRuleQuickRestBaseVisitor;


import okhttp3.RequestBody;
import okhttp3.Headers;
import okhttp3.ResponseBody;
import org.apache.commons.lang3.StringUtils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import okhttp3.OkHttpClient;
import javax.net.ssl.*;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
public class JThornRuleQuickRestCoreVisitor extends JThornRuleQuickRestBaseVisitor {

    protected OkHttpClient client;
    protected String method = null;
    protected String url;
    protected String data;
    protected String ContentType="application/json";
    protected List<JHeaderParam> headerList = new ArrayList<>();
    protected boolean followRedirects = false;
    protected String credentials;
    protected String downLoadFileName;
    protected JProxryBean jproxry;
    protected List<JFormParam> upLoadFileList = new ArrayList<>();
    public static OkHttpClient getUnsafeOkHttpClient() {
        try {
            final TrustManager[] trustAllCerts = new TrustManager[] {
                    new X509TrustManager() {
                        @Override
                        public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
                        }

                        @Override
                        public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
                        }

                        @Override
                        public X509Certificate[] getAcceptedIssuers() {
                            return new X509Certificate[]{};
                        }
                    }
            };
            final SSLContext sslContext = SSLContext.getInstance("SSL");
            sslContext.init(null, trustAllCerts, new java.security.SecureRandom());
            return new OkHttpClient.Builder()
                    .sslSocketFactory(sslContext.getSocketFactory(), (X509TrustManager)trustAllCerts[0])
                    .hostnameVerifier((hostname, session) -> true)
                    .build();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    protected String trimFileName(String fileName) {
        if(StringUtils.isNotEmpty(fileName)){
            return fileName.replaceAll("@", "");
        }else {
            return fileName;
        }
    }

    protected byte[] downLoadFile(ResponseBody responseBody) {
        try {
            InputStream inputStream = responseBody.byteStream();
            FileOutputStream outputStream = new FileOutputStream(downLoadFileName) ;
            byte[] buffer = new byte[4096];
            int bytesRead;
            while((bytesRead =inputStream.read(buffer))!=-1) {
                outputStream.write(buffer, 0, bytesRead);
            }
            return buffer;
        } catch(IOException e){
            e.printStackTrace();
        }
        return null;
    }

}
