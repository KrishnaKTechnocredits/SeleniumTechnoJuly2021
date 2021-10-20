/*Test Case 3 - 
Naivgate to "http://automationbykrishna.com/#"
Navigate to Basic Elements tab
Navigate to DIFFERENT EXAMPLES OF ALERTS section
Click on Javascript Confirmation button
Validate the alert message and accept the alert.
Validate the confirmation message displayed below the Javascript Confirmation button.
Click on Javascript Confirmation button
Dismiss the alert.
Validate the confirmation message displayed below the Javascript Confirmation button.*/

package astha.Assignment5;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class TestCase3 {

	static void validateAlertMessage(String alertAction) throws InterruptedException {
		System.out.println("Step -1 : Launch chrome browser and navigate to AutomationByKrishna");
		WebDriver driver = base.PredefinedActions.start();
		System.out.println("Step - Passed");
		System.out.println("Step -2 : Navigate to BasicElements tab");
		driver.findElement(By.linkText("Basic Elements")).click();
		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)");
		System.out.println("Step - Passed");
		System.out.println("Step -3 Click on javascript confirmation button");
		driver.findElement(By.id("javascriptConfirmBox")).click();
		System.out.println("Step - Passed");
		System.out.println("Step -4 Validate the alert pop-up");
		Alert alert = driver.switchTo().alert();
		System.out.println("Step -Passed");
		System.out.println("Step -5 Validate the alert message");
		String expectedMsg = "Are you are doing your homework regularly, Press Okay else Cancel!!";
		String actualMsg = alert.getText();
		if (expectedMsg.equals(actualMsg))
			System.out.println("Step - Passed");
		else
			System.out.println("Step - Failed");
		if (alertAction.equals("Accept")) {
			System.out.println("Step -6 Accept the alert");
			alert.accept();
			System.out.println("Step - Passed");
			System.out.println("Step -7 Validate the success message after accepting the alert");
			String expectedSuccessMsg = "You pressed OK!";
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
			String expectedSuccessMsg = "You pressed Cancel!";
			String actualSuccessMsg = driver.findElement(By.id("pgraphdemo")).getText();
			if (expectedSuccessMsg.equals(actualSuccessMsg))
				System.out.println("Step - Passed");
			else
				System.out.println("Step - Failed");
		}
		driver.quit();
	}
	
	public static void main(String[] args) throws InterruptedException {
		TestCase3.validateAlertMessage("Accept");
		TestCase3.validateAlertMessage("Dismiss");
	}
}
