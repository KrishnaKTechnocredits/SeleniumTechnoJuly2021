package technocredits.excelFileReading;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelOperation {

	public static Object[][] readExcelFile() {

		File file = new File("./excelFiles/testing.xlsx");// File Path
		FileInputStream input;
		Workbook workbook = null;
		try {
			input = new FileInputStream(file);
			workbook = new XSSFWorkbook(input);// IO Exception
		} catch (IOException e) {
			e.printStackTrace();
		} // File Not Exceltion

		/**
		 * 2003 -> XLS (HSSF) 2007 -> XLSX (XSSF)
		 */
		// Interface = class
//		workbook= new HSSFWorkbook();
		Sheet sheet = workbook.getSheet("Sheet1"); // import from ss pakage

		int lastRow = sheet.getLastRowNum() + 1;
		int lastCell = sheet.getRow(0).getLastCellNum();

		Object[][] data = new Object[lastRow][lastCell];

		/**
		 * For row it returns index instead of count
		 */

		System.out.println("Total Row: " + (lastRow));
		System.out.println("Total Cell: " + lastCell);

		for (int row = 0; row < lastRow; row++) {
			for (int colums = 0; colums < lastCell; colums++) {
				Cell cell = sheet.getRow(row).getCell(colums);
				if (cell.getCellType() == CellType.NUMERIC) {
					data[row][colums] = String.valueOf(cell.getNumericCellValue());
				} else if (cell.getCellType() == CellType.STRING) {
					data[row][colums] = String.valueOf(cell.getStringCellValue());
				} else if (cell.getCellType() == CellType.BOOLEAN) {
					data[row][colums] = String.valueOf(cell.getBooleanCellValue());
				}
			}
		}
		return data;
	}

//	public static void main(String[] args) throws IOException {
//		readExcelFile();
//	}

}
