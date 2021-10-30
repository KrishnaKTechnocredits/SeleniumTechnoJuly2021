package suruchi.Assignment5;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.PredefinedActions;

public class Program6 {

	static void validateSuccessAlertMessage(String emailAddress, String pwd) throws InterruptedException {
		WebDriver driver = PredefinedActions.start();

		Thread.sleep(3000);
		System.out.println("Navigate to Basic Elements tab");
		driver.findElement(By.linkText("Basic Elements")).click();

		Thread.sleep(2000);
		System.out.println("Navigate to the Basic Forms section and enter the email address and password");

		System.out.println("Enter email address");
		driver.findElement(By.name("emailId")).sendKeys(emailAddress);

		Thread.sleep(2000);
		System.out.println("Enter password");
		driver.findElement(By.id("pwd")).sendKeys(pwd);

		Thread.sleep(2000);
		System.out.println("Click on Submit button");
		driver.findElement(By.id("submitb2")).click();

		Thread.sleep(2000);
		System.out.println("Validate the success alert message.");

		Alert alert = driver.switchTo().alert();

		String actualAlertText = alert.getText();

		Thread.sleep(2000);
		if (actualAlertText.equals("You successfully clicked on it")) {
			System.out.println("Correct Alert Message");
			alert.accept();
		} else {
			System.out.println("Wrong Alert Message");
			alert.accept();
		}

		driver.close();

		System.out.println("Test Case passed");
	}

	public static void main(String[] args) throws InterruptedException {
		Program6.validateSuccessAlertMessage("suru123@mail.com", "suru123");
	}
}