package madhavi;
//Automate Singup : 

import org.openqa.selenium.By;

//http://automationpractice.com/index.php

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment_2 {
	void automateSignup() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./resources/chromedriver.exe");
		System.out.println("STEP 1 - Open Chrome Browser");
		WebDriver driver = new ChromeDriver();

		System.out.println("STEP 2- Enter automationpractice url");
		driver.get("http://automationpractice.com/index.php");
		Thread.sleep(1000);
		driver.manage().window().maximize();

		System.out.println("STEP 3- click on sign in option");
		driver.findElement(By.xpath("//a[@title='Log in to your customer account']")).click();

		System.out.println("STEP 4- Enter Email-Address");
		driver.findElement(By.xpath("//input[@id=\"email_create\"]")).sendKeys("xyz@pqr.com");

		System.out.println("STEP 5 : Click on Create account");
		driver.findElement(By.xpath("//button[@id = 'SubmitCreate']")).click();
		Thread.sleep(5000);
		System.out.println("STEP 6 : Select Title");
		driver.findElement(By.xpath("//input[@id='id_gender2']")).click();

		System.out.println("STEP 7 : Enter Firstname");
		driver.findElement(By.xpath("//input[@id=\"customer_firstname\"]")).sendKeys("Joe");

		System.out.println("STEP 8 : Enter Lastname");
		driver.findElement(By.xpath("//input[@id=\"customer_lastname\"]")).sendKeys("Falin");

		System.out.println("STEP 9 : Verify Email");
		String email = driver.findElement(By.xpath("//input[@id='email']")).getAttribute("value");
		if (email.equals("xyz@pqr.com"))
			System.out.println("Email is verified Succesfully");
		else {
			System.out.println("Incorrect email," + "\t" + "Test is failed here" + "Please correct email");
		}

		System.out.println("Step 10 - Enter password");
		driver.findElement(By.xpath("//input[@data-validate='isPasswd']")).sendKeys("Password@123$");

		System.out.println("Step 11 - Select Date for DOB");
		WebElement dobElement = driver.findElement(By.xpath("//select[@id='days']"));
		Select selectDobElement = new Select(dobElement);
		selectDobElement.selectByValue("14");

		System.out.println("Step 12 - Select Month for DOB");
		selectDobElement = new Select(driver.findElement(By.xpath("//select[@id='months']")));
		selectDobElement.selectByValue("12");

		System.out.println("Step 13 - Select Year for DOB");
		selectDobElement = new Select(driver.findElement(By.xpath("//select[@id='years']")));
		selectDobElement.selectByValue("1995");

		System.out.println("Step 14 - Enter First Name in Address");
		driver.findElement(By.xpath("//input[@id='firstname']")).sendKeys("User FirstName");

		System.out.println("Step 15 - Enter Last Name in Address");
		driver.findElement(By.xpath("//input[@id='lastname']")).sendKeys("User LastName");

		System.out.println("Step 16 - Enter Company Name");
		driver.findElement(By.xpath("//input[@id='company']")).sendKeys("User Company Name");

		System.out.println("Step 17 - Enter Company Address");
		driver.findElement(By.xpath("//input[@id='address1']")).sendKeys("Park Royal, Rahatani,Pune");

		System.out.println("Step 18 - Enter Company Address (Line 2)");
		driver.findElement(By.xpath("//input[@id='address2']")).sendKeys("ABC road,Pune");

		System.out.println("Step 19 - Enter City for the Company");
		driver.findElement(By.xpath("//input[@id='city']")).sendKeys("Pune");

		System.out.println("Step 20 - Select State for the Company");
		Select selectStateElement = new Select(driver.findElement(By.xpath("//select[@id='id_state']")));
		selectStateElement.selectByValue("32");

		System.out.println("Step 21 - Enter Zip code for the Company");
		driver.findElement(By.xpath("//input[@id='postcode']")).sendKeys("443245");

		System.out.println("Step 22 - Select country");
		WebElement countryElement = driver.findElement(By.xpath("//select[@id='id_country']"));
		Select selectCountryElement = new Select(countryElement);
		selectCountryElement.selectByValue("21");

		System.out.println("Step 23- Enter additional information");
		driver.findElement(By.xpath("//textarea[@id='other']")).sendKeys("More Info");

		System.out.println("Step 24- Enter Home Phone number");
		driver.findElement(By.xpath("//input[@id='phone']")).sendKeys("9678564325");

		System.out.println("Step 25- Enter Mobile Phone number");
		driver.findElement(By.xpath("//input[@id='phone_mobile']")).sendKeys("9678564320");

		System.out.println("Step 26- Add address alias");
		driver.findElement(By.xpath("//input[@id='alias']")).sendKeys("Address alias");

		System.out.println("Step 27: Locate register button, not click");
		driver.findElement(By.xpath("//button[@id='submitAccount']"));

		System.out.println("Test completed successfully");
		driver.close();

	}

	public static void main(String[] args) throws InterruptedException {
		new Assignment_2().automateSignup();

	}
}
