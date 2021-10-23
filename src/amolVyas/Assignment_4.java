package amolVyas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment_4 {
	WebDriver driver;

		
	void signUpForm() {
		System.out.println("STEP- Enter First Name");
		driver.findElement(By.xpath("//input[@id='usernamereg-firstName']")).sendKeys("Test");
		System.out.println("STEP- Enter Last Name");
		driver.findElement(By.xpath("//input[@id='usernamereg-lastName']")).sendKeys("Test");
		System.out.println("STEP- Enter Email ID");
		driver.findElement(By.xpath("//input[@id='usernamereg-yid']")).sendKeys("Test23111");
		System.out.println("STEP- Enter Password");
		driver.findElement(By.xpath("//input[@id='usernamereg-password']")).sendKeys("ADZS@1239767623");
		System.out.println("STEP- Enter Phone Number");
		driver.findElement(By.xpath("//input[@id='usernamereg-phone']")).sendKeys("9191121223");
		System.out.println("STEP- Enter DOB");
		Select month = new Select(driver.findElement(By.xpath("//select[@id='usernamereg-month']")));
		month.selectByVisibleText("February");
		driver.findElement(By.xpath("//input[@id='usernamereg-day']")).sendKeys("14");
		driver.findElement(By.xpath("//input[@id='usernamereg-year']")).sendKeys("2000");
		System.out.println("STEP- Enter Gender");
		driver.findElement(By.xpath("//input[@id='usernamereg-freeformGender']")).sendKeys("Male");
		System.out.println("Successfully entered contact form page details");
		//driver.close();
	}

	public Assignment_4(String url) {
		System.setProperty("webdriver.chrome.driver", "./resources/chromedriver.exe");
		driver = new ChromeDriver();
		System.out.println("STEP- Open Chrome");
		driver.manage().window().maximize();
		System.out.println("STEP-Open given URL");
		driver.get(url);
	}

	public static void main(String[] args) {
		String url = "https://login.yahoo.com/account/create?specId=yidReg";
		Assignment_4 assignment_4=new Assignment_4(url);
		assignment_4.signUpForm();
	}
}
