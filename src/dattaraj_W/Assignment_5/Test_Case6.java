package dattaraj_W.Assignment_5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test_Case6 {
WebDriver driver;
	
	public Test_Case6(String url) {
		System.setProperty("webdriver.chrome.driver", "./resources/chromedriver.exe");
		System.out.println("STEP - Open Chrome Browser");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		System.out.println("STEP - Enter url");
		driver.get(url);
	}
	
	void Case6() throws InterruptedException {
		Thread.sleep(3000);
		System.out.println("STEP- Tap on basic elements");
		driver.findElement(By.xpath("//a[@id='basicelements']")).click();
		Thread.sleep(3000);
		System.out.println("STEP- Enter email");
		driver.findElement(By.xpath("//input[@id='exampleInputEmail1']")).sendKeys("dattarajwete@gmail.com");
		System.out.println("STEP- Enter password");
		driver.findElement(By.xpath("//input[@id='UserLastName']")).sendKeys("werdfsead@123");
		System.out.println("STEP- Tap on submit button");
		driver.findElement(By.xpath("//button[@id='submitb2']")).click();
		System.out.println("STEP- Get alert message");
		String alertMessage = driver.switchTo().alert().getText();
		String expectedAlertMessage = "You successfully clicked on it";
		System.out.println("STEP- Validate alert message");
		if(alertMessage.equals(expectedAlertMessage))
			System.out.println("Alert message match");
		else
			System.out.println("Alert message not match");
		driver.switchTo().alert().accept();
		
		driver.close();
		driver.quit();
	}
	
	public static void main(String[] args) throws InterruptedException {
		String url= "http://automationbykrishna.com/#";
		new Test_Case6(url).Case6();
	}
}
