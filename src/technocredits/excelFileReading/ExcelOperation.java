package technocredits.excelFileReading;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ExcelOperation {

	@Test
	public void readExcelFile() throws IOException {
		File file = new File("./excelFiles/testing.xlsx");// File Path
		FileInputStream input = new FileInputStream(file);// File Not Exceltion

		/**
		 * 2003 -> XLS (HSSF) 2007 -> XLSX (XSSF)
		 */
		// Interface = class
		Workbook workbook = new XSSFWorkbook(input);// IO Exception
//		workbook= new HSSFWorkbook();
		Sheet sheet = workbook.getSheet("Sheet1"); // import from ss pakage

		int lastRow = sheet.getLastRowNum();
		int lastCell = sheet.getRow(0).getLastCellNum();

		/**
		 * For row it returns index instead of count
		 */

		System.out.println("Total Row: " + (lastRow + 1));
		System.out.println("Total Cell: " + lastCell);

		for (int row = 0; row <= lastRow; row++) {
			for (int colums = 0; colums < lastCell; colums++) {
				System.out.print(sheet.getRow(row).getCell(colums).getStringCellValue() + "\t");
			}
			System.out.println();
		}
	}
}
