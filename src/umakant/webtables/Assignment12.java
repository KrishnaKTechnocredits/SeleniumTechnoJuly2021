/*
 Assignment - 12: 24th Oct'2021
https://datatables.net/extensions/autofill/examples/initialisation/focus.html

Program 1 : Find unique Office location by navigating throw all pages.

program 2: print position per employee count by navigating throw all pages. 

Program 3: find out the position with highest and lowest employees. 

program 4 : sorting works on employee name or not. 

program 5 : verfiy sorting works on position. 
 */
package umakant.webtables;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.PredefinedActions;

public class Assignment12 {

	WebDriver driver;
	String nextButtonDisableClassName = "paginate_button next disabled";

	@BeforeClass
	void goToRequiredPage() {
		driver = PredefinedActions
				.start("https://datatables.net/extensions/autofill/examples/initialisation/focus.html");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	Set<String> getUniqueOfficeLocation() {
		Set<String> officeLocationSet = new HashSet<String>();
		int pages = driver.findElements(By.xpath("//div[@id='example_paginate']/span/a")).size();
		for (int index = 1; index <= pages; index++) {
			int rows = driver.findElements(By.xpath("//table[@id='example']/tbody/tr")).size();
			for (int innerIndex = 1; innerIndex <= rows; innerIndex++) {
				String officeLocation = driver
						.findElement(By.xpath("//table[@id='example']/tbody/tr[" + innerIndex + "]/td[3]")).getText();
				officeLocationSet.add(officeLocation);
			}
			driver.findElement(By.xpath("//a[@id='example_next']")).click();
		}
		if (pages > 0)
			driver.findElement(By.xpath("//div[@id='example_paginate']/span/a[1]")).click();
		return officeLocationSet;
	}

	Map<String, Integer> getPositionWiseEmployeeCount() {
		Map<String, Integer> positionEmployeeMap = new HashMap<String, Integer>();
		int pages = driver.findElements(By.xpath("//div[@id='example_paginate']/span/a")).size();
		for (int index = 1; index <= pages; index++) {
			int rows = driver.findElements(By.xpath("//table[@id='example']/tbody/tr")).size();
			for (int innerIndex = 1; innerIndex <= rows; innerIndex++) {
				String position = driver
						.findElement(By.xpath("//table[@id='example']/tbody/tr[" + innerIndex + "]/td[2]")).getText();
				if (positionEmployeeMap.containsKey(position))
					positionEmployeeMap.put(position, positionEmployeeMap.get(position) + 1);
				else
					positionEmployeeMap.put(position, 1);
			}
			driver.findElement(By.xpath("//a[@id='example_next']")).click();
		}
		if (pages > 0)
			driver.findElement(By.xpath("//div[@id='example_paginate']/span/a[1]")).click();
		return positionEmployeeMap;
	}

	String[] getPositionHavingHighestAndLowestEmployeeCount() {
		Map<String, Integer> positionEmployeeMap = new HashMap<String, Integer>();
		String[] output = { "", "" };
		int pages = driver.findElements(By.xpath("//div[@id='example_paginate']/span/a")).size();
		for (int index = 1; index <= pages; index++) {
			int rows = driver.findElements(By.xpath("//table[@id='example']/tbody/tr")).size();
			for (int innerIndex = 1; innerIndex <= rows; innerIndex++) {
				String position = driver
						.findElement(By.xpath("//table[@id='example']/tbody/tr[" + innerIndex + "]/td[2]")).getText();
				if (positionEmployeeMap.containsKey(position))
					positionEmployeeMap.put(position, positionEmployeeMap.get(position) + 1);
				else
					positionEmployeeMap.put(position, 1);
			}
			driver.findElement(By.xpath("//a[@id='example_next']")).click();
		}
		if (pages > 0)
			driver.findElement(By.xpath("//div[@id='example_paginate']/span/a[1]")).click();
		List<String> positionKeys = new ArrayList<>(positionEmployeeMap.keySet());
		int max = positionEmployeeMap.get(positionKeys.get(0));
		int min = positionEmployeeMap.get(positionKeys.get(0));
		output[0] = positionKeys.get(0);
		output[1] = positionKeys.get(0);
		for (int index = 1; index < positionKeys.size(); index++) {
			String dept = positionKeys.get(index);
			int deptEmp = positionEmployeeMap.get(dept);
			if (deptEmp > max) {
				output[1] = dept;
				max = deptEmp;
			} else if (deptEmp < min) {
				output[0] = dept;
				min = deptEmp;
			}
		}
		return output;
	}

	ArrayList<String> getEmployeeNameBeforeSorting() {
		ArrayList<String> employeeNameList = new ArrayList<String>();
		int pages = driver.findElements(By.xpath("//div[@id='example_paginate']/span/a")).size();
		for (int index = 1; index <= pages; index++) {
			int rows = driver.findElements(By.xpath("//table[@id='example']/tbody/tr")).size();
			for (int innerIndex = 1; innerIndex <= rows; innerIndex++) {
				String employeeName = driver
						.findElement(By.xpath("//table[@id='example']/tbody/tr[" + innerIndex + "]/td[1]")).getText();
				employeeNameList.add(employeeName);
			}
			driver.findElement(By.xpath("//a[@id='example_next']")).click();
		}
		if (pages > 0)
			driver.findElement(By.xpath("//div[@id='example_paginate']/span/a[1]")).click();
		return employeeNameList;
	}

	ArrayList<String> getEmployeeNameAfterSorting() {
		ArrayList<String> employeeNameList = new ArrayList<String>();
		driver.findElement(By.xpath("//table[@id='example']/thead/tr/th[1]")).click();
		int pages = driver.findElements(By.xpath("//div[@id='example_paginate']/span/a")).size();
		for (int index = 1; index <= pages; index++) {
			int rows = driver.findElements(By.xpath("//table[@id='example']/tbody/tr")).size();
			for (int innerIndex = 1; innerIndex <= rows; innerIndex++) {
				String employeeName = driver
						.findElement(By.xpath("//table[@id='example']/tbody/tr[" + innerIndex + "]/td[1]")).getText();
				employeeNameList.add(employeeName);
			}
			driver.findElement(By.xpath("//a[@id='example_next']")).click();
		}
		if (pages > 0)
			driver.findElement(By.xpath("//div[@id='example_paginate']/span/a[1]")).click();
		driver.findElement(By.xpath("//table[@id='example']/thead/tr/th[1]")).click();
		return employeeNameList;
	}
	
	ArrayList<String> getPositionBeforeSorting() {
		ArrayList<String> employeeNameList = new ArrayList<String>();
		int pages = driver.findElements(By.xpath("//div[@id='example_paginate']/span/a")).size();
		for (int index = 1; index <= pages; index++) {
			int rows = driver.findElements(By.xpath("//table[@id='example']/tbody/tr")).size();
			for (int innerIndex = 1; innerIndex <= rows; innerIndex++) {
				String employeeName = driver
						.findElement(By.xpath("//table[@id='example']/tbody/tr[" + innerIndex + "]/td[2]")).getText();
				employeeNameList.add(employeeName);
			}
			driver.findElement(By.xpath("//a[@id='example_next']")).click();
		}
		if (pages > 0)
			driver.findElement(By.xpath("//div[@id='example_paginate']/span/a[1]")).click();
		return employeeNameList;
	}

	ArrayList<String> getPositionAfterSorting() {
		ArrayList<String> employeeNameList = new ArrayList<String>();
		driver.findElement(By.xpath("//table[@id='example']/thead/tr/th[2]")).click();
		int pages = driver.findElements(By.xpath("//div[@id='example_paginate']/span/a")).size();
		for (int index = 1; index <= pages; index++) {
			int rows = driver.findElements(By.xpath("//table[@id='example']/tbody/tr")).size();
			for (int innerIndex = 1; innerIndex <= rows; innerIndex++) {
				String employeeName = driver
						.findElement(By.xpath("//table[@id='example']/tbody/tr[" + innerIndex + "]/td[2]")).getText();
				employeeNameList.add(employeeName);
			}
			driver.findElement(By.xpath("//a[@id='example_next']")).click();
		}
		if (pages > 0)
			driver.findElement(By.xpath("//div[@id='example_paginate']/span/a[1]")).click();
		driver.findElement(By.xpath("//table[@id='example']/thead/tr/th[1]")).click();
		return employeeNameList;
	}

	@Test
	void verifyOfficeLocation() {
		Set<String> actualOfficeLocations = getUniqueOfficeLocation();
		System.out.println(actualOfficeLocations);
		Set<String> expectedOfficeLocations = new HashSet<String>();
		expectedOfficeLocations.add("San Francisco");
		expectedOfficeLocations.add("New York");
		expectedOfficeLocations.add("Singapore");
		expectedOfficeLocations.add("Tokyo");
		expectedOfficeLocations.add("London");
		expectedOfficeLocations.add("Edinburgh");
		expectedOfficeLocations.add("Sydney");
		Assert.assertEquals(actualOfficeLocations, expectedOfficeLocations);
	}

	@Test
	void verifyPositionWiseEmployeeCount() {
		Map<String, Integer> actualMap = getPositionWiseEmployeeCount();
		System.out.println(actualMap);
		int totalEmployee = 0;
		for (String key : actualMap.keySet())
			totalEmployee += actualMap.get(key);
		Assert.assertEquals(totalEmployee, 57);
	}

	@Test
	void maxAndMinPositions() {
		String[] actualDepartment = getPositionHavingHighestAndLowestEmployeeCount();
		System.out.println(Arrays.toString(actualDepartment));
		String departmentHavingMaxEmployee = actualDepartment[1];
		Assert.assertEquals(departmentHavingMaxEmployee, "Software Engineer");
	}

	@Test
	void verifySortingByName() {
		ArrayList<String> employeeListBeforeSorting = getEmployeeNameBeforeSorting();
		ArrayList<String> actualList = getEmployeeNameAfterSorting();
		Collections.sort(employeeListBeforeSorting, Collections.reverseOrder());
		Assert.assertEquals(employeeListBeforeSorting, actualList);
	}
	
	@Test
	void verifyPositionSorting() {
		ArrayList<String> positionListBeforeSorting = getPositionBeforeSorting();
		ArrayList<String> actualList = getPositionAfterSorting();
		Collections.sort(positionListBeforeSorting);
		Assert.assertEquals(positionListBeforeSorting, actualList);
	}

	@AfterClass
	void closeThePage() {
		driver.close();
	}

}
