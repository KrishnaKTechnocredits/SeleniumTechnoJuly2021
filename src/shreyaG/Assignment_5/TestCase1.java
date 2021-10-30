/*Test Case 1 -

Naivgate to "http://automationbykrishna.com/#"
Enter the login details
Validate the positive scenario for password (By entering 8 characters)
Validate the success message
Validate the negative scenario for password (Enter less than 8 characters)
Validate the failure message*/
package shreyaG.Assignment_5;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCase1 {
	void program1() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./resources/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		System.out.println("Launch the browser");
		driver.get("http://automationbykrishna.com/#");
		
		System.out.println("Click on registration link");
		driver.findElement(By.id("registration2")).click();
		Thread.sleep(3000);
		
		System.out.println("Enter username");
		driver.findElement(By.id("unameSignin")).sendKeys("UnnatiG");
		
		System.out.println("Enter Password");
		driver.findElement(By.id("pwdSignin")).sendKeys("Pwd@12345");
		
		System.out.println("Click on submit button");
		driver.findElement(By.id("btnsubmitdetails")).click();
		
		System.out.println("Validating success message by entering password more than 8 character");
		Alert alert=driver.switchTo().alert();
		String text=alert.getText();
		Thread.sleep(2000);
		
		String actualText="Success!";
		if(text.equals(actualText)) {
			alert.accept();
			System.out.println("**Valid password**");
		}
		
		Thread.sleep(2000);
		driver.findElement(By.id("pwdSignin")).clear();
		driver.findElement(By.id("pwdSignin")).sendKeys("Pwd@12");
		driver.findElement(By.id("btnsubmitdetails")).click();
		System.out.println("Validating failure message by entering password less than 8 character");
		String text1=alert.getText();
		Thread.sleep(3000);
		String exactText="Failed! please enter strong password";
		if(text1.equals(exactText)) {
			alert.dismiss();
			System.out.println("**Password is invalid**");
		}
		System.out.println("Test runs successfully");
		driver.close();
	}
	
		public static void main(String[] args) throws InterruptedException {
		new TestCase1().program1();
	}

}
