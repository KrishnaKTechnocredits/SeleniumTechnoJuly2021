package amolVyas;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment_2 {

	void signUpAutomationPractice() throws InterruptedException {
		Random random = new Random();
		int x = random.nextInt(50);
		String name = "amolvyas" + x + "@test.com";
		System.setProperty("webdriver.chrome.driver", "./resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		System.out.println("Opening Chrome");
		driver.get("http://automationpractice.com/index.php");
		System.out.println("STEP- Open URL");
		System.out.println("STEP-Click on Sign In");
		WebElement element = driver.findElement(By.xpath("//a[contains(text(),'Sign in')]"));
		element.click();
		Thread.sleep(5000);
		System.out.println("STEP-Enter valid Email address");
		driver.findElement(By.xpath("//input[@id=\"email_create\"]")).sendKeys(name);
		System.out.println("STEP-Click on Submit button");
		driver.findElement(By.xpath("//button[@id='SubmitCreate']")).click();
		Thread.sleep(5000);
		System.out.println("STEP-Select Title as MR");
		driver.findElement(By.xpath("//input[@id='id_gender1']")).click();
		System.out.println("STEP-Enter First Name");
		driver.findElement(By.xpath("//input[@id='customer_firstname']")).sendKeys("Test");
		System.out.println("STEP-Enter Last Name");
		driver.findElement(By.xpath("//input[@id='customer_lastname']")).sendKeys("Test");
		System.out.println("STEP-Enter Password");
		driver.findElement(By.xpath("//input[@id='passwd']")).sendKeys("Test@123");
		;
		System.out.println("STEP-Enter DOB");
		Select days = new Select(driver.findElement(By.xpath("//select[@id='days']")));
		days.selectByVisibleText("1  ");
		Select month = new Select(driver.findElement(By.xpath("//select[@id='months']")));
		month.selectByVisibleText("January ");
		Select year = new Select(driver.findElement(By.xpath("//select[@id='years']")));
		year.selectByVisibleText("2000  ");
		System.out.println("STEP-Enter Company");
		driver.findElement(By.xpath("//input[@id='company']")).sendKeys("DXC Company");
		System.out.println("STEP-Enter Address");
		driver.findElement(By.xpath("//input[@id='address1']")).sendKeys("123 Sudma nagar");
		System.out.println("STEP-Enter City");
		driver.findElement(By.xpath("//input[@id='city']")).sendKeys("Indore");
		System.out.println("STEP-Enter State");
		Select state = new Select(driver.findElement(By.xpath("//select[@id='id_state']")));
		state.selectByVisibleText("Colorado");
		System.out.println("STEP-Enter Zip Code");
		driver.findElement(By.xpath("//input[@id='postcode']")).sendKeys("34512");
		System.out.println("STEP-Enter Country");
		Select country = new Select(driver.findElement(By.xpath("//select[@id='id_country']")));
		country.selectByVisibleText("United States");
		System.out.println("STEP-Enter Mobile Number");
		driver.findElement(By.xpath("//input[@id='phone_mobile']")).sendKeys("1234567890");
		System.out.println("STEP-Enter Future Refernce Code");
		driver.findElement(By.xpath("//input[@id='alias']")).clear();
		driver.findElement(By.xpath("//input[@id='alias']")).sendKeys("My Address");
		System.out.println("STEP-Click on Register button");
		driver.findElement(By.xpath("//button[@id='submitAccount']")).click();
		System.out.println("Test Passed");
		driver.close();
	}

	public static void main(String[] args) throws InterruptedException {
		new Assignment_2().signUpAutomationPractice();
	}

}
