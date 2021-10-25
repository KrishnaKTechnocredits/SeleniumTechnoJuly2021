/*Automate Singup : 
http://automationpractice.com/index.php*/

package shraddha.Assignment2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class AutomateSignUp {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./resources/chromedriver.exe");
		System.out.println("Step 1:Launch the Browser");
		WebDriver driver = new ChromeDriver();
		System.out.println("Step 2:Open the url");
		driver.get("http://automationpractice.com/index.php");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		System.out.println("Step 3:Click on Sign In button");
		driver.findElement(By.xpath("//a[contains(text(),'Sign in')]")).click();
		Thread.sleep(3000);
		System.out.println("Step 4:Enter the email id for the new account creation");
		driver.findElement(By.xpath("//input[@name='email_create']")).sendKeys("shraddhaatal@gmail.com");
		System.out.println("Step 5: Click on Create an account");
		driver.findElement(By.xpath("//button[@name='SubmitCreate']")).click();
		Thread.sleep(5000);
		System.out.println("Step 6:Select the gender");
		driver.findElement(By.xpath("//div[@class='radio']/span/input[@id='id_gender2']")).click();
		System.out.println("Step 7:Enter the firstname");
		driver.findElement(By.xpath("//input[@name='customer_firstname']")).sendKeys("Shraddha");
		System.out.println("Step 8:Enter the lastname");
		driver.findElement(By.xpath("//input[@name='customer_lastname']")).sendKeys("Rathi");
		System.out.println("Step 9:Enter the password");
		driver.findElement(By.xpath("//input[@name='passwd']")).sendKeys("password");
		WebElement day = driver.findElement(By.xpath("//select[@name='days']"));
		Select selectDay = new Select(day);
		System.out.println("Step 10:Select the BirthDay from the Dropdown");
		selectDay.selectByValue("1");
		WebElement month = driver.findElement(By.xpath("//select[@name='months']"));
		Select selectMonth = new Select(month);
		System.out.println("Step 11:Select the BirthMonth from the Dropdown");
		selectMonth.selectByValue("11");
		WebElement year = driver.findElement(By.xpath("//select[@id='years']"));
		Select selectYear = new Select(year);
		System.out.println("Step 12:Select the BirthYear from the Dropdown");
		selectYear.selectByVisibleText("1985  ");
		System.out.println("Step 13:Enter the first name in Address section");
		driver.findElement(By.xpath("//input[@name='company']")).sendKeys("Cognizant");
		System.out.println("Step 14:Enter the Address1");
		driver.findElement(By.xpath("//input[@name='address1']")).sendKeys("Mankhool Area");
		System.out.println("Step 15:Enter the Address2");
		driver.findElement(By.xpath("//input[@name='address2']")).sendKeys("Bafta Grand");
		System.out.println("Step 16:Enter the City");
		driver.findElement(By.xpath("//input[@name='city']")).sendKeys("California");
		WebElement state = driver.findElement(By.xpath("//select[@name='id_state']"));
		Select selectState = new Select(state);
		System.out.println("Step 17:Select the State from the Dropdown");
		selectState.selectByVisibleText("Florida");
		System.out.println("Step 18:Enter the Zip/postal code");
		driver.findElement(By.xpath("//input[@name='postcode']")).sendKeys("2380");
		System.out.println("Step 19:Enter the Additional Information");
		driver.findElement(By.xpath("//textarea[@name='other']")).sendKeys("Additional Information Testing");
		System.out.println("Step 20:Enter the Home Phone Number");
		driver.findElement(By.xpath("//input[@name='phone']")).sendKeys("9988442211");
		System.out.println("Step 21:Enter the Mobile Phone Number");
		driver.findElement(By.xpath("//input[@name='phone_mobile']")).sendKeys("9988442211");
		System.out.println("Step 22:Enter the address alias for future reference");
		driver.findElement(By.xpath("//input[@name='alias']")).sendKeys(" Testing");
		System.out.println("Step 23:Script passed successfully");
		driver.close();
	}
}
