/*Assignment - 2 : 16th Oct'2021
Automate Singup : 
http://automationpractice.com/index.php
*/

package parthavD;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment2 {

	void automateSignUp() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		System.out.println("Step 1 - Launch Automation Practice URL ");
		driver.get("http://automationpractice.com/index.php");
		Thread.sleep(1000);
		System.out.println("Step 2 - Click on Sign In button ");
		driver.findElement(By.xpath("//a[@title='Log in to your customer account']")).click();
		System.out.println("Step 3 - Enter the email address to create account");
		String userEmail = "abc1@xyz.com";
		driver.findElement(By.xpath("//input[@name='email_create']")).sendKeys(userEmail);
		System.out.println("Step 4 - Click Create Account Button");
		driver.findElement(By.xpath("//div[@class='submit']/button[@id='SubmitCreate']")).click();
		Thread.sleep(2000);
		System.out.println("Step 5 - Select Salutation");
		driver.findElement(By.xpath("//input[@id='id_gender1']")).click();
		System.out.println("Step 6 - Enter First Name");
		driver.findElement(By.xpath("//input[@id='customer_firstname']")).sendKeys("User FirstName");
		System.out.println("Step 7 - Enter Last Name");
		driver.findElement(By.xpath("//input[@id='customer_lastname']")).sendKeys("User LastName");
		System.out.println("Step 8 - Verify Email");
		String email = driver.findElement(By.xpath("//input[@id='email']")).getAttribute("value");
		if (email.equals(userEmail))
			System.out.println("Correct email showing");
		else {
			System.out.println("Incorrect email showing");
			System.out.println("Step 8 - Failed");
		}
		System.out.println("Step 9 - Enter password");
		driver.findElement(By.xpath("//input[@data-validate='isPasswd']")).sendKeys("Password@123");
		System.out.println("Step 10 - Select Date for DOB");

		WebElement dobElement = driver.findElement(By.xpath("//select[@id='days']"));
		Select selectDobElement = new Select(dobElement);
		selectDobElement.selectByValue("25");
		System.out.println("Step 11 - Select Month for DOB");
		selectDobElement = new Select(driver.findElement(By.xpath("//select[@id='months']")));
		selectDobElement.selectByValue("6");
		System.out.println("Step 12 - Select Year for DOB");
		selectDobElement = new Select(driver.findElement(By.xpath("//select[@id='years']")));
		selectDobElement.selectByValue("2009");
		System.out.println("Step 13 - Add First Name in Address");
		driver.findElement(By.xpath("//input[@id='firstname']")).sendKeys("User FirstName");
		System.out.println("Step 14 - Add Last Name in Address");
		driver.findElement(By.xpath("//input[@id='lastname']")).sendKeys("User LastName");
		System.out.println("Step 15 - Add Company Name");
		driver.findElement(By.xpath("//input[@id='company']")).sendKeys("User Company Name");
		System.out.println("Step 16 - Add Company Address");
		driver.findElement(By.xpath("//input[@id='address1']")).sendKeys("ABC Techno Park, Pune, MH, India");
		System.out.println("Step 17 - Add Company Address Line 2");
		driver.findElement(By.xpath("//input[@id='address2']")).sendKeys("Unit no 104");
		System.out.println("Step 18 - Select City for the Company");
		driver.findElement(By.xpath("//input[@id='city']")).sendKeys("Oakland");
		System.out.println("Step 19 - Select State for the Company");
		Select selectLocation = new Select(driver.findElement(By.xpath("//select[@id='id_state']")));
		selectLocation.selectByValue("5");
		System.out.println("Step 20 - Add Zip code for the Company");
		driver.findElement(By.xpath("//input[@id='postcode']")).sendKeys("08540");
		System.out.println("Step 21 - Select country");
		selectLocation = new Select(driver.findElement(By.xpath("//select[@id='id_country']")));
		selectLocation.selectByValue("21");
		System.out.println("Step 22- Add additional information");
		driver.findElement(By.xpath("//textarea[@id='other']")).sendKeys("Add additional information");
		System.out.println("Step 23- Add Home Phone number");
		driver.findElement(By.xpath("//input[@id='phone']")).sendKeys("8897784545");
		System.out.println("Step 24- Add Mobile Phone number");
		driver.findElement(By.xpath("//input[@id='phone_mobile']")).sendKeys("8897784545");
		System.out.println("Step 25- Add address alias");
		driver.findElement(By.xpath("//input[@id='alias']")).sendKeys("New Corporate Address");
		System.out.println("Test completed successfully");
		driver.close();

	}

	public static void main(String[] args) throws InterruptedException {
		new Assignment2().automateSignUp();

	}

}
