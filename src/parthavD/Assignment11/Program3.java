package parthavD.Assignment11;

import java.util.LinkedHashMap;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.PredefinedActions;

public class Program3 {

	WebDriver driver;

	@BeforeMethod
	WebDriver BrowserStart() {
		this.driver = PredefinedActions.start();
		return driver;
}
	
	public LinkedHashMap<String, Integer> getMap(){
		LinkedHashMap<String, Integer> map = new LinkedHashMap<String, Integer>();
		int rowSize = driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr")).size();
		
		for (int index = 1; index <= rowSize; index++){
			String dept = driver.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr["+index+"]/td[5]")).getText();
			if (!map.containsKey(dept)){
				map.put(dept, 1);
			}
			else{
				map.put(dept, map.get(dept) + 1);
			}
		}
		return map;
	}
	
	@Test
	void test1() {
		System.out.println("Step - Launch Automation by Krishna URL");
		driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
		System.out.println("Step - Navigate to demo tables section");
		driver.findElement(By.xpath("//a[@id='demotable']")).click();
		LinkedHashMap<String, Integer> map = getMap();
		String expectedDept = "7013-IT";
		int maxValue = 0;
		String deptWithMaxValue = "";
		Set<String> set = map.keySet();
		for (String key: set){
			if (maxValue < map.get(key)){
				maxValue = map.get(key);
				deptWithMaxValue = key;
			}
		}
		System.out.println(deptWithMaxValue);
		Assert.assertEquals(deptWithMaxValue, expectedDept);
		System.out.println("Test 1 end");
	}

	@AfterMethod
	void tearDown(){
		driver.close();
	}
}
