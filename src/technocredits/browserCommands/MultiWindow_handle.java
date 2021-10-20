package technocredits.browserCommands;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import base.PredefinedActions;

public class MultiWindow_handle {

	public static void main(String[] args) {
		WebDriver driver = PredefinedActions.start("https://www.naukri.com/");

		String mainWin = driver.getWindowHandle();
		System.out.println("Main Window ID : " + mainWin);
		Set<String> multiWin = driver.getWindowHandles();
		System.out.println("Multi Window : " + multiWin);

		Iterator<String> itr = multiWin.iterator();

		while (itr.hasNext()) {
			String curretnWin = itr.next();
			if (!curretnWin.equals(mainWin)) {
				System.out.println("Close Window : " + curretnWin);
				driver.switchTo().window(curretnWin);
				try {
					driver.findElement(By.xpath(""));
				} catch (Exception r) {

				}
				driver.close();
			}
		}
		driver.switchTo().window(mainWin);
		System.out.println("Title : " + driver.getTitle());

//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeAsyncScript("window.scrollBy(0,300)");

	}
}
