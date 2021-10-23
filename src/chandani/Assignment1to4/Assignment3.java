/*Assignment - 3: 16th Oct'2021
https://www.globalsqa.com/contact-us/
Verify Contact details.
Fill the form.*/
package chandani.Assignment1to4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment3{
	
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("https://www.globalsqa.com/contact-us/");
		driver.manage().window().maximize();
		
		Thread.sleep(3000);
		System.out.println("STEP - Enter Name");
		driver.findElement(By.xpath("//input[@name = 'comment_name']")).sendKeys("Chandani");
		
		System.out.println("STEP - Enter Email");
		driver.findElement(By.xpath("//input[@name = 'email']")).sendKeys("cheenu123@gmail.com");
		
		System.out.println("STEP - Enter Subject");
		driver.findElement(By.xpath("//input[@name = 'subject']")).sendKeys("Job Application");
		
		System.out.println("STEP - Enter Comments");
		driver.findElement(By.xpath("//textarea[@name = 'comment']")).sendKeys("Selenium code practice");
		
		//System.out.println("STEP - Verify you are not a robot");
		//driver.findElement(By.xpath("//label[@class='rc-anchor-center-item rc-anchor-checkbox-label']")).click();
			
		String expectedString1 = "+91-9910979218";
		String actualString1 = driver.findElement(By.xpath("//div[@id='contact_info-widget-3']//div[@class='icon_phone']")).getText();
				
		if(expectedString1.equals(actualString1))
				System.out.println("Verification of contact phone passed");
				else
					System.out.println("Verification of contact phone failed");
		
		String expectedString2 = "contact@globalsqa.com";
		
		String actualString2 = driver.findElement(By.xpath("//div[@id='contact_info-widget-3']//div[@class='icon_mail']")).getText();
				
		if(expectedString2.equals(actualString2))
				System.out.println("Verification of contact Email ID passed");
				else
					System.out.println("Verification of contact Email ID failed");
		
        String expectedString3 = "146, VP Block, Pitampura, New Delhi-110034";
		
		String actualString3 = driver.findElement(By.xpath("//div[@id='contact_info-widget-3']//div[@class='icon_loc']")).getText();
				
		if(expectedString3.equals(actualString3))
				System.out.println("Verification of contact Location passed");
				else
					System.out.println("Verification of contact Location failed");
	
		System.out.println("Assignment 3 - Test Successful");
		driver.close();
	}
}
