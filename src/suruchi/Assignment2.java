package suruchi;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment2 {

	void automationSignUp() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		System.out.println("Open Chrome in maximized state");
		driver.manage().window().maximize();

		System.out.println("Navigate to automation practice site");
		driver.get("http://automationpractice.com/index.php");

		System.out.println("Click on Sign In button");
		driver.findElement(By.xpath("//a[contains(text(),'Sign in')]")).click();

		Thread.sleep(3000);
		System.out.println("Enter email id");
		driver.findElement(By.name("email_create")).sendKeys("test@gmail.com");

		Thread.sleep(2000);
		System.out.println("Click on Create Account button");
		driver.findElement(By.xpath("//button[@name='SubmitCreate']")).click();

		Thread.sleep(2000);
		driver.close();

		System.out.println("Test Case passed");
	}

	public static void main(String[] args) throws InterruptedException {
		new Assignment2().automationSignUp();
	}
}