/*Assignment - 3: 16th Oct'2021

https://www.globalsqa.com/contact-us/
Verify Contact details.
Fill the form
*/
package Sagar_Assignment3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment3 {
	void verifyContactDetailsAndFillTheForm() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		System.out.println("STEP - Enter  URL");
		driver.get("https://www.globalsqa.com/contact-us/");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		System.out.println("STEP - Verify Contact Details");
		WebElement element =driver.findElement(By.xpath("//div[@id='contact_info-widget-3']//div[@class='icon_phone']"));
		String num=element.getText();
		if(num.equals("+91-9910979218")) {
			System.out.println("Contact Number Matched");
		}else {
			System.out.println("Contact Number Failed");
		}
		System.out.println("STEP - Verify Mail Address");
		WebElement element1 =driver.findElement(By.xpath("//div[@id='contact_info-widget-3']//div[@class='icon_mail']"));
		String mail=element1.getText();
		if(mail.equals("contact@globalsqa.com")) {
			System.out.println("Mail Address Verified");
		}else {
			System.out.println("Mail Address Not Verified");
		}
		System.out.println("STEP - Verify Address");
		WebElement element2 =driver.findElement(By.xpath("//div[@id='contact_info-widget-3']//div[@class='icon_loc']"));
		String address=element2.getText();
		if(address.equals("146, VP Block, Pitampura, New Delhi-110034")) {
			System.out.println("Address Verified");
		}else {
			System.out.println("Address Not Verified");
		}
		
		System.out.println("STEP - Enter Name");
		driver.findElement(By.xpath("//input[@id='comment_name']")).sendKeys("Sagar Anasane");
		
		System.out.println("STEP - Enter Email Address");
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("anasane.sagar@gmail.com");
		
		System.out.println("STEP - Enter Subject");
		driver.findElement(By.xpath("//input[@id='subject']")).sendKeys("Automation");
		
		System.out.println("STEP - Enter Message");
		driver.findElement(By.xpath("//textarea[@id='comment']")).sendKeys("Selenium Automation");
		
		System.out.println("STEP - I am not robot Button");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[@class='recaptcha-checkbox-border']")).click();
		
		/*System.out.println("STEP - Click on Send");
		driver.findElement(By.xpath("//input[@type='submit']"))..click();*/
		driver.close();
		
	}
	public static void main(String[] args) throws InterruptedException {
		Assignment3 assignment3 = new Assignment3();
		assignment3.verifyContactDetailsAndFillTheForm();
	}
}
