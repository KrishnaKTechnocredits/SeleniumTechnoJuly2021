/* Assignment - 12: 24th Oct'2021
https://datatables.net/extensions/autofill/examples/initialisation/focus.html
Program 1 : Find unique Office location by navigating throw all pages. */

package akansha_Jain.Assignment_12;

import java.util.HashSet;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestCase1 {
	WebDriver driver;
	
	@BeforeClass
	void launchBrowser() {
		driver = PredefinedActions.start();
	}
	
	
	Set<String> getUniqueOfficeLocations() {
		Set<String> set = new HashSet<>();
		int totalPages = driver.findElements(By.xpath("//div[@id='example_paginate']/span/a")).size();
		for(int index=1; index<=totalPages; index++) {
			int totalRows = driver.findElements(By.xpath("//table[@class='display nowrap dataTable']/tbody/tr")).size();
			for(int innerIndex=1; innerIndex<=totalRows; innerIndex++) {
				String location = driver.findElement(By.xpath("//table[@class='display nowrap dataTable']/tbody/tr["+innerIndex+"]/td[3]")).getText();
				set.add(location);
			}
			driver.findElement(By.xpath("//a[@id='example_next']")).click();
		}
		if(totalPages>0) 
			driver.findElement(By.xpath("//div[@id='example_paginate']/span/a[1]")).click();
		return set;
	}
	
	@Test
	void testCase1() {
		Set<String> actualSetOfUniqueLocations = getUniqueOfficeLocations();
		System.out.println("STEP- List of all unique locations- " + actualSetOfUniqueLocations);
		Set<String> expectedSetOfUniqueLocations = new HashSet<String>();
		expectedSetOfUniqueLocations.add("San Francisco");
		expectedSetOfUniqueLocations.add("New York");
		expectedSetOfUniqueLocations.add("Singapore");
		expectedSetOfUniqueLocations.add("Tokyo");
		expectedSetOfUniqueLocations.add("London");
		expectedSetOfUniqueLocations.add("Edinburgh");
		expectedSetOfUniqueLocations.add("Sydney");
		Assert.assertEquals(actualSetOfUniqueLocations, expectedSetOfUniqueLocations);
	}
	
	@AfterClass
	void closeBrowser() {
		driver.close();
	}
}