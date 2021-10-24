package suruchi.Assignment7;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.PredefinedActions;

public class Program4 {

	WebDriver driver;

	@BeforeClass
	void launch() throws InterruptedException {
		driver = PredefinedActions.start();
		Thread.sleep(2000);
		driver.findElement(By.linkText("Demo Tables")).click();
		Thread.sleep(2000);
	}

	ArrayList<String> getFirstNameFromTable1() {
		int totalRows = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size();
		ArrayList<String> al = new ArrayList<>();

		for (int rowIndex = 1; rowIndex <= totalRows; rowIndex++) {
			String firstName = driver.findElement(By.xpath("//table[@id='table1']//tbody/tr["+rowIndex+"]/td[2]")).getText();
			al.add(firstName);
		}
		return al;
	}

	@Test
	void verifyFirstNamesFromTable1() {
		ArrayList<String> expectedList = new ArrayList<>();
		expectedList.add("Maulik");
		expectedList.add("Krishna");
		expectedList.add("Dhara");
		expectedList.add("Abhishek");
		expectedList.add("Priya");

		ArrayList<String> actualList = getFirstNameFromTable1();
		Assert.assertEquals(actualList, expectedList);
	}

	@AfterClass
	void close() {
		driver.close();
	}
}