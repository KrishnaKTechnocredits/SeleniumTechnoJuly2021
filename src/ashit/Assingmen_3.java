package ashit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assingmen_3 {

	void verfiyContactInfoOnUI() {
		System.setProperty("webdriver.chrome.driver", "./resources/chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		System.out.println("STEP :Enter the url");
		driver.get("https://www.globalsqa.com/contact-us/");

		System.out.println("STEP : Verify text :CONTACT INFO");
		String expContactNum = "+91-9910979218";
		String actualContactText =driver.findElement(By.xpath("//div [@id = 'contact_info-widget-3']//div [1]")).getText();
		if (expContactNum.equals(actualContactText))
			System.out.println("Contact Number is verifred and passed");
		else
			System.out.println("Contact Number is verifred and failed");

		String expEmail = "contact@globalsqa.com";
		String actualEmailText =driver.findElement(By.xpath("//div [@id  ='contact_info-widget-3']//div[@class = 'icon_mail']")).getText();
		if (expEmail.equals(actualEmailText))
			System.out.println("Email adress is verifred and passed");
		else
			System.out.println("Email adress is verifred and failed");

		String expaddress = "146, VP Block, Pitampura, New Delhi-110034";
		String actualAddressText = driver.findElement(By.xpath("//div [@id  ='contact_info-widget-3']//div[@class = 'icon_loc']")).getText();
		if (expaddress.equals(actualAddressText))
			System.out.println("Contac Address is verifred and passed");
		else
			System.out.println("Contac Address is verifred and failed");

		System.out.println("STEP-Verify CONTACT FORM");
		System.out.println("STEP-Enter Name,Email ID,Subject, message Captcha");

		driver.findElement(By.xpath("//input [@name='comment_name']")).sendKeys("Priti Vattanavar");
		driver.findElement(By.xpath("//input [@name='email']")).sendKeys("psvattanvar@gmail.com");
		driver.findElement(By.xpath("//input [@name='subject']")).sendKeys("Enquiry");
		driver.findElement(By.xpath("//textarea [@id='comment']")).sendKeys("Regarding current opening");

		System.out.println("Test Case_3_1 excuted successfully");
		driver.close();
	}

	public static void main(String[] a) {
		Assingmen_3 assingmen_3 = new Assingmen_3();
		assingmen_3.verfiyContactInfoOnUI();
	}
}
