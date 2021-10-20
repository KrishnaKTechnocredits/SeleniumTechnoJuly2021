package technocredits.findElementExamples;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import base.PredefinedActions;

public class FindElementExample {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = PredefinedActions.start();
		Thread.sleep(2000);
		driver.findElement(By.id("registration2")).click();
		Thread.sleep(2000);
		List<WebElement> list = driver.findElements(By.xpath("//input[@type='text']"));
		System.out.println("Total Element : " + list.size());
//		list.get(0).sendKeys("Hi");
	}

}
