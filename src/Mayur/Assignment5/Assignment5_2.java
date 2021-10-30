package Mayur.Assignment5;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import amolVyas.Assignment_5.TestCase_2;

public class Assignment5_2 {
	
	void clickAlertAndVerifyMesage() throws Exception {
	System.setProperty("webdriver.chrome.driver","resources/chromedriver.exe");
	System.out.println("Step: Browser Launch");
	WebDriver driver = new ChromeDriver();
	System.out.println("Step : Url launch");
	driver.get("http://automationbykrishna.com/#");
	driver.manage().window().maximize();
	
	driver.findElement(By.xpath("//a[text()='Basic Elements']")).click();
	Thread.sleep(3000);
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("window.scrollBy(0,300)");
	System.out.println("STEP-Click on Alert button");
	driver.findElement(By.xpath("//button[@id='javascriptAlert']")).click();
	Alert alert = driver.switchTo().alert();
	System.out.println("STEP-Verify Alert popup is coming with the message");
	if(alert.getText().equals("You must be TechnoCredits student!!"))
		alert.accept();
	System.out.println("STEP-Accept the Alert");
	driver.close();
	System.out.println("Test Case Pass");
	}

	public static void main(String[] args) throws Exception {
		new Assignment5_2().clickAlertAndVerifyMesage();
	}
}

