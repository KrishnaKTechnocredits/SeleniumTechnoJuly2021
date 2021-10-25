/*Selenium Assignment 5 - 17th Oct 

Test Case 1 -

Naivgate to "http://automationbykrishna.com/#"
Enter the login details
Validate the positive scenario for password (By entering 8 characters)
Validate the success message
Validate the negative scenario for password (Enter less than 8 characters)
Validate the failure message*/

package monikaZ.Assignment_5;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCase_1 {

	 WebDriver driver;
	 
	void confirmPassword(WebDriver driver) {
		Alert alert = driver.switchTo().alert();
		String actualText = alert.getText();
		alert.accept(); 
		if (actualText.equals("Success!"))
			System.out.println("Valid Password");
		else
			System.out.println("Invalid Password");
	}
	void loginDeatils() throws InterruptedException{
		System.setProperty("webdriver.chrome.driver", "./resources/chromedriver.exe");
		System.out.println("Step- Open Chrome Browser");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		System.out.println("Step- Enter URL");
		driver.navigate().to("http://automationbykrishna.com/#");
		System.out.println("Step- Click on Registration Link");
		driver.findElement(By.xpath("//a[contains(text(),'Registration')]")).click();
		Thread.sleep(2000);
	
		System.out.println("Step- Enter Username");
		driver.findElement(By.xpath("//input[@id='unameSignin']")).sendKeys("monika");
		
		System.out.println("Step- Enter Password for Negative Scenario");
		driver.findElement(By.xpath("//input[@id = 'pwdSignin']")).sendKeys("223ds");

		System.out.println("Step- Click on Submit Button");
		driver.findElement(By.xpath("//button[@id = 'btnsubmitdetails']")).click();
		Thread.sleep(2000);
		
		System.out.println("Step- Check Password");
		confirmPassword(driver);

		System.out.println("Step- Clear Password");
		driver.findElement(By.xpath("//input[@id = 'pwdSignin']")).clear();

		Thread.sleep(3000);

		System.out.println("Step- Enter Password For Positive Scenario");
		driver.findElement(By.xpath("//input[@id = 'pwdSignin']")).sendKeys("1234margi");

		System.out.println("Step- CLick On Submit Button");
		driver.findElement(By.xpath("//button[@id = 'btnsubmitdetails']")).click();

		Thread.sleep(3000);

		System.out.println("Step- Check password");
		confirmPassword(driver);

		System.out.println("Test passed successfully");

		//driver.close();
		
	}
	
	public static void main(String[] args) throws InterruptedException {
		new TestCase_1().loginDeatils();
	}
}
