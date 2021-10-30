/*Assignment - 11: 24th Oct'2021
Program 1: Return unique Employees from table-2.  
output : size - 8

Program 2: print employee id which is duplicate in table-2 
output : 76585 

Program 3: print the name of deptment having maximum employees. 
output : 7013-IT*/
package chandani.Assignment11;


import java.util.List;
import java.util.Set;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base.PredefinedActions;


public class Assignment11 {

	WebDriver driver;
	
	@BeforeClass
	void start() {
		driver = PredefinedActions.start();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("STEP - Click on Demo Tables link");
		driver.findElement(By.linkText("Demo Tables")).click();
	}
	
	@Test(priority = 1)
	//@Parameters({"expectedEmpCount","actualEmpCount"})
	void getUniqueEmployeesCountAndVerify() {
		
		HashSet<String> setOfEmp = new HashSet<>();
		List<WebElement> listOfEmp = driver
				.findElements(By.xpath("//table[@class ='table table-striped']/tbody/tr/td[3]"));
		for (int index = 0; index < listOfEmp.size(); index++) {
			setOfEmp.add(listOfEmp.get(index).getText());
		}
		int actualEmpCount = setOfEmp.size();
		System.out.println("STEP : Actual Count of Unique Employees in the identified table is " + actualEmpCount );
		int expectedEmpCount = 8;
		Assert.assertEquals(actualEmpCount, expectedEmpCount, "The Employee Counts doesnt match with actual");
		System.out.println("Unique employee names " + setOfEmp);
		System.out.println("Test Case 1 of Assignment 11 Passed");
	}	
	
	//Test Case 2
	@Test(priority = 2)
	void getDuplicateEmployeeIdAndVerify() {
		System.out.println("STEP - Verify duplicate emp ID");
		Set<String> set = new HashSet<String>();
		String dupID = "";
		int rowCount = driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr")).size();
		for (int index = 1; index <= rowCount; index++) {
			String name = driver
					.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr[" + index + "]/td[2]"))
					.getText();
			if (!set.add(name))
				dupID = name;
		}

		String actualUniqueEmpID = dupID;
		String expectedUniqueEmpID = "76585";
		Assert.assertEquals(actualUniqueEmpID, expectedUniqueEmpID, "DupID employee count does not match");
		System.out.println("Duplicate empID from the table " + dupID);
		System.out.println("Test Case 2 of Assignment 11 Passed");

	}
	//Test Case 3
	@Test(priority = 3)
	void getDeptNameHavingMaxEmpAndVerify() {
		
		System.out.println("STEP - Verify Department name having Maximum Employees");
		ArrayList<String> deptName = new ArrayList<String>();
		deptName.add("7001-Admin");
		deptName.add("7002-Finance");
		deptName.add("7003-HR");
		deptName.add("7013-IT");
		
		
		String actualmaxDept = "";
		String expectedmaxDept = "7013-IT";
		int actualmaxCount = 0;
		int expectedmaxCount = 3;
		for (String str : deptName) {
			int empCount = driver
					.findElements(
							By.xpath("//table[@class='table table-striped']/tbody/tr/td[5][text()='" + str + "']"))
					.size();
			if (empCount > actualmaxCount) {
				actualmaxCount = empCount;
				actualmaxDept = str;
			}
		}
		Assert.assertEquals(actualmaxCount, expectedmaxCount, "Max employee count does not match");
		Assert.assertEquals(actualmaxDept, expectedmaxDept, "Dept having max employees does not match");
	System.out.println("Count of employees (maximum) : " + actualmaxCount);
	System.out.println("Department having the max number of employees " + actualmaxDept);
	System.out.println("Test Case 3 of Assignment 11 Passed");

	}
	@AfterClass
	void close() {
		driver.close();
	}
}

