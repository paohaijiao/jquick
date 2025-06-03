package com.paohaijiao.javelin.visitor;

import com.paohaijiao.javelin.bean.JFormParam;
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

public class JThornRuleQuickRestCoreVisitor extends JThornRuleQuickRestBaseVisitor {

    protected OkHttpClient client;
    protected String method = "GET";
    protected String url;
    protected final Headers.Builder headersBuilder = new Headers.Builder();
    protected RequestBody body;
    protected boolean followRedirects = false;
    protected String credentials;
    protected String downLoadFileName;
    protected JProxryBean jproxry;
    protected List<JFormParam> upLoadFileList = new ArrayList<>();

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
