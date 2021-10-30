package swati.Assignment6;

/*
Selenium Assignment-6 : 19th Oct’2021

Goto AutomationByKrishna
Navigate to Basic Element tab
There is `Open Multiwindow` option try to handle that scenario

*/

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment6 {
	
	void verfiyMultiwindow() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./resources/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		System.out.println("Enter URL");
		driver.get("http://automationbykrishna.com/#");
		driver.manage().window().maximize();
		System.out.println("Enter on Basic Element");
		driver.findElement(By.xpath("//a[@id='basicelements']")).click();
		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)");
		System.out.println("Click on Multiwindow Button");
		driver.findElement(By.xpath("//button[@id='javascriptMultiWindow']")).click();
		String mainWindow=driver.getWindowHandle();
		Set <String> allWindowList=driver.getWindowHandles();
		//System.out.println(mainWindow);
		////System.out.println(allWindowList);
		allWindowList.remove(mainWindow);
		//System.out.println(allWindowList);
		System.out.println("Close Window");
		for(String element:allWindowList) {
			System.out.println("Window "+element+" Closed");
			driver.switchTo().window(element);
			driver.close();
		}
		System.out.println("Switch Back to main window "+mainWindow);
		driver.switchTo().window(mainWindow);
		driver.close();
		System.out.println("TestCase 6 Pass");
	}

	public static void main(String[] args) throws InterruptedException {
		Assignment6 a6=new Assignment6();
		a6.verfiyMultiwindow();
		
	}
}

