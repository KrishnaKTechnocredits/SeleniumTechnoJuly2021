package technocredits.actionsClassExamples;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import base.PredefinedActions;

public class DoubleClickExample {
	
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = PredefinedActions.start("http://automationbykrishna.com/#");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebElement home = driver.findElement(By.id("basicelements"));
		home.click();
		WebElement doubleCLick = driver.findElement(By.xpath("//a[text()='Double-click on me']"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true)",doubleCLick);
		
		Actions action = new Actions(driver);
		action
		.doubleClick(doubleCLick)
		.perform();
	}

}
