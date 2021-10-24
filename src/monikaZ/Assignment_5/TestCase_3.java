/*Test Case 3 - 
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
package monikaZ.Assignment_5;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCase_3 {
	void handleAlertSection() throws InterruptedException{
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
		
		System.out.println("Step- Click on JavaScript Confirmation Button");;
		driver.findElement(By.xpath("//button[@id='javascriptConfirmBox']")).click();
		
		Thread.sleep(2000);
		Alert alert=driver.switchTo().alert();
		System.out.println(alert.getText());
		
		String expectedString = "Are you are doing your homework regularly, Press Okay else Cancel!!";
		String actualString = alert.getText();
		
		if(expectedString.equals(actualString))
			System.out.println("Test Passed");
		else
			System.out.println("Test Failed");
		
		System.out.println("Step- On clicking OK on the Alert");
		alert.accept();
		String expectedString1 = "You pressed OK!";
		String actualString1 = driver.findElement(By.xpath("//p[contains(text(),'You pressed OK!')]")).getText();

		if(expectedString1.equals(actualString1))
			System.out.println("Test Passed of verifying message on clicking ok on the alert");
			else
				System.out.println("Test Failed of verifying message on clicking ok on the alert");
		
		System.out.println("Step- On clicking Cancel on the Alert");
		driver.findElement(By.xpath("//div[@class='panel-body']//button[@id=\"javascriptConfirmBox\"]")).sendKeys(Keys.ENTER);

		Thread.sleep(3000);
		Alert alert1 = driver.switchTo().alert();
		alert1.dismiss();

		Thread.sleep(3000);
		String expectedString2 = "You pressed Cancel!";
		String actualString2 = driver.findElement(By.xpath("//p[contains(text(),'You pressed Cancel!')]")).getText();

		if(expectedString2.equals(actualString2))
			System.out.println("Test Passed on clicking Cancel on the alert");
		else
			System.out.println("Test Failed on clicking Cancel on the alert");

		driver.close();
		System.out.println("Step- Test Passed Sucessfully");
		
		
}
	public static void main(String[] args) throws InterruptedException {
		new TestCase_3().handleAlertSection();
	}
}
