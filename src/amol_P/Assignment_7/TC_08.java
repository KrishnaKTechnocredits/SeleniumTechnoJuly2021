package amol_P.Assignment_7;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
/*print the firstname of the employee whoes username is ppatro*/
public class TC_08 {
	static WebDriver driver;
	@BeforeMethod()
	public void setup() throws InterruptedException {
		driver = PredefineAction.start();

	}
	
	public static String getName(String uName)
	{
		String userName=uName;
		String ActualFirstName="";
		List<WebElement> list=driver.findElements(By.xpath("//table[@id='table1']/tbody/tr/td[4]"));
		List <WebElement> nameList=	driver.findElements(By.xpath("//table[@id='table1']/tbody/tr/td[2]"));
		for(int index=0;index<list.size();index++)
		{
			String uName1= list.get(index).getText();
			if(uName1.equals(userName))
			{
				ActualFirstName=nameList.get(index).getText();
			}
		}
		return ActualFirstName;
	}
	
	@Test
	public void TC08()
	{
		String actualFirstName= getName("ppatro");
		String expectedFirstName="Priya";
		System.out.println(" FirstName is:" +actualFirstName);
		Assert.assertEquals(actualFirstName, expectedFirstName);
		
	}
	
	@AfterMethod
	public void flush() {
		driver.quit();
	}
}
