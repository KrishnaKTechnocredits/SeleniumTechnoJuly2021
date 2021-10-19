package amolVyas.Assignment_5;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class TestCase_5 {

	void verifyAlertDemoSection(String firstName, String lastName, String company) throws InterruptedException {
		String output = firstName + " and " + lastName + " and " + company;
		WebDriver driver = Action.start();
		System.out.println("STEP-Navigate to Basic Element Page");
		driver.findElement(By.xpath("//a[text()='Basic Elements']")).click();
		Thread.sleep(3000);
		System.out.println("STEP-Enter First Name");
		driver.findElement(By.xpath("//input[@id='UserFirstName']")).sendKeys(firstName);
		System.out.println("STEP-Enter Last Name");
		driver.findElement(By.xpath("//input[@id='UserLastName']")).sendKeys(lastName);
		System.out.println("STEP-Enter Company Name");
		driver.findElement(By.xpath("//input[@id='UserCompanyName']")).sendKeys(company);
		System.out.println("STEP-Click on Submit button");
		driver.findElement(By.xpath("//div[@name='secondSegment'][1]/section/div/div/button[@type='submit']")).click();
		Alert alert = driver.switchTo().alert();
		String acutal = alert.getText();
		alert.accept();
		if (acutal.equalsIgnoreCase(output))
			System.out.println("First Name, Last Name and Company data Matched");
		else
			System.out.println("First Name, Last Name and Company data not Matched");
		driver.close();
		System.out.println("STEP-Test Case PASSED");
	}

	public static void main(String[] args) throws InterruptedException {
		new TestCase_5().verifyAlertDemoSection("Amol", "Vyas", "DXC");
	}
}