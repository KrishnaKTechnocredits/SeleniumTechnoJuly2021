package amol_P.Assignment_10;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/*Assginment - 10 : 24th Oct'2021
Similar to Assignment-9 but verification should be against managerid.

Sample Output: Employee Count reports to manager having manager id - 20209.
               Employee name reports to manager having manager id - 20209.

xpath axes : (axes  - navigation)
List<WebElement> list = driver.findElements(By.xpath("//table[@class='table table-striped']/tbody//td[5][text()='7001-Admin']//preceding-sibling::td[2]"));

for(WebElement element : list){
	sop(element.getText());*/

public class Assignment_10 {

	WebDriver driver;

	@BeforeMethod()
	public void setup() {
		driver = PredifineActions.start();
	}

	@Test()
	public void verifyEmployee() {
		String empID = "20209";
		List<WebElement> name = new ArrayList();
		driver.findElement(By.xpath("//a[@id='demotable']")).click();
		/*
		 * List<WebElement> list= driver.findElements(By.
		 * xpath("//table[@class='table table-striped']/tbody/tr/td[4][text()='"+empID+
		 * "']")); System.out.println(list.size());
		 */
		Map<String, Integer> map = new HashMap<String, Integer>();
		List<WebElement> list = driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr/td[4]"));

		for (int index = 0; index < list.size(); index++) {
			String allId = list.get(index).getText();

			if (map.containsKey(allId)) {
				map.put(empID, map.get(empID) + 1);
				name = driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr/td[4][text()='"
						+ allId + "']//preceding-sibling::td[1]"));

			} else {
				if (allId.equals(empID)) {
					map.put(empID, 1);
					name = driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr/td[4][text()='"
							+ allId + "']//preceding-sibling::td[1]"));
				}
			}
		}
		System.out.println(map);
		for (WebElement empName : name)
			System.out.println("Employee name: "+ empName.getText());
Assert.assertEquals(name.size(), 3);
	}

	@AfterMethod()
	public void tearDown() {
		driver.quit();
	}
}
