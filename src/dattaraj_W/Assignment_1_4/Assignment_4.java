package dattaraj_W.Assignment_1_4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import dattaraj_W.base.PredefinedActions;

public class Assignment_4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = PredefinedActions.start("https://login.yahoo.com/account/create?specId=yidReg");
		System.out.println("STEP - Open Chrome Browser");
		
		System.out.println("STEP- Enter first name");
		driver.findElement(By.xpath("//input[@id='usernamereg-firstName']")).sendKeys("Dattaraj");
		
		System.out.println("STEP- Enter last name");
		driver.findElement(By.xpath("//input[@id='usernamereg-lastName']")).sendKeys("Wete");
		
		System.out.println("STEP- Enter email address");
		driver.findElement(By.name("yid")).sendKeys("d_er_wete");
		
		System.out.println("STEP- Enter password");
		driver.findElement(By.name("password")).sendKeys("Password@656#45");
		
		System.out.println("STEP- Enter mobile number");
		driver.findElement(By.name("phone")).sendKeys("7588901793");
		
		System.out.println("STEP- Select birth month");
		WebElement month=driver.findElement(By.xpath("//select[@id='usernamereg-month']"));
		Select selMonth= new Select(month);
		selMonth.selectByVisibleText("April");
		
		System.out.println("STEP- Enter birth date");
		driver.findElement(By.xpath("//input[@name='dd']")).sendKeys("06");
		
		System.out.println("STEP- Enter birth year");
		driver.findElement(By.xpath("//input[@name='yyyy']")).sendKeys("1995");
		
		System.out.println("STEP- Enter gender");
		driver.findElement(By.xpath("//input[@name='freeformGender']")).sendKeys("Male");
	}

}
