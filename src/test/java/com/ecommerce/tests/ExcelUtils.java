package com.ecommerce.tests;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;
import java.io.IOException;

public class ExcelUtils {

    public static Object[][] getTestData(String filePath, String sheetName) {
        Object[][] data = null;
        try {
            FileInputStream fis = new FileInputStream(filePath);
            XSSFWorkbook workbook = new XSSFWorkbook(fis);
            XSSFSheet sheet = workbook.getSheet(sheetName);

            int rowCount = sheet.getPhysicalNumberOfRows();
            int colCount = sheet.getRow(0).getLastCellNum();

            data = new Object[rowCount - 1][colCount];

            for (int i = 1; i < rowCount; i++) { 
                for (int j = 0; j < colCount; j++) {
                    data[i - 1][j] = sheet.getRow(i).getCell(j).getStringCellValue();
                }
            }
            workbook.close();
        } catch (IOException e) {
            System.out.println("Error reading Excel file!");
            e.printStackTrace();
        }
        return data;
    }
}