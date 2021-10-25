/*Test Case 2 - 

Naivgate to "http://automationbykrishna.com/#"
Navigate to Basic Elements tab
Navigate to DIFFERENT EXAMPLES OF ALERTS section
Click on Alert button
Validate the alert message and accept the alert.*/
package shalakaP.Assignment5;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import shalakaP.Helper.PredefinedActions;

public class AlertProg2 {
	void prog2() throws InterruptedException {
		WebDriver driver = PredefinedActions.start();
		System.out.println("Step-Click on Basic Elements");
		driver.findElement(By.linkText("Basic Elements")).click();

		Thread.sleep(3000);
		System.out.println("Step-Click on Alert");
		WebElement element = driver.findElement(By.xpath("//button[text()='Alert']"));
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("arguments[0].scrollIntoView(true)", element);
		element.click();

		System.out.println("Step-Switch to Alert");
		Alert alert = driver.switchTo().alert();
		String actualText = alert.getText();

		System.out.println("Step-Validate alert message");
		String expectedText = "You must be TechnoCredits student!!";
		if (actualText.equals(expectedText))
			System.out.println("message is ok");
		else
			System.out.println("Wrong message");
		alert.accept();

	}

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		new AlertProg2().prog2();
	}

}
