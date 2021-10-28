/*Return a map of Deptname and count of employee within each deptment.
o/p : 7001-Admin -> 2
      7002-Finance -> 2
	  7003-HR -> 2
	  7013-IT -> 3*/


package elizabeth.Assignment_8;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import dattaraj_W.base.PredefinedActions;

public class Assignment8 {
	
	WebDriver driver;
	
	@BeforeClass
	public void launchBrowser() {
		this.driver=PredefinedActions.start();
		System.out.println("Step: Click on Demo Tables");
		driver.findElement(By.linkText("Demo Tables")).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	@AfterClass
	public void tearDown() {
		driver.close();
	}
	
	@Test
	void testCase1() {
		Map<String,Integer> actualMap=new LinkedHashMap<>();
		int totalRows=driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr")).size();
		for(int index=1;index<=totalRows;index++) {
			String department=driver.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr["+index+"]/td[5]")).getText();
			if(actualMap.containsKey(department)) {
				actualMap.put(department,actualMap.get(department)+1);
			}else {
				actualMap.put(department,1);
			}
		}
		System.out.println("Map of Deptname and count of employee within each deptment: "+ actualMap);
		
		Map<String,Integer> expectedMap=new LinkedHashMap<>();
		expectedMap.put("7001-Admin", 2);
		expectedMap.put("7002-Finance", 2);
		expectedMap.put("7003-HR", 2);
		expectedMap.put("7013-IT", 3);
		Assert.assertEquals(actualMap, expectedMap);
	}
}
