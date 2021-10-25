/*Selenium Assignment-6 : 19th Oct’2021

Goto AutomationByKrishna
Navigate to Basic Element tab
There is `Open Multiwindow` option try to handle that scenario
*/
package husain.Assignment6;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import husain.base.Prerequisites;

public class MultiWindow {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = Prerequisites.start();
		Thread.sleep(3000);
		System.out.println("STEP - Open Chrome Browser");

		System.out.println("STEP - Navigate to Basic Elements screen");
		driver.findElement(By.id("basicelements")).click();
		Thread.sleep(3000);

		System.out.println("STEP - Click on Open Multiwindow button");
		driver.findElement(By.id("javascriptMultiWindow")).click();

		String mainWindow = driver.getWindowHandle();
		Set<String> window = driver.getWindowHandles();

		Iterator<String> itr = window.iterator();

		System.out.println("STEP - Print window ids to the console");
		while (itr.hasNext()) {
			String currentWindow = itr.next();
			System.out.println("Current window " + currentWindow);
			driver.switchTo().window(currentWindow);
			if (!currentWindow.equals(mainWindow)) {
				/*
				 * driver.manage().window().maximize(); System.out.println(driver.getTitle());
				 * System.out.println(driver.findElement(By.xpath("//p")).getText());
				 * System.out.println("STEP - Closing child window");
				 */
				driver.close();
			}

		}
		System.out.println("STEP - Switch to main windw and print id to the console");
		driver.switchTo().window(mainWindow);
		System.out.println("Main window id: " + mainWindow);

		System.out.println("STEP - Close main window");
		driver.close();

	}

}
