package monali.webtables;

import java.util.ArrayList;
import java.util.HashMap;
/*Assginment - 10 : 24th Oct'2021
Similar to Assignment-9 but verification should be against managerid.

Sample Output: Employee Count reports to manager having manager id - 20209.
*/
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.PredefinedActions;

public class Assignment_10 {

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

	HashMap<Integer, ArrayList<String>> getEmpAsPerManagerId() {
		int rowsCount = driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr")).size();

		HashMap<Integer, ArrayList<String>> empManagerMap = new HashMap<>();

		for (int index = 1; index <= rowsCount; index++) {
			int managerId = Integer.parseInt(
					driver.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr[" + index + "]/td[4]"))
							.getText());
			String empName = driver.findElement(By.xpath(
					"//table[@class='table table-striped']/tbody/tr[" + index + "]/td[4]/preceding-sibling::td[1]"))
					.getText();
			if (empManagerMap.containsKey(managerId)) {
				ArrayList<String> EmployeeNames = empManagerMap.get(managerId);
				EmployeeNames.add(empName);
				empManagerMap.put(managerId, EmployeeNames);
			} else {
				ArrayList<String> EmployeeNames = new ArrayList<String>();
				EmployeeNames.add(empName);
				empManagerMap.put(managerId, EmployeeNames);
			}
		}
		return empManagerMap;
	}

	@Test
	void verifyEmployeeNamesAsPerManager() {
		HashMap<Integer, ArrayList<String>> actualEmployeeDetails = getEmpAsPerManagerId();
		HashMap<Integer, ArrayList<String>> ExpectedEmployees = new HashMap<Integer, ArrayList<String>>();
		ArrayList<String> empListForManager20209 = new ArrayList<String>();
		empListForManager20209.add("Abhijit Mane");
		empListForManager20209.add("Sumit Kulkarni");
		empListForManager20209.add("Pawan Belamkar");
		ExpectedEmployees.put(20209, empListForManager20209);
		ArrayList<String> employeeListForManager20205 = new ArrayList<String>();
		employeeListForManager20205.add("Sumit Mate");
		employeeListForManager20205.add("Prayag Mokate");
		employeeListForManager20205.add("Sumit Mate");
		employeeListForManager20205.add("Nikhil Patne");
		ExpectedEmployees.put(20205, employeeListForManager20205);
		ArrayList<String> employeeListForManager10101 = new ArrayList<String>();
		employeeListForManager10101.add("Chetan Shewale");
		employeeListForManager10101.add("Priyanka Bhale");
		ExpectedEmployees.put(10101, employeeListForManager10101);
		System.out.println(ExpectedEmployees);
		System.out.println(actualEmployeeDetails);
		Assert.assertEquals(ExpectedEmployees, actualEmployeeDetails);
	}

}
