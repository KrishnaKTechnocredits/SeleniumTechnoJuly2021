package varun.varun_Assignment_5;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.PredefinedActions;

public class Assignment_5_FillAlertDemoData {
	WebDriver driver = PredefinedActions.start("http://automationbykrishna.com/");

	void fillAlertDemoForm(String firstName, String lastName, String company) throws InterruptedException {
		String output = firstName + " and " + lastName + " and " + company;
		driver.findElement(By.xpath("//a[@id='basicelements']")).click();
		Thread.sleep(3000);
		System.out.println("Please enter FirstName");
		driver.findElement(By.xpath("//input[@name='ufname']")).sendKeys(firstName);
		driver.findElement(By.id("UserLastName")).sendKeys(lastName);
		driver.findElement(By.id("UserCompanyName")).sendKeys(company);
		driver.findElement(By.xpath("//div[@name='secondSegment'][1]/section/div/div/button[@type='submit']")).click();
		Alert alert = driver.switchTo().alert();
		String actual = alert.getText();
		alert.accept();
		if (actual.equalsIgnoreCase(output))
			System.out.println("Data matched :- Test Case Passed");
		else
			System.out.println("Data not matched :- Test Case failed");
		System.out.println("STEP-Test Case PASSED");
	}
	public static void main(String[] args) throws InterruptedException {
		Assignment_5_FillAlertDemoData assignment_5_FillAlertDemoData = new Assignment_5_FillAlertDemoData();
		assignment_5_FillAlertDemoData.fillAlertDemoForm("Varun", "Joshi", "Cybage");
	}
}
