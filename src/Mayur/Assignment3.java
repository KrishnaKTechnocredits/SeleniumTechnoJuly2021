package Mayur;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment3 {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "./resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		System.out.println("Step: Open Url");
		driver.get("https://www.globalsqa.com/contact-us/");
		driver.manage().window().maximize();
		driver.getTitle();
		
		//compare method through Str equals
		System.out.println("Step: Compare mail id ");
		WebElement element = driver.findElement(By.xpath("//div[@class='header_mail']"));
		String strText = element.getText();
		String expectedText = "contact@globalsqa.com";
		if (strText.equals(expectedText)) {
			System.out.println("Email id is equal");
		}else
			System.out.println("Email id isnot equals");
		
		//compare method through Str equals
		System.out.println("Step: Compare Phone Number ");
		WebElement phonenumber = driver.findElement(By.xpath("//div[@class='header_phone']"));
		String expectedphonenumber = phonenumber.getText();
		String actualphonenumber = "+91-9910979218";
		if(expectedphonenumber.equals(actualphonenumber)) {
			System.out.println("Phone number is same/equal");
		}else
			System.out.println("Phone number isnot same/equal");
		
		
		System.out.println("Step: Enter Name ");
		driver.findElement(By.xpath("//input[@id='comment_name']")).sendKeys("MaSh");
		System.out.println("Step: Enter Email");
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("abc@Abc");
		System.out.println("Step: Enter Subject");
		driver.findElement(By.xpath("//input[@id='subject']")).sendKeys("ABCDE");
		System.out.println("Step: Enter Message");
		driver.findElement(By.xpath("//textarea[@id='comment']")).sendKeys("At post Pune");
		
	
		

	}

}
