package ritabrata_bhattacharyya;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class Assignment_3 {
	static WebDriver driver;

	void VerifyMob(String num) {
		String phoneNumber = driver.findElement(By.xpath("//div[@class='icon_phone']")).getText();
		if (phoneNumber.equals(num)) {
			System.out.println(phoneNumber + " is valid number");
		} else

		{
			System.out.println(phoneNumber + " is not valid number");
		}
	}

	void verifyEmail(String email) {
		String mailId = driver.findElement(By.xpath("//div[@class='icon_mail']")).getText();
		if (mailId.equals(email)) {
			System.out.println(mailId + " is valid mail id");
		} else

		{
			System.out.println(mailId + " is not valid mail");
		}
	}

	void verifyAddress(String address) {
		String address1 = driver.findElement(By.xpath("//div[@class='icon_loc']")).getText();
		if (address1.equals(address)) {
			System.out.println(address1 + " is correct address");
		} else

		{
			System.out.println(address1 + " is incorrect address");
		}
	}

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"D:\\Software\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.globalsqa.com/contact-us/");

		Assignment_3 assignment_3 = new Assignment_3();
		assignment_3.VerifyMob("+91-9910979218");
		assignment_3.verifyEmail("contact@globalsqa.com");
		assignment_3.verifyAddress("146, VP Block, Pitampura, New Delhi-110034");

		driver.findElement(By.xpath("//input[@class='aqua_input' and @id='comment_name']")).sendKeys("Ritabrata");

		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("r.bhattacharyya96@gmail.com");

		driver.findElement(By.xpath("//input[@name='subject'][@id='subject']")).sendKeys("Subject selected successfully");

		driver.findElement(By.xpath("//textarea[@name='comment']")).sendKeys("This is my 3rd assignment of Selenium");

	}


	

}
