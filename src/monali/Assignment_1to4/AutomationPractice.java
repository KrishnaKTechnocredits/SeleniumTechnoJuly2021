package monali.Assignment_1to4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class AutomationPractice {

	WebDriver launchBrowser() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./resources/chromedriver.exe");
		System.out.println("STEP - Open Chrome Browser");
		WebDriver driver = new ChromeDriver();

		System.out.println("STEP - Enter AutomationPractice url");
		driver.get("http://automationpractice.com/index.php");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		return driver;
	}

	void automateSignup(WebDriver driver) throws InterruptedException {
		String email = "test@testing1.com";
		System.out.println("STEP-Click on Sign in");
		driver.findElement(By.xpath("//a[@title='Log in to your customer account']")).click();
		System.out.println("STEP-Enter Email Address");
		driver.findElement(By.xpath("//input[@id='email_create']")).sendKeys(email);
		System.out.println("STEP-Click on Create Account button");
		driver.findElement(By.xpath("//button[@id='SubmitCreate']")).click();
		Thread.sleep(3000);
		System.out.println("STEP-Select Title");
		driver.findElement(By.xpath("//input[@id='id_gender2']")).click();
		System.out.println("STEP-Enter First Name");
		driver.findElement(By.xpath("//input[@id='customer_firstname']")).sendKeys("Monali");
		System.out.println("STEP-Enter Last Name");
		driver.findElement(By.xpath("//input[@id='customer_lastname']")).sendKeys("Bendale");
		/*
		 * System.out.println("STEP-Check Email"); String
		 * expectedEmail=driver.findElement(By.xpath(
		 * "//input[@value='test@testing1.com']")).getText();
		 * if(email.equals(expectedEmail))
		 * System.out.println("Email text verified : Pass"); else
		 * System.out.println("Wrong Mail id : Fail");
		 */
		System.out.println("STEP-2 Enter Password");
		driver.findElement(By.xpath("//input[@id='passwd']")).sendKeys("Testing");
		System.out.println("STEP-Select Birth Date");
		WebElement birthDate = driver.findElement(By.xpath("//select[@id='days']"));
		Select dateOfBirth = new Select(birthDate);
		dateOfBirth.selectByIndex(4);
		System.out.println("STEP-Select Birth Month");
		WebElement birthMonth = driver.findElement(By.xpath("//select[@id='months']"));
		Select birthMonthSelect = new Select(birthMonth);
		birthMonthSelect.selectByVisibleText("April ");
		;

		System.out.println("STEP-Select Birth Year");
		WebElement birthYear = driver.findElement(By.xpath("//select[@id='years']"));
		Select birthYearSelect = new Select(birthYear);
		birthYearSelect.selectByVisibleText("1991  ");
		System.out.println("STEP-Select checkbox for signup");
		driver.findElement(By.xpath("//label[contains(text(),'Sign up for our newsletter!')]")).click();

		System.out.println("STEP-Enter First Name");
		driver.findElement(By.xpath("//input[@id='firstname']")).sendKeys("Monali");
		System.out.println("STEP-Enter Last Name");
		driver.findElement(By.xpath("//input[@id='lastname']"));
		System.out.println("STEP-Enter Company Name");
		driver.findElement(By.xpath("//input[@id='company']")).sendKeys("XYZ");
		System.out.println("STEP-Enter Address");
		driver.findElement(By.xpath("//input[@id='address1']")).sendKeys("Villa Parh 212");
		System.out.println("STEP-Enter Address Line2");
		driver.findElement(By.xpath("//input[@id='address2']")).sendKeys("Aprt 2,Silver Oak");
		System.out.println("STEP-Enter city Name");
		driver.findElement(By.xpath("//input[@id='city']")).sendKeys("Pune");
		System.out.println("STEP-select state");
		WebElement state = driver.findElement(By.xpath("//select[@id='id_state']"));
		Select selectState = new Select(state);
		selectState.selectByVisibleText("Indiana");
		System.out.println("STEP-Enter PostalCode");
		driver.findElement(By.xpath("//input[@id='postcode']")).sendKeys("654789");
		System.out.println("STEP-Select Country");
		WebElement country = driver.findElement(By.xpath("//select[@id='id_country']"));
		Select coutrySelect = new Select(country);
		coutrySelect.selectByVisibleText("United States");
		System.out.println("STEP-Enter Additional Information");
		driver.findElement(By.xpath("//textarea[@id='other']")).sendKeys("Test");
		System.out.println("STEP-Enter Home Phone");
		driver.findElement(By.xpath("//input[@id='phone']")).sendKeys("2334555555");
		System.out.println("STEP-Enter Mobile Phone");
		driver.findElement(By.xpath("//input[@id='phone_mobile']")).sendKeys("534534646");
		System.out.println("STEP-Enter Address alias");
		driver.findElement(By.xpath("//input[@id='alias']")).sendKeys("King");
		driver.close();
		System.out.println("Test Pass Successfully");
	}

	public static void main(String[] args) throws InterruptedException {
		AutomationPractice automate = new AutomationPractice();
		automate.automateSignup(automate.launchBrowser());
	}
}
