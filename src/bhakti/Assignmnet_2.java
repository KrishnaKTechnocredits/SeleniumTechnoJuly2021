/*Assignment - 2 : 16th Oct'2021
Automate Singup : 
http://automationpractice.com/index.php
*/
package bhakti;

import java.sql.Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Assignmnet_2 {
	
	static int x=0;
	 
	public static void main(String[] args) throws InterruptedException {
		String email= x+"@dispostable.com";
		x++;
		System.setProperty("webdriver.chrome.driver", "./resources/chromedriver.exe");
		System.out.println("1. Open Browser");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		System.out.println("2. Enter URL");
		driver.get("http://automationpractice.com/index.php");
		System.out.println("3. CLick on Sing in");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//a[@title='Log in to your customer account']")).click();
		Thread.sleep(5000);
		System.out.println("4. Enter Valid email id ");
		driver.findElement(By.xpath("//input[@name='email_create']")).sendKeys(email);
		System.out.println("5. Click on Create anaccount");
		driver.findElement(By.xpath("//button[@id='SubmitCreate']")).click();
		Thread.sleep(5000);
		System.out.println("6. Select Title");
		driver.findElement(By.xpath("//input[@id='id_gender2']")).click();

		System.out.println("7. Frist name");
		driver.findElement(By.xpath("//input[@id='customer_firstname']")).sendKeys("Bhakti");
		System.out.println("8. Last name");
		driver.findElement(By.xpath("//input[@id='customer_lastname']")).sendKeys("Kakade");
		System.out.println("9. Email");
		driver.findElement(By.xpath("//input[@id='email']")).clear();
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("x@dispostable.com");
		System.out.println("10. Password");
		driver.findElement(By.xpath("//input[@id='passwd']")).sendKeys("Password@12");
		System.out.println("11. select DOB: day");
		Select days= new Select (driver.findElement(By.xpath("//select[@id='days']")));
		days.selectByVisibleText("1");
		System.out.println("11. select DOB: month");
		Select month= new Select (driver.findElement(By.xpath("//select[@id='months']")));
		days.selectByValue("1");
		System.out.println("11. select DOB: year");
		Select year= new Select (driver.findElement(By.xpath("//select[@id='years']")));
		days.selectByValue("1987");
		System.out.println("STEP-Enter Company");
		driver.findElement(By.xpath("//input[@id='company']")).sendKeys("DXC Company");
		System.out.println("STEP-Enter Address");
		driver.findElement(By.xpath("//input[@id='address1']")).sendKeys("123 Sudma nagar");
		System.out.println("STEP-Enter City");
		driver.findElement(By.xpath("//input[@id='city']")).sendKeys("Indore");
		System.out.println("STEP-Enter State");
		Select state = new Select(driver.findElement(By.xpath("//select[@id='id_state']")));
		state.selectByVisibleText("Colorado");
		System.out.println("STEP-Enter Zip Code");
		driver.findElement(By.xpath("//input[@id='postcode']")).sendKeys("34512");
		System.out.println("STEP-Enter Country");
		Select country = new Select(driver.findElement(By.xpath("//select[@id='id_country']")));
		country.selectByVisibleText("United States");
		System.out.println("STEP-Enter Mobile Number");
		driver.findElement(By.xpath("//input[@id='phone_mobile']")).sendKeys("1234567890");
		System.out.println("STEP-Enter Future Refernce Code");
		driver.findElement(By.xpath("//input[@id='alias']")).clear();
		driver.findElement(By.xpath("//input[@id='alias']")).sendKeys("My Address");
		System.out.println("STEP-Click on Register button");
		driver.findElement(By.xpath("//button[@id='submitAccount']")).click();
		System.out.println("Test Passed");
		
		driver.quit();
	}
	 

}
