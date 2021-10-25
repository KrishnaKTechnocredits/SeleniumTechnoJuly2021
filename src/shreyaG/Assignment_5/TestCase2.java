/*Test Case 2 - 

Naivgate to "http://automationbykrishna.com/#"
Navigate to Basic Elements tab
Navigate to DIFFERENT EXAMPLES OF ALERTS section
Click on Alert button
Validate the alert message and accept the alert.*/
package shreyaG.Assignment_5;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import base.PredefinedActions;

public class TestCase2 {
	void program2() throws InterruptedException {
		WebDriver driver = PredefinedActions.start();
		
		System.out.println("Click on basic element");
		driver.findElement(By.id("basicelements")).click();
		Thread.sleep(2000);
		
		System.out.println("Click on alert button");
		driver.findElement(By.id("javascriptAlert")).click();
		Thread.sleep(2000);
		
		System.out.println("Switch to alert");
		System.out.println("Validate the message");
		Alert alert=driver.switchTo().alert();
		String text=alert.getText();
		
		String actualText="You must be TechnoCredits student!!";
		if(text.equals(actualText)) {
			System.out.println("Accept the alert");
			alert.accept();
			System.out.println("Test pass successfully");
		}
		driver.close();
		
	}
	public static void main(String[] args) throws InterruptedException {
		new TestCase2().program2();

	}

}
