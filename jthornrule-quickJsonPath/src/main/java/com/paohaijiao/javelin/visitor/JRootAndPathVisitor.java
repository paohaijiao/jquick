package com.paohaijiao.javelin.visitor;

import com.paohaijiao.javelin.bean.JSONPathResult;
import com.paohaijiao.javelin.parser.JQuickJSONPathParser;

public class JRootAndPathVisitor extends JSegmentVisitor {



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


}
