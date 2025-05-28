package org.paohaijiao.jstark;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.paohaijiao.jstark.obj.JSONObject;
import org.paohaijiao.jstark.parser.JSONLexer;
import org.paohaijiao.jstark.parser.JSONParser;
import org.paohaijiao.jstark.visitor.JSONCommonVisitor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        String rule=new Main().readFileFromClasspath("rule.txt");
        JSONLexer lexer = new JSONLexer(CharStreams.fromString(rule));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        JSONParser parser = new JSONParser(tokens);
        JSONParser.JsonContext tree = parser.json();
        JSONCommonVisitor tv = new JSONCommonVisitor();
        tv.visit(tree);
    }
    public  String readFileFromClasspath(String fileName) {
        StringBuilder result = new StringBuilder();
        try (InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(fileName);
             BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {

            String line;
            while ((line = reader.readLine()) != null) {
                result.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result.toString();
    }
}
