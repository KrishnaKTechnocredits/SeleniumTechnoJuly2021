/*Assignment-13:

https://datatables.net/extensions/autofill/examples/initialisation/focus.html

Program : Verify whole table is sorted based on Employee age.*/

package bhakti;

import java.util.ArrayList;
import java.util.Collections;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Assignment_13 {
	
	WebDriver driver;
	@BeforeClass
	void start() {
		System.setProperty("webdriver.chrome.driver", "./resources/chromedriver.exe");
		System.out.println("Step- Opend chrome driver");
		driver = new ChromeDriver();
		System.out.println("Step- Enter URL= https://datatables.net/extensions/autofill/examples/initialisation/focus.html ");
		driver.get("https://datatables.net/extensions/autofill/examples/initialisation/focus.html");
		
	}
	@AfterClass
	void end() {
		driver.quit();
	}
	
	//store values in employee object
	 @Test (priority=1)
	ArrayList<Employee> getEmployeeValues() {
		ArrayList<Employee> tabelData= new ArrayList();
		int pages= driver.findElements(By.xpath("//div/span/a[@class='paginate_button current' or @class='paginate_button ']")).size();
		for (int i=1; i<= pages; i++) {
			driver.findElement(By.xpath("//div/span/a[text()="+i+"]")).click();
			int rows= driver.findElements(By.xpath("//table[@id='example']/tbody/tr")).size();
			for (int j=1; j<= rows; j++) {
				String name=driver.findElement(By.xpath("//table[@id='example']/tbody/tr["+j+"]/td[1]")).getText();
				String position =driver.findElement(By.xpath("//table[@id='example']/tbody/tr["+j+"]/td[2]")).getText();
				String office=driver.findElement(By.xpath("//table[@id='example']/tbody/tr["+j+"]/td[3]")).getText();
				String  age =driver.findElement(By.xpath("//table[@id='example']/tbody/tr["+j+"]/td[4]")).getText();
				String start_date= driver.findElement(By.xpath("//table[@id='example']/tbody/tr["+j+"]/td[4]")).getText();
				String salary=driver.findElement(By.xpath("//table[@id='example']/tbody/tr["+j+"]/td[5]")).getText();
				Employee emp1= new Employee(name,position,office,age,start_date,salary  );
				tabelData.add(emp1);
			}
		}
		System.out.println("tabelData-->"+tabelData);
		return tabelData;
		
	}
	// find Sorting on basis  of age is working 
	@Test  (priority=2)
	void checkSortingWorking() {
		ArrayList<Employee> expectedTabelData= new ArrayList();
		expectedTabelData= getEmployeeValues();
		Collections.sort(expectedTabelData);
		driver.findElement(By.xpath("//table[@id='example']/thead/tr/th[4]")).click();
		ArrayList<Employee> actualTabelData= new ArrayList();
		actualTabelData=getEmployeeValues();
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(actualTabelData, expectedTabelData);
		
	}
	
}
