package amol_P.Assignment_6;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment_6 {

	public static void main(String[] args) throws InterruptedException
	{
		WebDriver driver= PredifineAction.start();
		System.out.println("Step 2- Click on Basic Element");
		driver.findElement(By.xpath("//a[text()='Basic Elements']")).click();
		
			Thread.sleep(2000);
		
		System.out.println("Step 3- Get ID of basic window");
		
		String basicWindowID= driver.getWindowHandle();
		System.out.println(basicWindowID);
		System.out.println("Step 4- Click on MltiWindow button");	
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		js.executeScript("window.scrollBy(0,300)");
		driver.findElement(By.xpath("//button[@id='javascriptMultiWindow']")).click();	
		Thread.sleep(2000);
		System.out.println("Step 5- Get ID of All open window ");		
		Set<String> allWindowID=driver.getWindowHandles();
		System.out.println(allWindowID);
		for(String windowID :allWindowID)
		{
		
			if(!(windowID.contains(basicWindowID)))
			{
				System.out.println("Step 6- Move to new open window");
				driver.switchTo().window(windowID);
				System.out.println("ID of new Open window "+windowID);
				System.out.println("Close the browser");
				driver.close();
				break;
			}
			
		
		 }
		
			
		}
		
		

	}


