/*
 * Test Case 5 - 

Go to "http://automationbykrishna.com/#"
Navigate to Basic Elements tab
Enter the FirstName , LastName & CompanyName in the Alert Demo section
Click on Submit button
Validate the alert message (Validate that the firstname, lastname and company name is correctly populated in the alert message)
Accept the alert
 */
package chandani.Assignment5;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment5TC5 {
	
	void alertDemoSection() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("http://automationbykrishna.com/#");
		
		Thread.sleep(3000);
		driver.manage().window().maximize();
		System.out.println("STEP - Click on Basic Elements Link");
		driver.findElement(By.linkText("Basic Elements")).click();

		Thread.sleep(3000);

		System.out.println("STEP - Enter First Name");
		driver.findElement(By.xpath("//input[@id=\"UserFirstName\"]")).sendKeys("Chandani");
		
		System.out.println("STEP - Enter Last Name");
		driver.findElement(By.xpath("//input[@id=\"UserLastName\"]")).sendKeys("Fatehchandani");
		
		System.out.println("STEP - Enter Company Name");
		driver.findElement(By.xpath("//input[@id=\"UserCompanyName\"]")).sendKeys("Deloitte");
		
		System.out.println("STEP - Click on Submit button");
		driver.findElement(By.xpath("//button[@onclick=\"myFunctionPopUp()\"]")).click();

		Thread.sleep(3000);

		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		
		String fname = "Chandani";
		String lname = "Fatehchandani";
		String Company = "Deloitte";
		
		String expectedMessage = fname+" and "+lname+" and "+Company;
		System.out.println(expectedMessage);
		String actualMessage = alert.getText();
		
		alert.accept();
		
		if(expectedMessage.equals(actualMessage))
				System.out.println("Test Pass of Message on Alert of Alert Demo Section");
				else
					System.out.println("Test Failed of Message on Alert of Alert Demo Section");
		
		driver.close();

	}
	
	public static void main(String[] args) throws InterruptedException {
		Assignment5TC5 assignment5TC5 = new Assignment5TC5();
		assignment5TC5.alertDemoSection();
		System.out.println("Test Case 5 of Assignment 5 is successful");
	}
}
