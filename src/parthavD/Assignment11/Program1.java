package parthavD.Assignment11;

import java.util.HashSet;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.PredefinedActions;

public class Program1 {
	
	WebDriver driver;

	@BeforeMethod
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
		int rowSize = driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr")).size();
		
		HashSet<Integer> set = new HashSet<>();
		for (int index = 1;index <= rowSize;index++){
			Integer empID = Integer.parseInt(driver.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr["+index+"]/td[2]")).getText());
			set.add(empID);
		}
		int expectedUniqueEmployees = 8;
		Assert.assertEquals(expectedUniqueEmployees, set.size());
		System.out.println("Test End");
		
	}
	
	@AfterMethod
	void tearDown(){
		driver.close();
	}
	
}
