/*Test Case 6 - 
Go to "http://automationbykrishna.com/#"
Navigate to Basic Elements tab
Navigate to the Basic Forms section and enter the email address and password 
Click on Submit button
Validate the success alert message.
Accept the alert*/

package vivek.Assignment05;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCase6 {

	static WebDriver openBrowser(String url) {
		System.setProperty("webdriver.chrome.driver", "./resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
		return driver;
	}

	static void validateBasicFormsSection() throws InterruptedException {
		System.out.println("Step 1: Open the browser");
		WebDriver driver = openBrowser("http://automationbykrishna.com/");
		System.out.println("Step 2: Click on Basic Elements");
		driver.findElement(By.linkText("Basic Elements")).click();
		Thread.sleep(2000);
		System.out.println("Step 3: Enter the email address and password in the Basic Forms section ");
		String emailAddress = "Vivekp@xyz.com";
		String password = "Patil";
		driver.findElement(By.id("exampleInputEmail1")).sendKeys(emailAddress);
		driver.findElement(By.id("pwd")).sendKeys(password);
		System.out.println("Step 4: Click on Submit button");
		driver.findElement(By.xpath("//*[@class = 'col-lg-6'][2]//button")).click();
		System.out.println("Step 5: Validate the alert message");
		Alert alert = driver.switchTo().alert();
		String expectedMessage = "You successfully clicked on it";
		String actualMessage = alert.getText();
		if (actualMessage.equals(expectedMessage))
			System.out.println(actualMessage + " is the expected message to be displayed");
		else
			System.out.println(actualMessage + " is not the expected message");
		System.out.println("Step 5: Accept the alert");
		alert.accept();
	}

	public static void main(String[] args) throws InterruptedException {
		validateBasicFormsSection();
	}
}
