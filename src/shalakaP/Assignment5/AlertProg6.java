/*Test Case 6 - 

Go to "http://automationbykrishna.com/#"
Navigate to Basic Elements tab
Navigate to the Basic Forms scetion and enter the email address and password 
Click on Submit button
Validate the success alert message.
Accept the alert*/
package shalakaP.Assignment5;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import shalakaP.Helper.PredefinedActions;

public class AlertProg6 {

	void prog6() throws InterruptedException {
		WebDriver driver = PredefinedActions.start();
		System.out.println("Step-Click on Basic Elements");
		driver.findElement(By.linkText("Basic Elements")).click();
		Thread.sleep(3000);
		System.out.println("Step-Fill basic form");
		System.out.println("Step-Enter Email");
		driver.findElement(By.xpath("//input[@id='exampleInputEmail1']")).sendKeys("shalaka@gmail.com");
		System.out.println("Step-Enter Password");
		driver.findElement(By.xpath("//input[@id='pwd']")).sendKeys("sha12457");
		System.out.println("Step-Submit button");
		driver.findElement(By.xpath("//button[@id='submitb2']")).click();

		System.out.println("Step-Switch to alert");
		Alert alert = driver.switchTo().alert();
		String actualText = alert.getText();
		String expectedText = "You successfully clicked on it";

		if (actualText.equals(expectedText))
			System.out.println("Text message is ok");
		else
			System.out.println("Text message is wrong");

		System.out.println("Validate the alert message");
		alert.accept();
		driver.close();
	}

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		new AlertProg6().prog6();
	}

}
