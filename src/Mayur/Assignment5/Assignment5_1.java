/*Test Case 1 -
Naivgate to "http://automationbykrishna.com/#"
Enter the login details
Validate the positive scenario for password (By entering 8 characters)
Validate the success message
Validate the negative scenario for password (Enter less than 8 characters)
Validate the failure message*/
package Mayur.Assignment5;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import base.PredefinedActions;


public class Assignment5_1 {

	void testCase1(String name , String password) throws Exception  {
//		
//		System.setProperty("webdriver.chrome.driver","resources/chromedriver.exe");
//		System.out.println("Step: Browser Launch");
//		WebDriver driver = new ChromeDriver();
//		System.out.println("Step : Url launch");
//		driver.get("http://automationbykrishna.com/#");
//		driver.manage().window().maximize();
		
		WebDriver driver = PredefinedActions.start();
		
		System.out.println("Step : Tittle of application");
		driver.getTitle();
		Thread.sleep(2000);
		System.out.println("Step : Click on Registration ");
		driver.findElement(By.xpath("//a[@id='registration2']")).click();
		
		Thread.sleep(2000);
		System.out.println("Step : Insert user name  ");
		driver.findElement(By.xpath("//input[@id = 'unameSignin']")).sendKeys(name);
		
		System.out.println("Step : Insert Password  ");
		driver.findElement(By.xpath("//input[@id = 'pwdSignin']")).sendKeys(password);
		
		System.out.println("Step : Click on   ");
		driver.findElement(By.xpath("//button[@id = 'btnsubmitdetails']")).click();
		Thread.sleep(2000);
		
		System.out.println("Validate password is correct or not ");
		Alert alert = driver.switchTo().alert();
		String actualText = alert.getText();
		
		
		if(password.length() > 8 && actualText.equals("Success!")) { 
			System.out.println("Password is correct and registration successfully completed..");
		    alert.accept();
	}else if (password.length()<8 && actualText.equalsIgnoreCase("Failed! please enter strong password"));{
			System.out.println("Password incorrect & registration Failed");
			alert.accept();
		}
		
		System.out.println("Step : Test case pass");
		driver.close();
	}

	public static void main(String[] args) throws Exception {
		new Assignment5_1().testCase1("Mayur","abcd");
		new Assignment5_1().testCase1("Mayur","1234@abcde");
	}
}
