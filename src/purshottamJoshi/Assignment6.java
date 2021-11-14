/*Selenium Assignment-6 : 19th Oct’2021

Goto AutomationByKrishna
Navigate to Basic Element tab
There is `Open Multiwindow` option try to handle that scenario*/


package purshottamJoshi;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import base.PredefinedActions;

public class Assignment6 {

	void handleMultiWindow() throws InterruptedException {
		System.out.println("STEP - Launch automation by krishna website");
		WebDriver driver = PredefinedActions.start();
		Thread.sleep(3000);
		System.out.println("STEP - Click on basic elements");
		driver.findElement(By.xpath("//a[@id='basicelements']")).click();
		Thread.sleep(3000);
		System.out.println("STEP -  Click on open MultiWindow Button");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(10,300)");
		driver.findElement(By.xpath("//button[@id='javascriptMultiWindow']")).click();
		System.out.println("STEP-Get session id of main window");
		String currentWindow = driver.getWindowHandle();
		Set<String> allwindows = driver.getWindowHandles();
		
		for(String window : allwindows) {
			if(!window.equals(currentWindow)) {
				System.out.println("STEP - Switch to open window ");
				driver.switchTo().window(window);
				System.out.println(driver.getWindowHandle());
				driver.close();
			}
		}
		
		System.out.println("Step5: Switch to original window");
		driver.switchTo().window(currentWindow);
		System.out.println(driver.getWindowHandle());
		driver.close();
		System.out.println("Test case passed");
		
	}
	public static void main(String[] args) throws InterruptedException {
		new Assignment6().handleMultiWindow();
	}
}
