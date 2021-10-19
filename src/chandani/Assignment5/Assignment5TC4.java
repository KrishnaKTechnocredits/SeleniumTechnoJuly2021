/*Test Case 4 - 

Go to "http://automationbykrishna.com/#"
Navigate to Basic Elements tab
Navigate to DIFFERENT EXAMPLES OF ALERTS section
Click on Javascript Prompt button
Enter the name in the alert and accept the alert.
Validate the confirmation message displayed below the Javascript Confirmation button.*/
package chandani.Assignment5;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment5TC4 {

	void javascriptPromptbutton() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("http://automationbykrishna.com/#");
		
		Thread.sleep(3000);
		driver.manage().window().maximize();
		System.out.println("STEP - Click on Basic Elements Link");
		driver.findElement(By.linkText("Basic Elements")).click();
		
		//Verification on clicking Ok on alert of Java Script Prompt button
		Thread.sleep(3000);
		System.out.println("STEP - Click on Java Script Prompt button under Different Examples of Alert");
		driver.findElement(By.xpath("//div[@class='panel-body']//button[@id=\"javascriptPromp\"]")).sendKeys(Keys.ENTER);

		Thread.sleep(3000);
		Alert alert = driver.switchTo().alert();
		Thread.sleep(3000);
		alert.sendKeys("Chandani");
		Thread.sleep(3000);
		alert.accept();
		
		String name = "Chandani";
		String expectedString = "Hello "+name+"! How are you today?";
		System.out.println(expectedString);
		String actualString = driver.findElement(By.xpath("//p[contains(text(),'Hello Chandani! How are you today?')]")).getText();
		
		if(expectedString.equals(actualString))
				System.out.println("Test Pass of Message on clicking ok on Alert of Java script Prompt Button");
				else
					System.out.println("Test Failed of Message on clicking ok on Alert of Java script Prompt Button");
		
		//Verification on clicking Cancel on alert of Java Script Prompt button
		System.out.println("STEP - Click on Java Script Prompt button under Different Examples of Alert");
		driver.findElement(By.xpath("//div[@class='panel-body']//button[@id=\"javascriptPromp\"]")).sendKeys(Keys.ENTER);

		Thread.sleep(3000);
		Alert alert1 = driver.switchTo().alert();
		Thread.sleep(3000);
		alert1.sendKeys("Chandani");
		Thread.sleep(3000);
		alert1.dismiss();
		
		String expectedString1 = "User cancelled the prompt.";
		System.out.println(expectedString1);
		String actualString1 = driver.findElement(By.xpath("//p[contains(text(),'User cancelled the prompt.')]")).getText();
		
		if(expectedString1.equals(actualString1))
				System.out.println("Test Pass of Message on clicking Cancel on Alert of Java script Prompt Button");
				else
					System.out.println("Test Failed of Message on clicking Cancel on Alert of Java script Prompt Button");
	
		driver.close();
	}
	
	
	public static void main(String[] args) throws InterruptedException {
	
		Assignment5TC4 assignment5TC4 = new Assignment5TC4();
		assignment5TC4.javascriptPromptbutton();
		System.out.println("Test Case 4 of Assignment 5 is successful");
	}
}
