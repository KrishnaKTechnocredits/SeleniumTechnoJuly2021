package suruchi.Assignment7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.PredefinedActions;

public class Program6 {
	WebDriver driver;

	@BeforeClass
	void launch() throws InterruptedException {
		driver = PredefinedActions.start();
		Thread.sleep(2000);
		driver.findElement(By.linkText("Demo Tables")).click();
		Thread.sleep(2000);
	}

	@Test
	void printRowsOfTable() {
		System.out.println(driver.findElement(By.xpath("//table[@id='table1']//tbody")).getText());
	}

	@AfterClass
	void close() {
		driver.close();
	}
}