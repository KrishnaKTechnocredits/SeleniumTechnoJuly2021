/*Assignment - 4: 16th Oct'2021
Yahoo Signup.
https://login.yahoo.com/account/create?specId=yidReg
*/
package monikaZ;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment_4 {
	static void getYahooSignUp() {
		System.setProperty("webdriver.chrome.driver", "./resources/chromedriver.exe");
		System.out.println("STEP- Open chrome browser");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		System.out.println("STEP- Enter Yahoo url");
		
		driver.get("https://login.yahoo.com/account/create?specId=yidReg");
		
		System.out.println("STEP- Enter First Name");
		driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys("Advika");
		
		System.out.println("STEP- Enter Last Name");
		driver.findElement(By.xpath("//input[@name='lastName']")).sendKeys("Patil");
		
		System.out.println("STEP- Enter Email Id");
		driver.findElement(By.xpath("//input[@name='yid']")).sendKeys("patil.advika");
		
		System.out.println("STEP- Enter Password");
		driver.findElement(By.xpath("//input[@id='usernamereg-password']")).sendKeys("Wpdk@5478");
		
		System.out.println("STEP- Enter Mobile No.");
		driver.findElement(By.xpath("//select[@name='shortCountryCode']")).sendKeys("+91");
		driver.findElement(By.xpath("//input[@id='usernamereg-phone']")).sendKeys("9856561475");
		
		System.out.println("STEP- Enter DOB");
		WebElement monthele=driver.findElement(By.xpath("//select[@name='mm']"));
		Select monthselect=new Select(monthele);
		monthselect.selectByVisibleText("March");
		
		driver.findElement(By.xpath("//input[@name='dd']")).sendKeys("20");
		driver.findElement(By.xpath("//input[@name='yyyy']")).sendKeys("1996");
		
		System.out.println("STEP- Enter Gender");
		driver.findElement(By.xpath("//input[@name='freeformGender']")).sendKeys("Female");
		
		System.out.println("STEP- Submit");
		driver.findElement(By.xpath("//button[@name='signup']")).click();
		
		driver.close();
		System.out.println("Test Passed Successfully");
		
	}
	public static void main(String[] args) {
		getYahooSignUp();
	}

}
