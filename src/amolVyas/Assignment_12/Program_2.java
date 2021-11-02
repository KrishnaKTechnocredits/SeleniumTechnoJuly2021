package amolVyas.Assignment_12;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import amolVyas.Assignment_5.Action;

public class Program_2 {

	WebDriver driver;

	@BeforeClass
	void getstart() {
		driver = Action.start("https://datatables.net/extensions/autofill/examples/initialisation/focus.html");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	void getEmpCountPerPosition() {
		int totalPages = driver.findElements(By.xpath("//div[@id='example_paginate']/span/a")).size();
		Map<String, Integer> map = new HashMap();
		for (int index = 1; index <= totalPages; index++) {
			int rowPerPage = driver.findElements(By.xpath("//table[@class='display nowrap dataTable']/tbody/tr"))
					.size();
			for (int innerIndex = 1; innerIndex <= rowPerPage; innerIndex++) {
				String position = driver
						.findElement(
								By.xpath("//table[@class='display nowrap dataTable']/tbody/tr[\"+innerIndex+\"]/td[2]"))
						.getText();
				if (map.containsKey(position)) {
					int count = map.get(position);
					map.put(position, ++count);
				} else
					map.put(position, 1);

			}
			driver.findElement(By.xpath("//a[text()='Next']")).click();
		}
		if (totalPages > 0)
			driver.findElement(By.xpath("//div[@id='example_paginate']/span/a[1]")).click();
		int actualEmpCount = 0;
		for (String count : map.keySet()) {
			actualEmpCount += map.get(count);
		}

		int expectedEmpCount = 57;
		Assert.assertTrue(actualEmpCount == expectedEmpCount);
	}

	@AfterClass
	void closeConnection() {
		driver.close();
	}

}
