package swati.Assignment2_4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment3 {
	
	void verifyContact() {
		System.setProperty("webdriver.chrome.driver", "./resources/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		System.out.println("Enter URL");
		driver.get("https://www.globalsqa.com/contact-us/");
		driver.manage().window().maximize();
		String contact=driver.findElement(By.xpath("//div[@id='contact_info-widget-3']//div[@class='icon_phone']")).getText();
		String email=driver.findElement(By.xpath("//div[@id='contact_info-widget-3']//div[@class='icon_mail']")).getText();
		String address=driver.findElement(By.xpath("//div[@id='contact_info-widget-3']//div[@class='icon_loc']")).getText();
		if(contact.equals("+91-9910979218")) {
			System.out.println("Success");
		}else {
			System.out.println("Mismatch in Contact text");
		}
		if(email.equals("contact@globalsqa.com")) {
			System.out.println("Success");
		}else
		{
			System.out.println("Mismatch in Email text");
		}
		if(address.equals("146, VP Block, Pitampura, New Delhi-110034")) {
			System.out.println("Success");
		}else {
			System.out.println("Mismatch in Address text");
		}
		
		//Contact Form
		System.out.println("Enter name");
		driver.findElement(By.xpath("//input[@id='comment_name']")).sendKeys("Swati");
		System.out.println("Enter email");
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("abc123@gamil.com");
		System.out.println("Enter subject");
		driver.findElement(By.xpath("//input[@name='subject']")).sendKeys("New Subject");
		System.out.println("Enter Comment");
		driver.findElement(By.xpath("//textarea[@name='comment']")).sendKeys("New Comment");
		//driver.findElement(By.xpath("//label[text()=\"I'm not a robot\"]")).click();
		//driver.findElement(By.xpath("//input[@name='submit']")).click();
		driver.close();
	}

	
	
	public static void main(String[] args) {
		Assignment3 a3=new Assignment3();
		a3.verifyContact();
	}
}
