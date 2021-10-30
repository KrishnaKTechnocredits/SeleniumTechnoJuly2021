/*Selenium Assignment-6 : 19th Oct’2021

Goto AutomationByKrishna
Navigate to Basic Element tab
There is `Open Multiwindow` option try to handle that scenario*/

package parthavD;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.PredefinedActions;

public class Assignment6 {
	
	void handleMultiWindow() throws InterruptedException{
		System.out.println("Step1 - Launch Automation by Krishna Webpage");
		WebDriver driver = PredefinedActions.start();
		Thread.sleep(3000);
		System.out.println("Step2 - Click Basic Elements tab");
		driver.findElement(By.xpath("//a[@id='basicelements']")).click();
		Thread.sleep(3000);
		System.out.println("Step3 - Click Open Multiwindow`button");
		driver.findElement(By.xpath("//button[@id='javascriptMultiWindow']")).click();
		String currentWindow = driver.getWindowHandle();
		System.out.println("Step4 - Get session IDs of multiple windows");
		Set<String> wHandles = driver.getWindowHandles();
		System.out.println("Step5 - Switch to the new window");
		String secondWindow = "";
		Iterator<String> itr = wHandles.iterator();
		while(itr.hasNext()){
			String wHandle = itr.next();
			if (!currentWindow.equals(wHandle))
				secondWindow = wHandle;
		}
		driver.switchTo().window(secondWindow);
		System.out.println("Step - Closing the new window");
		driver.close();
		driver.switchTo().window(currentWindow);
		System.out.println("Step7 - Switch back to the primary window");
		System.out.println("Primary window URL: ");
		System.out.println(driver.getCurrentUrl());
		System.out.println("Primary window Title: ");
		System.out.println(driver.getTitle());;
		System.out.println("Test completed successfully");;		
		driver.close();
	}

	public static void main(String[] args) throws InterruptedException {
		new Assignment6().handleMultiWindow();

	}

}
