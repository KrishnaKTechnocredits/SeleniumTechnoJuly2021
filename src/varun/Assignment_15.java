/*Assignment 15 : Actions class
Steps
1. Navigate to to flipkart
2. Mouse hover on `Home`
3. Mouse hover Under Living Room section 
4. Click on `Blanket` or `any other option`*/

package varun;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.PredefinedActions;

public class Assignment_15 {
	
	@Test
	void verifyCountOfDataUnderHome() throws InterruptedException {
		Assert.assertEquals(getNumOfItemsUnderHome(), 13);
	}
	
	int getNumOfItemsUnderHome() throws InterruptedException {
		int count = 0;
		WebDriver driver = PredefinedActions.start("https://www.flipkart.com/");
		driver.findElement(By.xpath("//button[text()='✕']")).click();
		Thread.sleep(3000);
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//div[text()='Home']"))).perform();
		action.moveToElement(driver.findElement(By.xpath("//a[text()='Living Room']"))).perform();
		count = driver.findElements(By.xpath("//a[@class='_6WOcW9 _3YpNQe']")).size();
		driver.close();
		return count;
	}
}
