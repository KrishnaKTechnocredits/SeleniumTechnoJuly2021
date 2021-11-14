package suruchi.Assignment7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.PredefinedActions;

public class Program1to3 {

	WebDriver driver;

	@BeforeClass
	void launch() throws InterruptedException {
		driver = PredefinedActions.start();
		Thread.sleep(2000);
		driver.findElement(By.linkText("Demo Tables")).click();
		Thread.sleep(2000);
	}

	@Test(priority = 1)
	void totalTablesInPage() {
		int expectedTableCount = 4;
		int actualTableCount = driver.findElements(By.tagName("table")).size();
		Assert.assertEquals(actualTableCount, expectedTableCount);
	}

	@Test(priority = 2)
	void totalRowsInTable1() {
		int expectedRowCount = 5;
		int actualRowCount = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size();
		Assert.assertEquals(actualRowCount, expectedRowCount);
	}

	@Test(priority = 3)
	void totalColumnsInTable1() {
		int expectedColumnCount = 4;
		int actualColumnCount = driver.findElements(By.xpath("//table[@id='table1']/thead/tr/th")).size();
		Assert.assertEquals(actualColumnCount, expectedColumnCount);
	}

	@AfterClass
	void close() {
		driver.close();
	}
}