package com.paohaijiao.javelin.executor;

import com.paohaijiao.javelin.antlr.impl.AbstractAntlrExecutor;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.TokenStream;
import com.paohaijiao.javelin.parser.JThornRuleQuickXMLLexer;
import com.paohaijiao.javelin.parser.JThornRuleQuickXMLParser;
import com.paohaijiao.javelin.visitor.JThornRuleQuickRestCommonVisitor;

public class JThornRuleQuickRestExecutor extends AbstractAntlrExecutor<String, Object> {
    @Override
    protected Lexer createLexer(CharStream input) {
        return new JThornRuleQuickXMLLexer(input);
    }

    @Override
    protected Parser createParser(TokenStream tokens) {
        return new JThornRuleQuickXMLParser(tokens);
    }

    @Override
    protected Object parse(Parser parser) throws AntlrExecutionException {
        JThornRuleQuickXMLParser calcParser = (JThornRuleQuickXMLParser) parser;
        JThornRuleQuickXMLParser.DocumentContext tree = calcParser.document();
        JThornRuleQuickRestCommonVisitor visitor = new JThornRuleQuickRestCommonVisitor();
        return visitor.visit(tree);
    }
}
