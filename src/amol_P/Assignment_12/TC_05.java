package amol_P.Assignment_12;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC_05 
{
	WebDriver driver;

	@BeforeMethod()
	public void setup() {
		driver = PredifineAction.start();
	}
	@Test
	public void sortBasedOnPosition()
	{
		List<WebElement> totalPages = driver.findElements(By.xpath("//div[@id='example_paginate']/span/a"));

		List<String> allPositions= new ArrayList();
		for (int index = 1; index <= totalPages.size(); index++) {
			driver.findElement(By.xpath("//div[@id='example_paginate']/span/a[" + index + "]")).click();
			List<WebElement> allPositionsList = driver.findElements(By.xpath("//table[@id='example']/tbody/tr/td[2]"));
			for (int index1 = 0; index1 < allPositionsList.size(); index1++) {
				String position = allPositionsList.get(index1).getText();

				allPositions.add(position);

			}
		}
		driver.findElement(By.xpath("//div[@id='example_paginate']/span/a[1]")).click();
		driver.findElement(By.xpath("//thead//th[@class='sorting' and text()='Position']")).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		List<String> PositionASCOrder = new ArrayList<>();
		for (int index = 1; index <= totalPages.size(); index++) {
			driver.findElement(By.xpath("//div[@id='example_paginate']/span/a[" + index + "]")).click();
			List<WebElement> allPositionsList = driver.findElements(By.xpath("//table[@id='example']/tbody/tr/td[2]"));
			for (int index1 = 0; index1 < allPositionsList.size(); index1++) {
				String Name = allPositionsList.get(index1).getText();

				PositionASCOrder.add(Name);

			}
		}
		System.out.println("Employee given list: " + allPositions);
		System.out.println("Employee sorted in Asc:" + PositionASCOrder);
		Collections.sort(allPositions);
		System.out.println("Sort Employee with collection in Asc: " + allPositions);
		Boolean flag = allPositions.equals(PositionASCOrder);
		Assert.assertTrue(flag);
	}
	
	
	@AfterMethod()
	public void teardown() {
		driver.quit();
	}
}
