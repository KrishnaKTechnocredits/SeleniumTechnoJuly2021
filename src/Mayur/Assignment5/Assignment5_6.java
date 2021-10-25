package Mayur.Assignment5;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.PredefinedActions;

public class Assignment5_6 {
	void verifyBasicFormSection(String emailID, String password) throws InterruptedException {
		WebDriver driver = PredefinedActions.start();
		System.out.println("STEP-Navigate to Basic Element Page");
		driver.findElement(By.xpath("//a[text()='Basic Elements']")).click();
		Thread.sleep(3000);
		System.out.println("STEP-Enter  Name");
		driver.findElement(By.xpath("//input[@id='exampleInputEmail1']")).sendKeys(emailID);
		System.out.println("STEP-Enter Password");
		driver.findElement(By.xpath("//input[@id='pwd']")).sendKeys(password);
		System.out.println("STEP-Click on Submit button");
		driver.findElement(By.xpath("//div[@name='secondSegment'][2]/section/div/div/button[@type='submit']")).click();
		Alert alert = driver.switchTo().alert();
		String acutal = alert.getText();
		alert.accept();
		if (acutal.equalsIgnoreCase("You successfully clicked on it"))
			System.out.println("Alert Verification Passed");
		else
			System.out.println("Alert Verification Failed");
		driver.close();
		System.out.println("STEP-Test Case PASSED");
	}

	public static void main(String[] args) throws InterruptedException {
		new Assignment5_6().verifyBasicFormSection("test@abc.in", "Shende");
	}
}