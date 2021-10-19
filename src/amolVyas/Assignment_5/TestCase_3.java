package amolVyas.Assignment_5;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class TestCase_3 {

	void clickAlertAndVerifyMesage(String alertOkCancel) throws InterruptedException {
		WebDriver driver = Action.start();
		System.out.println("STEP-Navigate to Basic Element Page");
		driver.findElement(By.xpath("//a[text()='Basic Elements']")).click();
		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)");
		System.out.println("STEP-Click on JavaScript confirmation button");
		driver.findElement(By.xpath("//button[@id='javascriptConfirmBox']")).click();
		Alert alert = driver.switchTo().alert();
		System.out.println("STEP-Verify Alert popup is coming with the message");
		if (alertOkCancel.equals("Accept")) {
			System.out.println("STEP-Click on Ok Alert");
			alert.accept();
			String actualAcceptedText = driver.findElement(By.xpath("//p[@id='pgraphdemo']")).getText();
			if (actualAcceptedText.equals("You pressed OK!"))
				System.out.println("STEP-Accept Message Verification Sucessfully");
		} else {
			alert.dismiss();
			System.out.println("STEP-Click on Cancel Alert");
			String actualAcceptedText = driver.findElement(By.xpath("//p[@id='pgraphdemo']")).getText();
			if (actualAcceptedText.equals("You pressed Cancel!"))
				System.out.println("STEP-Cancel Message Verification Sucessfully");
		}
		driver.close();
		System.out.println("Test Case Pass");
	}

	public static void main(String[] args) throws InterruptedException {
		new TestCase_3().clickAlertAndVerifyMesage("Accept");
		new TestCase_3().clickAlertAndVerifyMesage("Cancel");
	}

}
