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

public class Assingment_12_1 {
	
	WebDriver driver;
	@BeforeClass
	void start() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./resources/chromedriver.exe");
		driver = new ChromeDriver();
		System.out.println("Chrome Browser opened");
		System.out.println("WebSite : https://datatables.net/extensions/autofill/examples/initialisation/focus.html");
		driver.get("https://datatables.net/extensions/autofill/examples/initialisation/focus.html");
	}
		
	HashSet<String>  getUniqueOfficeLocationInAllPages() throws InterruptedException {
	  	System.out.println("Program 1 : Find unique Office location by navigating throw all pages.");
		HashSet<String> uniqueSetOfOfficeLocation = new HashSet<String>();
		int countOfuniqueOfficeLocation =0;
		System.out.println("Step: find no of pages.");
		int pagecount= driver.findElements(By.xpath("//div[@id ='example_paginate']//span/a")).size();
		System.out.println(pagecount);
		
		for (int index=1;index<=pagecount ;index++){
			Thread.sleep(1000);
			//System.out.println("Step: find no of rows on current page.");
			int rowCountOnPage = driver.findElements(By.xpath("//table[@id ='example']/tbody/tr")).size();
			//System.out.println(rowCountOnPage);
			for(int innerIndex=1 ;innerIndex<=rowCountOnPage;innerIndex++) {
				String officeName = driver.findElement(By.xpath("//table[@id ='example']/tbody/tr["+innerIndex+"]/td[3]")).getText();
				uniqueSetOfOfficeLocation.add(officeName);
			}
			driver.findElement(By.xpath("//a[@id='example_next']")).click();
		}	
		countOfuniqueOfficeLocation = uniqueSetOfOfficeLocation.size();
		System.out.println("Count of unique offcie location:"+countOfuniqueOfficeLocation);
		return uniqueSetOfOfficeLocation;
	}
	
	@Test(priority=1)
	void verifycountofuniqueOfficeLocation() throws InterruptedException {
		HashSet<String> actualuniqueSetOfOfficeLocation= getUniqueOfficeLocationInAllPages();
		System.out.println("Step : verify actual and expected count of office laction:");
		Assert.assertTrue(actualuniqueSetOfOfficeLocation.size()==7);
		HashSet<String> expuniqueSetOfOfficeLocation= new HashSet<String>();
		expuniqueSetOfOfficeLocation.add("San Francisco");
		expuniqueSetOfOfficeLocation.add("Edinburgh");
		expuniqueSetOfOfficeLocation.add("Singapore");
		expuniqueSetOfOfficeLocation.add("London");
		expuniqueSetOfOfficeLocation.add("Tokyo");
		expuniqueSetOfOfficeLocation.add("Sydney");
		expuniqueSetOfOfficeLocation.add("New York");
		System.out.println("Step : verify actual and expected list of office laction:");
		Assert.assertEquals(actualuniqueSetOfOfficeLocation, expuniqueSetOfOfficeLocation, "actual and expected count of office locationdoesnot macth");
		driver.navigate().refresh();
		
	}
	 
	@Test (priority=2)
	TreeMap<String, Integer> getpostioncountperEmp() throws InterruptedException {
		System.out.println("Program 2: print position per employee count by navigating throw all pages.");
		TreeMap<String, Integer> mapOfPositionPerEmp = new TreeMap<String, Integer>();
		System.out.println("Step: find no of pages.");
		int pageCount= driver.findElements(By.xpath("//div[@id ='example_paginate']//span/a")).size();
		System.out.println("Page count : "+pageCount);
		for (int index=1;index<=pageCount ;index++){
			Thread.sleep(1000);
			//System.out.println("Step: find no of rows on current page.");
			int rowCountOnPage = driver.findElements(By.xpath("//table[@id ='example']/tbody/tr")).size();
			//System.out.println("row count : "+ rowCountOnPage);
			for(int innerIndex=1 ;innerIndex<=rowCountOnPage;innerIndex++) {
				String postion= driver.findElement(By.xpath("//table[@id ='example']/tbody/tr["+innerIndex+"]/td[2]")).getText();
				if (mapOfPositionPerEmp.containsKey(postion)) {
					int count = mapOfPositionPerEmp.get(postion);
					mapOfPositionPerEmp.put(postion, ++count);
					
				}else {
					mapOfPositionPerEmp.put(postion, 1);
				}
			}	
			//System.out.println("Step: click on next button to navigate next page.");
			driver.findElement(By.xpath("//a[@id='example_next']")).click();
		}		
				
		System.out.println(" map of postions and employee count for that postion: ");
		System.out.println(mapOfPositionPerEmp);
		System.out.println("countof total postion: "+mapOfPositionPerEmp.size());
		int actualcountOfPostions= mapOfPositionPerEmp.size();
		int expcountOfPostions =33;
		Assert.assertEquals(actualcountOfPostions, expcountOfPostions);
		return mapOfPositionPerEmp;
	}
	
	
	@Test (priority=3)	
	void getPositonWithHigestAndLowestEmployee() throws InterruptedException{
		System.out.println("Program 3: find out the position with highest and lowest employees.");
		int maxPositions=0; int minPostions=1; 
		String actualmaxPostionMEmp ="";
		TreeMap<String, Integer> mapOfPositionPerEmp =getpostioncountperEmp();
		ArrayList<String> actuaListOfMinPostion = new ArrayList<String>();
		//Set<String>set = mapOfPositionPerEmp.keySet();
		for (String position:mapOfPositionPerEmp.keySet()) {
			int noOfPositons = mapOfPositionPerEmp.get(position);
				if (maxPositions<=noOfPositons) {
					maxPositions=noOfPositons;
					actualmaxPostionMEmp =position;
				}else if (minPostions>=noOfPositons){
					minPostions=noOfPositons;
					actuaListOfMinPostion.add(position);
				}
		}
		System.out.println("positions with max no of employee:-"+actualmaxPostionMEmp+"Number of employess are:- "+maxPositions);
		System.out.println("List Of positions with min no of employee:-"+actuaListOfMinPostion);
		System.out.println("Number of employess are:- "+actuaListOfMinPostion.size());
		int expMaxPostionMEmp= 6;
		int expListOfMinPostion =22;
		Assert.assertEquals(maxPositions, expMaxPostionMEmp);
		Assert.assertEquals(actuaListOfMinPostion.size(), expListOfMinPostion);
	}	
	
	
	
	 ArrayList<String> listPostions() {
		 System.out.println("program 5 : verfiy sorting works on position. .");
		 ArrayList<String> ListOfPositions = new ArrayList<String>();
		 int pageCnt = driver.findElements(By.xpath("//div[@id='example_paginate']/span/a")).size();
		 System.out.println(pageCnt);
		 for (int pageIndex=1;pageIndex<=pageCnt;pageIndex++) {
			 int rowCount = driver.findElements(By.xpath("//table[@id='example']/tbody/tr")).size();
			 for (int rowIndex=1;rowIndex<=rowCount;rowIndex++) {
				 String positions = driver.findElement(By.xpath("//table [@id ='example']/tbody/tr["+rowIndex+"]/td[2]")).getText();
				 ListOfPositions.add(positions);
			 }
			 
			 driver.findElement(By.xpath("//a[@id='example_next']")).click();
		 }
		//System.out.println(ListOfPositions);
		System.out.println(ListOfPositions.size());
		return ListOfPositions;
	 }
	 
	 
	 @Test(priority=5)
	 void verifySortingOnPositions() {
		ArrayList<String> expListOfPositions = listPostions();
		Collections.sort(expListOfPositions);
		System.out.println("List Of Positions before sorting by clicking on header = A-Z"+ expListOfPositions);
		/*Collections.sort(expListOfPositions, Collections.reverseOrder());
		System.out.println(expListOfPositions.size());
		System.out.println("List Of Positions After  RevreseSort = Z-A " + expListOfPositions);*/
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
Program 1 : Find unique Office location by navigating throw all pages.
Program 2: print position per employee count by navigating throw all pages. 
Program 3: find out the position with highest and lowest employees. 
program 4 : sorting works on employee name or not. 
program 5 : verfiy sorting works on position. */


