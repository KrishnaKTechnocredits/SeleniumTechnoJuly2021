package suruchi.Assignment5;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import base.PredefinedActions;

public class Program3 {

	void alertConfirmation() throws InterruptedException {
		WebDriver driver = PredefinedActions.start();

		System.out.println("Navigate to Basic Elements tab");
		driver.findElement(By.linkText("Basic Elements")).click();

		Thread.sleep(2000);
		System.out.println("Navigate to DIFFERENT EXAMPLES OF ALERTS section");

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)");

		Thread.sleep(2000);
		System.out.println("Click on Javascript Confirmation button");
		driver.findElement(By.id("javascriptConfirmBox")).click();

		Thread.sleep(2000);
		System.out.println("Validate the alert message and accept the alert.");

		Alert alert = driver.switchTo().alert();
		String alertText = alert.getText();

		if (alertText.equals("Are you are doing your homework regularly, Press Okay else Cancel!!")) {
			System.out.println("Alert message match!");
			alert.accept();
		} else
			System.out.println("Wrong message");

		Thread.sleep(2000);
		System.out.println("Validate the confirmation message displayed below the Javascript Confirmation button.");

		String actualText = driver.findElement(By.id("pgraphdemo")).getText();

		if (actualText.equals("You pressed OK!"))
			System.out.println("Correct OK message");
		else
			System.out.println("Wrong OK message");

		Thread.sleep(2000);
		System.out.println("Click on Javascript Confirmation button");
		driver.findElement(By.id("javascriptConfirmBox")).click();

		Thread.sleep(2000);
		System.out.println("Dismiss the alert.");
		alert.dismiss();

		Thread.sleep(2000);
		System.out.println("Validate the confirmation message displayed below the Javascript Confirmation button.");

		String actualDismissText = driver.findElement(By.id("pgraphdemo")).getText();

		if (actualDismissText.equals("You pressed Cancel!"))
			System.out.println("Correct Cancel message");
		else
			System.out.println("Wrong Cancel message");

		driver.close();

		System.out.println("Test Case Passed");
	}

	public static void main(String[] args) throws InterruptedException {
		new Program3().alertConfirmation();
	}
}