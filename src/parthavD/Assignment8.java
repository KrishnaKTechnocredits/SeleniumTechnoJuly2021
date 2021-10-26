/*Assignment - 8 : 23th Oct'2021
Return a map of Deptname and count of employee within each deptment.
o/p : 7001-Admin -> 2
      7002-Finance -> 2
	  7003-HR -> 2
	  7013-IT -> 3*/
package parthavD;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.PredefinedActions;

public class Assignment8 {

	WebDriver driver;

	@BeforeClass
	WebDriver BrowserStart() {
		this.driver = PredefinedActions.start();
		return driver;
	}

	@Test
	void test1() {
		System.out.println("Step - Launch Automation by Krishna URL");
		driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
		System.out.println("Step - Navigate to demo tables section");
		driver.findElement(By.xpath("//a[@id='demotable']")).click();
		int rowsize = driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr")).size();
		Map<String, Integer> map = new LinkedHashMap<>();
		for (int index = 1; index <= rowsize; index++) {
			String key = driver
					.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr[" + index + "]/td[5]"))
					.getText();
			if (!map.containsKey(key)) {
				map.put(key, 1);
			} else {
				map.put(key, map.get(key) + 1);
			}
		}
		System.out.println(map);
		Map<String, Integer> expectedMap = new LinkedHashMap<>();
		expectedMap.put("7001-Admin", 2);
		expectedMap.put("7002-Finance", 2);
		expectedMap.put("7003-HR", 2);
		expectedMap.put("7013-IT", 3);
		Assert.assertEquals(map, expectedMap);
	}

	@AfterClass
	void TearDown() {
		driver.close();
	}
}
