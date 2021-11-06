package dattaraj_W.Assignment_5;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test_Case2 {

	WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		String url= "http://automationbykrishna.com/";
		new Test_Case2(url).Case2();
	}
	

	public Test_Case2(String url) {
		System.setProperty("webdriver.chrome.driver", "./resources/chromedriver.exe");
		System.out.println("STEP - Open Chrome Browser");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		System.out.println("STEP - Enter url");
		driver.get(url);
	}
	
	void Case2() throws InterruptedException {
		// TODO Auto-generated method stub
		//Thread.sleep(3000);
		System.out.println("STEP- Tap on Basic Element");
		//driver.findElement(By.xpath("//a[@id='basicelements']")).click();
		driver.findElement(By.id("basicelements")).click();
		Thread.sleep(3000);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)");
		
		System.out.println("STEP- Tap on Alert button");
		driver.findElement(By.xpath("//button[@id='javascriptAlert']")).click();
		
		System.out.println("STEP- Get alert message");
		String expectedMessage = "You must be TechnoCredits student!!";
		
		String alertMessage = driver.switchTo().alert().getText();
		System.out.println("STEP- Validate alert message");
		
		if(alertMessage.equals(expectedMessage)) {
			System.out.println("Alert message match");
		}else {
			System.out.println("Alert message not match");
		}
		
		System.out.println("STEP- Accept alert");
		driver.switchTo().alert().accept();
		
		driver.close();
		driver.quit();
	}
}
