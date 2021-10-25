package swati.Assignment5;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
/*
 * Test Case 4 - 

Go to "http://automationbykrishna.com/#"
Navigate to Basic Elements tab
Navigate to DIFFERENT EXAMPLES OF ALERTS section
Click on Javascript Prompt button
Enter the name in the alert and accept the alert.
Validate the confirmation message displayed below the Javascript Confirmation button.
 */
public class Test4 {
	
	void verifyJavaScriptPrompt() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","./resources/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		System.out.println("Enter URL");
		driver.get("http://automationbykrishna.com/#");
		driver.manage().window().maximize();
		System.out.println("Enter on Basic Element");
		driver.findElement(By.xpath("//a[@id='basicelements']")).click();
		Thread.sleep(3000);
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)");
		System.out.println("Click on JavaScriptPrompt Button");
		driver.findElement(By.xpath("//button[@id='javascriptPromp']")).click();
		Alert alert=driver.switchTo().alert();
		System.out.println("Enter Name");
		alert.sendKeys("swati");
		alert.accept();
		String message=driver.findElement(By.xpath("//p[@id='pgraphdemo']")).getText();
		if(message.equals("Hello swati! How are you today?")) {
			System.out.println("Message validation Pass");
		}else
			System.out.println("Message validation fail");
		driver.close();
		System.out.println("TestCase 4 Pass");
	}
	
	public static void main(String[] args) throws InterruptedException {
		Test4 t4=new Test4();
		t4.verifyJavaScriptPrompt();
		
	}
}
