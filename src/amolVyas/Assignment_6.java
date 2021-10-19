package amolVyas;

import java.util.Set;

import javax.swing.text.html.HTMLDocument.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment_6 {

	void handleWindows() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		System.out.println("STEP-Open Chrome Browser");
		driver.manage().window().maximize();
		System.out.println("STEP-Open Given URL");
		driver.get("http://automationbykrishna.com/index.html#");
		System.out.println("STEP-Navigate to Basic Elements");
		driver.findElement(By.xpath("//a[text()='Basic Elements']")).click();
		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)");
		driver.findElement(By.xpath("//button[@id='javascriptMultiWindow']")).click();
		System.out.println("STEP-Get session id of main window");
		String mainWindow = driver.getWindowHandle();
		System.out.println("STEP-Get session id of all window");
		Set<String> allWindow = driver.getWindowHandles();
		allWindow.remove(mainWindow);
		for (String session : allWindow) {
			if (!session.equals(mainWindow)) {
				System.out.println("STEP-Removing extra window: " + session);
				driver.switchTo().window(session);
				driver.close();
			}
			System.out.println("STEP-Navigating to main window");
			driver.switchTo().window(mainWindow);
			driver.close();
			System.out.println("STEP-Test Case PASSED");
		}

	}

	public static void main(String[] args) throws InterruptedException {
		new Assignment_6().handleWindows();
	}

}
