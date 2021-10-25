package monikaZ;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment_6 {

	void handleMultiWindows() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./resources/chromedriver.exe");
		System.out.println("Step- Open Chrome Browser");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		System.out.println("Step- Enter URL");
		driver.navigate().to("http://automationbykrishna.com/#");
		
		Thread.sleep(3000);
		System.out.println("Step- Click on Basic Elements Link");
		driver.findElement(By.xpath("//a[contains(text(),'Basic Elements')]")).click();
		
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)");
		driver.findElement(By.xpath("//button[@id='javascriptMultiWindow']")).click();
		System.out.println("Step- Get Session ID of main Window");
		String mainWindow = driver.getWindowHandle();
		
		System.out.println("Step- Get session id of All Window");
		Set<String> allWindow = driver.getWindowHandles();
		allWindow.remove(mainWindow);
		for (String session : allWindow) {
			if (!session.equals(mainWindow)) {
				System.out.println("Step- Removing Extra Window: " + session);
				driver.switchTo().window(session);
				driver.close();
			}
			System.out.println("Step- Navigating to Main Window");
			driver.switchTo().window(mainWindow);
			
			driver.close();
			System.out.println("Step- Test Passed Sucessfully");
		}
	}
	public static void main(String[] args) throws InterruptedException {
		new Assignment_6().handleMultiWindows();
	}
}
