package madhavi;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Assignment_5_5 {
	String FirstName = "JOE";
	String LastName = "ASH";
	String CompanyName = "Sigma";

	@Test
	void useCase() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "./resources/chromedriver.exe");
		System.out.println("STEP1 : Launch browser");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("http://automationbykrishna.com/#");
		System.out.println("STEP2 - Click on  Basic Elements tab");
		driver.findElement(By.linkText("Basic Elements")).click();

		Thread.sleep(3000);

		System.out.println("STEP3 - Enter FirstName");
		driver.findElement(By.xpath("//input[@id='UserFirstName']")).sendKeys(FirstName);

		System.out.println("STEP4 - Enter LastName");
		driver.findElement(By.xpath("//input[@id='UserLastName']")).sendKeys(LastName);

		System.out.println("STEP5 - Enter CompanyName");
		driver.findElement(By.xpath("//input[@id='UserCompanyName']")).sendKeys(CompanyName);

		System.out.println("STEP6 : Click Submit button");
		driver.findElement(By.xpath("//button[@onclick='myFunctionPopUp()']")).click();

		Thread.sleep(2000);

		System.out.println("STEP7 - Verify Alert Ok operation");
		verifyAlertAcceptMessage(driver);

		Thread.sleep(3000);

		System.out.println("Test passed successfully");
		driver.close();

	}

	void verifyAlertAcceptMessage(WebDriver driver) {
		Alert alert = driver.switchTo().alert();
		String actualText = alert.getText();
		alert.accept();
		String expectedText = FirstName + " and " + LastName + " and " + CompanyName;
		Assert.assertEquals(actualText, expectedText, "Alter message should be verified as expected.");
	}
}