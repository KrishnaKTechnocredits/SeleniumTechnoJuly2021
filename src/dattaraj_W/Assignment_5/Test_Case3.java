package dattaraj_W.Assignment_5;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test_Case3 {

	WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		String url= "http://automationbykrishna.com/";
		new Test_Case3(url).Case3();
	}

	public Test_Case3(String url) {
		System.setProperty("webdriver.chrome.driver", "./resources/chromedriver.exe");
		System.out.println("STEP - Open Chrome Browser");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		System.out.println("STEP - Enter url");
		driver.get(url);
	}
	
	void Case3() throws InterruptedException {
		// TODO Auto-generated method stub
		System.out.println("STEP- Tap on basic elements");
		//driver.findElement(By.xpath("//a[@id='basicelements']")).click();
		driver.findElement(By.id("basicelements")).click();
		Thread.sleep(3000);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)");
		
		System.out.println("STEP- Tap on Javascript Confirmation");
		driver.findElement(By.xpath("//button[@id='javascriptConfirmBox']")).click();
		
		System.out.println("STEP- Get alert message");
		String expectedAlertMessage = "Are you are doing your homework regularly, Press Okay else Cancel!!";
		String alertMessage = driver.switchTo().alert().getText();
		
		System.out.println("STEP- Validate alert message");
		if(alertMessage.equals(expectedAlertMessage))
			System.out.println("Alert message match");
		else
			System.out.println("Alert message not match");
		
		System.out.println("STEP- Press okay");
		driver.switchTo().alert().accept();
		
		System.out.println("STEP- Validate confirmation message");
		String expectedConfirmationMessage = "You pressed OK!";
		
		String confirmationMessage = driver.findElement(By.xpath("//p[text()='You pressed OK!']")).getText();
		if(confirmationMessage.equals(expectedConfirmationMessage))
			System.out.println("Confirmation message match");
		else
			System.out.println("Confirmation message not match");
		
		//Dismiss alert
		System.out.println("STEP- Tap on Javascript Confirmation");
		driver.findElement(By.xpath("//button[@id='javascriptConfirmBox']")).click();
		
		System.out.println("STEP- Validate alert message");
		if(alertMessage.equals(expectedAlertMessage))
			System.out.println("Alert message match");
		else
			System.out.println("Alert message not match");
		
		System.out.println("STEP- Press cancel");
		driver.switchTo().alert().dismiss();
		
		System.out.println("STEP- Validate confirmation message");
		String expectedConfirmationMessage2 = "You pressed Cancel!";
		
		String confirmationMessage2 = driver.findElement(By.xpath("//p[text()='You pressed Cancel!']")).getText();
		if(confirmationMessage2.equals(expectedConfirmationMessage2))
			System.out.println("Confirmation message match");
		else
			System.out.println("Confirmation message not match");
		
		driver.close();
		driver.quit();
	}
}
