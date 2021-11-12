package technocredits.actionsClassExamples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import base.PredefinedActions;

public class ClickAndHoldExample {
	
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = PredefinedActions.start("file:///C:/Users/harsh/Downloads/DragAndDropCircleAngularJS.html");
		
		WebElement draggable = driver.findElement(By.id("draggable"));
		WebElement droptarget = driver.findElement(By.id("droptarget"));
		
		
		Actions action = new Actions(driver);
		action
		.clickAndHold(draggable)// single action
		.moveToElement(droptarget)// single action
		.release()// single action
		.build()
		.perform();
		
		
	}

}
