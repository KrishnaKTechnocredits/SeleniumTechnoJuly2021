package monali.webtables;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.PredefinedActions;

/*Assignment - 8 : 23th Oct'2021
Return a map of Deptname and count of employee within each deptment.
o/p : 7001-Admin -> 2
      7002-Finance -> 2
	  7003-HR -> 2
	  7013-IT -> 3*/

public class Assignment_8 {

	WebDriver driver;

	@BeforeClass
	void launchBrowser() {
		driver = PredefinedActions.start();
		driver.findElement(By.xpath("//a[contains(text(),'Demo Tables')]")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@AfterClass
	void tearDown() {
		driver.close();
	}

	@Test
	void getDeptNameAndCountOfEmployee() {

		Map<String, Integer> expectedMap = new HashMap<>();
		expectedMap.put("7001-Admin", 2);
		expectedMap.put("7002-Finance", 2);
		expectedMap.put("7003-HR", 2);
		expectedMap.put("7013-IT", 3);

		Map<String, Integer> map = new HashMap<>();
		int rowsCount = driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr")).size();
		for (int index = 1; index <= rowsCount; index++) {
			String key = driver
					.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr[" + index + "]/td[5]"))
					.getText();
			if (map.containsKey(key))
				map.put(key, map.get(key) + 1);
			else
				map.put(key, 1);
		}
		System.out.println(map);
		Assert.assertEquals(map, expectedMap);
	}

}
