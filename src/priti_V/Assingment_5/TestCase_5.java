package priti_V.Assingment_5;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCase_5 {
	void alertDemoSectionForm(String firstName, String lastName, String company) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./resources/chromedriver.exe");
		System.out.println("Chrome Browser opened");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		System.out.println("Website :automationbykrishna.com");
		driver.get("http://automationbykrishna.com/");
		
		System.out.println("Step: Click on the Basic Elemets link/menu");
		driver.findElement(By.xpath("//a[@id ='basicelements']" )).click();
		Thread.sleep(4000);
		
		System.out.println("Step: Enter FirstName");
		driver.findElement(By.xpath("//input [@id ='UserFirstName']" )).sendKeys(firstName);
		System.out.println("Step: LastName");
		driver.findElement(By.xpath("//input [@id ='UserLastName']" )).sendKeys(lastName);
		System.out.println("Step: Company Name");
		driver.findElement(By.xpath("//input [@id ='UserCompanyName']" )).sendKeys(company);
		
		System.out.println("Step: Click on the Submit Button");
		driver.findElement(By.xpath("//div[@name='secondSegment'][1]/section/div/div /button[@type ='submit']" )).click();
		
		System.out.println("Step: Handle the alert and validate the alert message ");
		
		String expected = firstName + " and " + lastName + " and " + company;
		/*System.out.println(expected.length());
		String str = "priti and Vattanavar and Globant";
		System.out.println(str.length());*/
		
		Alert alert = driver.switchTo().alert();
		if (alert.getText().equals(expected)) {
			System.out.println("alert message is correctly poulated with all input data");
			System.out.println("Step: Accpet the alert ");
			alert.accept();
			
		}else {
			System.out.println("alert message is not correctly poulated with all input data");
			System.out.println("Step: Accpet the alert ");
			alert.accept();
		}
		
			
			System.out.println("Test case_5_5 passed successfully ");
			driver.close();
	}
	
	
	public static void main(String[] a) throws InterruptedException {
		TestCase_5 testCase_5 = new TestCase_5();
		String firstName = "Prit";
		String lastName = "Vattanavar";
		String company = "Globant";
		testCase_5.alertDemoSectionForm("Prit", "Vattanavar", "Globant") ;
	}
}
/*Go to "http://automationbykrishna.com/#"
Navigate to Basic Elements tab
Enter the FirstName , LastName & CompanyName in the Alert Demo section
Click on Submit button
Validate the alert message (Validate that the firstname, lastname and company name is correctly populated in the alert message)
Accept the alert*/
