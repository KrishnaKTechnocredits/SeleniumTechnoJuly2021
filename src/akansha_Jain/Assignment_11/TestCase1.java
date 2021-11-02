/* Assignment - 11: 24th Oct'2021
Program 1: Return unique Employees from table-2.  
output : size - 8 */

package akansha_Jain.Assignment_11;

import java.util.HashSet;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestCase1 {
	WebDriver driver;
	
	@BeforeClass
	public void launchBrowser() {
		driver = PreDefinedActions.start();
	}
	
	HashSet<String> findUniqueEmployees() {
		HashSet<String> setOfEmpName = new HashSet<>();
		int totalRows= driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr")).size();
		for(int index=1; index<=totalRows; index++) {
			String empName = driver.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr["+index+"]/td[3]")).getText();
			setOfEmpName.add(empName);
		}
		return setOfEmpName;
	}
	
	@Test
	public void testCaseUniqueEmployees() {
		HashSet<String> actualSetOfEmpName = findUniqueEmployees();
		System.out.println("STEP- Unique Employees name- " + actualSetOfEmpName);
		System.out.println("STEP- Unique Employees count- " + actualSetOfEmpName.size());
		HashSet<String> expectedSetOfEmpName = new HashSet<>();
		expectedSetOfEmpName.add("Abhijit Mane");
		expectedSetOfEmpName.add("Sumit Mate");
		expectedSetOfEmpName.add("Sumit Kulkarni");
		expectedSetOfEmpName.add("Prayag Mokate");
		expectedSetOfEmpName.add("Pawan Belamkar");
		expectedSetOfEmpName.add("Nikhil Patne");
		expectedSetOfEmpName.add("Chetan Shewale");
		expectedSetOfEmpName.add("Priyanka Bhale");
		Assert.assertEquals(actualSetOfEmpName, expectedSetOfEmpName);
	}
	
	@AfterClass
	public void closeBrowser() {
		driver.close();
	}
}