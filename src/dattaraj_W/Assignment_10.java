package dattaraj_W;

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

public class Assignment_10 {
	WebDriver driver;
	
	@BeforeClass
	void launchBrowser() {
		System.out.println("STEP- Open chrome browser");
		System.setProperty("webdriver.chrome.driver", "./resources/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		System.out.println("STEP- Open URL");
		driver.get("http://automationbykrishna.com/index.html#");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.linkText("Demo Tables")).click();
	}

	HashMap<Integer, ArrayList<String>> getManagerIdMap() {
		int totalRows = driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr")).size();
		HashMap<Integer, ArrayList<String>> managerIDMap = new HashMap<Integer, ArrayList<String>>();
		for(int index=1; index<=totalRows; index++) {
			int managerId = Integer.parseInt(driver.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr["+index+"]/td[4]")).getText());
			String empName = driver.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr["+index+"]/td[4]/preceding-sibling::td[1]")).getText();
			if(managerIDMap.containsKey(managerId)){
				ArrayList<String> currentEmpList = managerIDMap.get(managerId);
				currentEmpList.add(empName);
				managerIDMap.put(managerId,currentEmpList);
			} else {
				ArrayList<String> newEmpList = new ArrayList<String>();
				newEmpList.add(empName);
				managerIDMap.put(managerId, newEmpList);
			}
		} 
		return managerIDMap;
	}

	@Test
	void testCaseVerifyEmpCountAgainstManager() {
		HashMap<Integer, ArrayList<String>> managerMap = getManagerIdMap();

		System.out.println("STEP- Verify employees count and employee name under manager id- 20209");
		ArrayList<String> actualEmpList = managerMap.get(20209);
		System.out.println("Emp list- " + actualEmpList + " & Emp count- " + actualEmpList.size() + " are coming under manager id- 20209");
		Assert.assertTrue(actualEmpList.size() == 3);

		ArrayList<String> expectedEmpList = new ArrayList<String>();
		expectedEmpList.add("Abhijit Mane");
		expectedEmpList.add("Sumit Kulkarni");
		expectedEmpList.add("Pawan Belamkar");
		Assert.assertEquals(actualEmpList, expectedEmpList);

		actualEmpList.clear();
		expectedEmpList.clear();

		System.out.println("STEP- Verify employees count and employee name under manager id- 20205");
		actualEmpList = managerMap.get(20205);
		System.out.println("Emp list- " + actualEmpList + " & Emp count- " + actualEmpList.size() + " are coming under manager id- 20205");
		Assert.assertTrue(actualEmpList.size() == 4);

		expectedEmpList.add("Sumit Mate");
		expectedEmpList.add("Prayag Mokate");
		expectedEmpList.add("Sumit Mate");
		expectedEmpList.add("Nikhil Patne");
		Assert.assertEquals(actualEmpList, expectedEmpList);

		actualEmpList.clear();
		expectedEmpList.clear();

		System.out.println("STEP- Verify employees count and employee name under manager id- 10101");
		actualEmpList = managerMap.get(10101);
		System.out.println("Emp list- " + actualEmpList + " & Emp count- " + actualEmpList.size() + " are coming under manager id- 10101");
		Assert.assertTrue(actualEmpList.size() == 2);

		expectedEmpList.add("Chetan Shewale");
		expectedEmpList.add("Priyanka Bhale");
		Assert.assertEquals(actualEmpList, expectedEmpList);
	}

	@AfterClass
	void closeBrowser() {
		driver.close();
	}
}