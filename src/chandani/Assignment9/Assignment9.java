/*Assignment - 9 : 24th Oct'2021
Verify Employee count and Employee name in each deptment.

Sample Output: Employee Count in 7001-Admin dept.
               Employee name belongs to 7001-Admin dept.*/
package chandani.Assignment9;


import java.util.ArrayList;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

import base.PredefinedActions;


public class Assignment9 {
	
	WebDriver driver;

	HashMap<String, ArrayList<String>> getEmployeeNameoOfEachDepartment() throws InterruptedException{
		
		driver = PredefinedActions.start();
		Thread.sleep(3000);
		System.out.println("STEP - Click on Demo Tables Link");
		driver.findElement(By.linkText("Demo Tables")).click();
		Thread.sleep(3000);
		int deptNameRows = driver.findElements(By.xpath("//table[@class=\"table table-striped\"]//tbody/tr/td[5]")).size();
		//int EmpName = driver.findElements(By.xpath("//table[@class=\"table table-striped\"]//tbody/tr/td[3]")).size();
		HashMap<String, ArrayList<String>> deptEmpMap = new HashMap<String, ArrayList<String>>();
		for(int rowIndex = 1; rowIndex <= deptNameRows;rowIndex++){
			String dptName = driver.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr[" + rowIndex + "]/td[5]")).getText();
			String empName = driver.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr[" + rowIndex + "]/td[3]")).getText();
			if(deptEmpMap.containsKey(dptName)){
				ArrayList<String> currentEmpList = deptEmpMap.get(dptName);
				currentEmpList.add(empName); 
				deptEmpMap.put(dptName,currentEmpList);
			}else{
				ArrayList<String> empNameList = new ArrayList<String>();
				empNameList.add(empName);
				deptEmpMap.put(dptName, empNameList);
			}
	} 
		System.out.println("STEP - Employee Names per Department");
		System.out.println(deptEmpMap);
		driver.close();
		return deptEmpMap;
	}
	
	
	@Test
	public void verifyEmployeePerDept() throws InterruptedException{
		HashMap<String, ArrayList<String>> deptEmpMap = getEmployeeNameoOfEachDepartment();
		ArrayList<String> actualEmpList = deptEmpMap.get("7001-Admin");
		System.out.println("STEP - Verify Employee Count of Department 7001-Admin \n");
	     Assert.assertTrue(actualEmpList.size() == 2);
		System.out.println("Verification of Employee of Department 7001-Admin Count Passed \n");
	     
		ArrayList<String> expectedEmpList = new ArrayList<String>();
		expectedEmpList.add("Abhijit Mane");
		expectedEmpList.add("Prayag Mokate");
		
		System.out.println("STEP - Verify Employees of Department 7001-Admin \n");
		Assert.assertTrue(actualEmpList.equals(expectedEmpList));
		System.out.println("Expected Employee List : " + expectedEmpList );
		System.out.println("Actual Employee List : " + actualEmpList );
		System.out.println("Verification of Employees of Department 7001-Admin Passed \n");

		
		actualEmpList.clear();
		actualEmpList = deptEmpMap.get("7002-Finance");
		System.out.println("STEP - Verify Employee Count of Department 7002-Finance \n");
	     Assert.assertTrue(actualEmpList.size() == 2);
		System.out.println("Verification of Employee of Department 7002-Finance Count Passed \n");
		
		expectedEmpList.clear();
		expectedEmpList.add("Sumit Mate");
		expectedEmpList.add("Sumit Mate");
		Assert.assertTrue(actualEmpList.equals(expectedEmpList));
		System.out.println("Expected Employee List : " + expectedEmpList );
		System.out.println("Actual Employee List : " + actualEmpList );
		System.out.println("Verification of Employees of Department 7002-Finance Passed \n");
		
		actualEmpList.clear();
		actualEmpList = deptEmpMap.get("7003-HR");
		Assert.assertTrue(actualEmpList.size() == 2);
		System.out.println("Verification of Employee of Department 7003-HR Count Passed \n");

		expectedEmpList.clear();
		expectedEmpList.add("Sumit Kulkarni");
		expectedEmpList.add("Pawan Belamkar");
		Assert.assertTrue(actualEmpList.equals(expectedEmpList));
		System.out.println("Expected Employee List : " + expectedEmpList );
		System.out.println("Actual Employee List : " + actualEmpList );
		System.out.println("Verification of Employees of Department 7003-HR Passed \n");
		

		actualEmpList.clear();
		actualEmpList = deptEmpMap.get("7013-IT");
		Assert.assertTrue(actualEmpList.size() == 3);
		System.out.println("Verification of Employee of Department 7013-IT Count Passed \n");
		
		expectedEmpList.clear();
		expectedEmpList.add("Nikhil Patne");
		expectedEmpList.add("Chetan Shewale");
		expectedEmpList.add("Priyanka Bhale");
		Assert.assertTrue(actualEmpList.equals(expectedEmpList));	
		System.out.println("Expected Employee List : " + expectedEmpList );
		System.out.println("Actual Employee List : " + actualEmpList );
		System.out.println("Verification of Employees of Department 7013-IT Passed \n");
		
		System.out.println("STEP - Assignment 9 Passed Successfully");		
	}
	
	@AfterSuite
	void close() {
		driver.close();
	}
	
}
