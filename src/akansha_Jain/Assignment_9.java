/* Assignment - 9 : 24th Oct'2021
Verfiy Employee count and Employee name in each deptment.
Sample Output: Employee Count in 7001-Admin dept.
               Employee name belongs to 7001-Admin dept. */

package akansha_Jain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Assignment_9 {
	WebDriver driver;
	
	@BeforeClass
	void launchBrowser() {
		System.out.println("STEP- Open chrome browser");
		System.setProperty("webdriver.chrome.driver", "//Users//punchh_akansha//eclipse-workspace//Java_Techno_Selenium_2021//resources//chromedriver");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		System.out.println("STEP- Open URL");
		driver.get("http://automationbykrishna.com/index.html#");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.linkText("Demo Tables")).click();
	}
	
	HashMap<String, ArrayList<String>> getDeptEmpMap() {
		int totalRows = driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr")).size();
		HashMap<String, ArrayList<String>> deptEmpMap = new HashMap<String, ArrayList<String>>();
		for(int index=1; index<=totalRows; index++) {
			String deptName = driver.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr["+index+"]/td[5]")).getText();
			String empName = driver.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr["+index+"]/td[5]/preceding-sibling::td[2]")).getText();
			if(deptEmpMap.containsKey(deptName)){
				ArrayList<String> currentEmpList = deptEmpMap.get(deptName);
				currentEmpList.add(empName);
				deptEmpMap.put(deptName,currentEmpList);
			} else {
				ArrayList<String> empNameList = new ArrayList<String>();
				empNameList.add(empName);
				deptEmpMap.put(deptName, empNameList);
			}
		} 
		return deptEmpMap;
	}
	
	@Test
	void testCaseVerifyEmpCountInEachDept() {
		HashMap<String, ArrayList<String>> deptEmployeeMap = getDeptEmpMap();
		
		System.out.println("STEP- Verify employees count and employee name in dept- 7001-Admin");
		ArrayList<String> actualEmpList = deptEmployeeMap.get("7001-Admin");
		System.out.println("Emp list- " + actualEmpList + " & Emp count- " + actualEmpList.size() + " in dept 7001-Admin");
		Assert.assertTrue(actualEmpList.size() == 2);
		
		ArrayList<String> expectedEmpList = new ArrayList<String>();
		expectedEmpList.add("Abhijit Mane");
		expectedEmpList.add("Prayag Mokate");
		Assert.assertEquals(actualEmpList, expectedEmpList);
		
		actualEmpList.clear();
		expectedEmpList.clear();
		
		System.out.println("STEP- Verify employees count and employee name in dept- 7002-Finance");
		actualEmpList = deptEmployeeMap.get("7002-Finance");
		System.out.println("Emp list- " + actualEmpList + " & Emp count- " + actualEmpList.size() + " in dept 7002-Finance");
		Assert.assertTrue(actualEmpList.size() == 2);
		
		expectedEmpList.add("Sumit Mate");
		expectedEmpList.add("Sumit Mate");
		Assert.assertEquals(actualEmpList, expectedEmpList);

		actualEmpList.clear();
		expectedEmpList.clear();
		
		System.out.println("STEP- Verify employees count and employee name in dept- 7003-HR");
		actualEmpList = deptEmployeeMap.get("7003-HR");
		System.out.println("Emp list- " + actualEmpList + " & Emp count- " + actualEmpList.size() + " in dept 7003-HR");
		Assert.assertTrue(actualEmpList.size() == 2);
		
		expectedEmpList.add("Sumit Kulkarni");
		expectedEmpList.add("Pawan Belamkar");
		Assert.assertEquals(actualEmpList, expectedEmpList);
		
		actualEmpList.clear();
		expectedEmpList.clear();
		
		System.out.println("STEP- Verify employees count and employee name in dept- 7013-IT");
		actualEmpList = deptEmployeeMap.get("7013-IT");
		System.out.println("Emp list- " + actualEmpList + " & Emp count- " + actualEmpList.size() + " in dept 7013-IT");
		Assert.assertTrue(actualEmpList.size() == 3);
		
		expectedEmpList.add("Nikhil Patne");
		expectedEmpList.add("Chetan Shewale");
		expectedEmpList.add("Priyanka Bhale");
		Assert.assertEquals(actualEmpList, expectedEmpList);
	}
	
	@AfterClass
	void closeBrowser() {
		driver.close();
	}
}