package com.paohaijiao.javelin.executor;

import org.antlr.v4.runtime.*;
import org.paohaijiao.jstark.antlr.impl.AbstractAntlrExecutor;
import org.paohaijiao.jstark.exception.AntlrExecutionException;
import com.paohaijiao.javelin.parser.JThornRuleQuickLangLexer;
import com.paohaijiao.javelin.parser.JThornRuleQuickLangParser;
import com.paohaijiao.javelin.visitor.JThornRuleQuickLangCommonVisitor;

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
