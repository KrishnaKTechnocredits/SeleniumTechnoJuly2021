package gauravK.Assignment_3;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;

/*
 * Assignment - 3: 16th Oct'2021
https://www.globalsqa.com/contact-us/
Verify Contact details.
Fill the form.
-------------------------------------------------------------
 */
public class GlobalSQATestingContactUsPage {
	WebDriver driver;
	
	public GlobalSQATestingContactUsPage(String url) {
		System.setProperty("webdriver.chrome.driver", "./resources/chromedriver.exe");
		driver = new ChromeDriver();
		System.out.println("STEP - Open Chrome browser.");
		driver.manage().window().maximize();
		System.out.println("STEP - loading URL "+url);
		try{
			driver.get(url);
		}catch (WebDriverException e) {
			System.out.println("Error in webpage address...");
		}finally {
			System.out.println("Contact us page loading test completed.");
		}
	}

	void verifyContactUsInfo(String contactNum, String email, String address) {
		System.out.println("STEP - Retrieving values from webpage.");
		String contactNumber = driver.findElement(By.xpath("//div[@id='contact_info-widget-3']/div[@class='icon_phone']")).getText();
		String contactEmail = driver.findElement(By.xpath("//div[@id='contact_info-widget-3']/div[@class='icon_mail']")).getText();
		String contactAddress = driver.findElement(By.xpath("//div[@id='contact_info-widget-3']/div[@class='icon_loc']")).getText();
		System.out.println("STEP - vefication process start.");
		if(contactNum.equals(contactNumber))
			System.out.println("Contact number "+contactNum+" is matched.");
		else
			System.out.println("Contact number "+contactNum+" is DONOT match with webpage contents.");
		if(email.equals(contactEmail))
			System.out.println("Contact email "+email+" is matched.");
		else
			System.out.println("Contact email "+email+" is DONOT match with webpage contents.");
		if(address.equals(contactAddress))
			System.out.println("Contact address "+address+" is matched.");
		else
			System.out.println("Contact address "+address+" is DONOT match with webpage contents.");
		System.out.println("STEP - vefication process ended.");
	}
	
	void fillContactUsForm() {
		System.out.println("STEP - Enter name.");
		driver.findElement(By.xpath("//input[@name='comment_name']")).sendKeys("Gaurav");
		System.out.println("STEP - Enter email.");
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("gaurav@gmail.com");
		System.out.println("STEP - Enter subject.");
		driver.findElement(By.xpath("//input[@name='subject']")).sendKeys("Service query");
		System.out.println("STEP - Enter message.");
		driver.findElement(By.xpath("//textarea[@name='comment']")).sendKeys("Please provide introductory details of all services you offer.");
		System.out.println("STEP - completing recaptcha.");
		try {
		driver.findElement(By.xpath("//iframe[@src='https://www.google.com/recaptcha/api2/aframe']")).click();
		} catch (ElementNotInteractableException b) {
			System.out.println("Recaptcha not completed.");
		}
		System.out.println("STEP - Click send button.");
		driver.findElement(By.xpath("//input[@name='submit']")).click();
		System.out.println("Form submission test complete.");
	}
	
	public static void main(String[] args) {
		String url = "https://www.globalsqa.com/contact-us/";
		GlobalSQATestingContactUsPage test = new GlobalSQATestingContactUsPage(url);
		test.verifyContactUsInfo("+91-9910979218","contact@globalsqa.com","146, VP Block, Pitampura, New Delhi-110034");
		test.fillContactUsForm();
	}
}
