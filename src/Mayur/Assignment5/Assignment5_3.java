package Mayur.Assignment5;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import base.PredefinedActions;

public class Assignment5_3 {
	
	void testcase_3() throws Exception {
		
		WebDriver driver = PredefinedActions.start();
		Thread.sleep(2000);
		System.out.println("Step : Click on Basic Element");
		driver.findElement(By.xpath("//a[@id='basicelements']")).click();
		
		Thread.sleep(2000);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)");
		
		System.out.println("Step : Click on JavaScript Confirmation");
		driver.findElement(By.xpath("//button[@id='javascriptConfirmBox']")).click();
		
		Thread.sleep(1000);
		System.out.println("STEP : Check cancel message");
		validateCancelMessage(driver);

		Thread.sleep(1000);
		System.out.println("Test passed successfully");
		driver.close(); 
		
		
	}	
		
	void validateOkMessage(WebDriver driver) {
		Alert alert = driver.switchTo().alert();
		alert.accept();
		String actualText = driver.findElement(By.xpath("//p[contains(text(),'You pressed OK!')]")).getText();
		String expectedText = "You pressed OK!";
		if(actualText.equals(expectedText))
			System.out.println("Valid ok Message");
		else
			System.out.println("Invalid Ok Message");
		
	}
	
	void validateCancelMessage(WebDriver driver) {
		Alert alert = driver.switchTo().alert();
		alert.dismiss(); // cancel
		String actualText = driver.findElement(By.xpath("//p[contains(text(),'You pressed Cancel!')]")).getText();
		String expectedText = "You pressed Cancel!";
		if (actualText.equals(expectedText))
			System.out.println("Valid cancel message");
		else
			System.out.println("Invalid cancel message");
	}

		public static void main(String[] args) throws Exception {
			new Assignment5_3().testcase_3();
		}
	}
	


