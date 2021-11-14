package astha.Assignment5;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TestCase5 {

	static void validateAlertMessage(String firstName, String lastName, String companyName) throws InterruptedException {
		System.out.println("Step -1 : Launch chrome browser and navigate to AutomationByKrishna");
		WebDriver driver = base.PredefinedActions.start();
		System.out.println("Step - Passed");
		System.out.println("Step -2 : Navigate to BasicElements tab");
		driver.findElement(By.linkText("Basic Elements")).click();
		Thread.sleep(3000);
		System.out.println("Step - Passed");
		System.out.println("Step -3 Enter first name in alert demo section");
		driver.findElement(By.name("ufname")).sendKeys(firstName);
		System.out.println("Step - Passed");
		System.out.println("Step -4 Enter second name in the alert demo section");
		driver.findElement(By.name("ulname")).sendKeys(lastName);
		System.out.println("Step - Passed");
		System.out.println("Step -4 Enter company name in the alert demo section");
		driver.findElement(By.name("cmpname")).sendKeys(companyName);
		System.out.println("Step - Passed");
		System.out.println("Step -5 Click on submit button");
		driver.findElement(By.xpath("//div[@name='secondSegment'][1]/section/div/div/button[@type='submit']")).click();
		System.out.println("Step - Passed");
		Alert alert = driver.switchTo().alert();
		System.out.println("Step -5 Validate the alert message");
		String expectedMsg = firstName + " and "+ lastName +" and " + companyName;
		String actualMsg = alert.getText();
		if (expectedMsg.equals(actualMsg))
			System.out.println("Step - Passed");
		else
			System.out.println("Step - Failed");
		alert.accept();
		driver.quit();
	}
	
	public static void main(String[] args) throws InterruptedException {
		TestCase5.validateAlertMessage("Astha", "Prakash", "Deloitte");
	}
}
