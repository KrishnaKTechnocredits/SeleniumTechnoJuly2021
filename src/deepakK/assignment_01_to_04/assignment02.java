/*Assignment - 2 : 16th Oct'2021
Automate Signup : 
http://automationpractice.com/index.php
	*/
package deepakK.assignment_01_to_04;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import base.PredefinedActions;

public class assignment02 {
	void signUp() throws InterruptedException {
		System.out.println("Step 1 : Open URL");
		WebDriver driver = PredefinedActions.start("http://automationpractice.com/index.php");

		System.out.println("Step 2 : Click on 'Sign in'");
		driver.findElement(By.xpath("//a[contains(text(),'Sign in')]")).click();

		System.out.println("Step 3 : Enter email address");
		driver.findElement(By.xpath("//input[@id = 'email_create']")).sendKeys("test2@ymail.com");

		System.out.println("Step 4 : Click on Create an account button");
		driver.findElement(By.xpath("//button[@id = 'SubmitCreate']")).click();

		Thread.sleep(10000);

		System.out.println("Step 5 : Select the Gender radio button");
		driver.findElement(By.xpath("//input[@id='id_gender1']")).click();

		System.out.println("Step 6 : Enter the first name");
		driver.findElement(By.xpath("//input[@id = 'customer_firstname']")).sendKeys("Deepak");

		System.out.println("Step 7 : Enter the last name");
		driver.findElement(By.xpath("//input[@id = 'customer_lastname']")).sendKeys("Kankhar");

		System.out.println("Step 8 : Enter the password");
		driver.findElement(By.xpath("//input[@id = 'passwd']")).sendKeys("password123");

		System.out.println("Step 9 : Select the birth date");
		Select bDay = new Select(driver.findElement(By.xpath("//select[@id = 'days']")));
		bDay.selectByValue("24");

		System.out.println("Step 10 : Select the birth month");
		Select bMonth = new Select(driver.findElement(By.xpath("//select[@id = 'months']")));
		bMonth.selectByVisibleText("March ");

		System.out.println("Step 11 : Select the birth year");
		Select bYear = new Select(driver.findElement(By.xpath("//select[@id = 'years']")));
		bYear.selectByValue("1990");

		System.out.println("Step 12 : Select the Newsletter checkbox");
		driver.findElement(By.xpath("//input[@id = 'newsletter']")).click();

		System.out.println("Step 13 : Select the Special Offers");
		driver.findElement(By.xpath("//input[@id = 'optin']")).click();

		System.out.println("Step 14 : Enter First Name for Address section");
		driver.findElement(By.xpath("//input[@id = 'firstname']")).sendKeys("Deepak");

		System.out.println("Step 15 : Enter Last Name for Address section");
		driver.findElement(By.xpath("//input[@id = 'lastname']")).sendKeys("Kankhar");

		System.out.println("Step 16 : Enter Company for Address section");
		driver.findElement(By.xpath("//input[@id = 'company']")).sendKeys("Test CompanyABC");

		System.out.println("Step 17 : Enter Address Line 1 for Address section");
		driver.findElement(By.xpath("//input[@id = 'address1']")).sendKeys("******Test Address Line 1******");

		System.out.println("Step 18 : Enter Address Line 2 for Address section");
		driver.findElement(By.xpath("//input[@id = 'address2']")).sendKeys("******Test Address Line 2******");

		System.out.println("Step 19 : Enter City for Address section");
		driver.findElement(By.xpath("//input[@id = 'city']")).sendKeys("AmazingCity");

		System.out.println("Step 20 : Select State for Address section");
		Select state = new Select(driver.findElement(By.xpath("//select[@id = 'id_state']")));
		state.selectByVisibleText("Montana");

		System.out.println("Step 21 : Enter postal code for Address section");
		driver.findElement(By.xpath("//input[@id = 'postcode']")).sendKeys("15215");

		System.out.println("Step 22 : Enter Additional Info code for Address section");
		driver.findElement(By.xpath("//textarea[@id = 'other']")).sendKeys("Test Additional Information");

		System.out.println("Step 23 : Enter Mobile Phone for Address section");
		driver.findElement(By.xpath("//input[@id = 'phone_mobile']")).sendKeys("1212343499");

		System.out.println("Step 24 : Enter Alias address for Address section");
		driver.findElement(By.xpath("//input[@id = 'alias']")).sendKeys("Alias field");

		System.out.println("Step 25 : Click in REGISTER button");
		driver.findElement(By.xpath("//button[@id = 'submitAccount']")).click();

		// driver.close();

	}

	public static void main(String[] args) throws InterruptedException {
		assignment02 obj = new assignment02();
		obj.signUp();

	}

}
