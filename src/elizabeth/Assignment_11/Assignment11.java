/*
 Assginment - 11: 24th Oct'2021
Program 1: Return unique Employees from table-2.  
output : size - 8

Program 2: print employee id which is duplicate in table-2 
output : 76585 

Program 3: print the name of deptment having maximum employees. 
output : 7013-IT
 */


package elizabeth.Assignment_11;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Assignment11 {
	
	WebDriver driver;
	SoftAssert softAssert=new SoftAssert();
	
	@BeforeClass
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		System.out.println("Step : Launch Browser");
		driver.get("http://automationbykrishna.com/");
		
		System.out.println("Step: Click on Demo Tables");
		driver.findElement(By.linkText("Demo Tables")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
	}
	@AfterClass
	public void tearDown() {
		driver.close();
	}
	
	@Test(priority=1)
	public void getUniqueEmployees() {
		int expectedSize=8;
		Set<String> names= new LinkedHashSet<String>();
		System.out.println("Step: find the total row count:");
		int totalRows=driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr")).size();
		for(int row=1;row<=totalRows;row++) {
			String empName=driver.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr["+row+"]/td[3]")).getText();
			names.add(empName);
		}
		
		System.out.println("Uniques names in table-2 are: " +names);
		int actualSize=names.size();
		System.out.println("Count of uniques names in table-2 is: " +actualSize);
		System.out.println("Step: Verify the actualSize with the expectedSize");
		softAssert.assertEquals(actualSize, expectedSize);
	}
	
	@Test(priority=2)
	public void getDuplicateEmployees() {
		String expectedEmpId="76585";
		String actualEmpId="";
		Set<String> EmpIdSet= new HashSet<String>();
		System.out.println("Step: find the total row count:");
		int totalRows=driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr")).size();
		for(int row=1;row<=totalRows;row++) {
			actualEmpId=driver.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr["+row+"]/td[2]")).getText();
			if(!EmpIdSet.add(actualEmpId)) {
				System.out.println("Duplicate empId's in table-2 is: " +actualEmpId);
			}
		}
		System.out.println("Step: Verify the actualEmpId with the expectedEmpId");
		softAssert.assertEquals(actualEmpId, expectedEmpId);
	}
	
	@Test(priority=3)
	public void getMaxEmpDep() {
		HashMap<String,Integer> hm=new HashMap<String,Integer>();
		int count=0;
		int maxCount=0;
		String actualMaxEmpDep="";
		String expectedMaxEmpDep="7013-IT";
		System.out.println("Step: find the total row count:");
		int totalRows=driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr")).size();
		for(int row=1;row<=totalRows;row++) {
			String depName=driver.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr["+row+"]/td[5]")).getText();
			if(hm.containsKey(depName)) {
				count=hm.get(depName);
				hm.put(depName, count+1);
				if(maxCount<count) {
					maxCount=count;
					actualMaxEmpDep=depName;
				}
			}else {
				hm.put(depName, 1);
			}
		}
		System.out.println("Name of deptment having maximum employees is " +actualMaxEmpDep);
		System.out.println("Step: Verify the actualMaxEmpDep with the expectedMaxEmpDep");
		softAssert.assertEquals(actualMaxEmpDep, expectedMaxEmpDep);
	}
		
}
