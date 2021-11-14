/*Test Case 1 -

Naivgate to "http://automationbykrishna.com/#"
Enter the login details
Validate the positive scenario for password (By entering 8 characters)
Validate the success message
Validate the negative scenario for password (Enter less than 8 characters)
Validate the failure message*/

package parthavD.Assignment5;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.PredefinedActions;

public class TestCase1 {
	
	void validateLoginFunctionality()  throws InterruptedException{
		System.out.println("Step1 - Launch Automation by Krishna Webpage");
		WebDriver driver = PredefinedActions.start();
		Thread.sleep(3000);
		System.out.println("Step2 - Click on Registration button");
		driver.findElement(By.linkText("Registration")).click();
		Thread.sleep(2000);
		System.out.println("Step3 - Positive Scenario verification");
		System.out.println("Step4 - Enter user name");
		driver.findElement(By.xpath("//input[@id='unameSignin']")).sendKeys("abc1@xyz.com");
		System.out.println("Step5 - Enter password");
		driver.findElement(By.xpath("//input[@id='pwdSignin']")).sendKeys("Password@123");
		System.out.println("Step6 - Click on Login button");
		driver.findElement(By.xpath("//button[@id='btnsubmitdetails']")).click();
		System.out.println("Step7 - Verify positive / success message");
		Alert alert = driver.switchTo().alert();
		String messageText = alert.getText();
		System.out.println("Step8 - Close Alert message");
		alert.accept();
		if (messageText.equals("Success!"))
			System.out.println("Positive scenario passed");
		else
			System.out.println("Positive scenario failed");
		
		System.out.println("Step9 - Negative Scenario verification");
		System.out.println("Ste10 - Enter user name");
		driver.findElement(By.xpath("//input[@id='unameSignin']")).clear();
		driver.findElement(By.xpath("//input[@id='unameSignin']")).sendKeys("abc1@xyz.com");
		System.out.println("Step11 - Enter password");
		driver.findElement(By.xpath("//input[@id='pwdSignin']")).clear();
		driver.findElement(By.xpath("//input[@id='pwdSignin']")).sendKeys("Pasor");
		System.out.println("Step12 - Click on Login button");
		driver.findElement(By.xpath("//button[@id='btnsubmitdetails']")).click();
		alert = driver.switchTo().alert();
		System.out.println("Step13 - Verify error message");
		messageText = alert.getText();
		System.out.println("Step14 - Close Alert message");
		alert.accept();
		if (messageText.equals("Failed! please enter strong password"))
			System.out.println("Negative scenario passed");
		else
			System.out.println("Negative scenario failed");
			driver.close();
	}

	public static void main(String[] args)  throws InterruptedException {
		new TestCase1().validateLoginFunctionality();

	}

}
