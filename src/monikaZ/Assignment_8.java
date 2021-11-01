/* Assignment - 8 : 23th Oct'2021
Return a map of Deptname and count of employee within each deptment.
o/p : 7001-Admin -> 2
      7002-Finance -> 2
	  7003-HR -> 2
	  7013-IT -> 3 */
package monikaZ;

import java.util.LinkedHashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import org.testng.annotations.Test;

public class Assignment_8 {

	WebDriver driver;
	
	@BeforeClass
	void launchBrowser() throws InterruptedException {
		
		System.out.println("STEP- Open Chrome Browser");
		System.setProperty("webdriver.chrome.driver","./resources/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		System.out.println("STEP- Enter URL");
		driver.get("http://automationbykrishna.com/index.html#");
		Thread.sleep(2000);
		System.out.println("STEP- Open Demo Tables");
		driver.findElement(By.xpath("//a[@id='demotable']")).click();
		Thread.sleep(3000);
	}
	
	
	@Test
	void testCase() {
		LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
		int totalRows = driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr")).size();
		for(int index=1; index<=totalRows; index++) {
			String deptName = driver.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr["+index+"]/td[5]")).getText();
			if(map.containsKey(deptName))
				map.put(deptName, map.get(deptName)+1);
			else
				map.put(deptName, 1);
		}
		System.out.println("The dept name with count of employees- " + map);
	}
	@AfterClass
	void closeBrowser() {
		driver.close();
	}
}
