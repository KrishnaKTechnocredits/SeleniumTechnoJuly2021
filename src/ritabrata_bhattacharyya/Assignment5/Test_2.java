/* Assignment 5 - 17th Oct 2021
http://automationbykrishna.com/#

Test Case 2 - 
Naivgate to "http://automationbykrishna.com/#"
Navigate to Basic Elements tab
Navigate to DIFFERENT EXAMPLES OF ALERTS section
Click on Alert button
Validate the alert message and accept the alert. */

package ritabrata_bhattacharyya.Assignment5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Test_2 {
	WebDriver driver;
	public Test_2(String url) {
		System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
		System.out.println("STEP1 - Open Chrome Browser");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		System.out.println("STEP2 - Enter url");
		driver.get(url);
	}
	
	
	void testCase2() throws InterruptedException {
		System.out.println("STEP3- Click on basic elements");
		driver.findElement(By.xpath("//a[@id='basicelements']")).click();
		Thread.sleep(3000);
		System.out.println("STEP4- Click on Alert button");
		driver.findElement(By.xpath("//button[@id='javascriptAlert']")).click();
		System.out.println("STEP5- Get alert message");
		String expectedMessage = "You must be TechnoCredits student!!";
		String alertMessage = driver.switchTo().alert().getText();
		System.out.println("STEP6- Validate alert message");
		if(alertMessage.equals(expectedMessage))
			System.out.println("Alert message match");
		else
			System.out.println("Alert message not match");
		System.out.println("STEP7- Accept alert");
		driver.switchTo().alert().accept();
		
		driver.close();
		driver.quit();
	}

	public static void main(String[] args) throws InterruptedException {
		String url= "http://automationbykrishna.com/#";
		new Test_2(url).testCase2();
	}

}
