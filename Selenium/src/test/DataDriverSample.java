package test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DataDriverSample {

	@Test(enabled=false)
	public void excelFileCreation() throws IOException {
		XSSFWorkbook wb = new XSSFWorkbook();
		XSSFSheet sheet = wb.createSheet("Sheet01");
		FileOutputStream out = new FileOutputStream(new File("src/DDT/File_01.xlsx"));

		wb.write(out);
		out.close();
	}

	@Test
	public void readFromExcel() throws IOException {
		FileInputStream inputFile = new FileInputStream(new File("src/DDT/File_01.xlsx"));
		XSSFWorkbook wb = new XSSFWorkbook(inputFile); /* cannot just directly read the file since it is not in plain text but rather rows and cols
	   XSSFSheet sh = wb.getSheetAt(0);either you can use index or */
		XSSFSheet sh = wb.getSheet("Sheet01");
		for(int i = 1;i<=sh.getLastRowNum();i++) {
			for(int j =0;j<sh.getRow(i).getPhysicalNumberOfCells();j++) {
				System.out.print(sh.getRow(i).getCell(j));
			}
			System.out.println();
		}

	}

}
