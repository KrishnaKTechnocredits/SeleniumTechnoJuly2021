package margi.Assignment_6;

import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/*Goto AutomationByKrishna
Navigate to Basic Element tab
There is 'Open Multiwindow' option try to handle that scenario*/

public class Assignment_6 {

	void testCase() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","resources/chromedriver.exe");
		System.out.println("STEP : Launch browser");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("http://automationbykrishna.com/#");

		System.out.println("STEP : Click on Basic Elements");
		driver.findElement(By.xpath("//a[contains(text(),'Basic Elements')]")).click();

		Thread.sleep(3000);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)");

		System.out.println("STEP : Click on Open Multiwindow");
		driver.findElement(By.xpath("//button[@id='javascriptMultiWindow']")).click();

		Thread.sleep(3000);

		String mainWindow = driver.getWindowHandle();
		Set<String> set = driver.getWindowHandles();
		Iterator<String> itr = set.iterator();
		while (itr.hasNext()) {
			String currentWindow = itr.next();
			if (!mainWindow.equals(currentWindow)) {
				driver.switchTo().window(currentWindow);
				driver.close();
			}
		}

		driver.switchTo().window(mainWindow);
		Thread.sleep(1000);

		System.out.println("Test passed successfully");
		driver.close();
	}

	public static void main(String[] args) throws InterruptedException {
		new Assignment_6().testCase();
	}
}
