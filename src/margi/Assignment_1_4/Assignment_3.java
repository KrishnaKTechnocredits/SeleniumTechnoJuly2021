package margi.Assignment_1_4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment_3 {

	void globalSQA() {
		System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
		System.out.println("STEP : Launch Chrome Browser");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.globalsqa.com/contact-us/");

		// contact info
		System.out.println("STEP : Verify Contact Number");
		WebElement contactElement = driver.findElement(By.xpath("//div[@id = 'contact_info-widget-3']/div[@class = 'icon_phone']"));
		String contact_text = contactElement.getText();
		if (contact_text.equals("+91-9910979218"))
			System.out.println("Valid Contact Number");
		else
			System.out.println("Invalid Contact number");

		System.out.println("STEP : Verify Mail");
		WebElement mailElement = driver
				.findElement(By.xpath("//div[@id = 'contact_info-widget-3']/div[@class = 'icon_mail']"));
		String mail_text = mailElement.getText();
		if (mail_text.equals("contact@globalsqa.com"))
			System.out.println("Valid Mail");
		else
			System.out.println("Invalid Mail");

		System.out.println("STEP : Verify Address");
		WebElement addressElement = driver
				.findElement(By.xpath("//div[@id = 'contact_info-widget-3']/div[@class = 'icon_loc']"));
		String address_text = addressElement.getText();
		if (address_text.equals("146, VP Block, Pitampura, New Delhi-110034"))
			System.out.println("Valid Address");
		else
			System.out.println("Invalid Address");

		// contact form
		System.out.println("STEP : Enter Name");
		driver.findElement(By.xpath("//input[@name = 'comment_name']")).sendKeys("margi");

		System.out.println("STEP : Enter Email");
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("margi.santoki@gmail.com");

		System.out.println("STEP : Enter Subject");
		driver.findElement(By.xpath("//input[@name='subject']")).sendKeys("Automation");

		System.out.println("STEP : Enter Message");
		driver.findElement(By.xpath("//textarea[@name='comment']")).sendKeys("Automation Practice");

		driver.close();
		System.out.println("Test passed successfully");
	}

	public static void main(String[] args) {
		new Assignment_3().globalSQA();
	}
}
