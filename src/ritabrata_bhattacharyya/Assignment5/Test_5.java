/* Assignment 5 - 17th Oct 2021
http://automationbykrishna.com/#

Test Case 5 - 
Go to "http://automationbykrishna.com/#"
Navigate to Basic Elements tab
Enter the FirstName , LastName & CompanyName in the Alert Demo section
Click on Submit button
Validate the alert message (Validate that the firstname, lastname and company name is correctly populated in the alert message)
Accept the alert */


package ritabrata_bhattacharyya.Assignment5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class Test_5 {
WebDriver driver;
public Test_5(String url) {
	System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
	System.out.println("STEP1 - Open Chrome Browser");
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	System.out.println("STEP2 - Enter url");
	driver.get(url);
}

//Test Case-5
void testCase5() throws InterruptedException {
	Thread.sleep(3000);
	System.out.println("STEP3- Click on basic elements");
	driver.findElement(By.xpath("//a[@id='basicelements']")).click();
	Thread.sleep(3000);
	System.out.println("STEP4- Enter First Name");
	String firstName = "Ritabrata";
	driver.findElement(By.xpath("//input[@id='UserFirstName']")).sendKeys(firstName);
	System.out.println("STEP5- Enter Last Name");
	String lastName = "Bhattacharyya";
	driver.findElement(By.xpath("//input[@id='UserLastName']")).sendKeys(lastName);
	System.out.println("STEP6- Enter Company Name");
	String companyName = "TCSSSSS";
	driver.findElement(By.xpath("//input[@id='UserCompanyName']")).sendKeys(companyName);
	System.out.println("STEP7- Tap on submit button");
	driver.findElement(By.xpath("//button[@onclick='myFunctionPopUp()']")).click();
	System.out.println("STEP8- Get alert message");
	String alertMessage = driver.switchTo().alert().getText();
	String expectedAlertMessage = firstName + " and " + lastName + " and " + companyName;
	System.out.println("STEP9- Validate alert message");
	if(alertMessage.equals(expectedAlertMessage))
		System.out.println("Alert message match");
	else
		System.out.println("Alert message not match");
	driver.switchTo().alert().accept();
	
	driver.close();
	driver.quit();
}

public static void main(String[] args) throws InterruptedException {
	String url= "http://automationbykrishna.com/#";
	new Test_5(url).testCase5();
}
	
	

}
