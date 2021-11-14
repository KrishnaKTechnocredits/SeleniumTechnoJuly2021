package amol_P.Assignment_5;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

public class TC_02 extends Start{

	void verifyAlert() 
	{
		
		
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//button[@id='javascriptAlert']")).click();
	
		Alert al=driver.switchTo().alert();
		String actualAlertText= al.getText();
		if(actualAlertText.equals("You must be TechnoCredits student!!"))
		{
			System.out.println("Test Case Passed");
		}
		else
		{
			System.out.println("Test Case Failed");
		}
		al.accept();
		driver.quit();
	}
	public static void main(String[] args) {
		TC_02 TC_02=new TC_02();
		Start.LoadURl();
		TC_02.verifyAlert();

	}

}
