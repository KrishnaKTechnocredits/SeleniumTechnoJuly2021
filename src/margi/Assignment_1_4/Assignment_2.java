package margi.Assignment_1_4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment_2 {

	String email, password;
	Assignment_2(String email, String password){
		this.email = email;
		this.password = password;
	}
	void automationPractice() throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
		System.out.println("STEP : Launch Browser");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://automationpractice.com/index.php");

		System.out.println("STEP : Click on Sign in button");
		driver.findElement(By.xpath("//a[contains(text(),'Sign in')]")).click();

		Thread.sleep(4000);

		//create an account
		System.out.println("STEP : Enter email address for create account");
		driver.findElement(By.xpath("//input[@name = 'email_create']")).sendKeys(email);

		System.out.println("STEP : Click on create account");
		driver.findElement(By.xpath("//button[@id = 'SubmitCreate']")).click();
		
		Thread.sleep(5000);

		//Create an account
		//Your Personal Information
		System.out.println("STEP : Select Title");
		driver.findElement(By.xpath("//input[@id='id_gender2']")).click();
		//driver.findElement(By.id("id_gender2")).click();
		 
		System.out.println("STEP : Enter firstname");
		driver.findElement(By.xpath("//input[@name='customer_firstname']")).sendKeys("Margi");
		
		System.out.println("STEP : Enter lastname");
		driver.findElement(By.xpath("//input[@name='customer_lastname']")).sendKeys("Santoki");
				
		System.out.println("STEP : Enter password");
		driver.findElement(By.xpath("//input[@name='passwd']")).sendKeys(password);
		
		System.out.println("STEP : Select Birth day");
		WebElement dayElement = driver.findElement(By.xpath("//select[@name='days']"));
		Select daySelect = new Select(dayElement);
		daySelect.selectByValue("23");
		
		System.out.println("STEP : Select Birth Month");
		WebElement monthElement = driver.findElement(By.xpath("//select[@name='months']"));
		Select monthSelect = new Select(monthElement);
		monthSelect.selectByValue("2");
		
		System.out.println("STEP : Select Birth Year");
		WebElement yearElement = driver.findElement(By.xpath("//select[@name='years']"));
		Select yearSelect = new Select(yearElement);
		yearSelect.selectByValue("1997");
		
		System.out.println("STEP : Click sign up for newsletter");
		driver.findElement(By.xpath("//input[@name='newsletter']")).click();
		
		System.out.println("STEP : Click recieve special offers");
		driver.findElement(By.xpath("//input[@name='optin']")).click();
		
		//your address
		System.out.println("STEP : Enter company name");
		driver.findElement(By.xpath("//input[@name='company']")).sendKeys("ABC");
		
		System.out.println("STEP : Enter address");
		driver.findElement(By.xpath("//input[@name='address1']")).sendKeys("Gujarat");
		
		System.out.println("STEP : Enter address line 2");
		driver.findElement(By.xpath("//input[@name='address2']")).sendKeys("India");
		
		System.out.println("STEP : Enter city");
		driver.findElement(By.xpath("//input[@name='city']")).sendKeys("Surat");
		
		System.out.println("STEP : Select State");
		Select stateSelect = new Select(driver.findElement(By.xpath("//select[@name='id_state']")));
		stateSelect.selectByVisibleText("Alaska");
		
		System.out.println("STEP : Enter postal code");
		driver.findElement(By.xpath("//input[@name='postcode']")).sendKeys("30045");
		
		System.out.println("STEP : Select Country");
		Select countrySelect = new Select(driver.findElement(By.xpath("//select[@name='id_country']")));
		countrySelect.selectByVisibleText("United States");
		
		System.out.println("STEP : Enter textarea");
		driver.findElement(By.xpath("//textarea[@name='other']")).sendKeys("Automation text area");
		
		System.out.println("STEP : Enter home phone");
		driver.findElement(By.xpath("//input[@name='phone']")).sendKeys("1122334455");
		
		System.out.println("STEP : Enter mobile phone");
		driver.findElement(By.xpath("//input[@name='phone_mobile']")).sendKeys("9988776655");
		
		System.out.println("STEP : Click on register");
		driver.findElement(By.xpath("//button[@id='submitAccount']")).click();
		
		System.out.println("Test passed successfully");

		driver.close();
	}
	
	void registered() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
		System.out.println("STEP : Launch Browser");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://automationpractice.com/index.php");

		System.out.println("STEP : Click on Sign in button");
		driver.findElement(By.xpath("//a[contains(text(),'Sign in')]")).click();

		Thread.sleep(5000);
		
		System.out.println("STEP : Enter email");
		driver.findElement(By.xpath("//div[@class='form-group']/input[@name='email']")).sendKeys(email);
		
		System.out.println("STEP : Enter password");
		driver.findElement(By.xpath("//input[@name='passwd']")).sendKeys(password);
		
		System.out.println("STEP : Click on Sign in button");
		driver.findElement(By.xpath("//button[@name='SubmitLogin']")).click();
		
		Thread.sleep(3000);
		System.out.println("STEP : Click on Sign out button");
		driver.findElement(By.xpath("//a[contains(text(),'Sign out')]")).click();
		
		Thread.sleep(3000);
		System.out.println("Login is successfully tested");
		driver.close();
	}

	public static void main(String[] args) throws InterruptedException {
		Assignment_2 assignment_2 = new Assignment_2("margi111@gmail.com", "123margi");
		assignment_2.automationPractice();
		System.out.println("Login");
		assignment_2.registered();
	}
}
