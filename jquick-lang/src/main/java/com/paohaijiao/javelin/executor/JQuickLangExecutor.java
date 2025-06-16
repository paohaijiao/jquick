package com.paohaijiao.javelin.executor;

import com.paohaijiao.javelin.antlr.impl.AbstractAntlrExecutor;
import com.paohaijiao.javelin.exception.AntlrExecutionException;
import com.paohaijiao.javelin.parser.JQuickLangLexer;
import com.paohaijiao.javelin.parser.JQuickLangParser;
import com.paohaijiao.javelin.visitor.JQuickLangCommonVisitor;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.TokenStream;

public class JQuickLangExecutor extends AbstractAntlrExecutor<String, Object> {
    @Override
    protected Lexer createLexer(CharStream input) {
        return new JQuickLangLexer(input);
    }

    @Override
    protected Parser createParser(TokenStream tokens) {
        return new JQuickLangParser(tokens);
    }

    @Override
    protected Object parse(Parser parser) throws AntlrExecutionException {
        JQuickLangParser calcParser = (JQuickLangParser) parser;
        JQuickLangParser.StatementContext tree = calcParser.statement();
        JQuickLangCommonVisitor visitor = new JQuickLangCommonVisitor();
        return visitor.visit(tree);
    }
}
