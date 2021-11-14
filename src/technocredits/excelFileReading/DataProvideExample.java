package technocredits.excelFileReading;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProvideExample {

	@Test(dataProvider = "read_from_excel")
	public void m1(String firstName, String lastName, String env) {
		System.out.println(firstName.trim());
		System.out.println(lastName.trim());
		System.out.println(env.trim());
//		System.out.println("browser Name : " + browser);
	}

	@DataProvider(name = "read_from_excel")
	public Object[][] getDataFromExcel() {
//		Object[][] data = new Object[2][4];//[row][colums]
//		data[0][0] = "java";
//		data[0][1] = "selenium";
//		data[0][2] = "qa";
//		data[0][3] = "chrome";
//		data[1][0] = "ruby";
//		data[1][1] = "calabash";
//		data[1][2] = "prod";
//		data[1][3] = "ff";
		
		return ExcelOperation.readExcelFile();
	}

//	@DataProvider(name="read_from_excel 3")
//	public Object[][] getDataFromExcel_1() {
//		return null;
//	}
//	@DataProvider(name="read_from_excel 6")
//	public Object[][] getDataFromExcel_2() {
//		return null;
//	}
}
