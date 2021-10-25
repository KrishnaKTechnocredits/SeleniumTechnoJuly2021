// Assignment - 7 : 23th Oct'2021

package akansha_Jain;

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
		System.out.println("STEP- Open chrome browser");
		System.setProperty("webdriver.chrome.driver", "//Users//punchh_akansha//eclipse-workspace//Java_Techno_Selenium_2021//resources//chromedriver");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		System.out.println("STEP- Open URL");
		driver.get("http://automationbykrishna.com/index.html#");
		Thread.sleep(3000);
		System.out.println("STEP- Open demo tables");
		driver.findElement(By.xpath("//a[@id='demotable']")).click();
		Thread.sleep(4000);
	}
	
	// How many tables are there on the page?
	@Test
	void testCase1() {
		System.out.println("Find total tables on page");
		int actualTableCount = driver.findElements(By.tagName("table")).size();
		System.out.println("Tota number of tables on page are-" + actualTableCount);
		int expectedTableCount = 4;
		Assert.assertEquals(actualTableCount, expectedTableCount);
	}
	
	// How many rows are there in EMPLOYEE BASIC INFORMATION?
	@Test
	void testCase2() {
		System.out.println("Find total rows on EMPLOYEE BASIC INFORMATION table");
		int actualRowsCount = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size();
		System.out.println("Tota number of rows on EMPLOYEE BASIC INFORMATION table are-" + actualRowsCount);
		int expectedRowsCount = 5;
		Assert.assertEquals(actualRowsCount, expectedRowsCount);
	}
	
	// How many columns are there in EMPLOYEE BASIC INFORMATION table?
	@Test
	void testCase3() {
		System.out.println("Find total columns on EMPLOYEE BASIC INFORMATION table");
		int actualColumnsCount = driver.findElements(By.xpath("//table[@id='table1']/thead/tr/th")).size();
		System.out.println("Tota number of columns on EMPLOYEE BASIC INFORMATION table are-" + actualColumnsCount);
		int expectedColumnsCount = 4;
		Assert.assertEquals(actualColumnsCount, expectedColumnsCount);
	}
	
	// return first name of all the employees
	@Test
	void testCase4() {
		ArrayList<String> actualListOfFirstNames = getListOfFirstNames();
		System.out.println("List of first names of all employees- " + actualListOfFirstNames);
		String[] expectedList = {"Maulik", "Krishna", "Dhara", "Abhishek", "Priya"};
		ArrayList<String> expectedListOfFirstNames = new ArrayList<String>(Arrays.asList(expectedList));
		Assert.assertEquals(actualListOfFirstNames, expectedListOfFirstNames);
	}
	
	ArrayList<String> getListOfFirstNames() {
		System.out.println("Find first name of all the employees");
		ArrayList<String> al = new ArrayList<String>();
		int rowsCount = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size();
		for(int index=1; index<=rowsCount; index++) {
			String name = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr["+index+"]/td[2]")).getText();
			al.add(name);
		}
		return al;
	}
	
	//  return index of given column name ie. lastname -> 3 column index
	@Test
	void testCase5() throws Exception {
		int actualColIndex = getColIndex("Last Name");
		System.out.println("Index of column name 'lastname' is- " + actualColIndex);
		int expectedColIndex = 3;
		Assert.assertEquals(actualColIndex, expectedColIndex);
	}
	
	int getColIndex(String colName) throws Exception{
		int totalCol = 4;
		int targetIndex = 0;
		for(int index=1;index<=totalCol;index++){
			String columnName = driver.findElement(By.xpath("//table[@id='table1']/thead/tr/th["+index+"]")).getText();
			if(columnName.equals(colName)){
				targetIndex = index;
				break;
			}
		}
		if(targetIndex == 0)
			throw new Exception("User trying to find colName " + colName + " which is not a part of a table");
		return targetIndex;
   }

	//  print all rows
	@Test
	void testCase6() {
		System.out.println("Print all the rows");
		int actualRows = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size();
		for(int index=1; index<=actualRows; index++) {
			System.out.println(driver.findElement(By.xpath("//table[@id='table1']/tbody/tr["+index+"]")).getText());
		}
		int expectedRows = 5;
		Assert.assertTrue(actualRows==expectedRows);;
	}
	
	// print lastname of the employee whoes first name is Abhishek
	@Test
	void testCase7() {
		String actualLastName = getLastNameFromFirstName("Abhishek");
		System.out.println("Lastname of the employee whose first name is Abhishek- " + actualLastName);
		String expectedLastName = "Sharma";
		Assert.assertEquals(actualLastName, expectedLastName);
	}
	
	String getLastNameFromFirstName(String name) {
		String output = "";
		int totalRows = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size();
		for(int index=1;index<=totalRows;index++) {
			String currentName = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr["+index+"]/td[2]")).getText();
			if(name.equals(currentName)) {
				output = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr["+index+"]/td[3]")).getText();
				break;
			}
		}
		return output;
	}
	
	// print the firstname of the employee whoes username is ppatro
	@Test
	void testCase8() {
		String actualFirstName = getFirstNameFromUserName("ppatro");
		System.out.println("Firstname of the employee whose username is ppatro- " + actualFirstName);
		String expectedFirstName = "Priya";
		Assert.assertEquals(actualFirstName, expectedFirstName);
	}
	
	String getFirstNameFromUserName(String name) {
		String output = "";
		int totalRows = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size();
		for(int index=1;index<=totalRows;index++) {
			String currentName = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr["+index+"]/td[4]")).getText();
			if(name.equals(currentName)) {
				output = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr["+index+"]/td[2]")).getText();
				break;
			}
		}
		return output;
	}
	
	// how many unique surnames we have in EMPLOYEE BASIC INFORMATION
	@Test
	void testCase9() {
		System.out.println("Find unique surnames we have in EMPLOYEE BASIC INFORMATION");
		int totalRows = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size();
		LinkedHashSet<String> actualUniqueSurnames = new LinkedHashSet<>();
		for(int index=1; index<=totalRows; index++) {
			String surName = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr["+index+"]/td[3]")).getText();
			actualUniqueSurnames.add(surName);
		}
		System.out.println("Unique surnames are- " + actualUniqueSurnames);
		int actualUniqueSurnamesCount = actualUniqueSurnames.size();
		int expectedUniqueSurnamesCount = 4;
		Assert.assertEquals(actualUniqueSurnamesCount, expectedUniqueSurnamesCount);
	}
	
	// return a map of firstname and username.
	@Test
	void testCase10() {
		LinkedHashMap<String, String> mapOfFirstNameUserName = getMapOfFirstNameUserName();
		System.out.println("A map of firstname and username is- " + mapOfFirstNameUserName);
		int actualMapSize = mapOfFirstNameUserName.size();
		int expectedMapSize = 5;
		Assert.assertEquals(actualMapSize, expectedMapSize);
	}
	
	LinkedHashMap<String, String> getMapOfFirstNameUserName() {
		int totalRows = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size();
		LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();
		for(int index=1; index<=totalRows; index++) {
			String firstName = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr["+index+"]/td[2]")).getText();
			String userName = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr["+index+"]/td[4]")).getText();
			map.put(firstName, userName);
		}
		return map;
	}
	
	// is table contains emplyee having username as kkanani
	@Test
	void testCase11() {
		String name = "kkanani";
		boolean flag = false;
		int totalRows = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size();
		for(int index=1; index<=totalRows; index++) {
			String userName = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr["+index+"]/td[4]")).getText();
			if(name.equals(userName)) {
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