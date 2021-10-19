package elizabeth.Assignment_4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment4 {
	
	public static void main(String args[]) {
	System.setProperty("webdriver.chrome.driver", "./resources/chromedriver.exe");
	System.out.println("Step 1:Launch Browser");
	WebDriver driver=new ChromeDriver();
	System.out.println("Step 2:Open the URL");
	driver.get("https://login.yahoo.com/account/create?specId=yidReg");
	System.out.println("Step 3:Enter the first name");
	driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys("Elizabeth");
	System.out.println("Step 4:Enter the last name");
	driver.findElement(By.xpath("//input[@name='lastName']")).sendKeys("Mary");
	System.out.println("Step 5:Enter the email address");
	driver.findElement(By.xpath("//input[@name='yid']")).sendKeys("elizabethjems");
	System.out.println("Step 6:Enter the password");
	driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Technocredits");
	System.out.println("Step 7:Enter the Mobile number");
	driver.findElement(By.xpath("//input[@name='phone']")).sendKeys("9876543210");
	System.out.println("Step 8:Select the Birth Month");
	WebElement birthMonth=driver.findElement(By.xpath("//select[@name='mm']"));
	Select selectMonth=new Select(birthMonth);
	selectMonth.selectByVisibleText("April");
	System.out.println("Step 9:Enter the Birth Day");
	driver.findElement(By.xpath("//input[@name='dd']")).sendKeys("18");
	System.out.println("Step 10:Enter the Birth year");
	driver.findElement(By.xpath("//input[@name='yyyy']")).sendKeys("1998");
	System.out.println("Step 11:Enter the Gender");
	driver.findElement(By.xpath("//input[@name='freeformGender']")).sendKeys("Female");
	System.out.println("Step 11:Script executed successfully");
	driver.close();
	}

}
