package purshottamJoshi;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment4 {

	
	final static void automateYahooSignUp() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		System.out.println("Launch the browser");
		driver.get("https://login.yahoo.com/account/create?specId=yidReg");
		driver.manage().window().maximize();

		System.out.println("STEP-Enter first name");
		driver.findElement(By.xpath("//input[@id='usernamereg-firstName']")).sendKeys("purshottam");

		System.out.println("STEP-Enter last name");
		driver.findElement(By.xpath("//input[@id='usernamereg-lastName']")).sendKeys("Joshi");

		System.out.println("STEP-Enter email");
		driver.findElement(By.xpath("//input[@name='yid']")).sendKeys("purshottam@yahoo.in");

		System.out.println("STEP-Enter password");
		driver.findElement(By.id("usernamereg-password")).sendKeys("test567");

		System.out.println("STEP-Enter mobile phone number");
		driver.findElement(By.id("usernamereg-phone")).sendKeys("123456678");

		System.out.println("STEP-Enter DOB");
		WebElement selectMonth=driver.findElement(By.xpath("//select[@name='mm']"));
		Select selectElement=new Select(selectMonth);
		selectElement.selectByVisibleText("September");

		driver.findElement(By.xpath("//input[@placeholder='Day']")).sendKeys("2");

		driver.findElement(By.name("yyyy")).sendKeys("1994");

		System.out.println("STEP-Enter gender");
		driver.findElement(By.name("freeformGender")).sendKeys("Male");
		System.out.println("Test Passed");
		driver.close();
	}
		
	
	
	public static void main(String[] args) {
		automateYahooSignUp();
	}
}
