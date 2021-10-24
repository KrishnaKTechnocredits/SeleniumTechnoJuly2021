package amol_P.Assignment_7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC_11 {

	WebDriver driver;
	@BeforeMethod()
	public void setup() throws InterruptedException {
		driver = PredefineAction.start();

	}
	@Test()
	public void verifyEmployee_TC11()
	{
		String name="kkanani";
		int expectedCount=1;
		int actualCount=driver.findElements(By.xpath("//table[@id='table1']/tbody//td[text()='"+name+"']")).size();
		if(actualCount==1) {
			System.out.println("Given table contains kKanani coloumn");
			Assert.assertEquals(actualCount, expectedCount, "Table contains kkanani");
		}
	}
	@AfterMethod
	public void flush() {
		driver.quit();
	}
}
