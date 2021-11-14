package amol_P.Assignment_7;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC_10 {
	WebDriver driver;
	@BeforeMethod()
	public void setup() throws InterruptedException {
		driver = PredefineAction.start();

	}
	@Test
	void getFirstNameAndLastName_TC10()
	{
		Map<String,String> mapData=new HashMap();
		int rowCount=driver.findElements(By.xpath("//table[@id='table1']/tbody/tr/td[2]")).size();
		for(int index=1;index<=rowCount;index++)
		{
			String firstName=driver.findElement(By.xpath("//table[@id='table1']/tbody/tr["+index+"]/td[2]")).getText();
			String lastName=driver.findElement(By.xpath("//table[@id='table1']/tbody/tr["+index+"]/td[4]")).getText();
			mapData.put(firstName, lastName);
		}
		System.out.println(mapData);
	}
	@AfterMethod
	public void flush() {
		driver.quit();
	}
}
