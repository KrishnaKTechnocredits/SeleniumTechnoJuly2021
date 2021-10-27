package shalakaP.Assignment10;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.PredefinedActions;

public class EmployeeNameWithManagerid {
	WebDriver driver;

	@BeforeClass
	public void getStart() {
		driver = PredefinedActions.start();
		System.out.println("Step-Click on Demo Table");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.linkText("Demo Tables")).click();
	}

	@AfterClass
	public void getClose() {
		driver.close();
	}

	HashMap<String, ArrayList<String>> getManagerId() {
		HashMap<String, ArrayList<String>> managerIdMap = new HashMap<String, ArrayList<String>>();

		int rowCnt = driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr/td[4]")).size();
		for (int index = 1; index <= rowCnt; index++) {
			String managerId = driver
					.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr[" + index + "]/td[4]"))
					.getText();
			String empName = driver.findElement(By.xpath(
					"//table[@class='table table-striped']/tbody/tr[" + index + "]/td[4]/preceding-sibling::td[1]"))
					.getText();

			if (managerIdMap.containsKey(managerId)) {
				ArrayList<String> currentList = managerIdMap.get(managerId);
				currentList.add(empName);
				managerIdMap.put(managerId, currentList);
			} else {
				ArrayList<String> empList = new ArrayList<String>();
				empList.add(empName);
				managerIdMap.put(managerId, empList);
			}
		}
		return managerIdMap;
	}

	@Test
	public void verifyEmpName() {
		HashMap<String, ArrayList<String>> EmpNAmeMap = getManagerId();
		System.out.println("Step-Print employee list and employee count having manager id-20209");
		ArrayList<String> actualEmpList = EmpNAmeMap.get("20209");
		System.out.println(
				"Emp list-" + actualEmpList + " Emp Count -" + actualEmpList.size() + " having manager id-20209");
		Assert.assertTrue(actualEmpList.size() == 3);

		ArrayList<String> expectedList = new ArrayList<String>();
		expectedList.add("Abhijit Mane");
		expectedList.add("Sumit Kulkarni");
		expectedList.add("Pawan Belamkar");
		Assert.assertEquals(actualEmpList, expectedList);

		actualEmpList.clear();
		expectedList.clear();

		System.out.println("Step-Print employee list and employee count having manager id-20205");
		actualEmpList = EmpNAmeMap.get("20205");
		System.out.println(
				"Emp list-" + actualEmpList + " Emp Count -" + actualEmpList.size() + " having manager id-20205");
		Assert.assertTrue(actualEmpList.size() == 4);
		expectedList.add("Sumit Mate");
		expectedList.add("Prayag Mokate");
		expectedList.add("Sumit Mate");
		expectedList.add("Nikhil Patne");
		Assert.assertEquals(actualEmpList, expectedList);
		actualEmpList.clear();
		expectedList.clear();

		System.out.println("Step-Print employee list and employee count having manager id-10101");
		actualEmpList = EmpNAmeMap.get("10101");
		System.out.println(
				"Emp list-" + actualEmpList + " Emp Count -" + actualEmpList.size() + " having manager id-10101");
		Assert.assertTrue(actualEmpList.size() == 2);
		expectedList.add("Chetan Shewale");
		expectedList.add("Priyanka Bhale");
		Assert.assertEquals(actualEmpList, expectedList);

	}
}
