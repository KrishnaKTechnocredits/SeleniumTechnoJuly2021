package margi.Assignment_7;

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

	@AfterClass
	void releaseResources() {
		driver.close();
	}

	// How many tables are there on the page
	@Test
	void testCase1() {
		System.out.println("STEP : find total tables on page");
		int count = driver.findElements(By.xpath("//table")).size();
		System.out.println("Total tables: " + count);
		int expectedResult = 4;
		int actualResult = count;
		Assert.assertEquals(actualResult,expectedResult);
	}

	// How many rows are there in EMPLOYEE BASIC INFORMATION
	@Test
	void testCase2() {
		System.out.println("STEP : find total rows in EMPLOYEE BASIC INFORMATION");
		int count = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size();
		System.out.println("Total rows in EMPLOYEE BASIC INFORMATION: " + count);
		int expectedResult = 5;
		int actualResult = count;
		Assert.assertEquals(actualResult,expectedResult);
	}

	// how many columns are there in EMPLOYEE BASIC INFORMATION
	@Test
	void testCase3() {
		System.out.println("STEP : find total columns in EMPLOYEE BASIC INFORMATION");
		int count = driver.findElements(By.xpath("//table[@id='table1']/thead/tr/th")).size();
		System.out.println("Total columns in EMPLOYEE BASIC INFORMATION: " + count);
		int expectedResult = 4;
		int actualResult = count;
		Assert.assertEquals(actualResult,expectedResult);
	}

	// return first name of all the employees
	@Test
	void testCase4() {
		ArrayList<String> listOfEmp = processTestCase4();
		int expectedResult = 5;
		int actualResult = listOfEmp.size();
		Assert.assertEquals(actualResult,expectedResult);
	}

	ArrayList<String> processTestCase4() {
		System.out.println("STEP : find first name of all the employees");
		ArrayList<String> listOfEmp = new ArrayList<>();
		int rowCount = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size();
		for (int index = 1; index <= rowCount; index++) {
			String firstName = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + index + "]/td[2]"))
					.getText();
			listOfEmp.add(firstName);
		}
		return listOfEmp;
	}

	// return index of given column name : ie. lastname -> 3 column index
	@Test
	void testCase5() {
		int colIndex = processTestCase5();
		int expectedResult = 3;
		int actualResult = colIndex;
		Assert.assertEquals(actualResult,expectedResult);
	}

	int processTestCase5() {
		System.out.println("STEP : index of given column name");
		String givenColName = "Last Name";
		int colIndex = 0;
		int colCount = driver.findElements(By.xpath("//table[@id='table1']/thead/tr/th")).size();
		for (int index = 1; index <= colCount; index++) {
			String currentString = driver.findElement(By.xpath("//table[@id='table1']/thead/tr[1]/th[" + index + "]"))
					.getText();
			if (givenColName.equals(currentString)) {
				colIndex = index;
				break;
			}
		}
		return colIndex;
	}

	// print all rows
	@Test
	void testCase6() {
		System.out.println("STEP : print all rows");
		List<WebElement> rowCount = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));
		for (int index = 1; index <= rowCount.size(); index++) {
			System.out.println(driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + index + "]")).getText());
		}
		int expectedResult = 5;
		int actualResult = rowCount.size();
		Assert.assertTrue(expectedResult == actualResult);
	}

	// print lastname of the employee whoes first name is Abhishek
	@Test
	void testCase7() {
		System.out.println("STEP : print lastname of the employee whose first name is Abhishek");
		String lastName = driver
				.findElement(By.xpath("//table[@id='table1']/tbody//td[text()='Abhishek']/following-sibling::td[1]"))
				.getText();
		String expectedResult = "Sharma";
		String actualResult = lastName;
		Assert.assertEquals(actualResult,expectedResult);
	}

	// print the firstname of the employee whose username is ppatro
	@Test
	void testCase8() {
		System.out.println("STEP : print lastname of the employee whose first name is Abhishek");
		String firstName = driver
				.findElement(By.xpath("//table[@id='table1']/tbody//td[text()='Patro']/preceding-sibling::td[1]"))
				.getText();
		String expectedResult = "Priya";
		String actualResult = firstName;
		Assert.assertEquals(actualResult,expectedResult);
	}

	// how many unique surnames we have in EMPLOYEE BASIC INFORMATION (4)
	@Test
	void testCase9() {
		System.out.println("STEP : find unique surnames we have in EMPLOYEE BASIC INFORMATION");
		int rowCount = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size();
		LinkedHashSet<String> setOfSurnames = new LinkedHashSet<>();
		for (int index = 1; index <= rowCount; index++) {
			String surName = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + index + "]/td[3]"))
					.getText();
			setOfSurnames.add(surName);
		}
		int expectedResult = 4;
		int actualResult = setOfSurnames.size();
		Assert.assertEquals(actualResult,expectedResult);
	}

	// return a map of firstname and username.
	@Test
	void testCase10() {
		LinkedHashMap<String, String> map = processTestCase10();
		int expectedResult = 5;
		int actualResult = map.size();
		Assert.assertEquals(actualResult,expectedResult);
	}

	LinkedHashMap<String, String> processTestCase10() {
		System.out.println("STEP : map of firstname and username");
		int rowCount = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size();
		LinkedHashMap<String, String> mapOfNames = new LinkedHashMap<>();
		for (int index = 1; index <= rowCount; index++) {
			String firstName = driver
					.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + index + "]/td[2]"))
					.getText();
			String lastName = driver
					.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + index + "]/td[4]"))
					.getText();
			mapOfNames.put(firstName, lastName);
		}
		return mapOfNames;
	}

	// is table contains emplyee having username as kkanani.
	@Test
	void testCase11() {
		System.out.println("STEP : check is table contains emplyee having username as kkanani");
		int rowCount = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size();
		boolean flag = true;
		String userName = "kkanani";
		for (int index = 1; index < rowCount; index++) {
			String presentName = driver
					.findElement(By.xpath("//table[@id='table1']/tbody//td[4][text() = '" + userName + "']")).getText();
			if (userName.equals(presentName)) {
				flag = true;
				break;
			}
		}
		boolean expectedResult = true;
		boolean actualResult = flag;
		Assert.assertEquals(actualResult,expectedResult);
	}
}
