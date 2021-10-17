package umakant;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment2 {

	void contactDetailsMatch(String mobileNumber, String emailAddress, String Address) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.globalsqa.com/");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//li[@id='menu-item-1561']")).click();
		String actualMobileNumber = driver
				.findElement(By.xpath("//div[@id='contact_info-widget-3']//div[@class='icon_phone']")).getText();
		String actualEmailAddress = driver
				.findElement(By.xpath("//div[@id='contact_info-widget-3']//div[@class='icon_mail']")).getText();
		String actualAddress = driver
				.findElement(By.xpath("//div[@id='contact_info-widget-3']//div[@class='icon_loc']")).getText();
		if (mobileNumber.equals(actualMobileNumber))
			System.out.println("Pass: Mobile number matched");
		else
			System.out.println("Fail:Mobile number does not match");
		if (emailAddress.equals(actualEmailAddress))
			System.out.println("Pass: Email Address matched");
		else
			System.out.println("Fail:Email Address does not match");
		if (actualAddress.equals(Address))
			System.out.println("Pass: Address  matched");
		else
			System.out.println("Address  does not match");
		driver.close();
	}

	void fillContactForm() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
		System.out.println("Step1: Launch the browser");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		System.out.println("Step2: Goto GlobalSQA website");
		driver.get("https://www.globalsqa.com/");
		Thread.sleep(3000);
		System.out.println("Step3: Click on contact us");
		driver.findElement(By.xpath("//li[@id='menu-item-1561']")).click();
		System.out.println("Step4:Enter the name");
		driver.findElement(By.xpath("//input[@id='comment_name']")).sendKeys("Umakant");
		System.out.println("Step5:Enter the email address");
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("umakant.sahani123456@gmail.com");
		System.out.println("Step6:Enter the subject");
		driver.findElement(By.xpath("//input[@id='subject']")).sendKeys("Testing subject line");
		System.out.println("Step6:Enter the Message");
		driver.findElement(By.xpath("//textarea[@id='comment']")).sendKeys("Testing Message line");
		// System.out.println("Step7:Click on captcha");
		// driver.findElement(By.xpath("//span[@role='checkbox']")).click();
	}

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Assignment2 globalSQADetails = new Assignment2();
		globalSQADetails.contactDetailsMatch("+91-9910979218", "contact@globalsqa.com",
				"146, VP Block, Pitampura, New Delhi-110034");
		globalSQADetails.fillContactForm();
	}

}
