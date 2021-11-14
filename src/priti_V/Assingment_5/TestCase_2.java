 package priti_V.Assingment_5;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCase_2 {
	
	static void loiginAutomationbyKrishna() throws InterruptedException {
	System.setProperty("webdriver.chrome.driver", "./resources/chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	System.out.println("Chrome Browser opened");
	System.out.println("WebSite : " +"http://automationbykrishna.com/");
	driver.get("http://automationbykrishna.com/");
	
	System.out.println("Step: Click on Basic Elements link/menu");
	driver.findElement(By.xpath("//a[@id ='basicelements']")).click();
	Thread.sleep(3000);
	
	System.out.println("Step: Click on alert button");
	driver.findElement(By.xpath("//button[@id = 'javascriptAlert']")).click();
	
	Alert alert = driver.switchTo().alert();
	String text= alert.getText();
	
		
	if (text.equals("You must be TechnoCredits student!!")) {
		System.out.println("pass");
		alert.accept();
	}
	else {
		System.out.println("fail");
		alert.accept();
	}
	
	System.out.println("Test case_5_2 completed successfully");
	Thread.sleep(2000);
	driver.close();
	
	}
	 
	public static void main(String[] a) throws InterruptedException {
		TestCase_2.loiginAutomationbyKrishna();
		
	}
}
/*Naivgate to "http://automationbykrishna.com/#"
Navigate to Basic Elements tab
Navigate to DIFFERENT EXAMPLES OF ALERTS section
Click on Alert button
Validate the alert message and accept the alert.*/
