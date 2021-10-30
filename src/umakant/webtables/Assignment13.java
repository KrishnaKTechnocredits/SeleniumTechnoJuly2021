/*Assignment-13: 
https://datatables.net/extensions/autofill/examples/initialisation/focus.html

Program : Verify whole table is sorted based on Employee age.*/

package umakant.webtables;

import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.PredefinedActions;

public class Assignment13 {

	WebDriver driver;

	@BeforeClass
	void goToRequiredPage() {
		driver = PredefinedActions
				.start("https://datatables.net/extensions/autofill/examples/initialisation/focus.html");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	ArrayList<Employee> getEmployeeDetailsBeforeSorting() {
		ArrayList<Employee> employeeNameList = new ArrayList<Employee>();
		int pages = driver.findElements(By.xpath("//div[@id='example_paginate']/span/a")).size();
		for (int index = 1; index <= pages; index++) {
			int rows = driver.findElements(By.xpath("//table[@id='example']/tbody/tr")).size();
			for (int innerIndex = 1; innerIndex <= rows; innerIndex++) {
				String employeeName = driver
						.findElement(By.xpath("//table[@id='example']/tbody/tr[" + innerIndex + "]/td[1]")).getText();
				String position = driver
						.findElement(By.xpath("//table[@id='example']/tbody/tr[" + innerIndex + "]/td[2]")).getText();
				String office = driver
						.findElement(By.xpath("//table[@id='example']/tbody/tr[" + innerIndex + "]/td[3]")).getText();
				int age = Integer.parseInt(driver
						.findElement(By.xpath("//table[@id='example']/tbody/tr[" + innerIndex + "]/td[4]")).getText());
				String startDate = driver
						.findElement(By.xpath("//table[@id='example']/tbody/tr[" + innerIndex + "]/td[5]")).getText();
				String salary = driver
						.findElement(By.xpath("//table[@id='example']/tbody/tr[" + innerIndex + "]/td[6]")).getText();
				Employee emp = new Employee(employeeName, position, office, age, startDate, salary);
				employeeNameList.add(emp);
			}
			driver.findElement(By.xpath("//a[@id='example_next']")).click();
		}
		if (pages > 0)
			driver.findElement(By.xpath("//div[@id='example_paginate']/span/a[1]")).click();
		return employeeNameList;
	}

	ArrayList<Employee> getEmployeeDetailsAfterSorting() {
		ArrayList<Employee> employeeNameList = new ArrayList<Employee>();
		driver.findElement(By.xpath("//table[@id='example']/thead/tr/th[4]")).click();
		int pages = driver.findElements(By.xpath("//div[@id='example_paginate']/span/a")).size();
		for (int index = 1; index <= pages; index++) {
			int rows = driver.findElements(By.xpath("//table[@id='example']/tbody/tr")).size();
			for (int innerIndex = 1; innerIndex <= rows; innerIndex++) {
				String employeeName = driver
						.findElement(By.xpath("//table[@id='example']/tbody/tr[" + innerIndex + "]/td[1]")).getText();
				String position = driver
						.findElement(By.xpath("//table[@id='example']/tbody/tr[" + innerIndex + "]/td[2]")).getText();
				String office = driver
						.findElement(By.xpath("//table[@id='example']/tbody/tr[" + innerIndex + "]/td[3]")).getText();
				int age = Integer.parseInt(driver
						.findElement(By.xpath("//table[@id='example']/tbody/tr[" + innerIndex + "]/td[4]")).getText());
				String startDate = driver
						.findElement(By.xpath("//table[@id='example']/tbody/tr[" + innerIndex + "]/td[5]")).getText();
				String salary = driver
						.findElement(By.xpath("//table[@id='example']/tbody/tr[" + innerIndex + "]/td[6]")).getText();
				Employee emp = new Employee(employeeName, position, office, age, startDate, salary);
				employeeNameList.add(emp);
			}
			driver.findElement(By.xpath("//a[@id='example_next']")).click();
		}
		if (pages > 0)
			driver.findElement(By.xpath("//div[@id='example_paginate']/span/a[1]")).click();
		driver.findElement(By.xpath("//table[@id='example']/thead/tr/th[1]")).click();
		return employeeNameList;
	}

	@Test
	void verifySortingByAge() {
		ArrayList<Employee> employeeList = getEmployeeDetailsBeforeSorting();
		System.out.println(employeeList);
		ArrayList<Employee> actualList = getEmployeeDetailsAfterSorting();
		System.out.println(actualList);
		Collections.sort(employeeList);
		Assert.assertEquals(employeeList, actualList);
	}

	@AfterClass
	void closeThePage() {
		driver.close();
	}

}
