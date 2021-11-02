package amol_P.Assignment_5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Start {
	static WebDriver driver;

	public static void LoadURl() {
		System.setProperty("webdriver.chrome.driver", "./resources//chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://automationbykrishna.com/#");
		driver.manage().window().maximize();
		System.out.println("Click on Basic Element");
		driver.findElement(By.xpath("//a[@id='basicelements']")).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}