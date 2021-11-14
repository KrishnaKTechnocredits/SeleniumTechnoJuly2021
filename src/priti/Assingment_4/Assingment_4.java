package priti.Assingment_4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;



public class Assingment_4 {
	void verifyYahooSignUpForm() throws InterruptedException{
		System.setProperty("webdriver.chrome.driver", "./resources/chromedriver.exe");
		System.out.println("Chrome browser launched");
		WebDriver driver= new ChromeDriver();
		
		
		System.out.println("STEP :Enter the url");
		driver.get("https://login.yahoo.com/account/create?specId=yidReg");
		
		System.out.println("STEP :Enter FirstName");
		driver.findElement(By.xpath("//input[@id ='usernamereg-firstName']")).sendKeys("Priti");
		
		System.out.println("STEP :Enter LastName");
		driver.findElement(By.xpath("//input[@id ='usernamereg-lastName']")).sendKeys("Vattanavar");
		
		System.out.println("STEP :verify prefilled text @yahoo.com in the email id textbox");
		driver.findElement(By.xpath("//p [@tabindex ='-1']"));
		
		
		System.out.println("STEP :Enter Email");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id ='usernamereg-yid']")).sendKeys("preeti_nilange@yahoo.com");
		
		Thread.sleep(1000);
		System.out.println("STEP :Enter password");
		driver.findElement(By.xpath("//input [@ id='usernamereg-password']")).sendKeys("priti123");
				
		
		System.out.println("STEP :Enter moile number");
		driver.findElement(By.xpath("//input [@id ='usernamereg-phone']")).sendKeys("9960877382");
		
		System.out.println("STEP :Select Month ");
		WebElement element = driver.findElement(By.xpath("//select [@id ='usernamereg-month']"));
		Select select= new Select(element);
		select.selectByVisibleText("December");
		
		System.out.println("STEP :Enter date");
		driver.findElement(By.xpath("//input[@id ='usernamereg-day']")).sendKeys("17");
		
		System.out.println("STEP :Enter Year");
		driver.findElement(By.xpath("//input[@id ='usernamereg-year']")).sendKeys("1976");
		
		System.out.println("STEP :Enter Gender");
		driver.findElement(By.xpath("//input[@id ='usernamereg-freeformGender']")).sendKeys("Female");
		
		Thread.sleep(3000);
		System.out.println("Test case executed successfully");
		driver.close();
	}
 
	public static void main(String[] a) throws InterruptedException{
		Assingment_4 assingment_4 = new Assingment_4();
		assingment_4.verifyYahooSignUpForm();
		
	}

}
