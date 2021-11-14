package shantanu.assignment10;
//Similar to Assignment-9 but verification should be against managerid.

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

public class Assignment10 {
	WebDriver driver;
	@BeforeMethod
	void start() {
		System.setProperty("webdriver.chrome.driver", "./resources/chromedriver.exe");
		System.out.println("STEP 1 - Open Chrome browser");
		driver = new ChromeDriver();
		driver.get("http://automationbykrishna.com/");
		driver.manage().window().maximize();
	}
	
	HashMap<Integer,ArrayList<String>> getHashMap(){
		HashMap<Integer,ArrayList<String>> mngEmpMap = new HashMap();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.linkText("Demo Tables")).click();
		int rows = driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr")).size();
		for(int rowIndex = 1; rowIndex <= rows; rowIndex++) {
			int manager = Integer.parseInt(driver.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr["+rowIndex+"]/td[4]")).getText());
			String employee = driver.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr["+rowIndex+"]/td[4]/preceding-sibling::td[1]")).getText();
			if(mngEmpMap.containsKey(manager)) {
				ArrayList<String> currentList = mngEmpMap.get(manager);
				currentList.add(employee);
				mngEmpMap.put(manager, currentList);
			}
			else {
				ArrayList<String> newEmpList = new ArrayList();
				newEmpList.add(employee);
				mngEmpMap.put(manager, newEmpList);
			}
		}
		return mngEmpMap;
	}
	
	@Test
	void verifyManagerWiseEmployeeList() {
		HashMap<Integer,ArrayList<String>> mngEmpMap = getHashMap();
		
		ArrayList<String> actualList = mngEmpMap.get(20209);
		Assert.assertTrue(actualList.size()==3);
		
		ArrayList<String> expectedList = new ArrayList();
		expectedList.add("Abhijit Mane");
		expectedList.add("Sumit Kulkarni");
		expectedList.add("Pawan Belamkar");
		Assert.assertEquals(actualList, expectedList);
		
		actualList.clear();
		expectedList.clear();
		actualList = mngEmpMap.get(20205);
		Assert.assertTrue(actualList.size()==4);
		
		expectedList.add("Sumit Mate");
		expectedList.add("Prayag Mokate");
		expectedList.add("Sumit Mate");
		expectedList.add("Nikhil Patne");
		Assert.assertEquals(actualList, expectedList);
		
		actualList.clear();
		expectedList.clear();
		actualList = mngEmpMap.get(10101);
		Assert.assertTrue(actualList.size()==2);
		
		expectedList.add("Chetan Shewale");
		expectedList.add("Priyanka Bhale");
		Assert.assertEquals(actualList, expectedList);
	}
	
	@AfterMethod
	void end() {
		driver.close();
	}
}
