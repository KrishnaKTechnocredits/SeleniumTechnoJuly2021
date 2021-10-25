package margi.Assignment_9;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

/*Verfiy Employee count and Employee name in each deptment.

Sample Output: Employee Count in 7001-Admin dept.
               Employee name belongs to 7001-Admin dept*/

public class Assignment_9 {

	WebDriver driver;

	@BeforeClass
	void launchBrowser() {
		System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		System.out.println("STEP : Launch Browser");
		driver.get("http://automationbykrishna.com/#");

		System.out.println("STEP : Navigate to Demo Tables");
		driver.findElement(By.linkText("Demo Tables")).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	@AfterClass
	void releaseResources() {
		driver.close();
	}

	HashMap<String, ArrayList<String>> getMapOfEmpAndDept() {
		System.out.println("STEP : find map of Employee name and count in each department");
		HashMap<String, ArrayList<String>> mapOfEmpAndDept = new HashMap<String, ArrayList<String>>();
		int rowCount = driver.findElements(By.xpath("//table[@class = 'table table-striped']/tbody/tr")).size();
		for (int index = 1; index <= rowCount; index++) {
			String deptName = driver
					.findElement(By.xpath("//table[@class = 'table table-striped']/tbody/tr[" + index + "]/td[5]"))
					.getText();
			if (mapOfEmpAndDept.containsKey(deptName)) {
				ArrayList<String> empData = mapOfEmpAndDept.get(deptName);
				empData.add(driver
						.findElement(By.xpath("//table[@class = 'table table-striped']/tbody/tr[" + index + "]/td[3]"))
						.getText());
				mapOfEmpAndDept.put(deptName, empData);
			} else {
				ArrayList<String> empNameList = new ArrayList<>();
				empNameList.add(driver
						.findElement(By.xpath("//table[@class = 'table table-striped']/tbody/tr[" + index + "]/td[3]"))
						.getText());
				mapOfEmpAndDept.put(deptName, empNameList);
			}
		}
		return mapOfEmpAndDept;
	}

	@Test
	public void verifyCountAndName() {
		SoftAssert softAssert = new SoftAssert();
		HashMap<String, ArrayList<String>> map = getMapOfEmpAndDept();
		ArrayList<String> expectedList = new ArrayList<>();
		ArrayList<String> actualList = new ArrayList<>();
		Set<String> setOfDept = map.keySet();

		for (String deptName : setOfDept) {
			if (deptName.equals("7001-Admin")) {
				int expectedCount = 2;
				int actualCount = map.get(deptName).size();
				softAssert.assertEquals(actualCount, expectedCount, "Count Of Employees in Admin Dept are invalid");
				expectedList.add("Abhijit Mane");
				expectedList.add("Prayag Mokate");
				actualList = map.get(deptName);
				softAssert.assertEquals(actualCount, expectedCount, "Name Of Employees in Admin Dept are invalid");
				System.out.println("Employee Count in 7001-Admin dept: " + actualCount);
				System.out.println("Employee name belongs to 7001-Admin dept: " + actualList);
				expectedList.clear();
				actualList.clear();
			} else if (deptName.equals("7002-Finance")) {
				int expectedCount = 2;
				int actualCount = map.get(deptName).size();
				softAssert.assertEquals(actualCount, expectedCount, "Count Of Employees in Finance Dept are invalid");
				expectedList.add("Sumit Mate");
				expectedList.add("Sumit Mate");
				actualList = map.get(deptName);
				softAssert.assertEquals(actualCount, expectedCount, "Name Of Employees in Finance Dept are invalid");
				System.out.println("Employee Count in 7002-Finance dept: " + actualCount);
				System.out.println("Employee name belongs to 7002-Finance dept: " + actualList);
				expectedList.clear();
				actualList.clear();
			} else if (deptName.equals("7003-HR")) {
				int expectedCount = 2;
				int actualCount = map.get(deptName).size();
				softAssert.assertEquals(actualCount, expectedCount, "Count Of Employees in HR Dept are invalid");
				expectedList.add("Sumit Kulkarni");
				expectedList.add("Pawan Belamkar");
				actualList = map.get(deptName);
				softAssert.assertEquals(actualCount, expectedCount, "Name Of Employees in HR Dept are invalid");
				System.out.println("Employee Count in 7003-HR dept: " + actualCount);
				System.out.println("Employee name belongs to 7003-HR dept: " + actualList);
				expectedList.clear();
				actualList.clear();
			} else if (deptName.equals("7013-IT")) {
				int expectedCount = 3;
				int actualCount = map.get(deptName).size();
				softAssert.assertEquals(actualCount, expectedCount, "Count Of Employees in IT Dept are invalid");
				expectedList.add("Nikhil Patne");
				expectedList.add("Chetan Shewale");
				expectedList.add("Priyanka Bhale");
				actualList = map.get(deptName);
				softAssert.assertEquals(actualCount, expectedCount, "Name Of Employees in IT Dept are invalid");
				System.out.println("Employee Count in 7013-IT dept: " + actualCount);
				System.out.println("Employee name belongs to 7013-IT dept: " + actualList);
				expectedList.clear();
				actualList.clear();
			}
			softAssert.assertAll();
		}

	}
}
