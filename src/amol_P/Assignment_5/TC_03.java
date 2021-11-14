package amol_P.Assignment_5;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;


import amol_P.Assignment_5.Start;;

public class TC_03 extends Start {

	void verifyJavaScriptConfirmation(String alert)
	{
		
		driver.findElement(By.xpath("//button[@id='javascriptConfirmBox']")).click();
		Alert al= driver.switchTo().alert();
		String actualAlert= al.getText();
		
		System.out.println("Switched to alert");
	if(alert.equals("accept"))
	{
		String actualOkMassage=null;
		al.accept();
		System.out.println("Alert Accepted");
		if(actualAlert.equals("Are you are doing your homework regularly, Press Okay else Cancel!!"))
		{
			 actualOkMassage= driver.findElement(By.xpath("//p[text()='You pressed OK!']")).getText();
			if(actualOkMassage.equals("You pressed OK!"))
			{
				System.out.println("Actual Message "+actualOkMassage);
				System.out.println("Test case passed");
			}
		}
		else
		{
			System.out.println("Expected alert is Are you are doing your homework regularly, Press Okay else Cancel!! but actaul Alert is "+actualOkMassage);
			System.out.println("Test case Failed");
		}
	}
	else
	{
		al.dismiss();
		System.out.println("Alert Cancelled");
		if(actualAlert.equals("Are you are doing your homework regularly, Press Okay else Cancel!!"))
		{
			String actualCancelMassage= driver.findElement(By.xpath("//p[text()='You pressed Cancel!']")).getText();
			if(actualCancelMassage.equals("You pressed Cancel!"))
			{
				System.out.println("Actual Message "+actualCancelMassage);
				System.out.println("Test case passed");
			}
		}
		else
		{
			System.out.println(" Expected Alert is Are you are doing your homework regularly, Press Okay else Cancel!! but Actual alert is: "+actualAlert);
			System.out.println("Test case Failed");
		}
		
	}
	}
	public static void main(String[] args) {
		Start.LoadURl();
		TC_03 TC_03=new TC_03();
		String acceptAlert="accept";
		String cancelAlert="cancel";
		TC_03.verifyJavaScriptConfirmation(acceptAlert);

	}

}
