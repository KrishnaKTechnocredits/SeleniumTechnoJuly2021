package amolVyas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment_3 {
	WebDriver driver;

	void verifyContactUs() {
		String expectedContact = "+91-9910979218";
		String expectedEmailID = "contact@globalsqa.com";
		String expectedAddress = "146, VP Block, Pitampura, New Delhi-110034";
		System.out.println("STEP - Reterving values from UI");
		String contact = driver.findElement(By.xpath("//div[@class='icon_phone']")).getText();
		String emailID = driver.findElement(By.xpath("//div[@class='icon_mail']")).getText();
		String address = driver.findElement(By.xpath("//div[@class='icon_loc']")).getText();

		if (contact.equals(expectedContact))
			System.out.println("Contact Matched");
		else
			System.out.println("Contact Not Matched");

		if (emailID.equals(expectedEmailID))
			System.out.println("Email ID Matched");
		else
			System.out.println("Email ID Not Matched");

		if (address.equals(expectedAddress))
			System.out.println("Address Matched");
		else
			System.out.println("Address Not Matched");

		System.out.println("Verify Contact us Test Passed");
	}
	
	void enterContactForm() {
		System.out.println("STEP- Enter Name");
		driver.findElement(By.xpath("//input[@id='comment_name']")).sendKeys("Test");
		System.out.println("STEP- Enter Email ID");
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("Test@test.com");
		System.out.println("STEP- Enter Subject");
		driver.findElement(By.xpath("//input[@id='subject']")).sendKeys("Application for SDET");
		System.out.println("STEP- Enter Comment");
		driver.findElement(By.xpath("//textarea[@id='comment']")).sendKeys("Need more information SDET Position");
		System.out.println("Successfully entered contact form page details");
		driver.close();
	}

	public Assignment_3(String url) {
		System.setProperty("webdriver.chrome.driver", "./resources/chromedriver.exe");
		driver = new ChromeDriver();
		System.out.println("STEP- Open Chrome");
		driver.manage().window().maximize();
		System.out.println("STEP-Open given URL");
		driver.get(url);
	}

	public static void main(String[] args) {
		String url = "https://www.globalsqa.com/contact-us/";
		Assignment_3 assignment_3=new Assignment_3(url);
		assignment_3.verifyContactUs();
		assignment_3.enterContactForm();
	}
}
