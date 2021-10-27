package husain.Assignment12;

import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.PredefinedActions;

public class Program5 {
	WebDriver driver;
	ArrayList<String> positionSort;

	@BeforeMethod
	void setup() {
		driver = PredefinedActions
				.start("https://datatables.net/extensions/autofill/examples/initialisation/focus.html");
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}

	ArrayList<String> getPositionList() {
		System.out.println("STEP - Get List of positions");
		ArrayList<String> lisOfPositions = new ArrayList<String>();
		int paginationCount = driver.findElements(By.xpath("//span/a[@aria-controls='example']/following-sibling::a"))
				.size();
		for (int i = 1; i <= paginationCount + 1; i++) {
			int rowcount = driver.findElements(By.xpath("//table[@id='example']/tbody/tr")).size();
			for (int index = 1; index <= rowcount; index++) {
				String position = driver.findElement(By.xpath("//table[@id='example']/tbody/tr[" + index + "]/td[2]"))
						.getText();
				lisOfPositions.add(position);
			}
			if (i != paginationCount + 1)
				driver.findElement(By.xpath("//span/a[@aria-controls='example']/following-sibling::a[" + i + "]"))
						.click();
		}

		return lisOfPositions;
	}

	@Test
	void sortPostions() {
		System.out.println("STEP - Sort list of positions retrieved from table");
		positionSort = getPositionList();
		Collections.sort(positionSort);
	}

	@Test
	void tableSorting() {
		System.out.println("STEP - Get sorted list of positions from the table");
		driver.findElement(By.xpath("//table[@id='example']/thead/tr/th[2]")).click();
		ArrayList<String> tableSort = getPositionList();
		System.out.println("STEP - Validate both sorted lists are identical");
		Assert.assertEquals(positionSort, tableSort, "Sorted list does not match");
	}

	@AfterMethod
	void windingDown() {
		driver.close();
	}
}
