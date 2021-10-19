package himanshu_Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment2 {

	void contactInfoMethod() throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "./resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        System.out.println("STEP 1: Launch automation practise");
	    driver.get("http://automationpractice.com/index.php");
	    driver.manage().window().maximize();
	    System.out.println("STEP 1: Click on login button");
	    driver.findElement(By.xpath("//a[@class='login']")).click();
	    System.out.println("STEP 2: Enter Email-Id");
	    driver.findElement(By.id("email_create")).sendKeys("him2310@gmail.com");
	    System.out.println("STEP 3: Click ");
	    driver.findElement(By.xpath("//i[@class='icon-user left']")).click();
	    
	    Thread.sleep(3000);
	    
	    System.out.println("STEP 4: Add Gender");
	    driver.findElement(By.id("id_gender1")).click();
	    System.out.println("STEP 5: Add First Name");
	    driver.findElement(By.id("customer_firstname")).sendKeys("Himanshu");
	    System.out.println("STEP 6: Add Last Name");
	    driver.findElement(By.id("customer_lastname")).sendKeys("Gupta");
	    System.out.println("STEP 7: Add Password");
	    driver.findElement(By.name("passwd")).sendKeys("Java@12345");
	    
	    System.out.println("STEP 8: Enter Date");
	    WebElement birthdateelement = driver.findElement(By.xpath("//select[@id='days']"));
		Select birthdateselect = new Select(birthdateelement);
		birthdateselect.selectByVisibleText("6  ");

		System.out.println("STEP 9: Enter Month");
		WebElement birthmonthelement = driver.findElement(By.xpath("//select[@id= 'months']"));
		Select birthmonthselect = new Select(birthmonthelement);
		birthmonthselect.selectByVisibleText("April ");

		System.out.println("STEP 10: Enter Year");
		WebElement birthmyearelement = driver.findElement(By.xpath("//select[@id= 'years']"));
		Select birthyearselect = new Select(birthmyearelement);
		birthyearselect.selectByValue("1989");
	    
	    driver.findElement(By.xpath("//input[@name='newsletter']")).click();
	    
	    driver.findElement(By.xpath("//input[@id='company']")).sendKeys("Google");
	    driver.findElement(By.xpath("//input[@id='address1']")).sendKeys("Flat no 6 Karve Nagar");
	    driver.findElement(By.xpath("//input[@id='address2']")).sendKeys("Kothrud");
	    driver.findElement(By.id("city")).sendKeys("Pune");
	    driver.findElement(By.xpath("//input[@id='postcode']")).sendKeys("411041");
	    driver.findElement(By.xpath("//textarea[@name='other']")).sendKeys("Lives in Pune");
	    driver.findElement(By.id("phone")).sendKeys("02012345");
	    driver.findElement(By.id("phone_mobile")).sendKeys("987654321");
	    driver.findElement(By.xpath("//input[@id='alias']")).sendKeys("India");
	 
	    driver.close();
	    System.out.println("Test Sucessfull");
	}
	
	public static void main(String[] args) throws InterruptedException {
		
		Assignment2 ass2 = new Assignment2();
		ass2.contactInfoMethod();
	}

}
