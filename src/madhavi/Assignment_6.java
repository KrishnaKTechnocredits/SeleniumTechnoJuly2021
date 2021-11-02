package madhavi;
import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

/*Goto AutomationByKrishna
Navigate to Basic Element tab
There is 'Open Multiwindow' option try to handle that scenario*/

public class Assignment_6 {
	@Test
	void handleWindowPopUP() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./resources/chromedriver.exe");
		System.out.println("STEP1 : Launch browser");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("http://automationbykrishna.com/#");

		System.out.println("STEP2 : Click on Basic Elements");
		driver.findElement(By.xpath("//a[contains(text(),'Basic Elements')]")).click();

		Thread.sleep(3000);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)");

		System.out.println("STEP3 : Click on Open Multiwindow");
		driver.findElement(By.xpath("//button[@id='javascriptMultiWindow']")).click();

		Thread.sleep(3000);

		String mainWindow = driver.getWindowHandle();
		System.out.println("Original Window ID:" + mainWindow);
		Set<String> set = driver.getWindowHandles();
		Iterator<String> itr = set.iterator();
		System.out.println("STEP4 : switch to Opened window");
		while (itr.hasNext()) {
			String currentWindow = itr.next();
			if (!mainWindow.equals(currentWindow)) {
				driver.switchTo().window(currentWindow);
				System.out.println("Current Window ID:" + currentWindow);
				Assert.assertNotEquals(currentWindow, mainWindow, " Both session ID's are different");
				System.out.println("Verification End.");
				driver.close();
			}
		}
		System.out.println("STEP5 : Switch to Original window");
		driver.switchTo().window(mainWindow);
		Thread.sleep(1000);

		System.out.println("Test is passed successfully");
		driver.close();
	}

	/*
	 * public static void main(String[] args) throws InterruptedException { new
	 * Assignment_6().handleWindowPopUP();
	 */
}
