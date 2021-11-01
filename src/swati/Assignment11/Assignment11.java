package swati.Assignment11;

/*

Assginment - 11: 24th Oct'2021
Program 1: Return unique Employees from table-2.  
output : size - 8

Program 2: print employee id which is duplicate in table-2 
output : 76585 

Program 3: print the name of deptment having maximum employees. 
output : 7013-IT
*/

import java.util.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Assignment11 {
	
	WebDriver driver;
	SoftAssert softAssert=new SoftAssert();
	
	@Test
	WebDriver start() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","./resources/chromedriver.exe");
		driver=new ChromeDriver();
		System.out.println("Enter URL");
		driver.get("http://automationbykrishna.com/#");
		driver.manage().window().maximize();
		System.out.println("Clcik on Demo Tables");
		driver.findElement(By.xpath("//a[@id='demotable']")).click();
		Thread.sleep(3000);
		return driver;			
	}
	
	@Test
	void getUniqueEmployee() {
		//table[@class='table table-striped']/tbody/tr/td[3]
		//int rowCount=driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr")).size();
		int expected=8;
		ArrayList<String> list1=new ArrayList<String>();
		List <WebElement> elements=driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr/td[3]"));
		for(WebElement item:elements) {
			String name=item.getText();
			if(!list1.contains(name)) {
				list1.add(name);
			}
			
		}
		int actual=list1.size();
		System.out.println(list1+":"+list1.size());
		softAssert.assertTrue(actual==expected);
		
	}
	@Test
	void getDuplicateEmpId() {
		HashSet<String> inputEmpList=new HashSet<String>();
		HashSet<String> outputEmpList=new HashSet<String>();
		HashSet<String> expectedEmpList=new HashSet<String>();
		expectedEmpList.add("76585");
		List<WebElement> list1=driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr/td[2]"));
		for(WebElement element:list1) {
			String empId=element.getText();
			if(!inputEmpList.add(empId)) {
				outputEmpList.add(empId);
			}
		}
		
		System.out.println(outputEmpList);
		softAssert.assertTrue(outputEmpList.equals(expectedEmpList));
	}
	
	@Test
	void getDeptHavingMaxEmp() {
		String expceted="7013-IT";
		//table[@class='table table-striped']/tbody/tr/td[5][text()='7001-Admin']//preceding-sibling::td[2]
		HashMap<String,Integer> map1=new HashMap<String,Integer>();
		int rowCount=driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr")).size();
		for(int index=1;index<=rowCount;index++) {
			String deptName=driver.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr["+index+"]/td[5]")).getText();
			int count=driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr/td[5][text()='"+deptName+"']//preceding-sibling::td[2]")).size();
			map1.put(deptName, count);
			
		}
		
		System.out.println(map1);
		int max=0;
		String actual="";
		for(String dept:map1.keySet()) {
			int temp=map1.get(dept);
			if(max<temp) {
				max=temp;
				actual=dept;
			}
			
		}
		System.out.println(actual);
		softAssert.assertTrue(actual.equals(expceted));
	}
	
	@Test
	void end() {
		driver.close();
	}
}

