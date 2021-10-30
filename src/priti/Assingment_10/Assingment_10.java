package priti.Assingment_10;

import java.util.ArrayList;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Assingment_10 {
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
	
	
	HashMap<String, ArrayList<String>> getEmpNameandcountForEachManger() {
		HashMap<String, ArrayList<String>> empNameAndManagerMap= new HashMap<String ,ArrayList<String>>();
		int rowCount = driver.findElements(By.xpath("//table [@class ='table table-striped']/tbody/tr")).size();
		for(int index=1;index<=rowCount;index++) {
			String ManagerId = driver.findElement(By.xpath("//table[@class ='table table-striped']/tbody/tr["+index+"]/td[4]")).getText();
			if (empNameAndManagerMap.containsKey(ManagerId)) {
				ArrayList<String> listOfCurrentEmpId = empNameAndManagerMap.get(ManagerId);
				listOfCurrentEmpId.add(driver.findElement(By.xpath("//table[@class ='table table-striped']/tbody/tr["+index+"]/td[3]")).getText());
				empNameAndManagerMap.put(ManagerId,listOfCurrentEmpId);
			}else {
				ArrayList<String> ListOfEmpId = new ArrayList<String>();
				ListOfEmpId.add(driver.findElement(By.xpath("//table[@class ='table table-striped']/tbody/tr["+index+"]/td[3]")).getText());
				empNameAndManagerMap.put(ManagerId,ListOfEmpId);
			}
		}
		System.out.println(empNameAndManagerMap);
		return empNameAndManagerMap;
	}
	
	@Test
	void verifyEmpNameForEachDept() {
		HashMap<String, ArrayList<String>>  mapOfDeptNameAndEmpName = getEmpNameandcountForEachManger();
		System.out.println("compare the count of employee per dept");
		ArrayList<String> actualListOfEmpName = new ArrayList<String>();
		actualListOfEmpName =mapOfDeptNameAndEmpName.get("20209");
		Assert.assertTrue(actualListOfEmpName.size()==3);
		
		ArrayList<String>expListOfEmpName = new ArrayList<String>();
		expListOfEmpName.add("Abhijit Mane");
		expListOfEmpName.add("Sumit Kulkarni");
		expListOfEmpName.add("Pawan Belamkar");
		Assert.assertEquals(actualListOfEmpName, expListOfEmpName, "For manager-20209 id list of Actual Employee and expected employee does not match.");
		
		actualListOfEmpName.clear();
		actualListOfEmpName = mapOfDeptNameAndEmpName.get("20205");
		Assert.assertTrue(actualListOfEmpName.size()==4);
		expListOfEmpName.clear();
		expListOfEmpName.add("Sumit Mate");
		expListOfEmpName.add("Prayag Mokate");
		expListOfEmpName.add("Sumit Mate");
		expListOfEmpName.add("Nikhil Patne");
		Assert.assertEquals(actualListOfEmpName, expListOfEmpName, "For manager-20205 id list of Actual Employee and expected employee does not match.");
		
		actualListOfEmpName.clear();
		actualListOfEmpName = mapOfDeptNameAndEmpName.get("10101");
		Assert.assertTrue(actualListOfEmpName.size()==2);
		expListOfEmpName.clear();
		expListOfEmpName.add("Chetan Shewale");
		expListOfEmpName.add("Priyanka Bhale");
		Assert.assertEquals(actualListOfEmpName, expListOfEmpName, "For manager-10101 id list of Actual Employee and expected employee does not match.");
		
	}	
	
		
	@AfterClass
	public void tearDown() {
		driver.close();
	}
}
