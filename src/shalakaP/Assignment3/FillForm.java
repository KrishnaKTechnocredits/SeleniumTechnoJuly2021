/*Assignment - 3: 16th Oct'2021
https://www.globalsqa.com/contact-us/
Verify Contact details.
Fill the form.*/
package shalakaP.Assignment3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FillForm {
	void verifyContactDetails() throws InterruptedException {
		System.setProperty("WebDriver.chrome.driver", "chromedriver.exe");
		System.out.println("Open Browser");
		WebDriver driver = new ChromeDriver();
		System.out.println("Step-Enter url");
		driver.get("https://www.globalsqa.com/contact-us/");
		driver.manage().window().maximize();

		Thread.sleep(3000);
		System.out.println("Step-Compare contact info");
		WebElement element = driver
				.findElement(By.xpath("//div[@id='contact_info-widget-3']//div[@class='icon_phone']"));
		String number = element.getText();
		if (number.equals("+91-9910979218"))
			System.out.println("Pass:contact number match");
		else
			System.out.println("Fail:contact number not match");

		WebElement element1 = driver
				.findElement(By.xpath("//div[@id='contact_info-widget-3']//div[@class='icon_mail']"));
		String email = element1.getText();
		if (email.equals("contact@globalsqa.com"))
			System.out.println("Pass:Email  match");
		else
			System.out.println("Fail:contact number not match");

		WebElement element2 = driver
				.findElement(By.xpath("//div[@id='contact_info-widget-3']//div[@class='icon_loc']"));
		String address = element2.getText();
		if (address.equals("146, VP Block, Pitampura, New Delhi-110034"))
			System.out.println("Pass: Address match");
		else
			System.out.println("Fail: Address not match");

		System.out.println("Fill contact form");
		System.out.println("Step-Enter Name");
		driver.findElement(By.xpath("//input[@id='comment_name']")).sendKeys("Shalaka");
		System.out.println("Step-Enter Email");
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("shalaka@gmail.com");
		System.out.println("Step-Enter Subject");
		driver.findElement(By.xpath("//input[@name='subject']")).sendKeys("Mathematics");
		System.out.println("Step-Enter Message");
		driver.findElement(By.xpath("//textarea[@name='comment']")).sendKeys("abcdefg");
		System.out.println("Step-Test Passed");
		driver.close();

	}

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		new FillForm().verifyContactDetails();
	}

}
