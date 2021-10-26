/*Assginment - 11: 24th Oct'2021
Program 1: Return unique Employees from table-2. 
output : size - 8*/

package bhakti;

import java.util.HashSet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Assignment_11 {
	
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
	 //Return unique Employees from table-2. 
	@Test
	void findUniqueEmp() {
		int rows= driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr")).size();
		HashSet<String> empIDList= new HashSet();
		HashSet<String> empID_NameList= new HashSet();
		for (int i=1; i<= rows; i++) {
			String empID= driver.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr["+i+"]/td[2]")).getText();
			if (empIDList.add(empID)) {
				String empName= driver.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr["+i+"]/td[3]")).getText();
				String empNameID= empID+"-"+empName;
				empID_NameList.add(empNameID);
			}
		}
		System.out.println("Numer of unique employee ->"+empIDList.size());
		System.out.println("Below is Unique employee List :");
		System.out.println(empID_NameList);
		int actual=empIDList.size();
		int expected=8;
		SoftAssert softAssert= new SoftAssert();
		softAssert.assertEquals(actual, expected);
	}

}
