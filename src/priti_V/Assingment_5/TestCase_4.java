package priti_V.Assingment_5;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCase_4 {
	
	void JavaScripPromptAlert(String name ) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		System.out.println("Chrome Browser opened");
		
		System.out.println("Website :automationbykrishna.com");
		driver.get("http://automationbykrishna.com/");
		
		System.out.println("Step: Click on the Basic Elemets link/menu");
		driver.findElement(By.xpath("//a[@id ='basicelements']" )).click();
		Thread.sleep(4000);
		
		System.out.println("Step: Click on JavaScrip Prompt Alert button");
		driver.findElement(By.xpath("//button[@id ='javascriptPromp']" )).click();
		
		System.out.println("Step: Handel the alert");
		Alert alert = driver.switchTo().alert();
		
		System.out.println("Step:Enter the authorized user name");
		alert.sendKeys(name);
		
		System.out.println("Step:accept the alert or click on ok button");
		alert.accept();
		
		System.out.println("Step:Validate Javascript Confirmation message displayed below the button ");
		String acceptText = driver.findElement(By.xpath("// p [@id ='pgraphdemo']" )).getText();
		//System.out.println(acceptText);
		String expectedText = "Hello "+name+"! How are you today?";
		/*System.out.println(expectedText.length());
		String str = "Hello priti! How are you today?";
		System.out.println(str.length());*/
		
		if (acceptText.equals(expectedText))
			System.out.println("pass");
		else
			System.out.println("Fail");
		
		System.out.println("Test case_5_4 executed successfully");
		
		Thread.sleep(2000);
		driver.close();
		
		
		
	}
	public static void main(String[] a) throws InterruptedException {
		TestCase_4 testCase_4 = new TestCase_4();
		String name= "Priti";
		testCase_4.JavaScripPromptAlert(name);
	}
	
}
/*Go to "http://automationbykrishna.com/#"
Navigate to Basic Elements tab
Navigate to DIFFERENT EXAMPLES OF ALERTS section
Click on Javascript Prompt button
Enter the name in the alert and accept the alert.
Validate the confirmation message displayed below the Javascript Confirmation button.*/
