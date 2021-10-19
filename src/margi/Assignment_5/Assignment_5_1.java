package margi.Assignment_5;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/*Test Case 1 -
Naivgate to "http://automationbykrishna.com/#"
Enter the login details
Validate the positive scenario for password (By entering 8 characters)
Validate the success message
Validate the negative scenario for password (Enter less than 8 characters)
Validate the failure message*/

public class Assignment_5_1 {

	void testCase_1() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","resources/chromedriver.exe");
		System.out.println("STEP : Launch browser");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("http://automationbykrishna.com/#");

		System.out.println("STEP : Click on Registration");
		driver.findElement(By.xpath("//a[contains(text(),'Registration')]")).click();

		Thread.sleep(4000);

		System.out.println("STEP : Enter username");
		driver.findElement(By.xpath("//input[@id = 'unameSignin']")).sendKeys("margi");

		System.out.println("STEP : Enter password - negative schenario");
		driver.findElement(By.xpath("//input[@id = 'pwdSignin']")).sendKeys("abc1");

		System.out.println("STEP : CLick on submit button");
		driver.findElement(By.xpath("//button[@id = 'btnsubmitdetails']")).click();

		Thread.sleep(3000);

		System.out.println("STEP : Check password");
		checkPassword(driver);

		System.out.println("STEP : Clear password");
		driver.findElement(By.xpath("//input[@id = 'pwdSignin']")).clear();

		Thread.sleep(3000);

		System.out.println("STEP : Enter password - positive schenario");
		driver.findElement(By.xpath("//input[@id = 'pwdSignin']")).sendKeys("1234margi");

		System.out.println("STEP : CLick on submit button");
		driver.findElement(By.xpath("//button[@id = 'btnsubmitdetails']")).click();

		Thread.sleep(3000);

		System.out.println("STEP : Check password");
		checkPassword(driver);

		System.out.println("Test passed successfully");

		driver.close();
	}

	void checkPassword(WebDriver driver) {
		Alert alert = driver.switchTo().alert();
		String actualText = alert.getText();
		alert.accept(); // ok
		if (actualText.equals("Success!"))
			System.out.println("Password is ok");
		else
			System.out.println("Password is NOT ok");
	}

	public static void main(String[] args) throws InterruptedException {
		new Assignment_5_1().testCase_1();
	}
}
