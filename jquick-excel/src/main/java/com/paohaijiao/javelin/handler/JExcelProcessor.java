package com.paohaijiao.javelin.handler;

import com.paohaijiao.javelin.model.JExcelExportModel;
import com.paohaijiao.javelin.model.JExcelImportModel;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;
public class JExcelProcessor {
     private Workbook workbook;
     private Sheet currentSheet;
     private DataFormatter dataFormatter = new DataFormatter();

    public List<Map<String, String>> importData(JExcelImportModel config) throws IOException {
        try (FileInputStream fis = new FileInputStream(config.getFileName())) {
            workbook = new XSSFWorkbook(fis);
            setSheet(config.getSheet());
            String range = config.getRange();
            int[] rangeBounds = parseRange(range);
            boolean hasHeader =config.getHeader();
            List<String> headers = new ArrayList<>();
            Map<String, String> mappings = config.getMappings();
            List<Map<String, String>> data = new ArrayList<>();
            int startRow = rangeBounds != null ? rangeBounds[0] : (hasHeader ? 1 : 0);
            int endRow = rangeBounds != null ? rangeBounds[1] : currentSheet.getLastRowNum();
            int startCol = rangeBounds != null ? rangeBounds[2] : 0;
            int endCol = rangeBounds != null ? rangeBounds[3] : getMaxColumnCount();
            if (hasHeader) {
                Row headerRow = currentSheet.getRow(rangeBounds != null ? rangeBounds[0] : 0);
                for (int i = startCol; i <= endCol; i++) {
                    Cell cell = headerRow.getCell(i, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                    String headerName = dataFormatter.formatCellValue(cell);
                    headers.add(mappings.getOrDefault(headerName, headerName));
                }
            } else {
                for (int i = startCol; i <= endCol; i++) {
                    headers.add("column_" + (i + 1));
                }
            }
            for (int rowNum = startRow; rowNum <= endRow; rowNum++) {
                Row row = currentSheet.getRow(rowNum);
                if (row == null) continue;
                Map<String, String> rowData = new LinkedHashMap<>();
                for (int colNum = startCol; colNum <= endCol; colNum++) {
                    if (colNum >= headers.size()) break;
                    Cell cell = row.getCell(colNum, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                    String value = dataFormatter.formatCellValue(cell);
                    Map<String, String> transforms = config.getTransforms();
                    String fieldName = headers.get(colNum);
                    if (transforms.containsKey(fieldName)) {
                        value = applyTransform(value, transforms.get(fieldName));
                    }
                    rowData.put(headers.get(colNum), value);
                }
                data.add(rowData);
            }
            return data;
        }
    }
    public void exportData(List<Map<String, String>> data, String filePath,
                           JExcelExportModel config) throws IOException {
        workbook = new XSSFWorkbook();
        Object sheet = config.getSheet();
        if (sheet instanceof String) {
            currentSheet = workbook.createSheet((String)sheet);
        }else{
            currentSheet = workbook.createSheet();
        }

        boolean hasHeader = config.getHeader();
        int rowNum = 0;
        if (hasHeader && !data.isEmpty()) {
            Row headerRow = currentSheet.createRow(rowNum++);
            int colNum = 0;
            for (String header : data.get(0).keySet()) {
                Cell cell = headerRow.createCell(colNum++);
                cell.setCellValue(header);
                CellStyle headerStyle = workbook.createCellStyle();
                Font headerFont = workbook.createFont();
                headerFont.setBold(true);
                headerStyle.setFont(headerFont);
                cell.setCellStyle(headerStyle);
            }
        }
        for (Map<String, String> rowData : data) {
            Row row = currentSheet.createRow(rowNum++);
            int colNum = 0;
            for (Map.Entry<String, String> entry : rowData.entrySet()) {
                Cell cell = row.createCell(colNum++);
                @SuppressWarnings("unchecked")
                Map<String, String> formats = config.getFormat();
                if (formats.containsKey(entry.getKey())) {
                    applyCellFormat(cell, formats.get(entry.getKey()));
                }

                setCellValue(cell, entry.getValue());
            }
        }

        // 应用公式
        @SuppressWarnings("unchecked")
        Map<String, String> formulas =config.getFormulas();
        if (!formulas.isEmpty() && rowNum > 0) {
            Row lastRow = currentSheet.getRow(rowNum - 1);
            for (Map.Entry<String, String> entry : formulas.entrySet()) {
                int colIndex = new ArrayList<>(data.get(0).keySet()).indexOf(entry.getKey());
                if (colIndex >= 0) {
                    lastRow.getCell(colIndex).setCellFormula(entry.getValue());
                }
            }
        }
        autoSizeColumns(data.get(0).keySet().size());
        try (FileOutputStream fos = new FileOutputStream(filePath)) {
            workbook.write(fos);
        }
    }

    private void setCellValue(Cell cell, String value) {
        try {
            if (value.contains(".")) {
                cell.setCellValue(Double.parseDouble(value));
            } else {
                cell.setCellValue(Integer.parseInt(value));
            }
            return;
        } catch (NumberFormatException e) {
        }

        // 尝试解析为布尔值
        if ("true".equalsIgnoreCase(value) || "false".equalsIgnoreCase(value)) {
            cell.setCellValue(Boolean.parseBoolean(value));
            return;
        }

        // 默认作为字符串处理
        cell.setCellValue(value);
    }

    private void autoSizeColumns(int columnCount) {
        for (int i = 0; i < columnCount; i++) {
            currentSheet.autoSizeColumn(i);
        }
    }
    private void setSheet(Object sheetConfig) {
        if (sheetConfig == null) {
            currentSheet = workbook.getSheetAt(0);
        } else if (sheetConfig instanceof Integer) {
            currentSheet = workbook.getSheetAt((Integer) sheetConfig - 1);
        } else if (sheetConfig instanceof String) {
            currentSheet = workbook.getSheet((String) sheetConfig);
            if (currentSheet == null) {
                currentSheet = workbook.createSheet((String) sheetConfig);
            }
        }
    }

    private int[] parseRange(String range) {
        if (range == null || range.isEmpty()) return null;

        try {
            String[] parts = range.split(":");
            String start = parts[0];
            String end = parts.length > 1 ? parts[1] : start;
            int[] startCoords = parseCellReference(start);
            int[] endCoords = parseCellReference(end);
            return new int[]{
                    startCoords[0], endCoords[0], // 行范围
                    startCoords[1], endCoords[1]  // 列范围
            };
        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid range format: " + range);
        }
    }

    private int[] parseCellReference(String ref) {
        String colPart = ref.replaceAll("[0-9]", "");
        String rowPart = ref.replaceAll("[^0-9]", "");
        int col = 0;
        for (int i = 0; i < colPart.length(); i++) {
            col = col * 26 + (colPart.charAt(i) - 'A' + 1);
        }
        int row = Integer.parseInt(rowPart) - 1; // 转换为0-based
        return new int[]{row, col - 1};
    }

    // 辅助方法：获取最大列数
    private int getMaxColumnCount() {
        int maxCols = 0;
        for (Row row : currentSheet) {
            if (row.getLastCellNum() > maxCols) {
                maxCols = row.getLastCellNum();
            }
        }
        return maxCols;
    }

    private String applyTransform(String value, String transform) {
        if (transform.contains("trim")) {
            return value.trim();
        }
        // 其他转换规则...
        return value;
    }
    private void applyCellFormat(Cell cell, String formatSpec) {
        CellStyle style = workbook.createCellStyle();
        if (formatSpec.startsWith("DATE")) {
            style.setDataFormat(workbook.createDataFormat().getFormat("yyyy-mm-dd"));
        } else if (formatSpec.startsWith("NUMBER")) {
            style.setDataFormat(workbook.createDataFormat().getFormat("#,##0.00"));
        } else if (formatSpec.startsWith("STRING")) {
            style.setDataFormat(workbook.createDataFormat().getFormat("@"));
        }
        cell.setCellStyle(style);
    }
}
