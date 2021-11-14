package dattaraj_W.Assignment_5;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test_Case4 {
	
	WebDriver driver;
	
	public Test_Case4(String url) {
		System.setProperty("webdriver.chrome.driver", "./resources/chromedriver.exe");
		System.out.println("STEP - Open Chrome Browser");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		System.out.println("STEP - Enter url");
		driver.get(url);
	}
	
	//Test Case-4
	void Case4() throws InterruptedException {
		Thread.sleep(3000);
		System.out.println("STEP- Tap on basic elements");
		driver.findElement(By.xpath("//a[@id='basicelements']")).click();
		//Thread.sleep(3000);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)");
		
		// Accept alert
		System.out.println("STEP- Tap on Javascript Prompt button");
		driver.findElement(By.xpath("//button[@id='javascriptPromp']")).click();
		System.out.println("STEP- Enter name in alert box");
		String name = "Dattaraj Wete";
		driver.switchTo().alert().sendKeys(name);
		System.out.println("STEP- Press okay");
		driver.switchTo().alert().accept();
		System.out.println("STEP- Validate confirmation message in case of okay");
		String expectedConfirmationMessage = "Hello " + name + "! How are you today?";
		String confirmationMessage = driver.findElement(By.xpath("//p[contains(text(), 'Hello')]")).getText();
		if(confirmationMessage.equals(expectedConfirmationMessage))
			System.out.println("Confirmation message match");
		else
			System.out.println("Confirmation message not match");
		
		//Dismiss alert
		System.out.println("STEP- Tap on Javascript Prompt button");
		driver.findElement(By.xpath("//button[@id='javascriptPromp']")).click();
		System.out.println("STEP- Press cancel");
		driver.switchTo().alert().dismiss();
		System.out.println("STEP- Validate confirmation message in case of cancel");
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
		// TODO Auto-generated method stub
		String url= "http://automationbykrishna.com/#";
		new Test_Case4(url).Case4();
	}

}
