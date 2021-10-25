package suruchi.Assignment5;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.PredefinedActions;

public class Program1 {

	void passwordInsertionMessageOnSignUp() throws InterruptedException {
		WebDriver driver = PredefinedActions.start();

		System.out.println("Click on Registration link");
		driver.findElement(By.id("registration2")).click();

		Thread.sleep(3000);
		System.out.println("Enter username");
		driver.findElement(By.id("unameSignin")).sendKeys("testusername");

		Thread.sleep(2000);
		System.out.println("Enter password with less than 8 characters");
		driver.findElement(By.id("pwdSignin")).sendKeys("suru123");

		Thread.sleep(2000);
		System.out.println("Click on check button");
		driver.findElement(By.id("btnsubmitdetails")).click();

		Thread.sleep(2000);
		System.out.println("Verify password");
		verifyPassword(driver);

		System.out.println("Clear password");
		driver.findElement(By.id("pwdSignin")).clear();

		Thread.sleep(2000);
		System.out.println("Reenter the password with more than 8 characters");
		driver.findElement(By.id("pwdSignin")).sendKeys("suru12345");

		Thread.sleep(2000);
		System.out.println("Click on check button");
		driver.findElement(By.id("btnsubmitdetails")).click();

		Thread.sleep(2000);
		System.out.println("Verify password");
		verifyPassword(driver);

		driver.close();

		System.out.println("Test Case Passed");
	}

	void verifyPassword(WebDriver driver) {
		Alert alert = driver.switchTo().alert();
		String alertText = alert.getText();
		alert.accept();

		if (alertText.equals("Success!"))
			System.out.println("Logged in");
		else
			System.out.println("Password not strong enough");
	}

	public static void main(String[] args) throws InterruptedException {
		new Program1().passwordInsertionMessageOnSignUp();
	}
}