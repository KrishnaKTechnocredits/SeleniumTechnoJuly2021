/*
 Go to "http://automationbykrishna.com/#"
Navigate to Basic Elements tab
Enter the FirstName , LastName & CompanyName in the Alert Demo section
Click on Submit button
Validate the alert message (Validate that the firstname, lastname and company name is correctly populated in the alert message)
Accept the alert
 */
package umakant.alertAndConfirmation;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.PredefinedActions;

public class TestCase5 {

	void verifyAlertDemoSection(String firstName, String lastName, String company) throws InterruptedException {
		String expectedMessage = firstName + " and " + lastName + " and " + company;
		System.out.println("Step1: Launch the automationbykrishna in chrome");
		WebDriver driver = PredefinedActions.start();
		Thread.sleep(3000);
		System.out.println("Step2: Navigate to Basic Elements tab");
		driver.findElement(By.xpath("//a[@id='basicelements']")).click();
		Thread.sleep(3000);
		System.out.println("Step3:Enetr the first name");
		driver.findElement(By.xpath("//input[@id='UserFirstName']")).sendKeys(firstName);
		System.out.println("Step4:Enetr the first name");
		driver.findElement(By.xpath("//input[@id='UserLastName']")).sendKeys(lastName);
		System.out.println("Step5:Enetr the first name");
		driver.findElement(By.xpath("//input[@id='UserCompanyName']")).sendKeys(company);
		System.out.println("Step6:Click on Submit");
		driver.findElement(By.xpath("//button[text()='Submit']")).click();
		System.out.println("Step7: Switch to alert window");
		Alert alert = driver.switchTo().alert();
		System.out.println("Step8: Get the message in alert window");
		String actualMessage = alert.getText();
		System.out.println("Step9: Click on OK in alert window");
		alert.accept();
		System.out.println("Step10:Compare the expected and actual message");
		if (actualMessage.equals(expectedMessage))
			System.out.println("Test Pass");
		else
			System.out.println("Test Fail");
		driver.close();
	}
	
	public static void main(String[] args) throws InterruptedException {
		new TestCase5().verifyAlertDemoSection("Umakant", "Sahani", "TCS");
	}

}
