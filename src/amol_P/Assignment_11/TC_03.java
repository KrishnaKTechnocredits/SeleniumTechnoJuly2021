package amol_P.Assignment_11;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC_03 {
	/*Program 3: print the name of deptment having maximum employees. 
	output : 7013-IT*/

	WebDriver driver;
	@BeforeMethod()
	public void setup() {
		driver = PredefineAction.start();
	}
	@Test()
	public void deptWithMaxEmployee_TC_03() {
	
		Map<String, Integer> map=new HashMap<String, Integer>();
		driver.findElement(By.xpath("//a[@id='demotable']")).click();
		List<WebElement> list= driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr/td[5]"));
		for(int index=0;index<list.size();index++)
		{
			String empDept=list.get(index).getText();
			if(map.containsKey(empDept))
			{
				map.put(empDept, map.get(empDept)+1);
			}
			else
			{
				map.put(empDept, 1);
			}
		}
		Set<String> maxDept=map.keySet();
		int maxDeptNum=0;
		String DeptWithMaxEmployee="";
		
		for(String dept:maxDept)
		{
			if(map.get(dept)>maxDeptNum)
			{
				maxDeptNum=map.get(dept);
				DeptWithMaxEmployee=dept;
			}
		}
		System.out.println("Dept who having maximum Emp with count as "+maxDeptNum +" is :"+DeptWithMaxEmployee);
		Assert.assertEquals(DeptWithMaxEmployee, "7013-IT");
	}
	
	@AfterMethod()
	public void teardown() {
		driver.close();
	}
}
