package elizabeth.Assignment_12;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Assignment12 {
	
	WebDriver driver;
	
	@BeforeClass
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
		System.out.println("Step: Launch the Browser");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://datatables.net/extensions/autofill/examples/initialisation/focus.html");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	//Program 1 : Find unique Office location by navigating throw all pages.
	Set<String> getUniqueOfficelocation() {
		
		Set<String> set=new HashSet<>();
		int totalPages=driver.findElements(By.xpath("//div[@class='dataTables_paginate paging_simple_numbers']//span/a")).size();
				
		for(int page=1;page<=totalPages;page++) {
			int totalRows=driver.findElements(By.xpath("//table[@class='display nowrap dataTable']//tbody/tr")).size();
			for(int row=1;row<=totalRows;row++) {
				String location=driver.findElement(By.xpath("//table[@class='display nowrap dataTable']/tbody/tr["+row+"]/td[3]")).getText();
				set.add(location);
			}
			driver.findElement(By.xpath("//a[@id='example_next']")).click();
		}
		if(totalPages>0) {
			driver.findElement(By.xpath("//div[@id='example_paginate']/span/a[1]")).click();
		}
		return set;
	}
	@Test
	public void testCase1() {
		System.out.println("***********Program 1*************");
		Set<String> actualSet=getUniqueOfficelocation();
		System.out.println("Step: Set of unique locations from all pages are:" +actualSet);
		System.out.println("Step: Verify if the actual set is same as expected set: ");
		Set<String> expectedSet= new HashSet<>();
		expectedSet.add("San Francisco");
		expectedSet.add("New York");
		expectedSet.add("Singapore");
		expectedSet.add("Tokyo");
		expectedSet.add("London");
		expectedSet.add("Edinburgh");
		expectedSet.add("Sydney");
		Assert.assertTrue(actualSet.equals(expectedSet));
		System.out.println("Verified successfully");
	}
	//program 2: print position per employee count by navigating throw all pages. 
	LinkedHashMap<String,Integer> getEmpCountPerPositionMap(){
		LinkedHashMap<String,Integer> map=new LinkedHashMap<String,Integer>();
		int totalPages=driver.findElements(By.xpath("//div[@class='dataTables_paginate paging_simple_numbers']//span/a")).size();
		
		for(int page=1;page<=totalPages;page++) {
			int totalRows=driver.findElements(By.xpath("//table[@class='display nowrap dataTable']//tbody/tr")).size();
			for(int row=1;row<=totalRows;row++) {
				String position=driver.findElement(By.xpath("//table[@class='display nowrap dataTable']/tbody/tr["+row+"]/td[2]")).getText();
					if(map.containsKey(position)) {
						int count=map.get(position);
						map.put(position,count+1);
					}else {
						map.put(position,1);
					}
			}
			driver.findElement(By.xpath("//a[@id='example_next']")).click();
		}
		if(totalPages>0) {
			driver.findElement(By.xpath("//div[@id='example_paginate']/span/a[1]")).click();
		}
		return map;
	}
	
	@Test
	public void testCase2() {
		System.out.println("***********Program 2*************");
		LinkedHashMap<String,Integer> EmpCountPerPosition=getEmpCountPerPositionMap();
		System.out.println("Step: Position per employee count by navigating throw all pages:" +EmpCountPerPosition);
		int actualEmpCount=0;
		int expectedEmpCount=57;
		for(String temp:EmpCountPerPosition.keySet()) {
			actualEmpCount+=EmpCountPerPosition.get(temp);
		}
		System.out.println("Actual Emp Count is " +actualEmpCount );
		System.out.println("Step: Verify if the count is same as expected employee count: ");
		Assert.assertTrue(actualEmpCount == expectedEmpCount);
		System.out.println("Verified successfully");
	}
	
	//Program 3: find out the position with highest and lowest employees. 
	@Test
	public void testCase3() {
		System.out.println("***********Program 3*************");
		LinkedHashMap<String,Integer> map=getEmpCountPerPositionMap();
		ArrayList<String> positions=new ArrayList<String>(map.keySet());
		String actualMaxPostion="";
		String actualMinPostion="";
		int actualMaxEmpCount=0;
		int expectedMaxEmpCount=6;
		String expectedMaxPosition="Software Engineer";
		String expectedMinPosition="Chief Marketing Officer (CMO)";
		for(String temp:positions) {
			if(actualMaxEmpCount<map.get(temp)) {
				actualMaxEmpCount=map.get(temp);
				actualMaxPostion=temp;
			}
		}
		int actualMinEmpCount=actualMaxEmpCount;
		int expectedMinEmpCount=1;
		for(String temp1:positions) {
			if(actualMinEmpCount>=map.get(temp1)) {
				actualMinEmpCount=map.get(temp1);
				actualMinPostion=temp1;
			}
		}
		System.out.println("Highest number of employees is: " +actualMaxEmpCount);
		System.out.println("Position with Highest number of employees is: " +actualMaxPostion);
		System.out.println("Lowest number of employees is: " +actualMinEmpCount);
		System.out.println("Position with Lowest number of employees is: " +actualMinPostion);
		System.out.println("Step: Verify if the actual postion is same as expected position");
		Assert.assertEquals(actualMaxPostion, expectedMaxPosition);
		Assert.assertEquals(actualMaxEmpCount, expectedMaxEmpCount);
		Assert.assertEquals(actualMinPostion, expectedMinPosition);
		Assert.assertEquals(actualMinEmpCount, expectedMinEmpCount);
		System.out.println("Verified successfully");
	}
	
	
	//program 4 : sorting works on employee name or not.
	ArrayList<String> getEmpNamesSorted() {
		ArrayList<String> al=new ArrayList<String>();
			int totalPages=driver.findElements(By.xpath("//div[@class='dataTables_paginate paging_simple_numbers']//span/a")).size();
			for(int page=1;page<=totalPages;page++) {
				int totalRows=driver.findElements(By.xpath("//table[@class='display nowrap dataTable']//tbody/tr")).size();
				for(int row=1;row<=totalRows;row++) {
					String empName=driver.findElement(By.xpath("//table[@class='display nowrap dataTable']/tbody/tr["+row+"]/td[1]")).getText();
					al.add(empName);
				}
				driver.findElement(By.xpath("//a[@id='example_next']")).click();
			}
			if(totalPages>0) {
				driver.findElement(By.xpath("//div[@id='example_paginate']/span/a[1]")).click();
			}
			return al;
	}
	
	@Test
	public void testCase4() {
		System.out.println("***********Program 4*************");
		System.out.println("Step: Click on Name Header to sort in descending order");
		driver.findElement(By.xpath("//table[@class='display nowrap dataTable']/thead//th[1]")).click();
		ArrayList<String> actualSortedList=getEmpNamesSorted();
		System.out.println("Sorted Employee list after clicking on the Name header is " +actualSortedList);
		ArrayList<String> expectedSortedList=getEmpNamesSorted();
		Collections.sort(expectedSortedList,Collections.reverseOrder());
		Assert.assertEquals(actualSortedList, expectedSortedList);
		
	}
	
	ArrayList<String> getPostionsSorted() {
		ArrayList<String> al=new ArrayList<String>();
			int totalPages=driver.findElements(By.xpath("//div[@class='dataTables_paginate paging_simple_numbers']//span/a")).size();
			for(int page=1;page<=totalPages;page++) {
				int totalRows=driver.findElements(By.xpath("//table[@class='display nowrap dataTable']//tbody/tr")).size();
				for(int row=1;row<=totalRows;row++) {
					String positions=driver.findElement(By.xpath("//table[@class='display nowrap dataTable']/tbody/tr["+row+"]/td[2]")).getText();
					al.add(positions);
				}
				driver.findElement(By.xpath("//a[@id='example_next']")).click();
			}
			if(totalPages>0) {
				driver.findElement(By.xpath("//div[@id='example_paginate']/span/a[1]")).click();
			}
			return al;
	}
	
	@Test
	public void testCase5() {
		System.out.println("***********Program 5*************");
		System.out.println("Step: Click on Position Header to sort it");
		driver.findElement(By.xpath("//table[@class='display nowrap dataTable']/thead//th[2]")).click();
		ArrayList<String> actualSortedList=getPostionsSorted();
		System.out.println("Sorted Positions after clicking on the Position header is " +actualSortedList);
		ArrayList<String> expectedSortedList=getPostionsSorted();
		Collections.sort(expectedSortedList);
		Assert.assertEquals(actualSortedList, expectedSortedList);
	}
	
	//
	@AfterClass
	public void tearDown() {
		driver.close();
	}
	
}
