package amol_P.Assignment_5;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class TC_01 {
	static WebDriver driver;

	String testVerifyAlert(String uName, String UPassword) throws InterruptedException {

		System.out.println("Enter UserName");
		driver.findElement(By.xpath("//input[@id='unameSignin']")).sendKeys(uName);
		System.out.println("Enter Password");
		driver.findElement(By.xpath("//input[@id='pwdSignin']")).sendKeys(UPassword);
		System.out.println("Click on Submit button");
		driver.findElement(By.xpath("//button[@id='btnsubmitdetails']")).click();
		Alert al = driver.switchTo().alert();
		String ActualAlert = al.getText();
		al.accept();
		return ActualAlert;

	}

	void testSuccessAlert(String uName, String uPassword) throws InterruptedException {
		System.out.println("Verify Success message..!");

		String alertActualMessage = testVerifyAlert(uName, uPassword);
		System.out.println(alertActualMessage);
		if (alertActualMessage.equals("Success!")) {
			System.out.println("Test Passed");
		} else {
			System.out.println("Test Failed");
		}
	}

	void testFailureAlert(String uName, String uPassword) throws InterruptedException {
		System.out.println("Verify Falure message..!");

		driver.findElement(By.xpath("//input[@id='pwdSignin']")).clear();
		driver.findElement(By.xpath("//input[@id='unameSignin']")).clear();
		String alertActualMessage = testVerifyAlert(uName, uPassword);
		System.out.println(alertActualMessage);
		if (alertActualMessage.equals("Failed! please enter strong password")) {
			System.out.println("Test Passed");
		} else {
			System.out.println("Test Failed");
		}
	}
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","./resources//chromedriver.exe");
		 driver =new ChromeDriver();
		driver.get("http://automationbykrishna.com/#");
		driver.manage().window().maximize();
		System.out.println("Click on Basic Element");
		driver.findElement(By.xpath("//a[@id='registration2']")).click();
		Thread.sleep(2000);
		TC_01 TC_01 = new TC_01();
		System.out.println("Test Case 1:");
		TC_01.testSuccessAlert("AmolP", "Password@1234");
		TC_01.testFailureAlert("AmolP", "dsc");

	}

}
