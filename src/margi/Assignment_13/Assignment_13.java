package margi.Assignment_13;

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

//https://datatables.net/extensions/autofill/examples/initialisation/focus.html
//Program : Verify whole table is sorted based on Employee age.

public class Assignment_13 {

	WebDriver driver;

	@BeforeClass
	void launchBrowser() {
		System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
		System.out.println("STEP : Launch Browser");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://datatables.net/extensions/autofill/examples/initialisation/focus.html");
		driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
	}

	@AfterClass
	void releaseResources() {
		driver.close();
	}

	// navigate through all pages
	boolean navigatePages() {
		boolean flag = false;
		String currentPage = driver.findElement(By.xpath("//a[@id = 'example_next']")).getAttribute("class");
		if (!currentPage.contains("disabled")) {
			flag = true;
			System.out.println("STEP: Click on Next Page");
		}
		driver.findElement(By.xpath("//a[@id = 'example_next']")).click();
		return flag;
	}

	ArrayList<Employee> actualSortedTableOnAge() {
		System.out.println("STEP : Click on 1st page");
		driver.findElement(By.xpath("//a[@data-dt-idx='1']")).click();
		ArrayList<Employee> actualSort = new ArrayList<>();
		System.out.println("Click on Age header");
		driver.findElement(By.xpath("//table[@id='example']/thead/tr/th[text()='Age']")).click();
		boolean flag = true;
		while (flag == true) {
			int rowCount = driver.findElements(By.xpath("//table[@id='example']/tbody/tr")).size();
			for (int index = 1; index <= rowCount; index++) {
				String name = driver.findElement(By.xpath("//table[@id='example']/tbody/tr[" + index + "]/td[1]"))
						.getText();
				String position = driver.findElement(By.xpath("//table[@id='example']/tbody/tr[" + index + "]/td[2]"))
						.getText();
				String office = driver.findElement(By.xpath("//table[@id='example']/tbody/tr[" + index + "]/td[3]"))
						.getText();
				int age = Integer.parseInt(
						driver.findElement(By.xpath("//table[@id='example']/tbody/tr[" + index + "]/td[4]")).getText());
				String startDate = driver.findElement(By.xpath("//table[@id='example']/tbody/tr[" + index + "]/td[5]"))
						.getText();
				String salary = driver.findElement(By.xpath("//table[@id='example']/tbody/tr[" + index + "]/td[6]"))
						.getText();
				Employee emp = new Employee(name, position, office, age, startDate, salary);
				actualSort.add(emp);
			}
			flag = navigatePages();
		}
		return actualSort;
	}

	ArrayList<Employee> expectedSortedTableOnAge() {
		System.out.println("STEP : Click on 1st page");
		driver.findElement(By.xpath("//a[@data-dt-idx='1']")).click();
		ArrayList<Employee> expectedSort = new ArrayList<>();
		boolean flag = true;
		while (flag == true) {
			int rowCount = driver.findElements(By.xpath("//table[@id='example']/tbody/tr")).size();
			for (int index = 1; index <= rowCount; index++) {
				String name = driver.findElement(By.xpath("//table[@id='example']/tbody/tr[" + index + "]/td[1]"))
						.getText();
				String position = driver.findElement(By.xpath("//table[@id='example']/tbody/tr[" + index + "]/td[2]"))
						.getText();
				String office = driver.findElement(By.xpath("//table[@id='example']/tbody/tr[" + index + "]/td[3]"))
						.getText();
				int age = Integer.parseInt(
						driver.findElement(By.xpath("//table[@id='example']/tbody/tr[" + index + "]/td[4]")).getText());
				String startDate = driver.findElement(By.xpath("//table[@id='example']/tbody/tr[" + index + "]/td[5]"))
						.getText();
				String salary = driver.findElement(By.xpath("//table[@id='example']/tbody/tr[" + index + "]/td[6]"))
						.getText();
				Employee emp = new Employee(name, position, office, age, startDate, salary);
				expectedSort.add(emp);
			}
			flag = navigatePages();
		}
		Collections.sort(expectedSort);
		return expectedSort;
	}

	@Test
	public void verifySortedTableBasedOnAge() {
		System.out.println("STEP : Verify table sorting based on age");
		ArrayList<Employee> expectedList = expectedSortedTableOnAge();
		ArrayList<Employee> actualList = actualSortedTableOnAge();
		Assert.assertEquals(actualList, expectedList, "Invalid table sorting based on age");
	}
}
