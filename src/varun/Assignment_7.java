package varun;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Assignment_7 {
	WebDriver driver;

	@BeforeClass
	void launchBrowser() {
		System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		System.out.println("STEP : Launch Browser");
		driver.get("http://automationbykrishna.com/#");

		System.out.println("STEP : Navigate to Demo Tables");
		driver.findElement(By.linkText("Demo Tables")).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	// Test Case 1:- How many tables are there on the page
	@Test
	void countOfTables() throws InterruptedException {
		int expectedSize = 4;
		System.out.println("How many tables are there on the page?");
		Thread.sleep(3000);
		int tableSize = driver.findElements(By.xpath("//table")).size();
		System.out.println("Total number of tables on a page is " + tableSize);
		Assert.assertEquals(expectedSize, tableSize);
		System.out.println("TC-01, Test case Passed");
	}

	// Test Case 2:- How many rows are there in EMPLOYEE BASIC INFORMATION
	@Test
	void countNumberOfRowsInEmployeeBasicInfo() throws InterruptedException {
		int expectedRowCount = 5;
		System.out.println("Find total number of rows from Employee Basic Info Table");
		Thread.sleep(3000);
		int actualRowCount = driver.findElements(By.xpath("//table[@class='table']/tbody/tr")).size();
		System.out.println("Total number of rows in Emp Basic info table is " + actualRowCount);
		Assert.assertEquals(expectedRowCount, actualRowCount);
		System.out.println("TC-02, Test case Passed");
	}

	// Test Case 3:- how many columns are there in EMPLOYEE BASIC INFORMATION
	@Test
	void countNumberOfColumnInEmployeeBasicInfo() throws InterruptedException {
		int expectedColumnCount = 4;
		System.out.println("Find total number of columns from Employee Basic Info Table");
		Thread.sleep(3000);
		int actualColumnCount = driver.findElements(By.xpath("//table[@id='table1']/thead/tr/th")).size();
		Assert.assertEquals(expectedColumnCount, actualColumnCount);
		System.out.println("TC-03, Test Case passed");
	}

	// Test case 4:- return first name of all the employees
	@Test
	void findFirstName() throws InterruptedException {
		ArrayList<String> listOfEmp = findFirstNameOfAllEmpFromEmployeeBasicInfo();
		int expectedResult = 5;
		int actualResult = listOfEmp.size();
		Assert.assertEquals(actualResult, expectedResult);
	}

	ArrayList<String> findFirstNameOfAllEmpFromEmployeeBasicInfo() throws InterruptedException {
		System.out.println("Find first name from Employee Basic Info Table");
		Thread.sleep(3000);
		ArrayList<String> listOfEmp = new ArrayList<>();
		int rowCount = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size();
		for (int index = 1; index <= rowCount; index++) {
			String firstName = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + index + "]/td[2]"))
					.getText();
			listOfEmp.add(firstName);
		}
		return listOfEmp;
	}

	// Test Case 5:- return index of given column name
	@Test
	int returnOfGivenColumnName(String colName) {
		int totalCol = 4;
		int targetIndex = 0;
		for (int index = 1; index < totalCol; index++) {
			String headerText = driver.findElement(By.xpath("//table[@id ='table1']//thead/tr/th['+index+']"))
					.getText();
			if (headerText.equals(colName)) {
				targetIndex = index;
				break;
			}
		}
		return targetIndex;
	}

	// Test Case 6:- print all rows
	@Test
	void printAllRows() {
		System.out.println("Print all the rows from the basic info table");
		List<WebElement> rowCount = driver.findElements(By.xpath("//table[@id='table1']//tbody/tr"));
		for (int rowIndex = 1; rowIndex <= rowCount.size(); rowIndex++) {
			System.out.println(
					driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + rowIndex + "]")).getText());
		}
	}

	// Test Case 7:- print lastname of the employee whoe's first name is Abhishek
	@Test
	void printLastNameOfAbhishek() {
		System.out.println("Print the last Name of all the employees whoes first name is abhishek");
		String lastName = driver
				.findElement(By.xpath("//table[@id='table1']/tbody//td[text() = 'Abhishek']/following-sibling::td[1]"))
				.getText();
		String expectedResult = "Sharma";
		String actualResult = lastName;
		Assert.assertEquals(actualResult, expectedResult);
	}

	// Test Case 8:- print the firstname of the employee whoes username is ppatro
	@Test
	void printFirstNameOfUserNamePpatro() {
		System.out.println("print the firstname of the employee whoes username is ppatro");
		String firstName = driver
				.findElement(By.xpath("//table[@id='table1']/tbody//td[text() = 'ppatro']/preceding-sibling::td[2]"))
				.getText();
		String expectedResult = "Priya";
		String actualResult = firstName;
		Assert.assertEquals(actualResult, expectedResult);
	}

	// Test Case 9:- how many unique surnames we have in EMPLOYEE BASIC INFORMATION
	// (4)
	@Test
	void countOfUniqueSurname() {
		System.out.println("print the count of unique surname from the employee basic information");
		int rowCount = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size();
		LinkedHashSet<String> surNames = new LinkedHashSet<String>();
		for (int index = 1; index <= rowCount; index++) {
			String surName = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + index + "]/td[3]"))
					.getText();
			surNames.add(surName);
		}
		int expectedResult = 4;
		int actualResult = surNames.size();
		Assert.assertEquals(actualResult, expectedResult);
	}

	// Test Case 10:- return a map of firstname and username.
	@Test
	void returnMapOfFirstAndLastName() {
		LinkedHashMap<String, String> map = processTestCase10();
		int expectedResult = 5;
		int actualResult = map.size();
		Assert.assertEquals(actualResult, expectedResult);
	}

	LinkedHashMap<String, String> processTestCase10() {
		System.out.println("Print map of firstname and username");
		int rowCount = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size();
		LinkedHashMap<String, String> map = new LinkedHashMap<>();
		for (int index = 1; index <= rowCount; index++) {
			String firstName = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + index + "]/td[2]"))
					.getText();
			String lastName = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + index + "]/td[4]"))
					.getText();
			map.put(firstName, lastName);
		}
		return map;
	}

	// Test Case 11:- is table contains employee having username as kkanani.
	@Test
	void userNameAsKkanani() {
		System.out.println("table contains employee having username as kkanani");
		int rowCount = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size();
		String userName = "kkanani";
		boolean flag = true;
		for (int index = 1; index <= rowCount; index++) {
			String name = driver
					.findElement(By.xpath("//table[@id='table1']/tbody//td[4][text() = '" + userName + "']")).getText();
			if (name.equals(userName)) {
				flag = true;
				break;
			}
		}
		boolean expectedResult = true;
		boolean actualResult = flag;
		Assert.assertEquals(actualResult, expectedResult);
	}

	@AfterClass
	void closeTheDriver() {
		driver.close();
	}
}