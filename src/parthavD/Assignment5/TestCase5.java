/*Test Case 5 - 

Go to "http://automationbykrishna.com/#"
Navigate to Basic Elements tab
Enter the FirstName , LastName & CompanyName in the Alert Demo section
Click on Submit button
Validate the alert message (Validate that the firstname, lastname and company name is correctly populated in the alert message)
Accept the alert

*/

package parthavD.Assignment5;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.PredefinedActions;

public class TestCase5 {

	void validateAlertDemoSection() throws InterruptedException {
		System.out.println("Step1 - Launch Automation by Krishna Webpage");
		WebDriver driver = PredefinedActions.start();
		Thread.sleep(3000);
		System.out.println("Step2 - Click Basic Elements tab");
		driver.findElement(By.xpath("//a[@id='basicelements']")).click();
		Thread.sleep(3000);
		String FirstName = "UserFirstName";
		String LastName = "UserLastName";
		String CompanyName = "Company Name";

		System.out.println("Step3 - Add FirstName in Alert Demo section");
		driver.findElement(By.xpath("//input[@id='UserFirstName']")).sendKeys(FirstName);
		System.out.println("Step4 - Add Last Name in Alert Demo section");
		driver.findElement(By.xpath("//input[@id='UserLastName']")).sendKeys(LastName);
		System.out.println("Step5 - Add Company Name in Alert Demo section");
		driver.findElement(By.xpath("//input[@id='UserCompanyName']")).sendKeys(CompanyName);
		System.out.println("Step6 - Click Submit button in Alert Demo section");
		driver.findElement(By.xpath("//button[@onclick='myFunctionPopUp()']")).click();
		Thread.sleep(2000);
		String expectedText = FirstName + " and " + LastName + " and " + CompanyName;
		System.out.println("Step7 - Verify Alert text in Alert Demo section");
		Alert alert = driver.switchTo().alert();
		String actualText = alert.getText();
		alert.accept();
		if (expectedText.equals(actualText)) {
			System.out.println("The text on the Alert prompt is fine");
			System.out.println("The test case passed");
		} else {
			System.out.println("The text on the Alert prompt doesnt match the expectation");
			System.out.println("The test case failed");
		}
		driver.close();
	}

	public static void main(String[] args) throws InterruptedException {
		new TestCase5().validateAlertDemoSection();

	}

}
