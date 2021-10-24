package suruchi.Assignment7;

import java.util.HashSet;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.PredefinedActions;

public class Program9 {

	WebDriver driver;

	@BeforeClass
	void launch() throws InterruptedException {
		driver = PredefinedActions.start();
		Thread.sleep(2000);
		driver.findElement(By.linkText("Demo Tables")).click();
		Thread.sleep(2000);
	}

	@Test
	void totalUniqueSurnamesInTable() {
		int totalRows = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size();
		Set<String> nameSet = new HashSet<>();

		for (int rowIndex = 1; rowIndex <= totalRows; rowIndex++) {
			String lastName = driver.findElement(By.xpath("//table[@id='table1']//tbody/tr[" + rowIndex + "]/td[3]"))
					.getText();
			nameSet.add(lastName);
		}
		Assert.assertEquals(nameSet.size(), 4);
	}

	@AfterClass
	void close() {
		driver.close();
	}
}