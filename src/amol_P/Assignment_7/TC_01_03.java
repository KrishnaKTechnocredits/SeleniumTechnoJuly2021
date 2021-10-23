package amol_P.Assignment_7;
/*1) How many tables are there on the page
-> driver.findElements(By.xpath("//table")).size();*/

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC_01_03 
{
	WebDriver driver;
	@BeforeMethod
	public void Launch() throws InterruptedException
	{
		driver= PredefineAction.start();
	}
	@Test(priority=1)
	public void verifyTotalTable_TC_01() throws InterruptedException
	{
		/*1) How many tables are there on the page*/
	

		int ExpectedSize=4;
		
		int ActualSize= driver.findElements(By.xpath("//table")).size();
		System.out.println("Total Size: "+ActualSize);
		Assert.assertEquals(ActualSize, ExpectedSize);
		
		
	}
	@Test(priority=2)
	public void getRowNum_TC_02()
	{
		/*How many rows are there in EMPLOYEE BASIC INFORMATION*/
		int expectedRowCount=5;
		int actualRowCount=driver.findElements(By.xpath("//table[@class='table']/tbody/tr")).size();
		System.out.println("Total Row count is : "+actualRowCount);
		Assert.assertEquals(actualRowCount, expectedRowCount);
	}
	
	@Test(priority=3)
	public void getColoumnNum_TC_03()
	{
		/*how many columns are there in EMPLOYEE BASIC INFORMATION*/
		int expectedColumnCount=4;
	 List<WebElement> actualColumnCount=	driver.findElements(By.xpath("//table[@class='table']/tbody/tr[1]/td"));
	 System.out.println("Total Column");
	 Assert.assertEquals(actualColumnCount.size(), expectedColumnCount);
	}
	
		
	
	@AfterMethod
	public void flush()
	{
		driver.quit();
	}

}
