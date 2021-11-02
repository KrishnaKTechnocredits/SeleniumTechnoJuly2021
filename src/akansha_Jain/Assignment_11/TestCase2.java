/* Assignment - 11: 24th Oct'2021
Program 2: print employee id which is duplicate in table-2 
output : 76585 */

package akansha_Jain.Assignment_11;

import java.util.ArrayList;
import java.util.HashMap;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestCase2 {
	WebDriver driver;
	
	@BeforeClass
	void launchBrowser() {
		driver = PreDefinedActions.start();
	}
	
	ArrayList<Integer> findDuplicateEmpId() {
		HashMap<Integer, Integer> empIdMap = new HashMap<>();
		int totalRows= driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr")).size();
		for(int index=1; index<=totalRows; index++) {
			int empId = Integer.parseInt(driver.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr["+index+"]/td[2]")).getText());
			if(empIdMap.containsKey(empId))
				empIdMap.put(empId, empIdMap.get(empId)+1);
			else
				empIdMap.put(empId, 1);
		}
		ArrayList<Integer> listOfDupEmpId = new ArrayList<>();
		for(int employeeID : empIdMap.keySet()) {
			if(empIdMap.get(employeeID)>1)
				listOfDupEmpId.add(employeeID);
		}
		return listOfDupEmpId;
	}
	
	@Test
	void testCaseEmployeeId() {
		ArrayList<Integer> actualListOfDupEmpID = findDuplicateEmpId();
		System.out.println("STEP- List of duplicate employee Ids- " + actualListOfDupEmpID);
		System.out.println("STEP- Number of duplicate employee Ids- " + actualListOfDupEmpID.size());
		ArrayList<Integer> expectedListOfDupEmpID = new ArrayList<>();
		expectedListOfDupEmpID.add(76585);
		Assert.assertTrue(actualListOfDupEmpID.size() == expectedListOfDupEmpID.size());
	}
	
	@AfterClass
	void closeBrowser() {
		driver.close();
	}
}