package shantanu.assignment8;
/*
 Return a map of Deptname and count of employee within each deptment.
o/p : 7001-Admin -> 2
      7002-Finance -> 2
	  7003-HR -> 2
	  7013-IT -> 3
 */

import base.PredefinedActions;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Assignment8 {
	WebDriver driver;
	
	@BeforeMethod
	public void startBrowser() {
		driver = PredefinedActions.start();
		driver.findElement(By.linkText("Demo Tables")).click();
	}
	
	int totalNumberOfRows() {
		return driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr")).size();
	}
	
	HashMap<String,Integer> findNoOfEmpInEachDept(int rows){
		HashMap<String,Integer> hm = new HashMap<String, Integer>();
		for(int rowIndex = 1; rowIndex <= rows; rowIndex++) {
			String dept = driver.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr["+rowIndex+"]/td[5]")).getText();
			if(hm.containsKey(dept))
				hm.put(dept, hm.get(dept)+1);
			else
				hm.put(dept, 1);
		}
		return hm;
	}
	
	@Test
	void displayNoOfEmpInEachDept() {
		int rows = totalNumberOfRows();
		System.out.println(findNoOfEmpInEachDept(rows));
	}
	
	@AfterMethod
	void tearDown() {
		driver.close();
	}
	
}
