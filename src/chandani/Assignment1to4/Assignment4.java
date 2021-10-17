/*Assignment - 4: 16th Oct'2021
Yahoo Signup.
https://login.yahoo.com/account/create?specId=yidReg*/
package chandani.Assignment1to4;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment4 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("https://login.yahoo.com/account/create?specId=yidReg");
		driver.manage().window().maximize();
		
		Thread.sleep(3000);
		System.out.println("STEP - Enter First Name");
		driver.findElement(By.xpath("//input[@id=\"usernamereg-firstName\"]")).sendKeys("Chandani");
		
		System.out.println("STEP - Enter Last Name");
		driver.findElement(By.xpath("//input[@id=\"usernamereg-lastName\"]")).sendKeys("F");
		
		System.out.println("STEP - Enter Email Address");
		driver.findElement(By.xpath("//input[@id=\"usernamereg-yid\"]")).sendKeys("Chandani0604");		
		
		System.out.println("STEP - Enter Password");
		driver.findElement(By.xpath("//input[@id=\"usernamereg-password\"]")).sendKeys("Selenium123");
		
		System.out.println("STEP - Enter Phone Number");
		driver.findElement(By.xpath("//input[@id=\"usernamereg-phone\"]")).sendKeys("9819582858");
		
		System.out.println("STEP - Enter Date of birth month");
		WebElement birthmonthelement = driver.findElement(By.xpath("//select[@name='mm']"));
		Select birthmonthselect = new Select(birthmonthelement);
		birthmonthselect.selectByVisibleText("April");
		
		System.out.println("STEP - Enter Date of birth");
		driver.findElement(By.xpath("//input[@id=\"usernamereg-day\"]")).sendKeys("6");
		
		System.out.println("STEP - Enter Date of birth year");
		driver.findElement(By.xpath("//input[@id=\"usernamereg-year\"]")).sendKeys("1989");
		
		System.out.println("STEP - Enter Gender");
		driver.findElement(By.xpath("//input[@id=\"usernamereg-freeformGender\"]")).sendKeys("Female");
		
		
		System.out.println("Assignment 4 - Test Successful");
		driver.close();
	}
}
