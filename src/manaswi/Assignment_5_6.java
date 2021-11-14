package manaswi;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/*Test Case 6 - 
Go to "http://automationbykrishna.com/#"
Navigate to Basic Elements tab
Navigate to the Basic Forms scetion and enter the email address and password 
Click on Submit button
Validate the success alert message.
Accept the alert
*/

public class Assignment_5_6 
{

	String email, password;

	Assignment_5_6(String email, String password) 
	{
		this.email = email;
		this.password = password;
	}

	void testCase_6() throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver","resources/chromedriver.exe");
		System.out.println("STEP : Launch browser");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("http://automationbykrishna.com/#");

		System.out.println("STEP : Click on Basic Elements");
		driver.findElement(By.xpath("//a[contains(text(),'Basic Elements')]")).click();

		Thread.sleep(3000);

		System.out.println("STEP : Enter email");
		driver.findElement(By.xpath("//input[@id='exampleInputEmail1']")).sendKeys(email);

		System.out.println("STEP : Enter password");
		driver.findElement(By.xpath("//input[@id='pwd']")).sendKeys(password);

		System.out.println("STEP : Click on Submit button");
		driver.findElement(By.xpath("//button[@id='submitb2']")).click();

		Thread.sleep(3000);

		validateText(driver);

		System.out.println("Test passed successfully");
		driver.close();
	}

	void validateText(WebDriver driver) 
	{
		Alert alert = driver.switchTo().alert();
		String actualText = alert.getText();
		alert.accept(); // ok
		String expectedText = "You successfully clicked on it";
		if (actualText.contains(expectedText))
			System.out.println("valid text");
		else
			System.out.println("invalid text");
	}

	public static void main(String[] args) throws InterruptedException
	{
		new Assignment_5_6("manaswi@gmail.com", "Manaswi10").testCase_6();
	}
}
