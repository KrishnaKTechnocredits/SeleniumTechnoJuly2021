/*Test Case 2 - 
Naivgate to "http://automationbykrishna.com/#"
Navigate to Basic Elements tab
Navigate to DIFFERENT EXAMPLES OF ALERTS section
Click on Alert button
Validate the alert message and accept the alert.
*/

package monikaZ.Assignment_5;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCase_2 {

	void handleAlertsection() throws InterruptedException{
		System.setProperty("webdriver.chrome.driver", "./resources/chromedriver.exe");
		System.out.println("Step- Open Chrome Browser");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		System.out.println("Step- Enter URL");
		driver.navigate().to("http://automationbykrishna.com/#");
		Thread.sleep(3000);
		System.out.println("Step- Click on Basic Elements Link");
		driver.findElement(By.xpath("//a[contains(text(),'Basic Elements')]")).click();
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)");
		
		Thread.sleep(2000);
		System.out.println("Step- Click on Alert Button Under Different Examples of Alert");
		driver.findElement(By.xpath("//div[@class='panel-body']//button[@id='javascriptAlert']")).sendKeys(Keys.ENTER);
		
		Thread.sleep(2000);
		Alert alert=driver.switchTo().alert();
		System.out.println(alert.getText());
		
		Thread.sleep(2000);
		String expectedString = "You must be TechnoCredits student!!";
		String actualString = alert.getText();
		
		if(expectedString.equals(actualString))
			System.out.println("Test Passed");
		else
			System.out.println("Test Fail");
		alert.accept();
		
		driver.close();
		System.out.println("Step- Test Passed Sucessfully");
	}
	public static void main(String[] args) throws InterruptedException {
		new TestCase_2().handleAlertsection();
	}
}
