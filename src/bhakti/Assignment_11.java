/*Assginment - 11: 24th Oct'2021
Program 1: Return unique Employees from table-2. 
output : size - 8


Program 2: print employee id which is duplicate in table-2 
output : 76585 

Program 3: print the name of deptment having maximum employees.
output : 7013-IT


*/

package bhakti;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Assignment_11 {
	
WebDriver driver;
	
	@BeforeClass
	void star() throws InterruptedException {
		 
		System.setProperty("webdriver.chrome.driver", "./resources/chromedriver.exe");
		System.out.println("Step- Open Chrom Browser");
		driver = new ChromeDriver();
		System.out.println("Step- Open URL ");
		driver.get("http://automationbykrishna.com/#");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//a[@id='demotable']")).click();
		Thread.sleep(5000);
	}
	@AfterClass
	void closeBrowser() {
		System.out.println("End");
		 driver.quit();
	}
	 //Program 1: Return unique Employees from table-2. . 
	@Test
	void p1_findUniqueEmp() {
		System.out.println("Program 1: Return unique Employees from table-2. ");
		int rows= driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr")).size();
		HashSet<String> empIDList= new HashSet();
		HashSet<String> empID_NameList= new HashSet();
		for (int i=1; i<= rows; i++) {
			String empID= driver.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr["+i+"]/td[2]")).getText();
			if (empIDList.add(empID)) {
				String empName= driver.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr["+i+"]/td[3]")).getText();
				String empNameID= empID+"-"+empName;
				empID_NameList.add(empNameID);
			}
		}
		System.out.println("Numer of unique employee ->"+empIDList.size());
		System.out.println("Below is Unique employee List :");
		System.out.println(empID_NameList);
		int actual=empIDList.size();
		int expected=8;
		SoftAssert softAssert= new SoftAssert();
		softAssert.assertEquals(actual, expected);
		softAssert.assertAll();
	}
	//Program 2: print employee id which is duplicate in table-2 
	@Test 
	void findDuplicateEmpID() {
		System.out.println("Program 2: print employee id which is duplicate in table-2");
		int rows= driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr")).size();
		HashSet<String> empIDList= new HashSet();
		String empName="";
		for (int i=1; i<= rows; i++) {
			String empID= driver.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr["+i+"]/td[2]")).getText();
			if (!empIDList.add(empID)) {
				 empName= driver.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr["+i+"]/td[3]")).getText();
				System.out.println("Duplicate Employee-->" +empName); 
			}
		}
		String expected= "Sumit Mate";
		SoftAssert softAssert= new SoftAssert();
		softAssert.assertEquals(empName, expected);
		softAssert.assertAll();
	}
	//Program 3: print the name of deptment having maximum employees.:	output : 7013-IT
	@Test
	void deptNameWithMaxEMp() {
		System.out.println("Program 3: print the name of deptment having maximum employees.:");
		int rows= driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr")).size();
		HashMap<String, Integer> deptListMap= new HashMap();
		for (int i=1; i<= rows; i++) {
			String deptName=driver.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr["+i+"]/td[5]")).getText();
			if (deptListMap.containsKey(deptName)) {
				int count=deptListMap.get(deptName);
				deptListMap.put(deptName, ++count);
				
			}else {
				deptListMap.put(deptName, 1);
			}

		}
		System.out.println(deptListMap);
		int max=0;
		String maxDepName="";
		for (Entry<String, Integer> deptName:deptListMap.entrySet() ) {
			if (deptName.getValue()>max) {
				max=deptName.getValue();
				maxDepName= deptName.getKey();
			}
		}
		System.out.println("Deparat having max employee-->"+maxDepName);
		String expected= "7013-IT";
		SoftAssert softAssert= new SoftAssert();
		softAssert.assertEquals(maxDepName, expected);
		softAssert.assertAll();
		
	}
}
