package swati.Assignment5;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/*
 * Test Case 2 - 

Naivgate to "http://automationbykrishna.com/#"
Navigate to Basic Elements tab
Navigate to DIFFERENT EXAMPLES OF ALERTS section
Click on Alert button
Validate the alert message and accept the alert.
 */

public class Test2 {
	
	void testCase2() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./resources/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		System.out.println("Enter URL");
		driver.get("http://automationbykrishna.com/#");
		driver.manage().window().maximize();
		System.out.println("Enter on Basic Element");
		driver.findElement(By.xpath("//a[@id='basicelements']")).click();
		Thread.sleep(3000);
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)");
		System.out.println("Click on Alert");
		driver.findElement(By.xpath("//button[@id='javascriptAlert']")).click();
		Alert alert=driver.switchTo().alert();
		String alertMsg=alert.getText();
		if(alertMsg.equals("You must be TechnoCredits student!!")) {
			System.out.println("Alert : Pass");
			alert.accept();
		}else
			System.out.println("Test Failed");
		
		System.out.println("TestCase2 Pass");
		driver.close();
	}
	
	public static void main(String[] args) throws InterruptedException {
		Test2 t2=new Test2();
		t2.testCase2();
		
	}

}

