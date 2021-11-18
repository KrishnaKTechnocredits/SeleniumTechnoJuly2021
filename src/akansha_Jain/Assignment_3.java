/* Assignment - 3: 16th Oct'2021

https://www.globalsqa.com/contact-us/
Verify Contact details.
Fill the form. */

package akansha_Jain;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment_3 {

	void matchElementsThenFillForm() throws InterruptedException {
		System.out.println("STEP- Open chrome browser");
		System.setProperty("webdriver.chrome.driver",
				"//Users//punchh_akansha//eclipse-workspace//Java_Techno_Selenium_2021//resources//chromedriver");
		WebDriver driver = new ChromeDriver();

		System.out.println("STEP- Open URL");
		driver.get("https://www.globalsqa.com/contact-us/");
		Thread.sleep(3000);

		System.out.println("STEP- Compare contact info");
		System.out.println("STEP- Compare contact number");
		String number = driver.findElement(By.xpath(".//div[@id='contact_info-widget-3']/div[@class='icon_phone']"))
				.getText();
		if (number.equals("+91-9910979218"))
			System.out.println("Contact number match");
		else
			System.out.println("Contact number not match");

		System.out.println("STEP- Compare email");
		String email = driver.findElement(By.xpath(".//div[@id='contact_info-widget-3']/div[@class='icon_mail']"))
				.getText();
		if (email.equals("contact@globalsqa.com"))
			System.out.println("Email match");
		else
			System.out.println("Email not match");

		System.out.println("STEP- Compare address");
		String address = driver.findElement(By.xpath(".//div[@id='contact_info-widget-3']/div[@class='icon_loc']"))
				.getText();
		if (address.equals("146, VP Block, Pitampura, New Delhi-110034"))
			System.out.println("Address match");
		else
			System.out.println("Address not match");

		System.out.println("STEP- Fill contact form");
		System.out.println("STEP- Enter name");
		driver.findElement(By.xpath("//input[@name='comment_name']")).sendKeys("Akansha Jain");

		System.out.println("STEP- Enter email");
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("goyanka.akku@gmail.com");

		System.out.println("STEP- Enter subject");
		driver.findElement(By.xpath("//input[@name='subject']")).sendKeys("Globant");

		System.out.println("STEP- Enter message");
		driver.findElement(By.xpath("//textarea[@placeholder='Message']"))
				.sendKeys("We are excited to hear about your new ideas, do not hesitate to share them with us.");

		// System.out.println("STEP- Click on captcha");
		// Cannot automate captcha
		// driver.findElement(By.xpath("//label[@class='rc-anchor-center-item
		// rc-anchor-checkbox-label']")).click();

		driver.close();
		driver.quit();
	}

	public static void main(String[] args) throws InterruptedException {
		new Assignment_3().matchElementsThenFillForm();
	}
}