/* Assignment - 11: 24th Oct'2021
Program 3: print the name of deptment having maximum employees. 
output : 7013-IT */

package akansha_Jain.Assignment_11;

import java.util.LinkedHashMap;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestCase3 {
	WebDriver driver;
	
	@BeforeClass
	void launchBrowser() {
		driver = PreDefinedActions.start();
	}
	
	String getMaxEmpDept() {
		LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
		int totalRows = driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr")).size();
		for(int index=1; index<=totalRows; index++) {
			String deptName = driver.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr["+index+"]/td[5]")).getText();
			if(map.containsKey(deptName))
				map.put(deptName, map.get(deptName)+1);
			else
				map.put(deptName, 1);
		}
		String maxEmpDeptName = "";
		int maxEmpCount = 0;
		for(String dept : map.keySet()) {
			if(map.get(dept) > maxEmpCount) {
				maxEmpCount = map.get(dept);
				maxEmpDeptName = dept;
			}
		}
		return maxEmpDeptName;
	}
	
	@Test
	void testCaseDeptNameMaxEmp() {
		String actualMaxEmpDeptName = getMaxEmpDept();
		System.out.println("STEP- Max employees dept name= " + actualMaxEmpDeptName);
		String expectedMaxEmpDeptName = "7013-IT";
		Assert.assertEquals(actualMaxEmpDeptName, expectedMaxEmpDeptName);
	}
	
	@AfterClass
	void closeBrowser() {
		driver.close();
	}
}