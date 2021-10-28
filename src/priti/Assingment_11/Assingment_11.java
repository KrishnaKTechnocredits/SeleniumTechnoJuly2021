package priti.Assingment_11;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Assingment_11 {
	WebDriver driver;
	
	@BeforeClass
	void start() {
		System.setProperty("webdriver.chrome.driver","./resources/chromedriver.exe");
		driver = new ChromeDriver();
		System.out.println("Chrome Browser opened");
		driver.manage().window().maximize();
		System.out.println("WebSite : http://automationbykrishna.com/");
		driver.get("http://automationbykrishna.com/");
		System.out.println("Step: Click on Demo Tables link");
		driver.findElement(By.linkText("Demo Tables")).click();
		
	}
	
	Set<String>  findUniqueEmployeeInEmployeeManager() {
		System.out.println("Program 1: Return unique Employees from table-2");
		int rowCount= driver.findElements(By.xpath("//table[@class ='table table-striped']/tbody/tr")).size();
		Set<String> setOFEmpName= new HashSet<String> ();
		for (int index=1;index<=rowCount;index++) {
			String empName = driver.findElement(By.xpath("//table[@class ='table table-striped']/tbody/tr["+index+"]/td[3]")).getText();
			setOFEmpName.add(empName);
		}
		System.out.println(setOFEmpName);
		return setOFEmpName;
	}
	
	@Test(priority=1)
	void verifyUniqueEmpNameSet(){
		Set<String> actualSetOFUniqueEmp = findUniqueEmployeeInEmployeeManager();
		Assert.assertTrue(actualSetOFUniqueEmp.size()==8);
		Set<String> exSsetOFUniqueEmp = new HashSet<String>();
		exSsetOFUniqueEmp.add("Abhijit Mane");
		exSsetOFUniqueEmp.add("Sumit Mate");
		exSsetOFUniqueEmp.add("Sumit Kulkarni");
		exSsetOFUniqueEmp.add("Prayag Mokate");
		exSsetOFUniqueEmp.add("Pawan Belamkar");
		exSsetOFUniqueEmp.add("Nikhil Patne");
		exSsetOFUniqueEmp.add("Chetan Shewale");
		exSsetOFUniqueEmp.add("Priyanka Bhale");
		
		Assert.assertEquals(actualSetOFUniqueEmp,exSsetOFUniqueEmp,"Actual and Expected employee list is not macthed" );
	}
	
	Set<String> printDuplicateEmployeeId(){
		System.out.println("Program 2: print employee id which is duplicate in table-2");
		int rowCount= driver.findElements(By.xpath("//table[@class ='table table-striped']/tbody/tr")).size();
		Set<String> setOFEmpId= new HashSet<String> ();
		for (int index=1;index<=rowCount;index++) {
			String empId =driver.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr["+index+"]/td[2]")).getText();
			if (!setOFEmpId.add(empId)){
				System.out.println("Duplicate Emplyoee Id is:"+empId);
			}
		}
		
		 System.out.println(setOFEmpId);
		 return setOFEmpId;
	 }
	
	@Test(priority=2)
	void verifyDuplcaiteEmployeeId() {
		Set<String> setOFEmpId = printDuplicateEmployeeId();
		Assert.assertTrue(setOFEmpId.size()==8);
	
	}
	@Test(priority=3)
	void printDeptNameWithMaxEmployee() {
		System.out.println("Program 3: print the name of deptment having maximum employees.");
		int rowCount= driver.findElements(By.xpath("//table[@class ='table table-striped']/tbody/tr")).size();
		int count= 0;
		
		HashMap<String, Integer> mapOfDeptName = new HashMap<String, Integer>();
		for(int index=1;index<=rowCount;index++) {
			String deptName = driver.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr["+index+"]/td[5]")).getText();
			if (mapOfDeptName.containsKey(deptName)) {
				count = mapOfDeptName.get(deptName);
				mapOfDeptName.put(deptName, count+1);
			}else {
				mapOfDeptName.put(deptName, 1);
			}
		}
		System.out.println(mapOfDeptName);
		Set<Entry<String, Integer>>set = mapOfDeptName.entrySet();
		int maxcount=0;
		String actuadeptNameWithMaxEmp ="";
		for(Entry<String, Integer> setOfdeptName:mapOfDeptName.entrySet() ) {
			int deptcount =setOfdeptName.getValue();
			if (deptcount>maxcount) {
				maxcount= deptcount;
				actuadeptNameWithMaxEmp=setOfdeptName.getKey();
			}
			
		}
		System.out.println("Department with maximum Employee :"+actuadeptNameWithMaxEmp);
		String expDeptNameWithMaxEmp= "7013-IT";
		Assert.assertEquals(actuadeptNameWithMaxEmp,expDeptNameWithMaxEmp,"Actual and Expcted employee does not match");
			
		}
		
	@AfterClass
	void closeBrowser() {
		driver.close();
		
	}
}
/*Assginment - 11: 24th Oct'2021
Program 1: Return unique Employees from table-2.  
output : size - 8
Program 2: print employee id which is duplicate in table-2 
output : 76585 
Program 3: print the name of deptment having maximum employees. 
output : 7013-IT*/


