/*
 * Program 1: Return unique Employees from table-2.  
output : size - 8

Program 2: print employee id which is duplicate in table-2 
output : 76585 

Program 3: print the name of deptment having maximum employees. 
output : 7013-IT
 */
package umakant.webtables;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.PredefinedActions;

public class Assignment11 {

	WebDriver driver;

	@BeforeClass
	void LaunchBrowser() {
		driver = PredefinedActions.start();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.linkText("Demo Tables")).click();
	}

	int getUniqueEmployeeCount() {
		HashSet<String> employeeSet = new HashSet<String>();
		int rows = driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr")).size();
		for (int index = 1; index <= rows; index++) {
			String employee = driver
					.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr[" + index + "]/td[3]"))
					.getText();
			employeeSet.add(employee);
		}
		return employeeSet.size();
	}

	HashSet<Integer> getDuplicateEmployeeID() {
		List<Integer> employeeIdList = new ArrayList<Integer>();
		HashSet<Integer> duplicateIDSet = new HashSet<Integer>();
		int rows = driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr")).size();
		for (int index = 1; index <= rows; index++) {
			int id = Integer.parseInt(
					driver.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr[" + index + "]/td[2]"))
							.getText());
			if (employeeIdList.contains(id))
				duplicateIDSet.add(id);
			else
				employeeIdList.add(id);
		}
		return duplicateIDSet;
	}

	String getDepartmentHavingMaximumEmployee() {
		String department = "";
		int max = 1;
		Map<String, Integer> departmentEmployeeMap = new HashMap<String, Integer>();
		int rows = driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr")).size();
		for (int index = 1; index <= rows; index++) {
			String dep = driver
					.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr[" + index + "]/td[5]"))
					.getText();
			if (departmentEmployeeMap.containsKey(dep)) {
				int employeeCount = departmentEmployeeMap.get(dep) + 1;
				departmentEmployeeMap.put(dep, employeeCount);
				if (employeeCount > max) {
					max = employeeCount;
					department = dep;
				}
			} else
				departmentEmployeeMap.put(dep, 1);
		}
		return department;
	}

	@Test
	void verifyUniqueEmployeeCount() {
		int actualSet = getUniqueEmployeeCount();
		int expectedSet = 8;
		Assert.assertEquals(actualSet, expectedSet);
	}

	@Test
	void verifyDuplicateEmployeeIdList() {
		HashSet<Integer> actualSet = getDuplicateEmployeeID();
		HashSet<Integer> expectedSet = new HashSet<Integer>();
		expectedSet.add(76585);
		Assert.assertEquals(actualSet, expectedSet);
	}

	@Test
	void verifyMaxEmployeeDepartment() {
		String actualDepartment = getDepartmentHavingMaximumEmployee();
		String expectedDepartment = "7013-IT";
		Assert.assertEquals(actualDepartment, expectedDepartment);
	}

	@AfterClass
	void browserClose() {
		driver.close();
	}
}
