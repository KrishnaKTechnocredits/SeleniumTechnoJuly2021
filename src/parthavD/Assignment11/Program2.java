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

public class Program2 {

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
		System.out.println("The duplicate employee IDs in the table are:");
		int exectedDuplicateEmpId = 76585;
		int empID;
		int duplicateEmpID = 0;
		for (int index = 1; index <= rowSize; index++) {
			empID = Integer.parseInt(
					driver.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr[" + index + "]/td[2]"))
							.getText());
			if (!set.add(empID)) {
				System.out.println(empID);
				duplicateEmpID = empID;
			}
		}
		Assert.assertEquals(duplicateEmpID, exectedDuplicateEmpId);
		System.out.println("Test1 End");
	}
	
	@AfterMethod
	void tearDown(){
		driver.close();
	}
}
