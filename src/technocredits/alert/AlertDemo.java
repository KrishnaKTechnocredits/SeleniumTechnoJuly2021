package technocredits.alert;

import java.util.ListIterator;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.PredefinedActions;

// JavaScript Based Alert
// We cant inspect them, they are blocking in nature.
// It has to be handled we interact with any other element.

public class AlertDemo {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = PredefinedActions.start();
		System.out.println("STEP - Click on Registration menu");
		driver.findElement(By.linkText("Registration")).click();
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='unameSignin']")).sendKeys("mkanani");
		driver.findElement(By.xpath("//input[@id='pwdSignin']")).sendKeys("mkanani1234");
		driver.findElement(By.xpath("//button[@id='btnsubmitdetails']")).click();
		
		Alert alert = driver.switchTo().alert();
		String text = alert.getText();
		alert.accept();
		
		if(text.equals("Success!"))
			System.out.println("Test pass");
		else
			System.out.println("Test fail");
		
		driver.findElement(By.xpath("//input[@id='unameSignin']")).clear();
		
		driver.switchTo().alert();
	}
}
