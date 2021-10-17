/* Assignment - 2 : 16th Oct'2021
Automate Singup : 
http://automationpractice.com/index.php */

package akansha_Jain;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment_2 {
	
	void automateSignup() throws InterruptedException {
		System.out.println("STEP- Open chrome browser");
		System.setProperty("webdriver.chrome.driver", "//Users//punchh_akansha//eclipse-workspace//Java_Techno_Selenium_2021//resources//chromedriver");
		WebDriver driver=new ChromeDriver();
		
		System.out.println("STEP- Open URL");
		driver.get("http://automationpractice.com/index.php");
		Thread.sleep(4000);
		
		System.out.println("STEP- Click on sign in button");
		driver.findElement(By.xpath("//a[contains(text(),'Sign in')]")).click();
		Thread.sleep(1000);
		
		System.out.println("STEP- Enter email");
		driver.findElement(By.xpath("//input[@name='email_create']")).sendKeys("akansha.jain@yopmail.com");
		Thread.sleep(1000);
		
		System.out.println("STEP- Click on Create an account button");
		driver.findElement(By.xpath("//i[@class='icon-user left']")).click();
		Thread.sleep(4000);
		
		System.out.println("STEP- Choose title");
		driver.findElement(By.xpath("//input[@value='2']")).click();
		
		System.out.println("STEP- Enter first name");
		driver.findElement(By.xpath("//input[@name='customer_firstname']")).sendKeys("Akansha");
		
		System.out.println("STEP- Enter last name");
		driver.findElement(By.xpath("//input[@name='customer_lastname']")).sendKeys("Jain");
		
		System.out.println("STEP- Enter password");
		driver.findElement(By.xpath("//input[@name='passwd']")).sendKeys("Password@123");
		
		System.out.println("STEP- Enter DOB");
		System.out.println("Enter Day");
		WebElement bdayElement1 = driver.findElement(By.xpath("//select[@name='days']"));
		Select bdaySelect1 = new Select(bdayElement1);
		bdaySelect1.selectByVisibleText("6  ");
		
		System.out.println("Enter Month");
		WebElement bdayElement2 = driver.findElement(By.xpath("//select[@name='months']"));
		Select bdaySelect2 = new Select(bdayElement2);
		bdaySelect2.selectByVisibleText("September ");
		
		System.out.println("Enter Year");
		WebElement bdayElement3 = driver.findElement(By.xpath("//select[@name='years']"));
		Select bdaySelect3 = new Select(bdayElement3);
		bdaySelect3.selectByVisibleText("1991  ");
		
		System.out.println("STEP- Choose newsletter checkbox");
		driver.findElement(By.xpath("//label[@for='newsletter']")).click();
		
		System.out.println("STEP- Choose optin checkbox");
		driver.findElement(By.xpath("//label[@for='optin']")).click();
		
		System.out.println("STEP- Enter first name for address");
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Akansha");
		
		System.out.println("STEP- Enter last name for address");
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Jain");		
		
		System.out.println("STEP- Enter company");
		driver.findElement(By.xpath("//input[@name='company']")).sendKeys("Punchh Tech India Pvt Ltd");		
		
		System.out.println("STEP- Enter address line 1");
		driver.findElement(By.xpath("//input[@name='address1']")).sendKeys("Newai Walon Ka Godam");	
		
		System.out.println("STEP- Enter address line 2");
		driver.findElement(By.xpath("//input[@name='address2']")).sendKeys("Qafla Bazaar");		
		
		System.out.println("STEP- Enter city");
		driver.findElement(By.xpath("//input[@name='city']")).sendKeys("Tonk");	
		
		System.out.println("STEP- Enter state");
		WebElement stateElement = driver.findElement(By.xpath("//select[@name='id_state']"));
		Select stateSelect = new Select(stateElement);
		stateSelect.selectByVisibleText("Indiana");
		
		System.out.println("STEP- Enter postcode");
		driver.findElement(By.xpath("//input[@name='postcode']")).sendKeys("304001");
		
		System.out.println("STEP- Enter additional information");
		driver.findElement(By.xpath("//textarea[@name='other']")).sendKeys("NA");
		
		System.out.println("STEP- Enter home phone");
		driver.findElement(By.xpath("//input[@name='phone']")).sendKeys("+16234567890");
		
		System.out.println("STEP- Enter mobile phone");
		driver.findElement(By.xpath("//input[@name='phone_mobile']")).sendKeys("+19887435678");
		
		//System.out.println("STEP- Click on register button");
		//driver.findElement(By.xpath("//button[@class='btn btn-default button button-medium']")).click();
		
		driver.close();
		driver.quit();
	}
	
	public static void main(String[] args) throws InterruptedException {
			new Assignment_2().automateSignup();
	}
}