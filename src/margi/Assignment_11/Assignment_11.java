package margi.Assignment_11;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Assignment_11 {
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

	// Program 1: Return unique Employees from table-2. [output : size - 8]

	int getUniqueEmpCount() {
		HashSet<String> setOfEmp = new HashSet<>();
		List<WebElement> listOfEmp = driver
				.findElements(By.xpath("//table[@class ='table table-striped']/tbody/tr/td[3]"));
		for (int index = 0; index < listOfEmp.size(); index++) {
			setOfEmp.add(listOfEmp.get(index).getText());
		}
		return setOfEmp.size();
	}

	@Test
	void uniqueEmployees() {
		System.out.println("STEP : find count of unique Employees");
		int expectedCount = 8;
		int actualCount = getUniqueEmpCount();
		System.out.println("Unique Employees in table 2: " + actualCount);
		Assert.assertEquals(actualCount, expectedCount, "Invalid count of unique element");
	}

	// Program 2: print employee id which is duplicate in table-2 [output : 76585]

	HashSet<String> getDuplicateEmpId() {
		HashSet<String> setOfEmpId = new HashSet<>();
		HashSet<String> setOfDuplicateEmpId = new HashSet<>();
		List<WebElement> listOfEmpId = driver
				.findElements(By.xpath("//table[@class ='table table-striped']/tbody/tr/td[2]"));
		for (int index = 0; index < listOfEmpId.size(); index++) {
			if (!setOfEmpId.add(listOfEmpId.get(index).getText())) {
				setOfDuplicateEmpId.add(listOfEmpId.get(index).getText());
			}
		}
		return setOfDuplicateEmpId;
	}

	@Test
	void duplicateEmpId() {
		System.out.println("STEP : find duplicate Employee Id");
		HashSet<String> expectedEmpIdSet = new HashSet<>();
		HashSet<String> actualEmpIdSet = getDuplicateEmpId();
		expectedEmpIdSet.add("76585");
		System.out.println(actualEmpIdSet);
		Assert.assertEquals(actualEmpIdSet, expectedEmpIdSet, "Invalid count of duplicate Employee Id");
	}

	// Program 3: print the name of department having maximum employees. [output :
	// 7013-IT]

	String getDeptNameMaxEmp() {
		HashMap<String, ArrayList<String>> mapOfEmpAndDept = new HashMap<String, ArrayList<String>>();
		int rowCount = driver.findElements(By.xpath("//table[@class = 'table table-striped']/tbody/tr")).size();
		for (int index = 1; index <= rowCount; index++) {
			String deptName = driver
					.findElement(By.xpath("//table[@class = 'table table-striped']/tbody/tr[" + index + "]/td[5]"))
					.getText();
			List<WebElement> list = driver
					.findElements(By.xpath("//table[@class='table table-striped']/tbody//td[5][text()='" + deptName
							+ "']/preceding-sibling::td[2]"));
			ArrayList<String> empNameList = new ArrayList<>();
			for (int innerIndex = 0; innerIndex < list.size(); innerIndex++) {
				empNameList.add(list.get(innerIndex).getText());
			}
			mapOfEmpAndDept.put(deptName, empNameList);
		}

		int maxEmpCount = 0;
		String maxDept = "";
		Set<String> setOfDept = mapOfEmpAndDept.keySet();
		for (String deptName : setOfDept) {
			int currentEmpCount = mapOfEmpAndDept.get(deptName).size();
			if (currentEmpCount > maxEmpCount) {
				maxEmpCount = currentEmpCount;
				maxDept = deptName;
			}
		}
		return maxDept;
	}

	@Test
	void DeptNameWithMaxEmp() {
		System.out.println("STEP: find department having maximum employee");
		String expectedName = "7013-IT";
		String actualName = getDeptNameMaxEmp();
		System.out.println("Department Name having maximum Employees: " + actualName);
		Assert.assertEquals(actualName, expectedName, "Invalid Department name having maximum employees");
	}
}
