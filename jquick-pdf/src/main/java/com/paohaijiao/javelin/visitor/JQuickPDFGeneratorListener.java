//package com.paohaijiao.javelin.visitor;
////import com.itextpdf.layout.element.Element;
//import com.paohaijiao.javelin.parser.JQuickPDFBaseListener;
//import com.paohaijiao.javelin.parser.JQuickPDFBaseVisitor;
//import com.paohaijiao.javelin.parser.JQuickPDFParser;
//import org.antlr.v4.runtime.tree.ParseTreeProperty;
//import org.antlr.v4.runtime.tree.ParseTreeWalker;
//import org.antlr.v4.runtime.ParserRuleContext;
//import com.itextpdf.kernel.pdf.PdfDocument;
//import com.itextpdf.kernel.pdf.PdfWriter;
//import com.itextpdf.kernel.pdf.PdfPage;
//import com.itextpdf.kernel.geom.PageSize;
//import com.itextpdf.kernel.colors.Color;
//import com.itextpdf.kernel.colors.DeviceRgb;
//import com.itextpdf.kernel.font.PdfFont;
//import com.itextpdf.kernel.font.PdfFontFactory;
//import com.itextpdf.layout.Document;
//import com.itextpdf.layout.element.*;
//import com.itextpdf.layout.properties.*;
//import com.itextpdf.layout.borders.Border;
//import com.itextpdf.layout.borders.SolidBorder;
//import com.itextpdf.io.image.ImageData;
//import com.itextpdf.io.image.ImageDataFactory;
//import com.itextpdf.svg.converter.SvgConverter;
//import java.io.IOException;
//import java.io.OutputStream;
//import java.util.Stack;
//import java.util.HashMap;
//import java.util.Map;
//
//public class JQuickPDFGeneratorListener extends JQuickPDFBaseListener {
//    private Document document;
//    private PdfWriter writer;
//    private Stack<Element> elementStack = new Stack<>();
//    private ParseTreeProperty<Object> values = new ParseTreeProperty<>();
//    private Map<String, Template> templates = new HashMap<>();
//
//    private PdfFont defaultFont;
//    private Color currentColor;
//
//    public JQuickPDFGeneratorListener(OutputStream outputStream) throws IOException {
//        this.writer = new PdfWriter(outputStream);
//        this.document = new Document(new PdfDocument(writer));
//        this.defaultFont = PdfFontFactory.createFont();
//        this.currentColor = DeviceRgb.BLACK;
//    }
//
//    @Override
//    public void enterDocument(JQuickPDFParser.DocumentContext ctx) {
//        System.out.println("Creating PDF document");
//    }
//
//    @Override
//    public void exitDocument(JQuickPDFParser.DocumentContext ctx) {
//        document.close();
//        System.out.println("PDF document created successfully");
//    }
//
//    @Override
//    public void enterPage(JQuickPDFParser.PageContext ctx) {
//        PageSize pageSize = getPageSize(ctx);
//        document.setPageSize(pageSize);
//        document.newPage();
//
//        if (ctx.margins() != null) {
//            applyMargins(ctx.margins());
//        }
//    }
//
//    private PageSize getPageSize(JQuickPDFParser.PageContext ctx) {
//        if (ctx.A4() != null) {
//            return PageSize.A4;
//        } else if (ctx.LETTER() != null) {
//            return PageSize.LETTER;
//        } else if (ctx.CUSTOM() != null) {
//            float width = Float.parseFloat(ctx.NUMBER(0).getText());
//            String widthUnit = ctx.UNIT(0).getText();
//            float height = Float.parseFloat(ctx.NUMBER(1).getText());
//            String heightUnit = ctx.UNIT(1).getText();
//
//            float widthPt = convertToPoints(width, widthUnit);
//            float heightPt = convertToPoints(height, heightUnit);
//
//            return new PageSize(widthPt, heightPt);
//        }
//        return PageSize.A4;
//    }
//
//    private void applyMargins(JQuickPDFParser.MarginsContext ctx) {
//        float left = convertToPoints(ctx.NUMBER(0).getText(), ctx.UNIT(0).getText());
//        float right = convertToPoints(ctx.NUMBER(1).getText(), ctx.UNIT(1).getText());
//        float top = convertToPoints(ctx.NUMBER(2).getText(), ctx.UNIT(2).getText());
//        float bottom = convertToPoints(ctx.NUMBER(3).getText(), ctx.UNIT(3).getText());
//        document.setMargins(top, right, bottom, left);
//    }
//
//    @Override
//    public void enterParagraph(JQuickPDFParser.ParagraphContext ctx) {
//        String text = ctx.STRING().getText().replaceAll("^\"|\"$", "");
//        Paragraph paragraph = new Paragraph(text)
//                .setFont(defaultFont)
//                .setFontColor(currentColor);
//
//        if (ctx.paragraph_style() != null) {
//            applyParagraphStyle(paragraph, ctx.paragraph_style());
//        }
//
//        addToDocument(paragraph);
//    }
//
//    private void applyParagraphStyle(Paragraph paragraph, JQuickPDFParser.Paragraph_styleContext ctx) {
//        for (JQuickPDFParser.Text_styleContext styleCtx : ctx.text_style()) {
//            if (styleCtx.font() != null) {
//                try {
//                    PdfFont font = PdfFontFactory.createFont(styleCtx.ID().getText());
//                    paragraph.setFont(font);
//                } catch (IOException e) {
//                    System.err.println("Error loading font: " + e.getMessage());
//                }
//            } else if (styleCtx.size() != null) {
//                float size = Float.parseFloat(styleCtx.NUMBER().getText());
//                paragraph.setFontSize(size);
//            } else if (styleCtx.color() != null) {
//                Color color = parseColor(styleCtx.color().COLOR().getText());
//                paragraph.setFontColor(color);
//            }
//        }
//
//        for (JQuickPDFParser.AlignmentContext alignCtx : ctx.alignment()) {
//            TextAlignment alignment = TextAlignment.valueOf(alignCtx.getText().toUpperCase());
//            paragraph.setTextAlignment(alignment);
//        }
//    }
//
//    @Override
//    public void enterHeading(JQuickPDFParser.HeadingContext ctx) {
//        String text = ctx.STRING().getText().replaceAll("^\"|\"$", "");
//        Paragraph heading = new Paragraph(text);
//
//        // Apply default heading styles
//        switch (ctx.getChild(1).getText()) {
//            case "h1": heading.setFontSize(24).setBold(); break;
//            case "h2": heading.setFontSize(20).setBold(); break;
//            case "h3": heading.setFontSize(16).setBold(); break;
//            case "h4": heading.setFontSize(14).setBold(); break;
//            case "h5": heading.setFontSize(12).setBold(); break;
//            case "h6": heading.setFontSize(10).setBold(); break;
//        }
//
//        if (ctx.text_style() != null) {
//            applyTextStyle(heading, ctx.text_style());
//        }
//
//        addToDocument(heading);
//    }
//
//    @Override
//    public void enterImage(JQuickPDFParser.ImageContext ctx) {
//        String imagePath = ctx.PATH().getText();
//        try {
//            ImageData imageData = ImageDataFactory.create(imagePath);
//            Image image = new Image(imageData);
//
//            if (ctx.image_style() != null) {
//                applyImageStyle(image, ctx.image_style());
//            }
//
//            addToDocument(image);
//        } catch (IOException e) {
//            System.err.println("Error loading image: " + e.getMessage());
//        }
//    }
//
//    private void applyImageStyle(Image image, JQuickPDFParser.Image_styleContext ctx) {
//        for (JQuickPDFParser.DimensionContext dimCtx : ctx.dimension()) {
//            if (dimCtx.width() != null) {
//                float width = Float.parseFloat(dimCtx.NUMBER(0).getText());
//                String unit = dimCtx.UNIT(0).getText();
//                image.setWidth(convertToPoints(width, unit));
//            } else if (dimCtx.height() != null) {
//                float height = Float.parseFloat(dimCtx.NUMBER(0).getText());
//                String unit = dimCtx.UNIT(0).getText();
//                image.setHeight(convertToPoints(height, unit));
//            }
//        }
//    }
//
//    @Override
//    public void enterSvg(JQuickPDFParser.SvgContext ctx) {
//        String svgPath = ctx.PATH().getText();
//        try {
//            SvgConverter.drawOnPdf(new java.io.FileInputStream(svgPath),
//                    writer,
//                    new com.itextpdf.svg.processors.impl.SvgConverterProperties());
//        } catch (IOException e) {
//            System.err.println("Error loading SVG: " + e.getMessage());
//        }
//    }
//
//    @Override
//    public void enterTemplate(JQuickPDFParser.TemplateContext ctx) {
//        String templateName = ctx.ID().getText();
//        Template template = new Template();
//        templates.put(templateName, template);
//        // Store template content for later use
//    }
//
//    @Override
//    public void exitTemplate(JQuickPDFParser.TemplateContext ctx) {
//        // Template processing complete
//    }
//
//    private void addToDocument(Element element) {
//        if (!elementStack.isEmpty()) {
//            Element parent = elementStack.peek();
//            if (parent instanceof Div) {
//                ((Div) parent).add(element);
//            } else if (parent instanceof Cell) {
//                ((Cell) parent).add(element);
//            }
//        } else {
//            document.add(element);
//        }
//    }
//
//    private float convertToPoints(float value, String unit) {
//        switch (unit) {
//            case "pt": return value;
//            case "mm": return value * 2.83465f;
//            case "cm": return value * 28.3465f;
//            case "in": return value * 72f;
//            case "px": return value * 0.75f; // Assuming 96dpi
//            default: return value;
//        }
//    }
//
//    private Color parseColor(String colorStr) {
//        if (colorStr.startsWith("#")) {
//            return hexToColor(colorStr);
//        } else if (colorStr.startsWith("rgb(")) {
//            return rgbToColor(colorStr);
//        } else {
//            return namedColorToColor(colorStr);
//        }
//    }
//
//    private Color hexToColor(String hex) {
//        return DeviceRgb.BLACK;
//    }
//
//    private Color rgbToColor(String rgb) {
//        return DeviceRgb.BLACK;
//    }
//
//    private Color namedColorToColor(String name) {
//        return DeviceRgb.BLACK;
//    }
//
//    private static class Template {
//    }
//}
