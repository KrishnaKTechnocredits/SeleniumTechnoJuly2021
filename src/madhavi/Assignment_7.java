package madhavi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Assignment_7 {

	WebDriver driver;

	@BeforeClass
	public void startBrowser() {
		System.setProperty("webdriver.chrome.driver", "./resources/chromedriver.exe");
		System.out.println("STEP1 : Launch Browser");
		driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("http://automationbykrishna.com/#");

		System.out.println("STEP2 : Click to Demo Tables");
		driver.findElement(By.linkText("Demo Tables")).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	// How many tables are there on the page
	@Test(priority = 1)
	public void testCase1() {
		System.out.println("STEP3 : find total tables on page");
		int expectedTableCount = 4;
		System.out.println(driver.findElements(By.tagName("table")).size());
		int actualTableCount = driver.findElements(By.tagName("table")).size();
		Assert.assertEquals(actualTableCount, expectedTableCount);

	}

	// How many rows are there in EMPLOYEE BASIC INFORMATION
	@Test(priority = 2)
	public void testCase2() {
		System.out.println("STEP3 : find total rows in EMPLOYEE BASIC INFORMATION");
		int expectedRowCount = 5;
		System.out.println(driver.findElements(By.xpath("//table[@id='table1']/tbody/tr" + "")).size());
		int actualRowCount = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size();
		Assert.assertEquals(actualRowCount, expectedRowCount);

	}

	// how many columns are there in EMPLOYEE BASIC INFORMATION
	@Test(priority = 3)
	public void testCase3() {
		System.out.println("STEP3 : find total columns in EMPLOYEE BASIC INFORMATION");
		int expectedColumnCount = 4;
		System.out.println(driver.findElements(By.xpath("//table[@id='table1']/thead/tr/th" + "")).size());
		int actualColumnCount = driver.findElements(By.xpath("//table[@id='table1']/thead/tr/th")).size();
		Assert.assertEquals(actualColumnCount, expectedColumnCount);

	}

	// return first name of all the employees
	@Test(priority = 4)
	public void testCase4() {
		System.out.println("STEP3 : find first name of all the employees");
		ArrayList<String> listOfFirstName = new ArrayList<String>();
		int rowCount = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size();
		for (int index = 1; index <= rowCount; index++) {
			String firstName = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + index + "]/td[2]"))
					.getText();
			listOfFirstName.add(firstName);
			System.out.println(listOfFirstName);
		}

		int expectedFirstnameCount = 5;
		int actaulFirstnameCount = listOfFirstName.size();
		Assert.assertTrue(actaulFirstnameCount == expectedFirstnameCount, "Test is passed");

	}

	// return index of given column name
	@Parameters("columnName")
	@Test(priority = 5)
	void getColIndex(@Optional("Last Name") String columnName) {
		System.out.println("STEP3 : Print index of given column name");
		Map<String, Integer> columnNames = new HashMap<>();
		columnNames.put("#", 1);
		columnNames.put("First Name", 2);
		columnNames.put("Last Name", 3);
		columnNames.put("Username", 4);
		int totalCol = driver.findElements(By.xpath("//table[@id='table1']/thead/tr/th")).size();
		int targetIndex = 0;
		for (int index = 1; index <= totalCol; index++) {
			String headerText = driver.findElement(By.xpath("//table[@id='table1']/thead/tr/th[" + index + "]"))
					.getText();
			if (headerText.equals(columnName)) {
				targetIndex = index;
				break;
			}
		}
		System.out.println(+targetIndex);
		System.out.println("Test verification is done");
		Assert.assertTrue(targetIndex == columnNames.get(columnName), "Test is passed");
	}

	// print all rows
	@Test(priority = 6)
	public void printRows() {
		System.out.println("STEP3 : print all rows");
		List<WebElement> totalRows = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));
		for (int rowIndex = 1; rowIndex <= totalRows.size(); rowIndex++) {
			System.out.println(
					driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + rowIndex + "]")).getText());
		}
		int expectedResult = 5;
		int actualResult = totalRows.size();
		System.out.println("Test verification is done");
		Assert.assertTrue(expectedResult == actualResult);
	}

	// print lastname of the employee whoes first name is Abhishek
	@Parameters("name")
	@Test(priority = 7)
	public void printLastName(@Optional("Abhishek") String name) {
		System.out.println("STEP3 :  print lastname of the employee whoes first name is Abhishek");
		Map<String, String> nameMap = new HashMap<>();
		nameMap.put("Maulik", "Kanani");
		nameMap.put("Krishna", "Kanani");
		nameMap.put("Dhara", "Boda");
		nameMap.put("Abhishek", "Sharma");
		nameMap.put("Priya", "Patro");
		int totalRows = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size();
		String output = "";
		for (int index = 1; index <= totalRows; index++) {
			String currentName = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + index + "]/td[2]"))
					.getText();
			if (currentName.equals(name)) {
				System.out.println(output = driver
						.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + index + "]/td[3]")).getText());
				break;
			}
		}

		Assert.assertEquals(output, nameMap.get(name));
		System.out.println("Test verification is done");
	}

	// print the firstname of the employee whoes username is ppatro
	@Parameters("uname")
	@Test(priority = 8)
	public void printFirstname(@Optional("ppatro") String uname) {
		System.out.println("STEP3 :  print the firstname of the employee whoes username is ppatro");
		Map<String, String> map = new HashMap<>();
		map.put("mkanani", "Maulik");
		map.put("kkanani", "Krishna");
		map.put("dboda", "Dhara");
		map.put("asharma", "Abhishek");
		map.put("ppatro", "Priya");
		int totalRows = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size();
		String firstname = "";
		for (int index = 1; index <= totalRows; index++) {
			String currentName = driver.findElement(By.xpath("//table[@id='table1']//tbody/tr[" + index + "]/td[4]"))
					.getText();
			if (currentName.equals(uname)) {

				System.out.println(firstname = driver
						.findElement(By.xpath("//table[@id='table1']//tbody/tr[" + index + "]/td[2]")).getText());
				break;
			}

		}
		Assert.assertEquals(firstname, map.get(uname));
		System.out.println("Test verification is done");
	}
	// how many unique surnames we have in EMPLOYEE BASIC INFORMATION (4)

	@Test(priority = 9)
	public void printUnquieSurnames() {
		System.out.println("STEP3 : how many unique surnames we have in EMPLOYEE BASIC INFORMATION ");
		int totalRows = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size();
		LinkedHashSet<String> listOfSurname = new LinkedHashSet<>();
		for (int index = 1; index <= totalRows; index++) {
			String surName = driver.findElement(By.xpath("//table[@id='table1']//tbody/tr[" + index + "]/td[3]"))
					.getText();
			listOfSurname.add(surName);
		}
		System.out.println(listOfSurname);
		int expectedResult = 4;
		int actualResult = listOfSurname.size();
		Assert.assertTrue(expectedResult == actualResult);
		System.out.println("Test verification is done");
	}

	// return a map of firstname and username.
	@Test(priority = 10)
	public void printMapFirstnameUserName() {
		System.out.println("STEP3 : Return a map of firstname and username.");
		HashMap<String, String> hm = new HashMap<String, String>();
		int totalRows = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size();
		for (int index = 1; index <= totalRows; index++) {
			String username = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + index + "]/td[4]"))
					.getText();
			String firstName = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + index + "]/td[2]"))
					.getText();
			hm.put(firstName, username);

		}
		System.out.println(hm);
		int expectedResult = 5;
		int actualResult = hm.size();
		Assert.assertTrue(expectedResult == actualResult);
		System.out.println("Test verification is done");
	}

	// is table contains emplyee having username as kkanani.
	@Test(priority = 11)
	public void tableContainsUsername() {
		System.out.println("STEP3 :  Verify table contains emplyee having username as kkanani..");
		int totalRows = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size();
		boolean isElementPresent = true;
		String username = "kkanani";
		for (int index = 1; index <= totalRows; index++) {
			String element = driver
					.findElement(By.xpath("//table[@id='table1']/tbody//td[4][text()='" + username + "']")).getText();
			if (username.equals(element)) {
				isElementPresent = true;
				break;
			}

		}
		Assert.assertTrue(isElementPresent);
		System.out.println("Test verification is done");

	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
