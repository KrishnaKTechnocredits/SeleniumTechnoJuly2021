/*Test Case 5 - 
Go to "http://automationbykrishna.com/#"
Navigate to Basic Elements tab
Enter the FirstName , LastName & CompanyName in the Alert Demo section
Click on Submit button
Validate the alert message (Validate that the firstname, lastname and company name is correctly populated in the alert message)
Accept the alert*/

package vivek.Assignment05;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCase5 {

	static WebDriver openBrowser(String url) {
		System.setProperty("webdriver.chrome.driver", "./resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
		return driver;
	}

	static void validateAlertDemoSection() throws InterruptedException {
		System.out.println("Step 1: Open the browser");
		WebDriver driver = openBrowser("http://automationbykrishna.com/");
		System.out.println("Step 2: Click on Basic Elements");
		driver.findElement(By.linkText("Basic Elements")).click();
		Thread.sleep(2000);
		System.out.println("Step 3: Enter the FirstName , LastName & CompanyName in the Alert Demo section");
		String firstName = "Vivek";
		String lastName = "Patil";
		String companyName = "Accenture";
		driver.findElement(By.id("UserFirstName")).sendKeys(firstName);
		driver.findElement(By.id("UserLastName")).sendKeys(lastName);
		driver.findElement(By.id("UserCompanyName")).sendKeys(companyName);
		System.out.println("Step 4: Click on Submit button");
		driver.findElement(By.xpath("//*[@class = 'col-lg-6'][1]//button")).click();
		System.out.println("Step 5: Validate the alert message");
		Alert alert = driver.switchTo().alert();
		String expectedMessage = firstName + " and " + lastName + " and " + companyName;
		String actualMessage = alert.getText();
		if (actualMessage.equals(expectedMessage))
			System.out.println(actualMessage + " is the expected message to be displayed");
		else
			System.out.println(actualMessage + " is not the expected message");
		System.out.println("Step 5: Accept the alert");
		alert.accept();
	}

	public static void main(String[] args) throws InterruptedException {
		validateAlertDemoSection();
	}
}
