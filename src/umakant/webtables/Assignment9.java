/*
 Verfiy Employee count and Employee name in each deptment.

Sample Output: Employee Count in 7001-Admin dept.
               Employee name belongs to 7001-Admin dept.
 */
package umakant.webtables;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.PredefinedActions;

public class Assignment9 {

	WebDriver driver;

	@BeforeClass
	void LaunchBrowser() {
		driver = PredefinedActions.start();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.linkText("Demo Tables")).click();
	}

	HashMap<String, ArrayList<String>> getEmployeeDetailsDepartmentWise() {
		HashMap<String, ArrayList<String>> employeeDetailsMap = new HashMap<String, ArrayList<String>>();
		int rows = driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr")).size();
		for (int index = 1; index <= rows; index++) {
			String departmentName = driver
					.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr[" + index + "]/td[5]"))
					.getText();
			String employeeName = driver.findElement(By.xpath(
					"//table[@class='table table-striped']/tbody/tr[" + index + "]/td[5]/preceding-sibling::td[2]"))
					.getText();
			if (employeeDetailsMap.containsKey(departmentName)) {
				ArrayList<String> employeeNames = employeeDetailsMap.get(departmentName);
				employeeNames.add(employeeName);
				employeeDetailsMap.put(departmentName, employeeNames);
			} else {
				ArrayList<String> employeeNames = new ArrayList<String>();
				employeeNames.add(employeeName);
				employeeDetailsMap.put(departmentName, employeeNames);
			}
		}
		return employeeDetailsMap;
	}

	@Test
	void verifyEmployeeNamesDepartmentWise() {
		HashMap<String, ArrayList<String>> actualEmployeeDetails = getEmployeeDetailsDepartmentWise();
		HashMap<String, ArrayList<String>> expecctedEmployeeDetails = new HashMap<String, ArrayList<String>>();
		ArrayList<String> adminEmployeeList = new ArrayList<String>();
		adminEmployeeList.add("Abhijit Mane");
		adminEmployeeList.add("Prayag Mokate");
		expecctedEmployeeDetails.put("7001-Admin", adminEmployeeList);
		ArrayList<String> financeEmployeeList = new ArrayList<String>();
		financeEmployeeList.add("Sumit Mate");
		financeEmployeeList.add("Sumit Mate");
		expecctedEmployeeDetails.put("7002-Finance", financeEmployeeList);
		ArrayList<String> hrEmployeeList = new ArrayList<String>();
		hrEmployeeList.add("Sumit Kulkarni");
		hrEmployeeList.add("Pawan Belamkar");
		expecctedEmployeeDetails.put("7003-HR", hrEmployeeList);
		ArrayList<String> itEmployeeList = new ArrayList<String>();
		itEmployeeList.add("Nikhil Patne");
		itEmployeeList.add("Chetan Shewale");
		itEmployeeList.add("Priyanka Bhale");
		expecctedEmployeeDetails.put("7013-IT", itEmployeeList);
		Assert.assertEquals(expecctedEmployeeDetails, actualEmployeeDetails);
	}

	@AfterClass
	void browserClose() {
		driver.close();
	}
}
