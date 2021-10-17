package monali.Assignment_1to4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GlobalSqaContantUsForm {

	WebDriver launchBrowser() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./resources/chromedriver.exe");
		System.out.println("STEP - Open Chrome Browser");
		WebDriver driver = new ChromeDriver();
		System.out.println("STEP - Enter GlobalSqa url");
		driver.get("https://www.globalsqa.com/contact-us/");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		return driver;
	}

	void verifyContactInfo(WebDriver driver, String mobileNo, String email, String address)
			throws InterruptedException {

		String actualMobileNo = driver
				.findElement(By.xpath("//div[@id='contact_info-widget-3']//div[@class='icon_phone']")).getText();
		if (mobileNo.equals(actualMobileNo))
			System.out.println("Mobile Number match--pass");
		else
			System.out.println("Mobile number does not match--fail");
		String actualEmail = driver.findElement(By.xpath("//div[@id='contact_info-widget-3']/div[@class='icon_mail']"))
				.getText();
		if (email.equals(actualEmail))
			System.out.println("Email match--pass");
		else
			System.out.println("Email address not match--fail");
		String actualAddress = driver.findElement(By.xpath("//div[@id='contact_info-widget-3']/div[@class='icon_loc']"))
				.getText();
		if (address.equals(actualAddress))
			System.out.println("Address match--pass");
		else
			System.out.println("Address does not match--fail");
	}

	void contactUsForm(WebDriver driver) throws InterruptedException {

		// WebDriver driver = launchBrowser();

		System.out.println("STEP - Enter name");
		driver.findElement(By.xpath("//input[@id='comment_name']")).sendKeys("James Bond");
		System.out.println("STEP - Enter Email");
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("james12@gmail.com");
		System.out.println("STEP - Enter Subject");
		driver.findElement(By.xpath("//input[@id='subject']")).sendKeys("Automation script-1");
		System.out.println("STEP - Enter Message");
		driver.findElement(By.xpath("//textarea[@id= 'comment']")).sendKeys("First Automation script test");
		/*
		 * System.out.println("STEP - Checkbox captcha");
		 * driver.findElement(By.xpath("//span[@role= 'checkbox']")).click();
		 */
		System.out.println("Test Pass Successfully");
		driver.close();

	}

	public static void main(String[] args) throws InterruptedException {
		GlobalSqaContantUsForm contactForm = new GlobalSqaContantUsForm();
		WebDriver driver = contactForm.launchBrowser();
		contactForm.verifyContactInfo(driver, "+91-9910979218", "contact@globalsqa.com",
				"146, VP Block, Pitampura, New Delhi-110034");
		contactForm.contactUsForm(driver);

	}
}
