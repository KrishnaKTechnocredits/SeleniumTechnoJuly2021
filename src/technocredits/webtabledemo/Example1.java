package technocredits.webtabledemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.PredefinedActions;

public class Example1 {

	WebDriver driver;
	
	@BeforeMethod
	public void startBrowser() {
		driver = PredefinedActions.start();
		driver.findElement(By.linkText("Demo Tables")).click();
	}
		
	@Test
	public void verifyCountOfTables() {
		System.out.println(driver.findElements(By.tagName("table")).size());
	}
	
	@Test
	public void verifyTotalRowsInTable1Test() {
		System.out.println(driver.findElements(By.xpath("//table[@id='table1']/tbody/tr\r\n" + 
				"")).size());
	}
	
	@Test
	public void verifyTotalColsInTable1Test() {
		System.out.println(driver.findElements(By.xpath("//table[@id='table1']/thead\r\n" + 
				"")).size());
	}
	
	@Test
	public void printTableData() {
		System.out.println(driver.findElement(By.xpath("//table[@id='table1']")).getText());
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
}
