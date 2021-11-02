package monali.Assignment_5_Alerts;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import dattaraj_W.base.PredefinedActions;

/*Test Case 2 - 
Naivgate to "http://automationbykrishna.com/#"
Navigate to Basic Elements tab
Navigate to DIFFERENT EXAMPLES OF ALERTS section
Click on Alert button
Validate the alert message and accept the alert.*/

public class TestCase_2 {

	void validationAlert(String expectedText) throws InterruptedException {
		System.out.println("Step 1: Launch Automation By Krishna Site");
		WebDriver driver = PredefinedActions.start();
		System.out.println("Step 2: Click on Basic Elements tab");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@id='basicelements']")).click();
		System.out.println("Step 3: Click on alert button");
		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)");
		driver.findElement(By.xpath("//button[text()='Alert']")).click();
		System.out.println("Step 4: Switch to Alert window");
		Alert alert = driver.switchTo().alert();
		System.out.println("Step 5: get alert window message");
		String actualText = alert.getText();
		System.out.println("Step 6 : Accept the alert");
		alert.accept();
		System.out.println("Step 7: validation on alert message");

		if (expectedText.equals(actualText))
			System.out.println("Test Pass");
		else
			System.out.println("Test Fail");
		driver.close();

	}

	public static void main(String[] args) throws InterruptedException {
		TestCase_2 tc2 = new TestCase_2();
		String expectedText = "You must be TechnoCredits student!!";
		tc2.validationAlert(expectedText);
		String failedText="College Student";
		tc2.validationAlert(failedText);

	}
}
