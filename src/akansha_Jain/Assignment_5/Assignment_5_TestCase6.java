/* Assignment 5 - 17th Oct’2021
http://automationbykrishna.com/#

Test Case 6 - 
Go to "http://automationbykrishna.com/#"
Navigate to Basic Elements tab
Navigate to the Basic Forms section and enter the email address and password 
Click on Submit button
Validate the success alert message.
Accept the alert  */

package akansha_Jain.Assignment_5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment_5_TestCase6 {
	WebDriver driver;

	public Assignment_5_TestCase6(String url) {
		System.setProperty("webdriver.chrome.driver",
				"//Users//punchh_akansha//eclipse-workspace//Java_Techno_Selenium_2021//resources//chromedriver");
		System.out.println("STEP - Open Chrome Browser");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		System.out.println("STEP - Enter url");
		driver.get(url);
	}

	// Test Case-6
	void testCase6() throws InterruptedException {
		Thread.sleep(3000);
		System.out.println("STEP- Tap on basic elements");
		driver.findElement(By.xpath("//a[@id='basicelements']")).click();
		Thread.sleep(3000);
		System.out.println("STEP- Enter email");
		driver.findElement(By.xpath("//input[@id='exampleInputEmail1']")).sendKeys("goyanka.akku@gmail.com");
		System.out.println("STEP- Enter password");
		driver.findElement(By.xpath("//input[@id='UserLastName']")).sendKeys("qwertyui@123");
		System.out.println("STEP- Tap on submit button");
		driver.findElement(By.xpath("//button[@id='submitb2']")).click();
		System.out.println("STEP- Get alert message");
		String alertMessage = driver.switchTo().alert().getText();
		String expectedAlertMessage = "You successfully clicked on it";
		System.out.println("STEP- Validate alert message");
		if (alertMessage.equals(expectedAlertMessage))
			System.out.println("Alert message match");
		else
			System.out.println("Alert message not match");
		driver.switchTo().alert().accept();

		driver.close();
		driver.quit();
	}

	public static void main(String[] args) throws InterruptedException {
		String url = "http://automationbykrishna.com/#";
		new Assignment_5_TestCase6(url).testCase6();
	}
}