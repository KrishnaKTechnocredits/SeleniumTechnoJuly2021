package suruchi.Assignment7;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.PredefinedActions;

public class Program10 {

	WebDriver driver;

	@BeforeClass
	void launch() throws InterruptedException {
		driver = PredefinedActions.start();
		Thread.sleep(2000);
		driver.findElement(By.linkText("Demo Tables")).click();
		Thread.sleep(2000);
	}

	@Test
	void getFirstNameAndUserNameFromTable(){
		Map<String, String> expectedNameUserNameMap = new HashMap<>();
		expectedNameUserNameMap.put("Maulik", "mkanani");
		expectedNameUserNameMap.put("Krishna", "kkanani");
		expectedNameUserNameMap.put("Dhara", "dboda");
		expectedNameUserNameMap.put("Abhishek", "asharma");
		expectedNameUserNameMap.put("Priya", "ppatro");
		
		Map<String, String> nameUserNameMap = new HashMap<>();
		int totalRows = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size();
		
		for(int rowIndex = 1; rowIndex <= totalRows; rowIndex++) {
			String firstName = driver.findElement(By.xpath("//table[@id='table1']//tbody/tr[" + rowIndex + "]/td[2]"))
					.getText();
			String username = driver
					.findElement(By.xpath("//table[@id='table1']//tbody/tr[" + rowIndex + "]/td[4]")).getText();
			nameUserNameMap.put(firstName, username);
		}
		Assert.assertEquals(nameUserNameMap, expectedNameUserNameMap);
	}
	
	@AfterClass
	void close() {
		driver.close();
	}
}