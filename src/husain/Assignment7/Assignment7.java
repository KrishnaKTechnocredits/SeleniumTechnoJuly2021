package husain.Assignment7;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.xml.bind.SchemaOutputResolver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.PredefinedActions;

public class Assignment7 {

	WebDriver driver;

	@BeforeClass
	void setup() {

		driver = PredefinedActions.start();
		driver.findElement(By.linkText("Demo Tables")).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	@Test(priority = 1)
	void findTableCount() {
		System.out.println("STEP - Find table count");
		int tableCount = driver.findElements(By.tagName("table")).size();
		System.out.println("Total number of tables on the page are " + tableCount);
	}

	@Test(priority = 2)
	void findRows() {
		System.out.println("STEP - Find row count");
		int rowCount = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size();
		System.out.println("Total number of rows on the Employee Basic Information table are " + rowCount);
	}

	@Test(priority = 3)
	void findColumns() {
		System.out.println("STEP - Find column count");
		int columnCount = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr[1]/td")).size();
		System.out.println("Total number of columns on the Employee Basic Information table are " + columnCount);
	}

	@Test(priority = 4)
	void printEmployeeFirstNames() {
		System.out.println("STEP - Find list of first names");
		int rowCount = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size();
		ArrayList<String> fnames = new ArrayList<String>();
		for (int index = 1; index <= rowCount; index++) {
			String name = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + index + "]/td[2]")).getText();
			fnames.add(name);
		}
		System.out.println("List of first names is " + fnames);
	}

	@Test(priority = 5)
	void findColName() {
		System.out.println("STEP - Find index of column Last Name");
		int columnCount = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr[1]/td")).size();
		String colName = "Last Name";
		int colIndex = 0;
		for (int index = 1; index <= columnCount; index++) {
			String name = driver.findElement(By.xpath("//table[@id='table1']/thead/tr/th[" + index + "]")).getText();
			if (colName.equals(name))
				colIndex = index;
		}
		System.out.println("Index of column Last Name is " + colIndex);
	}

	@Test(priority = 6)
	void printAllRows() {
		System.out.println("STEP - Print all rows");
		System.out.println(driver.findElement(By.id("table1")).getText());
	}

	@Test(priority = 7)
	void printSpecificLastName() {
		System.out.println("STEP - Find last name of Abhisek");
		String fname = "Abhishek";
		String lname = "";
		int rowCount = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size();
		for (int index = 1; index <= rowCount; index++) {
			String name = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + index + "]/td[2]")).getText();
			if (fname.equals(name)) {
				lname = driver
						.findElement(
								By.xpath("//table[@id='table1']/tbody/tr[" + index + "]/td[2]/following-sibling::td"))
						.getText();
			}
		}
		System.out.println("Last name of Abhishek is " + lname);
	}

	@Test(priority = 8)
	void printSpecificFirstName() {
		System.out.println("STEP - Find first name of ppatro");
		String uname = "ppatro";
		String fname = "";
		int rowCount = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size();
		for (int index = 1; index <= rowCount; index++) {
			String name = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + index + "]/td[4]")).getText();
			if (uname.equals(name)) {
				fname = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + index + "]/td[2]")).getText();
			}
		}
		System.out.println("First name of ppatro is " + fname);
	}

	@Test(priority = 9)
	void printUniqueLastNames() {
		System.out.println("STEP - Find unique list of last names");
		int rowCount = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size();
		Set<String> lnames = new HashSet<String>();
		for (int index = 1; index <= rowCount; index++) {
			String name = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + index + "]/td[3]")).getText();
			lnames.add(name);
		}
		System.out.println("List of unique last names is " + lnames);
	}

	@Test(priority = 10)
	void printMapOfNames() {
		System.out.println("STEP - Print map of first and last names");
		int rowCount = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size();
		Map<String, String> names = new HashMap<String, String>();
		for (int index = 1; index <= rowCount; index++) {
			String fname = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + index + "]/td[2]"))
					.getText();
			String lname = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + index + "]/td[3]"))
					.getText();
			names.put(fname, lname);
		}
		System.out.println("Map of names is " + names);
	}

	@Test(priority = 11)
	void findUsername() {

		System.out.println("STEP - Verify if username kkanani is present");
		int rowCount = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size();
		String uname = "kkanani";
		if (driver.findElement(By.xpath("//table[@id='table1']/tbody/tr//td[4][text()='kkanani']")).isDisplayed())
			System.out.println("The username kkanani is present in the table");
		else
			System.out.println("The username kkanani does not exist");

	}

	@AfterClass
	void windingDown() {
		driver.close();
	}

}
