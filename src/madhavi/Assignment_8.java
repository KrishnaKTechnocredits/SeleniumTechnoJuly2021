package madhavi;

import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

//Return a map of Deptname and count of employee within each deptment.
public class Assignment_8 {

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
	public TreeMap<String, Integer> getCountOfEachDept() {
		System.out.println("STEP3 : Get Department name and count of employee within each department");
		int rowCount = driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr")).size();
		TreeMap<String, Integer> map = new TreeMap<String, Integer>();
		for (int index = 1; index <= rowCount; index++) {
			String DeptName = driver
					.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr[" + index + "]/td[5]"))
					.getText();
			if (map.containsKey(DeptName))
				map.put(DeptName, map.get(DeptName) + 1);
			else
				map.put(DeptName, 1);

		}
		System.out.println(map);
		return map;

	}

	@Test
	public void validateDeptName() {
		TreeMap<String, Integer> map = getCountOfEachDept();
		Set<String> keyElem = map.keySet();
		for (String deptname : keyElem) {
			if (deptname.equals("7001-Admin")) {
				int actualEmpCount = map.get(deptname);
				int expectedEmpCount = 2;
				Assert.assertEquals(actualEmpCount, expectedEmpCount);
			} else if (deptname.equals("7002-Finance")) {
				int actualEmpCount = map.get(deptname);
				int expectedEmpCount = 2;
				Assert.assertEquals(actualEmpCount, expectedEmpCount);
			} else if (deptname.equals("7003-HR")) {
				int actualEmpCount = map.get(deptname);
				int expectedEmpCount = 2;
				Assert.assertEquals(actualEmpCount, expectedEmpCount);

			} else if (deptname.equals("7013-IT")) {
				int actualEmpCount = map.get(deptname);
				int expectedEmpCount = 3;
				Assert.assertEquals(actualEmpCount, expectedEmpCount);
			}
		}
	}

	@AfterClass
	public void closeBrowser() {
		driver.quit();
	}
}