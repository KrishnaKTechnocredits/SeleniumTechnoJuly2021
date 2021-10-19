package amolVyas.Assignment_5;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class TestCase_4 {

	void clickAlertAndEnterMessageAndVerifyMesage(String name) throws InterruptedException {
		WebDriver driver = Action.start();
		System.out.println("STEP-Navigate to Basic Element Page");
		driver.findElement(By.xpath("//a[text()='Basic Elements']")).click();
		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)");
		System.out.println("STEP-Click on JavaScript confirmation button");
		driver.findElement(By.xpath("//button[@id='javascriptPromp']")).click();
		Alert alert = driver.switchTo().alert();
		System.out.println("STEP-Verify Alert popup is coming");
		System.out.println("STEP-Enter Name");
		alert.sendKeys(name);
		alert.accept();
		String actualText = driver.findElement(By.xpath("//p[@id='pgraphdemo']")).getText();
		String exepected = "Hello " + name + "! How are you today?";
		if (actualText.equals(exepected))
			System.out.println("STEP-Verification Text matched");
		else
			System.out.println("STEP-Verification Text don't matched");
		driver.close();
		System.out.println("Test Case Pass");
	}

	public static void main(String[] args) throws InterruptedException {
		new TestCase_4().clickAlertAndEnterMessageAndVerifyMesage("Amol");
	}
}