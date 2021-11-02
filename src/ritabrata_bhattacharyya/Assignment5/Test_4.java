/* Assignment 5 - 17th Oct’2021
http://automationbykrishna.com/#

Test Case 4 - 
Go to "http://automationbykrishna.com/#"
Navigate to Basic Elements tab
Navigate to DIFFERENT EXAMPLES OF ALERTS section
Click on Javascript Prompt button
Enter the name in the alert and accept the alert.
Validate the confirmation message displayed below the Javascript Confirmation button. */



package ritabrata_bhattacharyya.Assignment5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class Test_4 {
WebDriver driver;
	
	public Test_4(String url) {
		System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
		System.out.println("STEP1 - Open Chrome Browser");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		System.out.println("STEP2 - Enter url");
		driver.get(url);
	}
	
	//Test Case-4
	void testCase4() throws InterruptedException {
		Thread.sleep(3000);
		System.out.println("STEP3- Click on basic elements");
		driver.findElement(By.xpath("//a[@id='basicelements']")).click();
		Thread.sleep(3000);
		
		// Accept alert
		System.out.println("STEP4- Click on Javascript Prompt button");
		driver.findElement(By.xpath("//button[@id='javascriptPromp']")).click();
		System.out.println("STEP5- Enter name in alert box");
		String name = "Ritabrata B";
		driver.switchTo().alert().sendKeys(name);
		System.out.println("STEP6- Press okay");
		driver.switchTo().alert().accept();
		System.out.println("STEP7- Validate confirmation message in case of okay");
		String expectedConfirmationMessage = "Hello " + name + "! How are you today?";
		String confirmationMessage = driver.findElement(By.xpath("//p[contains(text(), 'Hello')]")).getText();
		if(confirmationMessage.equals(expectedConfirmationMessage))
			System.out.println("Confirmation message match");
		else
			System.out.println("Confirmation message not match");
		
		//Dismiss alert
		System.out.println("STEP8- Tap on Javascript Prompt button");
		driver.findElement(By.xpath("//button[@id='javascriptPromp']")).click();
		System.out.println("STEP9- Press cancel");
		driver.switchTo().alert().dismiss();
		System.out.println("STEP10- Validate confirmation message in case of cancel");
		String expectedConfirmationMessage2 = "User cancelled the prompt.";
		String confirmationMessage2 = driver.findElement(By.xpath("//p[contains(text(), 'User')]")).getText();
		if(confirmationMessage2.equals(expectedConfirmationMessage2))
			System.out.println("Confirmation message match");
		else
			System.out.println("Confirmation message not match");

		driver.close();
		driver.quit();
	}

	public static void main(String[] args) throws InterruptedException {
		String url= "http://automationbykrishna.com/#";
		new Test_4(url).testCase4();
	}

}
