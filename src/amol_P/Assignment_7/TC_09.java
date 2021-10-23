package amol_P.Assignment_7;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC_09 
{
	WebDriver driver;
	
	@BeforeMethod()
	public void setup() throws InterruptedException {
		driver = PredefineAction.start();

	}
	@Test()
	public void  getUniqueName_TC09()
	{
		List<WebElement> name=driver.findElements(By.xpath("//table[@id='table1']/tbody/tr/td[3]"));
		System.out.println(name.get(2));
		Set<String> setName=new HashSet();
		for(WebElement uniqueName:name)
		{
		String UName=	uniqueName.getText();
		setName.add(UName);
		}
		System.out.println("Unique Element of sirname: "+setName);
	}

	@AfterMethod
	public void flush() {
		driver.quit();
	}

}
