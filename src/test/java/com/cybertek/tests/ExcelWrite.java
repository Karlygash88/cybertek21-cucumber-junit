package com.cybertek.tests;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelWrite {

    XSSFWorkbook workbook;
    XSSFSheet sheet;
    XSSFRow row;
    XSSFCell cell;

    @Test
    public void excel_write() throws IOException {

        String path = "SampleData.xlsx";

        // load the file in order to read from excel
        FileInputStream fileInputStream = new FileInputStream(path);

        // workbook > sheet > row > cell
        workbook = new XSSFWorkbook(fileInputStream);

        // create the sheet and pass the name of the sheet
        sheet = workbook.getSheet("Employees");

        row = sheet.getRow(1);

        cell = row.getCell(1);

        // ex: Storing Adam's cell if we were reusing it

        XSSFCell adamsCell = sheet.getRow(2).getCell(0);
        System.out.println("adamsCell = " + adamsCell);

        adamsCell.setCellValue("Madam");
        System.out.println("After = "+adamsCell);

        // =============================================================

        /*
        TODO: CHANGE STEVEN'S NAME

        STATIC WAY OF SOLUTION


         */

//        XSSFCell stevenCell = sheet.getRow(1).getCell(0);
//        stevenCell.setCellValue("Tom");
//
//        System.out.println(stevenCell);
        /*
        Dynamic way of solution
         */
        for (int rowNum = 0; rowNum < sheet.getPhysicalNumberOfRows(); rowNum++){
            if (sheet.getRow(rowNum).getCell(0).toString().equals("Steven")){
                sheet.getRow(rowNum).getCell(0).setCellValue("Tommy");
            }
        }

        // =============================================================




        FileOutputStream fileOutputStream = new FileOutputStream(path);
        workbook.write(fileOutputStream);
        fileInputStream.close();
        fileOutputStream.close();
        workbook.close();





    }
}
