

/* Assignment 5 - 17th Oct 2021
http://automationbykrishna.com/#
Test Case 1 -
Naivgate to "http://automationbykrishna.com/#"
Enter the login details
Validate the positive scenario for password (By entering 8 characters)
Validate the success message
Validate the negative scenario for password (Enter less than 8 characters)
Validate the failure message */

package purshottamJoshi;



import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.PredefinedActions;

public class Assignment5 {
	
	void validateLoginPage(String name, String password) throws InterruptedException {
		
		WebDriver driver = PredefinedActions.start();
		System.out.println("STEP - Navigate to Registration Page");
		driver.findElement(By.xpath("//a[@id='registration2']")).click();
		Thread.sleep(3000);
		System.out.println("STEP - Enter Name");
		driver.findElement(By.xpath("//input[@id='unameSignin']")).sendKeys(name);
		System.out.println("STEP - Enter Password");
		driver.findElement(By.xpath("//input[@id='pwdSignin']")).sendKeys(password);
		System.out.println("STEP-Click on Submit button");
		driver.findElement(By.xpath("//button[@id='btnsubmitdetails']")).click();
		Thread.sleep(3000);
		Alert alert = driver.switchTo().alert();
		String actual = alert.getText();
		if ( actual.equals("Success!")) {
			
			System.out.println("Password is valid ");
			alert.accept();
		} else {
			System.out.println("Password is less than 8 character enter atleast 8 characters");
			alert.accept();

		}
		System.out.println("STEP - Test case 1 Passed");
		driver.close();
	}

	public static void main(String[] args) throws InterruptedException {
		new Assignment5().validateLoginPage("purushottam", "test213");
		new Assignment5().validateLoginPage("purshottam", "test12345");
		
	}

}
