package Mayur.Assignment5;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import base.PredefinedActions;

public class Assignment5_4 {
	
	void clickAlertAndEnterMessageAndVerifyMesage(String name) throws Exception {
		
		WebDriver driver = PredefinedActions.start();
		
		Thread.sleep(2000);
		System.out.println("Step Click On Basic Element");
		driver.findElement(By.xpath("//a[@id='basicelements']")).click();
		Thread.sleep(2000);
		System.out.println("Step Scroll down the page ");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)");
		
		System.out.println("Step Click on javascript prompt button");
		driver.findElement(By.xpath("//button[@id='javascriptPromp']")).click();
		
		System.out.println("Step Handle popup and provide input");
		Thread.sleep(2000);
		Alert alert = driver.switchTo().alert();
		alert.sendKeys(name);
		alert.accept();
		
		String actualText = driver.findElement(By.xpath("//p[@id='pgraphdemo']")).getText();
		String expectedText = "Hello " + name + "! How are you today?";
		
		System.out.println("Step Verify text ");
		if(actualText.equals(expectedText))
			System.out.println("Step Verifivation Text Matches");
		else
			System.out.println("Step Verifivation Text is not Matches");
		driver.close();
		System.out.println("Test passed");
	}
	public static void main(String[] args) throws Exception {
		new Assignment5_4().clickAlertAndEnterMessageAndVerifyMesage("Mayur");
	}

}
