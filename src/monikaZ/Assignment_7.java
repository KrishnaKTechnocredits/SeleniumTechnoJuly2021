package monikaZ;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Assignment_7 {

	WebDriver driver;

	@BeforeClass
	void launchBrowser() throws InterruptedException {
		System.out.println("STEP- Open Chrome Browser");
		System.setProperty("webdriver.chrome.driver", "./resources/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		System.out.println("STEP- Enter URL");
		driver.get("http://automationbykrishna.com/index.html#");
		Thread.sleep(2000);
		System.out.println("STEP- Open Demo Tables");
		driver.findElement(By.xpath("//a[@id='demotable']")).click();
		Thread.sleep(3000);
	}

	// How many tables are there on the page
	@Test
	void testCase1() {
		System.out.println("Find total No.Of tables on Page");
		int actualTableCount = driver.findElements(By.tagName("table")).size();
		System.out.println("Total no.of tables on page are:" + actualTableCount);
		int expectedTableCount = 4;
		Assert.assertEquals(actualTableCount, expectedTableCount);

	}

	// How many rows are there in EMPLOYEE BASIC INFORMATION?
	@Test
	void testCase2() {
		System.out.println("Find total rows in EMPLOYEE BASIC INFORMATION Table");
		int actualRowsCount = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size();
		System.out.println("Total no.of rows in EMPLOYEE BASIC INFORMATION Table are:" + actualRowsCount);
		int expectedRowsCount = 5;
		Assert.assertEquals(actualRowsCount, expectedRowsCount);

	}

	// How many columns are there in EMPLOYEE BASIC INFORMATION table?
	@Test
	void testCase3() {
		System.out.println("Find total columns in EMPLOYEE BASIC INFORMATION table");
		int actualColumnsCount = driver.findElements(By.xpath("//table[@id='table1']/thead/tr/th")).size();
		System.out.println("Total number of columns in EMPLOYEE BASIC INFORMATION table are-" + actualColumnsCount);
		int expectedColumnsCount = 4;
		Assert.assertEquals(actualColumnsCount, expectedColumnsCount);
	}

	// Return first name of all the employees
	ArrayList<String> getListOfFirstNames() {
		System.out.println("Find Fist Name of all Employees:");
		ArrayList<String> al = new ArrayList<String>();
		int rowCount = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size();
		for (int index = 1; index <= rowCount; index++) {
			String name = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + index + "]/td[2]")).getText();
			al.add(name);
		}
		return al;
	}

	@Test
	void testCase4() {
		ArrayList<String> actualListOfFirstNames = getListOfFirstNames();
		System.out.println("List of First Names Of all Employees:" + actualListOfFirstNames);
		String[] expectedList = { "Maulik", "Krishna", "Dhara", "Abhishek", "Priya" };
		ArrayList<String> expectedListOfFirstNames = new ArrayList<String>(Arrays.asList(expectedList));
		Assert.assertEquals(actualListOfFirstNames, expectedListOfFirstNames);

	}

    //Return index of given column name ie. lastname -> 3 column index
	@Test
	void testCase5() throws Exception {
		int actualColIndex = getColIndex("Last Name");
		System.out.println("Index of column name 'lastname' is: " + actualColIndex);
		int expectedColIndex = 3;
		Assert.assertEquals(actualColIndex, expectedColIndex);
	}

	int getColIndex(String colName) throws Exception {
		int totalCol = 4;
		int targetIndex = 0;
		for (int index = 1; index <= totalCol; index++) {
			String columnName = driver.findElement(By.xpath("//table[@id='table1']/thead/tr/th[" + index + "]"))
					.getText();
			if (columnName.equals(colName)) {
				targetIndex = index;
				break;
			}
		}
		if (targetIndex == 0)
			throw new Exception("User trying to find colName " + colName + " which is not a part of a table");
		return targetIndex;
	}

	// print all rows
	@Test
	void testCase6() {
		System.out.println("Print all the rows");
		int actualRows = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size();
		for (int index = 1; index <= actualRows; index++) {
			System.out.println(driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + index + "]")).getText());
		}
		int expectedRows = 5;
		Assert.assertTrue(actualRows == expectedRows);
		;
	}

	// print lastname of the employee whoes first name is Abhishek
	@Test
	void testCase7() {
		String actualLastName = getLastNameFromFirstName("Abhishek");
		System.out.println("Lastname of the employee whose first name is Abhishek: " + actualLastName);
		String expectedLastName = "Sharma";
		Assert.assertEquals(actualLastName, expectedLastName);
	}

	String getLastNameFromFirstName(String name) {
		String output = "";
		int totalRows = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size();
		for (int index = 1; index <= totalRows; index++) {
			String currentName = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + index + "]/td[2]"))
					.getText();
			if (name.equals(currentName)) {
				output = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + index + "]/td[3]")).getText();
				break;
			}
		}
		return output;
	}

	// print the firstname of the employee whoes username is ppatro
	String getFirstNameFromUserName(String name) {
		String output = "";
		int totalRows = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size();
		for (int index = 1; index <= totalRows; index++) {
			String currentName = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + index + "]/td[4]"))
					.getText();
			if (name.equals(currentName)) {
				output = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + index + "]/td[2]")).getText();
				break;
			}
		}
		return output;
	}
	@Test
	void testCase8() {
		String actualFirstName = getFirstNameFromUserName("ppatro");
		System.out.println("Firstname of the employee whose username is ppatro- " + actualFirstName);
		String expectedFirstName = "Priya";
		Assert.assertEquals(actualFirstName, expectedFirstName);
	}

	// how many unique surnames we have in EMPLOYEE BASIC INFORMATION
	@Test
	void testCase9() {
		System.out.println("Find unique Surnames we have in EMPLOYEE BASIC INFORMATION");
		int totalRows = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size();
		LinkedHashSet<String> actualUniqueSurnames = new LinkedHashSet<>();
		for (int index = 1; index <= totalRows; index++) {
			String lastName = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + index + "]/td[3]"))
					.getText();
			actualUniqueSurnames.add(lastName);
		}
		System.out.println("Unique Surnames Are- " + actualUniqueSurnames);
		int actualUniqueSurnamesCount = actualUniqueSurnames.size();
		int expectedUniqueSurnamesCount = 4;
		Assert.assertEquals(actualUniqueSurnamesCount, expectedUniqueSurnamesCount);
	}

	// return a map of firstname and username.
	LinkedHashMap<String, String> getMapOfFirstNameUserName() {
		int totalRows = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size();
		LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();
		for (int index = 1; index <= totalRows; index++) {
			String firstName = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + index + "]/td[2]"))
					.getText();
			String userName = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + index + "]/td[4]"))
					.getText();
			map.put(firstName, userName);
		}
		return map;
	}
	@Test
	void testCase10() {
		LinkedHashMap<String, String> mapOfFirstNameUserName = getMapOfFirstNameUserName();
		System.out.println("A map of firstname and username is- " + mapOfFirstNameUserName);
		int actualMapSize = mapOfFirstNameUserName.size();
		int expectedMapSize = 5;
		Assert.assertEquals(actualMapSize, expectedMapSize);
	}

	

	// is table contains emplyee having username as kkanani
	@Test
	void testCase11() {
		String name = "kkanani";
		boolean flag = false;
		int totalRows = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size();
		for (int index = 1; index <= totalRows; index++) {
			String userName = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + index + "]/td[4]"))
					.getText();
			if (name.equals(userName)) {
				flag = true;
				break;
			}
		}
		boolean actualFlag = flag;
		System.out.println("Is Table contains employee having username as kkanani- " + actualFlag);
		boolean expectedFlag = true;
		Assert.assertTrue(actualFlag == expectedFlag);
	}

	@AfterClass
	void closeBrowser() {
		driver.close();
	}

}