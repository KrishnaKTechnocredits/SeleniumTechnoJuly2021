package parthavD;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.PredefinedActions;

public class Assignment9 {

	WebDriver driver;

	@BeforeMethod
	WebDriver BrowserStart() {
		this.driver = PredefinedActions.start();
		return driver;
	}

	LinkedHashMap<String, ArrayList<String>> getMap() {
		LinkedHashMap<String, ArrayList<String>> map = new LinkedHashMap<>();
		ArrayList<String> list = new ArrayList<>();
		int rowsize = driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr")).size();
		for (int index = 1; index <= rowsize; index++) {
			String key = driver
					.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr[" + index + "]/td[5]"))
					.getText();
			String value = driver.findElement(By.xpath(
					"//table[@class='table table-striped']/tbody/tr[" + index + "]/td[5]//preceding-sibling::td[2]"))
					.getText();
			if (!map.containsKey(key)) {
				ArrayList<String> list1 = new ArrayList<>();
				list1.add(value);
				map.put(key, list1);
			} else {
				ArrayList<String> list1 = map.get(key);
				list1.add(value);
				map.put(key, list1);
			}
		}
		return map;
	}

	@Test
	void test1() {
		System.out.println("Step - Launch Automation by Krishna URL");
		driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
		System.out.println("Step - Navigate to demo tables section");
		driver.findElement(By.xpath("//a[@id='demotable']")).click();
		System.out.println("Step - Getting data of table from the demo tables section");
		LinkedHashMap<String, ArrayList<String>> map = getMap();
		LinkedHashMap<String, ArrayList<String>> expectedMap = new LinkedHashMap<String, ArrayList<String>>();
		System.out.println("Step - Populating the expected table data for verification");
		ArrayList<String> expectedList1 = new ArrayList<String>();
		expectedList1.add("Abhijit Mane");
		expectedList1.add("Prayag Mokate");
		ArrayList<String> expectedList2 = new ArrayList<String>();
		expectedList2.add("Sumit Mate");
		expectedList2.add("Sumit Mate");
		ArrayList<String> expectedList3 = new ArrayList<String>();
		expectedList3.add("Sumit Kulkarni");
		expectedList3.add("Pawan Belamkar");
		ArrayList<String> expectedList4 = new ArrayList<String>();
		expectedList4.add("Nikhil Patne");
		expectedList4.add("Chetan Shewale");
		expectedList4.add("Priyanka Bhale");
		expectedMap.put("7001-Admin", expectedList1);
		expectedMap.put("7002-Finance", expectedList2);
		expectedMap.put("7003-HR", expectedList3);
		expectedMap.put("7013-IT", expectedList4);
		SoftAssert sassert = new SoftAssert();
		Set<String> keySet = map.keySet();
		System.out.println("Step - Validation of table data: expected v/s actual");
		for (String keys : keySet) {
			System.out.println("Department name:  " + keys);
			System.out.println("Department employees:  " + map.get(keys));
			switch (keys) {
			case "7001-Admin":
				ArrayList<String> list1 = map.get(keys);
				sassert.assertEquals(expectedList1.size(), map.get(keys).size());
				sassert.assertTrue(expectedList1.equals(list1));
				break;
			case "7002-Finance":
				ArrayList<String> list2 = map.get(keys);
				sassert.assertEquals(expectedList2.size(), map.get(keys).size());
				sassert.assertTrue(expectedList2.equals(list2));
				break;
			case "7003-HR":
				ArrayList<String> list3 = map.get(keys);
				sassert.assertEquals(expectedList3.size(), map.get(keys).size());
				sassert.assertTrue(expectedList3.equals(list3));
				break;
			case "7013-IT":
				ArrayList<String> list4 = map.get(keys);
				sassert.assertEquals(expectedList4.size(), map.get(keys).size());
				sassert.assertTrue(expectedList4.equals(list4));
				break;
			default:
				sassert.assertTrue(false);
				break;
			}
		}
		sassert.assertAll();
		System.out.println("Test end");

	}

	@AfterMethod
	void TearDown() {
		driver.close();
	}

}
