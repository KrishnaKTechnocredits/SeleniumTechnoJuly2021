/* Assignment 5 - 17th Oct’2021
http://automationbykrishna.com/#

Test Case 2 - 
Naivgate to "http://automationbykrishna.com/#"
Navigate to Basic Elements tab
Navigate to DIFFERENT EXAMPLES OF ALERTS section
Click on Alert button
Validate the alert message and accept the alert. */

package akansha_Jain.Assignment_5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment_5_TestCase2 {
	WebDriver driver;
	
	public Assignment_5_TestCase2(String url) {
		System.setProperty("webdriver.chrome.driver", "//Users//punchh_akansha//eclipse-workspace//Java_Techno_Selenium_2021//resources//chromedriver");
		System.out.println("STEP - Open Chrome Browser");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		System.out.println("STEP - Enter url");
		driver.get(url);
	}
	
	//Test Case-2
	void testCase2() throws InterruptedException {
		System.out.println("STEP- Tap on basic elements");
		driver.findElement(By.xpath("//a[@id='basicelements']")).click();
		Thread.sleep(3000);
		System.out.println("STEP- Tap on Alert button");
		driver.findElement(By.xpath("//button[@id='javascriptAlert']")).click();
		System.out.println("STEP- Get alert message");
		String expectedMessage = "You must be TechnoCredits student!!";
		String alertMessage = driver.switchTo().alert().getText();
		System.out.println("STEP- Validate alert message");
		if(alertMessage.equals(expectedMessage))
			System.out.println("Alert message match");
		else
			System.out.println("Alert message not match");
		System.out.println("STEP- Accept alert");
		driver.switchTo().alert().accept();
		
		driver.close();
		driver.quit();
	}

	public static void main(String[] args) throws InterruptedException {
		String url= "http://automationbykrishna.com/#";
		new Assignment_5_TestCase2(url).testCase2();
	}
}