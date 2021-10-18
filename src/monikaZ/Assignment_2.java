/*Assignment - 2 : 16th Oct'2021
Automate Singup : 
http://automationpractice.com/index.php*/

package monikaZ;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment_2 {

	static void signup() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./resources/chromedriver.exe");
		System.out.println("STEP- Open Chrome Browser");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		System.out.println("STEP-Enter AutomationPractice URL ");
		driver.get("http://automationpractice.com/index.php");
		System.out.println("STEP-Click on Sign in");
		driver.findElement(By.xpath("//a[@class='login']")).click();
		System.out.println("STEP- Enter Email Address");
		driver.findElement(By.name("email_create")).sendKeys("kicprhmno@gmail.com");
		
		System.out.println("STEP- Click on Create Account Button");
		driver.findElement(By.id("SubmitCreate")).click();
		
		System.out.println("STEP-Select Title");
		Thread.sleep(3000);
		WebElement title=driver.findElement(By.xpath("//input[@id='id_gender2']"));
		title.click();
		
		System.out.println("STEP-Enter First Name");
		driver.findElement(By.xpath("//input[@name='customer_firstname']")).sendKeys("EVA");
		
		System.out.println("STEP-Enter Last Name");
		driver.findElement(By.id("customer_lastname")).sendKeys("pqr");
	
		System.out.println("STEP-Email");
		driver.findElement(By.name("email"));
		
		System.out.println("STEP-Enter Password");
		driver.findElement(By.xpath("//input[@name='passwd']")).sendKeys("Pwsehhgnt123@");
		
		System.out.println("STEP-Enter Date of Birth");
		
		WebElement birthDayelement=driver.findElement(By.xpath("//select[@id='days']"));
		Select birthdayselect=new Select(birthDayelement);
		birthdayselect.selectByVisibleText("15  ");
		
		WebElement birthMonthelement = driver.findElement(By.xpath("//select[@id='months']"));
		Select birthMonthSelect = new Select(birthMonthelement);
		birthMonthSelect.selectByVisibleText("July ");
		
		WebElement birthYearelement=driver.findElement(By.xpath("//select[@id='years']"));
		Select birthYearselect=new Select(birthYearelement);
		birthYearselect.selectByVisibleText("1997  ");
			
		System.out.println("STEP-Click on checkBox");
		driver.findElement(By.name("newsletter")).click();
		
		
		System.out.println("STEP- Enter Company Name");
		driver.findElement(By.xpath("//input[@id='company']")).sendKeys("wipro");
		
		System.out.println("STEP- Enter Address1");
		driver.findElement(By.xpath("//input[@id='address1']")).sendKeys("xyz bdf dje");
		
		System.out.println("STEP- Enter Address2");
		driver.findElement(By.xpath("//input[@id='address2']")).sendKeys("xyz bdf dje");
		
		System.out.println("STEP- City Name");
		driver.findElement(By.xpath("//input[@name='city']")).sendKeys("Los Angeles");
		
		System.out.println("STEP- State Name");
		WebElement state=driver.findElement(By.xpath("//select[@name='id_state']"));
		Select state_select=new Select(state);
		state_select.selectByVisibleText("California");
		
		System.out.println("STEP- Enter Zip Code");
		driver.findElement(By.xpath("//input[@name='postcode']")).sendKeys("25896");
		
		System.out.println("STEP- Country Name");
		WebElement country=driver.findElement(By.xpath("//select[@name='id_country']"));
		Select country_select=new Select(country);
		country_select.selectByVisibleText("United States");
			
		System.out.println("STEP- Additional Information ");
		driver.findElement(By.xpath("//textarea[@name='other']")).sendKeys("ndind deiji ksmalk");
		
		System.out.println("STEP- Home phone-Number ");
		driver.findElement(By.xpath("//input[@id='phone']")).sendKeys("48753692");
		
		System.out.println("STEP- Mobile Number ");
		driver.findElement(By.xpath("//input[@id='phone_mobile']")).sendKeys("98657416");
		
		System.out.println("STEP- Address Alise for Future reference");
		driver.findElement(By.xpath("//input[@id='alias']")).sendKeys("xyz");
		
		System.out.println("STEP- Submit");
		driver.findElement(By.xpath("//button[@id='submitAccount']")).click();
		System.out.println("STEP- Close the Browser");
		driver.close();
		driver.manage().window().maximize();
		
	}
	public static void main(String[] args) throws InterruptedException {
		signup();
	}
}
