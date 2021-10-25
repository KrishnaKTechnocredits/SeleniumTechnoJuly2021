/* Assignment 5 - 17th Oct’2021
http://automationbykrishna.com/#

Test Case 3 - 
Naivgate to "http://automationbykrishna.com/#"
Navigate to Basic Elements tab
Navigate to DIFFERENT EXAMPLES OF ALERTS section
Click on Javascript Confirmation button
Validate the alert message and accept the alert.
Validate the confirmation message displayed below the Javascript Confirmation button.
Click on Javascript Confirmation button
Dismiss the alert.
Validate the confirmation message displayed below the Javascript Confirmation button. */

package akansha_Jain.Assignment_5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment_5_TestCase3 {
	WebDriver driver;
	
	public Assignment_5_TestCase3(String url) {
		System.setProperty("webdriver.chrome.driver", "//Users//punchh_akansha//eclipse-workspace//Java_Techno_Selenium_2021//resources//chromedriver");
		System.out.println("STEP - Open Chrome Browser");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		System.out.println("STEP - Enter url");
		driver.get(url);
	}
	
	//Test Case-3
	void testCase3() throws InterruptedException {
		//Accept alert
		System.out.println("STEP- Tap on basic elements");
		driver.findElement(By.xpath("//a[@id='basicelements']")).click();
		Thread.sleep(3000);
		System.out.println("STEP- Tap on Javascript Confirmation");
		driver.findElement(By.xpath("//button[@id='javascriptConfirmBox']")).click();
		System.out.println("STEP- Get alert message");
		String expectedAlertMessage = "Are you are doing your homework regularly, Press Okay else Cancel!!";
		String alertMessage = driver.switchTo().alert().getText();
		System.out.println("STEP- Validate alert message");
		if(alertMessage.equals(expectedAlertMessage))
			System.out.println("Alert message match");
		else
			System.out.println("Alert message not match");
		System.out.println("STEP- Press okay");
		driver.switchTo().alert().accept();
		System.out.println("STEP- Validate confirmation message");
		String expectedConfirmationMessage = "You pressed OK!";
		String confirmationMessage = driver.findElement(By.xpath("//p[text()='You pressed OK!']")).getText();
		if(confirmationMessage.equals(expectedConfirmationMessage))
			System.out.println("Confirmation message match");
		else
			System.out.println("Confirmation message not match");
		
		//Dismiss alert
		System.out.println("STEP- Tap on Javascript Confirmation");
		driver.findElement(By.xpath("//button[@id='javascriptConfirmBox']")).click();
		System.out.println("STEP- Validate alert message");
		if(alertMessage.equals(expectedAlertMessage))
			System.out.println("Alert message match");
		else
			System.out.println("Alert message not match");
		System.out.println("STEP- Press cancel");
		driver.switchTo().alert().dismiss();
		System.out.println("STEP- Validate confirmation message");
		String expectedConfirmationMessage2 = "You pressed Cancel!";
		String confirmationMessage2 = driver.findElement(By.xpath("//p[text()='You pressed Cancel!']")).getText();
		if(confirmationMessage2.equals(expectedConfirmationMessage2))
			System.out.println("Confirmation message match");
		else
			System.out.println("Confirmation message not match");
		
		driver.close();
		driver.quit();
	}

	public static void main(String[] args) throws InterruptedException {
		String url= "http://automationbykrishna.com/#";
		new Assignment_5_TestCase3(url).testCase3();
	}
}