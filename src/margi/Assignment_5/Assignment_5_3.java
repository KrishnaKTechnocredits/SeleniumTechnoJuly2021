package margi.Assignment_5;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/*Test Case 3 - 
Naivgate to "http://automationbykrishna.com/#"
Navigate to Basic Elements tab
Navigate to DIFFERENT EXAMPLES OF ALERTS section
Click on Javascript Confirmation button
Validate the alert message and accept the alert.
Validate the confirmation message displayed below the Javascript Confirmation button.
Click on Javascript Confirmation button
Dismiss the alert.
Validate the confirmation message displayed below the Javascript Confirmation button.
*/

public class Assignment_5_3 {

	void testCase_3() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","resources/chromedriver.exe");
		System.out.println("STEP : Launch browser");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("http://automationbykrishna.com/#");

		System.out.println("STEP : Click on Basic Elements");
		driver.findElement(By.xpath("//a[contains(text(),'Basic Elements')]")).click();

		Thread.sleep(3000);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)");

		System.out.println("STEP : Click on Javascript Confirmation button");
		driver.findElement(By.xpath("//button[@id='javascriptConfirmBox']")).click();

		Thread.sleep(3000);

		System.out.println("STEP : Check ok message");
		validateOkMessage(driver);

		Thread.sleep(3000);

		System.out.println("STEP : Click on Javascript Confirmation button");
		driver.findElement(By.xpath("//button[@id='javascriptConfirmBox']")).click();

		Thread.sleep(1000);

		System.out.println("STEP : Check cancel message");
		validateCancelMessage(driver);

		Thread.sleep(1000);

		System.out.println("Test passed successfully");
		driver.close();
	}

	void validateOkMessage(WebDriver driver) {
		Alert alert = driver.switchTo().alert();
		alert.accept(); // ok
		String actualText = driver.findElement(By.xpath("//p[contains(text(),'You pressed OK!')]")).getText();
		String expectedText = "You pressed OK!";
		if (actualText.equals(expectedText))
			System.out.println("Valid ok message");
		else
			System.out.println("Invalid ok message");
	}

	void validateCancelMessage(WebDriver driver) {
		Alert alert = driver.switchTo().alert();
		alert.dismiss(); // cancel
		String actualText = driver.findElement(By.xpath("//p[contains(text(),'You pressed Cancel!')]")).getText();
		String expectedText = "You pressed Cancel!";
		if (actualText.equals(expectedText))
			System.out.println("Valid cancel message");
		else
			System.out.println("Invalid cancel message");
	}

	public static void main(String[] args) throws InterruptedException {
		new Assignment_5_3().testCase_3();
	}
}
