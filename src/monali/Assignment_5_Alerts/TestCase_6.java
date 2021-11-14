package monali.Assignment_5_Alerts;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import dattaraj_W.base.PredefinedActions;

/*Test Case 6 - 
 to "http://automationbykrishna.com/#"
Navigate to Basic Elements tab
Navigate to the Basic Forms scetion and enter the email address and password 
Click on Submit button
Validate the success alert message.
Accept the alert
*/
public class TestCase_6 {

	String email;
	String password;

	TestCase_6(String email, String password) {
		this.email = email;
		this.password = password;
	}

	void basicFormsAlertValidation() throws InterruptedException {
		System.out.println("Step 1: Launch Automation By Krishna Site");
		WebDriver driver = PredefinedActions.start();
		System.out.println("Step 2: Click on Basic Elements tab");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@id='basicelements']")).click();
		Thread.sleep(3000);
		System.out.println("Step 3: Enter email address");
		driver.findElement(By.xpath("//input[@id='exampleInputEmail1']")).sendKeys(email);
		System.out.println("Step 4: Enter password");
		driver.findElement(By.xpath("//input[@id='pwd']")).sendKeys(password);
		System.out.println("Step 5: Click on Submit button");
		driver.findElement(By.xpath("//button[@id='submitb2']")).click();
		System.out.println("Step 6: Switch to alert window");
		Alert alert = driver.switchTo().alert();
		System.out.println("Step 7: get the text of alert window");
		String actualText = alert.getText();
		System.out.println("Step 8: Validate alert messages");
		String expectedText = "You successfully clicked on it";
		if (actualText.equals(expectedText))
			System.out.println("Test pass");
		else
			System.out.println("Test Fail");
		System.out.println("Step 8: Accept the alert");
		alert.accept();

		driver.close();
	}

	public static void main(String[] args) throws InterruptedException {
		TestCase_6 input1 = new TestCase_6("test@test.com", "123dewsal");
		TestCase_6 input2 = new TestCase_6("", "");
		input1.basicFormsAlertValidation();
		input2.basicFormsAlertValidation();
	}
}
