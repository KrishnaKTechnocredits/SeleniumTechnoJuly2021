/*Test Case 4 - 
Go to "http://automationbykrishna.com/#"
Navigate to Basic Elements tab
Navigate to DIFFERENT EXAMPLES OF ALERTS section
Click on Javascript Prompt button
Enter the name in the alert and accept the alert.
Validate the confirmation message displayed below the Javascript Confirmation button.*/

package vivek.Assignment05;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCase4 {

	static WebDriver openBrowser(String url) {
		System.setProperty("webdriver.chrome.driver", "./resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
		return driver;
	}

	static void validateJavaScriptPromptButton() throws InterruptedException {
		System.out.println("Step 1: Open the browser");
		WebDriver driver = openBrowser("http://automationbykrishna.com/");
		System.out.println("Step 2: Click on Basic Elements");
		driver.findElement(By.linkText("Basic Elements")).click();
		Thread.sleep(2000);
		System.out.println("Step 3: Click on JavaScript Confirmation button");
		driver.findElement(By.id("javascriptPromp")).click();
		System.out.println("Step 4: Enter the name in the alert and accept the alert");
		Alert alert = driver.switchTo().alert();
		String name = "Vivek";
		alert.sendKeys(name);
		alert.accept();
		System.out.println(
				"Step 5: Validate the confirmation message displayed below the Javascript Confirmation button");
		String expectedMessage = "Hello " + name + "! How are you today?";
		String actualMessage = driver.findElement(By.id("pgraphdemo")).getText();
		if (actualMessage.equals(expectedMessage))
			System.out.println(actualMessage + " is the expected message to be displayed");
		else
			System.out.println(actualMessage + " is not the expected message");
	}

	public static void main(String[] args) throws InterruptedException {
		validateJavaScriptPromptButton();
	}
}
