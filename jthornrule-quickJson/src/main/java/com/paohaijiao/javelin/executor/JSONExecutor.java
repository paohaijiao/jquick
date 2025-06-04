package com.paohaijiao.javelin.executor;

import com.paohaijiao.javelin.antlr.impl.AbstractAntlrExecutor;
import com.paohaijiao.javelin.exception.AntlrExecutionException;
import com.paohaijiao.javelin.obj.JSONObject;
import com.paohaijiao.javelin.parser.JSONLexer;
import com.paohaijiao.javelin.parser.JSONParser;
import com.paohaijiao.javelin.visitor.JSONCommonVisitor;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.TokenStream;

public class JSONExecutor extends AbstractAntlrExecutor<String, JSONObject> {
    @Override
    protected Lexer createLexer(CharStream input) {
        return new JSONLexer(input);
    }

    @Override
    protected Parser createParser(TokenStream tokens) {
        return new JSONParser(tokens);
    }

    @Override
    protected JSONObject parse(Parser parser) throws AntlrExecutionException {
        JSONParser calcParser = (JSONParser) parser;
        JSONParser.JsonContext tree = calcParser.json();
        JSONCommonVisitor visitor = new JSONCommonVisitor();
        return visitor.visitJson(tree);
    }
}
