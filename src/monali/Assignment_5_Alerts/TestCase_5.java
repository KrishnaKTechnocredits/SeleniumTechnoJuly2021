package monali.Assignment_5_Alerts;
/*Test Case 5 - 
Go to "http://automationbykrishna.com/#"
Navigate to Basic Elements tab
Enter the FirstName , LastName & CompanyName in the Alert Demo section
Click on Submit button
Validate the alert message (Validate that the firstname, lastname and company name is correctly populated in the alert message)
Accept the alert*/

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import dattaraj_W.base.PredefinedActions;

public class TestCase_5 {

	void AlertDemoValidation(String firstName, String lastName, String companyName) throws InterruptedException {
		System.out.println("Step 1: Launch Automation By Krishna Site");
		WebDriver driver = PredefinedActions.start();
		System.out.println("Step 2: Click on Basic Elements tab");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@id='basicelements']")).click();
		Thread.sleep(3000);
		System.out.println("Step 3 : Enter First name");
		driver.findElement(By.xpath("//input[@id='UserFirstName']")).sendKeys(firstName);
		System.out.println("Step 4 : Enter Last name");
		driver.findElement(By.xpath("//input[@id='UserLastName']")).sendKeys(lastName);
		System.out.println("Step 5 : Enter Company name");
		driver.findElement(By.xpath("//input[@id='UserCompanyName']")).sendKeys(companyName);
		System.out.println("Step 6: click on submit button");
		driver.findElement(By.xpath("//button[@onclick='myFunctionPopUp()']")).click();
		System.out.println("Step 7: Switch to alert window");
		Alert alert = driver.switchTo().alert();
		System.out.println("Step 8 : Get the text of alert");
		String actualMessage = alert.getText();
		String expectedMessage = "" + firstName + " and " + lastName + " and " + companyName + "";
		System.out.println("Step 8: Click on Ok Button");
		alert.accept();
		System.out.println("Step 10: Alert message validation");
		if (actualMessage.equals(expectedMessage))
			System.out.println("Test Pass");
		else
			System.out.println("Test Fail");
		driver.close();
	}

	public static void main(String[] args) throws InterruptedException {
		new TestCase_5().AlertDemoValidation("Monali", "Bendale", "Capgemini");
	}
}
