package margi.Assignment_5;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/*Test Case 5 - 
Go to "http://automationbykrishna.com/#"
Navigate to Basic Elements tab
Enter the FirstName , LastName & CompanyName in the Alert Demo section
Click on Submit button
Validate the alert message (Validate that the firstname, lastname and company name is correctly populated in the alert message)
Accept the alert
*/

public class Assignment_5_5 {

	String firstName, lastName, company;

	Assignment_5_5(String firstName, String lastName, String company) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.company = company;
	}

	void testCase_5() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","resources/chromedriver.exe");
		System.out.println("STEP : Launch browser");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("http://automationbykrishna.com/#");

		System.out.println("STEP : Click on Basic Elements");
		driver.findElement(By.xpath("//a[contains(text(),'Basic Elements')]")).click();

		Thread.sleep(3000);

		System.out.println("STEP : Enter first name");
		driver.findElement(By.xpath("//input[@id='UserFirstName']")).sendKeys(firstName);

		System.out.println("STEP : Enter last name");
		driver.findElement(By.xpath("//input[@id='UserLastName']")).sendKeys(lastName);

		System.out.println("STEP : Enter company name");
		driver.findElement(By.xpath("//input[@id='UserCompanyName']")).sendKeys(company);

		System.out.println("STEP : Click Submit button");
		driver.findElement(By.xpath("//button[@onclick='myFunctionPopUp()']")).click();

		Thread.sleep(2000);

		System.out.println("STEP : Check text");
		validateText(driver);

		System.out.println("Test passed successfully");
		driver.close();
	}

	void validateText(WebDriver driver) {
		Alert alert = driver.switchTo().alert();
		String actualText = alert.getText();
		alert.accept(); // ok
		String expectedText = firstName + " and " + lastName + " and " + company;
		if (actualText.contains(expectedText))
			System.out.println("valid text");
		else
			System.out.println("invalid text");
	}

	public static void main(String[] args) throws InterruptedException {
		new Assignment_5_5("margi", "santoki", "AtoZ").testCase_5();
	}
}
