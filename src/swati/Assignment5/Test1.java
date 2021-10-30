package swati.Assignment5;

/*
 *Test Case 1 -

Naivgate to "https://automationbykrishna.com/#"
Enter the login details
Validate the positive scenario for password (By entering 8 characters)
Validate the success message
Validate the negative scenario for password (Enter less than 8 characters)
Validate the failure message
 */

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test1 {
	
	void testCase1(String name,String password) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./resources/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		System.out.println("Enter URL:");
		driver.get("http://automationbykrishna.com/index.html#");
		driver.manage().window().maximize();
		System.out.println("Clcik on Registration");
		driver.findElement(By.xpath("//a[@id='registration2']")).click();
		Thread.sleep(3000);
		System.out.println("Enter User");
		driver.findElement(By.xpath("//input[@id='unameSignin']")).sendKeys(name);
		System.out.println("Enter Password");
		driver.findElement(By.xpath("//input[@id='pwdSignin']")).sendKeys(password);
		System.out.println("Click on button to sign in");
		driver.findElement(By.xpath("//button[@id='btnsubmitdetails']")).click();
		Alert alert=driver.switchTo().alert();
		String alertmsg=alert.getText();
		if(alertmsg.equals("Success!")) {
			System.out.println("Password validation Success");
			alert.accept();
		}else if(alertmsg.equals("Failed! please enter strong password")) {
			System.out.println("Password validation Failed");
			alert.accept();
		}
		driver.close();
		System.out.println("Test case 1 Pass");
			
	}
	
	public static void main(String[] args) throws InterruptedException {
		Test1 t1 = new Test1();
		t1.testCase1("swatid", "Techno@123");
		t1.testCase1("Swati", "abc");
	}
}

