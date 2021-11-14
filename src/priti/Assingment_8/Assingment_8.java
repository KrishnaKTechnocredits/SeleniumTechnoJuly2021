package priti.Assingment_8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Assingment_8 {
	
	HashMap<String ,Integer>findUniqueEmpOFdept() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		System.out.println("Chrome Browser opened");
		System.out.println("WebSite : " +"http://automationbykrishna.com/");
		driver.get("http://automationbykrishna.com");
		Thread.sleep(3000);
		System.out.println("Step: Click on Demo Tables link");
		driver.findElement(By.linkText("Demo Tables")).click();
		Thread.sleep(3000);
		HashMap<String ,Integer> map = new HashMap<String, Integer>();
		System.out.println("Step: find the number of rows");
		int rowindex = driver.findElements(By.xpath(" //table[@class='table table-striped']/tbody/tr")).size();
		for (int index=1;index<=rowindex;index++) { 
			String deptName = driver.findElement(By.xpath(" //table[@class='table table-striped']/tbody/tr["+index+"]/td[5]")).getText();
			if (map.containsKey(deptName)) {
				int count= map.get(deptName);
				map.put(deptName, ++count);
			}else {
				map.put(deptName, 1);
			}
		}	
		System.out.println(map);
		return map;
	}	
	public static void main(String[] a) throws InterruptedException {
			Assingment_8 assingment_8 = new Assingment_8();
			assingment_8.findUniqueEmpOFdept();
			
		}
			
}				
		
/*Assignment - 8 : 23th Oct'2021
Return a map of Deptname and count of employee within each deptment.
o/p : 7001-Admin -> 2
      7002-Finance -> 2
	  7003-HR -> 2
	  7013-IT -> 3
	*/
	
	
	
	


