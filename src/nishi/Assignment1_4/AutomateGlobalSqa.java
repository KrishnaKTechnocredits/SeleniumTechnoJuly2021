/*Assignment - 3: 16th Oct'2021

https://www.globalsqa.com/contact-us/
Verify Contact details.
Fill the form.*/

package nishi.Assignment1_4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutomateGlobalSqa {
	public static void main(String[] args) {
		AutomateGlobalSqa globalSqa=new AutomateGlobalSqa();
		globalSqa.verifyContactDetails("+91-9910979218", "contact@globalsqa.com",
				"146, VP Block, Pitampura, New Delhi-110034");
		globalSqa.fillForm();
		
	}

	 void fillForm() {
		 	System.setProperty("webdriver.chrome.driver", "./resources/chromedriver.exe");
			System.out.println("STEP - Open Chrome Browser");
			WebDriver driver = new ChromeDriver();
			System.out.println("STEP - Enter url");
			driver.get("https://www.globalsqa.com/contact-us/");
			System.out.println("STEP 1 : Enter name ");
			driver.findElement(By.xpath("//input[@name='comment_name']")).sendKeys("Nishi");
			System.out.println("STEP 2 : Enter email ");
			driver.findElement(By.xpath("//input[@name='email']")).sendKeys("nishi1234@gmail.com");
			System.out.println("STEP 3 : Enter Subject ");
			driver.findElement(By.xpath("//input[@name='subject']")).sendKeys("Science");
			System.out.println("STEP 4 : Enter Message ");
			driver.findElement(By.xpath("//textarea[@name='comment']")).sendKeys("all details entered");
			
		
	}

	void verifyContactDetails(String mobNo,String gmail,String address) {
		System.setProperty("webdriver.chrome.driver", "./resources/chromedriver.exe");
		System.out.println("STEP - Open Chrome Browser");
		WebDriver driver = new ChromeDriver();
		System.out.println("STEP - Enter url");
		driver.get("https://www.globalsqa.com/contact-us/");
		System.out.println("verifying mobile-no");
		String actualMoNo=driver.findElement(By.xpath("//div[@class='icon_phone']")).getText();
		String actualEmail=driver.findElement(By.xpath("//div[@class='icon_mail']")).getText();
		String actualAddress=driver.findElement(By.xpath("//div[@class='icon_loc']")).getText();
		if(actualMoNo.equals(mobNo))
			System.out.println("Mobile no verified");
		if(actualEmail.equals(gmail))
			System.out.println("gmail verified");
		if(actualAddress.equals(address))
			System.out.println("address verified");		
		
	}
}
