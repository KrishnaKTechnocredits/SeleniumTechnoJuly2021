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

public class Assignment_10 {

	WebDriver driver;

	@BeforeClass
	void LaunchBrowser() {
		driver = PredefinedActions.start();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.linkText("Demo Tables")).click();
	}

	HashMap<Integer, ArrayList<String>> getEmployeeDetailsManagerIdWise() {
		HashMap<Integer, ArrayList<String>> employeeDetailsMap = new HashMap<Integer, ArrayList<String>>();
		int rows = driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr")).size();
		for (int index = 1; index <= rows; index++) {
			int managerID = Integer.parseInt(
					driver.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr[" + index + "]/td[4]"))
							.getText());
			String employeeName = driver.findElement(By.xpath(
					"//table[@class='table table-striped']/tbody/tr[" + index + "]/td[4]/preceding-sibling::td[1]"))
					.getText();
			if (employeeDetailsMap.containsKey(managerID)) {
				ArrayList<String> employeeNames = employeeDetailsMap.get(managerID);
				employeeNames.add(employeeName);
				employeeDetailsMap.put(managerID, employeeNames);
			} else {
				ArrayList<String> employeeNames = new ArrayList<String>();
				employeeNames.add(employeeName);
				employeeDetailsMap.put(managerID, employeeNames);
			}
		}
		return employeeDetailsMap;
	}

	@Test
	void verifyEmployeeNamesManagerWise() {
		HashMap<Integer, ArrayList<String>> actualEmployeeDetails = getEmployeeDetailsManagerIdWise();
		HashMap<Integer, ArrayList<String>> expecctedEmployeeDetails = new HashMap<Integer, ArrayList<String>>();
		ArrayList<String> employeeListForManager20209 = new ArrayList<String>();
		employeeListForManager20209.add("Abhijit Mane");
		employeeListForManager20209.add("Sumit Kulkarni");
		employeeListForManager20209.add("Pawan Belamkar");
		expecctedEmployeeDetails.put(20209, employeeListForManager20209);
		ArrayList<String> employeeListForManager20205 = new ArrayList<String>();
		employeeListForManager20205.add("Sumit Mate");
		employeeListForManager20205.add("Prayag Mokate");
		employeeListForManager20205.add("Sumit Mate");
		employeeListForManager20205.add("Nikhil Patne");
		expecctedEmployeeDetails.put(20205, employeeListForManager20205);
		ArrayList<String> employeeListForManager10101 = new ArrayList<String>();
		employeeListForManager10101.add("Chetan Shewale");
		employeeListForManager10101.add("Priyanka Bhale");
		expecctedEmployeeDetails.put(10101, employeeListForManager10101);
		Assert.assertEquals(expecctedEmployeeDetails, actualEmployeeDetails);
	}

	@AfterClass
	void browserClose() {
		driver.close();
	}
}
