package dattaraj_W.Assignment_1_4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import dattaraj_W.base.PredefinedActions;

public class Assignment_3 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = PredefinedActions.start("https://www.globalsqa.com/contact-us/");
		System.out.println("STEP - Open Chrome Browser");
		
		String moble_num = driver.findElement(By.xpath("//div[@class='icon_phone']")).getText();
		if(moble_num.equals("+91-9910979218")) {
			System.out.println(moble_num + " is valid number");
		}else {
			System.out.println(moble_num + " is valid number");
		}
		
		String email = driver.findElement(By.xpath("//div[@class='icon_mail']")).getText();
		if(email.equals("contact@globalsqa.com")) {
			System.out.println(email + " is valid email");
		}else {
			System.out.println(email + " is valid email");
		}
		
		String address = driver.findElement(By.xpath("//div[@class='icon_loc']")).getText();
		if(address.equals("146, VP Block, Pitampura, New Delhi-110034")) {
			System.out.println(address + " is valid address");
		}else {
			System.out.println(address + " is valid address");
		}
		
		driver.findElement(By.xpath("//input[@class='aqua_input' and @id='comment_name']")).sendKeys("Dattaraj");

		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("dattarajwete@gmail.com");

		driver.findElement(By.xpath("//input[@name='subject'][@id='subject']")).sendKeys("Subject selected");

		driver.findElement(By.xpath("//textarea[@name='comment']")).sendKeys("3rd assignment");
	}

}
