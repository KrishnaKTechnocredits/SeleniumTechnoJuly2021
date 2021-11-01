/*Verfiy Employee count and Employee name in each deptment.

Sample Output: Employee Count in 7001-Admin dept.
               Employee name belongs to 7001-Admin dept.*/

package elizabeth.Assignment_9;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class Assignment9 {
	
	WebDriver driver;
	
	@BeforeClass
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		System.out.println("STEP : Launch Browser");
		driver.get("http://automationbykrishna.com/#");

		System.out.println("STEP : Navigate to Demo Tables");
		driver.findElement(By.linkText("Demo Tables")).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	public HashMap<String,Integer> getCountofEmployees() {
		HashMap<String,Integer> hm= new HashMap<String,Integer>();
		System.out.println("STEP : Find the total rows in the table");
		int totatRow=driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr/td[5]")).size();
		for(int row=1;row<=totatRow;row++) {
			String depName=driver.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr["+row+"]/td[5]")).getText();
			if(hm.containsKey(depName)) {
				int count=hm.get(depName);
				hm.put(depName,count+1);
			}else {
				hm.put(depName,1);
			}
		}
		return hm;
	}
	
	
	@Test
	public void verifyCountOfEmployee() {
		HashMap<String,Integer> deptEmpMap = getCountofEmployees();
		int expectedAdminCount=2;
		int expectedFinanceCount=2;
		int expectedHRCount=2;
		int expectedITCount=3;
		
		SoftAssert softAssert=new SoftAssert();
		Set<String> setofDeps=deptEmpMap.keySet();
		for(String DepName: setofDeps) {
			if(DepName.equals("7001-Admin")) {
				int actualAdminCount=deptEmpMap.get("7001-Admin");
				System.out.println("Employee Count in 7001-Admin dept is " + actualAdminCount);
				System.out.println("Step: Verify if the actualAdminCount is matching with the expectedAdminCount");
				softAssert.assertEquals(actualAdminCount, expectedAdminCount,"Admin Count is not as expected");
			}else if(DepName.equals("7002-Finance")) {
				int actualFinanceCount=deptEmpMap.get("7002-Finance");
				System.out.println("Employee Count in 7002-Finance dept is " + actualFinanceCount);
				System.out.println("Step: Verify if the actualFinanceCount is matching with the expectedFinanceCount");
				softAssert.assertEquals(actualFinanceCount, expectedFinanceCount,"Finance Count is not as expected");
			}else if(DepName.equals("7003-HR")) {
				int actualHRCount=deptEmpMap.get("7003-HR");
				System.out.println("Employee Count in 7003-HR dept is " + actualHRCount);
				System.out.println("Step: Verify if the actualHRCount is matching with the expectedHRCount");
				softAssert.assertEquals(actualHRCount, expectedHRCount,"HR Count is not as expected");
			}else if(DepName.equals("7013-IT")) {
				int actualITCount=deptEmpMap.get("7013-IT");
				System.out.println("Employee Count in 7013-IT dept is " + actualITCount);
				System.out.println("Step: Verify if the actualITCount is matching with the expectedITCount");
				softAssert.assertEquals(actualITCount, expectedITCount,"IT Count is not as expected");
			}
			
			softAssert.assertAll();
		}
		System.out.println("Employee Count of all departments successfully verified");
		
	}
	
	public HashMap<String,ArrayList<String>> getNamesofEmployees() {
		HashMap<String,ArrayList<String>> hm= new HashMap<String,ArrayList<String>>();
		System.out.println("STEP : Find the total rows in the table");
		int totatRow=driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr/td[5]")).size();
		for(int row=1;row<=totatRow;row++) {
			String depName=driver.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr["+row+"]/td[5]")).getText();
			String EmpName=driver.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr["+row+"]/td[3]")).getText();
			if(hm.containsKey(depName)) {
				ArrayList<String> currentEmpList=hm.get(depName);
				currentEmpList.add(EmpName);
				hm.put(depName, currentEmpList);
			}else {
				ArrayList<String> newEmpList=new ArrayList<String>();
				newEmpList.add(EmpName);
				hm.put(depName, newEmpList);
			}
		}
		return hm;
	}
	
	@Test
	public void verifyNamesOfEmployee() {
		HashMap<String,ArrayList<String>> deptEmpMap = getNamesofEmployees();
		SoftAssert softAssert=new SoftAssert();
		Set<String> setofDeps=deptEmpMap.keySet();
		for(String DepName: setofDeps) {
			if(DepName.equals("7001-Admin")) {
				ArrayList<String> expectedAdminNameList=new ArrayList<String>();
				expectedAdminNameList.add("Abhijit Mane");
				expectedAdminNameList.add("Prayag Mokate");
				ArrayList<String> actualNameList=deptEmpMap.get("7001-Admin");
				System.out.println("Employee names belongs to 7001-Admin dept is " + actualNameList);
				System.out.println("Step: Verify if the actualNameList is matching with the expectedAdminNameList");
				softAssert.assertEquals(actualNameList, expectedAdminNameList,"Admin names are not as expected");
			}else if(DepName.equals("7002-Finance")) {
				ArrayList<String> expectedFinanceNameList=new ArrayList<String>();
				expectedFinanceNameList.add("Sumit Mate");
				expectedFinanceNameList.add("Sumit Mate");
				ArrayList<String> actualNameList=deptEmpMap.get("7002-Finance");
				System.out.println("Employee names belongs to 7002-Finance dept is " + actualNameList);
				System.out.println("Step: Verify if the actualNameList is matching with the expectedFinanceNameList");
				softAssert.assertEquals(actualNameList, expectedFinanceNameList,"Finance names are not as expected");
			}else if(DepName.equals("7003-HR")) {
				ArrayList<String> expectedHRNameList=new ArrayList<String>();
				expectedHRNameList.add("Sumit Kulkarni");
				expectedHRNameList.add("Pawan Belamkar");
				ArrayList<String> actualNameList=deptEmpMap.get("7003-HR");
				System.out.println("Employee names belongs to 7003-HR dept is " + actualNameList);
				System.out.println("Step: Verify if the actualNameList is matching with the expectedHRNameList");
				softAssert.assertEquals(actualNameList, expectedHRNameList,"HR names are not as expected");
			}else if(DepName.equals("7013-IT")) {
				ArrayList<String> expectedITNameList=new ArrayList<String>();
				expectedITNameList.add("Nikhil Patne");
				expectedITNameList.add("Chetan Shewale");
				expectedITNameList.add("Priyanka Bhale");
				ArrayList<String> actualNameList=deptEmpMap.get("7013-IT");
				System.out.println("Employee names belongs to 7013-IT is " + actualNameList);
				System.out.println("Step: Verify if the actualNameList is matching with the expectedITNameList");
				softAssert.assertEquals(actualNameList, expectedITNameList,"IT names are not as expected");
			}
			softAssert.assertAll();
		}
		System.out.println("Employee Nameslist of all departments successfully verified");
	}
	
	@AfterClass
	public void tearDown() {
		driver.close();
	}

}
