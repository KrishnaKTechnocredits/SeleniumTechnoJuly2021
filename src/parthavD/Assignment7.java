/*Assignment - 7 : 23th Oct'2021
1) How many tables are there on the page*/

package parthavD;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.PredefinedActions;

public class Assignment7 {

	WebDriver driver;

	@BeforeClass
	WebDriver BrowserStart() {
		this.driver = PredefinedActions.start();
		return driver;
	}

	@Test
	void test1() {
		System.out.println("Step - Launch Automation by Krishna URL");
		driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
		System.out.println("Step - Navigate to demo tables section");
		driver.findElement(By.xpath("//a[@id='demotable']")).click();
		System.out.println("Step - Get the actual count of tables");
		List<WebElement> list = driver.findElements(By.xpath("//table"));
		int expectedTableCount = 4;
		Assert.assertEquals(list.size(), expectedTableCount);
		System.out.println("Test1 End");
	}

	@Test
	void test2() {
		List<WebElement> list = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));
		int expectedTableCount = 5;
		Assert.assertEquals(list.size(), expectedTableCount);
		System.out.println("Test2 End");
	}

	@Test
	void test3() {
		List<WebElement> list = driver.findElements(By.xpath("//table[@id='table1']/thead/tr/th"));
		int expectedColumnCount = 4;
		Assert.assertEquals(list.size(), expectedColumnCount);
		System.out.println("Test3 End");
	}

	ArrayList<String> getFirstNames() {
		int rowSize = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size();
		ArrayList<String> list = new ArrayList<>();

		for (int index = 1; index <= rowSize; index++) {
			list.add(driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + index + "]/td[2]")).getText());
		}

		return list;
	}

	@Test
	void test4() {
		ArrayList<String> list = getFirstNames();
		ArrayList<String> list1 = new ArrayList<String>();
		list1.add("Maulik");
		list1.add("Krishna");
		list1.add("Dhara");
		list1.add("Abhishek");
		list1.add("Priya");
		Assert.assertTrue(list.equals(list1));
		System.out.println("Test4 End");
	}

	@Test
	void test5() {
		int rowSize = driver.findElements(By.xpath("//table[@id='table1']/thead/tr/th")).size();
		String passedColumn = "Last Name";
		String checkColumn = "";
		int index;
		for (index = 1; index <= rowSize; index++) {
			checkColumn = driver.findElement(By.xpath("//table[@id='table1']/thead/tr/th["+index+"]")).getText();
			if (passedColumn.equals(checkColumn))
				break;
		}
		int expectedIndex = 3;
		Assert.assertEquals(expectedIndex, index);
		System.out.println("Test5 End");

	}
	
	@Test
	void test6() {
		int rowSize = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size();
		for (int index = 1; index <= rowSize; index++) {
			System.out.println(driver.findElement(By.xpath("//table[@id='table1']/tbody/tr["+index+"]")).getText());
		}
		System.out.println("Test6 End");

	}
	
	@Test
	void test7() {
		int rowSize = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size();
		String firstName = "Abhishek";
		String expectedText = "Sharma";
		String actualName = "";
		String actualText = "";
		for (int index = 1; index <= rowSize; index++) {
			actualName =  driver.findElement(By.xpath("//table[@id='table1']/tbody/tr["+index+"]/td[2]")).getText();
			if (firstName.equals(actualName)){
				actualText = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr["+index+"]/td[3]")).getText();
			}
		}
		
		Assert.assertEquals(expectedText, actualText);
		System.out.println("Test7 End");

	}

	
	@Test
	void test8() {
		int rowSize = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size();
		String username = "ppatro";
		String expectedText = "Priya";
		String actualText = "";
		for (int index = 1; index <= rowSize; index++) {
			String actualUserName =  driver.findElement(By.xpath("//table[@id='table1']/tbody/tr["+index+"]/td[4]")).getText();
			if (username.equals(actualUserName)){
				actualText = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr["+index+"]/td[4]//preceding-sibling::td[2]")).getText();
				System.out.println(actualText);
			}
		}
		Assert.assertEquals(expectedText, actualText);
		System.out.println("Test8 End");

	}
	
	@Test
	void test9() {
		int rowSize = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size();
		int expectedSurnamesCount = 4;
		String surname = "";
		ArrayList<String> list = new ArrayList<>();
		for (int index = 1; index <= rowSize; index++) {
			surname = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr["+index+"]/td[3]")).getText();
			if (!list.contains(surname))
				list.add(surname);
		}
		Assert.assertEquals(expectedSurnamesCount, list.size());
		System.out.println("Test9 End");

	}
	
	@Test
	void test10() {
		int rowSize = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size();
		int columnSize = driver.findElements(By.xpath("//table[@id='table1']/thead/tr/th")).size();
		String firstName = "";
		String username = "";
		Map<String, String> map = new HashMap<>();
		for (int index = 1; index <= rowSize; index++) {
			for (int innerIndex = 1;innerIndex <= columnSize;innerIndex++){
				username = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr["+index+"]/td[4]")).getText();
				firstName = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr["+index+"]/td[2]")).getText();
				map.put(username,firstName);
			}
		}
		Map<String, String> expectedMap = new HashMap<>();
		expectedMap.put("mkanani", "Maulik");
		expectedMap.put("kkanani", "Krishna");
		expectedMap.put("dboda", "Dhara");
		expectedMap.put("asharma", "Abhishek");
		expectedMap.put("ppatro", "Priya");
		Assert.assertEquals(map,expectedMap);
		System.out.println("Test10 End");

	}
	
	@Test
	void test11() {
		String namecheck = "kkanani";
		int expectedCount = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr/td[contains(text(),'"+namecheck+"')]")).size();
		Assert.assertTrue(expectedCount > 0);
		System.out.println("Test11 End");
	}

	@AfterClass
	void TearDown() {
		System.out.println("Teardown method  begins");
		this.driver.close();
		System.out.println("Teardown method executed");
	}

}
