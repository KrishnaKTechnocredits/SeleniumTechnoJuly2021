package technocredits.webElementCommands;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import base.PredefinedActions;

public class Enable_And_Disabled{

	public static void main(String[] args) {
		WebDriver driver = PredefinedActions
				.start("file:///D:/TechnoCredits/Selenium%20Dos/html%20form/Hidden_&_Enabled.html");
		WebElement textArea = driver.findElement(By.xpath("//input[@id='myText']"));
		System.out.println("Before click : " + textArea.isEnabled());
		driver.findElement(By.xpath("//button[text()='Enable & Disable Button']")).click();
		System.out.println("After click : " + textArea.isEnabled());
		textArea.sendKeys("techno");
	}
}
