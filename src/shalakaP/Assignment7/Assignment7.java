package shalakaP.Assignment7;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base.PredefinedActions;

public class Assignment7 {

	WebDriver driver;

	@BeforeClass
	void launchBrowser() {
		System.out.println("Step-Open Browser");
		System.out.println("Step-Open given url");
		driver = PredefinedActions.start();
		System.out.println("Step-Click on Demo tables");
		driver.findElement(By.linkText("Demo Tables")).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	@AfterClass
	void resourceRelease() {
		driver.close();
	}

	// How many tables are there on the page
	@Test
	void countTables() {
		System.out.println("Step-Count total number of tables on page");
		int actualTableCnt = driver.findElements(By.xpath("//table")).size();
		System.out.println("Count of tables:" + actualTableCnt);
		int expectedTableCnt = 4;
		Assert.assertEquals(actualTableCnt, expectedTableCnt);
	}

	// How many rows are there in EMPLOYEE BASIC INFORMATION
	@Test
	void countRows() {
		System.out.println("Step-Count rows in EMPLOYEE BASIC INFORMATION");
		int actualRowCnt = driver.findElements(By.xpath("//table[@class='table']/tbody/tr")).size();
		System.out.println("Count of rows:" + actualRowCnt);
		int expectedRowCnt = 5;
		Assert.assertEquals(actualRowCnt, expectedRowCnt);
	}

	// how many columns are there in EMPLOYEE BASIC INFORMATION
	@Test
	void countColumns() {
		System.out.println("Step-Count rows in EMPLOYEE BASIC INFORMATION");
		int actualColumnCnt = driver.findElements(By.xpath("//table[@class='table']/thead/tr/th")).size();
		System.out.println("Count of rows:" + actualColumnCnt);
		int expectedColumnCnt = 4;
		Assert.assertEquals(actualColumnCnt, expectedColumnCnt);
	}

	// return first name of all the employees
	@Test
	void getFirstNameOfAllEmployees() {
		ArrayList<String> actualList = new ArrayList<String>();
		ArrayList<String> expectedList = new ArrayList<String>();
		expectedList.add("Maulik");
		expectedList.add("Krishna");
		expectedList.add("Dhara");
		expectedList.add("Abhishek");
		expectedList.add("Priya");
		System.out.println("Step-Return first name of all the employees");
		int rowCnt = driver.findElements(By.xpath("//table[@class='table']/tbody/tr")).size();
		for (int index = 1; index <= rowCnt; index++) {
			String firstName = driver.findElement(By.xpath("//table[@class='table']/tbody/tr[" + index + "]/td[2]"))
					.getText();
			actualList.add(firstName);
		}
		Assert.assertEquals(actualList, expectedList);
	}

	/*
	 * // return index of given column name void getIndexOfGivenColumn() {
	 * System.out.println("Step-Returnindex of given column name");
	 * driver.findElement(By.xpath("//table[@class='table']/thead/tr/th[3]"));
	 * 
	 * }
	 */

	// print all rows
	@Test
	void printAllRows() {
		System.out.println("Step-Print all rows");
		int rowCnt = driver.findElements(By.xpath("//table[@class='table']/tbody/tr")).size();
		for (int index = 1; index <= rowCnt; index++) {
			System.out
					.println(driver.findElement(By.xpath("//table[@class='table']/tbody/tr[" + index + "]")).getText());
		}
	}

	// print lastname of the employee whose first name is Abhishek

	@Test
	void lastName() {
		String actuallastName = printLastName("Abhishek");
		String expectedLastName = "Sharma";
		Assert.assertEquals(expectedLastName, actuallastName);
	}

	String printLastName(String name) {
		System.out.println("Step-print lastname of the employee whoes first name is Abhishek");
		int rowCnt = driver.findElements(By.xpath("//table[@class='table']/tbody/tr")).size();
		String output = "";
		for (int index = 1; index <= rowCnt; index++) {
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
	@Test
	void firstName() {
		String actualUserName = printFirstName("ppatro");
		String expectedUserName = "Priya";
		Assert.assertEquals(actualUserName, expectedUserName);
	}

	String printFirstName(String userName) {
		System.out.println("Step-print the firstname of the employee whose username is ppatro");
		int rowCnt = driver.findElements(By.xpath("//table[@class='table']/tbody/tr")).size();
		String output = "";
		for (int index = 1; index <= rowCnt; index++) {
			String currentUserName = driver
					.findElement(By.xpath("//table[@class='table']/tbody/tr[" + index + "]/td[4]")).getText();
			if (userName.equals(currentUserName)) {
				output = driver.findElement(By.xpath("//table[@class='table']/tbody/tr[" + index + "]/td[2]"))
						.getText();
				break;
			}
		}

		return output;
	}

	// how many unique surnames we have in EMPLOYEE BASIC INFORMATION
	@Test
	void uniqueSurnames() {
		System.out.println("Step-Count unique surnames we have in EMPLOYEE BASIC INFORMATION");
		HashSet<String> uniqueSurname = new HashSet<String>();
		int rowCnt = driver.findElements(By.xpath("//table[@class='table']/tbody/tr")).size();
		for (int index = 1; index <= rowCnt; index++) {
			String surName = driver.findElement(By.xpath("//table[@class='table']/tbody/tr[" + index + "]/td[3]"))
					.getText();
			uniqueSurname.add(surName);
		}
		Assert.assertEquals(4, uniqueSurname.size());
	}

	// return a map of firstname and username.
	@Test
	void firstNameAndLastName() {
		LinkedHashMap<String, String> mapOfFirstnameAndLastName = mapOfFirstnameAndUsername();
		System.out.println("Map of firstname and LastNAme:" + mapOfFirstnameAndLastName);
		Assert.assertEquals(mapOfFirstnameAndLastName.size(), 5);
	}

	LinkedHashMap<String, String> mapOfFirstnameAndUsername() {
		LinkedHashMap<String, String> hm = new LinkedHashMap<String, String>();
		int rowCnt = driver.findElements(By.xpath("//table[@class='table']/tbody/tr")).size();
		for (int index = 1; index <= rowCnt; index++) {
			String username = driver.findElement(By.xpath("//table[@class='table']/tbody/tr[" + index + "]/td[4]"))
					.getText();
			String firstName = driver.findElement(By.xpath("//table[@class='table']/tbody/tr[" + index + "]/td[2]"))
					.getText();
			hm.put(username, firstName);
		}
		return hm;
	}

	// is table contains employee having username as kkanani.

	@Test
	void userName() {
		String username = "kkanani";
		boolean flag = true;
		int rowCnt = driver.findElements(By.xpath("//table[@class='table']/tbody/tr")).size();
		for (int index = 1; index <= rowCnt; index++) {
			String currUsername = driver.findElement(By.xpath("//table[@class='table']/tbody/tr[2]/td[4]")).getText();
			if (currUsername.equals(username))
				flag = true;
			break;
		}
		Assert.assertTrue(flag);
	}

	// return index of given column name
	@Test
	void colIndex() throws Exception {
		int actualColIndex = getColIndex("Last Name");
		int expectedColIndex = 3;
		Assert.assertEquals(actualColIndex, expectedColIndex);
	}

	int getColIndex(String colName) throws Exception {
		int totalCol = 4;
		int targetIndex = 0;
		for (int index = 1; index < totalCol; index++) {
			String headerText = driver.findElement(By.xpath("//table[@id='table1']/thead/tr/th[" + index + "]"))
					.getText();
			if (headerText.equals(colName)) {
				targetIndex = index;
				break;
			}
		}
		if (targetIndex == 0)
			throw new Exception("User trying to find colName " + colName + " which is not a part of a table");
		return targetIndex;
	}
}
