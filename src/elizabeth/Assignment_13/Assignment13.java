//Program : Verify whole table is sorted based on Employee age.

package elizabeth.Assignment_13;

import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Assignment13 {
	
	WebDriver driver;
	
	@BeforeClass
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
		driver=new ChromeDriver();
		System.out.println("Step: Launch browser");
		driver.get("https://datatables.net/extensions/autofill/examples/initialisation/focus.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	@AfterClass
	public void tearDown() {
		driver.close();
	}
	
	ArrayList<Employee> getEmpTable(){
		ArrayList<Employee> al=new ArrayList<Employee>();
		int totalPages=driver.findElements(By.xpath("//div[@class='dataTables_paginate paging_simple_numbers']//span/a")).size();
		for(int page=1;page<=totalPages;page++) {
			int totalRows=driver.findElements(By.xpath("//table[@class='display nowrap dataTable']//tbody/tr")).size();
			for(int row=1;row<=totalRows;row++) {
				String name=driver.findElement(By.xpath("//table[@class='display nowrap dataTable']/tbody/tr["+row+"]/td[1]")).getText();
				String position=driver.findElement(By.xpath("//table[@class='display nowrap dataTable']/tbody/tr["+row+"]/td[2]")).getText();
				String office=driver.findElement(By.xpath("//table[@class='display nowrap dataTable']/tbody/tr["+row+"]/td[3]")).getText();
				int age=Integer.parseInt(driver.findElement(By.xpath("//table[@class='display nowrap dataTable']/tbody/tr["+row+"]/td[4]")).getText());
				String startDate=driver.findElement(By.xpath("//table[@class='display nowrap dataTable']/tbody/tr["+row+"]/td[5]")).getText();
				String salary=driver.findElement(By.xpath("//table[@class='display nowrap dataTable']/tbody/tr["+row+"]/td[6]")).getText();
				Employee emp=new Employee(name,position,office,age,startDate,salary);
				al.add(emp);
			}
			driver.findElement(By.xpath("//a[@id='example_next']")).click();
		}
		if(totalPages>0) {
			driver.findElement(By.xpath("//div[@id='example_paginate']/span/a[1]")).click();
		}
		return al;
	}
	
	@Test
	public void verifySortedTable() {
		System.out.println("Step: Click on Age Header to sort the table content");
		driver.findElement(By.xpath("//table[@class='display nowrap dataTable']/thead/tr/th[4]")).click();
		ArrayList<Employee> actualsortedtable=getEmpTable();
		System.out.println(actualsortedtable);
		ArrayList<Employee> expectedsortedtable=getEmpTable();
		Collections.sort(expectedsortedtable);
		System.out.println(expectedsortedtable);
		System.out.println("Step: Verify the actual sorted table with the expected sorted table");
		Assert.assertEquals(actualsortedtable,expectedsortedtable);
		System.out.println("Verified successfully");
		
	}

}
