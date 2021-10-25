/*Yahoo Signup.
https://login.yahoo.com/account/create?specId=yidReg
*/

package vivek;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment04 {

	static WebDriver openURL(String url) {
		System.setProperty("webdriver.chrome.driver", "./resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
		return driver;
	}

	static void yahooSignup() {
		System.out.println("Step - Open the Yahoo mail from the chrome browser");
		WebDriver driver = openURL("https://login.yahoo.com/");
		System.out.println("Step - Click on create an account button");
		driver.findElement(By.id("createacc")).click();
		System.out.println("Step - Enter firstname and lastname");
		driver.findElement(By.id("usernamereg-firstName")).sendKeys("Vivek");
		driver.findElement(By.id("usernamereg-lastName")).sendKeys("Patil");
		System.out.println("Step - Enter username");
		driver.findElement(By.id("usernamereg-yid")).sendKeys("vivekvpatil1");
		System.out.println("Step - Enter password");
		driver.findElement(By.id("usernamereg-password")).sendKeys("yahoo@123");
		System.out.println("Step - Enter phone");
		driver.findElement(By.id("usernamereg-phone")).sendKeys("1234567890");
		System.out.println("Step - Enter Birth date");
		WebElement month = driver.findElement(By.id("usernamereg-month"));
		Select monthselect = new Select(month);
		monthselect.selectByVisibleText("February");
		driver.findElement(By.id("usernamereg-day")).sendKeys("10");
		driver.findElement(By.id("usernamereg-year")).sendKeys("1993");
		System.out.println("Step - Enter gender");
		driver.findElement(By.name("freeformGender")).sendKeys("Male");
	}

	public static void main(String[] args) {
		Assignment04.yahooSignup();
		System.out.println("Test Passed");
	}
}
