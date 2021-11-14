package Mayur;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment2 {

	public static void main(String[] args) throws Exception {
		
		//System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		//WebDriver driver = new ChromeDriver();
		
		System.out.println("Step1:- Open Browser");
		System.setProperty("webdriver.chrome.driver", "D:\\TechnoCredits Class\\TechnoCreditWorkplace\\Java_Techno_Selenium_2021\\resources\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();  
		System.out.println("Step2:- Open Url");
		driver.get("http://automationpractice.com/index.php");
		System.out.println("Step3:- maximize window");
		driver.manage().window().maximize();
		System.out.println("Step4:- Get Tittle of Application");
		System.out.println(driver.getTitle());
		Thread.sleep(2000);
		System.out.println("Step5:- Click on Sign in Button");
		driver.findElement(By.xpath("//a[contains(text(),'Sign in')]")).click();
		System.out.println("Step 6 :- Enter your mail id for crete account");
		driver.findElement(By.xpath("//input[@id='email_create']")).sendKeys("mssap18@gmail.com");
		System.out.println("Step 7 :- Click on Create Account");
		driver.findElement(By.xpath("//button[@id='SubmitCreate']")).click();
		Thread.sleep(2000);
		System.out.println("Step 8:-  Tittle");
		driver.findElement(By.xpath("//input[@id='id_gender1']")).click();
		System.out.println("Step 9:- First Name");
		driver.findElement(By.xpath("//input[@id='customer_firstname']")).sendKeys("Mayur");
		System.out.println("Step 10:- Last Name");
		driver.findElement(By.xpath("//input[@id='customer_lastname']")).sendKeys("sss");
		System.out.println("Step 12:- Password");
		driver.findElement(By.xpath("//input[@id='passwd']")).sendKeys("Mayur@123");
		
		
		System.out.println("Step 13:-select DOB");
		WebElement dob = driver.findElement(By.xpath("//select[@id='days']"));
		Select birthDay = new Select(dob);
		birthDay.selectByValue("12");
		
		System.out.println("Step14:- select Months");
		WebElement months = driver.findElement(By.xpath("//select[@id='months']"));
		Select monthofbirth = new Select(months);
		monthofbirth.selectByIndex(2);
		
		System.out.println("Step15:- select Year");
		WebElement year = driver.findElement(By.xpath("//select[@id='years']"));
		Select birthyear = new Select(year);
		birthyear.selectByValue("1990");
		
		System.out.println("Step 16:- First Name1");
		driver.findElement(By.xpath("//input[@id='firstname']")).sendKeys("Mayur");
		System.out.println("Step 17:- Last Name");
		driver.findElement(By.xpath("//input[@id='lastname']")).sendKeys("SSSS");
		System.out.println("Step 18:- Comapany");
		driver.findElement(By.xpath("//input[@id='company']")).sendKeys("ABC Pvt Ltd.");
		
		System.out.println("Step 19:- Adress");
		driver.findElement(By.xpath("//input[@id='address1']")).sendKeys("Pune");
		System.out.println("Step 20:- address2");
		driver.findElement(By.xpath("//input[@id='address2']")).sendKeys("KeshavNagar");
		System.out.println("Step 21:- city");
		driver.findElement(By.xpath("//input[@id='city']")).sendKeys("Pune Magarpatta");
		Thread.sleep(3000);
		
		System.out.println("Step 22:-select State");
		WebElement state = driver.findElement(By.xpath("//select[@id='id_state']"));
		Select stateSelect = new Select(state);
		stateSelect.selectByValue("4");
		
		Thread.sleep(2000);
		
		System.out.println("Step 23:- Select PostalCode");
		driver.findElement(By.xpath("//input[@id='postcode']")).sendKeys("10000");
		
		System.out.println("Step 24:- Select country");
		WebElement country = driver.findElement(By.xpath("//select[@id='id_country']"));
		Select countryselect = new Select(country);
		countryselect.selectByValue("21");
		
		System.out.println("Step 25:- Provide Address");
		driver.findElement(By.xpath("//textarea[@id='other']")).sendKeys("At post Pune But in NewYork");
		
		System.out.println("Step 26:- Home Phone");
		driver.findElement(By.xpath("//input[@id='phone']")).sendKeys("1234455879");
		
		System.out.println("Step 27:- Mobile Phone");
		driver.findElement(By.xpath("//input[@id='phone_mobile']")).sendKeys("1234567890");
		
		System.out.println("Step 28:- Alias Address");
		driver.findElement(By.xpath("//input[@id='alias']")).sendKeys("Abc");
		
		System.out.println("Step 29:- Submit");
		driver.findElement(By.xpath("//button[@id='submitAccount']")).click();
		
		

	}

}
