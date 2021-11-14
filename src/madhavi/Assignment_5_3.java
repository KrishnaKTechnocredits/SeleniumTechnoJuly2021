package madhavi;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Assignment_5_3 {
	// Test Case 3 -
	@Test
	void useCase1() throws InterruptedException {

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
		System.out.println("STEP3 - Click Javascript Confirmation button");
		driver.findElement(By.xpath("//button[@id='javascriptConfirmBox']")).click();
		Thread.sleep(3000);

		System.out.println("STEP4 - Verify Alert Message");
		verifyAlertAcceptMessage(driver);

		Thread.sleep(3000);

		System.out.println("Test is passed successfully");
		driver.close();
	}

	@Test
	void useCase2() throws InterruptedException {

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
		System.out.println("STEP3 - Click Javascript Confirmation button");
		driver.findElement(By.xpath("//button[@id='javascriptConfirmBox']")).click();
		Thread.sleep(3000);

		System.out.println("STEP4 - Verify Alert Message");
		verifyDismissAcceptMessage(driver);

		Thread.sleep(3000);

		System.out.println("Test is passed successfully");
		driver.close();
	}

	void verifyAlertAcceptMessage(WebDriver driver) {
		Alert alert = driver.switchTo().alert();
		String actualText = alert.getText();
		String expectedText = "Are you are doing your homework regularly, Press Okay else Cancel!!";
		alert.accept();
		Assert.assertEquals(actualText, expectedText, "Alter message should be verified as expected.");
		String actualText1 = driver.findElement(By.xpath("//p[@id='pgraphdemo']")).getText();
		String expectedText1 = "You pressed OK!";
		Assert.assertEquals(actualText1, expectedText1, "Alter Accept is verified");

	}

	void verifyDismissAcceptMessage(WebDriver driver) {
		Alert alert = driver.switchTo().alert();
		String actualText = alert.getText();
		String expectedText = "Are you are doing your homework regularly, Press Okay else Cancel!!";
		alert.dismiss();
		Assert.assertEquals(actualText, expectedText, "Alter message should be verified as expected.");
		String actualText1 = driver.findElement(By.xpath("//p[@id='pgraphdemo']")).getText();
		String expectedText1 = "You pressed Cancel!";
		Assert.assertEquals(actualText1, expectedText1, "Alter Dismiss is verified");

	}
}
