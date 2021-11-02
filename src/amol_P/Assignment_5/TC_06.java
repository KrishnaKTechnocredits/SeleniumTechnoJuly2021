package amol_P.Assignment_5;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;


import amol_P.Assignment_5.Start;

public class TC_06 extends Start{
	void verifySuccessMessage(String email,String password)
	{
		System.out.println("Enter email id");
		driver.findElement(By.xpath("//input[@id='exampleInputEmail1']")).sendKeys(email);
		System.out.println("Enter password");
		driver.findElement(By.xpath("//input[@id='pwd']")).sendKeys(password);
		System.out.println("Click on submit button");
		driver.findElement(By.xpath("//button[@id='submitb2']")).click();
		
		
		
		Alert al= driver.switchTo().alert();
	String actualMessage=	al.getText();
	al.accept();
		if(actualMessage.equals("You successfully clicked on it"))
		{
			System.out.println("Actual message is "+actualMessage);
			System.out.println("Test case Passed");
		}
	}
	public static void main(String[] args) {
		Start.LoadURl();
		TC_06 TC_06=new TC_06();
		TC_06.verifySuccessMessage("test@gmail.com", "sd");

	}

}
