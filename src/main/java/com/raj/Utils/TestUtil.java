package com.raj.Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.aspectj.util.FileUtil;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.raj.Base.TestBase;

public class TestUtil extends TestBase {
	
	public static Long PAGE_LOAD_TIMEOUT = 20L;
	public static Long IMPLICIT_WAIT_TIMEOUT = 10L;

	static Workbook book;
	static Sheet sheet;
	
	
	public void switchToFrame(String f) {
		driver.switchTo().frame(f);
	}
	
	public static Object[][] getTestData(String sheetName) {
		FileInputStream file = null;
		try {
			file = new FileInputStream("/Users/rajeshm/eclipse-workspace/SamplePOM/src/main/java/com/raj/Data/POMData.xlsx");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			book = WorkbookFactory.create(file);
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		sheet = book.getSheet(sheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		// System.out.println(sheet.getLastRowNum() + "--------" +
		// sheet.getRow(0).getLastCellNum());
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
				data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
				// System.out.println(data[i][k]);
			}
		}
		return data;
}
	
	public static String screenshot(String name) throws IOException {
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File snapshot = new File(System.getProperty("user.dir")+"/screenshot/"+System.currentTimeMillis()+".png");
		
		FileUtil.copyFile(src, snapshot);
		
		return snapshot.getAbsolutePath();
	}
}