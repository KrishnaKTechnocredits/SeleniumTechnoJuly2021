package amolVyas;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import amolVyas.Assignment_5.Action;

public class Assignment_11 {
	WebDriver driver;

	@BeforeClass
	void startUp() {
		driver = Action.start();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		System.out.println("STEP-Navigate to Demo Tables");
		driver.findElement(By.xpath("//a[text()='Demo Tables']")).click();
	}

	@Test
	void getCountOfUniqueEmpFromTable2() {
		List<WebElement> list = driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr/td[3]"));
		Set<String> set = new HashSet();
		for (WebElement emp : list) {
			set.add(emp.getText());
		}
		System.out.println("Count of Unique emp from table is " + set.size());
		Assert.assertEquals(set.size(), 8);

	}

	@Test
	void getDuplicateEmpIDFromTable2() {
		List<WebElement> list = driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr/td[2]"));
		List<String> empID = new ArrayList();
		Set<String> duplicateEmpID = new HashSet();
		for (WebElement wb : list) {
			empID.add(wb.getText());
		}
		for (int index = 0; index < empID.size(); index++) {
			if (empID.indexOf(empID.get(index)) != empID.lastIndexOf(empID.get(index))) {
				duplicateEmpID.add(empID.get(index));
			}
		}
		List<String> expectedEmp = new ArrayList();
		expectedEmp.add("76585");
		Assert.assertEquals(duplicateEmpID, expectedEmp);
	}

	@Test
	void getDeptHavingMaxEmp() {
		Map<String, Integer> map = new HashMap();
		int rowCount = driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr")).size();
		for (int index = 1; index <= rowCount; index++) {
			String deptID = driver
					.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr[" + index + "]/td[5]"))
					.getText();
			if (map.containsKey(deptID)) {
				int count = map.get(deptID);
				map.put(deptID, ++count);
			} else
				map.put(deptID, 1);
		}
		String deptName = "";
		int count = 0;
		Set<String> dept = map.keySet();
		for (String deptname : dept) {
			if (map.get(deptname) > count) {
				count = map.get(deptname);
				deptName = deptname;
			}
		}
		System.out.println("Maximum Emp dept is :" + deptName);
		Assert.assertEquals(deptName, "7013-IT");
	}

	@AfterClass
	void tearDown() {
		driver.close();
	}

}
