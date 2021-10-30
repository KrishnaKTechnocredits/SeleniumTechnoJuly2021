/*Automate Sign up: 
http://automationpractice.com/index.php 
*/

package vivek;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment02 {

	static WebDriver openURL(String url) {
		System.setProperty("webdriver.chrome.driver", "./resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
		return driver;
	}

	static void createAccount() throws InterruptedException {
		System.out.println("STEP - Open the URL in the Chrome Browser");
		WebDriver driver = openURL("http://automationpractice.com/index.php");
		System.out.println("STEP - Click on Sign in button");
		driver.findElement(By.xpath("//a[@title = 'Log in to your customer account']")).click();
		Thread.sleep(3000);
		System.out.println("STEP - Enter the email address and click on create new account");
		driver.findElement(By.name("email_create")).sendKeys("vivek9021655@gmail.com");
		driver.findElement(By.xpath("//i[@class= 'icon-user left']")).click();
		Thread.sleep(5000);
		System.out.println("STEP - Fill the form with required details");
		driver.findElement(By.xpath("//label[@for= 'id_gender1']")).click();
		System.out.println("STEP - Enter firstname, lastname");
		driver.findElement(By.name("customer_firstname")).sendKeys("Vivek");
		driver.findElement(By.name("customer_lastname")).sendKeys("Patil");
		System.out.println("STEP - Enter email");
		driver.findElement(By.id("email")).click();
		System.out.println("STEP - Enter password");
		driver.findElement(By.id("passwd")).sendKeys("vivek123");
		System.out.println("STEP - Enter DOB");
		WebElement dobelement = driver.findElement(By.id("days"));
		Select dayselect = new Select(dobelement);
		dayselect.selectByVisibleText("10  ");

		dobelement = driver.findElement(By.id("months"));
		Select monthselect = new Select(dobelement);
		monthselect.selectByVisibleText("February ");

		dobelement = driver.findElement(By.id("years"));
		Select yearselect = new Select(dobelement);
		yearselect.selectByVisibleText("1993  ");

		System.out.println("STEP - Enter address");
		driver.findElement(By.name("address1")).sendKeys("pune");
		driver.findElement(By.name("city")).sendKeys("pune");

		WebElement state = driver.findElement(By.id("id_state"));
		Select stateselect = new Select(state);
		stateselect.selectByVisibleText("Alabama");

		driver.findElement(By.name("postcode")).sendKeys("00000");
		driver.findElement(By.name("phone_mobile")).sendKeys("65416");
		driver.findElement(By.xpath("//span[text()='Register']")).click();
		Thread.sleep(3000);
	}

	public static void main(String[] args) throws InterruptedException {
		Assignment02.createAccount();
		System.out.println("Test Passed");
	}
}
