package priti_V.Assingment_5;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCase_1 {
	
	static void loiginAutomationbyKrishna(String name, String password) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		System.out.println("Chrome Browser opened");
		//driver.manage().window().maximize();
		
		System.out.println("WebSite : " +"http://automationbykrishna.com/");
		driver.get("http://automationbykrishna.com/");
		
		System.out.println("Step: Click on Registration link/menu");
		driver.findElement(By.xpath("//a[@id='registration2']")).click();
		Thread.sleep(3000);
		
		System.out.println("Step: Enter Username");
		WebElement username = driver.findElement(By.xpath("//input[@id = 'unameSignin']"));
		if (username.isEnabled()) {
		driver.findElement(By.xpath("//input[@id = 'unameSignin']")).clear();
		driver.findElement(By.xpath("//input[@id = 'unameSignin']")).sendKeys(name);
		} else
			System.out.println("Text field is disbaled");
		
		
		System.out.println("Step: Enter Password");
		driver.findElement(By.xpath("//input[@id='pwdSignin']")).sendKeys(password);
		
		System.out.println("Step: Click on the submit button");
		driver.findElement(By.xpath("//button[@id = 'btnsubmitdetails']")).click();
		//Thread.sleep(2000);
		
		System.out.println("Step: Handle the alert message");
		
		Alert alert = driver.switchTo().alert();
		String actualtext=alert.getText();
	
		
		if (password.length()>8 && actualtext.equalsIgnoreCase("Success!")) {
			System.out.println("valid password and registration done");
			alert.accept();
		}
		else if(password.length()<8 && actualtext.equalsIgnoreCase("Failed! please enter strong password")) {
			System.out.println("Invalid password and registration notdone");
			alert.accept();
		}
					
		System.out.println(" Test case_5_1 completed successfully");
		Thread.sleep(1000);
		driver.close();	
	
	}
	
	public static void main(String[] a) throws InterruptedException {
		TestCase_1.loiginAutomationbyKrishna("priti","priti12345");
		TestCase_1.loiginAutomationbyKrishna("Priti Vattanavar","priti");
	}
	
	

}

/*Naivgate to "http://automationbykrishna.com/#"
Test Case 1 -
Naivgate to "http://automationbykrishna.com/#"
Enter the login details
Validate the positive scenario for password (By entering 8 characters)
Validate the success message
Validate the negative scenario for password (Enter less than 8 characters)
Validate the failure message*/

