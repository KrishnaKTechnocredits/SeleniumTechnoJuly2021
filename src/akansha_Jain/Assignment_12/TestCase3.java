/* Assignment - 12: 24th Oct'2021
https://datatables.net/extensions/autofill/examples/initialisation/focus.html
Program 3: find out the position with highest and lowest employees. */

package akansha_Jain.Assignment_12;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestCase3 {
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
	void testCase3() {
		LinkedHashMap<String, Integer> map = getPositionPerEmpCount();
		ArrayList<String> listOfPositions = new ArrayList<>(map.keySet());
		String actualMaxPosition = "";
		String expectedMaxPosition = "Software Engineer";
		int actualMaxEmpCount = 0;
		int expectedMaxEmpCount = 6;	
		for(String temp : listOfPositions) {
			if(map.get(temp) > actualMaxEmpCount) {
				actualMaxEmpCount = map.get(temp);
				actualMaxPosition = temp;
			}
		}
		System.out.println("Position having max number of employees is- " + actualMaxPosition + " employee count is- " + actualMaxEmpCount);
		Assert.assertEquals(actualMaxPosition, expectedMaxPosition);
		Assert.assertEquals(actualMaxEmpCount, expectedMaxEmpCount);
		
		String actualLowestPosition = "";
		String expectedLowestPosition = "Chief Marketing Officer (CMO)";
		int actualMinEmpCount = 10;
		int expectedMinEmpCount = 1;
		for(String temp : listOfPositions) {
			if(map.get(temp) <= actualMinEmpCount) {
				actualMinEmpCount = map.get(temp);
				actualLowestPosition = temp;
			}
		}
		System.out.println("Position having lowest number of employees is- " + actualLowestPosition + " employee count is- " + actualMinEmpCount);
		Assert.assertEquals(actualLowestPosition, expectedLowestPosition);
		Assert.assertEquals(actualMinEmpCount, expectedMinEmpCount);
	}
	
	@AfterClass
	void closeBrowser() {
		driver.close();
	}
}