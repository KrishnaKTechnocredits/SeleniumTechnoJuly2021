/*
Assignment 15 : Actions class
Steps
1. Navigate to to flipkart
2. Mouse hover on `Home`
3. Mouse hover Under Living Room section 
4. Click on `Blanket` or `any other option`
 */
package umakant;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import base.PredefinedActions;

public class Assignment15 {
	
	@Test
	void navigateToSofaBeds() {
		WebDriver driver = PredefinedActions.start("https://www.flipkart.com/");
		WebDriverWait wait = new WebDriverWait(driver,30);
		driver.findElement(By.xpath("//button[text()='✕']")).click();
		WebElement elemHome = driver.findElement(By.xpath("//div[@class='xtXmba' and text()='Home']"));
		Actions action = new Actions(driver);
		action.moveToElement(elemHome)
		.build()
		.perform();
		WebElement elemLivingRoom = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[text()='Living Room']"))));
		action.moveToElement(elemLivingRoom)
		.perform();
		WebElement elemSofaBeds = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[text()='Sofa Beds']"))));
		action.click(elemSofaBeds)
		.perform();
	}

}
