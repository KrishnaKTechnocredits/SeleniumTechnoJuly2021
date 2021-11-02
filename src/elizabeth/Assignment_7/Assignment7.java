package elizabeth.Assignment_7;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.PredefinedActions;

public class Assignment7 {
	
	WebDriver driver;
	
	@BeforeClass
	public void launchBrowser() {
		this.driver = PredefinedActions.start();
		System.out.println("Step: Click on Demo Tables");
		driver.findElement(By.linkText("Demo Tables")).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	@AfterClass
	public void tearDown() {
		driver.close();
	}
	//1) How many tables are there on the page
	
	@Test(priority=1)
	void testCase1() {
		System.out.println("********TestCase1*********");
		System.out.println("Step 1: Find the total number of tables in the page");
		int actualCount=driver.findElements(By.xpath("//table")).size();
		System.out.println("Total number of tables: " +actualCount);
		int expectedcount=4;
		System.out.println("Step 2: Verify if the actual count is matching the expected count");
		Assert.assertEquals(actualCount,expectedcount);
		System.out.println("Testcase1: Executed successfully");
	}
	
	//2) How many rows are there in EMPLOYEE BASIC INFORMATION
	@Test(priority=2)
	void testCase2() {
		System.out.println("********TestCase2*********");
		System.out.println("Step 1: Find the number of rows in EMPLOYEE BASIC INFORMATION");
		int actualCount=driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size();
		System.out.println("Number of rows in the table: " +actualCount);
		int expectedcount=5;
		System.out.println("Step 2: Verify if the actual count is matching the expected count");
		Assert.assertEquals(actualCount,expectedcount);
		System.out.println("Testcase2: Executed successfully");
	}
	
	//3) how many columns are there in EMPLOYEE BASIC INFORMATION
	@Test(priority=3)
	void testCase3() {
		System.out.println("********TestCase3*********");
		System.out.println("Step 1: Find the number of columns in EMPLOYEE BASIC INFORMATION");
		int actualCount=driver.findElements(By.xpath("//table[@id='table1']/thead//th")).size();
		System.out.println("Number of columns in the table: " +actualCount);
		int expectedcount=4;
		System.out.println("Step 2: Verify if the actual count is matching the expected count");
		Assert.assertEquals(actualCount,expectedcount);
		System.out.println("Testcase3: Executed successfully");
	}
	
	//4) return first name of all the employees
	@Test(priority=4)
	void testCase4() {
		System.out.println("********TestCase4*********");
		ArrayList<String> al=new ArrayList<String>();
		System.out.println("Step 1: Return all firstnames");
		int rowCount=driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size();
		for(int rowIndex=1;rowIndex<=rowCount;rowIndex++) {
			String firstName=driver.findElement(By.xpath("//table[@id='table1']/tbody/tr["+rowIndex+"]/td[2]")).getText();
			al.add(firstName);
		}
		System.out.println("First Name of all employees "+al);
	}
	
	@Test(priority=5)
	void testCase5() {
		System.out.println("********TestCase5*********");
		int colIndex=0;
		String columnName="Last Name";
		System.out.println("Step 1: Return the index of given column name");
		int columnCount=driver.findElements(By.xpath("//table[@id='table1']/thead//th")).size();
		for(int index=1;index<=columnCount;index++) {
			String text=driver.findElement(By.xpath("//table[@id='table1']//th["+index+"]")).getText();
			if(text.equals(columnName)) {
				colIndex=index;
				break;
			}
		}
		System.out.println("Index is "+colIndex);
	}
	
	//6) print all rows
	@Test(priority=6)
	void testCase6() {
		System.out.println("********TestCase6*********");
		System.out.println("Step 1: Print all rows");
		int rowCount=driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size();
		for(int rowIndex=1;rowIndex<=rowCount;rowIndex++) {
			System.out.print(driver.findElement(By.xpath("//table[@id='table1']/tbody/tr["+rowIndex+"]")).getText());
			System.out.println();
		}
	}
	
	//7) print lastname of the employee whose first name is Abhishek
	@Test(priority=7)
	void testCase7(){
		System.out.println("********TestCase7*********");
		System.out.println("Step 1: Print the lastname of the employee whose first name is Abhishek");
		String output = "";
		int rowCount=driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size();
		for(int index=1;index<=rowCount;index++){
			String currentName = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr["+index+"]/td[2]")).getText();
			String name="Abhishek";
			if(name.equals(currentName)){
				output = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr["+index+"]/td[3]")).getText();
				break;
			}
		}
		System.out.println("Last name is " +output);
	}
	
	//8) print the firstname of the employee whose username is ppatro
	@Test(priority=8)
	void testCase8(){
		System.out.println("********TestCase8*********");
		System.out.println("Step 1: Print the firstname of the employee whose username is ppatro");
		String output = "";
		int rowCount=driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size();
		for(int index=1;index<=rowCount;index++){
			String currentName = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr["+index+"]/td[4]")).getText();
			String username="ppatro";
			if(username.equals(currentName)){
				output = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr["+index+"]/td[2]")).getText();
				break;
			}
		}
		System.out.println("First name is " +output);
	}
	
	//9) how many unique surnames we have in EMPLOYEE BASIC INFORMATION (4)
	@Test(priority=9)
	void testCase9(){
		System.out.println("********TestCase9*********");
		Set<String> set=new HashSet<String>();
		System.out.println("Step 1: Print the unique surnames in EMPLOYEE BASIC INFORMATION");
		int rowCount=driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size();
		for(int index=1;index<=rowCount;index++){
			String surNames = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr["+index+"]/td[3]")).getText();
			set.add(surNames);
			
		}
		System.out.println("Unique surnames are " +set);
		System.out.println("Count of unique surnames: " +set.size());
	}
	
	//10) return a map of firstname and username.
	@Test(priority=10)
	void testCase10(){
		System.out.println("********TestCase10********");
		HashMap<String,String> map=new HashMap<String,String>();
		System.out.println("Step 1: Return a map with firstname and username");
		int rowCount=driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size();
		for(int index=1;index<=rowCount;index++){
			String firstName = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr["+index+"]/td[2]")).getText();
			String surName = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr["+index+"]/td[4]")).getText();
			map.put(firstName,surName);
			
		}
		System.out.println(" Map of firstname and username is " +map);
	}
	
	//11) is table contains employee having username as kkanani.
	@Test(priority=11)
	void testCase11(){
		System.out.println("********TestCase11********");
		System.out.println("Step 1: Check if table contains employee having username as kkanani.");
		String name="kkanani";
		Boolean flag=false;
		int rowCount=driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size();
			for(int index=1;index<=rowCount;index++){
				String userName=driver.findElement(By.xpath("//table[@id='table1']/tbody/tr["+index+"]/td[4]")).getText();
					if(userName.equals(name)) {
						flag=true;
						break;
					}else {
						flag=false;
					}
			}	
			if(flag) {
				System.out.println(name+ " is displayed");
			}else {
				System.out.println(name+ " is not displayed");
			}
		}
}
	


