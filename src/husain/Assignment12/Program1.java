/*
 * Assignment - 12: 24th Oct'2021
https://datatables.net/extensions/autofill/examples/initialisation/focus.html

Program 1 : Find unique Office location by navigating through all pages.

 */
package husain.Assignment12;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.PredefinedActions;

public class Program1 {

	WebDriver driver;

	@BeforeMethod
	void setup() {
		driver = PredefinedActions
				.start("https://datatables.net/extensions/autofill/examples/initialisation/focus.html");
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}

	Set<String> findUniqueLocation() {
		System.out.println("STEP - Find unique office locations from the entire table");
		String classAttr = driver.findElement(By.id("example_next")).getAttribute("class");
		Set<String> officeLocation = new TreeSet<String>();
		int paginationCount = driver.findElements(By.xpath("//span/a[@aria-controls='example']/following-sibling::a"))
				.size();
		for (int i = 1; i <= paginationCount + 1; i++) {
			int rowCount = driver.findElements(By.xpath("//table[@id='example']/tbody/tr")).size();
			for (int index = 1; index <= rowCount; index++) {
				String location = driver.findElement(By.xpath("//table[@id='example']/tbody/tr[" + index + "]/td[3]"))
						.getText();
				officeLocation.add(location);
			}
			if (i != paginationCount + 1)
				driver.findElement(By.xpath("//span/a[@aria-controls='example']/following-sibling::a[" + i + "]"))
						.click();

		}
		System.out.println(officeLocation);
		return officeLocation;
	}

	@Test
	void verifyOfficeLocations() {
		System.out.println("STEP - Verify office locations");
		Set<String> actualLocationSet = findUniqueLocation();
		Set<String> expectedLocationSet = new TreeSet<String>();
		expectedLocationSet.add("Singapore");
		expectedLocationSet.add("San Francisco");
		expectedLocationSet.add("London");
		expectedLocationSet.add("New York");
		expectedLocationSet.add("Sydney");
		expectedLocationSet.add("Tokyo");
		expectedLocationSet.add("Edinburgh");

		int actualLocatonCount = actualLocationSet.size();
		int expectedLocationCount = expectedLocationSet.size();

		Assert.assertEquals(actualLocationSet, expectedLocationSet, "The office locations do not match");
		Assert.assertEquals(actualLocatonCount, expectedLocationCount, "The count of office locations does not match");

	}

	@AfterMethod
	void windingDown() {
		driver.close();
	}

}
