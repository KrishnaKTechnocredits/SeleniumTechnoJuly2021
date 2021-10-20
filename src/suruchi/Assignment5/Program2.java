package suruchi.Assignment5;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import base.PredefinedActions;

public class Program2 {

	void verifyAlertMessageAndAcceptAlert() throws InterruptedException {
		WebDriver driver = PredefinedActions.start();

		System.out.println("Click on Basic Elements tab");
		driver.findElement(By.id("basicelements")).click();

		Thread.sleep(3000);
		System.out.println("Click on Alert button");
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)");
		
		Thread.sleep(2000);
		driver.findElement(By.id("javascriptAlert")).click();

		Thread.sleep(2000);
		Alert alert = driver.switchTo().alert();
		String alertText = alert.getText();
		alert.accept();

		if (alertText.equals("You must be TechnoCredits student!!"))
			System.out.println("Correct Alert message");
		else
			System.out.println("Incorrect text message");

		driver.close();

		System.out.println("Test Case Passed");
	}

	public static void main(String[] args) throws InterruptedException {
		new Program2().verifyAlertMessageAndAcceptAlert();
	}
}