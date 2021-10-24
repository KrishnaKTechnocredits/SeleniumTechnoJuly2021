package amol_P.Assignment_8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/*Assignment - 8 : 23th Oct'2021
Return a map of Deptname and count of employee within each deptment.
o/p : 7001-Admin -> 2
      7002-Finance -> 2
	  7003-HR -> 2
	  7013-IT -> 3*/

public class Assignment_TC_08
{
	static WebDriver driver;
	
	@BeforeMethod()
	public void setup() throws InterruptedException
	
	{
		start();
	}
public static void start() throws InterruptedException
{
	System.setProperty("webdriver.chrome.driver", "./resources//chromedriver.exe");
	driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("http://automationbykrishna.com/index.html#");
	driver.findElement(By.id("demotable")).click();
	Thread.sleep(2000);
	
	
}
@Test()
public void getEmployeeCount_TC_08() throws InterruptedException
{
	Map<String, Integer> map=new LinkedHashMap<String, Integer>();
	Thread.sleep(2000);
	int rowCount=driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr/td[5]")).size();
	System.out.println("Total time required for this programe is 15 min");
	ArrayList<String> l= new ArrayList<>();
	for(int index=1;index<=rowCount;index++)
	{
		String name=driver.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr["+index+"]/td[5]")).getText();
		
		if(map.containsKey(name))
		{
			map.put(name, map.get(name)+1);
		}
		else
		{
			map.put(name, 1);
		}
	}
	System.out.println(map);
}
	
	@AfterMethod
	public void flush()
	{
		driver.quit();
	}

}
