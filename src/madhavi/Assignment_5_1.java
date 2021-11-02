package madhavi;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Assignment_5_1 {
	// Test Case 1
	@Test
	void negativeCase() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./resources/chromedriver.exe");
		System.out.println("STEP1 : Launch browser");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("http://automationbykrishna.com/#");
		System.out.println("STEP2 - Click on Registration Option");
		driver.findElement(By.linkText("Registration")).click();

		Thread.sleep(3000);
		// Negative Case
		System.out.println("STEP3 - Enter Username and Password");
		driver.findElement(By.xpath("//input[@id='unameSignin']")).sendKeys("MadhaviCH");
		driver.findElement(By.xpath("//input[@id='pwdSignin']")).sendKeys("Test123");
		System.out.println("STEP4 - Click on Submit button");
		driver.findElement(By.xpath("//button[@id='btnsubmitdetails']")).click();

		Thread.sleep(3000);

		System.out.println("STEP5 : Verify password");
		checkPassword(driver);

		Thread.sleep(3000);

		System.out.println("Test is failed");
		driver.close();
	}

	@Test
	void postiveCase() throws InterruptedException {
		Thread.sleep(5000);
		System.setProperty("webdriver.chrome.driver", "./resources/chromedriver.exe");
		System.out.println("STEP1 : Launch browser");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("http://automationbykrishna.com/#");
		System.out.println("STEP2 - Click on Registration Option");
		driver.findElement(By.linkText("Registration")).click();

		Thread.sleep(3000);
		// Positive Case
		System.out.println("STEP3 - Enter Username and Password");
		driver.findElement(By.xpath("//input[@id='unameSignin']")).sendKeys("MadhaviCH");
		driver.findElement(By.xpath("//input[@id='pwdSignin']")).sendKeys("Test@12345");
		System.out.println("STEP4 - Click on Submit button");
		driver.findElement(By.xpath("//button[@id='btnsubmitdetails']")).click();

		Thread.sleep(3000);

		System.out.println("STEP5 : Verify password");
		checkPassword(driver);

		Thread.sleep(3000);

		System.out.println("Test is passed successfully");
		driver.close();
	}

	void checkPassword(WebDriver driver) {
		Alert alert = driver.switchTo().alert();
		String actualText = alert.getText();
		String expectedText = "Success!";
		alert.accept();
		Assert.assertEquals(actualText, expectedText, "Login page Alter message should be success");
	}
	/*
	 * public static void main(String[] args) throws InterruptedException { new
	 * Assignment_5_1().negativeCase(); }
	 */
}