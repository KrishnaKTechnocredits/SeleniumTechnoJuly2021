/*Assignment - 2 : 16th Oct'2021

Automate Singup : 
http://automationpractice.com/index.php
*/
package nishi.Assignment1_4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class AutomateSignUp {
	public static void main(String[] args) throws InterruptedException {
		new AutomateSignUp().automateSignUp();
	}

	 void automateSignUp() throws InterruptedException {
		 	System.setProperty("webdriver.chrome.driver", "./resources/chromedriver.exe");
			System.out.println("STEP - Open Chrome Browser");
			WebDriver driver = new ChromeDriver();
			System.out.println("STEP - Enter url");
			driver.get("http://automationpractice.com/index.php");
			System.out.println("STEP - click on Sign in");
			driver.findElement(By.xpath("//a[contains(text(),'Sign in')]")).click();
			Thread.sleep(3000);
			System.out.println("STEP - enter email-id");
			driver.findElement(By.xpath("//input[@name='email_create']")).sendKeys("nishi9999@gmail.com");
			System.out.println("STEP- click on create an account");
			driver.findElement(By.xpath("//button[@name='SubmitCreate']")).click();
			Thread.sleep(5000);
			System.out.println("Step-6: Enter the title");
			driver.findElement(By.xpath("//input[@id='id_gender2']")).click();		
			System.out.println("STEP - Enter first name");
			driver.findElement(By.xpath("//input[@name='customer_firstname']")).sendKeys("Nishi");
			System.out.println("STEP - Enter last name");
			driver.findElement(By.xpath("//input[@name='customer_lastname']")).sendKeys("Bharti");
			System.out.println("STEP - Enter password ");
			driver.findElement(By.xpath("//input[@name='passwd']")).sendKeys("nishi1995@");
			System.out.println("STEP - Enter DD of DOB");
			WebElement birthdd=driver.findElement(By.xpath("//select[@name='days']"));
			Select ddSelect=new Select(birthdd);
			ddSelect.selectByValue("27");
			System.out.println("STEP - Enter MM of DOB");
			WebElement birthYY=driver.findElement(By.xpath("//select[@name='months']"));
			Select yySelect=new Select(birthYY);
			yySelect.selectByValue("10");
			System.out.println("STEP - Enter CCYY of DOB");
			WebElement birthCCYY=driver.findElement(By.xpath("//select[@name='years']"));
			Select ccyySelect=new Select(birthCCYY);
			ccyySelect.selectByValue("1995");
			System.out.println("STEP- click on any check-box");
			driver.findElement(By.xpath("//input[@name='newsletter']")).click();
			Thread.sleep(3000);			
			System.out.println("STEP- Enter company for address-details");
			driver.findElement(By.xpath("//input[@name='company']")).sendKeys("TCS");
			System.out.println("STEP- Enter address-1 for address-details");
			driver.findElement(By.xpath("//input[@name='address1']")).sendKeys("Sarhul Nagar");
			System.out.println("STEP- Enter address-2 for address-details");
			driver.findElement(By.xpath("//input[@name='address2']")).sendKeys("Bariyatu Road");
			System.out.println("STEP- Enter city for address-details");
			driver.findElement(By.xpath("//input[@name='city']")).sendKeys("Ranchi");	
			System.out.println("STEP- Enter state for address-details");
			WebElement state=driver.findElement(By.xpath("//select[@name='id_state']"));
			Select stateSelect=new Select(state);
			stateSelect.selectByVisibleText("Indiana");
			System.out.println("STEP- Enter zipCode for address-details");
			driver.findElement(By.xpath("//input[@name='postcode']")).sendKeys("Ranchi");
			System.out.println("STEP- Enter additional information for address-details");
			driver.findElement(By.xpath("//textarea[@name='other']")).sendKeys("Jharkhand");
			System.out.println("STEP- Enter home-phn number for address-details");
			driver.findElement(By.xpath("//input[@name='phone']")).sendKeys("1234567891");
			System.out.println("STEP- Enter mobile no for address-details");
			driver.findElement(By.xpath("//input[@name='phone_mobile']")).sendKeys("My Address");
			System.out.println("STEP- click on Register button");
			driver.findElement(By.xpath("//button[@name='submitAccount']")).click();
			Thread.sleep(3000);
			driver.close();
			
			
			
			
			
			
			
		
	}

}
