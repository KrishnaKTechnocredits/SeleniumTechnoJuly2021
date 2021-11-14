/*Selenium Assignment 5 - 17th Oct 

Test Case 1 -

Naivgate to "http://automationbykrishna.com/#"
Enter the login details
Validate the positive scenario for password (By entering 8 characters)
Validate the success message
Validate the negative scenario for password (Enter less than 8 characters)
Validate the failure message*/

package astha.Assignment5;

import java.util.Scanner;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TestCase1 {

	static void validateLogin(String userName, String password) throws InterruptedException {
		System.out.println("Step -1 : Launch chrome browser and navigate to AutomationByKrishna");
		WebDriver driver = base.PredefinedActions.start();
		System.out.println("Step - Passed");
		System.out.println("Step -2 : Navigate to registration tab");
		driver.findElement(By.linkText("Registration")).click();
		Thread.sleep(3000);
		System.out.println("Step - Passed");
		System.out.println("Step -3 Enter username");
		driver.findElement(By.id("unameSignin")).sendKeys(userName);
		System.out.println("Step - Passed");
		System.out.println("Step -4  Enter password ");
		driver.findElement(By.id("pwdSignin")).sendKeys(password);
		System.out.println("Step - Passed");
		System.out.println("Step -5: Click on submit button");
		driver.findElement(By.id("btnsubmitdetails")).click();
		System.out.println("Step - Passed");
		Alert alert = driver.switchTo().alert();
		int pwdLength = password.length();
		if (pwdLength >= 9) {
			System.out.println("Step 6 - Validate the success message");
			String expectedMsg = "Success!";
			String actualMsg = alert.getText();
			if (expectedMsg.equals(actualMsg))
				System.out.println("Step - Passed");
			else
				System.out.println("Step - Failed");
			alert.accept();
		} else {
			System.out.println("Step 7 - Validate the failure message");
			String expectedMsg = "Failed! please enter strong password";
			String actualMsg = alert.getText();
			if (expectedMsg.equals(actualMsg))
				System.out.println("Step - Passed");
			else
				System.out.println("Step - Failed");
			alert.accept();
		}
		driver.quit();
	}

	public static void main(String[] args) throws InterruptedException {
		System.out.println("Validate positive scenario");
		TestCase1.validateLogin("astha", "password123");
		System.out.println("Validate negative scenario");
		TestCase1.validateLogin("ankita", "asd");
	}
}
