package swati.Assignment8;

/*
Assignment - 8 : 23th Oct'2021
Return a map of Deptname and count of employee within each deptment.
o/p : 7001-Admin -> 2
     7002-Finance -> 2
	  7003-HR -> 2
	  7013-IT -> 3

*/


import java.util.LinkedHashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment8 {
	WebDriver driver;
	
	WebDriver start() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","./resources/chromedriver.exe");
		driver= new ChromeDriver();
		System.out.println("Enter URL");
		driver.get("http://automationbykrishna.com/#");
		driver.manage().window().maximize();
		System.out.println("Clcik on Demo Tables");
		driver.findElement(By.xpath("//a[@id='demotable']")).click();
		Thread.sleep(3000);
		return driver;
	}
	
	void returnEmployeeInEachDept() {
		//table[@class='table table-striped']/tbody/tr[1]/td[5]
		LinkedHashMap<String,Integer> map1=new LinkedHashMap<String,Integer>();
		int rowcount=driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr")).size();
		for(int index=1;index<=rowcount;index++) {
			String deptName=driver.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr["+index+"]/td[5]")).getText();
			if(map1.containsKey(deptName)) {
				map1.put(deptName,map1.get(deptName)+1 );
			}else
				map1.put(deptName, 1);
		}
		
		System.out.println("Count of employee within each department :");
		System.out.println(map1);
		
	}
	
	void end() {
		driver.close();
	}
	
	public static void main(String[] args) throws InterruptedException {
		Assignment8 a8=new Assignment8();
		a8.start();
		a8.returnEmployeeInEachDept();
		a8.end();
	}
}

