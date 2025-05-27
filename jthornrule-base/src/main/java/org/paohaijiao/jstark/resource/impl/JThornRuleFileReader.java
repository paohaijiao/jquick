package org.paohaijiao.jstark.resource.impl;

import org.paohaijiao.jstark.resource.JThornRuleReader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JThornRuleFileReader implements JThornRuleReader {
    private String filePath;

    public JThornRuleFileReader(String filePath) {
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
