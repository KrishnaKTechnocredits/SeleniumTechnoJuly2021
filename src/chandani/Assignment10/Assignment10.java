/*Assignment - 10 : 24th Oct'2021
Similar to Assignment-9 but verification should be against managerid.

Sample Output: Employee Count reports to manager having manager id - 20209.
               Employee name reports to manager having manager id - 20209.*/

package chandani.Assignment10;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.PredefinedActions;

public class Assignment10 {

	WebDriver driver;
	
	
	@BeforeClass
	void start() {
		driver = PredefinedActions.start();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("STEP - Click on Demo Tables link");
		driver.findElement(By.linkText("Demo Tables")).click();
	}
	
	
	HashMap<String, ArrayList<String>> getEmployeesCountUnderEachManagerID() {
		
		HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
		int rows = driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr")).size();
		
		for (int index = 1; index <= rows; index++) {			
	
	    String mngrID = driver.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr["+index+"]/td[4]")).getText();
	    List<WebElement> mngrIDRows = driver.findElements(By.xpath("//table[@class='table table-striped']/tbody//td[4][text()=" + mngrID
						+ "]/preceding-sibling::td[1]"));
		ArrayList<String> empList = new ArrayList<>();
			
	    for (int index1 = 0; index1 < mngrIDRows.size(); index1++ ) {			  
	    	 // String empName = driver.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr["+index1+"]/td[4][text()= '"+ mngrID +"']//preceding-sibling::td[1]")).getText();
			   empList.add(mngrIDRows.get(index1).getText());
	    	 // System.out.println(empName);
			}
	    	   map.put(mngrID, empList);
		}
			 
		return map;

	 }
	
	@Test
	public void verifyEmployeeNameAndCount() {
		SoftAssert softAssert = new SoftAssert();
		HashMap<String, ArrayList<String>> map = getEmployeesCountUnderEachManagerID();
		ArrayList<String> expectedList = new ArrayList<>();
		ArrayList<String> actualList = new ArrayList<>();
		Set<String> mngrIDSet = map.keySet();

		for (String managerId : mngrIDSet) {
			if (managerId.equals("20209")) {
				int expectedCount = 3;
				int actualCount = map.get(managerId).size();
				softAssert.assertEquals(actualCount, expectedCount);
				
				expectedList.add("Abhijit Mane");
				expectedList.add("Sumit Kulkarni");
				expectedList.add("Pawan Belamkar");
				actualList = map.get(managerId);
				
				softAssert.assertEquals(actualCount, expectedCount);
				System.out.println("Employee Count reporting to manager having manager id - 20209 is " + actualCount);
				System.out.println("Employee names reporting to manager having manager id - 20209 is " + actualList);
				expectedList.clear();
				actualList.clear();
				
			} else if (managerId.equals("20205")) {
				int expectedCount = 4;
				int actualCount = map.get(managerId).size();
				softAssert.assertEquals(actualCount, expectedCount);
				
				expectedList.add("Sumit Mate");
				expectedList.add("Prayag Mokate");
				expectedList.add("Sumit Mate");
				expectedList.add("Nikhil Patne");
				actualList = map.get(managerId);
				softAssert.assertEquals(actualCount, expectedCount);
						
				System.out.println("Employee Count reporting to manager having manager id - 20205 is " + actualCount);
				System.out.println("Employee names reporting to manager having manager id - 20205 is " + actualList);
				expectedList.clear();
				actualList.clear();
				
			} else if (managerId.equals("10101")) {
				int expectedCount = 2;
				int actualCount = map.get(managerId).size();
				softAssert.assertEquals(actualCount, expectedCount);
		
				expectedList.add("Chetan Shewale");
				expectedList.add("Priyanka Bhale");
				actualList = map.get(managerId);
				softAssert.assertEquals(actualCount, expectedCount);
						
				System.out.println("Employee Count reporting to manager having manager id - 10101 is " + actualCount);
				System.out.println("Employee names reporting to manager having manager id - 10101 is " + actualList);
				expectedList.clear();
				actualList.clear();
			}
			softAssert.assertAll();
		}

	}

	@AfterClass
	void close() {
		driver.close();
		System.out.println("Assignment 10 Passed Successfully");
	}
	
}

