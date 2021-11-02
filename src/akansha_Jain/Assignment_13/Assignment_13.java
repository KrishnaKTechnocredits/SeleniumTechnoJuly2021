package akansha_Jain.Assignment_13;

import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Assignment_13 {
	WebDriver driver;
	
	@BeforeClass
	void launchBrowser() {
		System.out.println("STEP- Open chrome browser");
		System.setProperty("webdriver.chrome.driver", "//Users//punchh_akansha//eclipse-workspace//Java_Techno_Selenium_2021//resources//chromedriver");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		System.out.println("STEP- Open URL");
		driver.get("https://datatables.net/extensions/autofill/examples/initialisation/focus.html");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	ArrayList<Employee> getEmployeeSortedListOnAge() {
		ArrayList<Employee> sortedEmpListOnAge = new ArrayList<>();
		int totalPages = driver.findElements(By.xpath("//div[@id='example_paginate']/span/a")).size();
		for(int index=1; index<=totalPages; index++) {
			int totalRows = driver.findElements(By.xpath("//table[@class='display nowrap dataTable']/tbody/tr")).size();
			for(int innerIndex=1; innerIndex<=totalRows; innerIndex++) {
				String name = driver.findElement(By.xpath("//table[@class='display nowrap dataTable']/tbody/tr["+innerIndex+"]/td[1]")).getText();
				String position = driver.findElement(By.xpath("//table[@class='display nowrap dataTable']/tbody/tr["+innerIndex+"]/td[2]")).getText();
				String office = driver.findElement(By.xpath("//table[@class='display nowrap dataTable']/tbody/tr["+innerIndex+"]/td[3]")).getText();
				int age = Integer.parseInt(driver.findElement(By.xpath("//table[@class='display nowrap dataTable']/tbody/tr["+innerIndex+"]/td[4]")).getText());
				String startDate = driver.findElement(By.xpath("//table[@class='display nowrap dataTable']/tbody/tr["+innerIndex+"]/td[5]")).getText();
				String salary = driver.findElement(By.xpath("//table[@class='display nowrap dataTable']/tbody/tr["+innerIndex+"]/td[6]")).getText();
				Employee employee = new Employee(name, position, office, age, startDate, salary);
				sortedEmpListOnAge.add(employee);
			}
			driver.findElement(By.xpath("//a[@id='example_next']")).click();
		}
		if(totalPages>0) 
			driver.findElement(By.xpath("//div[@id='example_paginate']/span/a[1]")).click();
		return sortedEmpListOnAge;
	}
	@Test
	void testCase() {
		driver.findElement(By.xpath("//table[@class='display nowrap dataTable']/thead/tr/th[4]")).click();
		ArrayList<Employee> actualSortedEmpListOnAge = getEmployeeSortedListOnAge();
		System.out.println("STEP- Actual sorted list of employees on basis of age- " + actualSortedEmpListOnAge);
		ArrayList<Employee> expectedSortedEmpListOnAge = getEmployeeSortedListOnAge();
		Collections.sort(expectedSortedEmpListOnAge);
		System.out.println("STEP- Expected sorted list of employees on basis of age- " + expectedSortedEmpListOnAge);
		Assert.assertEquals(actualSortedEmpListOnAge, expectedSortedEmpListOnAge);
	}
	
	@AfterClass
	void closeBrowser() {
		driver.close();
	}
}