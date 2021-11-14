/*Test Case 5 - 

Go to "http://automationbykrishna.com/#"
Navigate to Basic Elements tab
Enter the FirstName , LastName & CompanyName in the Alert Demo section
Click on Submit button
Validate the alert message (Validate that the firstname, lastname and company name is correctly populated in the alert message)
Accept the alert*/
package shreyaG.Assignment_5;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.PredefinedActions;

public class TestCase5 {
	void program5() throws InterruptedException {
		WebDriver driver = PredefinedActions.start();
		System.out.println("Click on basic element");
		driver.findElement(By.id("basicelements")).click();
		Thread.sleep(2000);
		
		System.out.println("Enter the first name");
		driver.findElement(By.id("UserFirstName")).sendKeys("Priyanka");
		
		System.out.println("Enter the last name");
		driver.findElement(By.id("UserLastName")).sendKeys("Rathod");
		
		System.out.println("Enter company name");
		driver.findElement(By.id("UserCompanyName")).sendKeys("Zomato");
		
		System.out.println("Click on submit button");
		driver.findElement(By.xpath("//button[@onclick='myFunctionPopUp()']")).click();
		Thread.sleep(2000);
		
		System.out.println("Switch to alert");
		Alert alert=driver.switchTo().alert();
		String text=alert.getText();
		String actualText="Priyanka and Rathod and Zomato";
		Thread.sleep(2000);
		
		if(text.equals(actualText)) {
			System.out.println("Entered details like firstname, lastname and company name is correctly populated in the alert message");
		}
		System.out.println("Accept the alert message");
		alert.accept();
		System.out.println("Test runs successfully");
		Thread.sleep(2000);
		driver.close();
		
	}
	public static void main(String[] args) throws InterruptedException {
		new TestCase5().program5();
		
	}

}
