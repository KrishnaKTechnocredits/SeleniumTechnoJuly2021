/* Assignment-6 : 19th Oct’2021
Goto AutomationByKrishna
Navigate to Basic Element tab
There is `Open Multiwindow` option try to handle that scenario */

package akansha_Jain;

import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment_6 {
	WebDriver driver;
	
	public Assignment_6(String url) {
		System.out.println("STEP- Open chrome browser");
		System.setProperty("webdriver.chrome.driver", "//Users//punchh_akansha//eclipse-workspace//Java_Techno_Selenium_2021//resources//chromedriver");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		System.out.println("STEP- Open URL");
		driver.get(url);
	}
	
	void openMultiWindow() throws InterruptedException {
		Thread.sleep(3000);
		System.out.println("STEP- Tap on basic elements");
		driver.findElement(By.xpath("//a[@id='basicelements']")).click();
		Thread.sleep(3000);
		System.out.println("STEP- Scroll down a little");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)");
		System.out.println("STEP- Tap on Open MultiWindow Button");
		driver.findElement(By.xpath("//button[@id='javascriptMultiWindow']")).click();
		System.out.println("STEP- Get session id of main window");
		String mainWindow = driver.getWindowHandle();
		System.out.println("Session id of main window- " + mainWindow);
		System.out.println("STEP- Get session ids of all windows open on click");
		Set<String> allWindows = driver.getWindowHandles();
		allWindows.remove(mainWindow);
		System.out.println("Session ids of all window- " + allWindows);
		for(String session : allWindows) {
			if(!session.equals(mainWindow)) {
				System.out.println("STEP- Removing extra window");
				driver.switchTo().window(session);
				driver.close();
			}
			System.out.println("STEP- Navigate to main window");
			driver.switchTo().window(mainWindow);
		}
		driver.close();
		driver.quit();
	}

	public static void main(String[] args) throws InterruptedException {
		String url = "http://automationbykrishna.com/index.html#";
		new Assignment_6(url).openMultiWindow();
	}
}