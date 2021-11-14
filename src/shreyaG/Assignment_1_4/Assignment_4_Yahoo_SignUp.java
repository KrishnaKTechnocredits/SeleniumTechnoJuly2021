package shreyaG.Assignment_1_4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment_4_Yahoo_SignUp {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./resources/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		System.out.println("Launch the browser");
		driver.get("https://login.yahoo.com/account/create?specId=yidReg");
		driver.manage().window().maximize();
		
		System.out.println("Enter first name");
		driver.findElement(By.xpath("//input[@id='usernamereg-firstName']")).sendKeys("Shreya");
		
		System.out.println("Enter last name");
		driver.findElement(By.xpath("//input[@id='usernamereg-lastName']")).sendKeys("Gulhane");
		
		System.out.println("Enter email");
		driver.findElement(By.xpath("//input[@name='yid']")).sendKeys("shreya_gulhane");
		
		System.out.println("Enter password");
		driver.findElement(By.id("usernamereg-password")).sendKeys("Pwd@1234");
		
		System.out.println("Enter mobile phone number");
		driver.findElement(By.id("usernamereg-phone")).sendKeys("2563489562");
		
		System.out.println("Enter DOB");
		WebElement selectMonth=driver.findElement(By.xpath("//select[@name='mm']"));
		Select selectElement=new Select(selectMonth);
		selectElement.selectByVisibleText("September");
		
		driver.findElement(By.xpath("//input[@placeholder='Day']")).sendKeys("1");
		
		driver.findElement(By.name("yyyy")).sendKeys("2001");
		
		System.out.println("Enter gender");
		driver.findElement(By.name("freeformGender")).sendKeys("Female");
		
		System.out.println("-----------------");
		System.out.println("Script runs successfully");
	}

}
