package manaswi;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/*Test Case 4 - 
Go to "http://automationbykrishna.com/#"
Navigate to Basic Elements tab
Navigate to DIFFERENT EXAMPLES OF ALERTS section
Click on Javascript Prompt button
Enter the name in the alert and accept the alert.
Validate the confirmation message displayed below the Javascript Confirmation button.
*/

public class Assignment_5_4 
{

	void testCase_4() throws InterruptedException 
	{
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

		System.out.println("STEP : Click on Javascript Prompt button");
		driver.findElement(By.xpath("//button[@id='javascriptPromp']")).click();

		Thread.sleep(3000);

		System.out.println("STEP : Check ok message");
		validateMessage(driver, "manaswi");

		Thread.sleep(2000);

		System.out.println("STEP : Click on Javascript Prompt button");
		driver.findElement(By.xpath("//button[@id='javascriptPromp']")).click();

		Thread.sleep(2000);

		System.out.println("STEP : Check cancel message");
		validateCancelMessage(driver);
		
		Thread.sleep(2000);

		System.out.println("Test passed successfully");
		driver.close();
	}

	void validateMessage(WebDriver driver, String name) throws InterruptedException 
	{
		Alert alert = driver.switchTo().alert();
		alert.sendKeys(name);
		alert.accept(); // ok
		String actualText = driver.findElement(By.xpath("//p[contains(text(),'Hello manaswi! How are you today?')]"))
				.getText();
		String expectedText = "Hello " + name + "! How are you today?";
		if (actualText.equals(expectedText))
			System.out.println("valid message");
		else
			System.out.println("invalid message");
	}

	void validateCancelMessage(WebDriver driver) {
		Alert alert = driver.switchTo().alert();
		alert.dismiss(); // cancel
		String actualText = driver.findElement(By.xpath("//p[contains(text(),'User cancelled the prompt.')]"))
				.getText();
		String expectedText = "User cancelled the prompt.";
		if (actualText.equals(expectedText))
			System.out.println("Valid cancel message");
		else
			System.out.println("Invalid cancel message");
	}

	public static void main(String[] args) throws InterruptedException
	{
		new Assignment_5_4().testCase_4();
	}
}
