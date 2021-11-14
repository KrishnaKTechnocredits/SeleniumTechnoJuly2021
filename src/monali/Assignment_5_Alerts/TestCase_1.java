package monali.Assignment_5_Alerts;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import dattaraj_W.base.PredefinedActions;
import umakant.alertAndConfirmation.TestCase1;

/*Test Case 1 -

Naivgate to "http://automationbykrishna.com/#"
Enter the login details
Validate the positive scenario for password (By entering 8 characters)
Validate the success message
Validate the negative scenario for password (Enter less than 8 characters)
Validate the failure message
*/
public class TestCase_1 {

	String userName;
	String password;

	TestCase_1(String userName, String password) {
		this.userName = userName;
		this.password = password;
	}

	void loginValidation() throws InterruptedException {
		System.out.println("Step 1: Launch Automation By Krishna Site");
		WebDriver driver = PredefinedActions.start();
		System.out.println("Step 2: Click on Registration link");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@id='registration2']")).click();
		Thread.sleep(3000);
		System.out.println("Step 3: Enter UserName");
		driver.findElement(By.xpath("//input[@id='unameSignin']")).sendKeys(userName);
		System.out.println("Step 4: Enter password");
		driver.findElement(By.xpath("//input[@id='pwdSignin']")).sendKeys(password);
		System.out.println("Click on submit button");
		driver.findElement(By.xpath("//button[@type='submit' and @id='btnsubmitdetails']")).click();
		System.out.println("Step 5: switch to alert window");
		Alert alert = driver.switchTo().alert();
		System.out.println("Step 6 : get alert window message");
		String alertMessage = alert.getText();
		System.out.println("Step 7 : Click on OK button on alert window");
		alert.accept();

		System.out.println("Step 8 : Compare actual and Excepted messages");

		if (password.length() == 0) {
			if (alertMessage.equals("Failed! please enter password"))
				System.out.println("Test Pass successfully please enter password");
			else
				System.out.println("Test Fail");
		} else if (userName.length() == 0) {
			if (alertMessage.equals("Failed! please enter username"))
				System.out.println("Test Pass successfully please enter username");
			else
				System.out.println("Test Fail");
		} else if (password.length() >= 8) {
			if (alertMessage.equals("Success!"))
				System.out.println("Test Pass successfully");
			else
				System.out.println("Test Fail");
		} else {
			if (alertMessage.equals("Failed! please enter strong password"))
				System.out.println("Test Pass successfully enter strong password");
			else
				System.out.println("Test Fail");
		}

		driver.close();
	}

	public static void main(String[] args) throws InterruptedException {
		TestCase_1 input1 = new TestCase_1("Monali", "12345678888");
		TestCase_1 input2 = new TestCase_1("Monali", "test");
		TestCase_1 input3 = new TestCase_1("Monali", "");
		TestCase_1 input4 = new TestCase_1("", "");
		TestCase_1 input5 = new TestCase_1("", "9876");
		input1.loginValidation();
		input2.loginValidation();
		input3.loginValidation();
		input4.loginValidation();
		input5.loginValidation();
	}

}
