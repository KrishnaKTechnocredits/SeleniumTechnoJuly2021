/* Assignment - 12: 24th Oct'2021
https://datatables.net/extensions/autofill/examples/initialisation/focus.html
Program 5 : verfiy sorting works on position. */

package akansha_Jain.Assignment_12;

import java.util.ArrayList;
import java.util.Collections;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestCase5 {
	WebDriver driver;
	
	@BeforeClass
	void launchBrowser() {
		driver = PredefinedActions.start();
	}
	
	ArrayList<String> getPositionsList() {
		ArrayList<String> positionsList = new ArrayList<>();
		int totalPages = driver.findElements(By.xpath("//div[@id='example_paginate']/span/a")).size();
		for(int index=1; index<=totalPages; index++) {
			int totalRows = driver.findElements(By.xpath("//table[@class='display nowrap dataTable']/tbody/tr")).size();
			for(int innerIndex=1; innerIndex<=totalRows; innerIndex++) {
				String position = driver.findElement(By.xpath("//table[@class='display nowrap dataTable']/tbody/tr["+innerIndex+"]/td[2]")).getText();
				positionsList.add(position);
			}
			driver.findElement(By.xpath("//a[@id='example_next']")).click();
		}
		if(totalPages>0) 
			driver.findElement(By.xpath("//div[@id='example_paginate']/span/a[1]")).click();
		return positionsList;
	}
	
	@Test
	void testCase5() {
		driver.findElement(By.xpath("//table[@class='display nowrap dataTable']/thead/tr/th[2]")).click();
		ArrayList<String> actualPositionsList = getPositionsList();
		System.out.println("STEP- Actual sorted list of employee names- " + actualPositionsList);
		ArrayList<String> expectedPositionsList = getPositionsList();
		Collections.sort(expectedPositionsList);
		System.out.println("STEP- Expected sorted list of employee names- " + expectedPositionsList);
		Assert.assertEquals(actualPositionsList, expectedPositionsList);
	}
	
	@AfterClass
	void closeBrowser() {
		driver.close();
	}
}