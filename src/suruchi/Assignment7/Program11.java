package suruchi.Assignment7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base.PredefinedActions;

public class Program11 {

	WebDriver driver;

	@BeforeClass
	void launch() throws InterruptedException {
		driver = PredefinedActions.start();
		Thread.sleep(2000);
		driver.findElement(By.linkText("Demo Tables")).click();
		Thread.sleep(2000);
	}

	@Parameters("username")
	@Test
	void findEmployeeWithUsername(@Optional("mkanani") String username) {
		int totalRows = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size();
		boolean isPresent = true;
		for (int rowIndex = 1; rowIndex <= totalRows; rowIndex++) {
			String table = driver.findElement(By.xpath("//table[@id='table1']//tbody//td[text()='" + rowIndex + "']"))
					.getText();
			if (table.contains(username)) {
				isPresent = true;
				break;
			}
			Assert.assertTrue(isPresent);
		}
	}

	@AfterClass
	void close() {
		driver.close();
	}
}