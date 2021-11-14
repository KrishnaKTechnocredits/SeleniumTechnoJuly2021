package margi.Assignment_10;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

/*Similar to Assignment-9 but verification should be against managerid.

Sample Output: Employee Count reports to manager having manager id - 20209.
               Employee name reports to manager having manager id - 20209.
               
xpath axes : (axes  - navigation)*/

public class Assignment_10 {

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

	HashMap<String, ArrayList<String>> getMapOfEmpAndManagerId() {
		System.out.println("STEP : find map of Employee name and count in each ManagerId");
		HashMap<String, ArrayList<String>> mapOfEmpAndId = new HashMap<String, ArrayList<String>>();
		int rowCount = driver.findElements(By.xpath("//table[@class = 'table table-striped']/tbody/tr")).size();
		for (int index = 1; index <= rowCount; index++) {
			String managerId = driver
					.findElement(By.xpath("//table[@class = 'table table-striped']/tbody/tr[" + index + "]/td[4]"))
					.getText();
			List<WebElement> list = driver
					.findElements(By.xpath("//table[@class='table table-striped']/tbody//td[4][text()='" + managerId
							+ "']/preceding-sibling::td[1]"));
			ArrayList<String> empList = new ArrayList<>();
			for (int innerIndex = 0; innerIndex < list.size(); innerIndex++) {
				empList.add(list.get(innerIndex).getText());
			}
			mapOfEmpAndId.put(managerId, empList);
		}
		return mapOfEmpAndId;
	}

	@Test
	public void verifyCountAndName() {
		SoftAssert softAssert = new SoftAssert();
		HashMap<String, ArrayList<String>> map = getMapOfEmpAndManagerId();
		ArrayList<String> expectedList = new ArrayList<>();
		ArrayList<String> actualList = new ArrayList<>();
		Set<String> setOfManagerId = map.keySet();

		for (String managerId : setOfManagerId) {
			if (managerId.equals("20209")) {
				int expectedCount = 3;
				int actualCount = map.get(managerId).size();
				softAssert.assertEquals(actualCount, expectedCount,
						"Invalid Employee Count reports to manager having manager id - 20209");
				expectedList.add("Abhijit Mane");
				expectedList.add("Sumit Kulkarni");
				expectedList.add("Pawan Belamkar");
				actualList = map.get(managerId);
				softAssert.assertEquals(actualCount, expectedCount,
						"Invalid Employee name reports to manager having manager id - 20209");
				System.out.println("Employee Count reports to manager having manager id - 20209: " + actualCount);
				System.out.println("Employee name reports to manager having manager id - 20209: " + actualList);
				expectedList.clear();
				actualList.clear();
			} else if (managerId.equals("20205")) {
				int expectedCount = 4;
				int actualCount = map.get(managerId).size();
				softAssert.assertEquals(actualCount, expectedCount,
						"Invalid Employee Count reports to manager having manager id - 20205");
				expectedList.add("Sumit Mate");
				expectedList.add("Prayag Mokate");
				expectedList.add("Sumit Mate");
				expectedList.add("Nikhil Patne");
				actualList = map.get(managerId);
				softAssert.assertEquals(actualCount, expectedCount,
						"Invalid Employee name reports to manager having manager id - 20205");
				System.out.println("Employee Count reports to manager having manager id - 20205: " + actualCount);
				System.out.println("Employee name reports to manager having manager id - 20205: " + actualList);
				expectedList.clear();
				actualList.clear();
			} else if (managerId.equals("10101")) {
				int expectedCount = 2;
				int actualCount = map.get(managerId).size();
				softAssert.assertEquals(actualCount, expectedCount,
						"Invalid Employee Count reports to manager having manager id - 10101");
				expectedList.add("Chetan Shewale");
				expectedList.add("Priyanka Bhale");
				actualList = map.get(managerId);
				softAssert.assertEquals(actualCount, expectedCount,
						"Invalid Employee name reports to manager having manager id - 10101");
				System.out.println("Employee Count reports to manager having manager id - 10101: " + actualCount);
				System.out.println("Employee name reports to manager having manager id - 10101: " + actualList);
				expectedList.clear();
				actualList.clear();
			}
			softAssert.assertAll();
		}

	}
}
