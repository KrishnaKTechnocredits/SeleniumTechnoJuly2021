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

public class TC_02 {
	WebDriver driver;

	@BeforeMethod()
	public void setup() {
		driver = PredefineAction.start();
	}

	@Test()
	public void getUniqueEmployee_TC_02() {

		String empName = "";
		
		Set<String> empSet = new HashSet();
		driver.findElement(By.xpath("//a[@id='demotable']")).click();
		List<WebElement> empList = driver
				.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr/td[2]"));
		for (WebElement name : empList) {
			
			String eName = name.getText();
			
			if(empSet.add(eName)==false)
			{
				empName=eName;
			}
		}
		System.out.println(" Unique Employee in table 2 is : " + empName);
		
	}

	@AfterMethod()
	public void teardown() {
		driver.close();
	}

}
