/*Selenium Assignment 5 - 17th Oct 

Test Case 1 -

Naivgate to "http://automationbykrishna.com/#"
Enter the login details
Validate the positive scenario for password (By entering 8 characters)
Validate the success message
Validate the negative scenario for password (Enter less than 8 characters)
Validate the failure message
*/
package shalakaP.Assignment5;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import shalakaP.Helper.PredefinedActions;

public class AlertProg1 {

	void prog1() throws InterruptedException {
		WebDriver driver = PredefinedActions.start();
		System.out.println("Step-Click on Registration");
		driver.findElement(By.linkText("Registration")).click();

		Thread.sleep(3000);
		System.out.println("Step-Enter login Details");
		System.out.println("Step-Enter username");
		driver.findElement(By.xpath("//input[@id='unameSignin']")).sendKeys("Shalaka");
		System.out.println("Step-Enter Password");
		driver.findElement(By.xpath("//input[@id='pwdSignin']")).sendKeys("Shalaka@123");
		System.out.println("Step-Click on Button");
		driver.findElement(By.xpath("//button[@id='btnsubmitdetails']")).click();
		System.out.println("Step-Switch to Alert");
		Alert alert = driver.switchTo().alert();
		String text = alert.getText();
		alert.accept();

		if (text.equals("Success!"))
			System.out.println("Test pass");
		else
			System.out.println("Test fail");

		System.out.println("Step-Enter Password less than 8 character");
		driver.findElement(By.xpath("//input[@id='pwdSignin']")).clear();
		driver.findElement(By.xpath("//input[@id='pwdSignin']")).sendKeys("123@s");
		System.out.println("Step-Click on Button");
		driver.findElement(By.xpath("//button[@id='btnsubmitdetails']")).click();
		System.out.println("Step-Switch to Alert");
		alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		alert.accept();
	}

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		new AlertProg1().prog1();
	}

}
