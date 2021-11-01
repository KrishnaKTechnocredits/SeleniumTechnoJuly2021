package manaswi;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/*Test Case 2 - 
Naivgate to "http://automationbykrishna.com/#"
Navigate to Basic Elements tab
Navigate to DIFFERENT EXAMPLES OF ALERTS section
Click on Alert button
Validate the alert message and accept the alert.
*/

public class Assignment_5_2 
{

	void testCase_2() throws InterruptedException
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

		System.out.println("STEP : CLick on Alert Button in different examples of alerts section");
		driver.findElement(By.xpath("//button[@id='javascriptAlert']")).click();

		Thread.sleep(3000);

		System.out.println("STEP : Check text");
		validateText(driver);

		System.out.println("Test passed successfully");
		driver.close();
	}

	void validateText(WebDriver driver) 
	{
		Alert alert = driver.switchTo().alert();
		String text = alert.getText();
		alert.accept(); // ok
		if (text.contains("TechnoCredits student!!"))
			System.out.println("valid text");
		else
			System.out.println("invalid text");
	}

	public static void main(String[] args) throws InterruptedException 
	{
		new Assignment_5_2().testCase_2();
	}
}
