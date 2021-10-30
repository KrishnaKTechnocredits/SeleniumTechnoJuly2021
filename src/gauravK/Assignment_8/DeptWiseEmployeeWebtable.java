package gauravK.Assignment_8;
/*
 * Assignment - 8 : 23th Oct'2021

Return a map of Deptname and count of employee within each department from Employee Manager Table.
o/p : 7001-Admin -> 2
      7002-Finance -> 2
      7003-HR -> 2
      7013-IT -> 3

 */
import java.util.TreeMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class DeptWiseEmployeeWebtable {
	
	@Test
	public void employeeByDeptName() throws InterruptedException {
		System.out.println("Opening Chrome browser \n Navigating to automationbykrishna.com");
		WebDriver driver = startBrowser("http://automationbykrishna.com/");
		System.out.println("Clicking Demo Tables link.");
		driver.findElement(By.linkText("Demo Tables")).click();
		Thread.sleep(3000);
		int totalRows = driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr")).size();
		System.out.println("Ttoal number of rows in the Employee Manager table: "+totalRows);
		System.out.println("Print count of employee by department name");
		TreeMap<String, Integer> map = new TreeMap<String, Integer>();
		for (int index = 1; index <= totalRows; index++) {
			String str = driver.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr["+index+"]/td[5]")).getText();
			if (map.containsKey(str)) {
				int cnt = map.get(str);
				map.put(str, cnt + 1);
			} 
			else {
				map.put(str, 1);
			}
		}
		System.out.println(map.entrySet());
		driver.close();
	}

	private WebDriver startBrowser(String str) {
		System.setProperty("webdriver.chrome.driver", "./resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(str);
		return driver;
	}
	
}
