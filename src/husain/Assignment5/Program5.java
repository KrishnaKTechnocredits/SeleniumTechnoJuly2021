/*
 * Test Case 5 - 

Go to "http://automationbykrishna.com/#"
Navigate to Basic Elements tab
Enter the FirstName , LastName & CompanyName in the Alert Demo section
Click on Submit button
Validate the alert message (Validate that the firstname, lastname and company name is correctly populated in the alert message)
Accept the alert

 */
package husain.Assignment5;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.PredefinedActions;

public class Program5 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = PredefinedActions.start();
		Thread.sleep(3000L);
		System.out.println("STEP - Open Chrome Browser");

		System.out.println("STEP - Click on BasicElements link");
		driver.findElement(By.xpath("//a[@id='basicelements']")).click();
		Thread.sleep(3000L);

		System.out.println("STEP - Enter first name");
		String fName = "Thorgan";
		driver.findElement(By.xpath("//input[@name='ufname']")).sendKeys(fName);

		System.out.println("STEP - Enter last name");
		String lName = "Hazard";
		driver.findElement(By.id("UserLastName")).sendKeys(lName);

		System.out.println("STEP - Enter company name");
		String cmpName = "Dortmund";
		driver.findElement(By.xpath("//input[@name='cmpname']")).sendKeys(cmpName);

		System.out.println("STEP - Click on Submit button");
		driver.findElement(By.xpath("//div[@class='panel-body']/div/button[@type='submit']")).click();

		System.out.println("STEP - Switch to Alert");
		Alert alert = driver.switchTo().alert();
		String expectedText = fName + " and " + lName + " and " + cmpName;
		String actualText = alert.getText();
		alert.accept();

		System.out.println("STEP - Validate message displayed on Alert popup");
		if (expectedText.equals(actualText))
			System.out.println("Message is valid");
		else
			System.out.println("Message is incorrect");
	}

}
