package priti.Assingment_1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assingment_1 {
	
	WebDriver start() {
		System.setProperty("webdriver.chrome.driver", "./resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		System.out.println("Chrome Browser opened");
		System.out.println("WebSite : " +"https://www.facebook.com");
		driver.get("https://www.facebook.com/");
		return driver;
	}
	
	void facebookLogin() throws InterruptedException{
		WebDriver driver =this.start();
		System.out.println("STEP -click on Create New account"  );
		driver.findElement(By.xpath("//a[@ class = '_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();
		Thread.sleep(2000);
		
		System.out.println("STEP -Enter First Name"  );
		driver.findElement(By.xpath("//input[@name ='firstname'] ")).sendKeys("Priti");
		
		System.out.println("STEP -Enter Last Name"  );
		driver.findElement(By.name("lastname")).sendKeys("Vattanavar");
		
		System.out.println("STEP -ReEnter Email Id"  );
		driver.findElement(By.name("reg_email__")).sendKeys("psvattanavar@gmail.com");
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//input[@ name = 'reg_email_confirmation__']")).sendKeys("psvattanavar@gmail.com");
		System.out.println("STEP -Enter Passowrd"  );
		driver.findElement(By.xpath("//input[@name = 'reg_passwd__']")).sendKeys("Priti123");
		
		System.out.println("STEP -Select your birth date"  );
		
		WebElement birtDayDate = driver.findElement(By.xpath ("//select[@aria-label='Day']"));
		Select selectbirtDayDate= new Select(birtDayDate);
		selectbirtDayDate.selectByVisibleText("17");
		
		System.out.println("STEP -Select your birth Month"  );	
		WebElement birtDayMonth = driver.findElement(By.xpath ("//select[@name = 'birthday_month' ]"));
		Select selectbirtDayMonth= new Select(birtDayMonth);
		selectbirtDayMonth.selectByVisibleText("Dec");
		
		System.out.println("Step-Enter birthday year");
		WebElement birthYear = driver.findElement(By.xpath("//select[@name = 'birthday_year' ]"));
		Select selectbirthYear = new Select(birthYear);
		selectbirthYear.selectByVisibleText("1976");
		
		System.out.println("Step-Select gender as Female");
		WebElement femaleGenderelement = driver.findElement(By.xpath("//input[@value='1']"));
		femaleGenderelement.click();
		
		System.out.println("Step-Selct gender as Male");
		WebElement maleGenderelement = driver.findElement(By.xpath("//input[@value='2']"));
		maleGenderelement.click();
		
		System.out.println("Step-Select gender as custom");
		WebElement customGenderelement = driver.findElement(By.xpath("//input[@value='-1']"));
		customGenderelement.click();
		
		driver.close();
		System.out.print("Test case executed successfully");
	}
	
	
	
	public static void main(String[] a) throws InterruptedException {
		Assingment_1 assingment_1 = new Assingment_1();
		assingment_1.facebookLogin();
		
		
	}
	
	
	
}
