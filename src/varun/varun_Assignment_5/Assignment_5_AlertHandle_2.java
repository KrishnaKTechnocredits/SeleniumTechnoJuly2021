package varun.varun_Assignment_5;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import base.PredefinedActions;

public class Assignment_5_AlertHandle_2 {
	WebDriver driver = PredefinedActions.start("http://automationbykrishna.com/");

	void alertTab() throws InterruptedException {
		driver.findElement(By.xpath("//a[@id='basicelements']")).click();
		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)");
		driver.findElement(By.xpath("//div[@class='panel-body']/button[@class='btn btn-success']")).click();
		Alert alert = driver.switchTo().alert();
		String successText = alert.getText();
		alert.accept();

		if (successText.equals("You must be TechnoCredits student!!"))
			System.out.println("Test Case passed");
		else
			System.out.println("Test Case Failed. Please handle alert carefully");
	}
	public static void main(String[] args) throws InterruptedException {
		Assignment_5_AlertHandle_2 assignment_5_AlertHandle_2 = new Assignment_5_AlertHandle_2();
		assignment_5_AlertHandle_2.alertTab();
	}
}
