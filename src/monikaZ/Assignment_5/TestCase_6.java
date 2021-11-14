/*Test Case 6 - 
Go to "http://automationbykrishna.com/#"
Navigate to Basic Elements tab
Navigate to the Basic Forms section and enter the email address and password 
Click on Submit button
Validate the success alert message.
Accept the alert*/

package monikaZ.Assignment_5;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCase_6 {
	
	void basicFormSection(String emailID, String password) throws InterruptedException {
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
		System.out.println("Step- Enter Email");
		driver.findElement(By.xpath("//input[@id='exampleInputEmail1']")).sendKeys(emailID);
		System.out.println("Step- Enter Password");
		driver.findElement(By.xpath("//input[@id='pwd']")).sendKeys(password);
		System.out.println("Step- Click on Submit button");
		driver.findElement(By.xpath("//div[@name='secondSegment'][2]/section/div/div/button[@type='submit']")).click();
		Alert alert = driver.switchTo().alert();
		String acutal = alert.getText();
		alert.accept();
		if (acutal.equalsIgnoreCase("You successfully clicked on it"))
			System.out.println("Alert Verification Passed");
		else
			System.out.println("Alert Verification Failed");
		//driver.close();
		System.out.println("Step- Test Passed Sucessfully");
	}

	public static void main(String[] args) throws InterruptedException {
		new TestCase_6().basicFormSection("monika@test.com", "12$der");
	}
}
