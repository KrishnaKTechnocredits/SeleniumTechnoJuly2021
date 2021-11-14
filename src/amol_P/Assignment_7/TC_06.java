package amol_P.Assignment_7;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC_06 {

	/*6) print all rows*/
		WebDriver driver;
	@BeforeMethod()
	public void setup() throws InterruptedException {
		driver = PredefineAction.start();

	}
		@Test()
		public void getTotalRow()
		{
			List <WebElement> allRow=driver.findElements(By.xpath("//table[@id='table1']/tbody/tr/td"));
			ArrayList< String> list=new ArrayList();
			for(WebElement data:allRow)
			{
				list.add(data.getText());
			}
			System.out.println(list);
		}
		@AfterMethod
		public void flush()
		{
			driver.quit();
		}
	

}
