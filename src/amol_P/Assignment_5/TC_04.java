package amol_P.Assignment_5;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;


import amol_P.Assignment_5.Start;

public class TC_04 extends Start{
	void checkJavaScriptPrompt(String name)
	{
		driver.findElement(By.xpath("//button[@id='javascriptPromp']")).click();
		System.out.println("Clicked on Prompt button");
		Alert al= driver.switchTo().alert();
		al.sendKeys(name);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		al.accept();
		String expected="Hello "+ name+"! How are you today?";
		System.out.println("Expected alert message: " +expected);
		String actual=driver.findElement(By.xpath("//p[@id='pgraphdemo']")).getText();
		if(actual.equals(expected))
		{
			System.out.println("Actual alert message: "+actual);
			System.out.println("Test case passed");
		}
		else
		{
			System.out.println("Expected alert message" +expected);
			System.out.println("Actual alert message: "+actual);
			System.out.println("Test case Failed");
		}
		
	}
	public static void main(String[] args) {
		Start.LoadURl();
		TC_04 TC_04=new TC_04();
		TC_04.checkJavaScriptPrompt("Amol");
		driver.quit();
	}

}
