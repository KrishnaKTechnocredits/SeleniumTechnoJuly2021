package swati.Assignment9;

/*
Assginment - 9 : 24th Oct'2021
Verfiy Employee count and Employee name in each deptment.

Sample Output: Employee Count in 7001-Admin dept.
              Employee name belongs to 7001-Admin dept.
*/

import java.util.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Assignment9 {
	
	WebDriver driver;
	@Test
	WebDriver start() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","./resources/chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("http://automationbykrishna.com/#");
		driver.manage().window().maximize();
		System.out.println("Clcik on Demo Tables");
		driver.findElement(By.xpath("//a[@id='demotable']")).click();
		Thread.sleep(3000);
		return driver;
	}
	
	@Test
	HashMap<String,ArrayList<String>> employeeNameInEachDept() {
		HashMap<String,ArrayList<String>> map1=new HashMap<String,ArrayList<String>>();
		int rowCount=driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr")).size();
		for(int index=1;index<=rowCount;index++) {
			String deptName=driver.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr["+index+"]/td[5]")).getText();
			if(map1.containsKey(deptName)) {
				ArrayList<String> temp= map1.get(deptName);
				String empName=driver.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr["+index+"]/td[3]")).getText();
				temp.add(empName);
				map1.put(deptName, temp);
			}else
			{
				ArrayList<String> empList=new ArrayList<String>();
				String empName=driver.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr["+index+"]/td[3]")).getText();
				empList.add(empName);
				map1.put(deptName, empList);
			}
		}
		System.out.println(map1);
		return map1;
	}
	
	@Test
	void countEmpInEachDept() {
		HashMap<String,ArrayList<String>> mapEmpCount=employeeNameInEachDept();
		ArrayList<String> empList=new ArrayList<String>();
		for(String deptName:mapEmpCount.keySet()) {
			if(deptName.equals("7001-Admin")) {
				empList=mapEmpCount.get(deptName);
				int empCount=empList.size();
				Assert.assertTrue(empCount==2,"Pass");
				System.out.println("Pass");
			}
			else if(deptName.equals("7002-Finance")) {
				empList.clear();
				empList=mapEmpCount.get(deptName);
				int empCount=empList.size();
				Assert.assertTrue(empCount==2);
				System.out.println("Pass");
			}
			else if(deptName.equals("7003-HR")) {
				empList.clear();
				empList=mapEmpCount.get(deptName);
				int empCount=empList.size();
				Assert.assertTrue(empCount==2);
				System.out.println("Pass");
				
			}
			else if(deptName.equals("7013-IT")) {
				empList.clear();
				empList=mapEmpCount.get(deptName);
				int empCount=empList.size();
				Assert.assertTrue(empCount==3);
				System.out.println("Pass");
			}
		}
	}
	@Test
	void end() {
		driver.close();
	}
	
}

