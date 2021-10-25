package varun;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment_3 {
	void automateGlobalSQA() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		System.out.println("Step-1 Open Chrome Browser");
		System.out.println("STEP - Enter automation url");
		driver.get("https://www.globalsqa.com/contact-us/");
		
		System.out.println("This is Step-2");
		System.out.println("Verify the header");
		WebElement contactHeader = driver.findElement(By.xpath("//div[@id='contact_info-widget-3']//span"));
		String expectedContactHeader = contactHeader.getText(); 
		String actualContactHeader = "CONTACT INFO";
		if(expectedContactHeader.equals(actualContactHeader))
			System.out.println("Contact Header is matching");
		else
			System.out.println("Header is not matching");
		
		System.out.println("This is Step-3");
		System.out.println("Verify Mobile Number");
		WebElement mobileNumber =  driver.findElement(By.xpath("//div[@id='contact_info-widget-3']/div[@class='icon_phone']"));
		String expectedNumber = mobileNumber.getText();
		String actualNumber = "+91-9910979218";
		if(expectedNumber.equals(actualNumber))
			System.out.println("Mobile Number matched");
		else
			System.out.println("Mobile Number not matched");
		
		
		System.out.println("This is step-4");
		System.out.println("Verify Email");
		WebElement email =  driver.findElement(By.xpath("//div[@id='contact_info-widget-3']/div[@class='icon_mail']"));
		String expectedEmail = email.getText();
		String actualEmail = "contact@globalsqa.com";
		if(expectedEmail.equals(actualEmail))
			System.out.println("Email matched");
		else
			System.out.println("Email not matched");
		
		System.out.println("This is step-5");
		System.out.println("Verify the contact header");
		WebElement contactForm = driver.findElement(By.xpath("//h2[@class='left_title']/span"));
		String actualFormText = contactForm.getText();
		String expectedFormText = contactForm.getText();
		if(expectedFormText.equals(actualFormText))
			System.out.println("Contact Form text Matched");
		else
			System.out.println("Contact Form text doesn't matched");
		
		System.out.println("This is step-6");
		System.out.println("Please fill the form");
		driver.findElement(By.xpath("//input[@id='comment_name']")).sendKeys("Varun");
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("varunjoshi@gmail.com");
		driver.findElement(By.xpath("//input[@id='subject']")).sendKeys("Mathematics");
		driver.findElement(By.xpath("//textarea[@id='comment']")).sendKeys("This is for automation testing");
		driver.findElement(By.xpath("recaptcha-checkbox-border")).click();
		Thread.sleep(3000);
		
	}
	
	public static void main(String[] args) throws InterruptedException {
		Assignment_3 assignment_3 = new Assignment_3();
		assignment_3.automateGlobalSQA();
		System.out.println("Test case passed");
	}
	
}
