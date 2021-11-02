package monali.webtables;
/*Assginment - 9 : 24th Oct'2021
Verfiy Employee count and Employee name in each deptment.

Sample Output: Employee Count in 7001-Admin dept.
               Employee name belongs to 7001-Admin dept.*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.PredefinedActions;

public class Assignment_9 {

	WebDriver driver;

	@BeforeMethod
	void launchBrowser() {
		driver = PredefinedActions.start();
		driver.findElement(By.xpath("//a[contains(text(),'Demo Tables')]")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@AfterMethod
	void tearDown() {
		driver.close();
	}

	HashMap<String, ArrayList<String>> getEmployeeDetailsAsPerDept() {
		int rowsCount = driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr")).size();

		HashMap<String, ArrayList<String>> empDeptMap = new HashMap<>();
		for (int index = 1; index <= rowsCount; index++) {
			String deptName = driver
					.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr[" + index + "]/td[5]"))
					.getText();
			String empName = driver.findElement(By.xpath(
					"//table[@class='table table-striped']/tbody/tr[" + index + "]/td[5]/preceding-sibling::td[2]"))
					.getText();
			if (empDeptMap.containsKey(deptName)) {
				ArrayList<String> employeeList = empDeptMap.get(deptName);
				employeeList.add(empName);
				empDeptMap.put(deptName, employeeList);
			} else {
				ArrayList<String> employeeList = new ArrayList<String>();
				employeeList.add(empName);
				empDeptMap.put(deptName, employeeList);
			}
		}
		return empDeptMap;
	}

	@Test
	void verifyEmployeeNameAsPerDept() {
		HashMap<String, ArrayList<String>> actualEmpList = getEmployeeDetailsAsPerDept();
		HashMap<String, ArrayList<String>> expectedEmpList = new HashMap<>();

		ArrayList<String> adminEmployeeList = new ArrayList<String>();
		adminEmployeeList.add("Abhijit Mane");
		adminEmployeeList.add("Prayag Mokate");
		expectedEmpList.put("7001-Admin", adminEmployeeList);
		ArrayList<String> financeEmployeeList = new ArrayList<String>();
		financeEmployeeList.add("Sumit Mate");
		financeEmployeeList.add("Sumit Mate");
		expectedEmpList.put("7002-Finance", financeEmployeeList);
		ArrayList<String> hrEmployeeList = new ArrayList<String>();
		hrEmployeeList.add("Sumit Kulkarni");
		hrEmployeeList.add("Pawan Belamkar");
		expectedEmpList.put("7003-HR", hrEmployeeList);
		ArrayList<String> itEmployeeList = new ArrayList<String>();
		itEmployeeList.add("Nikhil Patne");
		itEmployeeList.add("Chetan Shewale");
		itEmployeeList.add("Priyanka Bhale");
		expectedEmpList.put("7013-IT", itEmployeeList);
		System.out.println("Actual Emp List : "+actualEmpList);
		System.out.println("Actual Emp List : "+expectedEmpList);
		Assert.assertEquals(expectedEmpList, actualEmpList);
	}
}
