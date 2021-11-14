/*
 Naivgate to "http://automationbykrishna.com/#"
Enter the login details
Validate the positive scenario for password (By entering 8 characters)
Validate the success message
Validate the negative scenario for password (Enter less than 8 characters)
Validate the failure message

 */

package umakant.alertAndConfirmation;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.PredefinedActions;

public class TestCase1 {
	String userName;
	String password;

	TestCase1(String userName, String password) {
		this.userName = userName;
		this.password = password;
	}

	void validateLoginScenarion() throws InterruptedException {
		System.out.println("Input: UserName-" + userName + ",Password-" + password);
		System.out.println("Step1: Launch the automationbykrishna in chrome");
		WebDriver driver = PredefinedActions.start();
		System.out.println("Step2: Click on registration");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@id='registration2']")).click();
		Thread.sleep(3000);
		System.out.println("Step3: Enter the User Name");
		driver.findElement(By.xpath("//input[@id='unameSignin']")).sendKeys(userName);
		System.out.println("Step4: Enter the password");
		driver.findElement(By.xpath("//input[@id='pwdSignin']")).sendKeys(password);
		System.out.println("Step5: Click on the login");
		driver.findElement(By.xpath("//button[@id='btnsubmitdetails']")).click();
		System.out.println("Step6: Switch to alert window");
		Alert alert = driver.switchTo().alert();
		System.out.println("Step7: Get the message in alert window");
		String alertMessage = alert.getText();
		System.out.println("Step8: Click on OK in alert window");
		alert.accept();
		System.out.println("Step9:Compare the expected and actual message");
		if (password.length() == 0) {
			if (alertMessage.equals("Failed! please enter password"))
				System.out.println("Test Pass");
			else
				System.out.println("Test Fail");
		} else if (userName.length() == 0) {
			if (alertMessage.equals("Failed! please enter username"))
				System.out.println("Test Pass");
			else
				System.out.println("Test Fail");
		} else if (password.length() > 8) {
			if (alertMessage.equals("Success!"))
				System.out.println("Test Pass");
			else
				System.out.println("Test Fail");
		} else {
			if (alertMessage.equals("Failed! please enter strong password"))
				System.out.println("Test Pass");
			else
				System.out.println("Test Fail");
		}
		driver.close();
	}

	public static void main(String[] args) throws InterruptedException {
		TestCase1 input1 = new TestCase1("Umakant", "qweert12");
		TestCase1 input2 = new TestCase1("Umakant", "qweert");
		TestCase1 input3 = new TestCase1("Umakant", "");
		TestCase1 input4 = new TestCase1("", "");
		TestCase1 input5 = new TestCase1("", "abcd");
		input1.validateLoginScenarion();
		input2.validateLoginScenarion();
		input3.validateLoginScenarion();
		input4.validateLoginScenarion();
		input5.validateLoginScenarion();
	}

}
