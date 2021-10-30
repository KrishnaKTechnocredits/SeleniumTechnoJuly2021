/* Assignment - 12: 24th Oct'2021
https://datatables.net/extensions/autofill/examples/initialisation/focus.html
Program 2: print position per employee count by navigating throw all pages. */

package akansha_Jain.Assignment_12;

import java.util.LinkedHashMap;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestCase2 {
	WebDriver driver;
	
	@BeforeClass
	void launchBrowser() {
		driver = PredefinedActions.start();
	}
	
	LinkedHashMap<String, Integer> getPositionPerEmpCount() {
		LinkedHashMap<String, Integer> mapPositionEmpCount = new LinkedHashMap<>();
		int totalPages = driver.findElements(By.xpath("//div[@id='example_paginate']/span/a")).size();
		for(int index=1; index<=totalPages; index++) {
			int totalRows = driver.findElements(By.xpath("//table[@class='display nowrap dataTable']/tbody/tr")).size();
			for(int innerIndex=1; innerIndex<=totalRows; innerIndex++) {
				String position = driver.findElement(By.xpath("//table[@class='display nowrap dataTable']/tbody/tr["+innerIndex+"]/td[2]")).getText();
				if(mapPositionEmpCount.containsKey(position))
					mapPositionEmpCount.put(position, mapPositionEmpCount.get(position)+1);
				else
					mapPositionEmpCount.put(position, 1);
			}
			driver.findElement(By.xpath("//a[@id='example_next']")).click();
		}
		if(totalPages>0) 
			driver.findElement(By.xpath("//div[@id='example_paginate']/span/a[1]")).click();
		return mapPositionEmpCount;
	}
	
	@Test
	void testCase2() {
		LinkedHashMap<String, Integer> actualMapPositionEmpCount = getPositionPerEmpCount();
		System.out.println("STEP- " + actualMapPositionEmpCount);
		int actualEmpCount = 0;
		for(String count : actualMapPositionEmpCount.keySet()) {
			actualEmpCount += actualMapPositionEmpCount.get(count);
		}
		int expectedEmpCount = 57;
		Assert.assertTrue(actualEmpCount == expectedEmpCount);
	}
	
	@AfterClass
	void closeBrowser() {
		driver.close();
	}
}