/*Test Case 4 - 

Go to "http://automationbykrishna.com/#"
Navigate to Basic Elements tab
Navigate to DIFFERENT EXAMPLES OF ALERTS section
Click on Javascript Prompt button
Enter the name in the alert and accept the alert.
Validate the confirmation message displayed below the Javascript Confirmation button.*/
package shreyaG.Assignment_5;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.PredefinedActions;

public class TestCase4 {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = PredefinedActions.start();
		System.out.println("Click on basic element");
		driver.findElement(By.id("basicelements")).click();
		Thread.sleep(2000);
		
		System.out.println("Click on javascript prompt button");
		driver.findElement(By.id("javascriptPromp")).click();
		
		String name="Niyati";
		System.out.println("Switch to alert");
		Alert alert=driver.switchTo().alert();
		Thread.sleep(2000);
		System.out.println("Enter the name in the alert");
		alert.sendKeys(name);
		Thread.sleep(2000);
		System.out.println("Accept the alert");
		alert.accept();
		
		
		System.out.println("Validate the confirmation message displayed below the Javascript prompt button.");
		String text=driver.findElement(By.id("pgraphdemo")).getText();
		String actualText="Hello Niyati! How are you today?";
		if(actualText.equals(text)) {
			System.out.println("Message displayed correctly");
		}
		else {
			System.out.println("Message displayed is incorrect");
		}
		System.out.println("Test runs successfully");
		Thread.sleep(3000);
		driver.close();
	}

}
