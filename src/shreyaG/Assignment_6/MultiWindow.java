package shreyaG.Assignment_6;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class MultiWindow {
	void multiWindow() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./resources/chromedriver.exe");
		System.out.println("Launch the browser");
		WebDriver driver =new ChromeDriver();
		System.out.println("Enter the URL");
		driver.get("http://automationbykrishna.com");
		driver.manage().window().maximize();
		
		System.out.println("Click on basic element");
		driver.findElement(By.linkText("Basic Elements")).click();
		Thread.sleep(3000);
		
		System.out.println("Click on multiwindow button");
		driver.findElement(By.xpath("//button[@id='javascriptMultiWindow']")).click();
		Thread.sleep(3000);
		
		
		String mainWin=driver.getWindowHandle();
		System.out.println("Main window session id: "+mainWin);
		
		
		Set<String> allWindow=driver.getWindowHandles();
		System.out.println("All window session id: "+allWindow);
		
		Iterator<String> itr=allWindow.iterator();
		while(itr.hasNext()) {
			String currentWindow=itr.next();
			if(!currentWindow.equals(mainWin)) {
				System.out.println("Switch to newly opened window");
				driver.switchTo().window(currentWindow);
				System.out.println("New window id: "+currentWindow);
				
				System.out.println("Close newly open window ");
				driver.close();
			}
		}
		System.out.println("Switch to main window ");
		driver.switchTo().window(mainWin);
		System.out.println("Main window title: "+driver.getTitle());
		
		System.out.println("Close main window ");
		driver.close();
		
	}
	public static void main(String[] args) throws InterruptedException {
		MultiWindow multiWindow=new MultiWindow();
		multiWindow.multiWindow();

	}

}
