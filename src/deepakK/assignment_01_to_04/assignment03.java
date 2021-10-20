/*Assignment - 3: 16th Oct'2021
https://www.globalsqa.com/contact-us/
Verify Contact details.
Fill the form.
*/
package deepakK.assignment_01_to_04;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import base.PredefinedActions;;

public class assignment03 {
	
	void verifyContactInfo(String phone, String mail, String location) {
		WebDriver driver = new PredefinedActions().start("https://www.globalsqa.com/contact-us/");
		
		String actualPhone1 = driver.findElement(By.xpath("//div[@class= 'icon_phone']")).getText();
		String actualMail1 = driver.findElement(By.xpath("//div[@class= 'icon_mail']")).getText();
		String actualLocation1 = driver.findElement(By.xpath("//div[@class= 'icon_loc']")).getText();
		if(phone.equals(actualPhone1)) {
			System.out.println("The Phone number is correct: "+actualPhone1);
		}else
			System.out.println("Incorrect Phone Number");
		if(mail.equals(actualMail1)) {
			System.out.println("The email address is correct: "+actualMail1);
		}else
			System.out.println("Incorrect email address");
		if(location.equals(actualLocation1)) {
			System.out.println("The locaion is correct: "+actualLocation1);
		}else
			System.out.println("Incorrect Location");
		
		System.out.println("CONTACT INFO verification completed");
		System.out.println("Step 2 :  Enter Name");
		driver.findElement(By.xpath("//input[@id = 'comment_name']")).sendKeys("Deepak Kankhar");
		
		System.out.println("Step 3 :  Enter Email Address");
		driver.findElement(By.xpath("//input[@id = 'email']")).sendKeys("dgk@ymail.com");
		
		System.out.println("Step 4 :  Enter Subject");
		driver.findElement(By.xpath("//input[@id = 'subject']")).sendKeys("Filling the Contact Form");
		
		System.out.println("Step 5 :  Enter Message");
		driver.findElement(By.xpath("//textarea[@id = 'comment']")).sendKeys("Use Masks and Stay Safe");
		
		System.out.println("Step 6 :  Click on Captcha Checkbox");
		//dr.findElement(By.xpath("//span[@id = 'recaptcha-anchor']")).click();;
			
	}
	
	public static void main(String[] args) {
		assignment03 obj = new assignment03();
		obj.verifyContactInfo("+91-9910979218", "contact@globalsqa.com", 
				"146, VP Block, Pitampura, New Delhi-110034");
		
	}

}
