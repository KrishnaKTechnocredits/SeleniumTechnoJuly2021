/*Test Case 2 - 

Naivgate to "http://automationbykrishna.com/#"
Navigate to Basic Elements tab
Navigate to DIFFERENT EXAMPLES OF ALERTS section
Click on Alert button
Validate the alert message and accept the alert.*/
package chandani.Assignment5;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment5TC2 {
	
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("http://automationbykrishna.com/#");
		
		Thread.sleep(3000);
		driver.manage().window().maximize();
		System.out.println("STEP - Click on Basic Elements Link");
		driver.findElement(By.linkText("Basic Elements")).click();
		
		Thread.sleep(3000);
		System.out.println("STEP - Click on Alert button under Different Examples of Alert");
		driver.findElement(By.xpath("//div[@class='panel-body']//button[@id='javascriptAlert']")).sendKeys(Keys.ENTER);
		
		Thread.sleep(3000);
		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		
		String expectedString = "You must be TechnoCredits student!!";
		String actualString = alert.getText();
				
		if(expectedString.equals(actualString))
				System.out.println("Test Pass of Alert on Alert Button");
				else
					System.out.println("Test Failed of Alert on Alert Button");
		
		alert.accept();
		
		System.out.println("Test Case 2 of Assignment 5 is successful");
		driver.close();
	}
}
