/*Test Case 5 - 

Go to "http://automationbykrishna.com/#"
Navigate to Basic Elements tab
Enter the FirstName , LastName & CompanyName in the Alert Demo section
Click on Submit button
Validate the alert message (Validate that the firstname, lastname and company name is correctly populated in the alert message)
Accept the alert*/
package shalakaP.Assignment5;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import shalakaP.Helper.PredefinedActions;

public class AlertProg5 {

	void prog5() throws InterruptedException {
		WebDriver driver = PredefinedActions.start();
		System.out.println("Step-Click on Basic Elements");
		driver.findElement(By.linkText("Basic Elements")).click();
		Thread.sleep(3000);
		System.out.println("Step-Enter username");
		driver.findElement(By.name("ufname")).sendKeys("Shalaka");
		System.out.println("Step-Enter lastname");
		driver.findElement(By.name("ulname")).sendKeys("Prayag");
		System.out.println("Step-Enter company name");
		driver.findElement(By.name("cmpname")).sendKeys("Wipro");
		driver.findElement(By.xpath("//div[@class='panel-body']/div/button[@type='submit']")).click();

		System.out.println("Step-Switch to alert");
		Alert alert = driver.switchTo().alert();
		String actualText = alert.getText();
		String expectedText = "Shalaka and Prayag and Wipro";

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
		new AlertProg5().prog5();
	}

}
