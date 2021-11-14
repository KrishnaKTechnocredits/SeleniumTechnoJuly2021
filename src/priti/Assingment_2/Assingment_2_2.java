package priti.Assingment_2;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assingment_2_2 {
	
	void singInCreateAccountAndRegister(String name, String lastName) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		System.out.println("Chrome browser opened");
		driver.get("http://automationpractice.com/");
		
		System.out.println("STEP-click on the Sing in");
		driver.findElement(By.xpath("//a [@title ='Log in to your customer account']")).click();
		Thread.sleep(2000);
				
		System.out.println("STEP-Enter Email ID");
		driver.findElement(By.xpath("//input [@id ='email_create']")).clear();
		driver.findElement(By.xpath("//input [@id ='email_create']")).sendKeys("psvattanavar@gmail.com");
		System.out.println("STEP-click on the button Create new account");
		driver.findElement(By.xpath("//button [@class ='btn btn-default button button-medium exclusive']")).click();
		Thread.sleep(4000);
				
		System.out.println("STEP-Select Mrs radio button under Title");
		driver.findElement(By.xpath("//input[@value ='2']")).click();
		System.out.println("STEP-Enter First Name");
		driver.findElement(By.xpath("//input[@id ='customer_firstname']")).sendKeys(name);
		System.out.println("STEP-Enter Last Name");
		driver.findElement(By.xpath("//input [@id ='customer_lastname']")).sendKeys(lastName);
		System.out.println("STEP-Enter Email");
		Random randomGenerator = new Random();  
		int randomInt = randomGenerator.nextInt(1000);  
		driver.findElement(By.xpath("//input [@id ='email']")).clear();
		driver.findElement(By.xpath("//input [@id ='email']")).sendKeys("pvattanavar"+ randomInt +"@gmail.com");
		System.out.println("STEP-Enter Password");
		driver.findElement(By.xpath("//input [@id ='passwd']")).sendKeys("priti12345");
				
		System.out.println("STEP-Select Date Of Birth");
		Select dataSelect = new Select (driver.findElement(By.xpath("//div[@class ='selector']//select [@name ='days']")));
		dataSelect.selectByVisibleText("1  ");
		Select monthSelect= new Select(driver.findElement(By.xpath("//div[@class ='selector']//select [@name ='months']")));
		monthSelect.selectByValue("12");
		Select yearSelect = new Select(driver.findElement(By.xpath("//select[@name = 'years']")));
		/*JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)");*/
		yearSelect.selectByValue("1976");
				
		System.out.println("STEP-Verify the text- Sign up for our newsletter!");
		String signUpText= driver.findElement(By.xpath("//label [@for='newsletter']")).getText();
		if (signUpText.equals("Sign up for our newsletter!")) 
			System.out.println("pass");
		else
			System.out.println("fail");
		System.out.println("STEP-Check the checkbox for-Sign up for newsletter");
		driver.findElement(By.xpath("//label [@for='newsletter']")).click();
				
		System.out.println("STEP-Verify the text- recevie special offers from our partners!");
		String checkbox2Text = driver.findElement(By.xpath("//* [@for ='optin']")).getText();
		if (checkbox2Text .equals("Receive special offers from our partners!")) 
			System.out.println("pass");
		else
			System.out.println("fail");
		System.out.println("STEP-Check the checkbox for-Recevie special offers from our partners!");
		driver.findElement(By.xpath("//* [@for ='optin']")).click();
		
		System.out.println("STEP-Enter First Name in -Your Address -Section");
		driver.findElement(By.xpath("//input [@id  ='firstname']")).sendKeys(name);
		System.out.println("STEP-Enter Last Name in -Your Address -Section");
		driver.findElement(By.xpath("//input [@id  ='lastname']")).sendKeys(lastName);
		System.out.println("STEP-Enter Company  in -Your Address -Section");
		driver.findElement(By.xpath("//input [@id  ='company']")).sendKeys("Globant");
		System.out.println("STEP-Enter Address  in -Your Address -Section");
		driver.findElement(By.xpath("//input [@id  ='address1']")).sendKeys("Baner Road");
		System.out.println("STEP-Enter Address (Line 2) in -Your Address -Section");
		driver.findElement(By.xpath("//input [@id  ='address2']")).sendKeys("Kirti Element");
		System.out.println("STEP-Enter City in -Your Address -Section");
		driver.findElement(By.xpath("//input [@id  ='city']")).sendKeys("Pune");
		System.out.println("STEP-Select State in -Your Address -Section");
		driver.findElement(By.xpath("//select[@id ='id_state']")).sendKeys("Florida");
		System.out.println("STEP-Enter Zip/Postal code in -Your Address -Section");
		driver.findElement(By.xpath("//input [@id  ='postcode']")).sendKeys("12345");;
		System.out.println("STEP-Enter Country in -Your Address -Section");
		Select countrySelect = new Select(driver.findElement(By.xpath("//select [@id = 'id_country']")));
		countrySelect.selectByVisibleText("United States");
		
		System.out.println("STEP-Enter Additional information in -Your Address -Section");
		driver.findElement(By.xpath("//textarea [@name ='other']")).sendKeys("Landmark -Balewadi Stedium");
		System.out.println("STEP-Enter Home phone in -Your Address -Section");
		driver.findElement(By.xpath("//input[@id ='phone']")).sendKeys("9960877382");
		System.out.println("STEP-Enter Mobile phone  in -Your Address -Section");
		driver.findElement(By.xpath("//input[@id ='phone_mobile']")).sendKeys("9881697382");
		System.out.println("STEP-Enter Assign an address alias for future reference in -Your Address -Section");
		driver.findElement(By.xpath("//input[@id ='alias']")).sendKeys("Kirti Sco");
		System.out.println("STEP-Click on Register Button-Your Address -Section");
		driver.findElement(By.xpath("//button[@name ='submitAccount']")).click();
		Thread.sleep(2000);
		
		System.out.println("STEP-Verify that Registraton is successfull ");
		String accountName = name+" "+lastName;
		System.out.println("STEP-Verify Registered user name reflectd beside Sign In Link ");
		String regUsername = driver.findElement(By.xpath("//a [@ title = 'View my customer account']")).getText();
		if(regUsername.equals(accountName))
			System.out.println("Register Username text verifted and passed");
		else
			System.out.println("Register Username text verifted and failed");
		
		System.out.println("STEP-click Sign out link to verify that user get logged out");
		driver.findElement(By.xpath("//a [@title ='Log me out']")).click();
		Thread.sleep(3000);
				
		System.out.println("STEP-Test_2_1 case executed successfully");
		driver.close();
	}
		
	public static void main(String[] a) throws InterruptedException {
		Assingment_2_2 assingment_2_2 = new Assingment_2_2();
		String name = "Priti";
		String lastName= "Vattanavar";
		assingment_2_2.singInCreateAccountAndRegister(name,lastName);
	}
	
	

}
