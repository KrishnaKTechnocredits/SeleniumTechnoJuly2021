package madhavi;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Assignment_5_4 {
	// Test Case 4 -
	@Test
	void positiveuseCase() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "./resources/chromedriver.exe");
		System.out.println("STEP1 : Launch browser");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("http://automationbykrishna.com/#");
		System.out.println("STEP2 - Click on  Basic Elements tab");
		driver.findElement(By.linkText("Basic Elements")).click();

		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)");

		// Positive Case
		System.out.println("STEP3 - Click Javascript Prompt button");
		driver.findElement(By.xpath("//button[@id='javascriptPromp']")).click();
		Thread.sleep(3000);

		System.out.println("STEP4 - Verify Alert Ok operation");
		verifyAlertAcceptMessage(driver, "India");

		System.out.println("STEP5 : Click on Javascript Prompt button");
		driver.findElement(By.xpath("//button[@id='javascriptPromp']")).click();

		Thread.sleep(2000);
		// Negative Case
		System.out.println("STEP6 : Verify Alert Cancel operation");
		verifyAlertDismissMessage(driver);

		Thread.sleep(3000);

		System.out.println("Test passed successfully");
		driver.close();

	}

	void verifyAlertAcceptMessage(WebDriver driver, String name) {
		Alert alert = driver.switchTo().alert();
		alert.sendKeys(name);
		alert.accept();
		String actualText = driver.findElement(By.xpath("//p[@id='pgraphdemo']")).getText();
		String expectedText = "Hello " + name + "! How are you today?";
		Assert.assertEquals(actualText, expectedText, "Alter message Ok is verified.");

	}

	void verifyAlertDismissMessage(WebDriver driver) {
		Alert alert = driver.switchTo().alert();
		alert.dismiss();
		String actualText = driver.findElement(By.xpath("//p[@id='pgraphdemo']")).getText();
		String expectedText = "User cancelled the prompt.";
		Assert.assertEquals(actualText, expectedText, "Alter Dismiss message is verified.");

	}
}
