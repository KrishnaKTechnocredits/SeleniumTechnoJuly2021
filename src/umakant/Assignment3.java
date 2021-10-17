package umakant;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment3 {
	String email;
	String password;

	Assignment3(String email, String password) {
		this.email = email;
		this.password = password;
	}

	static WebDriver getBrowser() {
		System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		return driver;
	}

	void signUp() throws InterruptedException {
		System.out.println("Step-1:Launch the Browser");
		WebDriver driver = getBrowser();
		driver.manage().window().maximize();
		System.out.println("Step-2:Go to Automation Practice page");
		driver.get("http://automationpractice.com/index.php");
		Thread.sleep(3000);
		System.out.println("Step-3:Click on Sign In");
		driver.findElement(By.xpath("//a[contains(text(),'Sign in')]")).click();//
		Thread.sleep(3000);
		System.out.println("Step-4:Enter the email address");
		driver.findElement(By.xpath("//input[@id='email_create']")).sendKeys(email);
		System.out.println("Step-5:Click on create account");
		driver.findElement(By.xpath("//button[@id='SubmitCreate']")).click();
		Thread.sleep(3000);
		System.out.println("Step-6: Enter the title");
		driver.findElement(By.xpath("//input[@id='id_gender1']")).click();
		System.out.println("Step-7: Enter the First name");
		driver.findElement(By.xpath("//input[@id='customer_firstname']")).sendKeys("Umakant");
		System.out.println("Step-7: Enter the Last name");
		driver.findElement(By.xpath("//input[@id='customer_lastname']")).sendKeys("Sahani");
		System.out.println("Step-8: Enter the Password");
		driver.findElement(By.xpath("//input[@id='passwd']")).sendKeys(password);
		System.out.println("Step-9: Select the Day of Birth");
		WebElement selectElementDay = driver.findElement(By.xpath("//select[@id='days']"));
		Select selectDay = new Select(selectElementDay);
		selectDay.selectByValue("4");
		System.out.println("Step-10: Select the Month of Birth");
		WebElement selectElementMonths = driver.findElement(By.xpath("//select[@id='months']"));
		Select selectMonths = new Select(selectElementMonths);
		selectMonths.selectByValue("2");
		System.out.println("Step-11: Select the Year of Birth");
		WebElement selectElementYears = driver.findElement(By.xpath("//select[@id='years']"));
		Select selectYears = new Select(selectElementYears);
		selectYears.selectByValue("1995");
		System.out.println("Step-12: Select the signup for newsletter");
		driver.findElement(By.xpath("//input[@id='newsletter']")).click();
		System.out.println("Step-13: Select for special offer");
		driver.findElement(By.xpath("//input[@id='optin']")).click();
		System.out.println("Step-14:Enter the Address Details");
		driver.findElement(By.xpath("//input[@id='address1']")).sendKeys("T.D.R.");
		driver.findElement(By.xpath("//input[@id='city']")).sendKeys("Kolkata");
		WebElement selectElementState = driver.findElement(By.xpath("//select[@id='id_state']"));
		Select selectState = new Select(selectElementState);
		selectState.selectByVisibleText("New York");
		driver.findElement(By.xpath("//input[@id='postcode']")).sendKeys("70088");
		System.out.println("Step-15:Enter the Mobile Number");
		driver.findElement(By.xpath("//input[@id='phone_mobile']")).sendKeys("1234560879");
		System.out.println("Step-16:Enter the Reference Address");
		driver.findElement(By.xpath("//input[@id='alias']")).clear();
		driver.findElement(By.xpath("//input[@id='alias']")).sendKeys("test 123456");
		System.out.println("Step-16:Click on Register");
		driver.findElement(By.xpath("//button[@id='submitAccount']")).click();
		Thread.sleep(1000);// added to visualize it
		driver.findElement(By.xpath("//a[contains(text(),'Sign out')]")).click();
		Thread.sleep(1000);// added to visualize it
		driver.close();
	}

	void login() throws InterruptedException {
		System.out.println("Step-1:Launch the Browser");
		WebDriver driver = getBrowser();
		driver.manage().window().maximize();
		System.out.println("Step-2:Go to Automation Practice page");
		driver.get("http://automationpractice.com/index.php");
		Thread.sleep(3000);
		System.out.println("Step-3:Click on Sign In");
		driver.findElement(By.xpath("//a[contains(text(),'Sign in')]")).click();//
		Thread.sleep(3000);
		System.out.println("Step-4:Enter the email address");
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys(email);
		System.out.println("Step-4:Enter the Password");
		driver.findElement(By.xpath("//input[@id='passwd']")).sendKeys(password);
		System.out.println("Step-5:Click on Sign in");
		driver.findElement(By.xpath("//button[@id='SubmitLogin']")).click();
		Thread.sleep(1000);// added to visualize it
		driver.findElement(By.xpath("//a[contains(text(),'Sign out')]")).click();
		Thread.sleep(1000);// added to visualize it
		driver.close();
	}

	public static void main(String[] args) throws InterruptedException {
		Assignment3 automationPractice = new Assignment3("umakantsahani120034567@gmail.com", "Qwerty2021");
		System.out.println("-----SignUp-------");
		automationPractice.signUp();
		System.out.println("-----Login-------");
		automationPractice.login();
	}

}
