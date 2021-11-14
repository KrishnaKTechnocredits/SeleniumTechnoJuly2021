package suruchi;

import java.util.LinkedHashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.PredefinedActions;

public class Assignment8 {

	WebDriver driver;

	@BeforeClass
	void start() throws InterruptedException {
		driver = PredefinedActions.start();
		Thread.sleep(2000);
		driver.findElement(By.linkText("Demo Tables")).click();
		Thread.sleep(2000);
	}

	@Test
	void printDeptEmployeeMap() {
		int totalRows = driver.findElements(By.xpath("//table[@class='table table-striped']//tbody//tr")).size();

		Map<String, Integer> expectedDeptEmployeeMap = new LinkedHashMap<>();
		expectedDeptEmployeeMap.put("7001-Admin", 2);
		expectedDeptEmployeeMap.put("7002-Finance", 2);
		expectedDeptEmployeeMap.put("7003-HR", 2);
		expectedDeptEmployeeMap.put("7013-IT", 3);

		Map<String, Integer> actualDeptEmployeeMap = new LinkedHashMap<>();

		for (int rowIndex = 1; rowIndex <= totalRows; rowIndex++) {
			String dept = driver
					.findElement(By.xpath("//table[@class='table table-striped']//tbody//tr[" + rowIndex + "]/td[5]"))
					.getText();
			if (actualDeptEmployeeMap.containsKey(dept))
				actualDeptEmployeeMap.put(dept, actualDeptEmployeeMap.get(dept) + 1);
			else
				actualDeptEmployeeMap.put(dept, 1);
		}
		Assert.assertEquals(actualDeptEmployeeMap, expectedDeptEmployeeMap);
		System.out.println(actualDeptEmployeeMap);
	}

	@AfterClass
	void close() {
		driver.close();
	}
}