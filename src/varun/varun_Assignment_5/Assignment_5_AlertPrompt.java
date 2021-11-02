package varun.varun_Assignment_5;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import base.PredefinedActions;

public class Assignment_5_AlertPrompt {
	WebDriver driver = PredefinedActions.start("http://automationbykrishna.com/");
	
	void javaScriptPrompt(String Name) throws InterruptedException {
		driver.findElement(By.xpath("//a[@id='basicelements']")).click();
		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)");
		driver.findElement(By.id("javascriptPromp")).click();
		Alert alert = driver.switchTo().alert();
		System.out.println("STEP-Verify Alert popup is coming");
		System.out.println("STEP-Enter Name");
		alert.sendKeys(Name);
		alert.accept();
		String actualText = driver.findElement(By.xpath("//p[@id='pgraphdemo']")).getText();
		String exepected = "Hello " + Name + "! How are you today?";
		if (actualText.equals(exepected))
			System.out.println("Java script Prompt :- Test Case Passed");
		else
			System.out.println("Java script Prompt :- Test Case Failed");
		System.out.println("Test Case Pass");
	}
	public static void main(String[] args) throws InterruptedException {
		Assignment_5_AlertPrompt assignment_5_AlertPrompt = new Assignment_5_AlertPrompt();
		assignment_5_AlertPrompt.javaScriptPrompt("Varun");
	}
}
