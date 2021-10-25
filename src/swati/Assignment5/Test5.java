package swati.Assignment5;

/*
Test Case 5 - 

Go to "http://automationbykrishna.com/#"
Navigate to Basic Elements tab
Enter the FirstName , LastName & CompanyName in the Alert Demo section
Click on Submit button
Validate the alert message (Validate that the firstname, lastname and company name is correctly populated in the alert message)
Accept the alert

*/

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test5 {
	
	void verifyAlertDemo() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./resources/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		System.out.println("Enter URL");
		driver.get("http://automationbykrishna.com/#");
		driver.manage().window().maximize();
		System.out.println("Enter on Basic Element");
		driver.findElement(By.xpath("//a[@id='basicelements']")).click();
		Thread.sleep(3000);
		System.out.println("Enter First Name");
		driver.findElement(By.xpath("//input[@id='UserFirstName']")).sendKeys("swati");
		System.out.println("Enter Last Name");
		driver.findElement(By.xpath("//input[@id='UserLastName']")).sendKeys("salunke");
		System.out.println("Enter Company Name");
		driver.findElement(By.xpath("//input[@id='UserCompanyName']")).sendKeys("techno");
		System.out.println("Click on Submit button");
		driver.findElement(By.xpath("//button[@onclick='myFunctionPopUp()']")).click();
		Alert alert=driver.switchTo().alert();
		String message=alert.getText();
		if(message.equals("swati and salunke and techno")) {
			System.out.println("Alert message validation Pass");
			alert.accept();
		}else
			System.out.println("Message Validation Failed");
		driver.close();
		System.out.println("TestCase5 Pass");
	}
	
	public static void main(String[] args) throws InterruptedException {
		Test5 t5=new Test5();
		t5.verifyAlertDemo();
		
	}

}
