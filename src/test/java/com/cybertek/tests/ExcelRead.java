package com.cybertek.tests;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

public class ExcelRead {

    @Test
    public void excel_read_test() throws IOException {
        String path = "SampleData.xlsx";
        // load the file in order to read from excel
        FileInputStream fileInputStream = new FileInputStream(path);

        // workbook > sheet > row > cell
        XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);

        // create the sheet and pass the name of the sheet
        XSSFSheet sheet = workbook.getSheet("Employees");

        // ROW --> SHEET
        //System.out.println(sheet.getRow(3).getCell(2));

        int usedRows = sheet.getPhysicalNumberOfRows();
        //System.out.println(usedRows);

        int lastRowNum = sheet.getLastRowNum();

        // TODO: 1 - CREATE A LOGIC TO PRINT OUT NEENA'S NAME DYNAMICALLY

        for (int rowNum = 0; rowNum < usedRows; rowNum++) {
            if (sheet.getRow(rowNum).getCell(0).toString().equals("Neena")) {
                System.out.println("CurrentCell = " + sheet.getRow(rowNum).getCell(0));
            }
        }

        // TODO: 2 - CREATE A LOGIC TO PRINT OUT LAST NAME DYNAMICALLY

        for (int rowNum = 0; rowNum < usedRows; rowNum++) {
            if (sheet.getRow(rowNum).getCell(0).toString().equals("Adam"))
                System.out.println("Adam's last name is " + sheet.getRow(rowNum).getCell(1));
        }

        for (int rowNum = 0; rowNum < usedRows; rowNum++) {

            for (int cellNum = 0; cellNum < 3; cellNum++) {
                String currentCell = sheet.getRow(rowNum).getCell(cellNum).toString();
                System.out.printf("%-20s", sheet.getRow(rowNum).getCell(cellNum) + " ");
                if (currentCell.equals("null")) {
                    break;
                }
            }
            System.out.println();
        }

        Map<String, String> employees = new LinkedHashMap<>();
        for (int i = 0; i < usedRows; i++) {
            employees.put(sheet.getRow(i).getCell(0).toString() +" "+ sheet.getRow(i).getCell(1).toString(), sheet.getRow(i).getCell(2).toString());
        }
        System.out.println(employees);



    }
}
