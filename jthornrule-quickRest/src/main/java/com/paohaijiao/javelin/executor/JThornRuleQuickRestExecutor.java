package com.paohaijiao.javelin.executor;

import com.paohaijiao.javelin.antlr.impl.AbstractAntlrExecutor;
import com.paohaijiao.javelin.exception.AntlrExecutionException;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.TokenStream;
import com.paohaijiao.javelin.parser.JThornRuleQuickRestLexer;
import com.paohaijiao.javelin.parser.JThornRuleQuickRestParser;
import com.paohaijiao.javelin.visitor.JThornRuleQuickRestCommonVisitor;

public class JThornRuleQuickRestExecutor extends AbstractAntlrExecutor<String, Object> {
    @Override
    protected Lexer createLexer(CharStream input) {
        return new JThornRuleQuickRestLexer(input);
    }

    @Override
    protected Parser createParser(TokenStream tokens) {
        return new JThornRuleQuickRestParser(tokens);
    }

    @Override
    protected Object parse(Parser parser) throws AntlrExecutionException {
        JThornRuleQuickRestParser calcParser = (JThornRuleQuickRestParser) parser;
        JThornRuleQuickRestParser.CurlCommandContext tree = calcParser.curlCommand();
        JThornRuleQuickRestCommonVisitor visitor = new JThornRuleQuickRestCommonVisitor();
        return visitor.visit(tree);
    }
}
