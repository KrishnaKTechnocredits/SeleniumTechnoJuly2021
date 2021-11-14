package amol_P.Assignment_12;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC_01 {
	/* Program 1 : Find unique Office location by navigating throw all pages. */
	WebDriver driver;

	@BeforeMethod()
	public void setup() {
		driver = PredifineAction.start();
	}

	@Test
	public void verifyUniqueOffice_TC01() {
		String officeName = null;
		List<WebElement> list = new ArrayList<>();
		List<String> listUniqueEmp = new ArrayList<String>();

		List<WebElement> totalPages = driver.findElements(By.xpath("//div[@id='example_paginate']/span/a"));

		for (int index = 1; index <= totalPages.size(); index++) {
			if (index <= totalPages.size()) {
				driver.findElement(By.xpath("//div[@id='example_paginate']/span/a[" + index + "]")).click();
			}
			list = driver.findElements(By.xpath("//table[@id='example']/tbody/tr/td[3]"));
			System.out.println(list.size());
			for (int index1 = 1; index1 <= list.size(); index1++) {

				if (index1 <= list.size())
					officeName = driver.findElement(By.xpath("//table[@id='example']/tbody/tr[" + index1 + "]/td[3]"))
							.getText();
				
				listUniqueEmp.add(officeName);

			}

		}
		Set<String> uniqSet=new HashSet(listUniqueEmp);
		
		System.out.println("unique Office locations are: "+uniqSet);
	}

	@AfterMethod()
	public void teardown() {
		driver.quit();
	}
}
