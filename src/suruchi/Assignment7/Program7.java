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

public class Program7 {
	WebDriver driver;

	@BeforeClass
	void launch() throws InterruptedException {
		driver = PredefinedActions.start();
		Thread.sleep(2000);
		driver.findElement(By.linkText("Demo Tables")).click();
		Thread.sleep(2000);
	}

	@Parameters("fname")
	@Test
	void printLastNameOfEmployee(@Optional("Abhishek") String fname) {
		Map<String, String> nameMap = new HashMap<>();
		nameMap.put("Maulik", "Kanani");
		nameMap.put("Krishna", "Kanani");
		nameMap.put("Dhara", "Boda");
		nameMap.put("Abhishek", "Sharma");
		nameMap.put("Priya", "Patro");

		int totalRows = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size();
		String lastName = "";

		for (int rowIndex = 1; rowIndex <= totalRows; rowIndex++) {
			String firstName = driver.findElement(By.xpath("//table[@id='table1']//tbody/tr[" + rowIndex + "]/td[2]"))
					.getText();
			if (firstName.equals(fname)) {
				lastName = driver.findElement(By.xpath("//table[@id='table1']//tbody/tr[" + rowIndex + "]/td[3]"))
						.getText();
				break;
			}
		}
		Assert.assertEquals(lastName, nameMap.get(fname));
	}

	@AfterClass
	void close() {
		driver.close();
	}
}