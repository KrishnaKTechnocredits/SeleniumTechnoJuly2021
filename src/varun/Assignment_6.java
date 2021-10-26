package varun;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment_6 {
	void handleMultiWindow() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		System.out.println("STEP-Open Chrome Browser");
		driver.manage().window().maximize();
		System.out.println("STEP-Open Given URL");
		driver.get("http://automationbykrishna.com/index.html#");
		System.out.println("STEP-Navigate to Basic Elements");
		driver.findElement(By.id("basicelements")).click();
		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)");

		System.out.println("Click on Open MultiWindow");
		driver.findElement(By.id("javascriptMultiWindow")).click();
		String currentwindow = driver.getWindowHandle();
		System.out.println("Please get the session ID");
		Set<String> allWindow = driver.getWindowHandles();
		allWindow.remove(currentwindow);

		for (String session : allWindow) {
			if (!session.equals(currentwindow)) {
				System.out.println("STEP-Removing extra window: " + session);
				driver.switchTo().window(session);
				driver.close();
			}
			System.out.println("STEP-Navigating to main window");
			driver.switchTo().window(currentwindow);
			driver.close();
			System.out.println("STEP-Test Case PASSED");
		}

	}
	public static void main(String[] args) throws InterruptedException{
		Assignment_6 assignment_6 = new Assignment_6();
		assignment_6.handleMultiWindow();
	}
}
