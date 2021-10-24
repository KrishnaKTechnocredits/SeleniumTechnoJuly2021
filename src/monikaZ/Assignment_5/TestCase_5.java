/*Test Case 5 - 
Go to "http://automationbykrishna.com/#"
Navigate to Basic Elements tab
Enter the FirstName , LastName & CompanyName in the Alert Demo section
Click on Submit button
Validate the alert message (Validate that the firstname, lastname and company name is correctly populated in the alert message)
Accept the alert
*/

package monikaZ.Assignment_5;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCase_5 {
	
	void validateAlertMessage() throws InterruptedException {
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
		System.out.println("STEP-Enter First Name");
		driver.findElement(By.xpath("//input[@id='UserFirstName']")).sendKeys("Monika");
		
		System.out.println("Step-Enter Last Name");
		driver.findElement(By.xpath("//input[@id='UserLastName']")).sendKeys("Zankar");
		
		System.out.println("Step-Enter Company Name");
		driver.findElement(By.xpath("//input[@id='UserCompanyName']")).sendKeys("abc");
		
		System.out.println("Step-Click on Submit button");
		driver.findElement(By.xpath("//div[@name='secondSegment'][1]/section/div/div/button[@type='submit']")).click();
		
		Alert alert=driver.switchTo().alert();
		
		String fname = "Monika";
		String lname = "Zankar";
		String company= "abc";

		String output = fname+" and "+lname+" and "+company;
		System.out.println(output);
		String actualMessage = alert.getText();
		
		alert.accept();
		if(actualMessage.equalsIgnoreCase(output))
			System.out.println("Data is Matched");
		else
			System.out.println("Data is not Matched");
		
		driver.close();
		System.out.println("Step- Test Passed Sucessfully");
	}
	public static void main(String[] args) throws InterruptedException {
		new TestCase_5().validateAlertMessage();
	}

}
