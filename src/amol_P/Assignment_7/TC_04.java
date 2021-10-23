package amol_P.Assignment_7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
/*4) return first name of all the employees
->	ArrayList<String> listOfFirstName = new ArrayList<String>();
	String[] arr = new String[totalRows];
	for(){*/

public class TC_04 {
	static WebDriver driver;

	@BeforeMethod()
	public void setup() throws InterruptedException {
		driver = PredefineAction.start();

	}

	private static ArrayList<String> getFirstName() throws InterruptedException {

		int expectedColumnCount = 4;
		List<WebElement> actualColumnCount = driver.findElements(By.xpath("//table[@class='table']/tbody/tr/td[2]"));
		ArrayList<String> list = new ArrayList();
		for (int index = 1; index <= actualColumnCount.size(); index++) {
			String name = driver.findElement(By.xpath("//table[@class='table']/tbody/tr[" + index + "]/td[2]"))
					.getText();
			list.add(name);
		}
		System.out.println(list);
		return list;
	}

	@Test()
	public void verifyFirstName() throws InterruptedException {
		TC_04.getFirstName();
	}
	
	

	
	@AfterMethod
	public void flush()
	{
		driver.quit();
	}
}
