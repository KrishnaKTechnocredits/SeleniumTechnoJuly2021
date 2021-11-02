package swati.Assignment10;

/*
 * Assginment - 10 : 24th Oct'2021
Similar to Assignment-9 but verification should be against managerid.

Sample Output: Employee Count reports to manager having manager id - 20209.
               Employee name reports to manager having manager id - 20209.
 */

import java.util.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Assignment10 {
	WebDriver driver;
	@Test
	WebDriver start() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","./resources/chromedriver.exe");
		driver=new ChromeDriver();
		System.out.println("Enter URL");
		driver.get("http://automationbykrishna.com/#");
		driver.manage().window().maximize();
		System.out.println("Clcik on Demo Tables");
		driver.findElement(By.xpath("//a[@id='demotable']")).click();
		Thread.sleep(3000);
		return driver;			
	}
	
	@Test
	HashMap<String,ArrayList<String>> getEmpNamesReportToManager() {
		//table[@class='table table-striped']/tbody/tr/td[4][text()='7001-Admin']//preceding-sibling::td[1]
		HashMap <String,ArrayList<String>> map1=new HashMap<String,ArrayList<String>>();
		int rowCount=driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr")).size();
		
		for(int index=1;index<=rowCount;index++) {
			String mgID=driver.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr["+index+"]/td[4]")).getText();
			ArrayList <String> list1=new ArrayList<String>();
				List<WebElement> list=driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr/td[4][text()='"+mgID+"']//preceding-sibling::td[1]"));
				
				for(int index2=0;index2<list.size();index2++) {
					//System.out.println(list.get(index2).getText());
					list1.add(list.get(index2).getText());
				}
							
			map1.put(mgID, list1);
			
		}
		System.out.println(map1);
		return map1;
	}
	
	@Test
	void getEmpCountReportToEachManager() {
		HashMap <String,ArrayList<String>> map2=getEmpNamesReportToManager();
		HashMap <String,Integer> empList= new HashMap<String,Integer>();
		HashMap <String,Integer> expectedMap=new HashMap<String,Integer>();
		expectedMap.put("20209", 3);
		expectedMap.put("20205", 4);
		expectedMap.put("10101", 2);
		
		for(String mangerID:map2.keySet()) {
			int count=map2.get(mangerID).size();
			empList.put(mangerID, count);
		}
		
		System.out.println(empList);
		Assert.assertTrue(empList.equals(expectedMap));
	}
	
	@Test
	void end() {
		driver.close();
	}
	
}

