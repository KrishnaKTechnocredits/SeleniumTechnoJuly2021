/*Assignment-13:

https://datatables.net/extensions/autofill/examples/initialisation/focus.html

Program : Verify whole table is sorted based on Employee age.*/

package amolVyas.Assignment_13;

import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import amolVyas.Assignment_5.Action;

public class Assignment_13 {

	WebDriver driver;

	@BeforeClass
	void start() {
		driver = Action.start("https://datatables.net/extensions/autofill/examples/initialisation/focus.html");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}

	@AfterClass
	void tearDown() {
		driver.quit();
	}

	ArrayList<Employee> getEmployeeValues() {
		ArrayList<Employee> TableData = new ArrayList();
		int pages = driver
				.findElements(By.xpath("//div/span/a[@class='paginate_button current' or @class='paginate_button ']"))
				.size();
		for (int i = 1; i <= pages; i++) {
			driver.findElement(By.xpath("//div/span/a[text()=" + i + "]")).click();
			int rows = driver.findElements(By.xpath("//table[@id='example']/tbody/tr")).size();
			for (int j = 1; j <= rows; j++) {
				String name = driver.findElement(By.xpath("//table[@id='example']/tbody/tr[" + j + "]/td[1]"))
						.getText();
				String position = driver.findElement(By.xpath("//table[@id='example']/tbody/tr[" + j + "]/td[2]"))
						.getText();
				String office = driver.findElement(By.xpath("//table[@id='example']/tbody/tr[" + j + "]/td[3]"))
						.getText();
				String age = driver.findElement(By.xpath("//table[@id='example']/tbody/tr[" + j + "]/td[4]")).getText();
				String start_date = driver.findElement(By.xpath("//table[@id='example']/tbody/tr[" + j + "]/td[4]"))
						.getText();
				String salary = driver.findElement(By.xpath("//table[@id='example']/tbody/tr[" + j + "]/td[5]"))
						.getText();
				Employee emp1 = new Employee(name, position, office, age, start_date, salary);
				TableData.add(emp1);
			}
		}
		return TableData;

	}

	@Test
	void verifySorting() {
		ArrayList<Employee> expectedTableData = new ArrayList();
		expectedTableData = getEmployeeValues();
		Collections.sort(expectedTableData);
		System.out.println(expectedTableData);
		driver.findElement(By.xpath("//table[@id='example']/thead/tr/th[4]")).click();
		ArrayList<Employee> actualTableData = new ArrayList();
		actualTableData = getEmployeeValues();
		System.out.println(actualTableData);

	}

}
