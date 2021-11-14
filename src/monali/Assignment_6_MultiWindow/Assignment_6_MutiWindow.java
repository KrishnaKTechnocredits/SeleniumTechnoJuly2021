package monali.Assignment_6_MultiWindow;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment_6_MutiWindow {

	void multiWindowTC1() throws InterruptedException {
		System.out.println("Step 1: Launch Automation By Krishna Site");
		System.setProperty("webdriver.chrome.driver", "./resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://automationbykrishna.com");
		driver.manage().window().maximize();
		System.out.println("Step 2: Click on Basic Elements tab");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[contains(text(),'Basic Elements')]")).click();
		Thread.sleep(3000);
		System.out.println("Step 3: To scroll down on page");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)");
		System.out.println("Step 4: Click on Open multi window button");
		driver.findElement(By.xpath("//button[@id='javascriptMultiWindow']")).click();

		System.out.println("Step 5: Get the current window ID");
		String mainWindow = driver.getWindowHandle();

		Set<String> allWindow = driver.getWindowHandles();
		Iterator<String> itr = allWindow.iterator();
		while (itr.hasNext()) {
			String window = itr.next();
			if (!window.equals(mainWindow)) {
				System.out.println("Step 6: switch to open window");
				driver.switchTo().window(window);
				System.out.println("New Window id : " + driver.getWindowHandle());
				driver.close();
			}
		}
		System.out.println("Step 7 :Switch to mainWindow");
		driver.switchTo().window(mainWindow);
		System.out.println(driver.getWindowHandle());
		driver.close();
	}

	public static void main(String[] args) throws InterruptedException {
		new Assignment_6_MutiWindow().multiWindowTC1();
	}
}
