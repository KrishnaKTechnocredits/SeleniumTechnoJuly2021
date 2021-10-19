/*
Test Case 3 - 

Naivgate to "http://automationbykrishna.com/#"
Navigate to Basic Elements tab
Navigate to DIFFERENT EXAMPLES OF ALERTS section
Click on Javascript Confirmation button
Validate the alert message and accept the alert.
Validate the confirmation message displayed below the Javascript Confirmation button.
Click on Javascript Confirmation button
Dismiss the alert.
Validate the confirmation message displayed below the Javascript Confirmation button.*/
package shalakaP.Assignment5;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import shalakaP.Helper.PredefinedActions;

public class AlertProg3 {
	void prog3() throws InterruptedException {
		WebDriver driver = PredefinedActions.start();
		System.out.println("Step-Click on Basic Elements");
		driver.findElement(By.linkText("Basic Elements")).click();

		Thread.sleep(3000);
		System.out.println("Step-Enter Click on Confirmation button");
		WebElement element = driver.findElement(By.xpath("//button[text()='Javascript Confirmation']"));
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("arguments[0].scrollIntoView(true)", element);
		element.click();

		System.out.println("Step-Enter Switch to alert");
		Alert alert = driver.switchTo().alert();
		System.out.println("Step-Validate the alert message");
		String actualText = alert.getText();
		String expectedText = "Are you are doing your homework regularly, Press Okay else Cancel!!";
		if (actualText.equals(expectedText))
			System.out.println("Text is ok");
		else
			System.out.println("Text is Wrong");
		alert.accept();

		System.out.println("Step-Validate the confirmation message displayed below ok button");
		String actualOkMsgText = driver.findElement(By.xpath("//p[text()='You pressed OK!']")).getText();
		String expectedOkMsgText = "You pressed OK!";
		if (actualOkMsgText.equals(expectedOkMsgText))
			System.out.println("Message is ok");
		else
			System.out.println("Wrong ok message");

		Thread.sleep(3000);
		System.out.println("Step-Enter Click on Confirmation button");
		driver.findElement(By.xpath("//button[text()='Javascript Confirmation']")).click();;
		System.out.println("Step-Enter-Switch to alert");
		alert = driver.switchTo().alert();
		alert.dismiss();

		System.out.println("Step-Validate the confirmation message displayed below cancel button");
		String actualCancelText = driver.findElement(By.xpath("//p[text()='You pressed Cancel!']")).getText();
		String expectedCancelMsgText = "You pressed Cancel!";
		if (actualCancelText.equals(expectedCancelMsgText))
			System.out.println("Cancel Message is ok");
		else
			System.out.println("Wrong Cancel message");
	}

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		new AlertProg3().prog3();
	}

}
