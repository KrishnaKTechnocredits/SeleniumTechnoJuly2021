package shraddha.Assignment3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment3 {
	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "./resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		System.out.println("Step: Launch Browser");
		driver.get("https://www.globalsqa.com/contact-us/");
		driver.manage().window().maximize();
		driver.getTitle();

		System.out.println("Step 1: Enter Name ");
		driver.findElement(By.xpath("//input[@id='comment_name']")).sendKeys("Shraddha");
		System.out.println("Step 2: Enter Email");
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("hello@hotmail.com");
		System.out.println("Step 3: Enter Subject");
		driver.findElement(By.xpath("//input[@id='subject']")).sendKeys("Maths");
		System.out.println("Step 4: Enter Message");
		driver.findElement(By.xpath("//textarea[@id='comment']")).sendKeys("Automation Testing Assignment3");

		// compare phone number
		System.out.println("Step 5: Compare Phone Number ");
		String phonenumber = driver.findElement(By.xpath("//div[@class='header_phone']")).getText();
		String actualphonenumber = "+91-9910979218";
		if (phonenumber.equals(actualphonenumber)) {
			System.out.println("Verification of phone number verified");
		} else
			System.out.println("Phone number verification Failed");

		// compare email address
		System.out.println("Step 6: Compare mail id ");
		String emailId = driver.findElement(By.xpath("//div[@class='header_mail']")).getText();
		String expectedText = "contact@globalsqa.com";
		if (emailId.equals(expectedText)) {
			System.out.println("Verification of Email Address Verified");
		} else
			System.out.println("Email Address verification Failed");
	
		driver.close();
	}
}
