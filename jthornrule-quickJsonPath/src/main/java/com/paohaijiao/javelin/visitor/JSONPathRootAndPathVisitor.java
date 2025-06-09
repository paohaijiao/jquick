package com.paohaijiao.javelin.visitor;

import com.paohaijiao.javelin.bean.JSONPathResult;
import com.paohaijiao.javelin.obj.JSONObject;
import com.paohaijiao.javelin.parser.JQuickJSONPathParser;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class JSONPathRootAndPathVisitor extends JSONPathCoreVisitor {



    @Override
    public JSONPathResult visitPath(JQuickJSONPathParser.PathContext ctx) {
        if (null != ctx.root()) {
            this.currentJsonObject = visitRoot(ctx.root());
        }
        for (JQuickJSONPathParser.SegmentContext segment : ctx.segment()) {
            visitSegment(segment);
        }
        Object obj = this.currentJsonObject;
        JSONPathResult jsonPathResult = new JSONPathResult(obj);
        return jsonPathResult;
    }

    @Override
    public Object visitRoot(JQuickJSONPathParser.RootContext ctx) {
        if (ctx.getText().equals("$")) {
            return this.rootJsonObject;
        } else {
            return currentJsonObject;
        }
    }

    /**
     * parse JSONPath express path Segment
     *
     * @param ctx the parse tree
     * @return
     */
    @Override
    public Void visitSegment(JQuickJSONPathParser.SegmentContext ctx) {
        // process .
        if (ctx.getChild(0).getText().equals(".")) {
            if (ctx.getChildCount() == 2) {
                if (ctx.identifier() != null) {
                    this.currentJsonObject = visitDotField(ctx.identifier(), this.currentJsonObject);
                } else if (ctx.getChild(1).getText().equals("*")) {
                    this.currentJsonObject = visitDotWildcard(this.currentJsonObject);
                }
            }
        } else if (ctx.getChild(0).getText().equals("[")) {
            this.currentJsonObject = visitBracketNotation(ctx.subscript(), this.currentJsonObject);
        } else if (ctx.getChild(0).getText().equals("..")) {//recurse  ('..' identifier or '..' '[' subscript ']')
            if (ctx.identifier() != null) {
                this.currentJsonObject = visitRecursiveField(ctx.identifier(), this.currentJsonObject);
            } else if (ctx.subscript() != null) {
                this.currentJsonObject = visitRecursiveBracketNotation(ctx.subscript(), this.currentJsonObject);
            }
        }
        return null;
    }

}
