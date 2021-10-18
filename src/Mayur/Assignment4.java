package Mayur;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment4 {

	public static void main(String[] args) {
		
	System.setProperty("webdriver.chrome.driver", "./resources/chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	
	System.out.println("Step: Open Url");
	driver.get("https://login.yahoo.com/account/create?specId=yidReg/");
	driver.manage().window().maximize();
	driver.getTitle();
	
	System.out.println("Step: Enter First Name ");
	driver.findElement(By.xpath("//input[@id='usernamereg-firstName']")).sendKeys("MASH");
	System.out.println("Step: Enter Last Name");
	driver.findElement(By.xpath("//input[@id='usernamereg-lastName']")).sendKeys("SHDE");
	System.out.println("Step: Email id");
	driver.findElement(By.xpath("//input[@id='usernamereg-yid']")).sendKeys("MASH123");
	System.out.println("Step:Password ");
	driver.findElement(By.xpath("//input[@id='usernamereg-password']")).sendKeys("MASHTYU1334");
	System.out.println("Step: Mobile Number ");
	driver.findElement(By.xpath("//input[@id='usernamereg-phone']")).sendKeys("9807654321");
	
	System.out.println("Step: Enter Birth Month ");
	WebElement bom = driver.findElement(By.xpath("//select[@id='usernamereg-month']"));
	Select  birthmonth = new Select(bom);
	birthmonth.selectByIndex(5);
	
	System.out.println("Step: Enter Day ");
	driver.findElement(By.xpath("//input[@id='usernamereg-day']")).sendKeys("01");
	System.out.println("Step: Enter Year ");
	driver.findElement(By.xpath("//input[@id='usernamereg-year']")).sendKeys("1990");
	
	driver.findElement(By.xpath("//input[@id='usernamereg-freeformGender']")).sendKeys("Male");
	
	System.out.println("Assignement 4 Done");

	}

}
