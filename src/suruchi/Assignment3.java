package suruchi;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment3 {
	WebDriver driver;

	void matchContactInfoDetails() {
		System.setProperty("webdriver.chrome.driver", "./resources/chromedriver.exe");
		driver = new ChromeDriver();

		System.out.println("Open Chrome in maximized state");
		driver.manage().window().maximize();
		System.out.println("Navigate to Global SQA site");
		driver.get("https://www.globalsqa.com/contact-us/");

		System.out.println("Verify contact info");
		System.out.println("Verify phone number");
		String expectedPhoneText = "+91-9910979218";
		String actualPhoneText = driver
				.findElement(By.xpath("//div[@id='contact_info-widget-3']/div[@class='icon_phone']")).getText();

		if (expectedPhoneText.equals(actualPhoneText))
			System.out.println("Phone number matched");
		else
			System.out.println("Phone number not matching");

		System.out.println("Verify email id");
		String expectedEmailId = "contact@globalsqa.com";
		String actualEmailId = driver
				.findElement(By.xpath("//div[@id='contact_info-widget-3']/div[@class='icon_mail']")).getText();

		if (expectedEmailId.equals(actualEmailId))
			System.out.println("Email id matched");
		else
			System.out.println("Email id not matching");

		System.out.println("Verify address");
		String expectedAddress = "146, VP Block, Pitampura, New Delhi-110034";
		String actualAddress = driver.findElement(By.xpath("//div[@id='contact_info-widget-3']/div[@class='icon_loc']"))
				.getText();

		if (expectedAddress.equals(actualAddress))
			System.out.println("Address matched");
		else
			System.out.println("Address not matching");
	}

	void fillContactForm() {
		System.out.println("Fill Name field");
		driver.findElement(By.xpath("//input[@name='comment_name']")).sendKeys("Test Name");

		System.out.println("Fill Email field");
		driver.findElement(By.name("email")).sendKeys("test@gmail.com");

		System.out.println("Fill Subject field");
		driver.findElement(By.name("subject")).sendKeys("Test Subject");

		System.out.println("Fill Message field");
		driver.findElement(By.name("comment")).sendKeys("Test Message");

		/*
		 * System.out.println("Check Captcha checkbox");
		 * driver.findElement(By.className("recaptcha-checkbox-border")).click();
		 */

		driver.close();

		System.out.println("Test Case passed");
	}

	public static void main(String[] args) {
		Assignment3 assignment3 = new Assignment3();
		assignment3.matchContactInfoDetails();
		assignment3.fillContactForm();
	}
}