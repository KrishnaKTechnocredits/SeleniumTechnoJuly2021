/*Assignment - 4: 16th Oct'2021

Yahoo Signup.
https://login.yahoo.com/account/create?specId=yidReg
*/
package nishi.Assignment1_4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class YahooSingUp {
	public static void main(String[] args) {
		new YahooSingUp().fillSignUp();
	}

	void fillSignUp() {
		System.setProperty("webdriver.chrome.driver", "./resources/chromedriver.exe");
		System.out.println("STEP - Open Chrome Browser");
		WebDriver driver = new ChromeDriver();
		System.out.println("STEP - Enter url");
		driver.get("https://login.yahoo.com/account/create?specId=yidReg");
		System.out.println("STEP 1 : Enter First Name ");
		driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys("Nishi");
		System.out.println("STEP 2 : Enter Second Name ");
		driver.findElement(By.xpath("//input[@name='lastName']")).sendKeys("Bharti");
		System.out.println("STEP 3 : Enter email-id ");
		driver.findElement(By.xpath("//input[@name='yid']")).sendKeys("nishikol");
		System.out.println("STEP 4 : Enter password ");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("nishikol@");
		System.out.println("STEP 5 : Enter mobile no ");
		driver.findElement(By.xpath("//input[@name='phone']")).sendKeys("1122334455");
		System.out.println("STEP 6 : Enter birth month ");
		WebElement birthmm=driver.findElement(By.xpath("//select[@name='mm']"));
		Select ddSelect=new Select(birthmm);
		ddSelect.selectByValue("10");
		System.out.println("STEP 7 : Enter dd ");
		driver.findElement(By.xpath("//input[@name='dd']")).sendKeys("12");
		System.out.println("STEP 8 : Enter yy ");
		driver.findElement(By.xpath("//input[@name='yyyy']")).sendKeys("1995");
		System.out.println("STEP 9 : Enter gender");
		driver.findElement(By.xpath("//input[@name='freeformGender']")).sendKeys("female");
		
		
	}

}
