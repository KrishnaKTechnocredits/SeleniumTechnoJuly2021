/*Assignment - 8 : 23th Oct'2021
Return a map of Deptname and count of employee within each deptment.
o/p : 7001-Admin -> 2
      7002-Finance -> 2
	  7003-HR -> 2
	  7013-IT -> 3
*/


package amolVyas;

import java.util.LinkedHashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import amolVyas.Assignment_5.Action;

public class Assignment_8 {
	@Test
	void getCountOfDeptartment() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		System.out.println("STEP-Open Chrome Browser");
		driver.manage().window().maximize();
		System.out.println("STEP-Open Given URL");
		driver.get("http://automationbykrishna.com/index.html#");
		System.out.println("STEP-Navigate to Demo Tables");
		driver.findElement(By.xpath("//a[text()='Demo Tables']")).click();
		Thread.sleep(3000);
		int countRow = driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr")).size();
		Map<String, Integer> map = new LinkedHashMap();
		for (int index = 1; index <= countRow; index++) {
			String key = driver
					.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr[" + index + "]/td[5]"))
					.getText();
			if (map.containsKey(key)) {
				int count = map.get(key);
				map.put(key, ++count);

			} else
				map.put(key, 1);
		}
		System.out.println("STEP-Print Deptname and count of employee within each deptment");
		System.out.println(map);
		Assert.assertEquals(driver.findElement(By.xpath("//a[text()='Demo Tables']")).getText(), "Demo Tables");
		driver.close();
	}
}
