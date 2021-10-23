package technocredits.webElementCommands;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import base.PredefinedActions;

public class Visible_And_Hidden {

	public static void main(String[] args) {
		WebDriver driver = PredefinedActions
				.start("file:///D:/TechnoCredits/Selenium%20Dos/html%20form/Hidden_&_Enabled.html");

		WebElement visibleText = driver.findElement(By.xpath("//div[contains(@id,'DIV')]"));
		System.out.println("Before click :" + visibleText.isDisplayed());
		driver.findElement(By.xpath("//button[text()='Visiable & Hidden Button']")).click();
		System.out.println("After click :" + visibleText.isDisplayed());

		visibleText.sendKeys("hi");

	}
}
