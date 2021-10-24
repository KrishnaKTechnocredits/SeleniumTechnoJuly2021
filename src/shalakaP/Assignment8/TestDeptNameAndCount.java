/*Assignment - 8 : 23th Oct'2021
Return a map of Deptname and count of employee within each deptment.
o/p : 7001-Admin -> 2
      7002-Finance -> 2
	  7003-HR -> 2
	  7013-IT -> 3
*/
package shalakaP.Assignment8;

import java.util.LinkedHashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import base.PredefinedActions;

public class TestDeptNameAndCount {

	@Test
	public void getDeptCount() throws InterruptedException {

		WebDriver driver;
		System.out.println("Step-open browser");
		System.out.println("Step-Open given url");
		driver = PredefinedActions.start();
		Thread.sleep(3000);
		System.out.println("Step-Click on Demo tables");
		driver.findElement(By.linkText("Demo Tables")).click();

		System.out.println("Step-Find number of rows");
		Thread.sleep(3000);
		int rowCount = driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr")).size();
		// System.out.println(rowCount);

		System.out.println("Step- Count of employee in each Depatment with name ");
		Map<String, Integer> map = new LinkedHashMap<String, Integer>();
		for (int index = 1; index <= rowCount; index++) {
			String deptName = driver
					.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr[" + index + "]/td[5]"))
					.getText();
			if (map.containsKey(deptName)) {
				map.put(deptName, map.get(deptName) + 1);
			} else {
				map.put(deptName, 1);
			}
		}

		System.out.println(map);
		driver.close();
	}

}
