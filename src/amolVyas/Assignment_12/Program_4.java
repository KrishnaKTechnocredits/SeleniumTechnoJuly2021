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

public class Program_4 {

	WebDriver driver;

	@BeforeClass
	void getstart() {
		driver = Action.start("https://datatables.net/extensions/autofill/examples/initialisation/focus.html");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void verifySortBasedOnEmployee() {
		List<WebElement> totalPages = driver.findElements(By.xpath("//div[@id='example_paginate']/span/a"));

		List<String> allEmployeeName = new ArrayList();
		for (int index = 1; index <= totalPages.size(); index++) {
			driver.findElement(By.xpath("//div[@id='example_paginate']/span/a[" + index + "]")).click();
			List<WebElement> allEmployeeList = driver.findElements(By.xpath("//table[@id='example']/tbody/tr/td[1]"));
			for (int innerIndex = 0; innerIndex < allEmployeeList.size(); innerIndex++) {
				String Name = allEmployeeList.get(innerIndex).getText();

				allEmployeeName.add(Name);

			}
		}
		driver.findElement(By.xpath("//div[@id='example_paginate']/span/a[1]")).click();
		driver.findElement(By.xpath("//thead//th[@class='sorting sorting_asc' or text()='Name']")).click();

		List<String> EmployeeRevOrder = new ArrayList<>();
		for (int index = 1; index <= totalPages.size(); index++) {
			driver.findElement(By.xpath("//div[@id='example_paginate']/span/a[" + index + "]")).click();
			List<WebElement> allEmployeeList = driver.findElements(By.xpath("//table[@id='example']/tbody/tr/td[1]"));
			for (int innerIndex = 0; innerIndex < allEmployeeList.size(); innerIndex++) {
				String Name = allEmployeeList.get(innerIndex).getText();

				EmployeeRevOrder.add(Name);

			}
		}
		System.out.println("Employee given list: " + allEmployeeName);
		System.out.println("Employee sorted :" + EmployeeRevOrder);
		Collections.sort(EmployeeRevOrder);
		System.out.println("Reverse the sorted employee: " + EmployeeRevOrder);
		Boolean flag = allEmployeeName.equals(EmployeeRevOrder);
		Assert.assertTrue(flag);
	}

	@AfterClass
	void closeConnection() {
		driver.close();
	}

}
