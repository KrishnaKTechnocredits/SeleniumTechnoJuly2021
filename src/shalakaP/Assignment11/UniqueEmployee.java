/*Assginment - 11: 24th Oct'2021
Program 1: Return unique Employees from table-2.  
output : size - 8*/
package shalakaP.Assignment11;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.PredefinedActions;

public class UniqueEmployee {

	WebDriver driver;

	@BeforeClass
	public void getStart() {
		driver = PredefinedActions.start();
		System.out.println("Step-Click on Demo Table");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.linkText("Demo Tables")).click();
	}

	@AfterClass
	public void getClose() {
		driver.close();
	}

	@Test
	public void verifyUniqueName() {
		System.out.println("Step- Print unique Employee list");
		LinkedHashSet<String> actualEmpSet = getUniqueName();
		System.out.println("Unique Emp list: " + actualEmpSet.size());
		LinkedHashSet<String> expectedEmpSet = new LinkedHashSet<String>();
		expectedEmpSet.add("Abhijit Mane");
		expectedEmpSet.add("Sumit Mate");
		expectedEmpSet.add("Sumit Kulkarni");
		expectedEmpSet.add("Prayag Mokate");
		expectedEmpSet.add("Pawan Belamkar");
		expectedEmpSet.add("Nikhil Patne");
		expectedEmpSet.add("Chetan Shewale");
		expectedEmpSet.add("Priyanka Bhale");

		Assert.assertEquals(actualEmpSet, expectedEmpSet);
	}

	LinkedHashSet<String> getUniqueName() {
		LinkedHashSet<String> empSet = new LinkedHashSet<String>();
		int rowCnt = driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr/td[4]")).size();
		for (int index = 1; index <= rowCnt; index++) {
			String empName = driver
					.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr[" + index + "]/td[3]"))
					.getText();
			empSet.add(empName);
		}
		return empSet;
	}

	// Program 2: print employee id which is duplicate in table-2
	@Test
	public void verifyDupEmpId() {
		System.out.println("Step- print employee id which is duplicate in table-2");
		String actualEmpId = getDupEmpId();
		System.out.println("Dupicate Emp Id: " + actualEmpId);
		String expectedEmpId = "76585";
		Assert.assertEquals(actualEmpId, expectedEmpId);
	}

	String getDupEmpId() {
		HashSet<String> empIdSet = new HashSet<String>();
		int rowCnt = driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr")).size();
		String empId = "";
		String duplicateId = "";
		for (int index = 1; index <= rowCnt; index++) {
			empId = driver.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr[" + index + "]/td[2]"))
					.getText();
			if (!empIdSet.add(empId)) {
				duplicateId = empId;
			}
		}
		return duplicateId;
	}

	/*
	 * Program 3: print the name of deptment having maximum employees. output :
	 * 7013-IT
	 */

	@Test
	public void verifyDeptName() {
		String actualDeptName = printNameOfDeptHavingMaxEmp();
		System.out.println("Dep name:"+actualDeptName);
		String expectedDeptName = "7013-IT";

		Assert.assertEquals(actualDeptName, expectedDeptName);

	}

	String printNameOfDeptHavingMaxEmp() {
		System.out.println("Step-print the name of deptment having maximum employees");
		HashMap<String, Integer> hm = new HashMap<String, Integer>();
		int rowCnt = driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr")).size();
		for (int index = 1; index <= rowCnt; index++) {
			String deptName = driver
					.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr[" + index + "]/td[5]"))
					.getText();
			if (hm.containsKey(deptName)) {
				hm.put(deptName, hm.get(deptName) + 1);
			} else {
				hm.put(deptName, 1);

			}
		}
		String dupDeptName = "";
		int maxDeptCnt = 0;
		for (String dept : hm.keySet()) {
			if (hm.get(dept) > maxDeptCnt) {
				maxDeptCnt = hm.get(dept);
				dupDeptName = dept;
			}
		}
		return dupDeptName;
	}
}