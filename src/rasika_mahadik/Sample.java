package rasika_mahadik;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Sample {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		driver.manage().window().fullscreen();
		Thread.sleep(2000);
		System.out.println(driver.getTitle());
		driver.get("file:///C:/Users/Rasika%20Mahadik/Downloads/Pattern%20Printing.pdf");
		driver.get("https://www.amazon.in/");
		System.out.println(driver.getPageSource());
		//driver.get("https://www.facebook.com/");
		driver.quit();
	}

}
