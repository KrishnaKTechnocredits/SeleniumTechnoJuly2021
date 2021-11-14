/*
 * Assignment - 11: 24th Oct'2021
Program 1: Return unique Employees from table-2.  
output : size - 8

Program 2: print employee id which is duplicate in table-2 
output : 76585 

Program 3: print the name of deptment having maximum employees. 
output : 7013-IT

 */
package husain.Assignment11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.PredefinedActions;

public class Assignment11 {

	WebDriver driver;

	@BeforeClass
	void setup() {

		driver = PredefinedActions.start();
		driver.findElement(By.linkText("Demo Tables")).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	@Test
	void findUniqueEmpCount() {
		System.out.println("STEP - Find count and names of unique employees");
		Set<String> set = new HashSet<String>();
		int rowCount = driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr")).size();
		for (int index = 1; index <= rowCount; index++) {
			String name = driver
					.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr[" + index + "]/td[3]"))
					.getText();
			set.add(name);
		}

		int actualUniqueEmpCount = set.size();
		int expectedUniqueEmpCount = 8;
		Assert.assertEquals(actualUniqueEmpCount, expectedUniqueEmpCount, "Unique employee count does not match");
		System.out.println("List of unique employee names from the table " + set);
		System.out.println("Count of unique employee names from the table " + set.size());
	}

	@Test
	void printUniqueEmpID() {

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
	}

	@Test
	void findMaxEpCount() {
		System.out.println("STEP - Find dept having max number of employees and their count");
		ArrayList<String> dept = new ArrayList<String>(
				Arrays.asList("7001-Admin", "7002-Finance", "7003-HR", "7013-IT"));
		int rowCount = driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr")).size();
		int expectedMaxEmpCount = 3;
		int maxCount = 0;
		String expectedMaxDept = "7013-IT";
		String maxDept = "";
		for (String str : dept) {
			int empCount = driver
					.findElements(
							By.xpath("//table[@class='table table-striped']/tbody/tr/td[5][text()='" + str + "']"))
					.size();
			if (empCount > maxCount) {
				maxCount = empCount;
				maxDept = str;
			}
		}
		Assert.assertEquals(maxCount, expectedMaxEmpCount, "Max employee count does not match");
		Assert.assertEquals(maxDept, expectedMaxDept, "Dept having max employees does not match");
		System.out.println("Dept having max employees is " + maxDept + " and the max count is " + maxCount);

	}

	@AfterClass
	void windingDown() {
		driver.close();
	}

}
