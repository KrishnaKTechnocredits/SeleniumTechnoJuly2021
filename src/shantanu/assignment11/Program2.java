package shantanu.assignment11;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

//print employee id which is duplicate in table-2
public class Program2 {
	WebDriver driver;
	
	@BeforeMethod
	void start() {
		System.setProperty("webdriver.chrome.driver", "./resources/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://www.automationbykrishna.com");
		driver.manage().window().maximize();
	}
	
	ArrayList<Integer> getDuplicateEmpID() {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.linkText("Demo Tables")).click();
		int rows = driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr")).size();
		HashMap<Integer,Integer> empIDMap = new HashMap();
		for(int rowIndex = 1; rowIndex <= rows; rowIndex++) {
			int empID = Integer.parseInt(driver.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr["+rowIndex+"]/td[2]")).getText());
			if(empIDMap.containsKey(empID))
				empIDMap.put(empID, empIDMap.get(empID)+1);
			else
				empIDMap.put(empID, 1);
		}
		ArrayList<Integer> duplicateID = new ArrayList();
		for(int key:empIDMap.keySet()) {
			if(empIDMap.get(key) > 1)
				duplicateID.add(key);
		}
		return duplicateID;
	}
	
	@Test
	void displayDuplicateEmpID() {
		System.out.println(getDuplicateEmpID());
	}
	@AfterMethod
	void end() {
		driver.close();
	}
}
