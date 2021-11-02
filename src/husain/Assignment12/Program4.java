/*
 * Assignment - 12: 24th Oct'2021
https://datatables.net/extensions/autofill/examples/initialisation/focus.html

program 4 : sorting works on employee name or not. 

 */

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

public class Program4 {

	WebDriver driver;
	ArrayList<String> empNamesSort;

	@BeforeMethod
	void setup() {
		driver = PredefinedActions
				.start("https://datatables.net/extensions/autofill/examples/initialisation/focus.html");
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}

	ArrayList<String> getEmployeeList() {
		System.out.println("STEP - Get List of employee names");
		ArrayList<String> empName = new ArrayList<String>();
		int paginationCount = driver.findElements(By.xpath("//span/a[@aria-controls='example']/following-sibling::a"))
				.size();
		for (int i = 1; i <= paginationCount + 1; i++) {
			int rowcount = driver.findElements(By.xpath("//table[@id='example']/tbody/tr")).size();
			for (int index = 1; index <= rowcount; index++) {
				String name = driver.findElement(By.xpath("//table[@id='example']/tbody/tr[" + index + "]/td[1]"))
						.getText();
				empName.add(name);
			}
			if (i != paginationCount + 1)
				driver.findElement(By.xpath("//span/a[@aria-controls='example']/following-sibling::a[" + i + "]"))
						.click();
		}
		return empName;

	}

	@Test
	void sortEmpName() {
		System.out.println("STEP - Sort list of employee names retrieved from table");
		empNamesSort = getEmployeeList();
		Collections.sort(empNamesSort, Collections.reverseOrder());
	}

	@Test
	void tableSorting() {
		System.out.println("STEP - Get sorted list of employee names from the table");
		driver.findElement(By.xpath("//table[@id='example']/thead/tr/th[1]")).click();
		ArrayList<String> tableSortedNames = getEmployeeList();
		System.out.println("STEP - Validate both sorted lists are identical");
		Assert.assertEquals(empNamesSort, tableSortedNames, "Sorted list does not match");

	}

	@AfterMethod
	void windingDown() {
		driver.close();
	}

}
