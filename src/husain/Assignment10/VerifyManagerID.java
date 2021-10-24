/*
 * Assginment - 10 : 24th Oct'2021
Similar to Assignment-9 but verification should be against managerid.

Sample Output: Employee Count reports to manager having manager id - 20209.
               Employee name reports to manager having manager id - 20209.
}

 */
package husain.Assignment10;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.PredefinedActions;

public class VerifyManagerID {

	WebDriver driver;

	@BeforeMethod
	void setup() {
		driver = PredefinedActions.start();
		driver.findElement(By.linkText("Demo Tables")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	HashMap<String, ArrayList<String>> getDeptMap() {

		HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
		int rowCount = driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr")).size();
		for (int index = 1; index <= rowCount; index++) {
			String managerID = driver
					.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr[" + index + "]/td[4]"))
					.getText();
			if (map.containsKey(managerID)) {
				String name = driver
						.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr[" + index + "]/td[3]"))
						.getText();
				ArrayList<String> currList = map.get(managerID);
				currList.add(name);
				map.put(managerID, currList);
			}

			else {
				ArrayList<String> empList = new ArrayList<String>();
				String name = driver
						.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr[" + index + "]/td[3]"))
						.getText();
				empList.add(name);
				map.put(managerID, empList);
			}

		}

		System.out.println(map);
		return map;

	}

	@Test
	void verifyIDAndName() {
		HashMap<String, ArrayList<String>> map = getDeptMap();
		Set<String> set = map.keySet();

		ArrayList<String> actualList = new ArrayList<String>();
		ArrayList<String> expectedList = new ArrayList<String>();
		SoftAssert sassert = new SoftAssert();
		for (String deptName : set) {
			if (deptName.equals("20209")) {
				int actualEmpCount = map.get(deptName).size();
				int expectedEmpCount = 3;
				actualList = map.get(deptName);
				expectedList.add("Abhijit Mane");
				expectedList.add("Sumit Kulkarni");
				expectedList.add("Pawan Belamkar");
				System.out.println("Employee Count reports to manager id 20209 is " + actualEmpCount);
				System.out.println("Employees name reports to manager id 20209 is " + actualList);
				sassert.assertEquals(actualEmpCount, expectedEmpCount, "20209 Count does not match.");
				sassert.assertEquals(actualList, expectedList, "20209 employee list does not match.");
				actualList.clear();
				expectedList.clear();
			} else if (deptName.equals("20205")) {
				int actualEmpCount = map.get(deptName).size();
				int expectedEmpCount = 4;
				actualList = map.get(deptName);
				expectedList.add("Sumit Mate");
				expectedList.add("Prayag Mokate");
				expectedList.add("Sumit Mate");
				expectedList.add("Nikhil Patne");
				System.out.println("Employee Count reports to manager id 20205 is " + actualEmpCount);
				System.out.println("Employee Count reports to manager id 20205 is " + actualList);
				sassert.assertEquals(actualEmpCount, expectedEmpCount, "20205 Count does not match.");
				sassert.assertEquals(actualList, expectedList, "20205 employee list does not match.");
				actualList.clear();
				expectedList.clear();
			} else if (deptName.equals("10101")) {
				int actualEmpCount = map.get(deptName).size();
				int expectedEmpCount = 2;
				actualList = map.get(deptName);
				expectedList.add("Chetan Shewale");
				expectedList.add("Priyanka Bhale");
				System.out.println("Employee Count reports to manager id 10101 is " + actualEmpCount);
				System.out.println("Employee Count reports to manager id 10101 is " + actualList);
				sassert.assertEquals(actualEmpCount, expectedEmpCount, "10101 Count does not match.");
				sassert.assertEquals(actualList, expectedList, "10101 employee list does not match.");
				actualList.clear();
				expectedList.clear();
			}
		}
		sassert.assertAll();
	}

	@AfterMethod
	void windingDown() {
		driver.close();
	}
}
