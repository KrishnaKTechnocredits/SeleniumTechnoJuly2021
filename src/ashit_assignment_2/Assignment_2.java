

/*Assignment - 2 : 16th Oct'2021
Automate Singup : 
http://automationpractice.com/index.php
*/

package ashit_assignment_2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment_2 {

	void verifyTextOnAutomationPractice() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		System.out.println("Chrome Browser opened");
		System.out.println("WebSite : " +"http://automationbykrishna.com/");
		driver.get("http://automationpractice.com/");

		System.out.println("STEP-Verify the text: Women");
		String womenText = driver.findElement(By.xpath("//a[@title='Women']")).getText();
		String expectedText1= "WOMEN";
		if (expectedText1.equals(womenText)) {
			System.out.println("Pass");
		}else {
			System.out.println("Fail");
		}

		System.out.println("STEP-Verify the text: Dresses");
		String dressText= driver.findElement(By.xpath("//div[@id = 'block_top_menu']/ul[@class ='sf-menu clearfix menu-content sf-js-enabled sf-arrows']/li[2]//a [@title= 'Dresses']")).getText();
		System.out.println(dressText);
		String expectedText2 = "DRESSES";
		if (expectedText2.equals(dressText)) {
			System.out.println("Pass");
		}else {
			System.out.println("Fail");
		}


		System.out.println("STEP-Verify the text: T-Shirts");
		String tshirtsText= driver.findElement(By.xpath("//div [@id ='block_top_menu']/ul [@class = 'sf-menu clearfix menu-content sf-js-enabled sf-arrows']/li[3]//a [@title = 'T-shirts']")).getText();
		String expectedText3 = "T-SHIRTS";
		if (expectedText3.equals(tshirtsText)) {
			System.out.println("Pass");
		}else {
			System.out.println("Fail");
		}

		System.out.println("STEP-Verify text on Sign in link");
		String signinText = driver.findElement(By.xpath("//a[contains(text(), 'Sign in')]")).getText();

		if ("Sign in".equals(signinText)) {
			System.out.println("Pass");
		}else {
			System.out.println("Fail");
		}

		System.out.println("STEP-click on the Sing in");
		driver.findElement(By.xpath("//a [@title ='Log in to your customer account']")).click();
		Thread.sleep(2000);
		System.out.println("STEP-Test case_2_1 executed successfully");
		driver.close();
	}

	public static void main(String []a) throws InterruptedException {
		Assignment_2 assingment_2 = new Assignment_2();
		assingment_2.verifyTextOnAutomationPractice();
	}
}
