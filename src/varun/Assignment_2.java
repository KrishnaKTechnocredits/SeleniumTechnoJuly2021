package varun;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment_2 {

	void automationSignUp() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./resources/chromedriver.exe");
		System.out.println("STEP - Open Chrome Browser");
		WebDriver driver = new ChromeDriver();
		System.out.println("STEP - Enter automation url");
		driver.get("http://automationpractice.com");

		System.out.println("Click on SignIn Button");
		driver.findElement(By.xpath("//a[@class='login']")).click();
		Thread.sleep(3000);
		System.out.println("Enter valid EmailId");
		driver.findElement(By.id("email_create")).click();
		driver.findElement(By.id("email_create")).sendKeys("var.josh@as.cas");
		System.out.println("Click on create an account button");
		driver.findElement(By.id("SubmitCreate")).click();
		
		Thread.sleep(3000);
		System.out.println("Select title");
		driver.findElement(By.id("id_gender1")).click();

		System.out.println("Please enter firstname");
		WebElement firstname = driver.findElement(By.xpath("//input[@name='customer_firstname']"));
		firstname.click();
		firstname.sendKeys("Varun");

		System.out.println("Please enter lastName");
		WebElement lastname = driver.findElement(By.xpath("//input[@name='customer_lastname']"));
		lastname.click();
		lastname.sendKeys("Joshi");	

		System.out.println("Please enter Valid Email");
		WebElement password = driver.findElement(By.id("passwd"));
		password.click();
		password.sendKeys("test1234");
		
		System.out.println("STEP - Enter Date of birth");
		WebElement birthDayelement = driver.findElement(By.xpath("//select[@name='days']"));
		Select birthDaySelect = new Select(birthDayelement);
		birthDaySelect.selectByValue("26");
		
		System.out.println("STEP - Enter Month of birth");
		WebElement birthmonthelement = driver.findElement(By.xpath("//div[@id='uniform-months']/select[@id='months']"));
		birthmonthelement.click();
		Select birthMonthSelect = new Select(birthmonthelement);
		birthMonthSelect.selectByVisibleText("January ");
		
		System.out.println("STEP - Enter year of birth");
		WebElement birthyearelement = driver.findElement(By.xpath("//select[@name='years']"));
		birthyearelement.click();
		Select birthYearSelect = new Select(birthyearelement);
		birthYearSelect.selectByValue("1991");
		
		//YOUR ADDRESS
		System.out.println("Enter the company details");
		driver.findElement(By.xpath("//input[@name='company']")).sendKeys("Cybage");
		
		System.out.println("Enter your address");
		driver.findElement(By.xpath("//input[@name='address1']")).sendKeys("Bramha Avenue");
		driver.findElement(By.xpath("//input[@name='address2']")).sendKeys("Kondhwa");
		driver.findElement(By.xpath("//input[@name='city']")).sendKeys("PUNE");
		
		System.out.println("Enter state");
		WebElement state = driver.findElement(By.xpath("//select[@name='id_state']"));
		state.click();
		Select stateName = new Select(state);
		stateName.selectByVisibleText("Arizona");
		
		System.out.println("Enter PostalCode");
		driver.findElement(By.xpath("//input[@name='postcode']")).sendKeys("20310");
		
		System.out.println("Enter Additional Information");
		driver.findElement(By.xpath("//textarea[@name='other']")).sendKeys("This is just for Automation script");
		
		System.out.println("Enter Phone Number");
		driver.findElement(By.xpath("//input[@name='phone']")).sendKeys("123456789");
		
		System.out.println("Enter Mobile Number");
		driver.findElement(By.xpath("//input[@name='phone_mobile']")).sendKeys("8487451154");
		
		System.out.println("Please assign an address");
		driver.findElement(By.xpath("//input[@name='alias']")).sendKeys("Kondhwa,pune");
		
		System.out.println("Please click on submit button");
		driver.findElement(By.xpath("//button[@name='submitAccount']")).click();
		
		System.out.println("Test Case is Passed");
	}

	public static void main(String[] args) throws InterruptedException {
		Assignment_2 assignment_2 = new Assignment_2();
		assignment_2.automationSignUp();
	}
}
