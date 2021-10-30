package elizabeth.Assignment_5;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.PredefinedActions;

public class Assignment5_Registration {
	
	static void login(WebDriver driver) {
		System.out.println("Step 2: Enter the username");
		driver.findElement(By.xpath("//input[@id='unameSignin']")).sendKeys("elizMary");
		System.out.println("Step 3: Enter the password less than 8 characters");
		driver.findElement(By.xpath("//input[@id='pwdSignin']")).sendKeys("pwd");
		System.out.println("Step 4: Click on Submit");
		driver.findElement(By.xpath("//button[@id='btnsubmitdetails']")).click();
		
		System.out.println("Step 5: Verify the text on the pop up");
		Alert alert=driver.switchTo().alert();
		String actualText=alert.getText();
		System.out.println(actualText);
		String expectedText="Failed! please enter strong password";
		
		if(actualText.equals(expectedText)) {
			System.out.println("Text is as expected");
		}else {
			System.out.println("Text is not as expected");
		}
		alert.accept();
		
		System.out.println("Step 6: Re-enter the password to more than 8 characters");
		driver.findElement(By.xpath("//input[@id='pwdSignin']")).sendKeys("qwertyuiop");
		System.out.println("Step 7: Now click on submit button");
		driver.findElement(By.xpath("//button[@id='btnsubmitdetails']")).click();
		
		System.out.println("Step 8: Verify the text on the pop up");
		Alert alert1=driver.switchTo().alert();
		String actualText1=alert1.getText();
		System.out.println(actualText1);
		String expectedText1="Success!";
		
		if(actualText1.equals(expectedText1)) {
			System.out.println("Text is as expected");
		}else {
			System.out.println("Text is not as expected");
		}
		alert1.accept();
		
	}
	
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = PredefinedActions.start();
		System.out.println("Step 1: Click on Registration");
		driver.findElement(By.xpath("//a[@id='registration2']")).click();
		Thread.sleep(5000);
		
		login(driver);
		
	}

}
