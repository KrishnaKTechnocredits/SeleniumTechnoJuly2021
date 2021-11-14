/*Assignment - 2 : 16th Oct'2021

Automate Singup : 
http://automationpractice.com/index.php
*/package Sagar_Assignment2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment2 {
	void automateSignUp() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		System.out.println("STEP - Enter  URL");
		driver.get("http://automationpractice.com/index.php");
		Thread.sleep(3000);
		System.out.println("STEP - Click on Sign In Button");
		driver.findElement(By.xpath("//a[@title='Log in to your customer account']")).click();
		Thread.sleep(3000);
		System.out.println("STEP - Enter Email Address");
		driver.findElement(By.xpath("//input[@name=\"email_create\"]")).sendKeys("anasane.sagar@gmail.com");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@class='btn btn-default button button-medium exclusive']")).click();
		Thread.sleep(5000);
	    System.out.println("STEP - Enter Title (Mr/Mrs)");
		driver.findElement(By.xpath("//input[@id='id_gender2']")).click();
		System.out.println("STEP - Enter First Name");
		driver.findElement(By.xpath("//input[@name='customer_firstname']")).sendKeys("Sagar");
		System.out.println("STEP - Enter Last Name");
		driver.findElement(By.xpath("//input[@name='customer_lastname']")).sendKeys("Anasane");
		System.out.println("STEP - Enter Password");
		driver.findElement(By.xpath("//input[@id='passwd']")).sendKeys("12345");
		System.out.println("STEP - Enter Date of Birth");
		WebElement dateOfBirth=driver.findElement(By.xpath("//select[@id='days']"));
		Select dobSelect=new Select(dateOfBirth);
		dobSelect.selectByVisibleText("20");
		WebElement dateOfBirth1=driver.findElement(By.xpath("//select[@id='months']"));
		Select dobSelect1=new Select(dateOfBirth1);
		dobSelect1.selectByVisibleText("October");
		WebElement dateOfBirth2=driver.findElement(By.xpath("//select[@id='years']"));
		Select dobSelect2=new Select(dateOfBirth2);
		dobSelect2.selectByVisibleText("1994");
		System.out.println("STEP - Enter First Name");
		driver.findElement(By.xpath("//input[@id='firstname']")).sendKeys("Sagar");
		System.out.println("STEP - Enter Last Name");
		driver.findElement(By.xpath("//input[@id='lastname']")).sendKeys("Anasane");
		System.out.println("STEP - Enter Company Name");
		driver.findElement(By.xpath("//input[@id='company']")).sendKeys("TechGig");
		System.out.println("STEP - Enter Address");
		driver.findElement(By.xpath("//input[@id='address1']")).sendKeys("Bavdhan, Pune");
		System.out.println("STEP - Enter Address Line2");
		driver.findElement(By.xpath("//input[@id='address2']")).sendKeys("Bavdhan, Pune");
		System.out.println("STEP - Enter City Name");
		driver.findElement(By.xpath("//input[@id='city']")).sendKeys("Pune");
		//System.out.println("STEP - Enter Address Line2");
		System.out.println("STEP - Select State");
		WebElement dateOfBirth3=driver.findElement(By.xpath("//select[@id='id_state']"));
		Select dobSelect3=new Select(dateOfBirth3);
		dobSelect3.selectByVisibleText("Maharashtra");
		System.out.println("STEP - Zip Code");
		driver.findElement(By.xpath("//input[@id='postcode']")).sendKeys("Bavdhan, Pune");
		System.out.println("STEP - Select Country");
		WebElement dateOfBirth4=driver.findElement(By.xpath("//select[@id='id_country']"));
		Select dobSelect4=new Select(dateOfBirth4);
		dobSelect4.selectByVisibleText("India");
		System.out.println("STEP - Additional Information");
		driver.findElement(By.xpath("//textarea[@id='other']")).sendKeys("Surfing all types og Clothes");
		System.out.println("STEP - Enter Home Phone");
		driver.findElement(By.xpath("//input[@id='phone']")).sendKeys("96478523647");
		System.out.println("STEP - Mobile Phone");
		driver.findElement(By.xpath("//input[@id='phone_mobile']")).sendKeys("798545653215");
		System.out.println("STEP - Enter Another Address");
		driver.findElement(By.xpath("//input[@id='alias']")).sendKeys("Hinjewadi Pune");
		/*System.out.println("STEP - Click Register Button");
		driver.findElement(By.xpath("//button[@id='submitAccount']")).click();*/
		System.out.println("Registration Successful");
	}
	public static void main(String[] args) throws InterruptedException {
		Assignment2 assignment2=new Assignment2();
		assignment2.automateSignUp();
	}
}
