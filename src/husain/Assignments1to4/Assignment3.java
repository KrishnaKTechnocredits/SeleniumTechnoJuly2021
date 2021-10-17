package husain.Assignments1to4;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import husain.base.Prerequisites;

public class Assignment3 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = Prerequisites.start("https://www.globalsqa.com/contact-us/");
		System.out.println("STEP - Open Chrome browser");
		Thread.sleep(3000L);

		System.out.println("STEP - Verify phone number");
		String phoneExpected = "+91-9910979218";
		String phoneActual = driver.findElement(By.xpath("//div[@id='contact_info-widget-3']/div[@class='icon_phone']"))
				.getText();
		if (phoneExpected.equals(phoneActual))
			System.out.println("Phone number matches - Pass");
		else
			System.out.println("Phone number does not match - Fail");

		System.out.println("STEP - Verify email");
		String emailExpected = "contact@globalsqa.com";
		String emailActual = driver.findElement(By.xpath("//div[@id='contact_info-widget-3']/div[@class='icon_mail']"))
				.getText();
		if (emailExpected.equals(emailActual))
			System.out.println("Email matches - Pass");
		else
			System.out.println("Email does not match - Fail");

		System.out.println("STEP - Verify location");
		String locExpected = "146, VP Block, Pitampura, New Delhi-110034";
		String locActual = driver.findElement(By.xpath("//div[@id='contact_info-widget-3']/div[@class='icon_loc']"))
				.getText();
		if (locExpected.equals(locActual))
			System.out.println("Location matches - Pass");
		else
			System.out.println("Lcation does not match - Fail");

		System.out.println("STEP - Enter Name");
		driver.findElement(By.id("comment_name")).sendKeys("Mesut Ozil");

		System.out.println("STEP - Enter Email");
		driver.findElement(By.id("email")).sendKeys("abc.xyz.com");

		System.out.println("STEP - Enter Subject");
		driver.findElement(By.xpath("//input[@name='subject']")).sendKeys("Physics");

		System.out.println("STEP - Enter Additional data");
		driver.findElement(By.xpath("//textarea[@name='comment']")).sendKeys("Additional information added");

		System.out.println("STEP - Click on Re-Captcha checkbox");

		try {
			driver.findElement(By.id("recaptcha-anchor")).click();
		} catch (NoSuchElementException e) {
			System.out.println("Exception - Unable to select captcha checkbox");
		}

	}

}
