package amolVyas.Assignment_5;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TestCase_1 {

	void loginPage(String name, String password) throws InterruptedException {
		WebDriver driver = Action.start();
		System.out.println("STEP-Navigate to Registration Page");
		driver.findElement(By.xpath("//a[text()='Registration']")).click();
		Thread.sleep(5000);
		System.out.println("STEP-Enter Name");
		driver.findElement(By.xpath("//input[@id='unameSignin']")).sendKeys(name);
		System.out.println("STEP-Enter Password");
		driver.findElement(By.xpath("//input[@id='pwdSignin']")).sendKeys(password);
		System.out.println("STEP-Click on Submit button");
		driver.findElement(By.xpath("//button[@id='btnsubmitdetails']")).click();
		Thread.sleep(2000);
		Alert alert = driver.switchTo().alert();
		String actual = alert.getText();
		if (password.length() > 8 && actual.equalsIgnoreCase("Success!")) {
			System.out.println("Password Length is more than 8 character and registraion completed");
			alert.accept();
		} else if (password.length() < 8 && actual.equalsIgnoreCase("Failed! please enter strong password")) {
			System.out.println("Password Length is less than 8 character and registraion Failed");
			alert.accept();

		}
		System.out.println("STEP- Test case 1 Passed");
		driver.close();
	}

	public static void main(String[] args) throws InterruptedException {
		new TestCase_1().loginPage("Amol", "Vyas");
		new TestCase_1().loginPage("Amol", "Vyas12345");
		
	}

}
