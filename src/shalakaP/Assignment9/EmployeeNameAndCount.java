/*Assginment - 9 : 24th Oct'2021
Verfiy Employee count and Employee name in each deptment.

Sample Output: Employee Count in 7001-Admin dept.
               Employee name belongs to 7001-Admin dept.*/
package shalakaP.Assignment9;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.PredefinedActions;

public class EmployeeNameAndCount {

	WebDriver driver;

	@BeforeClass
	void start() {
		System.out.println("Step-Open Browser");
		System.out.println("Step-Click on given url");
		driver = PredefinedActions.start();
		System.out.println("Step-Click on Demo Tables");
		driver.findElement(By.linkText("Demo Tables")).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

	}

	HashMap<String, ArrayList<String>> getEmployeeNameAndDeptName() {
		HashMap<String, ArrayList<String>> deptMap = new HashMap<String, ArrayList<String>>();
		int rowCnt = driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr")).size();
		for (int index = 1; index <= rowCnt; index++) {
			String deptName = driver
					.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr[" + index + "]/td[5]"))
					.getText();
			String empName = driver.findElement(By.xpath(
					"//table[@class='table table-striped']/tbody/tr[" + index + "]/td[5]/preceding-sibling::td[2]"))
					.getText();

			if (deptMap.containsKey(deptName)) {
				ArrayList<String> currentList = deptMap.get(deptName);
				currentList.add(empName);
				deptMap.put(deptName, currentList);
			} else {
				ArrayList<String> empList = new ArrayList<String>();
				empList.add(empName);
				deptMap.put(deptName, empList);
			}

		}
		return deptMap;
	}

	@Test
	public void verifyEmpName() {
		HashMap<String, ArrayList<String>> deptEmpName = getEmployeeNameAndDeptName();
		System.out.println("Step-Print employee list and employee count in dept 7001-Admin");
		ArrayList<String> actualAdminEmpList = deptEmpName.get("7001-Admin");
		System.out.println("Emp list- " + actualAdminEmpList + " & Emp count- " + actualAdminEmpList.size() + " in dept 7001-Admin");
		Assert.assertTrue(actualAdminEmpList.size() == 2);

		ArrayList<String> expectedAdminEmpList = new ArrayList<String>();
		expectedAdminEmpList.add("Abhijit Mane");
		expectedAdminEmpList.add("Prayag Mokate");
		Assert.assertEquals(actualAdminEmpList, expectedAdminEmpList);

		ArrayList<String> actualFinanceEmpList = deptEmpName.get("7002-Finance");
		System.out.println("Step-Print employee list and employee count in dept 7001-Finance");
		System.out.println("Emp list- " + actualFinanceEmpList + " & Emp count- " + actualFinanceEmpList.size() + " in dept 7001-Finance");
		Assert.assertTrue(actualFinanceEmpList.size() == 2);

		ArrayList<String> expectedFinanceEmpList = new ArrayList<String>();
		expectedFinanceEmpList.add("Sumit Mate");
		expectedFinanceEmpList.add("Sumit Mate");
		Assert.assertEquals(actualFinanceEmpList, expectedFinanceEmpList);

		ArrayList<String> actualHREmpList = deptEmpName.get("7003-HR");
		System.out.println("Step-Print employee list and employee count in dept 7001-HR");
		System.out.println("Emp list- " + actualHREmpList + " & Emp count- " + actualHREmpList.size() + " in dept 7001-HR");
		Assert.assertTrue(actualHREmpList.size() == 2);

		ArrayList<String> expectedHREmpList = new ArrayList<String>();
		expectedHREmpList.add("Sumit Kulkarni");
		expectedHREmpList.add("Pawan Belamkar");
		Assert.assertEquals(actualHREmpList, expectedHREmpList);

		ArrayList<String> actualITEmpList= deptEmpName.get("7013-IT");
		System.out.println("Step-Print employee list and employee count in dept 7001-IT");
		System.out.println("Emp list- " + actualITEmpList + " & Emp count- " + actualITEmpList.size() + " in dept 7001-IT");
		Assert.assertTrue(actualITEmpList.size() == 3);

		ArrayList<String> expectedITEmpList = new ArrayList<String>();
		expectedITEmpList.add("Nikhil Patne");
		expectedITEmpList.add("Chetan Shewale");
		expectedITEmpList.add("Priyanka Bhale");
		Assert.assertEquals(actualITEmpList, expectedITEmpList);
	}
}
