/* Assignment 5 - 17th Oct 2021
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


package ritabrata_bhattacharyya.Assignment5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Test_3 {
WebDriver driver;
	
	public Test_3(String url) {
		System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
		System.out.println("STEP1 - Open Chrome Browser");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		System.out.println("STE2P - Enter url");
		driver.get(url);
	}
	

	void testCase3() throws InterruptedException {
		System.out.println("STEP3- Click on basic elements");
		driver.findElement(By.xpath("//a[@id='basicelements']")).click();
		Thread.sleep(3000);
		System.out.println("STEP4- Click on Javascript Confirmation");
		driver.findElement(By.xpath("//button[@id='javascriptConfirmBox']")).click();
		System.out.println("STEP5- Get alert message");
		String expectedAlertMessage = "Are you are doing your homework regularly, Press Okay else Cancel!!";
		String alertMessage = driver.switchTo().alert().getText();
		System.out.println("STEP5- Validate alert message");
		if(alertMessage.equals(expectedAlertMessage))
			System.out.println("Alert message match");
		else
			System.out.println("Alert message not match");
		System.out.println("STEP6- Press okay");
		driver.switchTo().alert().accept();
		System.out.println("STEP7- Validate confirmation message");
		String expectedConfirmationMessage = "You pressed OK!";
		String confirmationMessage = driver.findElement(By.xpath("//p[text()='You pressed OK!']")).getText();
		if(confirmationMessage.equals(expectedConfirmationMessage))
			System.out.println("Confirmation message match");
		else
			System.out.println("Confirmation message not match");
		
		//Dismiss alert
		System.out.println("STEP8- Tap on Javascript Confirmation");
		driver.findElement(By.xpath("//button[@id='javascriptConfirmBox']")).click();
		System.out.println("STEP9- Validate alert message");
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
		new Test_3(url).testCase3();
	}

}
