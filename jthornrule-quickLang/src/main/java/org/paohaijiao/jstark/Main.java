package org.paohaijiao.jstark;

import org.antlr.runtime.tree.ParseTree;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.paohaijiao.jstark.parser.JThornRuleQuickLangLexer;
import org.paohaijiao.jstark.parser.JThornRuleQuickLangParser;

public class Main {
    public static void main(String[] args) throws Exception {
        String rule="";
        JThornRuleQuickLangLexer lexer = new JThornRuleQuickLangLexer(CharStreams.fromString("3 + 5 * 10"));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        JThornRuleQuickLangParser parser = new JThornRuleQuickLangParser(tokens);
        JThornRuleQuickLangParser.RulesContext tree = parser.rules();
        System.out.println(tree.toStringTree(parser));
    }
}
