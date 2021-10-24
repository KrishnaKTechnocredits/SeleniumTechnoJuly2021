/*Selenium Assignment-2 : 19th Oct’2021

Goto AutomationByKrishna
Navigate to Basic Element tab
There is `Open Multiwindow` option try to handle that scenario
 */
package shalakaP.Assignment6;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import base.PredefinedActions;

public class MultiWindow {

	void prog1() throws InterruptedException {
		WebDriver driver = PredefinedActions.start();
		System.out.println("Step- Click on Basic Elements");
		driver.findElement(By.id("basicelements")).click();
		Thread.sleep(3000);
		WebElement element = driver.findElement(By.id("javascriptMultiWindow"));
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("arguments[0].scrollIntoView(true)", element);
		element.click();

		String mainWindow = driver.getWindowHandle();
		System.out.println("Step-Get session id of main window");
		System.out.println("MainWindow:" + mainWindow);

		System.out.println("Step-Close current  session window");
		Set<String> multiWindow = driver.getWindowHandles();
		Iterator<String> itr = multiWindow.iterator();
		while (itr.hasNext()) {
			String window = itr.next();
			if (!(mainWindow.equals(window))) {
				System.out.println("Closewin:" + window);
				driver.switchTo().window(window);
				driver.close();
			}
		}
		System.out.println("Step-Switch to main window");
		driver.switchTo().window(mainWindow);
		System.out.println("Title:" + driver.getTitle());
		System.out.println("Step-Test passed successfully");

	}

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		new MultiWindow().prog1();
	}

}
