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

import com.paohaijiao.javelin.param.ContextParams;
import com.paohaijiao.javelin.parser.JQuickLangLexer;
import com.paohaijiao.javelin.parser.JQuickLangParser;
import com.paohaijiao.javelin.visitor.JQuickLangCommonVisitor;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.junit.Test;

import java.io.IOException;

/**
 * packageName PACKAGE_NAME
 *
 * @author Martin
 * @version 1.0.0
 * @className Junit
 * @date 2025/6/16
 * @description
 */
public class JValueTest {
    @Test
    public void testValue01() throws IOException {
        JQuickLangLexer lexer = new JQuickLangLexer(CharStreams.fromString("${type}"));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        JQuickLangParser parser = new JQuickLangParser(tokens);
        JQuickLangParser.VariablesContext tree = parser.variables();
        ContextParams params = new ContextParams();
        params.put("type", "string");
        JQuickLangCommonVisitor tv = new JQuickLangCommonVisitor(params);
        Object object= tv.visit(tree);
        System.out.println(object);
    }
    @Test
    public void testValue02() throws IOException {
        JQuickLangLexer lexer = new JQuickLangLexer(CharStreams.fromString("2025-06-07 12:00:01"));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        JQuickLangParser parser = new JQuickLangParser(tokens);
        JQuickLangParser.DateContext tree = parser.date();
        ContextParams params = new ContextParams();
        JQuickLangCommonVisitor tv = new JQuickLangCommonVisitor(params);
        Object object= tv.visit(tree);
        System.out.println(object);
    }

}
