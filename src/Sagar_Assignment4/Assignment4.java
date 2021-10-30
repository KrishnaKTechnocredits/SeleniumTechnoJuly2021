/*Assignment - 4: 16th Oct'2021

Yahoo Signup.
https://login.yahoo.com/account/create?specId=yidReg
*/
package Sagar_Assignment4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment4 {
	
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		System.out.println("STEP - Enter Yahoo URL");
		driver.get("https://login.yahoo.com/account/create?specId=yidReg");
		System.out.println("STEP - Enter First Name");
		driver.findElement(By.xpath("//input[@id='usernamereg-firstName']")).sendKeys("Sagar");
		System.out.println("STEP - Enter Last Name");
		driver.findElement(By.xpath("//input[@id='usernamereg-lastName']")).sendKeys("Anasane");
		System.out.println("STEP - Enter Email Address");
		driver.findElement(By.xpath("//input[@id='usernamereg-yid']")).sendKeys("anasanesagar");
		Thread.sleep(3000);
		System.out.println("STEP - Enter Password");
		driver.findElement(By.xpath("//input[@id='usernamereg-password']")).sendKeys("12345@$%techNoCre");
		//Thread.sleep(3000);
		System.out.println("STEP - Enter Phone Number");
		driver.findElement(By.xpath("//input[@id='usernamereg-phone']")).sendKeys("8793671267");
		System.out.println("STEP - Enter Date of Birth");
		WebElement birthMonthElement=driver.findElement(By.xpath("//select[@id='usernamereg-month']"));
		Select birthMonthSelect= new Select(birthMonthElement);
		birthMonthSelect.selectByVisibleText("October");
		driver.findElement(By.xpath("//input[@id='usernamereg-day']")).sendKeys("20");
		driver.findElement(By.xpath("//input[@id='usernamereg-year']")).sendKeys("1994");
		driver.findElement(By.xpath("//input[@id='usernamereg-freeformGender']")).sendKeys("Male");
		System.out.println("STEP - Sign Up Successful");
		//driver.findElement(By.xpath("//button[@type='submit']")).click();
		
	}
}
