package amolVyas.Assignment_12;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import amolVyas.Assignment_5.Action;

public class Program_5 {

	WebDriver driver;

	@BeforeClass
	void getstart() {
		driver = Action.start("https://datatables.net/extensions/autofill/examples/initialisation/focus.html");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void verifySortBasedOnPosition() {
		List<WebElement> totalPages = driver.findElements(By.xpath("//div[@id='example_paginate']/span/a"));

		List<String> allPositions = new ArrayList();
		for (int index = 1; index <= totalPages.size(); index++) {
			driver.findElement(By.xpath("//div[@id='example_paginate']/span/a[" + index + "]")).click();
			List<WebElement> allPositionsList = driver.findElements(By.xpath("//table[@id='example']/tbody/tr/td[2]"));
			for (int innerIndex = 0; innerIndex < allPositionsList.size(); innerIndex++) {
				String position = allPositionsList.get(innerIndex).getText();

				allPositions.add(position);

			}
		}
		driver.findElement(By.xpath("//div[@id='example_paginate']/span/a[1]")).click();
		driver.findElement(By.xpath("//thead//th[@class='sorting' and text()='Position']")).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		List<String> PositionASCOrder = new ArrayList<>();
		for (int index = 1; index <= totalPages.size(); index++) {
			driver.findElement(By.xpath("//div[@id='example_paginate']/span/a[" + index + "]")).click();
			List<WebElement> allPositionsList = driver.findElements(By.xpath("//table[@id='example']/tbody/tr/td[2]"));
			for (int innerIndex = 0; innerIndex < allPositionsList.size(); innerIndex++) {
				String Name = allPositionsList.get(innerIndex).getText();

				PositionASCOrder.add(Name);

			}
		}
		System.out.println("Employee given list: " + allPositions);
		System.out.println("Employee sorted in Asc:" + PositionASCOrder);
		Collections.sort(allPositions);
		System.out.println("Sort Employee with collection in Asc: " + allPositions);
		Boolean flag = allPositions.equals(PositionASCOrder);
		Assert.assertTrue(flag);
	}

	@AfterClass
	void closeConnection() {
		driver.close();
	}

}
