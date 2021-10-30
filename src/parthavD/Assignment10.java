package parthavD;

import java.util.ArrayList;
import java.util.HashMap;
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

public class Assignment10  {

	WebDriver driver;

	@BeforeMethod
	WebDriver BrowserStart() {
		this.driver = PredefinedActions.start();
		return driver;
	}

	HashMap<String, ArrayList<String>> getMap() {
		HashMap<String, ArrayList<String>> map = new HashMap<>();
		ArrayList<String> list = new ArrayList<>();
		int rowsize = driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr")).size();
		for (int index = 1; index <= rowsize; index++) {
			String key = driver
					.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr["+index+"]/td[4]"))
					.getText();
			if (key.equals("20209")) {
				if (!map.containsKey(key)) {
					ArrayList<String> list1 = new ArrayList<>();
					String value = driver.findElement(By.xpath(
							"//table[@class='table table-striped']/tbody/tr[" + index + "]/td[4]//preceding-sibling::td[1]"))
							.getText();
					list1.add(value);
					map.put(key, list1);
				} else {
					String value = driver.findElement(By.xpath(
							"//table[@class='table table-striped']/tbody/tr[" + index + "]/td[4]//preceding-sibling::td[1]"))
							.getText();
					ArrayList<String> list1 = map.get(key);
					list1.add(value);
					map.put(key, list1);
				}
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
		HashMap<String, ArrayList<String>> map = getMap();
		HashMap<String, ArrayList<String>> expectedMap = new HashMap<String, ArrayList<String>>();
		System.out.println("Step - Populating the expected table data for verification");
		ArrayList<String> expectedList1 = new ArrayList<String>();
		expectedList1.add("Abhijit Mane");
		expectedList1.add("Sumit Kulkarni");
		expectedList1.add("Pawan Belamkar");
		expectedMap.put("20209", expectedList1);
		SoftAssert sassert = new SoftAssert();
		Set<String> keySet = map.keySet();
		System.out.println("Step - Validation of table data: expected v/s actual");
		for (String keys : keySet) {
			System.out.println("Manager ID:  " + keys);
			System.out.println("Employees under this manager:  " + map.get(keys));
			if (keys.equals("20209")){
				sassert.assertEquals(expectedList1.size(),map.get(keys).size());
				ArrayList<String> actualList = map.get(keys);
				sassert.assertTrue(expectedList1.equals(actualList));
			}
			else	
				sassert.assertTrue(false);
		}
		sassert.assertAll();
		System.out.println("Test end");

	}

	@AfterMethod
	void TearDown() {
		driver.close();
	}

}
