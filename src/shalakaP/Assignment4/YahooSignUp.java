/*
Assignment - 4: 16th Oct'2021
Yahoo Signup.
https://login.yahoo.com/account/create?specId=yidReg*/
package shalakaP.Assignment4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class YahooSignUp {
	void signUp() throws InterruptedException {
		System.setProperty("Webdriver.chrome.driver", "chromedriver.exe");
		System.out.println("STEP - Open Chrome Browser");
		WebDriver driver = new ChromeDriver();
		System.out.println("STEP - Enter Url");
		driver.get("https://login.yahoo.com/account/create?specId=yidReg*/");
		driver.manage().window().maximize();
		System.out.println("STEP - Create a Yahoo email address");
		System.out.println("STEP - Enter Firstname");
		driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys("Shalaka");
		System.out.println("STEP - Enter lastName");
		driver.findElement(By.xpath("//input[@name='lastName']")).sendKeys("Prayag");
		System.out.println("STEP - Enter Email");
		driver.findElement(By.xpath("//input[@id='usernamereg-yid']")).sendKeys("prayag.shalaka");
		System.out.println("STEP - Enter password");
		driver.findElement(By.xpath("//input[@autocomplete='new-password']")).sendKeys("Shala123!");
		System.out.println("STEP - Enter Mobile Number");
		driver.findElement(By.xpath("//input[@id='usernamereg-phone']")).sendKeys("8484956585");
		System.out.println("STEP - Select month");
		WebElement element = driver.findElement(By.xpath("//select[@id='usernamereg-month']"));
		Select monthElement = new Select(element);
		monthElement.selectByVisibleText("September");
		System.out.println("STEP - Select Day");
		driver.findElement(By.xpath("//input[@id='usernamereg-day']")).sendKeys("15");
		System.out.println("STEP - Select Year");
		driver.findElement(By.xpath("//input[@placeholder='Year']")).sendKeys("1992");
		System.out.println("STEP - Select Gender");
		driver.findElement(By.xpath("//input[@name='freeformGender']")).sendKeys("Female");
		Thread.sleep(5000);
		System.out.println("STEP - Test Passed successfully");


	}

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		new YahooSignUp().signUp();
	}

}
