/*Assignment - 3: 16th Oct'2021
https://www.globalsqa.com/contact-us/
Verify Contact details.  (Contact Info section)
Fill the form.  (Fill the Contact Form and dont click on Send)*/

package parthavD;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import base.PredefinedActions;

public class Assignment3 {

	void verifyContactDetails() throws InterruptedException {
		System.out.println("Step 1 - Launch Global SQA URL ");
		WebDriver driver = PredefinedActions.start("https://www.globalsqa.com/contact-us/");
		Thread.sleep(1000);
		System.out.println("Step 2 - Verify Mobile Number in Contact Info ");
		String verifyMobileNo = driver.findElement(By.xpath("//div[contains(@class,'icon_phone')]")).getText();
		if ("+91-9910979218".equals(verifyMobileNo))
			System.out.println("Mobile number matches - Step passed");
		else
			System.out.println("Mobile number doesn't match - Step failed");
		System.out.println("Step 3 - Verify Email address in Contact Info ");
		String verifyEmailID = driver.findElement(By.xpath("//div[contains(@class,'icon_mail')]")).getText();
		if ("contact@globalsqa.com".equals(verifyEmailID))
			System.out.println("Email ID matches - Step passed");
		else
			System.out.println("Email ID doesn't match - Step failed");
		System.out.println("Step 4 - Verify address in Contact Info ");
		String verifyAddress = driver.findElement(By.xpath("//div[contains(@class,'icon_loc')]")).getText();
		if ("146, VP Block, Pitampura, New Delhi-110034".equals(verifyAddress))
			System.out.println("Address matches - Step passed");
		else
			System.out.println("Address doesn't match - Step failed");
		System.out.println("Test Completed successfully");
		driver.close();

	}

	void fillContactInfoForm() throws InterruptedException {
		System.out.println("Step 1 - Launch Global SQA URL ");
		WebDriver driver = PredefinedActions.start("https://www.globalsqa.com/contact-us/");
		Thread.sleep(1000);
		System.out.println("Step 2 - Fill Name in Contact Form");
		driver.findElement(By.xpath("//input[@id='comment_name']")).sendKeys("UserFirstName");
		System.out.println("Step 3 - Fill User Email ID in Contact Form");
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("user@domain.com");
		System.out.println("Step 4 - Fill Subject in Contact Form");
		driver.findElement(By.xpath("//input[@id='subject']")).sendKeys("User Subject");
		System.out.println("Step 5 - Fill Message in Contact Form");
		driver.findElement(By.xpath("//textarea[@id='comment']")).sendKeys("User comments in the message");
		try {
			System.out.println("Step 6 - Click on Captcha checkbox");
			driver.findElement(By.xpath("//span[@id='recaptcha-anchor']")).click();
		} catch (Exception ne) {
			System.out.println("Captcha not automatable");
		}
		System.out.println("Test Completed successfully");
		driver.close();

	}

	public static void main(String[] args) throws InterruptedException {
		new Assignment3().verifyContactDetails();
		new Assignment3().fillContactInfoForm();

	}

}
