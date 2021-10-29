package amol_P.Assignment_12;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC_04 {
	WebDriver driver;

	@BeforeMethod()
	public void setup() {
		driver = PredifineAction.start();
	}

	/* program 4 : sorting works on employee name or not. */
	@Test()
	public void sortBasedOnEmployee() {
		List<WebElement> totalPages = driver.findElements(By.xpath("//div[@id='example_paginate']/span/a"));

		List<String> allEmployeeName = new ArrayList();
		for (int index = 1; index <= totalPages.size(); index++) {
			driver.findElement(By.xpath("//div[@id='example_paginate']/span/a[" + index + "]")).click();
			List<WebElement> allEmployeeList = driver.findElements(By.xpath("//table[@id='example']/tbody/tr/td[1]"));
			for (int index1 = 0; index1 < allEmployeeList.size(); index1++) {
				String Name = allEmployeeList.get(index1).getText();

				allEmployeeName.add(Name);

			}
		}
		driver.findElement(By.xpath("//div[@id='example_paginate']/span/a[1]")).click();
		driver.findElement(By.xpath("//thead//th[@class='sorting sorting_asc' or text()='Name']")).click();

		List<String> EmployeeRevOrder = new ArrayList<>();
		for (int index = 1; index <= totalPages.size(); index++) {
			driver.findElement(By.xpath("//div[@id='example_paginate']/span/a[" + index + "]")).click();
			List<WebElement> allEmployeeList = driver.findElements(By.xpath("//table[@id='example']/tbody/tr/td[1]"));
			for (int index1 = 0; index1 < allEmployeeList.size(); index1++) {
				String Name = allEmployeeList.get(index1).getText();

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

	@AfterMethod()
	public void teardown() {
		driver.quit();
	}
}
