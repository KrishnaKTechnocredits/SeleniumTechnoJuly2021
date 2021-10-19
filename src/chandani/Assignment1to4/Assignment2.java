/*Assignment - 2 : 16th Oct'2021
Automate Singup : 
http://automationpractice.com/index.php*/
package chandani.Assignment1to4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment2 {
	
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("http://automationpractice.com/index.php");
		
		System.out.println("STEP - Click on Sign Up button");
		driver.findElement(By.xpath("//a[contains(text(),'Sign in')]")).click();
		
		Thread.sleep(3000);
		driver.manage().window().maximize();
		System.out.println("STEP - Enter email ID");
		driver.findElement(By.xpath("//input[@name = 'email_create']")).sendKeys("cheenu123@gmail.com");
		
		System.out.println("STEP - Click on Create account");
		driver.findElement(By.xpath("//button[@class=\"btn btn-default button button-medium exclusive\"]")).click();
		
		Thread.sleep(3000);
		
		System.out.println("Enter Salutation");
		driver.findElement(By.xpath("//input[@id=\"id_gender2\"]")).click();

		
		
		System.out.println("STEP - Enter First Name");
		driver.findElement(By.xpath("//input[@id=\"customer_firstname\"]")).sendKeys("Chandani");
		
		System.out.println("STEP - Enter Last Name");
		driver.findElement(By.xpath("//input[@id=\"customer_lastname\"]")).sendKeys("Fatehchandani");
		
		System.out.println("STEP - Enter Pasword");
		driver.findElement(By.xpath("//input[@id=\"passwd\"]")).sendKeys("Auto@123");
		
		Thread.sleep(3000);
		System.out.println("STEP - Enter Date of birth");
		
		WebElement birthdateelement = driver.findElement(By.xpath("//select[@id='days']"));
		Select birthdateselect = new Select(birthdateelement);
		birthdateselect.selectByVisibleText("6  ");
		
		System.out.println("STEP - Enter Birth month");

		WebElement birthmonthelement = driver.findElement(By.xpath("//select[@id= 'months']"));
		Select birthmonthselect = new Select(birthmonthelement);
		birthmonthselect.selectByVisibleText("April ");
		
		System.out.println("STEP - Enter Birth year");
		
		WebElement birthmyearelement = driver.findElement(By.xpath("//select[@id= 'years']"));
		Select birthyearselect = new Select(birthmyearelement);
		birthyearselect.selectByValue("1989");
		
		System.out.println("STEP - Enter Address related details - First Name, Last Name, Company, Address Line 1, Address Line 2, \n"
				+ "City, State, Zip Code, Additional Information, Home Phone, Mobile Phone, \n"
				+ "Address Alias");
		
		driver.findElement(By.xpath("//input[@name=\"firstname\"]")).sendKeys("Chandani");
		
		driver.findElement(By.xpath("//input[@name=\"lastname\"]")).sendKeys("Fatehchandani");
						
		driver.findElement(By.xpath("//input[@name=\"company\"]")).sendKeys("Technocredits");

		driver.findElement(By.xpath("//input[@name=\"address1\"]")).sendKeys("City park in Niagara Falls");
		driver.findElement(By.xpath("//input[@id='address2']")).sendKeys("Niagara Falls NY");
		driver.findElement(By.xpath("//input[@id=\"city\"]")).sendKeys("Niagara Falls");
		
		WebElement selectState = driver.findElement(By.xpath("//select[@id=\"id_state\"]"));
		Select state = new Select(selectState);
		state.selectByVisibleText("New York");
		
		driver.findElement(By.xpath("//input[@id='postcode']")).sendKeys("14303");
		driver.findElement(By.xpath("//textarea[@id=\"other\"]")).sendKeys("Assignment 2 - Technocredits");
		driver.findElement(By.xpath("//input[@id='phone']")).sendKeys("9819582858");
		driver.findElement(By.xpath("//input[@id='phone_mobile']")).sendKeys("9619714838");
		driver.findElement(By.xpath("//input[@name=\"alias\"]")).clear();
		driver.findElement(By.xpath("//input[@name=\"alias\"]")).sendKeys("Home");
		
		System.out.println("Assigment 2 - Test successful");
		driver.close();			
	}
}
