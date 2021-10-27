package margi.Assignment_12;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
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
import org.testng.asserts.SoftAssert;

//https://datatables.net/extensions/autofill/examples/initialisation/focus.html

public class Assignment_12 {

	WebDriver driver;

	@BeforeClass
	void launchBrowser() {
		System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
		System.out.println("STEP : Launch Browser");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://datatables.net/extensions/autofill/examples/initialisation/focus.html");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}

	@AfterClass
	void releaseResources() {
		driver.close();
	}

	// navigate through all pages
	boolean navigatePages() {
		boolean flag = false;
		String currentPage = driver.findElement(By.xpath("//a[@id = 'example_next']")).getAttribute("class");
		if (!currentPage.contains("disabled")) {
			flag = true;
			System.out.println("STEP: Click on Next Page");
		}
		driver.findElement(By.xpath("//a[@id = 'example_next']")).click();
		return flag;
	}

	// Program 1:Find unique Office location by navigating through all pages

	HashSet<String> getUniqueOfficeLocation() {
		System.out.println("STEP : Click on 1st page");
		driver.findElement(By.xpath("//a[@data-dt-idx='1']")).click();
		HashSet<String> uniqueOfficeLoc = new HashSet<String>();
		boolean flag = true;
		while (flag == true) {
			List<WebElement> listOfOffice = driver.findElements(By.xpath("//table[@id='example']/tbody/tr/td[3]"));
			for (int index = 0; index < listOfOffice.size(); index++) {
				uniqueOfficeLoc.add(listOfOffice.get(index).getText());
			}
			flag = navigatePages();
		}
		return uniqueOfficeLoc;
	}

	@Test
	public void uniqueOfficeLocation() {
		System.out.println("STEP : Find unique Office location by navigating through all pages");
		HashSet<String> expectedSet = new HashSet<>();
		expectedSet.add("Edinburgh");
		expectedSet.add("London");
		expectedSet.add("New York");
		expectedSet.add("San Francisco");
		expectedSet.add("Sydney");
		expectedSet.add("Singapore");
		expectedSet.add("Tokyo");
		HashSet<String> actualSet = getUniqueOfficeLocation();
		System.out.println(actualSet);
		Assert.assertEquals(actualSet, expectedSet, "Invalid unique Office Location");
	}

	// program 2:print position per employee count by navigating through all pages.

	LinkedHashMap<String, ArrayList<String>> getPositionPerEmp() {
		System.out.println("STEP : Click on 1st page");
		driver.findElement(By.xpath("//a[@data-dt-idx='1']")).click();
		LinkedHashMap<String, ArrayList<String>> mapOfPositionEmp = new LinkedHashMap<>();
		boolean flag = true;
		while (flag == true) {
			int rowCount = driver.findElements(By.xpath("//table[@id='example']/tbody/tr")).size();
			for (int index = 1; index <= rowCount; index++) {
				String position = driver.findElement(By.xpath("//table[@id='example']/tbody/tr[" + index + "]/td[2]"))
						.getText();
				if (mapOfPositionEmp.containsKey(position)) {
					ArrayList<String> addListOfEmp = mapOfPositionEmp.get(position);
					addListOfEmp.add(driver
							.findElement(By.xpath("//table[@id='example']/tbody/tr[" + index + "]/td[1]")).getText());
					mapOfPositionEmp.put(position, addListOfEmp);
				} else {
					ArrayList<String> listOfEmp = new ArrayList<>();
					listOfEmp.add(driver.findElement(By.xpath("//table[@id='example']/tbody/tr[" + index + "]/td[1]"))
							.getText());
					mapOfPositionEmp.put(position, listOfEmp);
				}
			}
			flag = navigatePages();
		}
		return mapOfPositionEmp;
	}

	@Test
	public void verifyPositionPerEmpCount() {

		System.out.println("STEP: find position per employee count");
		SoftAssert softAssert = new SoftAssert();
		LinkedHashMap<String, ArrayList<String>> map = getPositionPerEmp();
		Set<String> setOfPositions = map.keySet();
		for (String name : setOfPositions) {
			if (name.equals("Accountant")) {
				int expectedCount = 2;
				int actualCount = map.get(name).size();
				softAssert.assertEquals(actualCount, expectedCount, "Invalid Employee count for Accountant position");
				System.out.println("Employee Count for " + name + " position is: " + actualCount);
			}

			else if (name.equals("Chief Executive Officer (CEO)")) {
				int expectedCount = 1;
				int actualCount = map.get(name).size();
				softAssert.assertEquals(actualCount, expectedCount,
						"Invalid Employee count for Chief Executive Officer (CEO) position");
				System.out.println("Employee Count for " + name + " position is: " + actualCount);
			}

			else if (name.equals("Chief Operating Officer (COO)")) {
				int expectedCount = 1;
				int actualCount = map.get(name).size();
				softAssert.assertEquals(actualCount, expectedCount,
						"Invalid Employee count for Chief Operating Officer (COO) position");
				System.out.println("Employee Count for " + name + " position is: " + actualCount);
			}

			else if (name.equals("Chief Financial Officer (CFO)")) {
				int expectedCount = 1;
				int actualCount = map.get(name).size();
				softAssert.assertEquals(actualCount, expectedCount,
						"Invalid Employee count for Chief Financial Officer (CFO) position");
				System.out.println("Employee Count for " + name + " position is: " + actualCount);
			}

			else if (name.equals("Chief Marketing Officer (CMO)")) {
				int expectedCount = 1;
				int actualCount = map.get(name).size();
				softAssert.assertEquals(actualCount, expectedCount,
						"Invalid Employee count for Chief Marketing Officer (CMO) position");
				System.out.println("Employee Count for " + name + " position is: " + actualCount);
			}

			else if (name.equals("Customer Support")) {
				int expectedCount = 1;
				int actualCount = map.get(name).size();
				softAssert.assertEquals(actualCount, expectedCount,
						"Invalid Employee count for Customer Support position");
				System.out.println("Employee Count for " + name + " position is: " + actualCount);
			}

			else if (name.equals("Data Coordinator")) {
				int expectedCount = 1;
				int actualCount = map.get(name).size();
				softAssert.assertEquals(actualCount, expectedCount,
						"Invalid Employee count for Data Coordinator position");
				System.out.println("Employee Count for " + name + " position is: " + actualCount);
			}

			else if (name.equals("Developer")) {
				int expectedCount = 4;
				int actualCount = map.get(name).size();
				softAssert.assertEquals(actualCount, expectedCount, "Invalid Employee count for Developer position");
				System.out.println("Employee Count for " + name + " position is: " + actualCount);
			}

			else if (name.equals("Director")) {
				int expectedCount = 1;
				int actualCount = map.get(name).size();
				softAssert.assertEquals(actualCount, expectedCount, "Invalid Employee count for Director position");
				System.out.println("Employee Count for " + name + " position is: " + actualCount);
			}

			else if (name.equals("Development Lead")) {
				int expectedCount = 1;
				int actualCount = map.get(name).size();
				softAssert.assertEquals(actualCount, expectedCount,
						"Invalid Employee count for Development Lead position");
				System.out.println("Employee Count for " + name + " position is: " + actualCount);
			}

			else if (name.equals("Financial Controller")) {
				int expectedCount = 1;
				int actualCount = map.get(name).size();
				softAssert.assertEquals(actualCount, expectedCount,
						"Invalid Employee count for Financial Controller position");
				System.out.println("Employee Count for " + name + " position is: " + actualCount);
			}

			else if (name.equals("Integration Specialist")) {
				int expectedCount = 3;
				int actualCount = map.get(name).size();
				softAssert.assertEquals(actualCount, expectedCount,
						"Invalid Employee count for Integration Specialist position");
				System.out.println("Employee Count for " + name + " position is: " + actualCount);
			}

			else if (name.equals("Junior Technical Author")) {
				int expectedCount = 1;
				int actualCount = map.get(name).size();
				softAssert.assertEquals(actualCount, expectedCount,
						"Invalid Employee count for Junior Technical Author position");
				System.out.println("Employee Count for " + name + " position is: " + actualCount);
			}

			else if (name.equals("Javascript Developer")) {
				int expectedCount = 2;
				int actualCount = map.get(name).size();
				softAssert.assertEquals(actualCount, expectedCount,
						"Invalid Employee count for Javascript Developer position");
				System.out.println("Employee Count for " + name + " position is: " + actualCount);
			}

			else if (name.equals("Junior Javascript Developer")) {
				int expectedCount = 1;
				int actualCount = map.get(name).size();
				softAssert.assertEquals(actualCount, expectedCount,
						"Invalid Employee count for Junior Javascript Developer position");
				System.out.println("Employee Count for " + name + " position is: " + actualCount);
			}

			else if (name.equals("Marketing Designer")) {
				int expectedCount = 2;
				int actualCount = map.get(name).size();
				softAssert.assertEquals(actualCount, expectedCount,
						"Invalid Employee count for Marketing Designer position");
				System.out.println("Employee Count for " + name + " position is: " + actualCount);
			}

			else if (name.equals("Office Manager")) {
				int expectedCount = 3;
				int actualCount = map.get(name).size();
				softAssert.assertEquals(actualCount, expectedCount,
						"Invalid Employee count for Office Manager position");
				System.out.println("Employee Count for " + name + " position is: " + actualCount);
			}

			else if (name.equals("Personnel Lead")) {
				int expectedCount = 1;
				int actualCount = map.get(name).size();
				softAssert.assertEquals(actualCount, expectedCount,
						"Invalid Employee count for Personnel Lead position");
				System.out.println("Employee Count for " + name + " position is: " + actualCount);
			}

			else if (name.equals("Post-Sales support")) {
				int expectedCount = 1;
				int actualCount = map.get(name).size();
				softAssert.assertEquals(actualCount, expectedCount,
						"Invalid Employee count for Post-Sales support position");
				System.out.println("Employee Count for " + name + " position is: " + actualCount);
			}

			else if (name.equals("Pre-Sales Support")) {
				int expectedCount = 1;
				int actualCount = map.get(name).size();
				softAssert.assertEquals(actualCount, expectedCount,
						"Invalid Employee count for Pre-Sales Support position");
				System.out.println("Employee Count for " + name + " position is: " + actualCount);
			}

			else if (name.equals("Regional Director")) {
				int expectedCount = 5;
				int actualCount = map.get(name).size();
				softAssert.assertEquals(actualCount, expectedCount,
						"Invalid Employee count for Regional Director position");
				System.out.println("Employee Count for " + name + " position is: " + actualCount);
			}

			else if (name.equals("Regional Marketing")) {
				int expectedCount = 1;
				int actualCount = map.get(name).size();
				softAssert.assertEquals(actualCount, expectedCount,
						"Invalid Employee count for Regional Marketing position");
				System.out.println("Employee Count for " + name + " position is: " + actualCount);
			}

			else if (name.equals("Sales Assistant")) {
				int expectedCount = 3;
				int actualCount = map.get(name).size();
				softAssert.assertEquals(actualCount, expectedCount,
						"Invalid Employee count for Sales Assistant position");
				System.out.println("Employee Count for " + name + " position is: " + actualCount);
			}

			else if (name.equals("Secretary")) {
				int expectedCount = 1;
				int actualCount = map.get(name).size();
				softAssert.assertEquals(actualCount, expectedCount, "Invalid Employee count for Secretary position");
				System.out.println("Employee Count for " + name + " position is: " + actualCount);
			}

			else if (name.equals("Senior Javascript Developer")) {
				int expectedCount = 1;
				int actualCount = map.get(name).size();
				softAssert.assertEquals(actualCount, expectedCount,
						"Invalid Employee count for Senior Javascript Developer position");
				System.out.println("Employee Count for " + name + " position is: " + actualCount);
			}

			else if (name.equals("Senior Marketing Designer")) {
				int expectedCount = 1;
				int actualCount = map.get(name).size();
				softAssert.assertEquals(actualCount, expectedCount,
						"Invalid Employee count for Senior Marketing Designer position");
				System.out.println("Employee Count for " + name + " position is: " + actualCount);
			}

			else if (name.equals("Software Engineer")) {
				int expectedCount = 6;
				int actualCount = map.get(name).size();
				softAssert.assertEquals(actualCount, expectedCount,
						"Invalid Employee count for Software Engineer position");
				System.out.println("Employee Count for " + name + " position is: " + actualCount);
			}

			else if (name.equals("Support Engineer")) {
				int expectedCount = 3;
				int actualCount = map.get(name).size();
				softAssert.assertEquals(actualCount, expectedCount,
						"Invalid Employee count for Support Engineer position");
				System.out.println("Employee Count for " + name + " position is: " + actualCount);
			}

			else if (name.equals("Support Lead")) {
				int expectedCount = 1;
				int actualCount = map.get(name).size();
				softAssert.assertEquals(actualCount, expectedCount, "Invalid Employee count for Support Lead position");
				System.out.println("Employee Count for " + name + " position is: " + actualCount);
			}

			else if (name.equals("System Architect")) {
				int expectedCount = 1;
				int actualCount = map.get(name).size();
				softAssert.assertEquals(actualCount, expectedCount,
						"Invalid Employee count for System Architect position");
				System.out.println("Employee Count for " + name + " position is: " + actualCount);
			}

			else if (name.equals("Systems Administrator")) {
				int expectedCount = 2;
				int actualCount = map.get(name).size();
				softAssert.assertEquals(actualCount, expectedCount,
						"Invalid Employee count for Systems Administrator position");
				System.out.println("Employee Count for " + name + " position is: " + actualCount);
			}

			else if (name.equals("Team Leader")) {
				int expectedCount = 1;
				int actualCount = map.get(name).size();
				softAssert.assertEquals(actualCount, expectedCount, "Invalid Employee count for Team Leader position");
				System.out.println("Employee Count for " + name + " position is: " + actualCount);
			}

			else if (name.equals("Technical Author")) {
				int expectedCount = 1;
				int actualCount = map.get(name).size();
				softAssert.assertEquals(actualCount, expectedCount,
						"Invalid Employee count for Technical Author position");
				System.out.println("Employee Count for " + name + " position is: " + actualCount);
			}
		}
		softAssert.assertAll();
	}

	// Program 3:find out the position with highest and lowest employees.
	LinkedHashMap<String, Integer> getPositionWithHighLowEmp() {
		LinkedHashMap<String, Integer> positionWithEmp = new LinkedHashMap<String, Integer>();
		LinkedHashMap<String, ArrayList<String>> map = getPositionPerEmp();
		int maxCount = 1, minCount = 1;
		String maxEmp = "", minEmp = "";
		for (String emp : map.keySet()) {
			if (maxCount <= map.get(emp).size()) {
				maxCount = map.get(emp).size();
				maxEmp = emp;
			}
		}
		for (String emp : map.keySet()) {
			if (minCount >= map.get(emp).size()) {
				minCount = map.get(emp).size();
				minEmp = emp;
			}
		}
		positionWithEmp.put(maxEmp, maxCount);
		positionWithEmp.put(minEmp, minCount);
		return positionWithEmp;
	}

	@Test
	public void positionWithHighestLowestEmp() {

		System.out.println("STEP : Position with maximum and minimum employees respectively");
		LinkedHashMap<String, Integer> actualMap = getPositionWithHighLowEmp();
		System.out.println(actualMap);
		LinkedHashMap<String, Integer> expectedMap = new LinkedHashMap<String, Integer>();
		expectedMap.put("Software Engineer", 6);
		expectedMap.put("Chief Marketing Officer (CMO)", 1);
		Assert.assertEquals(actualMap, expectedMap, "Invalid maximum and minimum number of employees");
	}

	// program 4:sorting works on employee name or not.
	ArrayList<String> actualSortedName() {
		System.out.println("STEP : Click on 1st page");
		driver.findElement(By.xpath("//a[@data-dt-idx='1']")).click();
		ArrayList<String> actualSort = new ArrayList<>();
		System.out.println("Click on Employee name header");
		driver.findElement(By.xpath("//table[@id='example']/thead/tr/th[text()='Name']")).click();
		boolean flag = true;
		while(flag==true) {
			List<WebElement> list = driver.findElements(By.xpath("//table[@id='example']/tbody/tr/td[1]"));
			for (int index = 0; index < list.size(); index++) {
				actualSort.add(list.get(index).getText());
			}
			flag = navigatePages();
		}
		return actualSort;
	}
	
	ArrayList<String> expectedSortedName() {
		System.out.println("STEP : Click on 1st page");
		driver.findElement(By.xpath("//a[@data-dt-idx='1']")).click();
		ArrayList<String> expectedSort = new ArrayList<>();
		boolean flag = true;
		while(flag==true) {
			List<WebElement> list = driver.findElements(By.xpath("//table[@id='example']/tbody/tr/td[1]"));
			for (int index = 0; index < list.size(); index++) {
				expectedSort.add(list.get(index).getText());
			}
			flag = navigatePages();
		}
		Collections.sort(expectedSort,Collections.reverseOrder());
		return expectedSort;
	}

	@Test
	public void verifySortingOnEmp() {
		System.out.println("STEP : Verify Sorting On Employee name");
		ArrayList<String> actualList = actualSortedName();
		ArrayList<String> expectedList = expectedSortedName();
		Assert.assertEquals(actualList, expectedList, "Invalid Employee name sorting");
	}
	
	// program 5:verify sorting works on position.
	ArrayList<String> actualSortedPosition() {
		System.out.println("STEP : Click on 1st page");
		driver.findElement(By.xpath("//a[@data-dt-idx='1']")).click();
		ArrayList<String> actualSort = new ArrayList<>();
		System.out.println("Click on Position header");
		driver.findElement(By.xpath("//table[@id='example']/thead/tr/th[text()='Position']")).click();
		boolean flag = true;
		while(flag==true) {
			List<WebElement> list = driver.findElements(By.xpath("//table[@id='example']/tbody/tr/td[2]"));
			for (int index = 0; index < list.size(); index++) {
				actualSort.add(list.get(index).getText());
			}
			flag = navigatePages();
		}
		return actualSort;
	}
	
	ArrayList<String> expectedSortedPosition() {
		System.out.println("STEP : Click on 1st page");
		driver.findElement(By.xpath("//a[@data-dt-idx='1']")).click();
		ArrayList<String> expectedSort = new ArrayList<>();
		boolean flag = true;
		while(flag==true) {
			List<WebElement> list = driver.findElements(By.xpath("//table[@id='example']/tbody/tr/td[2]"));
			for (int index = 0; index < list.size(); index++) {
				expectedSort.add(list.get(index).getText());
			}
			flag = navigatePages();
		}
		Collections.sort(expectedSort);
		return expectedSort;
	}

	@Test
	public void verifySortingOnPosition() {
		System.out.println("STEP : Verify Sorting On Position");
		ArrayList<String> actualList = actualSortedPosition();
		ArrayList<String> expectedList = expectedSortedPosition();
		Assert.assertEquals(actualList, expectedList, "Invalid position sorting");
	}
}
