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
package shreyaG.Assignment_5;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import base.PredefinedActions;

public class TestCase3 {
	void Program3() throws InterruptedException {
		WebDriver driver = PredefinedActions.start();
		
		System.out.println("Click on basic element");
		driver.findElement(By.id("basicelements")).click();
		Thread.sleep(2000);
		
		System.out.println("Click on javascript confirmation button");
		driver.findElement(By.id("javascriptConfirmBox")).click();
		
		System.out.println("Validate the alert message and accept the alert.");
		Alert alert=driver.switchTo().alert();
		String text=alert.getText();
		String actualText="Are you are doing your homework regularly, Press Okay else Cancel!!";
		if(text.equals(actualText)) {
			System.out.println("**Alert message is correct**");
			alert.accept();
		}
		
		System.out.println("Validate the confirmation message displayed below the Javascript Confirmation button.");
		String actualText1="You pressed OK!";
		String text1=driver.findElement(By.id("pgraphdemo")).getText();
		if(text1.equals(actualText1))
			System.out.println("**Confirmation message is correct**");
		else
			System.out.println("**Confirmation message is Incorrect**");
		
		System.out.println("Click on Javascript Confirmation button");
		driver.findElement(By.id("javascriptConfirmBox")).click();
		System.out.println("Switch to alert");
		Alert alert1=driver.switchTo().alert();
		System.out.println("Dismiss the alert");
		alert1.dismiss();
		System.out.println("Validate the confirmation message displayed below the Javascript Confirmation button.");
		String actualText2="You pressed Cancel!";
		String text2=driver.findElement(By.id("pgraphdemo")).getText();
		if(text1.equals(actualText2))
			System.out.println("**Confirmation meassage for cancel is correct**");
		else
			System.out.println("**Confirmation meassage for cancel is Incorrect**");
		System.out.println("Test runs successfully");
		driver.close();
	}

	public static void main(String[] args) throws InterruptedException {
		new TestCase3().Program3();

	}

}
