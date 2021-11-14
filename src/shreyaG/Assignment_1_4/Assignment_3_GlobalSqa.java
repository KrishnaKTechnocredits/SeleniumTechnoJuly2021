package shreyaG.Assignment_1_4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment_3_GlobalSqa {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./resources/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		System.out.println("launch the browser");
		driver.get("https://www.globalsqa.com/contact-us/");
		
		System.out.println("Verify details");
		String actualText="+91-9910979218";
		String text=driver.findElement(By.xpath("//div[@class='header_contacts']/div[text()='+91-9910979218']")).getText();
		if(text.equals(actualText)) 
			System.out.println("valid");
		
		else 
			System.out.println("Invalid");
	
		
		String exactText="contact@globalsqa.com";
		String text1=driver.findElement(By.xpath("//div[@id='contact_info-widget-3']/div[contains(text(),'contact@globalsqa.com')]")).getText();
		if(text1.equals(exactText)) 
			System.out.println("valid");
		else
			System.out.println("Invalid");
		
		
		String requiredText="146, VP Block, Pitampura, New Delhi-110034";
		WebElement element=driver.findElement(By.xpath("//div[@id='contact_info-widget-3']/div[contains(text(),'146, VP Block, Pitampura, New Delhi-110034')]"));
		String text2=element.getText();
		if(text2.equals(requiredText))
			System.out.println("valid");
		else
			System.out.println("Invalid");
		
		
		System.out.println("Enter the name");
		driver.findElement(By.xpath("//input[@id='comment_name']")).sendKeys("Shreya");
		
		System.out.println("Enter email");
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("shreyagulhane@gmail.com");
		
		System.out.println("Enter subject");
		driver.findElement(By.name("subject")).sendKeys("About assignment submission");
		
		System.out.println("Enter message");
		driver.findElement(By.xpath("//textarea[@id='comment']")).sendKeys("Completed");
		
		
		System.out.println("--------------------");
		
		System.out.println("Script runs successfully");
		
	}

}
