package shantanu.assignment9;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/* Verfiy Employee count and Employee name in each deptment.*/
public class Assignment9 {
	WebDriver driver;
	@BeforeMethod
	void start() {
		System.setProperty("webdriver.chrome.driver", "./resources/chromedriver.exe");
		System.out.println("STEP 1 - Open Chrome Browser");
		driver = new ChromeDriver();
		driver.get("http://automationbykrishna.com/");
		driver.manage().window().maximize();
	}

	HashMap<String,ArrayList<String>> getHashMap() {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.linkText("Demo Tables")).click();
		HashMap<String,ArrayList<String>> deptEmpMap = new HashMap();
		int noOfRows = driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr")).size();
		for(int rowIndex = 1; rowIndex <= noOfRows; rowIndex++) {
			String deptName = driver.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr["+rowIndex+"]/td[5]")).getText();
			String empName = driver.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr["+rowIndex+"]/td[5]/preceding-sibling::td[2]")).getText();
			if(deptEmpMap.containsKey(deptName)) {
				ArrayList<String> currentList = deptEmpMap.get(deptName);
				currentList.add(empName);
				deptEmpMap.put(deptName, currentList);
			}
			else {
				ArrayList<String> empList = new ArrayList();
				empList.add(empName);
				deptEmpMap.put(deptName, empList);
			}
		}
		return deptEmpMap;		
	}
	
	@Test
	void verifyDeptWiseEmpList() {
		HashMap<String,ArrayList<String>> deptEmpMap = getHashMap();
		
		ArrayList<String> actualList = deptEmpMap.get("7001-Admin");
		Assert.assertTrue(actualList.size()==2);
		
		ArrayList<String> expectedList = new ArrayList();
		expectedList.add("Abhijit Mane");
		expectedList.add("Prayag Mokate");
		Assert.assertEquals(actualList, expectedList);
		
		actualList.clear();
		expectedList.clear();
		actualList = deptEmpMap.get("7002-Finance");
		Assert.assertTrue(actualList.size()==2);
		
		expectedList.add("Sumit Mate");
		expectedList.add("Sumit Mate");
		Assert.assertEquals(actualList, expectedList);
		
		actualList.clear();
		expectedList.clear();
		actualList = deptEmpMap.get("7003-HR");
		Assert.assertTrue(actualList.size()==2);
		
		expectedList.add("Sumit Kulkarni");
		expectedList.add("Pawan Belamkar");
		Assert.assertEquals(actualList, expectedList);
		
		actualList.clear();
		expectedList.clear();
		actualList = deptEmpMap.get("7013-IT");
		Assert.assertTrue(actualList.size()==3);
		
		expectedList.add("Nikhil Patne");
		expectedList.add("Chetan Shewale");
		expectedList.add("Priyanka Bhale");
		Assert.assertEquals(actualList, expectedList);
	}
	
	@AfterMethod
	void end() {
		driver.close();
	}
}
