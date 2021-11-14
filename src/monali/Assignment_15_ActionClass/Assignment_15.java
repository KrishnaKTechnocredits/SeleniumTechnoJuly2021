package monali.Assignment_15_ActionClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.PredefinedActions;

public class Assignment_15 {
	
	@Test
	public void mouseHoverAction() throws InterruptedException {
		System.out.println("Launch Flipkart URL");
		WebDriver driver = PredefinedActions.start("https://www.flipkart.com/");
		System.out.println("STEP : Close login Screen");
		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();

		Thread.sleep(3000);
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//div[text()='Home']"))).perform();
		action.moveToElement(driver.findElement(By.xpath("//a[text()='Living Room']"))).build().perform();
		int listOfLivingRoomElements = driver
				.findElements(By.xpath("//span[text()='more in Living Room']/parent::div/a")).size();

		int expectedCount = 13;
		Assert.assertEquals(listOfLivingRoomElements, expectedCount, "Count mismatch");

		action.moveToElement(driver.findElement(By.xpath("//a[text()='Dining Sets']"))).click().build().perform();
		System.out.println("Dining set item is clicked");
	}

}



