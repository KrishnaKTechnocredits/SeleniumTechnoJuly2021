package umakant.multiWindow;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.PredefinedActions;

public class Assignment6 {

	void getTextFromMultiWindow() throws InterruptedException {
		WebDriver driver = PredefinedActions.start();
		Thread.sleep(3000);
		System.out.println("Step1: Click on Basic Element");
		driver.findElement(By.xpath("//a[@id='basicelements']")).click();
		Thread.sleep(3000);
		System.out.println("Step2: Click on Open MultiWindow");
		driver.findElement(By.xpath("//button[@id='javascriptMultiWindow']")).click();
		System.out.print("Step3: Get the current window ID:");
		String currentWindow = driver.getWindowHandle();
		System.out.println(currentWindow);
		Set<String> openedWindows = driver.getWindowHandles();
		for (String window : openedWindows) {
			if (!window.equals(currentWindow)) {
				System.out.println("Step4: Switch to opened windows");
				driver.switchTo().window(window);
				System.out.println("New window id: " + driver.getWindowHandle());
				driver.close();
			}
		}
		System.out.println("Step5: Switch to original window");
		driver.switchTo().window(currentWindow);
		System.out.println(driver.getWindowHandle());
		driver.close();
	}

	public static void main(String[] args) throws InterruptedException {
		new Assignment6().getTextFromMultiWindow();
	}

}
