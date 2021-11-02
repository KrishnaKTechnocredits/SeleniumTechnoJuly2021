package elizabeth.Assignment_5;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import base.PredefinedActions;

public class Assignment5 {
	
	static void verifyAlert(WebDriver driver) {
		System.out.println("Step 2: Click on Alert Button");
		driver.findElement(By.xpath("//button[text()='Alert']")).click();
		Alert alert=driver.switchTo().alert();
		String actualText=alert.getText();
		System.out.println(actualText);
		alert.accept();
		String expectedText="You must be TechnoCredits student!!";
		
		System.out.println("Step 3: Verify the text on the pop up");
		if(actualText.equals(expectedText)) {
			System.out.println("Verification Passed");
		}else {
			System.out.println("Verification Failed");
		}
	}
	
	static void javascriptConfirmation(WebDriver driver) {
		System.out.println("Step 4: Click on Javascript Confirmation");
		driver.findElement(By.xpath("//button[text()='Javascript Confirmation']")).click();
		Alert alert1=driver.switchTo().alert();
		System.out.println("Step 5: Click on OK");
		alert1.accept();
		WebElement element1 =driver.findElement(By.xpath("//p[@id='pgraphdemo']"));
		String actualMessage1=element1.getText();
		System.out.println(actualMessage1);
		String expectedMessage1="You pressed OK!";
		
		System.out.println("Step 6: Verify the message after clicking Ok");
		if(actualMessage1.equals(expectedMessage1)) {
			System.out.println("Message is as expected");
		}else {
			System.out.println("Message is not as expected");
		}
		
		System.out.println("Step 7: Click on Javascript Confirmation again");
		driver.findElement(By.xpath("//button[text()='Javascript Confirmation']")).click();
		Alert alert2=driver.switchTo().alert();
		System.out.println("Step 8: Click on Cancel");
		alert2.dismiss();
		WebElement element2 =driver.findElement(By.xpath("//p[@id='pgraphdemo']"));
		String actualMessage2=element2.getText();
		System.out.println(actualMessage2);
		String expectedMessage2="You pressed Cancel!";
	
		System.out.println("Step 9: Verify the message after clicking on Cancel");
		if(actualMessage2.equals(expectedMessage2)) {
			System.out.println("Message is as expected");
		}else {
			System.out.println("Message is not as expected");
		}
	}
	
	static void javascriptPrompt(WebDriver driver) {
		System.out.println("Step 10: Click on Javascript Prompt");
		driver.findElement(By.xpath("//button[text()='Javascript Prompt']")).click();
		Alert alert=driver.switchTo().alert();
		System.out.println(alert.getText());
		System.out.println("Step 11: Enter the name");
		String name="Elizabeth";
		alert.sendKeys(name);
		System.out.println("Step 12: Click on OK");
		alert.accept();
		
		WebElement element =driver.findElement(By.xpath("//p[@id='pgraphdemo']"));
		String actualMessage=element.getText();
		System.out.println(actualMessage);
		String expectedMessage="Hello "+name+"! How are you today?";
		
		System.out.println("Step 13: Verify the message after clicking on Ok");
		if(actualMessage.equals(expectedMessage)) {
			System.out.println("Message is as expected");
		}else {
			System.out.println("Message is not as expected");
		}
		
		System.out.println("Step 14: Click on Javascript Prompt again");
		driver.findElement(By.xpath("//button[text()='Javascript Prompt']")).click();
		Alert alert2=driver.switchTo().alert();
		System.out.println("Step 15: Click on Cancel without entering the name");
		alert2.dismiss();
		
		WebElement element2 =driver.findElement(By.xpath("//p[@id='pgraphdemo']"));
		String actualMessage2=element2.getText();
		System.out.println(actualMessage2);
		String expectedMessage2="User cancelled the prompt.";
		
		System.out.println("Step 16: Verify the message after clicking on Cancel");
		if(actualMessage2.equals(expectedMessage2)) {
			System.out.println("Message is as expected");
		}else {
			System.out.println("Message is not as expected");
		}
	}
	
	static void alertDemo(WebDriver driver) {
		System.out.println("Step 17: Enter the First Name");
		String firstName="Elizabeth";
		String lastName="Mary";
		String companyName="Deloitte";
		driver.findElement(By.xpath("//input[@name='ufname']")).sendKeys(firstName);
		System.out.println("Step 18: Enter the Last Name");
		driver.findElement(By.xpath("//input[@name='ulname']")).sendKeys(lastName);
		System.out.println("Step 19: Enter the Company Name");
		driver.findElement(By.xpath("//input[@name='cmpname']")).sendKeys(companyName);
		System.out.println("Step 20: Click on Submit");
		driver.findElement(By.xpath("//button[@onclick='myFunctionPopUp()']")).click();
		
		Alert alert=driver.switchTo().alert();
		String actualText=alert.getText();
		System.out.println(actualText);
		String expectedText= firstName+" and "+lastName+" and "+companyName;
		
		System.out.println("Step 21: Verfy the text in the pop up");
		if(actualText.equals(expectedText)) {
			System.out.println("Text is as expected");
		}else {
			System.out.println("Text is not as expected");
		}
		
		alert.accept();
	}
	
		static void basicForms(WebDriver driver) {
			System.out.println("Step 22: Enter the email address");
			driver.findElement(By.xpath("//input[@name='emailId']")).sendKeys("elizz@test.com");
			System.out.println("Step 23: Enter the password");
			driver.findElement(By.xpath("//input[@id='pwd']")).sendKeys("password");
			System.out.println("Step 24: Click on Submit");
			driver.findElement(By.xpath("//button[@id='submitb2']")).click();
			
			System.out.println("Step 25: Verify the text in the pop up");
			Alert alert=driver.switchTo().alert();
			String actualText=alert.getText();
			System.out.println(actualText);
			String expectedText="You successfully clicked on it";
			
			if(actualText.equals(expectedText)) {
				System.out.println("Text is as expected");
			}else {
				System.out.println("Text is not as expected");
			}
			
		}
	
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = PredefinedActions.start();
		Thread.sleep(5000);
		System.out.println("Step 1: Click on Basic Elements");
		driver.findElement(By.linkText("Basic Elements")).click();
		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)");
		Thread.sleep(3000);
		Assignment5.verifyAlert(driver);
		Assignment5.javascriptConfirmation(driver);
		Assignment5.javascriptPrompt(driver);
		Assignment5.alertDemo(driver);
		Assignment5.basicForms(driver);
	}
}
