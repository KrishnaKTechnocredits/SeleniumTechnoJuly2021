/*Return a map of Deptname and count of employee within each deptment.
o/p : 7001-Admin -> 2
      7002-Finance -> 2
	  7003-HR -> 2
	  7013-IT -> 3*/
package chandani.Assignment8;

import java.util.LinkedHashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment8 {
	
	Map<String, Integer> getEmployeeCountOfDepartment() throws InterruptedException{
		
		Map<String,Integer> map = new LinkedHashMap<String,Integer>();
		System.setProperty("webdriver.chrome.driver", "./resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("http://automationbykrishna.com/#");
		
		Thread.sleep(3000);
		driver.manage().window().maximize();
		System.out.println("STEP - Click on Demo Tables Link");
		driver.findElement(By.linkText("Demo Tables")).click();
		
		Thread.sleep(3000);
		System.out.println("STEP - Find number of rows");
		int TotalRows = driver.findElements(By.xpath("//table[@class=\"table table-striped\"]/tbody/tr")).size();
		
		System.out.println("STEP - Count of Employees per Department");
		for (int rowIndex = 1; rowIndex <= TotalRows; rowIndex++) {
			String dptName = driver.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr[" + rowIndex + "]/td[5]")).getText();
			if (map.containsValue(dptName)) {
				map.put(dptName,map.get(dptName)+1);
			} else
				map.put(dptName, 1);
		}	
		System.out.println("------------------------------------------");
		System.out.println(map);
		driver.close();
		return map;
	}
	
	public static void main(String[] args) throws InterruptedException {
		Assignment8 assignment8 = new Assignment8();
		assignment8.getEmployeeCountOfDepartment();
	}
}
