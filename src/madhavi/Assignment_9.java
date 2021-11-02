package madhavi;

import java.util.ArrayList;
import java.util.TreeMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

//Verfiy Employee count and Employee name in each deptment.
public class Assignment_9 {

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

	@Test
	public TreeMap<String, ArrayList<String>> getEmpNameCount() {
		System.out.println("STEP3 :Verfiy Employee count and Employee name in each deptment.");
		int rowCount = driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr")).size();
		TreeMap<String, ArrayList<String>> map = new TreeMap<String, ArrayList<String>>();
		for (int index = 1; index <= rowCount; index++) {
			String DeptName = driver
					.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr[" + index + "]/td[5]"))
					.getText();
			String employeeName = driver.findElement(By.xpath(
					"//table[@class='table table-striped']/tbody/tr[" + index + "]/td[5]/preceding-sibling::td[2]"))
					.getText();
			if (map.containsKey(DeptName)) {
				ArrayList<String> employeeNames = map.get(DeptName);
				employeeNames.add(employeeName);
				map.put(DeptName, employeeNames);
			} else {
				ArrayList<String> employeeNames = new ArrayList<String>();
				employeeNames.add(employeeName);
				map.put(DeptName, employeeNames);
			}
		}
		System.out.println(map);
		return map;
	}

	@Test
	void verifyEmployeeCountAndEmployeeName() {
		TreeMap<String, ArrayList<String>> actualResult = getEmpNameCount();
		TreeMap<String, ArrayList<String>> expectedResult = new TreeMap<String, ArrayList<String>>();
		ArrayList<String> adminList = new ArrayList<String>();
		adminList.add("Abhijit Mane");
		adminList.add("Prayag Mokate");
		expectedResult.put("7001-Admin", adminList);
		ArrayList<String> financeList = new ArrayList<String>();
		financeList.add("Sumit Mate");
		financeList.add("Sumit Mate");
		expectedResult.put("7002-Finance", financeList);
		ArrayList<String> hrList = new ArrayList<String>();
		hrList.add("Sumit Kulkarni");
		hrList.add("Pawan Belamkar");
		expectedResult.put("7003-HR", hrList);
		ArrayList<String> listIT = new ArrayList<String>();
		listIT.add("Nikhil Patne");
		listIT.add("Chetan Shewale");
		listIT.add("Priyanka Bhale");
		expectedResult.put("7013-IT", listIT);
		Assert.assertEquals(actualResult, expectedResult);
	}

	@AfterClass
	public void closeBrowser() {
		driver.quit();
	}
}
