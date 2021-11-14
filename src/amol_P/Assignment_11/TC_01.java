package amol_P.Assignment_11;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
/*Program 1: Return unique Employees from table-2.  
output : size - 8*/

public class TC_01 
{
	WebDriver driver;
	
	@BeforeMethod()
	public void setup()
	{
		driver=	PredefineAction.start();
	}
	
	@Test()
	public void getUniqueEmployee_TC_01()
	{
		
		String empName="";
		Set<String>empSet= new HashSet();
		driver.findElement(By.xpath("//a[@id='demotable']")).click();
		List<WebElement> empList=driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr/td[2]"));
		for(WebElement name:empList)
		{
			empName=name.getText();
			 empSet.add(empName);
			
		}
		System.out.println("Total Unique Employees in table 2 are: "+empSet.size());
		Assert.assertEquals(empSet.size(), 8);
	}
	
	
	@AfterMethod()
	public void teardown()
	{
		driver.close();
	}

}
