package com.paohaijiao.javelin.executor;

import com.paohaijiao.javelin.antlr.impl.JAbstractAntlrExecutor;
import com.paohaijiao.javelin.bean.JResult;
import com.paohaijiao.javelin.exception.JAntlrExecutionException;
import com.paohaijiao.javelin.parser.JThornRuleQuickRestLexer;
import com.paohaijiao.javelin.parser.JThornRuleQuickRestParser;
import com.paohaijiao.javelin.visitor.JThornRuleQuickRestCommonVisitor;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.TokenStream;

public class JThornRuleQuickRestExecutor extends JAbstractAntlrExecutor<String, JResult> {
    @Override
    protected Lexer createLexer(CharStream input) {
        return new JThornRuleQuickRestLexer(input);
    }

    @Override
    protected Parser createParser(TokenStream tokens) {
        return new JThornRuleQuickRestParser(tokens);
    }

    @Override
    protected JResult parse(Parser parser) throws JAntlrExecutionException {
        JThornRuleQuickRestParser calcParser = (JThornRuleQuickRestParser) parser;
        JThornRuleQuickRestParser.CurlCommandContext tree = calcParser.curlCommand();
        JThornRuleQuickRestCommonVisitor visitor = new JThornRuleQuickRestCommonVisitor();
        return visitor.visitCurlCommand(tree);
    }
}
