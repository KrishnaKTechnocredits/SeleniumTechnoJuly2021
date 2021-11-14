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

public class Program8 {

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
	void printLastNameOfEmployee(@Optional("ppatro") String username) {
		Map<String, String> nameMap = new HashMap<>();
		nameMap.put("mkanani", "Maulik");
		nameMap.put("kkanani", "Krishna");
		nameMap.put("dboda", "Dhara");
		nameMap.put("asharma", "Abhishek");
		nameMap.put("ppatro", "Priya");

		int totalRows = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size();
		String firstName = "";

		for (int rowIndex = 1; rowIndex <= totalRows; rowIndex++) {
			String actualUserName = driver
					.findElement(By.xpath("//table[@id='table1']//tbody/tr[" + rowIndex + "]/td[4]")).getText();
			if (actualUserName.equals(username)) {
				firstName = driver.findElement(By.xpath("//table[@id='table1']//tbody/tr[" + rowIndex + "]/td[2]"))
						.getText();
				break;
			}
		}
		Assert.assertEquals(firstName, nameMap.get(username));
	}

	@AfterClass
	void close() {
		driver.close();
	}
}