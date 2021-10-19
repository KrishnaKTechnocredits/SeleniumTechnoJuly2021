package husain.Assignments1to4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import husain.base.Prerequisites;

public class Assignment4 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = Prerequisites.start("https://login.yahoo.com/account/create?specId=yidReg");
		System.out.println("STEP - Open Chrome browser");
		Thread.sleep(3000L);

		System.out.println("STEP - Enter First Name");
		driver.findElement(By.id("usernamereg-firstName")).sendKeys("Mikel");

		System.out.println("STEP - Enter Last Name");
		driver.findElement(By.xpath("//input[@name='lastName']")).sendKeys("Arteta");

		System.out.println("STEP - Enter Email");
		driver.findElement(By.xpath("//input[@name='yid']")).sendKeys("m8teta");

		System.out.println("STEP - Enter Password");
		driver.findElement(By.id("usernamereg-password")).sendKeys("Pass=1234");

		System.out.println("STEP - Enter phone number");
		driver.findElement(By.xpath("//input[@name='phone']")).sendKeys("9009012345");

		System.out.println("STEP - Enter Date of Birth");
		Select month = new Select(driver.findElement(By.id("usernamereg-month")));
		month.selectByIndex(5);

		driver.findElement(By.id("usernamereg-day")).sendKeys("12");

		driver.findElement(By.id("usernamereg-year")).sendKeys("1991");

		System.out.println("STEP - Enter Gender");
		driver.findElement(By.className("usernamereg-freeformGender")).sendKeys("Male");
	}

}
