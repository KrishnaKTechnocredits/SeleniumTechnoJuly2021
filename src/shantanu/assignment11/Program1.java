package shantanu.assignment11;
import java.util.HashSet;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
//Return unique Employees from table-2.
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Program1 {
	WebDriver driver;
	@BeforeMethod
	void start() {
		System.setProperty("webdriver.chrome.driver", "./resources/chromedriver.exe");
		System.out.println("STEP 1 - Open Chrome browser");
		driver = new ChromeDriver();
		driver.get("http://automationbykrishna.com");
		driver.manage().window().maximize();
	}
	
	HashSet<String> getUniqueEmployees() {
		HashSet<String> setOfEmployees = new HashSet();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.linkText("Demo Tables")).click();
		int rows = driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr")).size();
		for(int rowIndex = 1; rowIndex <= rows; rowIndex++) {
			String employee = driver.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr["+rowIndex+"]/td[3]")).getText();
			setOfEmployees.add(employee);
		}
		return setOfEmployees;
	}
	
	@Test
	void displayUniqueEmployees() {
		System.out.println(getUniqueEmployees());
	}
	
	@AfterMethod
	void end() {
		driver.close();
	}
}
