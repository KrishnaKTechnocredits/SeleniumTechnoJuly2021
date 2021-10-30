/*
 * Assginment - 9 : 24th Oct'2021
Verify Employee count and Employee name in each deptment.

Sample Output: Employee Count in 7001-Admin dept.
               Employee name belongs to 7001-Admin dept.
 */
package husain.Assignment9;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.PredefinedActions;

public class EmpNameAndCount {

	WebDriver driver;

	@BeforeMethod
	void setup() throws InterruptedException {
		driver = PredefinedActions.start();
		driver.findElement(By.linkText("Demo Tables")).click();
		Thread.sleep(3000);
	}

	HashMap<String, ArrayList<String>> getDeptMap() {
		WebElement table = driver.findElement(By.xpath("//table[@class='table table-striped']/tbody"));
		int rowCount = table.findElements(By.tagName("tr")).size();
		HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
		for (int index = 1; index <= rowCount; index++) {
			String dept = driver
					.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr[" + index + "]/td[5]"))
					.getText();
			if (map.containsKey(dept)) {
				String name = driver
						.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr[" + index + "]/td[3]"))
						.getText();
				ArrayList<String> currList = map.get(dept);
				currList.add(name);
				map.put(dept, currList);
			} else {
				ArrayList<String> empList = new ArrayList<String>();
				String name = driver
						.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr[" + index + "]/td[3]"))
						.getText();
				empList.add(name);
				map.put(dept, empList);
			}
		}
		System.out.println(map);
		return map;
	}

	@Test
	void validateDeptMap() {
		HashMap<String, ArrayList<String>> map = getDeptMap();
		Set<String> set = map.keySet();
		ArrayList<String> actualList = new ArrayList<String>();
		ArrayList<String> expectedList = new ArrayList<String>();
		SoftAssert sassert = new SoftAssert();
		for (String deptName : set) {
			if (deptName.equals("7001-Admin")) {
				int actualEmpCount = map.get(deptName).size();
				int expectedEmpCount = 2;
				actualList = map.get(deptName);
				expectedList.add("Abhijit Mane");
				expectedList.add("Prayag Mokate");
				System.out.println("Employee Count in 7001-Admin dept table is " + actualEmpCount);
				System.out.println("Employees in 7001-Admin dept table are " + actualList);
				sassert.assertEquals(actualEmpCount, expectedEmpCount, "Admin Count does not match.");
				sassert.assertEquals(actualList, expectedList, "Admin department employee list does not match.");
				actualList.clear();
				expectedList.clear();
			} else if (deptName.equals("7002-Finance")) {
				int actualEmpCount = map.get(deptName).size();
				int expectedEmpCount = 2;
				actualList = map.get(deptName);
				expectedList.add("Sumit Mate");
				expectedList.add("Sumit Mate");
				System.out.println("Employee Count in 7002-Finance dept table is " + actualEmpCount);
				System.out.println("Employees in 7002-Finance dept table are " + actualList);
				sassert.assertEquals(actualEmpCount, expectedEmpCount, "Finance Count does not match.");
				sassert.assertEquals(actualList, expectedList, "Finance department employee list does not match.");
				actualList.clear();
				expectedList.clear();
			} else if (deptName.equals("7003-HR")) {
				int actualEmpCount = map.get(deptName).size();
				int expectedEmpCount = 2;
				actualList = map.get(deptName);
				expectedList.add("Sumit Kulkarni");
				expectedList.add("Pawan Belamkar");
				System.out.println("Employee Count in 7003-HR dept table is " + actualEmpCount);
				System.out.println("Employees in 7003-HR dept table are " + actualList);
				sassert.assertEquals(actualEmpCount, expectedEmpCount, "HR Count does not match.");
				sassert.assertEquals(actualList, expectedList, "HR department employee list does not match.");
				actualList.clear();
				expectedList.clear();
			} else if (deptName.equals("7013-IT")) {
				int actualEmpCount = map.get(deptName).size();
				int expectedEmpCount = 3;
				actualList = map.get(deptName);
				expectedList.add("Nikhil Patne");
				expectedList.add("Chetan Shewale");
				expectedList.add("Priyanka Bhale");
				System.out.println("Employee Count in 7013-IT dept table is " + actualEmpCount);
				System.out.println("Employees in 7013-IT dept table are " + actualList);
				sassert.assertEquals(actualEmpCount, expectedEmpCount, "IT Count does not match.");
				sassert.assertEquals(actualList, expectedList, "IT department employee list does not match.");
				actualList.clear();
				expectedList.clear();
			}
			sassert.assertAll();
		}

	}

	@AfterMethod
	void windingDown() {
		driver.close();
	}

}
