package com.paohaijiao.javelin.bean;

import lombok.Data;
import okhttp3.MediaType;
import okio.BufferedSource;
import okio.ByteString;

import java.io.InputStream;
import java.io.Reader;

@Data
public class JResult {

    private MediaType mediaType;

    private String string;

    private byte[] bytes;

    private InputStream byteStream;

    private Reader charStream;

    private ByteString byteString;
    private Long contentLength;
    private BufferedSource source;
}
