package amol_P.Assignment_5;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;


import amol_P.Assignment_5.Start;

public class TC_05 extends Start {

	void checkDetails(String fName,String lName,String company)
	{
		System.out.println("Enter First Name");
		driver.findElement(By.xpath("//input[@name='ufname']")).sendKeys(fName); 
		System.out.println("Enter Last Name");
		driver.findElement(By.xpath("//input[@name='ulname']")).sendKeys(lName); 
		System.out.println("Enter Companay Name");
		driver.findElement(By.xpath("//input[@name='cmpname']")).sendKeys(company); 
		
		driver.findElement(By.xpath("//button[@type='submit']")).click();; 
		Alert al= driver.switchTo().alert();
	String actualDetails=	al.getText();
	System.out.println("Accept the alert");
	al.accept();
	String expectedDetails=fName+" and "+lName+" and "+company;
	if(actualDetails.equals(expectedDetails))
	{
		System.out.println("Actual Message: "+actualDetails);
		System.out.println("Expected Message: "+expectedDetails);
		System.out.println("Test case passed");
	}
	else
	{
		System.out.println("Actual Message: "+actualDetails);
		System.out.println("Expected Message: "+expectedDetails);
		System.out.println("Test case Failed");
	}
		
	}
	public static void main(String[] args) {
		Start.LoadURl();
		TC_05 TC_05=new TC_05();
		String firstName="Amol";
		String lastName="Pawar";
		String company="Techno";
		
		TC_05.checkDetails(firstName,lastName,company);
		driver.quit();

	}

}
