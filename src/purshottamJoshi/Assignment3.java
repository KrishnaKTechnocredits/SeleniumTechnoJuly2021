package purshottamJoshi;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



public class Assignment3 {

	WebDriver driver;
	
	public Assignment3(String url) {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		System.out.println("STEP- Open Chrome Browser");
		driver.manage().window().maximize();
		System.out.println("STEP-Open given URL");
		driver.get(url);
	}
	

	void contactUs() {
		String expectedContact = "+91-9910979218";
		String expectedEmailID = "contact@globalsqa.com";
		String expectedAddress = "146, VP Block, Pitampura, New Delhi-110034";
		System.out.println("STEP - Reterving values from UI");
		String contact = driver.findElement(By.xpath("//div[@class='icon_phone']")).getText();
		String emailID = driver.findElement(By.xpath("//div[@class='icon_mail']")).getText();
		String address = driver.findElement(By.xpath("//div[@class='icon_loc']")).getText();

		if (contact.equals(expectedContact))
			System.out.println("Contact number matched");
		else
			System.out.println("Contact not matched");

		if (emailID.equals(expectedEmailID))
			System.out.println("Email id matched");
		else
			System.out.println("Emial not matching");

		if (address.equals(expectedAddress))
			System.out.println("Address matched");
		else
			System.out.println("Address not matching");

		System.out.println("Test Pass");
	}
	
	void automateContactForm() {
		System.out.println("STEP- Enter Name");
		driver.findElement(By.xpath("//input[@id='comment_name']")).sendKeys("Purushottam Joshi");
		System.out.println("STEP- Enter Email ID");
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("purushottam@gmail.com");
		System.out.println("STEP- Enter Subject");
		driver.findElement(By.xpath("//input[@id='subject']")).sendKeys("hello");
		System.out.println("STEP- Enter Comment");
		driver.findElement(By.xpath("//textarea[@id='comment']")).sendKeys("tesing ");
		System.out.println("Successfully entered contact form page details");
		driver.close();
	}



	public static void main(String[] args) {
		Assignment3 assignment3=new Assignment3("https://www.globalsqa.com/contact-us/");
		assignment3.contactUs();
		assignment3.automateContactForm();
	}
}
