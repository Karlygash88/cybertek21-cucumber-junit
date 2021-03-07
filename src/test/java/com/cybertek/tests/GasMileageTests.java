package com.cybertek.tests;

import com.cybertek.pages.GasMileageCalculatorPage;
import com.cybertek.utilities.Driver;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class GasMileageTests {

    XSSFWorkbook workbook;
    XSSFSheet sheet;
    FileInputStream fileInputStream;
    FileOutputStream fileOutputStream;
    GasMileageCalculatorPage gasMileageCalculatorPage = new GasMileageCalculatorPage();


    @Test
    public void gas_mileage_calculation() throws IOException {
        Driver.getDriver().get("https://www.calculator.net/gas-mileage-calculator.html");

        // get the path from Content Root
        String path = "src/test/resources/testData/GasMileageTestData.xlsx";

        // load the file into inputStream object
        fileInputStream = new FileInputStream(path);

        // loading the workbook to the class
        workbook = new XSSFWorkbook(fileInputStream);

        // opening the sheet
        sheet = workbook.getSheet("GasMileage");
        for (int i = 1; i < sheet.getPhysicalNumberOfRows(); i++) {

            XSSFRow row = sheet.getRow(i);

            if (!row.getCell(0).toString().equals("Y")){
                if (row.getCell(6)==null){
                    row.createCell(6);
                }
                row.getCell(6).setCellValue("Skip Requested");
                continue;
            }
            XSSFCell cell = row.getCell(1);

            double current = cell.getNumericCellValue();

            // clearing the input before entering the data
            gasMileageCalculatorPage.inputCurrentOdo.clear();

            gasMileageCalculatorPage.inputCurrentOdo.sendKeys(String.valueOf(current));

            //========================================================================

            double previous = row.getCell(2).getNumericCellValue();

            gasMileageCalculatorPage.inputPreviousOdo.clear();
            gasMileageCalculatorPage.inputPreviousOdo.sendKeys(String.valueOf(previous));

            //=================================================================================
            double gas = row.getCell(3).getNumericCellValue();

            gasMileageCalculatorPage.inputGas.clear();
            gasMileageCalculatorPage.inputGas.sendKeys(String.valueOf(gas));


            // =============================
            // click to calculate button

            gasMileageCalculatorPage.calculateButton.click();

            double expectedResult = (current - previous) / gas;

            //System.out.println("expectedResult = " + expectedResult);

            double actualResult = Double.parseDouble(gasMileageCalculatorPage.resultInGas.getText().split(" ")[0]);

            DecimalFormat decimalFormat = new DecimalFormat("0.00");

            double formattedExpectedResult = Double.parseDouble(decimalFormat.format(expectedResult));

            if (row.getCell(4) == null)
                row.createCell(4);

            row.getCell(4).setCellValue(formattedExpectedResult + "");

            //=====================================================================================

            if (row.getCell(5) == null)
                row.createCell(5);
            row.getCell(5).setCellValue(actualResult + "");

            if (row.getCell(6) == null)
                row.createCell(6);


            if (actualResult == formattedExpectedResult) {
                row.getCell(6).setCellValue("PASS!");
            } else row.getCell(6).setCellValue("FAIL!");

            DateTimeFormatter DTF = DateTimeFormatter.ofPattern("hh:mm:ss a");
            if (row.getCell(7) == null)
                row.createCell(7);
            row.getCell(7).setCellValue(LocalTime.now().format(DTF));
        }

        // Assert.assertEquals(formattedExpectedResult, actualResult, 0.00);

        // We must write into excel using write method

        fileOutputStream = new FileOutputStream(path);
        workbook.write(fileOutputStream);
        fileOutputStream.close();
        fileInputStream.close();
        workbook.close();


    }
}
