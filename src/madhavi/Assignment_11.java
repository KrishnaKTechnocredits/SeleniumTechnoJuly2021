package madhavi;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
/*Assginment - 11: 24th Oct'2021
Program 1: Return unique Employees from table-2.  
output : size - 8

Program 2: print employee id which is duplicate in table-2 
output : 76585 

Program 3: print the name of deptment having maximum employees. 
output : 7013-IT*/
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Assignment_11 {
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

	// Program 1: Return unique Employees from table-2.
	@Test(priority = 1)
	void getUniqueEmployeesCount() {
		System.out.println("STEP3 :Get unique Employees from table-2.");
		int rowCount = driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr")).size();
		HashSet<String> employeeNameSet = new HashSet<String>();
		for (int index = 1; index <= rowCount; index++) {
			String employeeName = driver.findElement(By.xpath(
					"//table[@class='table table-striped']/tbody/tr[" + index + "]/td[5]/preceding-sibling::td[2]"))
					.getText();
			employeeNameSet.add(employeeName);
		}
		int expectedSet = 8;
		int actaulResult = employeeNameSet.size();
		Assert.assertEquals(actaulResult, expectedSet);
		System.out.println("Test verification is done");
		System.out.println(employeeNameSet.size());
	}

	// print employee id which is duplicate in table-2
	@Test(priority = 2)
	void getDuplicateEmployeeID() {
		System.out.println("STEP3 :Print employee id which is duplicate in table-2");
		int rowCount = driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr")).size();
		HashSet<String> duplicateSet = new HashSet<String>();
		String duplicateEMPID = "";
		for (int index = 1; index <= rowCount; index++) {
			String employeeID = driver
					.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr[" + index + "]/td[2]"))
					.getText();
			if (!duplicateSet.add(employeeID))
				duplicateEMPID = employeeID;
		}
		String actaulResult = duplicateEMPID;
		String expectedSet = "76585";
		Assert.assertEquals(actaulResult, expectedSet);
		System.out.println("Test verification is done");
		System.out.println(duplicateEMPID);
	}

	// print the name of department having maximum employees.
	@Test(priority = 3)
	void getDeptHavingMaxEmp() {
		System.out.println("STEP3 :Print the name of deptment having maximum employees.");
		int max = 1;
		String department = "";
		int rowCount = driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr")).size();
		Map<String, Integer> map = new HashMap<String, Integer>();

		for (int index = 1; index <= rowCount; index++) {
			String deptName = driver
					.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr[" + index + "]/td[5]"))
					.getText();
			if (map.containsKey(deptName)) {
				map.put(deptName, map.get(deptName) + 1);
				if (map.get(deptName) + 1 > max) {
					max = map.get(deptName) + 1;
					department = deptName;
				}

			} else
				map.put(deptName, 1);
		}
		String actaulResult = department;
		String expectedSet = "7013-IT";
		Assert.assertEquals(actaulResult, expectedSet);
		System.out.println("Test verification is done");
		System.out.println(department);
	}

	@AfterClass
	public void closeBrowser() {
		driver.quit();
	}
}
