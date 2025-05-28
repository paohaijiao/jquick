package org.paohaijiao.jstark;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.paohaijiao.jstark.parser.JSONLexer;
import org.paohaijiao.jstark.parser.JSONParser;
import org.paohaijiao.jstark.visitor.JSONCommonVisitor;

public class Main {
    public static void main(String[] args) {
        String rule="";
        JSONLexer lexer = new JSONLexer(CharStreams.fromString(rule));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        JSONParser parser = new JSONParser(tokens);
        JSONParser.JsonContext tree = parser.json();
        JSONCommonVisitor tv = new JSONCommonVisitor();
        tv.visit(tree);
    }
}
