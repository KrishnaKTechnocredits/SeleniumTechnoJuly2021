package shalakaP.Assignment2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class AutomateSignUpTest {

	void automateSignUp() throws InterruptedException {
		System.setProperty("Webdriver.chrome.driver", "chromedriver.exe");
		System.out.println("STEP - Open Chrome Browser");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		System.out.println("enter the Url");
		driver.get("http://automationpractice.com/index.php");

		System.out.println("STEP - click on Sign in");
		driver.findElement(By.xpath("//a[contains(text(),'Sign in')]")).click();

		Thread.sleep(3000);

		System.out.println("STEP - Enter email");
		driver.findElement(By.xpath("//input[@name='email_create']")).sendKeys("shalaka157@gmail.com");

		System.out.println("STEP - click on Create account button");
		driver.findElement(By.xpath("//button[@id='SubmitCreate']")).click();

		Thread.sleep(5000);
		System.out.println("STEP - Enter title");
		driver.findElement(By.xpath("//input[@id='id_gender2']")).click();

		System.out.println("STEP - Enter Firstname");
		driver.findElement(By.xpath("//input[@name='customer_firstname']")).sendKeys("Shalaka");

		System.out.println("STEP - Enter Lastname");
		driver.findElement(By.xpath("//input[@name='customer_lastname']")).sendKeys("Prayag");

		System.out.println("STEP - Enter Password");
		driver.findElement(By.xpath("//input[@name='passwd']")).sendKeys("Prayag@123");

		Thread.sleep(3000);
		System.out.println("STEP - Enter Date of birth");
		WebElement birthDateElement = driver.findElement(By.xpath("//select[@name='days']"));
		Select birthDateSelect = new Select(birthDateElement);
		birthDateSelect.selectByValue("15");

		System.out.println("STEP - Enter month of birth");
		WebElement birthMonthElement = driver.findElement(By.xpath("//select[@name='months']"));
		Select birthMonthSelect = new Select(birthMonthElement);
		birthMonthSelect.selectByValue("9");

		System.out.println("STEP - Enter year of birth");
		WebElement birthYearElement = driver.findElement(By.xpath("//select[@name='years']"));
		Select birthYearSelect = new Select(birthYearElement);
		birthYearSelect.selectByValue("1992");

		System.out.println("STEP -select sign up for news settler");
		driver.findElement(By.xpath("//div[@id='uniform-newsletter']")).click();

		System.out.println("STEP -select Receive special offers from our partners");
		driver.findElement(By.xpath("//div[@id='uniform-optin']")).click();

		System.out.println("STEP - Enter your address details");
		driver.findElement(By.xpath("//input[@id='company']")).sendKeys("abdc");
		driver.findElement(By.xpath("//input[@id='address1']")).sendKeys("Sreet no.5,P.O.box no.4115");
		driver.findElement(By.xpath("//input[@id='address2']")).sendKeys("paras appartment");
		driver.findElement(By.xpath("//input[@id='city']")).sendKeys("Pune");
		WebElement stateElement = driver.findElement(By.xpath("//select[@name='id_state']"));
		Select elementSelect = new Select(stateElement);
		elementSelect.selectByValue("20");
		driver.findElement(By.xpath("//input[@id='postcode']")).sendKeys("12635");

		System.out.println("STEP - Enter mobile number");
		driver.findElement(By.xpath("//input[@id='phone_mobile']")).sendKeys("8996658552");

		System.out.println("STEP - Assign an address");
		driver.findElement(By.xpath("//input[@name='alias']")).clear();
		driver.findElement(By.xpath("//input[@name='alias']")).sendKeys("Abcdefg");

		System.out.println("STEP - Click on register");
		driver.findElement(By.xpath("//button[@name='submitAccount']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@class='logout']")).click();
		Thread.sleep(2000);
		driver.close();

	}

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		new AutomateSignUpTest().automateSignUp();
	}

}
