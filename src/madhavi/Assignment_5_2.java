package madhavi;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Assignment_5_2 {
	// Test Case 2 -
	@Test
	void postiveCase() throws InterruptedException {

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
		System.out.println("STEP3 - Click on  Alert button");
		driver.findElement(By.xpath("//button[@id='javascriptAlert']")).click();
		
		Thread.sleep(3000);

		System.out.println("STEP4 - Verify Alert Message");
		verifyAlertMessage(driver);

		Thread.sleep(3000);

		System.out.println("Test is passed successfully");
		driver.close();
	}

	void verifyAlertMessage(WebDriver driver) {
		Alert alert = driver.switchTo().alert();
		String actualText = alert.getText();
		String expectedText = "You must be TechnoCredits student!!";
		alert.accept();
		Assert.assertEquals(actualText, expectedText, "Alter message should be verified as expected.");
	}

	/*
	 * public static void main(String[] args) throws InterruptedException { new
	 * Assignment_5_2().postiveCase(); }
	 */
}