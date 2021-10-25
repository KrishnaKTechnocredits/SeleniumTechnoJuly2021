/*Assignment - 4: 16th Oct'2021
Yahoo Signup.
https://login.yahoo.com/account/create?specId=yidReg
*/
package deepakK.assignment_01_to_04;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import base.PredefinedActions;

public class assignment04 {
	
	void signUp() {
		WebDriver driver = new PredefinedActions().start("https://login.yahoo.com/account/create?specId=yidReg");
				
		System.out.println("Step 2: Enter First Name");
		driver.findElement(By.xpath("//input[@name = 'firstName']")).sendKeys("Deepak");
		
		System.out.println("Step 3: Enter Surname");
		driver.findElement(By.xpath("//input[@name = 'lastName']")).sendKeys("Kankhar");
		
		System.out.println("Step 4: Enter email address");
		driver.findElement(By.xpath("//input[@name = 'yid']")).sendKeys("dgkankhar21");
		
		System.out.println("Step 5: Enter Password");
		driver.findElement(By.xpath("//input[@name = 'password']")).sendKeys("#passdeep$");
		
		System.out.println("Step 6: Enter Phone Number");
		driver.findElement(By.xpath("//input[@name = 'phone']")).sendKeys("9898765654");
		
		System.out.println("Step 7: Enter Date of Birth");
		WebElement month = driver.findElement(By.xpath("//select[@name = 'mm']"));
		Select month1 = new Select(month);
		month1.selectByVisibleText("September");
		
		driver.findElement(By.xpath("//input[@name = 'dd']")).sendKeys("28");
		
		driver.findElement(By.xpath("//input[@name = 'yyyy']")).sendKeys("1990");
		
		System.out.println("Step 8: Enter the Gender");
		driver.findElement(By.xpath("//input[@name = 'freeformGender']")).sendKeys("MALE");
		
		System.out.println("All details entered successfully");
		
	}
	
	public static void main(String[] args) {
		assignment04 obj = new assignment04();
		obj.signUp();
				

	}

}
