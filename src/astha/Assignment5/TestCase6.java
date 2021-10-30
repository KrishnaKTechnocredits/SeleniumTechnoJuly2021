package astha.Assignment5;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TestCase6 {

	static void validateAlertMessage(String emailId, String password) throws InterruptedException {
		System.out.println("Step -1 : Launch chrome browser and navigate to AutomationByKrishna");
		WebDriver driver = base.PredefinedActions.start();
		System.out.println("Step - Passed");
		System.out.println("Step -2 : Navigate to BasicElements tab");
		driver.findElement(By.linkText("Basic Elements")).click();
		Thread.sleep(3000);
		System.out.println("Step - Passed");
		System.out.println("Step - 3 : Enter name in the basic form");
		driver.findElement(By.xpath("//input[@id='exampleInputEmail1']")).sendKeys(emailId);
		System.out.println("Step - Passed");
		System.out.println("Step - 4 : Enter password in the basic form");
		driver.findElement(By.xpath("//input[@id='pwd']")).sendKeys(password);
		System.out.println("Step - 5 : Click on Submit button and verify success message");
		driver.findElement(By.xpath("//div[@name='secondSegment'][2]/section/div/div/button[@type='submit']")).click();
		Alert alert = driver.switchTo().alert();
		String expectedMsg = "You successfully clicked on it";
		String actualMsg = alert.getText();
		alert.accept();
		if (actualMsg.equals(expectedMsg))
			System.out.println("Step - Passed");

		driver.close();
	}

	public static void main(String[] args) throws InterruptedException {
		TestCase6.validateAlertMessage("astha_prakash@test.com", "123456789");
	}
}
