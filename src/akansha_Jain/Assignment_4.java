/* Assignment - 4: 16th Oct'2021

Yahoo Signup.
https://login.yahoo.com/account/create?specId=yidReg */

package akansha_Jain;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment_4 {

	void yahooSignup() throws InterruptedException {
		System.out.println("STEP- Open chrome browser");
		System.setProperty("webdriver.chrome.driver",
				"//Users//punchh_akansha//eclipse-workspace//Java_Techno_Selenium_2021//resources//chromedriver");
		WebDriver driver = new ChromeDriver();

		System.out.println("STEP- Open URL");
		driver.get("https://login.yahoo.com/account/create?specId=yidReg");
		Thread.sleep(3000);

		System.out.println("STEP- Enter first name");
		driver.findElement(By.name("firstName")).sendKeys("Akansha");

		System.out.println("STEP- Enter last name");
		driver.findElement(By.name("lastName")).sendKeys("Jain");

		System.out.println("STEP- Enter email address");
		driver.findElement(By.name("yid")).sendKeys("goyanka.akku0609");

		System.out.println("STEP- Enter password");
		driver.findElement(By.name("password")).sendKeys("Password@123@123");

		System.out.println("STEP- Enter mobile number");
		driver.findElement(By.name("phone")).sendKeys("9887001221");

		System.out.println("STEP- Enter DOB");
		System.out.println("Enter Month");
		WebElement bdayElement1 = driver.findElement(By.xpath("//select[@name='mm']"));
		Select bdaySelect1 = new Select(bdayElement1);
		bdaySelect1.selectByValue("9");

		System.out.println("Enter Day");
		driver.findElement(By.name("dd")).sendKeys("6");

		System.out.println("Enter Year");
		driver.findElement(By.name("yyyy")).sendKeys("1991");

		System.out.println("STEP- Enter gender");
		driver.findElement(By.name("freeformGender")).sendKeys("Female");
		Thread.sleep(5000);

		driver.close();
		driver.quit();
	}

	public static void main(String[] args) throws InterruptedException {
		new Assignment_4().yahooSignup();
	}
}