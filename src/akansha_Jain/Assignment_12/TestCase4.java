/* Assignment - 12: 24th Oct'2021
https://datatables.net/extensions/autofill/examples/initialisation/focus.html
Program 4 : sorting works on employee name or not. */

package akansha_Jain.Assignment_12;

import java.util.ArrayList;
import java.util.Collections;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestCase4 {
	WebDriver driver;
	
	@BeforeClass
	void launchBrowser() {
		driver = PredefinedActions.start();
	}
	
	ArrayList<String> getEmpNameList() {
		ArrayList<String> empNameList = new ArrayList<>();
		int totalPages = driver.findElements(By.xpath("//div[@id='example_paginate']/span/a")).size();
		for(int index=1; index<=totalPages; index++) {
			int totalRows = driver.findElements(By.xpath("//table[@class='display nowrap dataTable']/tbody/tr")).size();
			for(int innerIndex=1; innerIndex<=totalRows; innerIndex++) {
				String empName = driver.findElement(By.xpath("//table[@class='display nowrap dataTable']/tbody/tr["+innerIndex+"]/td[1]")).getText();
				empNameList.add(empName);
			}
			driver.findElement(By.xpath("//a[@id='example_next']")).click();
		}
		if(totalPages>0) 
			driver.findElement(By.xpath("//div[@id='example_paginate']/span/a[1]")).click();
		return empNameList;
	}
	
	@Test
	void testCase4() {
		driver.findElement(By.xpath("//table[@class='display nowrap dataTable']/thead/tr/th[1]")).click();
		ArrayList<String> actualEmpNameList = getEmpNameList();
		System.out.println("STEP- Actual sorted list of employee names- " + actualEmpNameList);
		ArrayList<String> expectedEmpNameList = getEmpNameList();
		Collections.sort(expectedEmpNameList, Collections.reverseOrder());
		System.out.println("STEP- Expected sorted list of employee names- " + expectedEmpNameList);
		Assert.assertEquals(actualEmpNameList, expectedEmpNameList);
	}
	
	@AfterClass
	void closeBrowser() {
		driver.close();
	}
}