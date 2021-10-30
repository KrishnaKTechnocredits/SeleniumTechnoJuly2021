/*Goto AutomationByKrishna
Navigate to Basic Element tab
There is Open Multiwindow` option try to handle that scenario*/

package vivek;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment06 {

	static WebDriver openBrowser(String url) {
		System.setProperty("webdriver.chrome.driver", "./resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
		return driver;
	}

	static void multiWindowHandle() throws InterruptedException {
		System.out.println("Step 1: open the browser");
		WebDriver driver = openBrowser("http://automationbykrishna.com/");
		System.out.println("Step 2: Navigate to Basic Elements tab");
		driver.findElement(By.linkText("Basic Elements")).click();
		Thread.sleep(2000);
		System.out.println("Step 3: Click on open MultiWindow in the alerts section");
		driver.findElement(By.id("javascriptMultiWindow")).click();
		System.out.println("Step 4: Get the main window session id");
		String mainWindow = driver.getWindowHandle();
		System.out.println(mainWindow);
		System.out.println("Step 5: Get all window session id");
		Set<String> allWindow = driver.getWindowHandles();
		System.out.println(allWindow);
		System.out.println("Step 6: Close newly opened windows");
		Iterator<String> itr = allWindow.iterator();
		while (itr.hasNext()) {
			String currentWindow = itr.next();
			if (!currentWindow.equals(mainWindow)) {
				driver.switchTo().window(currentWindow);
				driver.close();
			}
		}
		System.out.println("Step 7: Get the title of main window");
		driver.switchTo().window(mainWindow);
		System.out.println(driver.getTitle());
	}

	public static void main(String[] args) throws InterruptedException {
		multiWindowHandle();
	}
}
