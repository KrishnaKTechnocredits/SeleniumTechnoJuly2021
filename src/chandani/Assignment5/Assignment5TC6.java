/*Test Case 6 - 

Go to "http://automationbykrishna.com/#"
Navigate to Basic Elements tab
Navigate to the Basic Forms scetion and enter the email address and password 
Click on Submit button
Validate the success alert message.
Accept the alert*/
package chandani.Assignment5;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment5TC6 {

	
	void basicFormsSection() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("http://automationbykrishna.com/#");
		
		Thread.sleep(3000);
		driver.manage().window().maximize();
		System.out.println("STEP - Click on Basic Elements Link");
		driver.findElement(By.linkText("Basic Elements")).click();

		Thread.sleep(3000);

		System.out.println("STEP - Enter Email ID");
		driver.findElement(By.xpath("//input[@id=\"exampleInputEmail1\"]")).sendKeys("chandni0604@gmail.com");
		
		System.out.println("STEP - Enter Password");
		driver.findElement(By.xpath("//input[@id=\"pwd\"]")).sendKeys("chandni@123");

		
		System.out.println("STEP - Click on Submit button");
		driver.findElement(By.xpath("//button[@id=\"submitb2\"]")).click();

		Thread.sleep(3000);

		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		
		String expectedMessage = "You successfully clicked on it";
		System.out.println(expectedMessage);
		String actualMessage = alert.getText();
		
		alert.accept();
		
		if(expectedMessage.equals(actualMessage))
				System.out.println("Test Pass of Message on Alert of BASIC FORMS Section after clicking Submit Button");
				else
					System.out.println("Test Failed of Message on Alert of BASIC FORMS Section after clicking Submit button");
		
		driver.close();

	}
	
	public static void main(String[] args) throws InterruptedException {
		Assignment5TC6 assignment5TC6 = new Assignment5TC6();
		assignment5TC6.basicFormsSection();
		System.out.println("Test Case 6 of Assignment 5 is successful");
	}
}
	
