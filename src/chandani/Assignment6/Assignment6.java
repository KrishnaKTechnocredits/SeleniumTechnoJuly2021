package chandani.Assignment6;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment6 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("http://automationbykrishna.com/#");
		
		Thread.sleep(3000);
		driver.manage().window().maximize();
		System.out.println("STEP - Click on Basic Elements Link");
		driver.findElement(By.linkText("Basic Elements")).click();
		
		Thread.sleep(3000);
		
		System.out.println("STEP- Scroll down");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)");
		
		System.out.println("STEP - Click on Open Multi Window Button");
		driver.findElement(By.xpath("//button[@id=\"javascriptMultiWindow\"]")).click();
		
		Thread.sleep(3000);
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
	}
}
