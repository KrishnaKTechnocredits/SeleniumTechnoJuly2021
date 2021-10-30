package swati.Assignment5;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/*
 Test Case 6 - 

Go to "http://automationbykrishna.com/#"
Navigate to Basic Elements tab
Navigate to the Basic Forms section and enter the email address and password 
Click on Submit button
Validate the success alert message.
Accept the alert
 */

public class Test6 {
	void verfiyBasicForms() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./resources/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		System.out.println("Enter URL");
		driver.get("http://automationbykrishna.com/#");
		driver.manage().window().maximize();
		System.out.println("Enter on Basic Element");
		driver.findElement(By.xpath("//a[@id='basicelements']")).click();
		Thread.sleep(3000);
		System.out.println("Enter Email");
		driver.findElement(By.xpath("//input[@id='exampleInputEmail1']")).sendKeys("aab@gamil.com");
		System.out.println("Enter Password");
		driver.findElement(By.xpath("//input[@id='pwd']")).sendKeys("aab");
		System.out.println("Click on Submit button");
		driver.findElement(By.xpath("//button[@id='submitb2']")).click();
		Alert alert=driver.switchTo().alert();
		String message=alert.getText();
		if(message.equals("You successfully clicked on it")) {
			System.out.println("Message validated successfully");
			alert.accept();
		}else
			System.out.println("Message validation Failed");
		driver.close();
		System.out.println("TestCase6 Pass");
		
	}
	
	public static void main(String[] args) throws InterruptedException {
		Test6 t6=new Test6();
		t6.verfiyBasicForms();	
	}
}
