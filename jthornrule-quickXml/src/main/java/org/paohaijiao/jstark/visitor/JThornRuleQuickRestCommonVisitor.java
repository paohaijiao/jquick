package org.paohaijiao.jstark.visitor;

import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.paohaijiao.jstark.obj.JSONArray;
import org.paohaijiao.jstark.obj.JSONObject;
import org.paohaijiao.jstark.parser.JThornRuleQuickXMLLexer;
import org.paohaijiao.jstark.parser.JThornRuleQuickXMLParser;

import java.util.List;
public class JThornRuleQuickRestCommonVisitor extends JThornRuleQuickRestCoreVisitor {

    @Override
    public JSONObject visitDocument(JThornRuleQuickXMLParser.DocumentContext ctx) {
        JSONObject document = new JSONObject();
        if (ctx.prolog() != null) {
            document.put("prolog", visitProlog(ctx.prolog()));
        }
        if (!ctx.misc().isEmpty()) {
            JSONArray preMisc = new JSONArray();
            for (JThornRuleQuickXMLParser.MiscContext misc : ctx.misc()) {
                preMisc.add(visitMisc(misc));
            }
            document.put("preMisc", preMisc);
        }
        if (ctx.element() != null) {
            document.put("root", visitElement(ctx.element()));
        }
        if (ctx.misc().size() > (ctx.prolog() != null ? 1 : 0)) {
            JSONArray postMisc = new JSONArray();
            List<JThornRuleQuickXMLParser.MiscContext> miscList = ctx.misc();
            for (int i = (ctx.prolog() != null ? 1 : 0); i < miscList.size(); i++) {
                postMisc.add(visitMisc(miscList.get(i)));
            }
            document.put("postMisc", postMisc);
        }
        return document;
    }
    @Override
    public JSONObject visitProlog(JThornRuleQuickXMLParser.PrologContext ctx) {
        JSONObject prolog = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        for (JThornRuleQuickXMLParser.AttributeContext attr : ctx.attribute()) {
            jsonArray.add(visitAttribute(attr));
        }
        prolog.put(attributes, jsonArray);
        return prolog;
    }
    @Override
    public JSONObject visitContent(JThornRuleQuickXMLParser.ContentContext ctx) {
        JSONObject content = new JSONObject();
        if (ctx.chardata(0) != null) {
            content.put(chardata,visitChardata(ctx.chardata(0)));
        }
        JSONArray array=new JSONArray();
        for (ParseTree child : ctx.children) {
            JSONObject data = new JSONObject();
            if (child instanceof JThornRuleQuickXMLParser.ChardataContext) {
                String text = ((JThornRuleQuickXMLParser.ChardataContext) child).getText();
                data.put(chardata,text);
            }
            else if (child instanceof JThornRuleQuickXMLParser.ElementContext) {
                JSONObject ele= visitElement((JThornRuleQuickXMLParser.ElementContext) child);
                data.put(element,ele);
            }
            else if (child instanceof JThornRuleQuickXMLParser.ReferenceContext) {
                JSONObject re= visitReference((JThornRuleQuickXMLParser.ReferenceContext) child);
                data.put(reference,re);
            }
            else if (child instanceof TerminalNode) {
                TerminalNode node = (TerminalNode) child;
                switch (node.getSymbol().getType()) {
                    case JThornRuleQuickXMLLexer.CDATA:
                        data.put(cdata,node.getText());
                        break;

                    case JThornRuleQuickXMLLexer.COMMENT:
                        data.put(comment,node.getText());
                        break;

                    case JThornRuleQuickXMLLexer.PI:
                        data.put(pi,node.getText());
                        break;

                    case JThornRuleQuickXMLLexer.SEA_WS:
                        data.put(seaWs,node.getText());
                        break;
                }
            }
            array.add(data);
        }
        content.put(element,array);
        return content;
    }

    @Override
    public JSONObject visitElement(JThornRuleQuickXMLParser.ElementContext ctx) {
        JSONObject element = new JSONObject();
        element.put(name, ctx.Name(0).getText());
        if (!ctx.attribute().isEmpty()) {
            JSONObject attrs = new JSONObject();
            for (JThornRuleQuickXMLParser.AttributeContext attr : ctx.attribute()) {
                JSONObject attribute = visitAttribute(attr);
                attrs.put(attribute.getString(name), attribute.get(string));
            }
            element.put(attributes, attrs);
        }
        if (ctx.content() != null) {
            element.put(content, visitContent(ctx.content()));
        }
        return element;
    }

    @Override
    public JSONObject  visitReference(JThornRuleQuickXMLParser.ReferenceContext ctx) {
        JSONObject json = new JSONObject();
        if (ctx.EntityRef() != null) {
            json.put(entityRef, ctx.EntityRef().getText());
        } else {
            json.put(charRef, ctx.CharRef().getText());
        }
        return json;
    }

    @Override
    public JSONObject visitAttribute(JThornRuleQuickXMLParser.AttributeContext ctx) {
        JSONObject attribute = new JSONObject();
        attribute.put(name, ctx.Name().getText());
        String value = ctx.STRING().getText();
        attribute.put(string, value.substring(1, value.length() - 1));
        return attribute;
    }

    @Override
    public JSONObject  visitChardata(JThornRuleQuickXMLParser.ChardataContext ctx) {
        JSONObject json=new JSONObject();
        if (ctx.TEXT() != null) {
            json.put(text, ctx.TEXT().getText());
        } else {
            json.put(seaWs, ctx.SEA_WS().getText());
        }
        return json;
    }
    @Override
    public JSONObject  visitMisc(JThornRuleQuickXMLParser.MiscContext ctx) {
        JSONObject json=new JSONObject();
        if (ctx.COMMENT() != null) {
             json.put(comment, ctx.COMMENT().getText());
            return json;
        } else if (ctx.PI() != null) {
            json.put(pi, ctx.PI().getText());
            return json;
        } else {
            json.put(seaWs, ctx.SEA_WS().getText());
            return json;
        }
    }


}
