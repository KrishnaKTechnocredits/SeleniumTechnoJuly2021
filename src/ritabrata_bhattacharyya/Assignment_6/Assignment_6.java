package ritabrata_bhattacharyya.Assignment_6;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import priti.Assingment_6.Assingment_6;

public class Assignment_6 {
	
	void handleExtraWindows() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		System.out.println("STEP1-Open Chrome Browser");
		driver.manage().window().maximize();
		
		System.out.println("STEP2-Open Given URL");
		driver.get("http://automationbykrishna.com/index.html#");
		
		System.out.println("STEP3-Navigate to Basic Elements");
		//driver.findElement(By.xpath("//a[text()='Basic Elements']")).click();
		driver.findElement(By.xpath("//a[@id ='basicelements']")).click();
		Thread.sleep(4000);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)");
		
		driver.findElement(By.xpath("//button[@id='javascriptMultiWindow']")).click();

		
		System.out.println("STEP4-Get session id of main window");
		String mainWindow = driver.getWindowHandle();
		System.out.println("STEP5-Get session id of all window");
		Set<String> allWindow = driver.getWindowHandles();
		allWindow.remove(mainWindow);
		for (String sessionWindow:allWindow)
			if (!sessionWindow.equals(mainWindow)) {
				System.out.println("STEP6-Remove extra windows: " + sessionWindow);
				driver.switchTo().window(sessionWindow);
				driver.close();
			}
			System.out.println("STEP7-Navigate to main window " + mainWindow);
			driver.switchTo().window(mainWindow);
			driver.close();
			System.out.println("Test_6 executed and passed successfully.");
	}
	public static void main(String[] args) throws InterruptedException {
		new Assingment_6().handleExtraWindows();
	}
}

