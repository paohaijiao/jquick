package com.paohaijiao.javelin.resource.impl;

import com.paohaijiao.javelin.resource.JThornRuleReader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class JThornRuleReSourceFileReader implements JThornRuleReader {
    private String filePath;

    public JThornRuleReSourceFileReader(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public String getRule() {
        // 实现文件读取逻辑
        try {
            return readFileFromClasspath(filePath);
        } catch (IOException e) {
            throw new RuntimeException("Failed to read file: " + filePath, e);
        }
    }
    public static String readFileFromClasspath(String filePath) throws IOException {
        try (InputStream inputStream = JThornRuleReSourceFileReader.class.getClassLoader().getResourceAsStream(filePath);
             BufferedReader reader = new BufferedReader(
                     new InputStreamReader(inputStream, StandardCharsets.UTF_8))) {

            StringBuilder content = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
            return content.toString();
        }
    }
}
