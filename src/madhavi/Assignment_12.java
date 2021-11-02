package madhavi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
/*Program 1 : Find unique Office location by navigating throw all pages.

program 2: print position per employee count by navigating throw all pages. 

Program 3: find out the position with highest and lowest employees. 

program 4 : sorting works on employee name or not. 

program 5 : verfiy sorting works on position. */
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Assignment_12 {
	WebDriver driver;

	@BeforeClass
	public void startBrowser() {
		System.setProperty("webdriver.chrome.driver", "./resources/chromedriver.exe");
		System.out.println("STEP1 : Launch Browser");
		driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://datatables.net/extensions/autofill/examples/initialisation/focus.html");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	// Find unique Office location by navigating throw all pages.
	@Test(priority = 1)
	void getUniqueOfficeLocation() {
		System.out.println("STEP3 :Get unique Office location by navigating throw all pages..");
		HashSet<String> set = new HashSet<>();
		int noOfPages = driver.findElements(By.xpath("//div[@id='example_paginate']/span/a")).size();
		for (int index = 1; index <= noOfPages; index++) {
			int rowCount = driver.findElements(By.xpath("//table[@class='display nowrap dataTable']/tbody/tr")).size();
			for (int index1 = 1; index1 <= rowCount; index1++) {
				String location = driver
						.findElement(
								By.xpath("//table[@class='display nowrap dataTable']/tbody/tr[" + index1 + "]/td[3]"))
						.getText();
				set.add(location);
			}
			driver.findElement(By.xpath("//a[@id='example_next']")).click();
		}
		if (noOfPages > 0)
			driver.findElement(By.xpath("//div[@id='example_paginate']/span/a[1]")).click();
		System.out.println(set);
		Set<String> actualSets = set;
		Set<String> expectedSets = new HashSet<String>();
		expectedSets.add("San Francisco");
		expectedSets.add("New York");
		expectedSets.add("Singapore");
		expectedSets.add("Tokyo");
		expectedSets.add("London");
		expectedSets.add("Edinburgh");
		expectedSets.add("Sydney");
		System.out.println("Test verification is done");
		Assert.assertEquals(actualSets, expectedSets);
	}

	// program 2: print position per employee count by navigating throw all pages.
	@Test(priority = 2)
	LinkedHashMap<String, Integer> getPositionPerEmpCount() {
		System.out.println("STEP3 :Print position per employee count by navigating throw all pages. .");
		LinkedHashMap<String, Integer> mapCount = new LinkedHashMap<>();
		int noOfPages = driver.findElements(By.xpath("//div[@id='example_paginate']/span/a")).size();
		for (int index = 1; index <= noOfPages; index++) {
			int rowCount = driver.findElements(By.xpath("//table[@class='display nowrap dataTable']/tbody/tr")).size();
			for (int index1 = 1; index1 <= rowCount; index1++) {
				String position = driver
						.findElement(
								By.xpath("//table[@class='display nowrap dataTable']/tbody/tr[" + index1 + "]/td[2]"))
						.getText();
				if (mapCount.containsKey(position))
					mapCount.put(position, mapCount.get(position) + 1);
				else
					mapCount.put(position, 1);
			}
			driver.findElement(By.xpath("//a[@id='example_next']")).click();
		}
		if (noOfPages > 0)
			driver.findElement(By.xpath("//div[@id='example_paginate']/span/a[1]")).click();
		return mapCount;
	}

	@Test
	void verifyPositionPerEmpCount() {
		Map<String, Integer> actualResultMap = getPositionPerEmpCount();
		System.out.println(actualResultMap);
		int totalEmployee = 0;
		// String expectedResultmap="57";
		for (String key : actualResultMap.keySet())
			totalEmployee = totalEmployee + actualResultMap.get(key);
		Assert.assertEquals(totalEmployee, 57);
	}

	// Program 3: find out the position with highest and lowest employees.
	@Test(priority = 3)
	String[] getHighestLowestPosition() {
		System.out.println("STEP3 :Find out the position with highest and lowest employees");
		LinkedHashMap<String, Integer> map = getPositionPerEmpCount();
		String[] output = { "", "" };
		ArrayList<String> listOfPositions = new ArrayList<>(map.keySet());
		int max = map.get(listOfPositions.get(0));
		int min = map.get(listOfPositions.get(0));
		output[0] = listOfPositions.get(0);
		output[1] = listOfPositions.get(0);
		for (int index = 1; index < listOfPositions.size(); index++) {
			String dept = listOfPositions.get(index);
			int deptEmp = map.get(dept);
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

	@Test
	void maxAndMinPositions() {
		String[] actualDepartment = getHighestLowestPosition();
		System.out.println(Arrays.toString(actualDepartment));
		String departmentHavingMaxEmployee = actualDepartment[1];
		Assert.assertEquals(departmentHavingMaxEmployee, "Software Engineer");
		String departmentHavingMinEmployee = actualDepartment[0];
		Assert.assertEquals(departmentHavingMinEmployee, "Chief Executive Officer (CEO)");
	}
	// sorting works on employee name or not.
	ArrayList<String> getEmployeeNameBeforeSorting() {
		List<String> employeeNameList = new ArrayList<String>();
		int noOfPages = driver.findElements(By.xpath("//div[@id='example_paginate']/span/a")).size();
		for (int index = 1; index <= noOfPages; index++) {
			int rowCount = driver.findElements(By.xpath("//table[@id='example']/tbody/tr")).size();
			for (int innerIndex = 1; innerIndex <= rowCount; innerIndex++) {
				String employeeName = driver
						.findElement(By.xpath("//table[@id='example']/tbody/tr[" + innerIndex + "]/td[1]")).getText();
				employeeNameList.add(employeeName);
			}
			driver.findElement(By.xpath("//a[@id='example_next']")).click();
		}
		if (noOfPages > 0)
			driver.findElement(By.xpath("//div[@id='example_paginate']/span/a[1]")).click();
		return (ArrayList<String>) employeeNameList;
	}

	ArrayList<String> getEmployeeNameAfterSorting() {
		List<String> employeeNameList = new ArrayList<String>();
		driver.findElement(By.xpath("//table[@id='example']/thead/tr/th[1]")).click();
		int noOfPages = driver.findElements(By.xpath("//div[@id='example_paginate']/span/a")).size();
		for (int index = 1; index <= noOfPages; index++) {
			int rowCount = driver.findElements(By.xpath("//table[@id='example']/tbody/tr")).size();
			for (int index1 = 1; index1 <= rowCount; index1++) {
				String employeeName = driver
						.findElement(By.xpath("//table[@id='example']/tbody/tr[" + index1 + "]/td[1]")).getText();
				employeeNameList.add(employeeName);
			}
			driver.findElement(By.xpath("//a[@id='example_next']")).click();
		}
		if (noOfPages > 0)
			driver.findElement(By.xpath("//div[@id='example_paginate']/span/a[1]")).click();
		driver.findElement(By.xpath("//table[@id='example']/thead/tr/th[1]")).click();
		return (ArrayList<String>) employeeNameList;
	}

	@Test(priority = 4)
	void verifySortingByName() {
		System.out.println("STEP3 :: verfiy sorting works on employee sName.");
		ArrayList<String> employeeBeforeSortinglist = getEmployeeNameBeforeSorting();
		ArrayList<String> actualList = getEmployeeNameAfterSorting();
		Collections.sort(employeeBeforeSortinglist, Collections.reverseOrder());
		Assert.assertEquals(employeeBeforeSortinglist, actualList);
	}

	// program 5 : verfiy sorting works on position.
	List<String> getPositionBeforeSorting() {
		ArrayList<String> employeeNameList = new ArrayList<String>();
		int noOfPages = driver.findElements(By.xpath("//div[@id='example_paginate']/span/a")).size();
		for (int index = 1; index <= noOfPages; index++) {
			int rowCount = driver.findElements(By.xpath("//table[@id='example']/tbody/tr")).size();
			for (int index1 = 1; index1 <= rowCount; index1++) {
				String employeeName = driver
						.findElement(By.xpath("//table[@id='example']/tbody/tr[" + index1 + "]/td[2]")).getText();
				employeeNameList.add(employeeName);
			}
			driver.findElement(By.xpath("//a[@id='example_next']")).click();
		}
		if (noOfPages > 0)
			driver.findElement(By.xpath("//div[@id='example_paginate']/span/a[1]")).click();
		return employeeNameList;
	}

	List<String> getPositionAfterSorting() {
		ArrayList<String> employeeNameList = new ArrayList<String>();
		driver.findElement(By.xpath("//table[@id='example']/thead/tr/th[2]")).click();
		int noOfPages = driver.findElements(By.xpath("//div[@id='example_paginate']/span/a")).size();
		for (int index = 1; index <= noOfPages; index++) {
			int rowCount = driver.findElements(By.xpath("//table[@id='example']/tbody/tr")).size();
			for (int index1 = 1; index1 <= rowCount; index1++) {
				String employeeName = driver
						.findElement(By.xpath("//table[@id='example']/tbody/tr[" + index1 + "]/td[2]")).getText();
				employeeNameList.add(employeeName);
			}
			driver.findElement(By.xpath("//a[@id='example_next']")).click();
		}
		if (noOfPages > 0)
			driver.findElement(By.xpath("//div[@id='example_paginate']/span/a[1]")).click();
		driver.findElement(By.xpath("//table[@id='example']/thead/tr/th[1]")).click();
		return employeeNameList;
	}

	@Test(priority = 5)
	void verifyPositionSorting() {
		System.out.println("STEP3 :: Verfiy sorting works on position.");
		ArrayList<String> positionBeforeSortingList = (ArrayList<String>) getPositionBeforeSorting();
		ArrayList<String> actualList = (ArrayList<String>) getPositionAfterSorting();
		Collections.sort(positionBeforeSortingList);
		Assert.assertEquals(positionBeforeSortingList, actualList);
	}

	@AfterClass
	public void closeBrowser() {
		driver.quit();
	}
}
