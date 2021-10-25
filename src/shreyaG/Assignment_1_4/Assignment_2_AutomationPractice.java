package shreyaG.Assignment_1_4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment_2_AutomationPractice {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./resources/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		System.out.println("launch the browser");
		driver.navigate().to("http://automationpractice.com/index.php");
		
		driver.manage().window().maximize();
		
		System.out.println("Click on the Sign in button");
		driver.findElement(By.xpath("//a[@class='login']")).click();
		
		System.out.println("Write an email id");
		driver.findElement(By.xpath("//input[@id='email_create']")).sendKeys("shreyagulhane@gmail.com");
		
		
		System.out.println("Click on create an account button");
		driver.findElement(By.xpath("//i[@class='icon-user left']")).click();
		Thread.sleep(3000);
		
		System.out.println("Select gender");
		driver.findElement(By.xpath("//label[@for='id_gender1']")).click();
		
		System.out.println("Enter first name");
		driver.findElement(By.name("customer_firstname")).sendKeys("Shreya");
		
		System.out.println("Enter last name");
		driver.findElement(By.id("customer_lastname")).sendKeys("Gulhane");
		
		System.out.println("Enter email address");
		driver.findElement(By.xpath("//input[@data-validate='isEmail']")).clear();
		driver.findElement(By.xpath("//input[@data-validate='isEmail']")).sendKeys("shreyagulhane@gmail.com");
		
		
		System.out.println("Enter password");
		driver.findElement(By.xpath("//input[@name='passwd']")).sendKeys("pwd1002");
		
		System.out.println("Enter DOB");
		WebElement selectDate=driver.findElement(By.id("days"));
		Select dateElement=new Select(selectDate);
		dateElement.selectByVisibleText("1  ");
		
		WebElement selectMonth=driver.findElement(By.xpath("//select[@id='months']"));
		Select monthElement=new Select(selectMonth);
		monthElement.selectByVisibleText("September ");
		
		WebElement selectYear=driver.findElement(By.id("years"));
		Select yearElement=new Select(selectYear);
		yearElement.selectByVisibleText("2001  ");
		
		driver.findElement(By.xpath("//label[@for='optin']")).click();
		
		System.out.println("Enter company name");
		driver.findElement(By.id("company")).sendKeys("Oracle");
		
		System.out.println("Enter address");
		driver.findElement(By.name("address1")).sendKeys("Near Kalyan");
		
		System.out.println("Enter city name");
		driver.findElement(By.name("city")).sendKeys("Karanja Lad");
		
		System.out.println("Select state name");
		WebElement selectState=driver.findElement(By.xpath("//select[@id='id_state']"));
		Select stateElement=new Select(selectState);
		stateElement.selectByVisibleText("California");
		
		System.out.println("Enter postal code");
		driver.findElement(By.id("postcode")).sendKeys("444105");
		
		System.out.println("Select country name");
		WebElement selectCountry=driver.findElement(By.xpath("//select[@id='id_country']"));
		Select countryElement=new Select(selectCountry);
		countryElement.selectByVisibleText("United States");
		
		System.out.println("Enter Other Info");
		driver.findElement(By.xpath("//textarea[@cols='26']")).sendKeys("No");
		
		System.out.println("Enter home phone");
		driver.findElement(By.id("phone")).sendKeys("2456357891");
		
		System.out.println("Enter mobile phone");
		driver.findElement(By.id("phone_mobile")).sendKeys("4589632571");
		
		System.out.println("Assign an address alias for future reference");
		driver.findElement(By.id("alias")).clear();
		driver.findElement(By.id("alias")).sendKeys("Pune");
		System.out.println("---------------------");
		System.out.println("Script runs successfully");
		
		

	}

}
