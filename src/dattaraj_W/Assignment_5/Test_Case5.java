package dattaraj_W.Assignment_5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Test_Case5 {
		
		WebDriver driver;
		
		public Test_Case5(String url) {
			System.setProperty("webdriver.chrome.driver", "./resources/chromedriver.exe");
			System.out.println("STEP - Open Chrome Browser");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			System.out.println("STEP - Enter url");
			driver.get(url);
		}
		
		//Test Case-5
		void Case5() throws InterruptedException {
			Thread.sleep(3000);
			System.out.println("STEP- Tap on basic elements");
			driver.findElement(By.xpath("//a[@id='basicelements']")).click();
			//Thread.sleep(3000);
			System.out.println("STEP- Enter First Name");
			String firstName = "Dattaraj";
			driver.findElement(By.xpath("//input[@id='UserFirstName']")).sendKeys(firstName);
			System.out.println("STEP- Enter Last Name");
			String lastName = "Wete";
			driver.findElement(By.xpath("//input[@id='UserLastName']")).sendKeys(lastName);
			System.out.println("STEP- Enter Company Name");
			String companyName = "TCS";
			driver.findElement(By.xpath("//input[@id='UserCompanyName']")).sendKeys(companyName);
			System.out.println("STEP- Tap on submit button");
			driver.findElement(By.xpath("//button[@onclick='myFunctionPopUp()']")).click();
			System.out.println("STEP- Get alert message");
			String alertMessage = driver.switchTo().alert().getText();
			String expectedAlertMessage = firstName + " and " + lastName + " and " + companyName;
			System.out.println("STEP- Validate alert message");
			if(alertMessage.equals(expectedAlertMessage))
				System.out.println("Alert message match");
			else
				System.out.println("Alert message not match");
			driver.switchTo().alert().accept();
			
			driver.close();
			driver.quit();
		}
		
		public static void main(String[] args) throws InterruptedException {
			String url= "http://automationbykrishna.com/#";
			new Test_Case5(url).Case5();
		}
}
