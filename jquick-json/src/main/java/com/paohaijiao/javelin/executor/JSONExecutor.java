package com.paohaijiao.javelin.executor;

import com.paohaijiao.javelin.antlr.impl.JAbstractAntlrExecutor;
import com.paohaijiao.javelin.exception.JAntlrExecutionException;
import com.paohaijiao.javelin.obj.JsonResponse;
import com.paohaijiao.javelin.parser.JSONLexer;
import com.paohaijiao.javelin.parser.JSONParser;
import com.paohaijiao.javelin.visitor.JSONCommonVisitor;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.TokenStream;

public class JSONExecutor extends JAbstractAntlrExecutor<String, JsonResponse> {
    @Override
    protected Lexer createLexer(CharStream input) {
        return new JSONLexer(input);
    }

    @Override
    protected Parser createParser(TokenStream tokens) {
        return new JSONParser(tokens);
    }

    @Override
    protected JsonResponse parse(Parser parser) throws JAntlrExecutionException {
        JSONParser calcParser = (JSONParser) parser;
        JSONParser.JsonContext tree = calcParser.json();
        JSONCommonVisitor visitor = new JSONCommonVisitor();
        return visitor.visitJson(tree);
    }
}
