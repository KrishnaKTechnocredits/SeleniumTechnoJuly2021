/*
 * Assignment - 12: 24th Oct'2021
https://datatables.net/extensions/autofill/examples/initialisation/focus.html

program 2: print position per employee count by navigating throw all pages. 

Program 3: find out the position with highest and lowest employees.

 */
package husain.Assignment12;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.PredefinedActions;

public class Program2_3 {

	WebDriver driver;

	@BeforeMethod
	void setup() {
		driver = PredefinedActions
				.start("https://datatables.net/extensions/autofill/examples/initialisation/focus.html");
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}

	HashMap<String, Integer> findPositionMap() {

		HashMap<String, Integer> map = new HashMap<String, Integer>();
		System.out.println("STEP - Find position and count of employee per position");
		int paginationCount = driver.findElements(By.xpath("//span/a[@aria-controls='example']/following-sibling::a"))
				.size();
		for (int i = 1; i <= paginationCount + 1; i++) {
			int rowCount = driver.findElements(By.xpath("//table[@id='example']/tbody/tr")).size();
			for (int index = 1; index <= rowCount; index++) {
				String position = driver.findElement(By.xpath("//table[@id='example']/tbody/tr[" + index + "]/td[2]"))
						.getText();
				if (map.containsKey(position)) {
					int positionCount = map.get(position);
					map.put(position, ++positionCount);
				} else {

					map.put(position, 1);
				}
			}
			if (i != paginationCount + 1)
				driver.findElement(By.xpath("//span/a[@aria-controls='example']/following-sibling::a[" + i + "]"))
						.click();
		}
		System.out.println(map);
		return map;
	}

	@Test
	void verifyEmpPosition() {
		System.out.println("STEP - Validate position and count of employee per position");
		HashMap<String, Integer> map = findPositionMap();
		Set<String> position = map.keySet();
		String maxPosition = "";
		String expectedPosition = "Software Engineer";
		int maxCount = 0;
		int expectedCount = 6;
		for (String temp : position) {
			if (map.get(temp) > maxCount) {
				maxCount = map.get(temp);
				maxPosition = temp;
			}
		}
		System.out.println("Position having max number of employees: " + maxPosition);
		System.out.println("Number of employees at that position: " + maxCount);
		Assert.assertEquals(maxCount, expectedCount, "The count of emloyees does not match");
		Assert.assertEquals(maxPosition, expectedPosition, "The position does not match");

	}

	@AfterMethod
	void windingDown() {
		driver.close();
	}

}
