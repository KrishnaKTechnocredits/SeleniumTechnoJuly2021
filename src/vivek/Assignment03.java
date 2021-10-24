/*https://www.globalsqa.com/contact-us/
Verify Contact details.
Fill the form.*/

package vivek;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment03 {

	static WebDriver opeURL(String url) {
		System.setProperty("webdriver.chrome.driver", "./resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
		return driver;
	}

	static void VerifyDetailsAndfillForm() throws InterruptedException {
		System.out.println("STEP - Open the URL in the Chrome Browser");
		WebDriver driver = opeURL("https://www.globalsqa.com/contact-us/");
		System.out.println("STEP - Verify phone number");
		String phoneExpected = "+91-9910979218";
		String phoneActual = driver.findElement(By.xpath("//div[@id='contact_info-widget-3']/div[@class='icon_phone']"))
				.getText();
		if (phoneActual.equals(phoneExpected))
			System.out.println("phone number matches");
		else
			System.out.println("phone number does not match");
		System.out.println("STEP - Verify email id");
		String emailExpected = "contact@globalsqa.com";
		String emailActual = driver.findElement(By.xpath("//div[@id='contact_info-widget-3']/div[@class='icon_mail']"))
				.getText();
		if (emailActual.equals(emailExpected))
			System.out.println("Email id matches");
		else
			System.out.println("Email id does not match");
		System.out.println("STEP - Verify address");
		String addressExpected = "146, VP Block, Pitampura, New Delhi-110034";
		String addressActual = driver.findElement(By.xpath("//div[@id='contact_info-widget-3']/div[@class='icon_loc']"))
				.getText();
		if (addressActual.equals(addressExpected))
			System.out.println("Address matches");
		else
			System.out.println("Address does not match");
		System.out.println("STEP - Enter the name");
		driver.findElement(By.name("comment_name")).sendKeys("Vivek Patil");
		System.out.println("STEP - Enter the email");
		driver.findElement(By.name("email")).sendKeys("vpatil123@gmail.com");
		System.out.println("STEP - Enter the subject");
		driver.findElement(By.name("subject")).sendKeys("Meeting required to discuss requirements");
		System.out.println("STEP - Enter the message");
		driver.findElement(By.name("comment"))
				.sendKeys("Hello scheduling a meeting to get more clarity on the requirements");
		System.out.println("STEP - Click on I am not a robot captcha");
		driver.switchTo().frame(0);
		driver.findElement(By.xpath("//div[@class='recaptcha-checkbox-border']")).click();
		Thread.sleep(3000);
		driver.switchTo().parentFrame();
		System.out.println("STEP - Submit the form");
		try {
			driver.findElement(By.id("submit")).click();
		} catch (ElementClickInterceptedException ec) {
			System.out.println("Cannot click on submit button due to picture captcha");
		}
	}

	public static void main(String[] args) throws InterruptedException {
		Assignment03.VerifyDetailsAndfillForm();
		System.out.println("Test Passed");
	}
}
