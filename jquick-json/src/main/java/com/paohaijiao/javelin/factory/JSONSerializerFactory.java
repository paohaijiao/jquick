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
package com.paohaijiao.javelin.factory;

import com.paohaijiao.javelin.param.JContext;
import com.paohaijiao.javelin.serializer.JDefaultJSONSerializer;
import com.paohaijiao.javelin.serializer.JSONSerializer;
import com.paohaijiao.javelin.serializerQ.JQuickJSONSerializer;

/**
 * packageName com.paohaijiao.javelin.factory
 *
 * @author Martin
 * @version 1.0.0
 * @className JSONSerializerFactory
 * @date 2025/6/20
 * @description
 */
public class JSONSerializerFactory {

    private static final JSONSerializer DEFAULT_SERIALIZER = new JDefaultJSONSerializer();

    public static JSONSerializer getDefaultSerializer() {
        return DEFAULT_SERIALIZER;
    }

    public static JSONSerializer createSerializer() {
        return new JDefaultJSONSerializer();
    }
    public static JSONSerializer createJQuickSerializer(JContext context) {
        return new JQuickJSONSerializer(context);
    }
}
