package com.paohaijiao.javelin.resource.impl;

import com.paohaijiao.javelin.resource.JQuickReader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JQuickFileReader implements JQuickReader {
    private String filePath;

    public JQuickFileReader(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public String getRule() {
        // 实现文件读取逻辑
        try {
            return new String(Files.readAllBytes(Paths.get(filePath)));
        } catch (IOException e) {
            throw new RuntimeException("Failed to read file: " + filePath, e);
        }
    }
}
