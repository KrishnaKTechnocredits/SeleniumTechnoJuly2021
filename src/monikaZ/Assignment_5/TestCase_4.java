/*Test Case 4 - 
Go to "http://automationbykrishna.com/#"
Navigate to Basic Elements tab
Navigate to DIFFERENT EXAMPLES OF ALERTS section
Click on Javascript Prompt button
Enter the name in the alert and accept the alert.
Validate the confirmation message displayed below the Javascript Confirmation button.
*/
package monikaZ.Assignment_5;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCase_4 {
	
	void javaScritptPromptButton(String name) throws InterruptedException {
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
		
		System.out.println("STEP-Click on JavaScript confirmation button");
		driver.findElement(By.xpath("//button[@id='javascriptPromp']")).click();
		Thread.sleep(2000);
		Alert alert = driver.switchTo().alert();
		System.out.println("STEP-Verify Alert popup is coming");
		System.out.println("STEP-Enter Name");
		alert.sendKeys(name);
		alert.accept();
		String actualText = driver.findElement(By.xpath("//p[@id='pgraphdemo']")).getText();
		
		String exepectedText = "Hello " + name + "! How are you today?";
		
		if(actualText.equals(exepectedText))
			System.out.println("Text Matched");
		else
			System.out.println("Text not Matched");
		driver.close();
		System.out.println("Step- Test Passed Sucessfully");
	}
	public static void main(String[] args) throws InterruptedException {
		new TestCase_4().javaScritptPromptButton("monika");
	
	}
}

