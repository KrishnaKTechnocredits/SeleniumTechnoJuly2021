package priti_V.Assingment_5;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCase_3 {
	
	void validateJavascriptConfirmationMessage() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./resources/chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		System.out.println("Chrome Browser opened");
		System.out.println("Website :automationbykrishna.com");
		driver.get("http://automationbykrishna.com/");
		System.out.println("Step: Screanrio-1: accept the alert");
		System.out.println("Step: Click on the Basic Elements link/menu");
		driver.findElement(By.xpath(" //a [@id ='basicelements']")).click();
		Thread.sleep(4000);
		
		System.out.println("Step: Click on javascript confirmation button");
		driver.findElement(By.xpath("//button[@class ='btn btn-warning']")).click();
		
		System.out.println("Step: Pleas handle the alert");
		Alert alert = driver.switchTo().alert();
		//String text = alert.getText();
		
		if (alert.getText().equals("Are you are doing your homework regularly, Press Okay else Cancel!!")) {
			System.out.println("Pass");
			alert.accept();
			System.out.println("Validate the confirmation message displayed below the Javascript Confirmation button.");
			String acceptText = driver.findElement(By.xpath("//p [@id ='pgraphdemo']")).getText();
			if (acceptText.equals("You pressed OK!"))
				System.out.println("pass");
			else 
				System.out.println("Fail");
		}
		else {
			System.out.println("Fail");
			alert.accept();
		}
		System.out.println("Step: Screanrio-2: Dismiss the alert");
		System.out.println("Step: Click on javascript confirmation button");
		driver.findElement(By.xpath("//button[@class ='btn btn-warning']")).click();
		System.out.println("STEP-Click on Cancel Alert");
		alert.dismiss();
		System.out.println("Validate the confirmation message displayed below the Javascript Confirmation button.");
		String dismisstext= driver.findElement(By.xpath("//p [@id ='pgraphdemo']")).getText();
		if (dismisstext.equals("You pressed Cancel!"))
			System.out.println("Pass");
		else
			System.out.println("Fail");
		System.out.println("Test case_5_3 passed successfully");
		
		Thread.sleep(2000);
		driver.close();
		
	}
	public static void main(String[] a) throws InterruptedException {
		TestCase_3 testCase_3 = new TestCase_3();
		testCase_3.validateJavascriptConfirmationMessage();
		
	}
}
/*Naivgate to "http://automationbykrishna.com/#"
Navigate to Basic Elements tab
Navigate to DIFFERENT EXAMPLES OF ALERTS section
Click on Javascript Confirmation button
Validate the alert message and accept the alert.
Validate the confirmation message displayed below the Javascript Confirmation button.
Click on Javascript Confirmation button
Dismiss the alert.
Validate the confirmation message displayed below the Javascript Confirmation button.*/
