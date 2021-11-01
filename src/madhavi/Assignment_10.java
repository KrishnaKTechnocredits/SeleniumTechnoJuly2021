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

//Similar to Assignment-9 but verification should be against managerid.
public class Assignment_10 {
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
	public TreeMap<String, ArrayList<String>> getEmpNameMngID() {
		System.out.println("STEP3 :Verfiy Employee count and Employee name in each deptment.");
		int rowCount = driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr")).size();
		TreeMap<String, ArrayList<String>> map = new TreeMap<String, ArrayList<String>>();
		for (int index = 1; index <= rowCount; index++) {
			String mngID =driver.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr[" + index + "]/td[4]"))
					.getText();
			String employeeName = driver.findElement(By.xpath(
					"//table[@class='table table-striped']/tbody/tr[" + index + "]/td[5]/preceding-sibling::td[2]"))
					.getText();
			if (map.containsKey(mngID)) {
				ArrayList<String> employeeNames = map.get(mngID);
				employeeNames.add(employeeName);
				map.put(mngID, employeeNames);
			} else {
				ArrayList<String> employeeNames = new ArrayList<String>();
				employeeNames.add(employeeName);
				map.put(mngID, employeeNames);
			}
		}
		System.out.println(map);
		return map;
	}

	@Test
	void verifymanageridAndEmployeeName() {
		TreeMap<String, ArrayList<String>> actualResult = getEmpNameMngID();
		TreeMap<String, ArrayList<String>> expectedResult = new TreeMap<String, ArrayList<String>>();
		ArrayList<String> List20209MngID = new ArrayList<String>();
		List20209MngID.add("Abhijit Mane");
		List20209MngID.add("Sumit Kulkarni");
		List20209MngID.add("Pawan Belamkar");
		expectedResult.put("20209", List20209MngID);
		ArrayList<String> List20205MngID  = new ArrayList<String>();
		List20205MngID.add("Sumit Mate");
		List20205MngID.add("Prayag Mokate");
		List20205MngID.add("Sumit Mate");
		List20205MngID.add("Nikhil Patne");
		expectedResult.put("20205", List20205MngID);
		ArrayList<String> List10101MngID = new ArrayList<String>();
		List10101MngID.add("Chetan Shewale");
		List10101MngID.add("Priyanka Bhale");
		expectedResult.put("10101", List10101MngID);
		Assert.assertEquals(actualResult, expectedResult);
	}

	@AfterClass
	public void closeBrowser() {
		driver.quit();
	}
}
