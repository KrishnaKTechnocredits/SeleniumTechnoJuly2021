package husain.Assignments1to4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import husain.base.Prerequisites;

public class Assignment2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = Prerequisites.start("http://automationpractice.com/index.php");
		System.out.println("STEP - Open Chrome Browser");

		System.out.println("STEP - Click on Sign In button");
		driver.findElement(By.xpath("//a[@class='login']")).click();
		Thread.sleep(3000L);

		System.out.println("STEP - Enter email address");
		driver.findElement(By.xpath("//input[@id='email_create']")).sendKeys("acb1@zyx.com");

		System.out.println("STEP - Clickon Create Account button");
		driver.findElement(By.xpath("//button[@name='SubmitCreate']")).click();
		;
		Thread.sleep(3000L);

		System.out.println("STEP - Select Gender");
		driver.findElement(By.xpath("//input[@id='id_gender1']")).click();

		System.out.println("STEP - Enter First name");
		driver.findElement(By.xpath("//input[@id='customer_firstname']")).sendKeys("Matt");

		System.out.println("STEP - Enter Last name");
		driver.findElement(By.xpath("//input[@name='customer_lastname']")).sendKeys("Hummels");

		System.out.println("STEP - Enter Password");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("pass1234");

		System.out.println("STEP - Birth Date");
		Select days = new Select(driver.findElement(By.xpath("//select[@id='days']")));
		days.selectByValue("21");
		Select month = new Select(driver.findElement(By.xpath("//select[@id='months']")));
		month.selectByVisibleText("August ");
		Select year = new Select(driver.findElement(By.xpath("//select[@id='years']")));
		year.selectByIndex(34);

		System.out.println("STEP - Select checkbox for newsletter");
		driver.findElement(By.xpath("//input[@name='newsletter']")).click();

		System.out.println("STEP - Select checkox for special offers");
		driver.findElement(By.xpath("//input[@name='optin']")).click();

		System.out.println("STEP - Enter Company name");
		driver.findElement(By.xpath("//input[@id='company']")).sendKeys("Tesla");

		System.out.println("STEP - Address");
		driver.findElement(By.xpath("//input[@name='address1']")).sendKeys("223 Baker st");
		driver.findElement(By.xpath("//input[@name='address2']")).sendKeys("Apt no.202");
		driver.findElement(By.xpath("//input[@name='city']")).sendKeys("Pittsburgh");
		Select state = new Select(driver.findElement(By.xpath("//select[@id='id_state']")));
		state.selectByValue("38");
		driver.findElement(By.xpath("//input[@id='postcode']")).sendKeys("15215");

		System.out.println("STEP - Enter Additional Information");
		driver.findElement(By.xpath("//textarea[@name='other']")).sendKeys("text area data added");

		System.out.println("STEP - Enter Homephone number");
		driver.findElement(By.xpath("//input[@name='phone']")).sendKeys("4142345312");

		System.out.println("STEP - Enter Mobile number");
		driver.findElement(By.xpath("//input[@name='phone_mobile']")).sendKeys("2121243123");

		System.out.println("STEP - Enter Address reference");
		driver.findElement(By.xpath("//input[@value='My address']")).clear();
		driver.findElement(By.xpath("//input[@value='My address']")).sendKeys("Home");

		System.out.println("STEP - Click on Register button");
		driver.findElement(By.xpath("//button[@id='submitAccount']")).click();
	}

}
