package org.example.excelparser.app.util;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class XlsxReader {
    public static List<Integer> readFile(String path) {
        List<Integer> result = new ArrayList<>();

        try (FileInputStream f = new FileInputStream(path);
             Workbook workbook = new XSSFWorkbook(f)) {
            Sheet sheet = workbook.getSheetAt(0);
            for (Row r: sheet) {
                Cell cell = r.getCell(0);
                if (cell != null && cell.getCellType().equals(CellType.NUMERIC)) {
                    result.add((int) cell.getNumericCellValue());
                }
            }
        } catch (FileNotFoundException e) {
        throw new IllegalArgumentException("File not found: " + path);
        } catch (IOException e) {
            throw new IllegalStateException("I/O error while reading file: " + path);
        }
        return result;
    }
}
