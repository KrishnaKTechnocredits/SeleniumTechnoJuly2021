/* Assignment 5 - 17th Oct 2021
http://automationbykrishna.com/#

Test Case 6 - 
Go to "http://automationbykrishna.com/#"
Navigate to Basic Elements tab
Navigate to the Basic Forms section and enter the email address and password 
Click on Submit button
Validate the success alert message.
Accept the alert  */


package ritabrata_bhattacharyya.Assignment5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test_6 {
	WebDriver driver;
	public Test_6(String url) {
		System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
		System.out.println("STEP1 - Open Chrome Browser");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		System.out.println("STEP2 - Enter url");
		driver.get(url);
	}
	
	//Test Case-6
	void testCase6() throws InterruptedException {
		Thread.sleep(3000);
		System.out.println("STEP3- Click on basic elements");
		driver.findElement(By.xpath("//a[@id='basicelements']")).click();
		Thread.sleep(3000);
		System.out.println("STEP4- Enter email");
		driver.findElement(By.xpath("//input[@id='exampleInputEmail1']")).sendKeys("ritabrata.bhattacharyya96@gmail.com");
		System.out.println("STEP5- Enter password");
		driver.findElement(By.xpath("//input[@id='UserLastName']")).sendKeys("qwertyui@123");
		System.out.println("STEP6- Tap on submit button");
		driver.findElement(By.xpath("//button[@id='submitb2']")).click();
		System.out.println("STEP7- Get alert message");
		String alertMessage = driver.switchTo().alert().getText();
		String expectedAlertMessage = "You successfully clicked on it";
		System.out.println("STEP8- Validate alert message");
		if(alertMessage.equals(expectedAlertMessage))
			System.out.println("Alert message match");
		else
			System.out.println("Alert message not match");
		driver.switchTo().alert().accept();
		
		driver.close();
		driver.quit();
	}

	public static void main(String[] args) throws InterruptedException {
		String url= "http://automationbykrishna.com/#";
		new Test_6(url).testCase6();
	}

}
