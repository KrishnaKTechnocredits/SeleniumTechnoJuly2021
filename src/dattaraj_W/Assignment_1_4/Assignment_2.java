package dattaraj_W.Assignment_1_4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import dattaraj_W.base.PredefinedActions;

public class Assignment_2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = PredefinedActions.start("http://automationpractice.com/index.php");
		System.out.println("STEP - Open Chrome Browser");

		System.out.println("STEP - Click on Sign In button");
		driver.findElement(By.xpath("//a[@class='login']")).click();
		Thread.sleep(3000);

		System.out.println("STEP - Enter email address");
		driver.findElement(By.xpath("//input[@id='email_create']")).sendKeys("ytodt@rty.com");

		System.out.println("STEP - Click on Create Account button");
		driver.findElement(By.xpath("//button[@name='SubmitCreate']")).click();
		Thread.sleep(3000);
		
		System.out.println("STEP- Choose title");
		driver.findElement(By.xpath("//input[@value='2']")).click();
		
		System.out.println("STEP - Enter First name");
		driver.findElement(By.xpath("//input[@id='customer_firstname']")).sendKeys("jack");

		System.out.println("STEP - Enter Last name");
		driver.findElement(By.xpath("//input[@name='customer_lastname']")).sendKeys("danieal");

		System.out.println("STEP - Enter Password");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("pass1234");

		System.out.println("STEP - Birth Date");
		Select days = new Select(driver.findElement(By.xpath("//select[@id='days']")));
		days.selectByValue("6");
		Select month = new Select(driver.findElement(By.xpath("//select[@id='months']")));
		month.selectByVisibleText("April ");
		Select year = new Select(driver.findElement(By.xpath("//select[@id='years']")));
		year.selectByIndex(45);

		System.out.println("STEP - Select checkbox for newsletter");
		driver.findElement(By.xpath("//input[@name='newsletter']")).click();

		System.out.println("STEP - Select checkox for special offers");
		driver.findElement(By.xpath("//input[@name='optin']")).click();

		System.out.println("STEP - Enter Company name");
		driver.findElement(By.xpath("//input[@id='company']")).sendKeys("Tesla");

		System.out.println("STEP - Address");
		driver.findElement(By.xpath("//input[@name='address1']")).sendKeys("23 Apt");
		driver.findElement(By.xpath("//input[@name='address2']")).sendKeys("Apt no.009");
		driver.findElement(By.xpath("//input[@name='city']")).sendKeys("paris");
		Select state = new Select(driver.findElement(By.xpath("//select[@id='id_state']")));
		state.selectByValue("38");
		driver.findElement(By.xpath("//input[@id='postcode']")).sendKeys("00000");

		System.out.println("STEP - Enter Additional Information");
		driver.findElement(By.xpath("//textarea[@name='other']")).sendKeys("text area data added");

		System.out.println("STEP - Enter Homephone number");
		driver.findElement(By.xpath("//input[@name='phone']")).sendKeys("67676767");

		System.out.println("STEP - Enter Mobile number");
		driver.findElement(By.xpath("//input[@name='phone_mobile']")).sendKeys("3453332123");

		System.out.println("STEP - Enter Address reference");
		driver.findElement(By.xpath("//input[@value='My address']")).clear();
		driver.findElement(By.xpath("//input[@value='My address']")).sendKeys("Home");

		System.out.println("STEP - Click on Register button");
		driver.findElement(By.xpath("//button[@id='submitAccount']")).click();
	}

}
