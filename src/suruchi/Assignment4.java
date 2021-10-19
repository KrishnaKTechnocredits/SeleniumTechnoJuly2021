package suruchi;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment4 {
	void yahooCreateAccount() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		System.out.println("Open Chrome in maximized state");
		driver.manage().window().maximize();

		System.out.println("Navigate to Yahoo Sign Up page");
		driver.get("https://login.yahoo.com/account/create?specId=yidReg");

		System.out.println("Fill in First Name field");
		driver.findElement(By.id("usernamereg-firstName")).sendKeys("Test");

		System.out.println("Fill in Last Name field");
		driver.findElement(By.id("usernamereg-lastName")).sendKeys("Name");

		System.out.println("Fill in Email Address field");
		driver.findElement(By.id("usernamereg-yid")).sendKeys("knighT57352");

		System.out.println("Fill in Password field");
		driver.findElement(By.id("usernamereg-password")).sendKeys("password@123456");

		System.out.println("Fill in Mobile number field");
		driver.findElement(By.id("usernamereg-phone")).sendKeys("9134782974");

		System.out.println("Select Birth Month");
		WebElement birthMonth = driver.findElement(By.id("usernamereg-month"));
		Select birthMonthSelect = new Select(birthMonth);
		birthMonthSelect.selectByVisibleText("October");

		System.out.println("Fill in Day field");
		driver.findElement(By.id("usernamereg-day")).sendKeys("13");

		System.out.println("Fill in Year field");
		driver.findElement(By.id("usernamereg-year")).sendKeys("1997");

		System.out.println("Fill in Gender field");
		driver.findElement(By.id("usernamereg-freeformGender")).sendKeys("Female");

		Thread.sleep(3000);
		driver.close();

		System.out.println("Test Case passed");
	}

	public static void main(String[] args) throws InterruptedException {
		new Assignment4().yahooCreateAccount();
	}
}