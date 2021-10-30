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

//print the name of deptment having maximum employees.
public class Program3 {
	WebDriver driver;
	
	@BeforeMethod
	void start() {
		System.setProperty("webdriver.chrome.driver", "./resources/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://automationbykrishna.com");
		driver.manage().window().maximize();
	}
	
	String getDeptWithMaxEmp() {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.linkText("Demo Tables")).click();
		HashMap<String,Integer> deptEmpMap = new HashMap();
		int rows = driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr")).size();
		for(int rowIndex = 1; rowIndex <= rows; rowIndex++) {
			String dept = driver.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr["+rowIndex+"]/td[5]")).getText();
			if(deptEmpMap.containsKey(dept))
				deptEmpMap.put(dept, deptEmpMap.get(dept)+1);
			else
				deptEmpMap.put(dept, 1);
		}
		String deptWithMaxEmp = "";
		int maxEmp = 0;
		for(String key:deptEmpMap.keySet()) {
			if(deptEmpMap.get(key) > maxEmp) {
				maxEmp = deptEmpMap.get(key);
				deptWithMaxEmp = key;
			}
		}
		return deptWithMaxEmp;
	}
	
	@Test
	void displayDeptWithMaxEmp() {
		System.out.println(getDeptWithMaxEmp());
	}
	@AfterMethod
	void end() {
		driver.close();
	}
}
