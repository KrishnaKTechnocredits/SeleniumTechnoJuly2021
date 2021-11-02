package varun.varun_Assignment_5;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import base.PredefinedActions;

public class Assignment_5_AlertHandle_3 {
	WebDriver driver = PredefinedActions.start("http://automationbykrishna.com/");

	void javascriptConfirmation() throws InterruptedException {
		driver.findElement(By.xpath("//a[@id='basicelements']")).click();
		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)");
		driver.findElement(By.xpath("//button[@id='javascriptConfirmBox']")).click();
		Alert alert = driver.switchTo().alert();
		String successText = alert.getText();
		alert.accept();

		if (successText.equals("Are you are doing your homework regularly, Press Okay else Cancel!!"))
			System.out.println("Success alert message :- Test Case passed");
		else
			System.out.println("Test Case Failed. Please handle alert carefully");
	}

	void javascriptAlertCancel() throws InterruptedException {
		driver.findElement(By.xpath("//a[@id='basicelements']")).click();
		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)");
		driver.findElement(By.xpath("//button[@id='javascriptConfirmBox']")).click();
		Alert alert = driver.switchTo().alert();
		alert.dismiss();

		String element = driver.findElement(By.xpath("//p[@id='pgraphdemo']")).getText();
		if (element.equals("You pressed Cancel!"))
			System.out.println("Cancel Alert Message :- Test Case passed");
		else
			System.out.println("Test Case Failed. Please handle alert carefully");
	}

	public static void main(String[] args) throws InterruptedException {
		Assignment_5_AlertHandle_3 assignment_5_AlertHandle_3 = new Assignment_5_AlertHandle_3();
		assignment_5_AlertHandle_3.javascriptConfirmation();
		assignment_5_AlertHandle_3.javascriptAlertCancel();
	}
}
