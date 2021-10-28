package priti.Assingment_9;

import java.util.ArrayList;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Assingment_9 {
	WebDriver driver;
	@BeforeClass
	void  start() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./resources/chromedriver.exe");
		driver = new ChromeDriver();
		System.out.println("Step : Launch Chrome Browser");
		driver.manage().window().maximize();
		System.out.println("Step :open Website -http://automationbykrishna.com/index.html");
		driver. get("http://automationbykrishna.com/");
		driver.findElement(By.xpath("//a [@id ='demotable']")).click();
		Thread.sleep(3000);
	}
	

	HashMap<String, ArrayList<String>> getEmpCntAndEmpNameInEachDept() {
		HashMap<String, ArrayList<String>> DeptEmpMap = new HashMap<String ,ArrayList<String>>();
		int rowCount = driver.findElements(By.xpath("//table [@class ='table table-striped']/tbody/tr")).size();
		System.out.println(rowCount);
		for (int index=1; index<=rowCount;index++) {
			String deptName= driver.findElement(By.xpath("//table[@class ='table table-striped']/tbody/tr["+index+"]/td[5]")).getText();
			if(DeptEmpMap.containsKey(deptName)) {
				ArrayList<String> currentEmplist =DeptEmpMap.get(deptName);
				String curretnEmpName=
						driver.findElement(By.xpath("//table[@class = 'table table-striped']/tbody/tr["+index+"]/td[3]")).getText();
				
				currentEmplist.add(curretnEmpName);
				DeptEmpMap.put(deptName, currentEmplist);
			}else {
				ArrayList<String> listEmpName= new ArrayList<String>();
				String EmpName=driver.findElement(By.xpath("//table[@class = 'table table-striped']/tbody/tr["+index+"]/td[3]")).getText();
				listEmpName.add(EmpName);
				DeptEmpMap.put(deptName, listEmpName);
			}
			
		}
			System.out.println(DeptEmpMap);
			return DeptEmpMap;
		}	
	@Test
	void verifyEmpCountInEachDept() {
		HashMap<String, ArrayList<String>> DeptEmpMap= getEmpCntAndEmpNameInEachDept();
		ArrayList<String> actualEmpList=DeptEmpMap.get("7001-Admin");
		Assert.assertTrue(actualEmpList.size() ==2);
		ArrayList<String> expectedEmpList= new ArrayList<String>();
		expectedEmpList.add("Abhijit Mane");
		expectedEmpList.add("Prayag Mokate");
		Assert.assertEquals(actualEmpList, actualEmpList, "Actual count of employee does not macth the expected count");
	
		actualEmpList.clear();
		actualEmpList = DeptEmpMap.get("7002-Finance");
		Assert.assertTrue(actualEmpList.size()==2);
		expectedEmpList.clear();
		expectedEmpList.add("Sumit Mate");
		expectedEmpList.add("Sumit Mate");
		Assert.assertEquals(actualEmpList, actualEmpList, "Actual count of employee does not macth the expected count");
			
		actualEmpList.clear();
		actualEmpList = DeptEmpMap.get("7003-HR");
		Assert.assertTrue(actualEmpList.size()==2);
		expectedEmpList.clear();
		expectedEmpList.add("Sumit Kulkarni");
		expectedEmpList.add("Pawan Belamkar");
		Assert.assertEquals(actualEmpList, actualEmpList, "Actual count of employee does not macth the expected count");
			
		actualEmpList.clear();
		actualEmpList = DeptEmpMap.get("7013-IT");
		Assert.assertTrue(actualEmpList.size()==3);
		expectedEmpList.clear();
		expectedEmpList.add("Nikhil Patne");
		expectedEmpList.add("Chetan Shewale");
		expectedEmpList.add("Priyanka Bhale");
		Assert.assertEquals(actualEmpList, actualEmpList, "Actual count of employee does not macth the expected count");
			
	}
		
	@AfterClass
	public void tearDown() {
		driver.close();
	}
}	
/*Assginment - 9 : 24th Oct'2021
Verfiy Employee count and Employee name in each deptment.
Sample Output: Employee Count in 7001-Admin dept.
               Employee name belongs to 7001-Admin dept.*/	
	


