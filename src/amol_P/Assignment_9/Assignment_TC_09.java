package amol_P.Assignment_9;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/*Assginment - 9 : 24th Oct'2021
Verfiy Employee count and Employee name in each deptment.

Sample Output: Employee Count in 7001-Admin dept.
               Employee name belongs to 7001-Admin dept.*/

public class Assignment_TC_09 {

	WebDriver driver;
	@BeforeMethod()
	public void setup()
	{
		driver=PredifineAction.start();
	}
	@Test
	public void verifyEmployee()
	{
		String name="7001-Admin";
		driver.findElement(By.xpath("//a[@id='demotable']")).click();
		List<WebElement> list=driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr/td[5]"));
		
		Map<String, Integer> map=new HashMap<String, Integer>();
		List<WebElement> nameList=new ArrayList();
		for(int index=0;index<list.size();index++ )
		{
			
			String ename=list.get(index).getText();
			if(map.containsKey(ename) )
			{
				map.put(ename, map.get(ename)+1);
					}
			else
			{
				if(ename.equals(name)) {
				map.put(ename, 1);
				nameList=driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr/td[5][text()='"+ename+"']//preceding-sibling::td[2]"));
				}
				
			}
		}
		System.out.println("Employee Count in 7001-Admin dept "+map);
		for(int index=0;index<nameList.size();index++)
		{
			System.out.println( " Employee name "+ nameList.get(index).getText());
		}
		Assert.assertEquals(nameList.size(), 2);
	
		
	}
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
