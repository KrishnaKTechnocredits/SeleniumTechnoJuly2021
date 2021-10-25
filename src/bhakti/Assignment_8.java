/*Assignment - 8 : 23th Oct'2021
Assignment - 8 : 23th Oct'2021
Return a map of Deptname and count of employee within each deptment.
o/p : 7001-Admin -> 2
      7002-Finance -> 2
	  7003-HR -> 2
	  7013-IT -> 3

*/
package bhakti;

import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Assignment_8 {
	
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
	 
	//Return a map of Deptname and count of employee within each deptment.
	@Test
	void mapOfDep_CountofEmp() {
		System.out.println("Step- Map of Deptname and count of employee within each deptment.");
		List<WebElement> rows= driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr"));
		HashMap <String, Integer> hm= new HashMap();
		for (int i=1; i<=rows.size(); i++) {
			String depName=driver.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr["+i+"]/td[5]")).getText();
			if (hm.containsKey(depName)) {
				int count= hm.get(depName);
				hm.put(depName, ++count);
				
			}else
				hm.put(depName, 1);
		}
		System.out.println(hm);
		SoftAssert softAssert= new SoftAssert();
		for(Entry<String, Integer> n: hm.entrySet()) {
			if (n.getKey().equals("7003-HR")) {
				softAssert.assertEquals(n.getValue(), 2);
			}else if (n.getKey().equals("7013-IT"))	{
				softAssert.assertEquals(n.getValue(), 3);
			}else if (n.getKey().equals("7002-Finance"))	{
				softAssert.assertEquals(n.getValue(), 2);
			}else if (n.getKey().equals("7001-Admin"))	{
				softAssert.assertEquals(n.getValue(), 2);
			}
		}
	} 
}
