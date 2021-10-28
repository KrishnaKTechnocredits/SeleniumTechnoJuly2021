package purshottamJoshi;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.PredefinedActions;

public class Assignment5_TestCase5 {

	void validateAlertDemo() throws InterruptedException {
		
		
		System.out.println("STEP - Click on basic elements");
		WebDriver driver = PredefinedActions.start();
		driver.findElement(By.xpath("//a[@id='basicelements']")).click();
		Thread.sleep(3000);
		System.out.println("STEP - Enter First Name");
		String firstName = "Purshottam";
		driver.findElement(By.xpath("//input[@id='UserFirstName']")).sendKeys(firstName);
		System.out.println("STEP - Enter Last Name");
		String lastName = "Joshi";
		driver.findElement(By.xpath("//input[@id='UserLastName']")).sendKeys(lastName);
		System.out.println("STEP- Enter Company Name");
		String companyName = "Adroit";
		driver.findElement(By.xpath("//input[@id='UserCompanyName']")).sendKeys(companyName);
		System.out.println("STEP - Click on submit button");
		driver.findElement(By.xpath("//button[@onclick='myFunctionPopUp()']")).click();
		System.out.println("STEP - Get alert message");
		String alertMessage = driver.switchTo().alert().getText();
		String expectedAlertMessage = firstName + " and " + lastName + " and " + companyName;
		System.out.println("STEP- Validate alert message");
		if(alertMessage.equals(expectedAlertMessage))
			System.out.println("Alert message matched");
		else
			System.out.println("Alert message did not matched");
		driver.switchTo().alert().accept();
		
		System.out.println("test case 5 pass");
		driver.close();
	}

	public static void main(String[] args) throws InterruptedException {
		new Assignment5_TestCase5().validateAlertDemo();
	}
}
