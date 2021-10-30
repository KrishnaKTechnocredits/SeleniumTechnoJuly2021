/*Test Case 4 - 

Go to "http://automationbykrishna.com/#"
Navigate to Basic Elements tab
Navigate to DIFFERENT EXAMPLES OF ALERTS section
Click on Javascript Prompt button
Enter the name in the alert and accept the alert.
Validate the confirmation message displayed below the Javascript Confirmation button.*/
package shalakaP.Assignment5;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import shalakaP.Helper.PredefinedActions;

public class AlertProg4 {
	 void prog4(String name) throws InterruptedException {
		 WebDriver driver=PredefinedActions.start();
		 System.out.println("Step-Click on Basic Elements");
		 driver.findElement(By.linkText("Basic Elements")).click();
		 Thread.sleep(3000);
		System.out.println("Step-Click on Prompt button");
		 WebElement element = driver.findElement(By.xpath("//button[text()='Javascript Prompt']"));
			JavascriptExecutor je = (JavascriptExecutor) driver;
			je.executeScript("arguments[0].scrollIntoView(true)", element);
			element.click();
			
			System.out.println("Step-Switch to Alert");
			Alert alert=driver.switchTo().alert();
			alert.sendKeys(name);
			alert.accept();
			String actualText= driver.findElement(By.xpath("//p[@id=\"pgraphdemo\"]")).getText();

			
			System.out.println("Validate the confirmation message displayed below ok button");
			String expectedText="Hello "+name+"! How are you today?";
			if(actualText.equals(expectedText))
				System.out.println("Text is ok");
			else
				System.out.println("Text is Wrong");
			
			System.out.println("Step-Click on Prompt button");
			driver.findElement(By.xpath("//button[text()='Javascript Prompt']")).click();
			
			System.out.println("Step-Switch to Alert");
			alert=driver.switchTo().alert();
			alert.sendKeys(name);
			alert.dismiss();
			
			System.out.println("Validate the confirmation message displayed below cancel button");
			String actualCancelText= driver.findElement(By.xpath("//p[@id=\"pgraphdemo\"]")).getText();
			String expectedCancelText="User cancelled the prompt.";
			if(actualCancelText.equals(expectedCancelText))
				System.out.println("Cancel text is ok");
			else
				System.out.println("Cancel text is Wrong");
			
			driver.close();
			
	 }

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		new AlertProg4().prog4("Shalaka");
	}

}
