package swati.Assignment2_4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class AutomateSingup {
	
	void validateSignIn() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","./resources/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		//int temp=0;
		System.out.println("STEP - Enter automatepractice URL");
		driver.get("http://automationpractice.com/index.php");
		driver.manage().window().maximize();
		System.out.println("Click on Sign-in");
		driver.findElement(By.xpath("//a[contains(text(),'Sign in')]")).click();
		Thread.sleep(3000);
		System.out.println("Enter Email ID");
		driver.findElement(By.xpath("//input[@id='email_create']")).sendKeys("sds596@gmail.com");
		System.out.println("Click on Create an Account button");
		driver.findElement(By.xpath("//button[@class='btn btn-default button button-medium exclusive']")).click();
		Thread.sleep(3000);
		System.out.println("Select Title");
		driver.findElement(By.xpath("//input[@id='id_gender1']")).click();
		System.out.println("Enter First Name");
		driver.findElement(By.name("customer_firstname")).sendKeys("abc");
		System.out.println("Enter Last Name");
		driver.findElement(By.name("customer_lastname")).sendKeys("xyz");
		System.out.println("Enter Email");
		driver.findElement(By.xpath("//input[@id='email']")).click();
		System.out.println("Enter Password");
		driver.findElement(By.name("passwd")).sendKeys("abc12345");
		System.out.println("Enter Date of Birth");	
		WebElement birthDay= driver.findElement(By.xpath("//select[@name='days']"));
		Select day =new Select(birthDay);
		day.selectByIndex(9);
		Select month=new Select(driver.findElement(By.xpath("//select[@id='months']")));
		month.selectByIndex(4);
		Select year=new Select(driver.findElement(By.xpath("//select[@id='years']")));
		year.selectByIndex(6);
		driver.findElement(By.xpath("//input[@id='newsletter']")).click();
		System.out.println("Your Address");
		System.out.println("Enter First Name");
		driver.findElement(By.xpath("//input[@id='firstname']")).sendKeys("abc");
		System.out.println("Enter Last Name");
		driver.findElement(By.xpath("//input[@id='lastname']")).sendKeys("xyz");
		System.out.println("Enter Company Name");
		driver.findElement(By.xpath("//input[@id='company']")).sendKeys("TCS");
		System.out.println("Enter Address1");
		driver.findElement(By.xpath("//input[@id='address1']")).sendKeys("Address1");
		System.out.println("Enter Address2");
		driver.findElement(By.xpath("//input[@id='address2']")).sendKeys("Address2");
		System.out.println("Enter City");
		driver.findElement(By.id("city")).sendKeys("Pune");
		System.out.println("Select State");
		WebElement state=driver.findElement(By.xpath("//select[@id='id_state']"));
		Select st=new Select(state);
		st.selectByVisibleText("Alabama");
		System.out.println("Enter PostCode");
		driver.findElement(By.xpath("//input[@name='postcode']")).sendKeys("41128");
		System.out.println("Select Country");
		WebElement cntry=driver.findElement(By.xpath("//select[@name='id_country']"));
		Select country=new Select(cntry);
		country.selectByVisibleText("United States");
		System.out.println("Enter Additional information");
		driver.findElement(By.xpath("//textarea[@name='other']")).sendKeys("abc xyz");
		System.out.println("Enter Phone no");
		driver.findElement(By.xpath("//input[@name='phone']")).sendKeys("43243123");
		System.out.println("Enter mobile no");
		driver.findElement(By.xpath("//input[@name='phone_mobile']")).sendKeys("9800000012");
		System.out.println("Enter Alias");
		driver.findElement(By.xpath("//input[@name='alias']")).sendKeys("My addr");
		driver.findElement(By.xpath("//button[@name='submitAccount']")).click();
		driver.close();
	}
	
	public static void main(String[] a) throws InterruptedException {
		AutomateSingup signIn=new AutomateSingup();
		signIn.validateSignIn();
	}

}