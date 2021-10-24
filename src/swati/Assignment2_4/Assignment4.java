package swati.Assignment2_4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment4 {
	
	void validateYahooLogin() {
		
		System.setProperty("webdriver.chrome.driver", "./resources/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		System.out.println("Enter URL");
		driver.get("https://login.yahoo.com/account/create?specId=yidReg");
		driver.manage().window().maximize();
		System.out.println("Enter FirstName");
		driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys("Swati");
		System.out.println("Enter LastName");
		driver.findElement(By.xpath("//input[@name='lastName']")).sendKeys("Salunke");
		System.out.println("Enter UserName ");
		driver.findElement(By.xpath("//input[@name='yid']")).sendKeys("swaticccc9131");
		System.out.println("Enter Password");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("swaticccc9131");
		System.out.println("Enter Phone No");
		driver.findElement(By.xpath("//input[@name='phone']")).sendKeys("9881616400");
		System.out.println("Select Month ");
		WebElement month=driver.findElement(By.xpath("//select[@name='mm']"));
		Select mn=new Select(month);
		mn.selectByValue("2");
		System.out.println("Enter day ");
		driver.findElement(By.xpath("//input[@name='dd']")).sendKeys("2");
		System.out.println("Enter Year ");
		driver.findElement(By.xpath("//input[@name='yyyy']")).sendKeys("2002");
		System.out.println("Enter Gender");
		driver.findElement(By.xpath("//input[@name='freeformGender']")).sendKeys("Female");
		System.out.println("Success");
		driver.close();		
		
	}
	
	public static void main(String[] args) {
		Assignment4 a1=new Assignment4();
		a1.validateYahooLogin();
		
	}

}
