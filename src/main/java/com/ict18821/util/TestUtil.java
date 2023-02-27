package com.ict18821.util;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import static com.ict18821.base.TestBase.driver;

public class TestUtil {
    public static long PAGE_LOAD_TIMEOUT = 20;
    public static long IMPLICIT_WAIT = 10;
    public static String TESTDATA_EXCELSHEET_PATH = "G:\\EDUCATION\\8th semester\\ITS4202 Emerging Technologies\\Assignment\\ICT18821_MavenTestNG\\src\\main\\java\\com\\ict18821\\data\\TestDataSet.xlsx";
    static Workbook workbook;
    static Sheet sheet;


    public static Object[][] getTestData(String sheetName) {
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(TESTDATA_EXCELSHEET_PATH);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            workbook = WorkbookFactory.create(fis);
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        sheet = workbook.getSheet(sheetName);
        Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
        for (int i = 0; i < sheet.getLastRowNum(); i++) {
            for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
                data[i][k] = sheet.getRow(i + 1).getCell(k).toString();

            }
        }
        return data;
    }

    public static void takeScreenshotAtEndOfTest() throws IOException {
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String currentDir = System.getProperty("user.dir");
        File destFile = new File(currentDir + "\\screenshot\\" + System.currentTimeMillis() + ".png");
        FileHandler.copy(scrFile, destFile);
    }
}


