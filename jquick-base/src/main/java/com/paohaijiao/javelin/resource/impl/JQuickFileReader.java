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
