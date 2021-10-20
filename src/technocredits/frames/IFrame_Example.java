package technocredits.frames;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.PredefinedActions;

public class IFrame_Example {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = PredefinedActions.start();
		driver.findElement(By.linkText("IFrame Demo")).click();
		Thread.sleep(4000);

		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[3]")));// element
		// driver.switchTo().frame(0); // index
		// driver.switchTo().frame("site1"); // name or id

		Thread.sleep(2000);
		System.out.println(driver.findElement(By.xpath("//h1[@class='title']")).getText());

		driver.switchTo().parentFrame();//automation by krishna
		driver.switchTo().parentFrame();
		//		driver.switchTo().defaultContent();
		
		driver.switchTo().frame(0);
		Thread.sleep(2000);
		System.out.println(driver.findElement(By.xpath("//h1[@class='display-1 mt-0 mt-md-5 pb-1']")).getText());
	}
}
