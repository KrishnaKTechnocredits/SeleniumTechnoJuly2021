/* Assignment 5 - 17th Oct 2021
http://automationbykrishna.com/#

Test Case 1 -
Naivgate to "http://automationbykrishna.com/#"
Enter the login details
Validate the positive scenario for password (By entering 8 characters)
Validate the success message
Validate the negative scenario for password (Enter less than 8 characters)
Validate the failure message */



package ritabrata_bhattacharyya.Assignment5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test_1 {
	WebDriver driver;
	public Test_1(String url) {
		System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
		System.out.println("Open Chrome Browser");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		System.out.println("Enter the url");
		driver.get(url);
	}
	
	//Test Case-1
	void testCase1() throws InterruptedException {
		Thread.sleep(3000);
		System.out.println("STEP1- Click on registration");
		driver.findElement(By.xpath("//a[@id='registration2']")).click();
		Thread.sleep(3000);
		
		//Postive scenario
		System.out.println("STEP2- Enter username");
		driver.findElement(By.xpath("//input[@id='unameSignin']")).sendKeys("RitabrataB");
		System.out.println("STEP3- Enter valid password");
		driver.findElement(By.xpath("//input[@id='pwdSignin']")).sendKeys("qwertyuiop@123");
		System.out.println("STEP4- Click on tick button");
		driver.findElement(By.xpath("//button[@id='btnsubmitdetails']")).click();
		System.out.println("STEP5- Get alert message");
		String str = driver.switchTo().alert().getText();
		System.out.println("STEP5- Validate alert message in case of success");
		if(str.equals("Success!"))
			System.out.println("Success message match");
		else
			System.out.println("Success message not match");
		System.out.println("STEP67- Accept alert");
		driver.switchTo().alert().accept();
		
		//Clear fields text
		System.out.println();
		System.out.println("STEP8 - Clear username");
		driver.findElement(By.xpath("//input[@id='unameSignin']")).clear();
		System.out.println("STEP9- Clear password");
		driver.findElement(By.xpath("//input[@id='pwdSignin']")).clear();
		
		//Negative scenario
		System.out.println();
		System.out.println("STEP10- Enter username");
		driver.findElement(By.xpath("//input[@id='unameSignin']")).sendKeys("RitabrataB");
		System.out.println("STEP11- Enter less than 8 digit password");
		driver.findElement(By.xpath("//input[@id='pwdSignin']")).sendKeys("qwertyuiop@123");
		System.out.println("STEP12- Tap on tick button");
		driver.findElement(By.xpath("//button[@id='btnsubmitdetails']")).click();
		System.out.println("STEP13- Get alert message");
		String str2 = driver.switchTo().alert().getText();
		System.out.println("STEP14- Validate alert message in case of failure");
		if(str2.equals("Failed! lease enter strong password"))
			System.out.println("Failure message match");
		else
			System.out.println("Failure message not match");
		System.out.println("STEP15- Dismiss alert");
		driver.switchTo().alert().dismiss();
		
		driver.close();
		driver.quit();
	}

	public static void main(String[] args) throws InterruptedException {
		String url= "http://automationbykrishna.com/#";
		new Test_1(url).testCase1();
	}

}
