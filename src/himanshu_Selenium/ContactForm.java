package himanshu_Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ContactForm {

void contactFormMethod() throws InterruptedException{
		
	    System.setProperty("webdriver.chrome.driver", "./resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
	    
	    System.out.println("STEP 1: Launching Global SQA website");
        driver.get("https://www.globalsqa.com/contact-us/");
        
        driver.manage().window().maximize();
        Thread.sleep(3000);
        
	    System.out.println("STEP 2: Verify Conatct Number");
	    String str1 = "+91-9910979218";
        String str2 = driver.findElement(By.xpath("//div[@id='contact_info-widget-3']//div[@class='icon_phone']")).getText();
	       if(str1.equals(str2))
        	System.out.println("Contact Number- VERIFIED");
           else
        	System.out.println("Contact Number- NOT VERIFIED");
	
        System.out.println("STEP 3: Verify Email");
        String str3 = "contact@globalsqa.com";
        String str4 = driver.findElement(By.xpath("//div[@id='contact_info-widget-3']//div[@class='icon_mail']")).getText();
           if(str3.equals(str4))
		     System.out.println("Email- VERIFIED");
		   else
			System.out.println("Email- NOT VERIFIED");

        System.out.println("STEP 4: Verify Address");
        String str5 = "146, VP Block, Pitampura, New Delhi-110034";
        String str6 = driver.findElement(By.xpath("//div[@id='contact_info-widget-3']//div[@class='icon_loc']")).getText();
          if(str5.equals(str6))
		     System.out.println("Address- VERIFIED");
		  else
   	      	 System.out.println("Address- NOT VERIFIED");
 
        System.out.println("STEP 5: Enter Name");
	    driver.findElement(By.id("comment_name")).sendKeys("Himanshu");
	    
	    System.out.println("STEP 6: Enter Email Id");
	    driver.findElement(By.name("email")).sendKeys("himanshu@123");
	    
	    System.out.println("STEP 7: Enter Subject");
	    driver.findElement(By.name("subject")).sendKeys("Science");
	    
	    System.out.println("STEP 8: Add Some Comment");
	    driver.findElement(By.xpath("//textarea[@id='comment']")).sendKeys("Science is very interesting Subject");
	    //driver.findElement(By.xpath("//div[@class='recaptcha-checkbox-checkmark']")).click();
	    
	    System.out.println("STEP 9: Closing the Browser");
	    driver.close();
	}

	public static void main(String[] args) throws InterruptedException {
		
		ContactForm ass3 = new ContactForm();
		ass3.contactFormMethod();
		
	}
}
