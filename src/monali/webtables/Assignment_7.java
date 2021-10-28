package monali.webtables;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.PredefinedActions;

public class Assignment_7 {
	WebDriver driver;

	@BeforeClass
	void launchBrowser() {
		driver = PredefinedActions.start();
		driver.findElement(By.xpath("//a[contains(text(),'Demo Tables')]")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@AfterClass
	void tearDown() {
		driver.close();
	}

	// 1) How many tables are there on the page
	@Test
	void TestCase_1() {
		int actualResult = driver.findElements(By.tagName("table")).size();
		int expectedResult = 4;
		Assert.assertEquals(actualResult, expectedResult);
	}

	// 2) How many rows are there in EMPLOYEE BASIC INFORMATION
	@Test
	void TestCase_2() {
		int actualResult = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size();
		int expectedResult = 5;
		Assert.assertEquals(actualResult, expectedResult);
	}

	// 3) how many columns are there in EMPLOYEE BASIC INFORMATION
	@Test
	void TestCase_3() {
		int actualResult = driver.findElements(By.xpath("//table[@id='table1']/thead//th")).size();
		int expectedResult = 4;
		Assert.assertEquals(actualResult, expectedResult);
	}

	// 4) return first name of all the employees

	ArrayList<String> TestCase_4() {
		int rowsCount = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size();
		ArrayList<String> listOfFirstNames = new ArrayList<>();
		for (int index = 1; index <= rowsCount; index++) {
			String firstName = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + index + "]/td[2]"))
					.getText();
			listOfFirstNames.add(firstName);
		}
		return listOfFirstNames;
	}

	@Test
	void verifyFirstNames() {
		ArrayList<String> expectedList = new ArrayList<String>();
		expectedList.add("Maulik");
		expectedList.add("Krishna");
		expectedList.add("Dhara");
		expectedList.add("Abhishek");
		expectedList.add("Priya");

		ArrayList<String> actualList = TestCase_4();
		Assert.assertEquals(actualList, expectedList);
	}

	// 5) return index of given column name ie. lastname -> 3 column index

	@Test
	void testCase_5() {
		int actualIndex = getIndexOfColumnName();
		int expectedIndex = 3;
		System.out.println("Last Name column index : " + actualIndex);
		Assert.assertEquals(actualIndex, expectedIndex);

	}

	int getIndexOfColumnName() {
		String columnName = "Last Name";

		int columnCount = driver.findElements(By.xpath("//table[@id='table1']/thead/tr/th")).size();
		int actualIndex = 0;
		for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
			String columnHeader = driver.findElement(By.xpath("//table[@id='table1']/thead/tr/th[" + columnIndex + "]"))
					.getText();
			if (columnName.equals(columnHeader)) {
				actualIndex = columnIndex;
				break;
			}
		}

		return actualIndex;
	}

	// 6) print all rows
	@Test
	void TestCase_6() {
		String element = driver.findElement(By.xpath("//table[@id='table1']/tbody")).getText();
		System.out.println(element);
	}

	// 7) print lastname of the employee whose first name is Abhishek
	@Test
	void getLastName() {
		int rowsCount = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size();
		String firstName = "Abhishek";
		String expectedText = "Sharma";
		String actualText = "";
		for (int index = 1; index <= rowsCount; index++) {
			String actualName = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + index + "]/td[2]"))
					.getText();
			if (firstName.equals(actualName))
				actualText = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + index + "]/td[3]"))
						.getText();
		}
		System.out.println("Abhishek last name : " + actualText);
		Assert.assertEquals(actualText, expectedText);
	}

	// 8) print the firstname of the employee whoes username is ppatro
	@Test
	void testCase_8() {
		String expectedText = "Priya";
		String actualText = "";
		String userName = "ppatro";
		int rowsCount = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size();

		for (int index = 1; index <= rowsCount; index++) {
			String actualName = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + index + "]/td[4]"))
					.getText();
			if (userName.equals(actualName))
				actualText = driver
						.findElement(By
								.xpath("//table[@id='table1']/tbody/tr[" + index + "]/td[4]/preceding-sibling::td[2]"))
						.getText();
		}
		System.out.println("First name of ppatro : " + actualText);
		Assert.assertEquals(expectedText, actualText);
	}

	// 9) how many unique surnames we have in EMPLOYEE BASIC INFORMATION
	@Test
	void uniqueSurname() {
		Set<String> set = new HashSet<>();
		int expectedCount = 4;
		int rowsCount = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size();
		for (int index = 1; index <= rowsCount; index++) {
			String lastName = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + index + "]/td[3]"))
					.getText();
			set.add(lastName);
		}
		Assert.assertEquals(expectedCount, set.size());
	}

	// 10) return a map of firstname and username.
	@Test
	void getFirstNameandUserName() {
		Map<String, String> expectedMap = new HashMap<>();
		expectedMap.put("Maulik", "mkanani");
		expectedMap.put("Krishna", "kkanani");
		expectedMap.put("Dhara", "dboda");
		expectedMap.put("Abhishek", "asharma");
		expectedMap.put("Priya", "ppatro");

		int rowsCount = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size();
		Map<String, String> actualMap = new HashMap<>();
		for (int index = 1; index <= rowsCount; index++) {
			String firstName = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + index + "]/td[2]"))
					.getText();
			String userName = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + index + "]/td[4]"))
					.getText();
			actualMap.put(firstName, userName);
		}
		Assert.assertEquals(actualMap, expectedMap);
	}

	// 11) is table contains emplyee having username as kkanani.
	@Test
	void userNamePresentOrNot() {
		String expectedUserName = "kkanani";
		boolean flag = false;
		int rowsCount = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size();
		for (int index = 1; index <= rowsCount; index++) {
			String actualUserName = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[2]/td[4]")).getText();
			if (actualUserName.equals(expectedUserName))
				flag = true;
			break;
		}
		Assert.assertTrue(flag);

	}
}
