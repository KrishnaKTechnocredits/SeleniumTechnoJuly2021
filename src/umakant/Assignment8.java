/*Assignment - 8 : 23th Oct'2021
Return a map of Deptname and count of employee within each deptment.
o/p : 7001-Admin -> 2
      7002-Finance -> 2
	  7003-HR -> 2
	  7013-IT -> 3
	  */
package umakant;

import java.util.LinkedHashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.PredefinedActions;

public class Assignment8 {

	Map<String, Integer> getDepartWiseCount() throws InterruptedException {
		WebDriver driver = PredefinedActions.start();
		Map<String, Integer> hm = new LinkedHashMap<String, Integer>();
		System.out.println("Step: CLick on Demo Tables");
		driver.findElement(By.linkText("Demo Tables")).click();
		Thread.sleep(3000);
		System.out.println("Step: Calculate the number of rows");
		int rows = driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr")).size();
		System.out.println("Step: Calculate the number of employee of each department");
		for (int rowIndex = 1; rowIndex <= rows; rowIndex++) {
			String department = driver
					.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr[" + rowIndex + "]/td[5]"))
					.getText();
			if (hm.containsKey(department))
				hm.put(department, hm.get(department) + 1);
			else
				hm.put(department, 1);
		}
		driver.close();
		return hm;
	}

	public static void main(String[] args) throws InterruptedException {
		System.out.println(new Assignment8().getDepartWiseCount());
	}

}
