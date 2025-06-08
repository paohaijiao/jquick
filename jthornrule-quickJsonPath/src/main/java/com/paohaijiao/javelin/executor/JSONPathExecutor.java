package com.paohaijiao.javelin.executor;

import com.paohaijiao.javelin.antlr.impl.AbstractAntlrExecutor;
import com.paohaijiao.javelin.exception.AntlrExecutionException;
import com.paohaijiao.javelin.obj.JSONObject;
import com.paohaijiao.javelin.parser.JQuickJSONPathLexer;
import com.paohaijiao.javelin.parser.JQuickJSONPathParser;
import com.paohaijiao.javelin.visitor.JSONPathCommonVisitor;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.TokenStream;

public class JSONPathExecutor extends AbstractAntlrExecutor<String, JSONObject> {
    private JSONObject json=null;
    public JSONPathExecutor(JSONObject json) {
        this.json=json;
    }
    protected Lexer createLexer(CharStream input) {
        return new JQuickJSONPathLexer(input);
    }

    @Override
    protected Parser createParser(TokenStream tokens) {
        return new JQuickJSONPathParser(tokens);
    }

    @Override
    protected JSONObject parse(Parser parser) throws AntlrExecutionException {
        JQuickJSONPathParser calcParser = (JQuickJSONPathParser) parser;
        JQuickJSONPathParser.PathContext tree = calcParser.path();
        JSONPathCommonVisitor visitor = new JSONPathCommonVisitor(json);
        return  visitor.visitPath(tree);
    }
}
