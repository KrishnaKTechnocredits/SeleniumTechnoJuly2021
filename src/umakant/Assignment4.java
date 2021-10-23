package umakant;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment4 {

	static WebDriver getBrowser() {
		System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		return driver;
	}

	void yahooSignUp() throws InterruptedException {
		WebDriver driver = getBrowser();
		System.out.println("Step-1: Enter the Url");
		driver.get("https://login.yahoo.com/account/create?specId=yidReg");
		Thread.sleep(3000);
		System.out.println("Step-2: Enter the first name");
		driver.findElement(By.xpath("//input[@id='usernamereg-firstName']")).sendKeys("Umakant");
		System.out.println("Step-3: Enter the last name");
		driver.findElement(By.xpath("//input[@id='usernamereg-lastName']")).sendKeys("Sahani");
		System.out.println("Step-4: Enter the email address");
		driver.findElement(By.xpath("//input[@id='usernamereg-yid']")).sendKeys("umakant.sahani");
		System.out.println("Step-5: Enter the password");
		driver.findElement(By.xpath("//input[@id='usernamereg-password']")).sendKeys("Qwerty@2021");
		System.out.println("Step-6: Enter the mobile number");
		driver.findElement(By.xpath("//input[@id='usernamereg-phone']")).sendKeys("1234567890");
		System.out.println("Step-7: Select the birth monthr");
		WebElement selectBirthMonthElement = driver.findElement(By.xpath("//select[@id='usernamereg-month']"));
		Select selectBirthMonth = new Select(selectBirthMonthElement);
		selectBirthMonth.selectByVisibleText("February");
		System.out.println("Step-8: Enter the Day of birth");
		driver.findElement(By.xpath("//input[@id='usernamereg-day']")).sendKeys("04");
		System.out.println("Step-9: Enter the Year of birth");
		driver.findElement(By.xpath("//input[@id='usernamereg-year']")).sendKeys("1995");
		System.out.println("Step-10: Enter the Gender");
		driver.findElement(By.xpath("//input[@id='usernamereg-year']")).sendKeys("Male");
	}

	public static void main(String[] args) throws InterruptedException {
		new Assignment4().yahooSignUp();
	}

}
