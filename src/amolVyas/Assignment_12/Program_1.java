package amolVyas.Assignment_12;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import amolVyas.Assignment_5.Action;

public class Program_1 {

	WebDriver driver;

	@BeforeClass
	void getstart() {
		driver = Action.start("https://datatables.net/extensions/autofill/examples/initialisation/focus.html");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	void getDetailsOfLocation() {
		int pageCount = driver
				.findElements(By.xpath("//a[@class='paginate_button ' or @class='paginate_button current']")).size();
		Set<String> offices = new LinkedHashSet();
		for (int index = 1; index <= pageCount; index++) {
			int rowCount = driver.findElements(By.xpath("//table[@id='example']/tbody/tr")).size();
			for (int innerIndex = 1; innerIndex <= rowCount; innerIndex++) {
				String office = driver
						.findElement(By.xpath("//table[@id='example']/tbody/tr[" + innerIndex + "]/td[3]")).getText();
				offices.add(office);
			}
			driver.findElement(By.xpath("//a[@id='example_next']")).click();
		}
		System.out.println(offices);
		Assert.assertEquals(offices.size(), 7);
	}

	@AfterClass
	void closeConnection() {
		driver.close();
	}

}
