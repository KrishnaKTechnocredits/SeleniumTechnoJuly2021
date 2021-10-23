/*
 * Test Case 1 -

Naivgate to "http://automationbykrishna.com/#"
Enter the login details
Validate the positive scenario for password (By entering 8 characters)
Validate the success message
Validate the negative scenario for password (Enter less than 8 characters)
Validate the failure message

 */
package husain.Assignment5;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.PredefinedActions;

public class Program1 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = PredefinedActions.start();
		Thread.sleep(3000L);
		System.out.println("STEP - Open Chrome Browser");

		System.out.println("STEP - Click on registration link");
		driver.findElement(By.xpath("//a[@id='registration2']")).click();

		Thread.sleep(3000L);
		System.out.println("STEP - Enter username");
		driver.findElement(By.id("unameSignin")).sendKeys("test123");

		System.out.println("STEP - Enter password with 8 characters");
		driver.findElement(By.id("pwdSignin")).sendKeys("pass=1234");

		System.out.println("STEP - Click on Submit button");
		driver.findElement(By.id("btnsubmitdetails")).click();

		System.out.println("STEP - Switch to Alert");
		Alert alert = driver.switchTo().alert();

		System.out.println("STEP - Print success message from alert");
		System.out.println(alert.getText());
		alert.accept();

		System.out.println("STEP - Enter password with less than 8 characters");
		driver.findElement(By.id("pwdSignin")).clear();
		driver.findElement(By.id("pwdSignin")).sendKeys("pass=12");

		System.out.println("STEP - Click on Submit button");
		driver.findElement(By.id("btnsubmitdetails")).click();

		System.out.println("STEP - Switch to Alert");
		alert = driver.switchTo().alert();

		System.out.println("STEP - Print failure message from alert");
		System.out.println(alert.getText());
		alert.accept();
	}

}
