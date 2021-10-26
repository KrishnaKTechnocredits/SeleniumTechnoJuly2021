package madhavi;
//Yahoo Signup

//https://login.yahoo.com/account/create?specId=yidReg

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import base.PredefinedActions;

public class Assignment_4 {
	void yahooSignUp() throws InterruptedException {
		System.out.println("Step 1 - Open Yahoo URL ");
		WebDriver driver = PredefinedActions.start("https://login.yahoo.com/account/create?specId=yidReg");
		Thread.sleep(1000);

		System.out.println("Step 2 : Enter First Name");
		driver.findElement(By.xpath("//input[@name = 'firstName']")).sendKeys("Mayuri");

		System.out.println("Step 3 : Enter Last Name");
		driver.findElement(By.xpath("//input[@name = 'lastName']")).sendKeys("Rao");

		System.out.println("Step 4 : Enter Email");
		driver.findElement(By.xpath("//input[@name = 'yid']")).sendKeys("Mayuri_Rao0123");

		System.out.println("Step 5 : Enter Password");
		driver.findElement(By.xpath("//input[@name = 'password']")).sendKeys("MRaoooo@123$");

		System.out.println("Step 6 : Enter Mobile Number");
		driver.findElement(By.xpath("//input[@name='phone']")).sendKeys("8934123456");

		System.out.println("Step 7 : Enter Birth Month");
		WebElement birthMonthElement = driver.findElement(By.xpath("//select[@name='mm']"));
		Select birthMonth = new Select(birthMonthElement);
		birthMonth.selectByVisibleText("November");

		System.out.println("Step 8 : Enter Birth Date");
		driver.findElement(By.xpath("//input[@name='dd']")).sendKeys("15");

		System.out.println("Step 9 : Enter Birth Year");
		driver.findElement(By.xpath("//input[@name='yyyy']")).sendKeys("2000");

		System.out.println("Step 10 : Enter Gender");
		driver.findElement(By.xpath("//input[@name='freeformGender']")).sendKeys("Others");

		System.out.println("Step 8- Locate Continue button");
		driver.findElement(By.xpath("//button[@name='signup']"));
		Thread.sleep(6000);

		// driver.close();
		System.out.println("Test passed successfully");

	}

	public static void main(String[] args) throws InterruptedException {
		new Assignment_4().yahooSignUp();

	}
}
