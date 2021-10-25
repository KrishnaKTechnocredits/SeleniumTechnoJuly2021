/*Assginment - 9 : 24th Oct'2021
Verfiy Employee count and Employee name in each deptment.

Sample Output: Employee Count in 7001-Admin dept.
               Employee name belongs to 7001-Admin dept.
               HashMap<String, ArrayList<String>>
               HashMap <String, 1> 
               
               Dep A (Key) =  bhakti  (AttayList) , harshada
               Dep B= Amol, Amruta
			   
*/

package bhakti;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Assignment_9 {

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

	// Verfiy Employee count and Employee name in each deptment.
	@Test
	void empCountAndEmpNameOfEachDep() {

		HashMap<String, ArrayList<String>> depListMap = new HashMap();
		ArrayList<String> empNames = new ArrayList<String>();
		int rows = driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr")).size();
		for (int i = 1; i <= rows; i++) {
			String depName = driver
					.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr[" + i + "]/td[5]")).getText();
			if (depListMap.containsKey(depName)) {
				ArrayList<String> temp = depListMap.get(depName);
				String empName = driver
						.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr[" + i + "]/td[3]"))
						.getText();
				temp.add(empName);
				depListMap.put(depName, temp);

			} else {
				String empName = driver
						.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr[" + i + "]/td[3]"))
						.getText();
				ArrayList currentNames = new ArrayList();
				currentNames.add(empName);
				depListMap.put(depName, currentNames);
			}
		}
		System.out.println(depListMap);

		for (Entry<String, ArrayList<String>> dep : depListMap.entrySet()) {
			System.out.println(dep.getKey() + " -" + dep.getValue() + "- Number of employee: " + dep.getValue().size());
			SoftAssert softAssert = new SoftAssert();
			if (dep.getKey().equals("7003-HR")) {
				softAssert.assertEquals(dep.getValue().size(), 2);
				String[] name = { "Sumit Kulkarni", "Pawan Belamkar" };
				ArrayList<String> expected = new ArrayList<String>(Arrays.asList(name));
				softAssert.assertEquals(dep.getValue(), expected);
			} else if (dep.getKey().equals("7013-IT")) {
				softAssert.assertEquals(dep.getValue().size(), 3);
				String[] name = { "Nikhil Patne","Chetan Shewale", "Priyanka Bhale" };
				ArrayList<String> expected = new ArrayList<String>(Arrays.asList(name));
				softAssert.assertEquals(dep.getValue(), expected);

			} else if (dep.getKey().equals("7002-Finance")) {
				softAssert.assertEquals(dep.getValue().size(), 2);
				String[] name = { "Sumit Mate", "Sumit Mate" };
				ArrayList<String> expected = new ArrayList<String>(Arrays.asList(name));
				softAssert.assertEquals(dep.getValue(), expected);
			} else if (dep.getKey().equals("7001-Admin")) {
				softAssert.assertEquals(dep.getValue().size(), 2);
				String[] name = { "Abhijit Mane", "Prayag Mokate" };
				ArrayList<String> expected = new ArrayList<String>(Arrays.asList(name));
				softAssert.assertEquals(dep.getValue(), expected);
			}
		}
	}
}
