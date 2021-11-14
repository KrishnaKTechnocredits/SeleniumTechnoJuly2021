package suruchi;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import base.PredefinedActions;

public class Assignment6 {

	void multiWindowHandle() throws InterruptedException {
		WebDriver driver = PredefinedActions.start();

		Thread.sleep(3000);
		System.out.println("Navigate to Basic Elements tab");
		driver.findElement(By.linkText("Basic Elements")).click();

		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)");

		String mainWindow = driver.getWindowHandle();
		System.out.println("Main Window Session ID: " + mainWindow);

		Thread.sleep(2000);
		System.out.println("Click on Open MultiWindow option");
		driver.findElement(By.id("javascriptMultiWindow")).click();

		Set<String> multiWindow = driver.getWindowHandles();
		System.out.println("Multi Window IDs: " + multiWindow);

		Iterator<String> itr = multiWindow.iterator();

		while (itr.hasNext()) {
			String currentWindow = itr.next();
			if (!currentWindow.equals(mainWindow)) {
				System.out.println("Close Window: " + currentWindow);
				driver.switchTo().window(currentWindow);
				Thread.sleep(2000);
				driver.close();
			}
		}

		System.out.println("Switch to main window");
		driver.switchTo().window(mainWindow);
		System.out.println("Window Title: " + driver.getTitle());

		driver.close();

		System.out.println("Test Case passed");
	}

	public static void main(String[] args) throws InterruptedException {
		new Assignment6().multiWindowHandle();
	}
}