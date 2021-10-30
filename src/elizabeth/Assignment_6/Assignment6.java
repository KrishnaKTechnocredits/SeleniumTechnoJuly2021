package elizabeth.Assignment_6;

import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import base.PredefinedActions;

public class Assignment6 {
	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = PredefinedActions.start();
		Thread.sleep(5000);
		System.out.println("Step 3: Click on Basic Elements button");
		driver.findElement(By.xpath("//a[text()='Basic Elements']")).click();
		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)");
		System.out.println("Step 4: Click on Open Multiwindow");
		driver.findElement(By.xpath("//button[text()='Open MultiWindow']")).click();
		Set<String> multiWin= driver.getWindowHandles();
		String mainWindow= driver.getWindowHandle();
		System.out.println("Main Window ID" + mainWindow);
		System.out.println("Multi Window ID" +multiWin);
		Thread.sleep(5000);
		System.out.println("Step 5: Close the Open Multiwindow alone without closing the main window");
		Iterator<String> itr =multiWin.iterator();
		while(itr.hasNext()){
			String currentWindow=itr.next();
			if(!currentWindow.equals(mainWindow)) {
				driver.switchTo().window(currentWindow);
				System.out.println("Current Window ID:" +currentWindow);
				driver.close();
			}
		}
		System.out.println("Step 6: Script Executed Successfully");
		
	}

}
