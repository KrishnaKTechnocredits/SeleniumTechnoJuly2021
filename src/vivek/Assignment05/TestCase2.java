/*Test Case 2 - 
Naivgate to "http://automationbykrishna.com/#"
Navigate to Basic Elements tab
Navigate to DIFFERENT EXAMPLES OF ALERTS section
Click on Alert button
Validate the alert message and accept the alert.*/

package vivek.Assignment05;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCase2 {

	static WebDriver openBrowser(String url) {
		System.setProperty("webdriver.chrome.driver", "./resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
		return driver;
	}

	static void validateAlertButton() throws InterruptedException {
		System.out.println("Step 1: Open the browser");
		WebDriver driver = openBrowser("http://automationbykrishna.com/");
		System.out.println("Step 2: Click on Basic Elements");
		driver.findElement(By.linkText("Basic Elements")).click();
		Thread.sleep(2000);
		System.out.println("Step 3: Click on Alert button");
		driver.findElement(By.id("javascriptAlert")).click();
		System.out.println("Step 4: Validate the Alert message");
		Alert alert = driver.switchTo().alert();
		String expectedAlertMessage = "You must be TechnoCredits student!!";
		String actualAlertMessage = alert.getText();
		if (actualAlertMessage.equals(expectedAlertMessage))
			System.out.println(actualAlertMessage + " is the expected message to be displayed");
		else
			System.out.println(actualAlertMessage + " is not the expected message");
		System.out.println("Step 5: Accept the alert");
		alert.accept();
	}

	public static void main(String[] args) throws InterruptedException {
		validateAlertButton();
	}
}
