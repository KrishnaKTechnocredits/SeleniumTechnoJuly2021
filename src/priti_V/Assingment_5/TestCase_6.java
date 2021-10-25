package priti_V.Assingment_5;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCase_6 {
	void verifyBasicForms(String emial, String password) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./resources/chromedriver.exe");
		System.out.println("Chrome Browser opened");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		System.out.println("Website :automationbykrishna.com");
		driver.get("http://automationbykrishna.com/");
		
		System.out.println("Step: Click on the Basic Elemets link/menu");
		driver.findElement(By.xpath("//a[@id ='basicelements']" )).click();
		Thread.sleep(4000);
		
		System.out.println("Step: Enter Email address");
		driver.findElement(By.xpath("//input[@name ='emailId']")).sendKeys("email");
		
		System.out.println("Step: Pass word");
		driver.findElement(By.xpath("//input[@id ='pwd']")).sendKeys(password);
		
		System.out.println("Step: Click on the Submit Button");
		driver.findElement(By.xpath("//section [@class ='panel']/div/div[5]//button[@id ='submitb2']")).click();
		
		System.out.println("Step: Handle the alert message ");
		Alert alert = driver.switchTo().alert();
		
		System.out.println("Step: Validate the success alert message");
		if (alert.getText().equals("You successfully clicked on it")) {
			System.out.println("Alert messsage validated successfully");
			System.out.println("Step: Accpet the alert ");
			alert.accept();
		}
		else {
			System.out.println("Alert messsage is not validated successfully");
			alert.accept();
		}
		
		System.out.println("Test case_5_6 passed successfully");
		driver.close();
	}
	
	public static void main(String[] a) throws InterruptedException {
		TestCase_6 testCase_6 = new TestCase_6();
		String email = "psvattanavar@gmail.com";
		String password =  "priti123456";
		testCase_6.verifyBasicForms(email,password);
	}
}
/*Go to "http://automationbykrishna.com/#"
Navigate to Basic Elements tab
Navigate to the Basic Forms scetion and enter the email address and password 
Click on Submit button
Validate the success alert message.
Accept the alert*/