package technocredits.actionsClassExamples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import base.PredefinedActions;

public class MouseHoverExample {
	
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = PredefinedActions.start("https://www.flipkart.com/");
		Thread.sleep(5000);
		WebElement home = driver.findElement(By.xpath("//*[text()='Home']"));
		
		Actions action = new Actions(driver);
		action
		.moveToElement(home)
		.perform();
	}

}
