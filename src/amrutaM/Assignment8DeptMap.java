package amrutaM;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.PredefinedActions;

/*Assignment - 8 : 23th Oct'2021
Return a map of Deptname and count of employee within each deptment.
o/p : 7001-Admin -> 2
      7002-Finance -> 2
	  7003-HR -> 2
	  7013-IT -> 3*/
public class Assignment8DeptMap {
	WebDriver driver;
	
	@BeforeClass
	public void beforeClass() {
		driver = PredefinedActions.start();
		System.out.println("Navigating to Demo Tables page ");
		driver.findElement(By.xpath("//a[text()='Demo Tables']")).click();
	}
	
	@Test
	public void getDeptDetailsMap() {
		HashMap<String , Integer> deptMap = new HashMap<>();
		int totalRows = driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr")).size();
		for(int rows = 1; rows<=totalRows;rows++) {
			String deptName = driver.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr["+rows+"]/td[5]")).getText();
			if(deptMap.containsKey(deptName)) {
				deptMap.put(deptName, deptMap.get(deptName)+1);
				
			}else {
				deptMap.put(deptName, 1);
			}
		}
		System.out.println(deptMap);
	}
	
	@AfterClass
	public void tearDown() {
		driver.close();
	}
	
}
