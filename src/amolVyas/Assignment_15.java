package amolVyas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import amolVyas.Assignment_5.Action;

public class Assignment_15 {

	
	int getCountOfItemsUnderHome() throws InterruptedException {
		int count=0;
		WebDriver driver = Action.start("https://www.flipkart.com/");
		driver.findElement(By.xpath("//button[text()='✕']")).click();
		Thread.sleep(3000);
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//*[text()='Home']"))).perform();
		action.moveToElement(driver.findElement(By.xpath("//a[text()='Living Room']"))).perform();
		count = driver.findElements(By.xpath("//span[text()='more in Living Room']/parent::div/a")).size();
		driver.quit();
		return count;
	}
		@Test
		void verifyCountOfItems() throws InterruptedException {
			Assert.assertEquals(getCountOfItemsUnderHome(), 13);
			
		

	}

}
