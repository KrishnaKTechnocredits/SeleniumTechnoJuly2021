/*Test Case 1 -

Naivgate to "http://automationbykrishna.com/#"
Enter the login details
Validate the positive scenario for password (By entering 8 characters)
Validate the success message
Validate the negative scenario for password (Enter less than 8 characters)
Validate the failure message*/
package chandani.Assignment5;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment5TC1 {
	
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("http://automationbykrishna.com/#");
		
		Thread.sleep(3000);
		driver.manage().window().maximize();
		System.out.println("STEP - Click on Registration Link");
		driver.findElement(By.linkText("Registration")).click();
		
		Thread.sleep(3000);
		System.out.println("STEP - Enter Username");
		driver.findElement(By.xpath("//input[@id=\"unameSignin\"]")).sendKeys("ChandaniF");
		
		System.out.println("STEP - Enter Password");
		driver.findElement(By.xpath("//input[@id=\"pwdSignin\"]")).sendKeys("chandni0604");
		
		System.out.println("STEP - Click on Submit button");
		driver.findElement(By.xpath("//button[@id=\"btnsubmitdetails\"]")).click();

		Thread.sleep(3000);
		
// Validation of Success alert
		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		
		String expectedString1 = "Success!";
		String actualString1 = alert.getText();
				
		if(expectedString1.equals(actualString1))
				System.out.println("Test Pass of Success Alert");
				else
					System.out.println("Test Failed of Success Alert");
		
		alert.accept();

// Validation of failed alert		
		System.out.println("STEP - Enter Updated incorrect Password");
		driver.findElement(By.xpath("//input[@id=\"pwdSignin\"]")).clear();
		driver.findElement(By.xpath("//input[@id=\"pwdSignin\"]")).sendKeys("chandni");
		
		System.out.println("STEP - Click on Submit button again after entering incorrect password");
		driver.findElement(By.xpath("//button[@id=\"btnsubmitdetails\"]")).click();
		
		Thread.sleep(3000);
		
		Alert alert1 = driver.switchTo().alert();
		System.out.println(alert1.getText());
		
		String expectedString2 = "Failed! please enter strong password";
		String actualString2 = alert.getText();
				
		if(expectedString2.equals(actualString2))
				System.out.println("Test Pass of Failed Alert");
				else
					System.out.println("Test Failed of Failed Alert");
		
		alert.accept();
		
		System.out.println("Test Case 1 of Assignment 5 is successful");
		driver.close();
		
	}

}
