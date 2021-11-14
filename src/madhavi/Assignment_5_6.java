package madhavi;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Assignment_5_6 {
	// Test Case 6 -
	@Test
	void useCase() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "./resources/chromedriver.exe");
		System.out.println("STEP1 : Launch browser");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("http://automationbykrishna.com/#");
		System.out.println("STEP2 - Click on  Basic Elements tab");
		driver.findElement(By.linkText("Basic Elements")).click();

		Thread.sleep(3000);

		System.out.println("STEP3 - Enter the email address and password ");
		driver.findElement(By.xpath("//input[@id='exampleInputEmail1']")).sendKeys("test@xyz.com");

		driver.findElement(By.xpath("//input[@id='pwd']")).sendKeys("Test@xyz12");

		System.out.println("STEP4 - Click on Submit ");
		driver.findElement(By.xpath("//button[@id='submitb2']")).click();
		Thread.sleep(2000);

		System.out.println("STEP7 - Verify Alert Ok operation");
		verifyAlertAcceptMessage(driver);

		driver.findElement(By.xpath("//input[@id='exampleInputEmail1']")).clear();

		driver.findElement(By.xpath("//input[@id='pwd']")).clear();

		Thread.sleep(3000);

		System.out.println("Test passed successfully");
		driver.close();

	}

	void verifyAlertAcceptMessage(WebDriver driver) {
		Alert alert = driver.switchTo().alert();
		String actualText = alert.getText();
		alert.accept();
		String expectedText = "You successfully clicked on it";
		Assert.assertEquals(actualText, expectedText, "Alter message should be verified");
	}
}
