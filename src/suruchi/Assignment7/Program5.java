package suruchi.Assignment7;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base.PredefinedActions;

public class Program5 {

	WebDriver driver;

	@BeforeClass
	void launch() throws InterruptedException {
		driver = PredefinedActions.start();
		Thread.sleep(2000);
		driver.findElement(By.linkText("Demo Tables")).click();
		Thread.sleep(2000);
	}

	@Parameters("columnName")
	@Test
	void getIndexOfColumnName(@Optional("Username") String columnName) {
		Map<String, Integer> columnNamesMap = new HashMap<>();
		columnNamesMap.put("#", 1);
		columnNamesMap.put("First Name", 2);
		columnNamesMap.put("Last Name", 3);
		columnNamesMap.put("Username", 4);

		int totalColumns = driver.findElements(By.xpath("//table[@id='table1']/thead/tr/th")).size();
		Integer actualIndex = 0;
		for (int colIndex = 1; colIndex <= totalColumns; colIndex++) {
			String actualColumnName = driver
					.findElement(By.xpath("//table[@id='table1']//thead/tr/th[" + colIndex + "]")).getText();
			if (actualColumnName.equals(columnName)) {
				actualIndex = colIndex;
				break;
			}
		}
		Assert.assertEquals(actualIndex, columnNamesMap.get(columnName));
	}

	@AfterClass
	void close() {
		driver.close();
	}
}