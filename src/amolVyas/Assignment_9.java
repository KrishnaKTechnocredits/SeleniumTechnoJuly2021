package amolVyas;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import amolVyas.Assignment_5.Action;

public class Assignment_9 {
	WebDriver driver;

	@BeforeClass
	void getOpenBrowser() {
		driver = Action.start();
		System.out.println("STEP-Navigate to Demo Tables");
		driver.findElement(By.xpath("//a[text()='Demo Tables']")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	void getCountEmpEachDept() {
		int rowCount = driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr")).size();
		Map<String, Integer> map = new HashMap();
		for (int index = 1; index <= rowCount; index++) {
			String key = driver
					.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr[" + index + "]/td[5]"))
					.getText();
			if (map.containsKey(key)) {
				int count = map.get(key);
				map.put(key, ++count);
			} else
				map.put(key, 1);
		}
		System.out.println(map);
	}

	@Test
	void getEmpNameEachDept() {
		Map<String, ArrayList<String>> map = new HashMap();
		int rowCount = driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr")).size();
		for (int index = 1; index <= rowCount; index++) {
			String key = driver
					.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr[" + index + "]/td[5]"))
					.getText();
			String value = driver
					.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr[" + index + "]/td[3]"))
					.getText();

			if (map.containsKey(key)) {
				ArrayList<String> name = map.get(key);
				name.add(value);
				map.put(key, name);
			} else {
				ArrayList<String> listOfName = new ArrayList();
				listOfName.add(value);
				map.put(key, listOfName);
			}
		}
		System.out.println(map);
	}

	@AfterClass
	void getTearDown() {
		driver.close();
	}

}
