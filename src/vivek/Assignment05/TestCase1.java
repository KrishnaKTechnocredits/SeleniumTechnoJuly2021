/*Test Case 1 -
Navigate to "http://automationbykrishna.com/#"
Enter the login details
Validate the positive scenario for password (By entering 8 characters)
Validate the success message
Validate the negative scenario for password (Enter less than 8 characters)
Validate the failure message*/

package vivek.Assignment05;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCase1 {

	static WebDriver openBrowser(String url) {
		System.setProperty("webdriver.chrome.driver", "./resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		return driver;
	}

	static void validatePositiveScenarioPassword() throws InterruptedException {
		System.out.println("Step 1: Open the browser");
		WebDriver driver = openBrowser("http://automationbykrishna.com/");
		System.out.println("Step 2: Click on registration");
		driver.findElement(By.linkText("Registration")).click();
		;
		Thread.sleep(3000);
		System.out.println("Step 3: Enter the username");
		driver.findElement(By.id("unameSignin")).sendKeys("vivek@xyz.com");
		System.out.println("Step 4: Enter the password more than 8 characters");
		driver.findElement(By.id("pwdSignin")).sendKeys("vivek@123");
		System.out.println("Step 5: Click on submit");
		driver.findElement(By.id("btnsubmitdetails")).click();
		System.out.println("Step 6: Validate the success message");
		Alert alert = driver.switchTo().alert();
		String ActualText = alert.getText();
		String ExpectedText = "Success!";
		if (ActualText.equals(ExpectedText))
			System.out.println(ActualText + " is the expected text being displayed for pwd more than 8 characters");
		else
			System.out.println(ActualText + " is the not the expected text");
		alert.accept();
	}

	static void validateNegativeScenarioPassword() throws InterruptedException {
		System.out.println("Step 1: Open the browser");
		WebDriver driver = openBrowser("http://automationbykrishna.com/");
		System.out.println("Step 2: Click on registration");
		driver.findElement(By.linkText("Registration")).click();
		Thread.sleep(3000);
		System.out.println("Step 3: Enter the username");
		driver.findElement(By.id("unameSignin")).sendKeys("vivek@xyz.com");
		System.out.println("Step 4: Enter the password more than 8 characters");
		driver.findElement(By.id("pwdSignin")).sendKeys("vivek");
		System.out.println("Step 5: Click on submit");
		driver.findElement(By.id("btnsubmitdetails")).click();
		System.out.println("Step 6: Validate the success message");
		Alert alert = driver.switchTo().alert();
		String ActualText = alert.getText();
		String ExpectedText = "Failed! please enter strong password";
		if (ActualText.equals(ExpectedText))
			System.out.println(ActualText + " is the expected text being displayed for pwd less than 8 characters");
		else
			System.out.println(ActualText + " is the not the expected text");
		alert.accept();
	}

	public static void main(String[] args) throws InterruptedException {
		validatePositiveScenarioPassword();
		validateNegativeScenarioPassword();
	}
}
