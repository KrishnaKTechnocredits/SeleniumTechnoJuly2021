/* Assignment 5 - 17th Oct’2021
http://automationbykrishna.com/#

Test Case 1 -
Naivgate to "http://automationbykrishna.com/#"
Enter the login details
Validate the positive scenario for password (By entering 8 characters)
Validate the success message
Validate the negative scenario for password (Enter less than 8 characters)
Validate the failure message */

package akansha_Jain.Assignment_5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment_5_TestCase1 {
	WebDriver driver;
	
	public Assignment_5_TestCase1(String url) {
		System.setProperty("webdriver.chrome.driver", "//Users//punchh_akansha//eclipse-workspace//Java_Techno_Selenium_2021//resources//chromedriver");
		System.out.println("STEP - Open Chrome Browser");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		System.out.println("STEP - Enter url");
		driver.get(url);
	}
	
	//Test Case-1
	void testCase1() throws InterruptedException {
		Thread.sleep(3000);
		System.out.println("STEP- Tap on registration");
		driver.findElement(By.xpath("//a[@id='registration2']")).click();
		Thread.sleep(3000);
		
		//Postive scenario
		System.out.println("STEP- Enter username");
		driver.findElement(By.xpath("//input[@id='unameSignin']")).sendKeys("AkanshaJain");
		System.out.println("STEP- Enter valid 8 digit password");
		driver.findElement(By.xpath("//input[@id='pwdSignin']")).sendKeys("qwertyui@123");
		System.out.println("STEP- Tap on tick button");
		driver.findElement(By.xpath("//button[@id='btnsubmitdetails']")).click();
		System.out.println("STEP- Get alert message");
		String str = driver.switchTo().alert().getText();
		System.out.println("STEP- Validate alert message in case of success");
		if(str.equals("Success!"))
			System.out.println("Success message match");
		else
			System.out.println("Success message not match");
		System.out.println("STEP- Accept alert");
		driver.switchTo().alert().accept();
		
		//Clear fields text
		System.out.println();
		System.out.println("STEP- Clear username");
		driver.findElement(By.xpath("//input[@id='unameSignin']")).clear();
		System.out.println("STEP- Clear password");
		driver.findElement(By.xpath("//input[@id='pwdSignin']")).clear();
		
		//Negative scenario
		System.out.println();
		System.out.println("STEP- Enter username");
		driver.findElement(By.xpath("//input[@id='unameSignin']")).sendKeys("AkanshaJain");
		System.out.println("STEP- Enter less than 8 digit password");
		driver.findElement(By.xpath("//input[@id='pwdSignin']")).sendKeys("qwerty");
		System.out.println("STEP- Tap on tick button");
		driver.findElement(By.xpath("//button[@id='btnsubmitdetails']")).click();
		System.out.println("STEP- Get alert message");
		String str2 = driver.switchTo().alert().getText();
		System.out.println("STEP- Validate alert message in case of failure");
		if(str2.equals("Failed! please enter strong password"))
			System.out.println("Failure message match");
		else
			System.out.println("Failure message not match");
		System.out.println("STEP- Dismiss alert");
		driver.switchTo().alert().dismiss();
		
		driver.close();
		driver.quit();
	}

	public static void main(String[] args) throws InterruptedException {
		String url= "http://automationbykrishna.com/#";
		new Assignment_5_TestCase1(url).testCase1();
	}
}