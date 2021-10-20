package suruchi.Assignment5;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import base.PredefinedActions;

public class Program4 {

	static void promptConfirmation(String alertAction, String name) throws InterruptedException {
		WebDriver driver = PredefinedActions.start();

		System.out.println("Navigate to Basic Elements tab");
		driver.findElement(By.linkText("Basic Elements")).click();

		Thread.sleep(2000);
		System.out.println("Navigate to DIFFERENT EXAMPLES OF ALERTS section");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)");

		Thread.sleep(2000);
		System.out.println("Click on Javascript Prompt button");
		driver.findElement(By.id("javascriptPromp")).click();

		System.out.println("Verify instruction message in alert pop-up");

		Thread.sleep(2000);
		Alert alert = driver.switchTo().alert();

		String actualInstructionMessage = alert.getText();

		if (actualInstructionMessage.equals("Please enter your name :"))
			System.out.println("Instruction message is correct");
		else
			System.out.println("Wrong instruction message");

		Thread.sleep(2000);
		System.out.println("Enter the name in the alert and accept the alert.");

		if (alertAction.equals("Accept")) {
			Thread.sleep(2000);
			alert.sendKeys(name);

			Thread.sleep(2000);
			alert.accept();

			String expectedText = "Hello " + name + "! How are you today?";

			Thread.sleep(2000);
			System.out.println("Validate the confirmation message displayed below the Javascript Confirmation button.");
			String actualText = driver.findElement(By.id("pgraphdemo")).getText();

			if (actualText.contains(expectedText))
				System.out.println("Correct greeting message");
			else
				System.out.println("Wrong greeting message");
		} else {
			Thread.sleep(2000);
			alert.sendKeys(name);

			Thread.sleep(2000);
			alert.dismiss();

			String expectedText = "User cancelled the prompt.";

			Thread.sleep(2000);
			System.out.println("Validate the confirmation message displayed below the Javascript Confirmation button.");
			String actualText = driver.findElement(By.id("pgraphdemo")).getText();

			if (actualText.contains(expectedText))
				System.out.println("Correct cancellation message");
			else
				System.out.println("Wrong cancellation message");
		}

		driver.close();

		System.out.println("Test Case passed");
	}

	public static void main(String[] args) throws InterruptedException {
		Program4.promptConfirmation("Accept", "Suruchi");
		Program4.promptConfirmation("Dismiss", "Suruchi");
	}
}