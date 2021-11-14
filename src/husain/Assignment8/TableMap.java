package husain.Assignment8;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.PredefinedActions;

public class TableMap {
	WebDriver driver;

	@BeforeMethod
	void setup() throws InterruptedException {
		driver = PredefinedActions.start();
		driver.findElement(By.linkText("Demo Tables")).click();
		Thread.sleep(3000);
	}

	HashMap<String, Integer> getDeptMap() {
		WebElement table = driver.findElement(By.xpath("//table[@class='table table-striped']/tbody"));
		int rowCount = table.findElements(By.tagName("tr")).size();
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		for (int index = 1; index <= rowCount; index++) {
			String dept = driver
					.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr[" + index + "]/td[5]"))
					.getText();
			if (map.containsKey(dept)) {
				int count = map.get(dept);
				map.put(dept, ++count);
			} else
				map.put(dept, 1);
		}
		System.out.println(map);
		return map;
	}

	@Test
	void validateDeptMap() {
		HashMap<String, Integer> map = getDeptMap();
		Set<String> set = map.keySet();
		for (String deptName : set) {
			if (deptName.equals("7001-Admin")) {
				int actualEmpCount = map.get(deptName);
				int expectedEmpCount = 2;
				Assert.assertEquals(actualEmpCount, expectedEmpCount, "Admin Count does not match.");
			} else if (deptName.equals("7002-Finance")) {
				int actualEmpCount = map.get(deptName);
				int expectedEmpCount = 2;
				Assert.assertEquals(actualEmpCount, expectedEmpCount, "Finance Count does not match.");
			} else if (deptName.equals("7003-HR")) {
				int actualEmpCount = map.get(deptName);
				int expectedEmpCount = 2;
				Assert.assertEquals(actualEmpCount, expectedEmpCount, "HR Count does not match.");
			} else if (deptName.equals("7013-IT")) {
				int actualEmpCount = map.get(deptName);
				int expectedEmpCount = 3;
				Assert.assertEquals(actualEmpCount, expectedEmpCount, "IT Count does not match.");
			}
		}

	}

	@AfterMethod
	void windingDown() {
		driver.close();
	}
}
