package suruchi.Assignment5;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.PredefinedActions;

public class Program5 {

	static void validateAlertDemoMessage(String fname, String lname, String company) throws InterruptedException {
		WebDriver driver = PredefinedActions.start();

		Thread.sleep(3000);
		System.out.println("Navigate to Basic Elements tab");
		driver.findElement(By.linkText("Basic Elements")).click();

		System.out.println("Enter the FirstName , LastName & CompanyName in the Alert Demo section");

		Thread.sleep(2000);
		System.out.println("Enter FirstName");
		driver.findElement(By.id("UserFirstName")).sendKeys(fname);

		Thread.sleep(1000);
		System.out.println("Enter LastName");
		driver.findElement(By.id("UserLastName")).sendKeys(lname);

		Thread.sleep(1000);
		System.out.println("Enter CompanyName");
		driver.findElement(By.id("UserCompanyName")).sendKeys(company);

		Thread.sleep(2000);
		System.out.println("Click on Submit button");
		driver.findElement(By.xpath("//button[1][@type='submit']")).click();

		Thread.sleep(2000);
		System.out.println(
				"Validate the alert message (Validate that the firstname, lastname and company name is correctly populated in the alert message)");

		String expectedAlertMessage = fname + " and " + lname + " and " + company;

		Alert alert = driver.switchTo().alert();
		String actualAlertMessage = alert.getText();

		if (actualAlertMessage.equals(expectedAlertMessage)) {
			System.out.println("Correct Alert message");
			System.out.println("Accept the alert");
			alert.accept();
		} else {
			System.out.println("Wrong Alert message");
			alert.accept();
		}

		driver.close();

		System.out.println("Test Case passed");
	}

	public static void main(String[] args) throws InterruptedException {
		Program5.validateAlertDemoMessage("Suruchi", "Joshi", "Company123");
	}
}