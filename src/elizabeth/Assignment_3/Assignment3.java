/*https://www.globalsqa.com/contact-us/
Verify Contact details.
Fill the form.*/

package elizabeth.Assignment_3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment3 {
	
	String expectedMobileNum="+91-9910979218";
	String expectedEmail="contact@globalsqa.com";
	String expectedLocation="146, VP Block, Pitampura, New Delhi-110034";
	
	void verifyContactDetails(String actualMobileNum,String actualEmail,String actualLocation) {
		
		if(expectedMobileNum.equals(actualMobileNum)) {
			System.out.println("Mobile number is as expected");
		}else {
			System.out.println("Mobile number is not as expected");
		}
			
		if(expectedEmail.equals(actualEmail)) {
			System.out.println("Email address is as expected");
		}else {
			System.out.println("Email address is not as expected");
		}
		if(expectedLocation.equals(actualLocation)) {
			System.out.println("location is as expected");
		}else {
			System.out.println("location is not as expected");
		}
	}
	


	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "./resources/chromedriver.exe");
		System.out.println("Step 1:Launch Browser");
		WebDriver driver=new ChromeDriver();
		System.out.println("Step 2:Open the URL");
		driver.get("https://www.globalsqa.com/contact-us/");
		String actualMobileNum=driver.findElement(By.xpath("//div[@id='contact_info-widget-3']/div[@class='icon_phone']")).getText();
		String actualEmail=driver.findElement(By.xpath("//div[@id='contact_info-widget-3']/div[@class='icon_mail']")).getText();
		String actualLocation=driver.findElement(By.xpath("//div[@id='contact_info-widget-3']/div[@class='icon_loc']")).getText();
		Assignment3 assignment3=new Assignment3();
		System.out.println("Step 3:Verify mobile number,email address and location");
		assignment3.verifyContactDetails(actualMobileNum,actualEmail,actualLocation);
		System.out.println("Step 4:Enter the name");//input[@name='comment_name']
		driver.findElement(By.xpath("//input[@name='comment_name']")).sendKeys("Elizabeth");
		System.out.println("Step 5:Enter the email address");
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("eliza@gmail.com");;
		System.out.println("Step 6:Enter the Subject");
		driver.findElement(By.xpath("//input[@name='subject']")).sendKeys("Testing");
		System.out.println("Step 7:Enter the Message Body");
		driver.findElement(By.xpath("//textarea[@name='comment']")).sendKeys("Automation Testing Demo");
		System.out.println("Step 8:Click on the I'm not a robot checkbox");
		driver.findElement(By.xpath("//iframe[@title='reCAPTCHA']")).click();
		System.out.println("Step 9:Script passed successfully");
		driver.close();
	}
}
