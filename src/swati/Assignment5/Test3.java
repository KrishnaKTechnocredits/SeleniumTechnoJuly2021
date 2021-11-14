package swati.Assignment5;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/*
 Test Case 3 - 

Naivgate to "http://automationbykrishna.com/#"
Navigate to Basic Elements tab
Navigate to DIFFERENT EXAMPLES OF ALERTS section
Click on Javascript Confirmation button
Validate the alert message and accept the alert.
Validate the confirmation message displayed below the Javascript Confirmation button.
Click on Javascript Confirmation button
Dismiss the alert.
Validate the confirmation message displayed below the Javascript Confirmation button.
 */

public class Test3 {
	void verifyJavaScriptConfirmation() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","./resources/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		System.out.println("Enter URL");
		driver.get("http://automationbykrishna.com/#");
		driver.manage().window().maximize();
		System.out.println("Enter on Basic Element");
		driver.findElement(By.xpath("//a[@id='basicelements']")).click();
		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)");
		System.out.println("Clcik on JavaConfirmation Button");
		driver.findElement(By.xpath("//button[@id='javascriptConfirmBox']")).click();
		pressOKButton(driver);	
		driver.findElement(By.xpath("//button[@id='javascriptConfirmBox']")).click();
		pressCancelButton(driver);
		driver.close();
		System.out.println("TestCase3 Pass");
		
	}
	void pressOKButton(WebDriver driver) {
		Alert alert=driver.switchTo().alert();
		String alertMsg=alert.getText();
		if(alertMsg.equals("Are you are doing your homework regularly, Press Okay else Cancel!!")) {
			System.out.println("Alert Message :Pass for OK");
			alert.accept();
		}else
			System.out.println("Failed");
		
		String message=driver.findElement(By.xpath("//p[text()='You pressed OK!']")).getText();
		validateMessage(message);
		
	}
	void pressCancelButton(WebDriver driver) {
		Alert alert=driver.switchTo().alert();
		String alertMsg=alert.getText();
		if(alertMsg.equals("Are you are doing your homework regularly, Press Okay else Cancel!!")) {
			System.out.println("Alert Message :Pass for Cancel");
			alert.dismiss();
		}else
			System.out.println("Failed");
		
		String message=driver.findElement(By.xpath("//p[@id='pgraphdemo']")).getText();
		validateMessage(message);
		
	}
	
	void validateMessage(String message) {
		if(message.equals("You pressed OK!"))
		{
			System.out.println("Message validation Pass for OK button");
		}else if(message.equals("You pressed Cancel!")) {
			System.out.println("Message validation Pass for Cancel button");
		
		}else
			System.out.println("Invalid Message");
	}
	
	public static void main(String[] args) throws InterruptedException {
		Test3 t3=new Test3();
		t3.verifyJavaScriptConfirmation();
	}
}
