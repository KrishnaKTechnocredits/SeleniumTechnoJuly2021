package amol_P.Assignment_12;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC_02_03 {
	/*
	 * program 2: print position per employee count by navigating throw all pages.
	 */
	WebDriver driver;

	@BeforeMethod()
	public void setup() {
		driver = PredifineAction.start();
	}

	// @Test()
	void verifyPositionPerEmployee_TC_() {
		List<String> list = new ArrayList();

		List<WebElement> totalPositionPerPage = new ArrayList();
		List<WebElement> totalPages = driver.findElements(By.xpath("//div[@id='example_paginate']/span/a"));
		for (int index = 1; index <= totalPages.size(); index++) {

			driver.findElement(By.xpath("//div[@id='example_paginate']/span/a[" + index + "]")).click();
			totalPositionPerPage = driver.findElements(By.xpath("//table[@id='example']/tbody/tr/td[2]"));
			for (int index1 = 1; index1 < totalPositionPerPage.size(); index1++) {
				String positions = totalPositionPerPage.get(index1).getText();
				list.add(positions);

			}
		}

		Map<String, Integer> map = new HashMap();
		for (int index = 0; index < list.size(); index++) {
			String position = list.get(index);
			if (map.containsKey(position)) {
				map.put(position, map.get(position) + 1);
			} else {
				map.put(position, 1);
			}
		}
		System.out.println(map);
	}

	/* Program 3: find out the position with highest and lowest employees. */
	@Test()
	void verifyPositionWithHighestAndLowestEmployee_TC_03() {
		List<String> list = new ArrayList();

		List<WebElement> totalPositionPerPage = new ArrayList();
		List<WebElement> totalPages = driver.findElements(By.xpath("//div[@id='example_paginate']/span/a"));
		for (int index = 1; index <= totalPages.size(); index++) {

			driver.findElement(By.xpath("//div[@id='example_paginate']/span/a[" + index + "]")).click();
			totalPositionPerPage = driver.findElements(By.xpath("//table[@id='example']/tbody/tr/td[2]"));
			for (int index1 = 1; index1 < totalPositionPerPage.size(); index1++) {
				String positions = totalPositionPerPage.get(index1).getText();
				list.add(positions);

			}
		}

		Map<String, Integer> map = new HashMap();
		for (int index = 0; index < list.size(); index++) {
			String position = list.get(index);
			if (map.containsKey(position)) {
				map.put(position, map.get(position) + 1);
			} else {
				map.put(position, 1);
			}
		}
		System.out.println(map);
		String maxPostion = "";
		int maxCount = 0;

		Set<String> set = map.keySet();

		int getFirstElementvalue = 0;
		String LowPosition = "";
		int lowCount = 0;
		for (String allPosition : set) {
			if (getFirstElementvalue == 0) {
				lowCount = map.get(allPosition);
				getFirstElementvalue++;
			}
			if (map.get(allPosition) > maxCount) {
				maxCount = map.get(allPosition);
				maxPostion = allPosition;
			}
			if (map.get(allPosition) < lowCount) {
				lowCount = map.get(allPosition);
				LowPosition = allPosition;

			}

		}
		System.out.println("Element with max count and position is :" + maxCount + " " + maxPostion);
		System.out.println("Element with low count and position is : " + lowCount + " " + LowPosition);
	}

	@AfterMethod()
	public void teardown() {
		driver.quit();
	}
}
