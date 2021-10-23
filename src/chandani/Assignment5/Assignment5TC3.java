package chandani.Assignment5;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment5TC3 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("http://automationbykrishna.com/#");
		
		Thread.sleep(3000);
		driver.manage().window().maximize();
		System.out.println("STEP - Click on Basic Elements Link");
		driver.findElement(By.linkText("Basic Elements")).click();
		
		Thread.sleep(3000);
		System.out.println("STEP - Click on Javascript Confirmation button under Different Examples of Alert");
		driver.findElement(By.xpath("//div[@class='panel-body']//button[@id=\"javascriptConfirmBox\"]")).sendKeys(Keys.ENTER);

		Thread.sleep(3000);
		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		
		String expectedString = "Are you are doing your homework regularly, Press Okay else Cancel!!";
		String actualString = alert.getText();
				
		if(expectedString.equals(actualString))
				System.out.println("Test Pass of Alert on Alert Button");
				else
					System.out.println("Test Failed of Alert on Alert Button");
		
		alert.accept();
		//On clicking ok on the Alert
		System.out.println("On clicking ok verify the message on UI");
		String expectedString1 = "You pressed OK!";
		String actualString1 = driver.findElement(By.xpath("//p[contains(text(),'You pressed OK!')]")).getText();
		
		if(expectedString1.equals(actualString1))
			System.out.println("Test Pass of verifying message on clicking ok on the alert");
			else
				System.out.println("Test Failed of verifying message on clicking ok on the alert");
		
		//On clicking Cancel on the Alert
		
		System.out.println("STEP - Click on Javascript Confirmation button under Different Examples of Alert");
		driver.findElement(By.xpath("//div[@class='panel-body']//button[@id=\"javascriptConfirmBox\"]")).sendKeys(Keys.ENTER);

		Thread.sleep(3000);
		Alert alert1 = driver.switchTo().alert();
		alert1.dismiss();
	
		Thread.sleep(3000);
		System.out.println("On clicking Cancel verify the message on UI");
		String expectedString2 = "You pressed Cancel!";
		String actualString2 = driver.findElement(By.xpath("//p[contains(text(),'You pressed Cancel!')]")).getText();
			
		if(expectedString2.equals(actualString2))
			System.out.println("Test Pass of verifying message on clicking Cancel on the alert");
		else
			System.out.println("Test Failed of verifying message on clicking Cancel on the alert");
		
		System.out.println("Test Case 3 of Assignment 5 is successful");
		driver.close();
		
	}
}
