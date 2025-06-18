package com.paohaijiao.javelin.handler;

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

    public void exportData(List<Map<String, String>> data, String filePath, Map<String, Object> config) throws IOException {
        workbook = new XSSFWorkbook();
        String sheetName = (String) config.getOrDefault("sheet", "Sheet1");
        currentSheet = workbook.createSheet(sheetName);
        boolean hasHeader = (boolean) config.getOrDefault("header", true);
        int rowNum = 0;
        if (hasHeader && !data.isEmpty()) {
            Row headerRow = currentSheet.createRow(rowNum++);
            int colNum = 0;
            for (String header : data.get(0).keySet()) {
                headerRow.createCell(colNum++).setCellValue(header);
            }
        }
        for (Map<String, String> rowData : data) {
            Row row = currentSheet.createRow(rowNum++);
            int colNum = 0;
            for (String value : rowData.values()) {
                Cell cell = row.createCell(colNum++);
                Map<String, String> formats = (Map<String, String>) config.getOrDefault("format", new HashMap<>());
                String fieldName = new ArrayList<>(rowData.keySet()).get(colNum - 1);
                if (formats.containsKey(fieldName)) {
                    applyCellFormat(cell, formats.get(fieldName));
                }
                cell.setCellValue(value);
            }
        }
        Map<String, String> formulas = (Map<String, String>) config.getOrDefault("formulas", new HashMap<>());
        if (!formulas.isEmpty() && rowNum > 0) {
            Row lastRow = currentSheet.getRow(rowNum - 1);
            for (Map.Entry<String, String> entry : formulas.entrySet()) {
                int colIndex = new ArrayList<>(data.get(0).keySet()).indexOf(entry.getKey());
                if (colIndex >= 0) {
                    lastRow.getCell(colIndex).setCellFormula(entry.getValue());
                }
            }
        }
        try (FileOutputStream fos = new FileOutputStream(filePath)) {
            workbook.write(fos);
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
        // 这里实现具体的格式设置逻辑
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
