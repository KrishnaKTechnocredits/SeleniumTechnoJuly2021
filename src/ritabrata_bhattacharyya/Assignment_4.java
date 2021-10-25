package ritabrata_bhattacharyya;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment_4 {
	
	void yahooSignUp()  {
		System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
		System.out.println("STEP 1: Launch Browser");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://login.yahoo.com/?.");
		System.out.println("STEP 2: Click on Create Account button");
		driver.findElement(By.xpath("//a[@id = 'createacc']")).click();

		System.out.println("STEP 3: Enter First Name");
		driver.findElement(By.xpath("//input[@name = 'firstName']")).sendKeys("Ritabrata");

		System.out.println("STEP 4: Enter Last Name");
		driver.findElement(By.xpath("//input[@name = 'lastName']")).sendKeys("Bhattacharyya");

		System.out.println("STEP 5: Enter Email");
		driver.findElement(By.xpath("//input[@name = 'yid']")).sendKeys("rito.bhatt");

		System.out.println("STEP 6: Enter Password");
		driver.findElement(By.xpath("//input[@name = 'password']")).sendKeys("Oct@2K21");

		System.out.println("STEP 7: Enter Mobile Number");
		driver.findElement(By.xpath("//input[@name='phone']")).sendKeys("9382550066");

		System.out.println("STEP 8: Enter Birth Month");
		WebElement birthMonthElement = driver.findElement(By.xpath("//select[@name='mm']"));
		Select birthMonth = new Select(birthMonthElement);
		birthMonth.selectByVisibleText("January");

		System.out.println("STEP 9: Enter Birth Date");
		driver.findElement(By.xpath("//input[@name='dd']")).sendKeys("15");

		System.out.println("STEP 10: Enter Birth Year");
		driver.findElement(By.xpath("//input[@name='yyyy']")).sendKeys("1997");

		System.out.println("STEP 11: Enter Gender");
		driver.findElement(By.xpath("//input[@name='freeformGender']")).sendKeys("Male");

		driver.close();
		System.out.println("All test cases passed successfully");
	}

	public static void main(String[] args) throws InterruptedException {
		new Assignment_4().yahooSignUp();
	}

}
