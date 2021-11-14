/*Similar to Assignment-9 but verification should be against managerid.

Sample Output: Employee Count reports to manager having manager id - 20209.
               Employee name reports to manager having manager id - 20209.
*/

package elizabeth.Assignment_10;

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

public class Assignment10 {
	
	WebDriver driver;
	SoftAssert softassert=new SoftAssert();
	
	@BeforeClass
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		System.out.println("STEP : Launch Browser");
		driver.get("http://automationbykrishna.com/#");

		System.out.println("STEP : Click on Demo Tables");
		driver.findElement(By.linkText("Demo Tables")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
	}
	
	public HashMap<String,Integer> getCountofEmployees() {
		HashMap<String,Integer> hm=new HashMap<String,Integer>();
		System.out.println("Step: Find the total count of rows");
		int totalRows=driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr")).size();
		
		for(int row=1;row<=totalRows;row++) {
			String managerId =driver.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr["+row+"]/td[4]")).getText();
			if(hm.containsKey(managerId)) {
				int count=hm.get(managerId);
				hm.put(managerId, count+1);
			}else
				hm.put(managerId, 1);
		}
		return hm;
	}
	
	@Test
	public void verifyCountOfEmp() {
		HashMap<String,Integer>  managerEmpMap = getCountofEmployees();
		
		int expectedEmpCountForManager1=3;
		int expectedEmpCountForManager2=4;
		int expectedEmpCountForManager3=2;
		
		
		Set<String> setOfManagerIds=managerEmpMap.keySet();
		for(String id:setOfManagerIds) {
			if(id.equals("20209")) {
				int actualCount=managerEmpMap.get("20209");
				System.out.println("Employee Count reports to manager having manager id - 20209 is " +actualCount);
				System.out.println("Step: Verify the actualCount with the expectedEmpCount");
				softassert.assertEquals(actualCount, expectedEmpCountForManager1,"Actual count is matching with the expected employee count of Manager1");
			}else if(id.equals("20205")) {
				int actualCount=managerEmpMap.get("20205");
				System.out.println("Employee Count reports to manager having manager id - 20205 is " +actualCount);
				System.out.println("Step: Verify the actualCount with the expectedEmpCount");
				softassert.assertEquals(actualCount, expectedEmpCountForManager2,"Actual count is matching with the expected employee count of Manager2");
			}else if(id.equals("10101")){
				int actualCount=managerEmpMap.get("10101");
				System.out.println("Employee Count reports to manager having manager id - 10101 is " +actualCount);
				System.out.println("Step: Verify the actualCount with the expectedEmpCount");
				softassert.assertEquals(actualCount, expectedEmpCountForManager3,"Actual count is matching with the expected employee count of Manager3");
			}
			softassert.assertAll();
		}
		System.out.println("Verified the counts of employees reporting to their respective managers");
	}
	
	public HashMap<String,ArrayList<String>> getNamesofEmployees() {
		HashMap<String,ArrayList<String>> hm=new HashMap<String,ArrayList<String>>();
		System.out.println("Step: Find the total count of rows");
		int totalRows=driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr")).size();
		
		for(int row=1;row<=totalRows;row++) {
			String managerId =driver.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr["+row+"]/td[4]")).getText();
			String name=driver.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr["+row+"]/td[3]")).getText();
			if(hm.containsKey(managerId)) {
				ArrayList<String> currentEmpName=hm.get(managerId);
				currentEmpName.add(name);
				hm.put(managerId, currentEmpName);
			}else {
				ArrayList<String> newEmpNameList = new ArrayList<String>();
				newEmpNameList.add(name);
				hm.put(managerId, newEmpNameList);
			}
				
		}
		return hm;
	}
	
	@Test
	public void verifyNamesOfEmp() {
		HashMap<String,ArrayList<String>>  managerEmpMap = getNamesofEmployees();
		ArrayList<String> expectedList=new ArrayList<String>();
		ArrayList<String> actualList=new ArrayList<String>();
		
		Set<String> setOfManagerIds=managerEmpMap.keySet();
		for(String id:setOfManagerIds) {
			if(id.equals("20209")) {
				actualList=managerEmpMap.get("20209");
				expectedList.add("Abhijit Mane");
				expectedList.add("Sumit Kulkarni");
				expectedList.add("Pawan Belamkar");
				System.out.println("Employee name reports to manager having manager id - 20209. is " +actualList);
				System.out.println("Step: Verify the actualList with the expectedList");
				softassert.assertTrue(actualList.equals(expectedList),"Actual list is matching with the expected employee names of Manager1");
				actualList.clear();
				expectedList.clear();
			}else if(id.equals("20205")) {
				actualList=managerEmpMap.get("20205");
				expectedList.add("Sumit Mate");
				expectedList.add("Prayag Mokate");
				expectedList.add("Sumit Mate");
				expectedList.add("Nikhil Patne");
				System.out.println("Employee name reports to manager having manager id - 20205. is " +actualList);
				System.out.println("Step: Verify the actualList with the expectedList");
				softassert.assertTrue(actualList.equals(expectedList),"Actual list is matching with the expected employee names of Manager2");
				actualList.clear();
				expectedList.clear();
			}else if(id.equals("10101")){
				actualList=managerEmpMap.get("10101");
				expectedList.add("Chetan Shewale");
				expectedList.add("Priyanka Bhale");
				System.out.println("Employee name reports to manager having manager id - 10101. is " +actualList);
				System.out.println("Step: Verify the actualList with the expectedList");
				softassert.assertTrue(actualList.equals(expectedList),"Actual list is matching with the expected employee names of Manager3");
				actualList.clear();
				expectedList.clear();
			}
			softassert.assertAll();
		}
		System.out.println("Verified the names of employees reporting to their respective managers");
	}
	
	
	@AfterClass
	public void tearDown() {
		driver.close();
	}

}
