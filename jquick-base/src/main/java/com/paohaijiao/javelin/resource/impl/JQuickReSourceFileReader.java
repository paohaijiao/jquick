/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Copyright (c) [2025-2099] Martin (goudingcheng@gmail.com)
 */
package com.paohaijiao.javelin.resource.impl;

import com.paohaijiao.javelin.resource.JQuickReader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class JQuickReSourceFileReader implements JQuickReader {
    private String filePath;

    public JQuickReSourceFileReader(String filePath) {
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
        try (InputStream inputStream = JQuickReSourceFileReader.class.getClassLoader().getResourceAsStream(filePath);
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
