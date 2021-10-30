/*Test Case 2 - 

Naivgate to "http://automationbykrishna.com/#"
Navigate to Basic Elements tab
Navigate to DIFFERENT EXAMPLES OF ALERTS section
Click on Alert button
Validate the alert message and accept the alert.*/

package astha.Assignment5;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class TestCase2 {

	static void validateAlertMessage() throws InterruptedException {
		System.out.println("Step -1 : Launch chrome browser and navigate to AutomationByKrishna");
		WebDriver driver = base.PredefinedActions.start();
		System.out.println("Step - Passed");
		System.out.println("Step -2 : Navigate to BasicElements tab");
		driver.findElement(By.linkText("Basic Elements")).click();
		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)");
		System.out.println("Step - Passed");
		System.out.println("Step -3 Click on alert button");
		driver.findElement(By.id("javascriptAlert")).click();
		System.out.println("Step - Passed");
		System.out.println("Step -4 Validate the alert pop-up");
		Alert alert = driver.switchTo().alert();
		System.out.println("Step -Passed");
		System.out.println("Step -5 Validate the alert message");
		String expectedMsg = "You must be TechnoCredits student!!";
		String actualMsg = alert.getText();
		if (expectedMsg.equals(actualMsg))
			System.out.println("Step - Passed");
		else
			System.out.println("Step - Failed");
		System.out.println("Step -6 Close the alert");
		alert.accept();
		System.out.println("Step - Passed");
		driver.quit();
	}

	public static void main(String[] args) throws InterruptedException {
		System.out.println("Validate positive scenario");
		TestCase2.validateAlertMessage();
	}
}
