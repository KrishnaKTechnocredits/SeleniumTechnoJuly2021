package astha.Assignment5;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class TestCase4 {

	static void validateAlertMessage(String alertAction, String name) throws InterruptedException {
		System.out.println("Step -1 : Launch chrome browser and navigate to AutomationByKrishna");
		WebDriver driver = base.PredefinedActions.start();
		System.out.println("Step - Passed");
		System.out.println("Step -2 : Navigate to BasicElements tab");
		driver.findElement(By.linkText("Basic Elements")).click();
		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)");
		System.out.println("Step - Passed");
		System.out.println("Step -3 Click on javascript prompt button");
		driver.findElement(By.xpath("//button[@id = 'javascriptPromp']")).click();
		System.out.println("Step - Passed");
		System.out.println("Step -4 Validate the alert pop-up");
		Alert alert = driver.switchTo().alert();
		System.out.println("Step -Passed");
		System.out.println("Step -5 Validate the alert message");
		String expectedMsg = "Please enter your name :";
		String actualMsg = alert.getText();
		if (expectedMsg.equals(actualMsg))
			System.out.println("Step - Passed");
		else
			System.out.println("Step - Failed");
		alert.sendKeys(name);
		if (alertAction.equals("Accept")) {
			System.out.println("Step -6 Accept the alert");
			alert.accept();
			System.out.println("Step - Passed");
			System.out.println("Step -7 Validate the success message after accepting the alert");
			String expectedSuccessMsg = "Hello " +name+"! How are you today?";
			String actualSuccessMsg = driver.findElement(By.id("pgraphdemo")).getText();
			if (expectedSuccessMsg.equals(actualSuccessMsg))
				System.out.println("Step - Passed");
			else
				System.out.println("Step - Failed");
		} else {
			System.out.println("Step -6 Dismiss the alert");
			alert.dismiss();
			System.out.println("Step - Passed");
			System.out.println("Step -7 Validate the cancel message after dismissing the alert");
			String expectedSuccessMsg = "User cancelled the prompt.";
			String actualSuccessMsg = driver.findElement(By.id("pgraphdemo")).getText();
			if (expectedSuccessMsg.equals(actualSuccessMsg))
				System.out.println("Step - Passed");
			else
				System.out.println("Step - Failed");
		}
		driver.quit();
	}
	
	public static void main(String[] args) throws InterruptedException {
		TestCase4.validateAlertMessage("Accept","astha");
		TestCase4.validateAlertMessage("Dismiss","astha");
	}
}
