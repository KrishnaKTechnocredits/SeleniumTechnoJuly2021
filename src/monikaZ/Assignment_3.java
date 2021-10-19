/*Assignment - 3: 16th Oct'2021
https://www.globalsqa.com/contact-us/
Verify Contact details.
Fill the form.*/

package monikaZ;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment_3 {

	void getContactDetails() {
		String mobNo="+91-9910979218";
		String emailId="contact@globalsqa.com";
		String address="146, VP Block, Pitampura, New Delhi-110034";
		
		System.setProperty("webdriver.chrome.driver","./resources/chromedriver.exe");
		System.out.println("STEP: Open Chrome Browser");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.globalsqa.com/contact-us/");
		
		System.out.println("STEP-Enter Contact Details");
		String mobNo1=driver.findElement(By.xpath("//div[@class='icon_phone']")).getText();
		String emailID1=driver.findElement(By.xpath("//div[@class='icon_mail']")).getText();
		String address1=driver.findElement(By.xpath("//div[@class='icon_loc']")).getText();
		
		if(mobNo1.equals(mobNo))
			System.out.println("Valid Contact Number ");
		else
			System.out.println("Invalid Contact Number");
		
		if(emailID1.equals(emailId))
			System.out.println("Valid EmilId");
		else
			System.out.println("Invlid EmailId");
		
		if(address1.equals(address))
			System.out.println("Valid Address");
		else
			System.out.println("Invalid Address");
		
		
		System.out.println("STEP-Enter Name");
		driver.findElement(By.xpath("//input[@id='comment_name']")).sendKeys("Selenium");
		
		System.out.println("STEP- Enter EmailId");
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("selenium@sel.com");
		
		System.out.println("STEP- Enter Subject");
		driver.findElement(By.xpath("//input[@id='subject']")).sendKeys("Automation Testing");
		
		System.out.println("STEP- Enter Comment");
		driver.findElement(By.xpath("//textarea[@id='comment']")).sendKeys("Please Share syllabus related to this subject");
		
		driver.close();
		System.out.println("STEP- Test Passed Sucessfully");
	}
	public static void main(String[] args) {
	
		new Assignment_3().getContactDetails();
	}
	
}
