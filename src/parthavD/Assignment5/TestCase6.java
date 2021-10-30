/*Test Case 6 - 

Go to "http://automationbykrishna.com/#"
Navigate to Basic Elements tab
Navigate to the Basic Forms scetion and enter the email address and password 
Click on Submit button
Validate the success alert message.
Accept the alert*/

package parthavD.Assignment5;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.PredefinedActions;

public class TestCase6 {

	void BasicFormAlert() throws InterruptedException {
		System.out.println("Step1 - Launch Automation by Krishna Webpage");
		WebDriver driver = PredefinedActions.start();
		Thread.sleep(3000);
		System.out.println("Step2 - Click Basic Elements tab");
		driver.findElement(By.xpath("//a[@id='basicelements']")).click();
		Thread.sleep(3000);
		System.out.println("Step3 - Add Email address in Basic Forms section");
		driver.findElement(By.xpath("//input[@id='exampleInputEmail1']")).sendKeys("abc@xyz.com");
		System.out.println("Step4 - Add Password in Basic Forms section");
		driver.findElement(By.xpath("//input[@id='pwd']")).sendKeys("Password@123");
		System.out.println("Step5 - Click on Submit button in Basic Forms section");
		driver.findElement(By.xpath("//button[@id='submitb2']")).click();
		Alert alert = driver.switchTo().alert();
		System.out.println("Step6 - Verify Alert text in Basic Forms section");
		String actualText = alert.getText();
		alert.accept();
		if (actualText.equals("You successfully clicked on it"))
			System.out.println("The text matches. Test case passed");
		else
			System.out.println("The text doesn't match. Test case failed");
		driver.close();
	}

	public static void main(String[] args) throws InterruptedException {
		new TestCase6().BasicFormAlert();
	}

}
