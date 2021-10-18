package margi.Assignment_1_4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment_4 {

	void yahooSignIn() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
		System.out.println("STEP : Launch Chrome Browser");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://login.yahoo.com/?.");
		System.out.println("STEP : Click on Create Account");
		driver.findElement(By.xpath("//a[@id = 'createacc']")).click();

		System.out.println("STEP : Enter First Name");
		driver.findElement(By.xpath("//input[@name = 'firstName']")).sendKeys("margi");

		System.out.println("STEP : Enter Last Name");
		driver.findElement(By.xpath("//input[@name = 'lastName']")).sendKeys("santoki");

		System.out.println("STEP : Enter Email");
		driver.findElement(By.xpath("//input[@name = 'yid']")).sendKeys("margi.santoki");

		System.out.println("STEP : Enter Password");
		driver.findElement(By.xpath("//input[@name = 'password']")).sendKeys("Pwd??123");

		System.out.println("STEP : Enter Mobile Number");
		driver.findElement(By.xpath("//input[@name='phone']")).sendKeys("9876543210");

		System.out.println("STEP : Enter Birth Month");
		WebElement birthMonthElement = driver.findElement(By.xpath("//select[@name='mm']"));
		Select birthMonth = new Select(birthMonthElement);
		birthMonth.selectByVisibleText("February");

		System.out.println("STEP : Enter Birth Date");
		driver.findElement(By.xpath("//input[@name='dd']")).sendKeys("23");

		System.out.println("STEP : Enter Birth Year");
		driver.findElement(By.xpath("//input[@name='yyyy']")).sendKeys("1997");

		System.out.println("STEP : Enter Gender");
		driver.findElement(By.xpath("//input[@name='freeformGender']")).sendKeys("Female");

		driver.close();
		System.out.println("Test passed successfully");
	}

	public static void main(String[] args) throws InterruptedException {
		new Assignment_4().yahooSignIn();
	}
}
