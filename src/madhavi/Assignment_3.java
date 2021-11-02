package madhavi;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import base.PredefinedActions;

/*https://www.globalsqa.com/contact-us/
Verify Contact details.
Fill the form.*/

public class Assignment_3 {

	void verifyContactInfo() throws InterruptedException {
		System.out.println("Step 1 - Open globalsqa URL ");
		WebDriver driver = PredefinedActions.start("https://www.globalsqa.com/contact-us/");
		Thread.sleep(1000);

		System.out.println("Verify CONTACT INFO");

		System.out.println("Step 2 - Verify Mobile Number");
		String verifyMobileNumber = driver.findElement(By.xpath("//div[@class='icon_phone']")).getText();
		String cellNumber = "+91-9910979218";
		if (cellNumber.equals(verifyMobileNumber))
			System.out.println("MobileNo is verified successfully-Step is Passed");
		else
			System.out.println("MobileNo is not matched - Step is failed");

		System.out.println("Step 3 - Verify Email address");
		String verifyEmailID = driver.findElement(By.xpath("//div[@class='icon_mail']")).getText();
		String mail = "contact@globalsqa.com";
		if (mail.equals(verifyEmailID))
			System.out.println("Email ID matches - Step is passed");
		else
			System.out.println("Email ID doesn't match - Step is failed");

		System.out.println("Step 4 - Verify Location address");
		String verifyAddress = driver.findElement(By.xpath("//div[@class='icon_loc']")).getText();
		String location = "146, VP Block, Pitampura, New Delhi-110034";
		if (location.equals(verifyAddress))
			System.out.println("Address matches - Step is passed");
		else
			System.out.println("Address doesn't match - Step is failed");

		System.out.println("Test Completed successfully");
		driver.close();

	}

	
	void globalsqaSignUp() throws InterruptedException {
		System.out.println("Step 1 - Open globalsqa URL ");
		WebDriver driver = PredefinedActions.start("https://www.globalsqa.com/contact-us/");
		Thread.sleep(1000);

		System.out.println("Step 2 - Fill Name in Contact Form");
		driver.findElement(By.xpath("//input[@id='comment_name']")).sendKeys("Uname");

		System.out.println("Step 3 - Fill Email ID");
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("test@123.com");

		System.out.println("Step 4 - Fill Subject");
		driver.findElement(By.xpath("//input[@id='subject']")).sendKeys("Contact Subject");

		System.out.println("Step 5 - Fill Message box");
		driver.findElement(By.xpath("//textarea[@id='comment']")).sendKeys("Comment pl");

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,250)", "");
		Thread.sleep(5000);

		System.out.println("Step 6 - Click on Captcha checkbox");
		try {
			driver.findElement(By.xpath("//span[@id='recaptcha-anchor']")).click();
		} catch (Exception ne) {
			System.out.println("Captcha is not automate");
		}

		System.out.println("Step 7 - Locate Send button");
		driver.findElement(By.xpath("//input[@name=\"submit\"]"));

		System.out.println("Test completed successfully");
		driver.close();

	}

	public static void main(String[] args) throws InterruptedException {
		new Assignment_3().globalsqaSignUp();
		new Assignment_3().verifyContactInfo();

	}
}