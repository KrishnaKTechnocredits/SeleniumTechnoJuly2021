package monali.Assignment_1to4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class YahooSignUp {

	void YahooSignupPage() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./resources/chromedriver.exe");
		System.out.println("STEP - Open Chrome Browser");
		WebDriver driver =new ChromeDriver();
		
		System.out.println("STEP - Enter Yahoo url");
		driver.get("https://login.yahoo.com/account/create?specId=yidReg");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		System.out.println("STEP - Enter First name");
		driver.findElement(By.xpath("//input[@id='usernamereg-firstName']")).sendKeys("James");
		System.out.println("STEP - Enter Last name");
		driver.findElement(By.xpath("//input[@id='usernamereg-lastName']")).sendKeys("Bond");
		System.out.println("STEP - Enter Email");
		driver.findElement(By.xpath("//input[@id='usernamereg-yid']")).sendKeys("james12440979");
		System.out.println("STEP - Enter Password");
		driver.findElement(By.xpath("//input[@id='usernamereg-password']")).sendKeys("Test@123");
		System.out.println("STEP - Enter Mobile Number");
		driver.findElement(By.xpath("//input[@id='usernamereg-phone']")).sendKeys("9870553331");
		System.out.println("STEP-Select Birth Month");
		WebElement birthMonth = driver.findElement(By.xpath("//select[@id='usernamereg-month']"));
		Select birthMonthSelect=new Select(birthMonth);
		birthMonthSelect.selectByValue("12");
		System.out.println("STEP-Select birth date");
		driver.findElement(By.xpath("//input[@id='usernamereg-day']")).sendKeys("31");
		System.out.println("STEP-Select birth year");
		driver.findElement(By.xpath("//input[@id='usernamereg-year']")).sendKeys("1989");
		System.out.println("STEP-Select Gender");
		driver.findElement(By.xpath("//input[@id='usernamereg-freeformGender']")).sendKeys("Female");
		System.out.println("Yahoo singup page-Test Pass successfully");	
		driver.close();
	}
	
	public static void main(String[] args) throws InterruptedException {
		YahooSignUp yahooSignup=new YahooSignUp();
		yahooSignup.YahooSignupPage();
		
	}
}
