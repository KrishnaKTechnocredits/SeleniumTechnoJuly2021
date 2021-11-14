package priti.Assingment_12;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Assingment_12_2 {
	
	WebDriver driver;
	@BeforeClass
	void start() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./resources/chromedriver.exe");
		driver = new ChromeDriver();
		System.out.println("Chrome Browser opened");
		System.out.println("WebSite : https://datatables.net/extensions/autofill/examples/initialisation/focus.html");
		driver.get("https://datatables.net/extensions/autofill/examples/initialisation/focus.html");
	}
	
	ArrayList<String>  listOfEmpName() {
		System.out.println("program 4 : sorting works on employee name or not.");
		ArrayList<String> ListOfEmpName = new ArrayList<String>();
		int pageCnt = driver.findElements(By.xpath("//div[@id='example_paginate']/span/a")).size();
		System.out.println(pageCnt);
		 for (int pageIndex=1;pageIndex<=pageCnt;pageIndex++) {
			 int rowCount = driver.findElements(By.xpath("//table[@id='example']/tbody/tr")).size();
			 for (int rowIndex=1;rowIndex<=rowCount;rowIndex++) {
				 String empName = driver.findElement(By.xpath("//table [@id ='example']/tbody/tr["+rowIndex+"]/td[1]")).getText();
				 ListOfEmpName.add(empName);
			 }
			 
			 driver.findElement(By.xpath("//a[@id='example_next']")).click();
		 }
		//System.out.println(ListOfEmpName);
		System.out.println(ListOfEmpName.size());
		return ListOfEmpName;
	}
	 @Test(priority=1)
	 void verifySortingOnEmpName() {
		ArrayList<String> expListOfEmpName = listOfEmpName();
		//System.out.println("List Of Emp before sorting by clicking on header = A-Z"+expListOfEmpName);
		Collections.sort(expListOfEmpName, Collections.reverseOrder());
		System.out.println("List Of Emp After  RevreseSort = Z-A " + expListOfEmpName);
		System.out.println("Step:click on the header Name of the column to sort the column by header");
		driver.navigate().refresh();
		driver.findElement(By.xpath("//table[@id ='example']/thead/tr/th[text()='Name']")).click();
		ArrayList<String> actualListOfEmpName = new ArrayList<String>();
		actualListOfEmpName = listOfEmpName();
		driver.navigate().refresh();
		System.out.println("List Of Emp after sorting by clicking on header = Z-A"+actualListOfEmpName);
		Assert.assertEquals(actualListOfEmpName, expListOfEmpName);
		 
	 }
	 
	
	 ArrayList<String> listPostions() {
		 System.out.println("program 5 : verfiy sorting works on position. .");
		 ArrayList<String> ListOfPositions = new ArrayList<String>();
		 int pageCnt = driver.findElements(By.xpath("//div[@id='example_paginate']/span/a")).size();
		 for (int pageIndex=1;pageIndex<=pageCnt;pageIndex++) {
			 int rowCount = driver.findElements(By.xpath("//table[@id='example']/tbody/tr")).size();
			 for (int rowIndex=1;rowIndex<=rowCount;rowIndex++) {
				 String positions = driver.findElement(By.xpath("//table [@id ='example']/tbody/tr["+rowIndex+"]/td[2]")).getText();
				 ListOfPositions.add(positions);
			 }
			 
			 driver.findElement(By.xpath("//a[@id='example_next']")).click();
		 }
		
		return ListOfPositions;
	 }
	 
	 
	 @Test(priority=2)
	 void verifySortingOnPositions() {
		ArrayList<String> expListOfPositions = listPostions();
		Collections.sort(expListOfPositions);
		System.out.println("List Of Positions before sorting by clicking on header = A-Z"+ expListOfPositions);
		System.out.println("Step:click on the header of the column Positons to sort the column by header");
		driver.navigate().refresh();
		driver.findElement(By.xpath("//table[@id ='example']/thead/tr/th[2]")).click();
		ArrayList<String> actualListOfPositions = new ArrayList<String>();
		actualListOfPositions = listPostions();
		driver.navigate().refresh();
		System.out.println("List Of Postions after sorting by clicking on header = Z-A"+actualListOfPositions);
		Assert.assertEquals(actualListOfPositions, expListOfPositions);
	 }
			
	@AfterClass
	void closeBrowser() {
		driver.close();
	}
}

/*Assignment - 12: 24th Oct'2021
https://datatables.net/extensions/autofill/examples/initialisation/focus.html
program 4 : sorting works on employee name or not. 
program 5 : verfiy sorting works on position. */



