/*Assginment - 10 : 24th Oct'2021
Similar to Assignment-9 but verification should be against managerid.
Sample Output: Employee Count reports to manager having manager id - 20209.
               Employee name reports to manager having manager id - 20209.
			   
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

public class Assignment_10 {

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

		HashMap<String, ArrayList<String>> managerListMap = new HashMap();
		ArrayList<String> empNames = new ArrayList<String>();
		int rows = driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr")).size();
		for (int i = 1; i <= rows; i++) {
			String mngName = driver
					.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr[" + i + "]/td[4]")).getText();
			if (managerListMap.containsKey(mngName)) {
				ArrayList<String> temp = managerListMap.get(mngName);
				String empName = driver
						.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr[" + i + "]/td[3]"))
						.getText();
				temp.add(empName);
				managerListMap.put(mngName, temp);

			} else {
				String empName = driver
						.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr[" + i + "]/td[3]"))
						.getText();
				ArrayList currentNames = new ArrayList();
				currentNames.add(empName);
				managerListMap.put(mngName, currentNames);
			}
		}
		System.out.println(managerListMap);

		for (Entry<String, ArrayList<String>> dep : managerListMap.entrySet()) {
			System.out.println(dep.getKey() + " -" + dep.getValue() + "- Number of employee: " + dep.getValue().size());
			SoftAssert softAssert = new SoftAssert();
			if (dep.getKey().equals("20209")) {
				softAssert.assertEquals(dep.getValue().size(), 3);
				String[] name = { "Abhijit Mane", "Sumit Kulkarni", "Pawan Belamkar" };
				ArrayList<String> expected = new ArrayList<String>(Arrays.asList(name));
				softAssert.assertEquals(dep.getValue(), expected);
			} else if (dep.getKey().equals("10101")) {
				softAssert.assertEquals(dep.getValue().size(), 2);
				String[] name = { "Chetan Shewale","Priyanka Bhale" };
				ArrayList<String> expected = new ArrayList<String>(Arrays.asList(name));
				softAssert.assertEquals(dep.getValue(), expected);

			} else if (dep.getKey().equals("20205")) {
				softAssert.assertEquals(dep.getValue().size(), 4);
				String[] name = { "Sumit Mate", "Prayag Mokate","Sumit Mate", "Nikhil Patne" };
				ArrayList<String> expected = new ArrayList<String>(Arrays.asList(name));
				softAssert.assertEquals(dep.getValue(), expected);
			} 
		}
	}
}
