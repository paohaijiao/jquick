package com.paohaijiao.javelin.executor;

import com.paohaijiao.javelin.antlr.impl.AbstractAntlrExecutor;
import com.paohaijiao.javelin.exception.AntlrExecutionException;
import com.paohaijiao.javelin.parser.JThornRuleQuickLangLexer;
import com.paohaijiao.javelin.parser.JThornRuleQuickLangParser;
import com.paohaijiao.javelin.visitor.JThornRuleQuickLangCommonVisitor;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.TokenStream;

public class JThornRuleQuickLangExecutor  extends AbstractAntlrExecutor<String, Object> {
    @Override
    protected Lexer createLexer(CharStream input) {
        return new JThornRuleQuickLangLexer(input);
    }

    @Override
    protected Parser createParser(TokenStream tokens) {
        return new JThornRuleQuickLangParser(tokens);
    }

    @Override
    protected Object parse(Parser parser) throws AntlrExecutionException {
        JThornRuleQuickLangParser calcParser = (JThornRuleQuickLangParser) parser;
        JThornRuleQuickLangParser.RulesContext tree = calcParser.rules();
        JThornRuleQuickLangCommonVisitor visitor = new JThornRuleQuickLangCommonVisitor();
        return visitor.visit(tree);
    }
}
