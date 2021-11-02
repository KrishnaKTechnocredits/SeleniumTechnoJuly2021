package amolVyas;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import amolVyas.Assignment_5.Action;

public class Assignment_7 {
	
	WebDriver driver;
	
	@BeforeClass
	void getOpenBrowser() throws InterruptedException {
		driver = Action.start();
		System.out.println("STEP-Navigate to Demo tables");
	driver.findElement(By.xpath("//a[text()='Demo Tables']")).click();
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	int getCountOfMatchedXpath(String xpath) {
		return driver.findElements(By.xpath(xpath)).size();
	}
	
	@Test
	void getTotalCountOfTable() {
		System.out.println("Count of Table on a page is: "+getCountOfMatchedXpath("//table"));
		Assert.assertEquals(getCountOfMatchedXpath("//table"), 4);
	}
	
	@Test
	void getRowCountFromEmpTable(){
		System.out.println("Count of Row in Emp table: "+getCountOfMatchedXpath("//table[@id='table1']/tbody/tr"));
		Assert.assertEquals(getCountOfMatchedXpath("//table[@id='table1']/tbody/tr"), 5);
	}
	
	@Test
	void getColumnCountFromEmpTable() {
		System.out.println("Count of Column in Emp Table: "+getCountOfMatchedXpath("//table[@id='table1']/thead/tr/th"));
		Assert.assertEquals(getCountOfMatchedXpath("//table[@id='table1']/thead/tr/th"), 4);
	}
	
	@Test
	void printFirstNameColumnFromTable() {
		List<WebElement> list = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr/td[2]"));
		Assert.assertEquals(list.size(), 5);
		for(WebElement FirstName:list) {
			System.out.print(FirstName.getText()+" ");
		}
	}
	
	@Test
	void getColumnIndex() {
		int totalColumn=driver.findElements(By.xpath("//table[@id='table1']/thead//th")).size();
		int targetIndex=0;
		for(int index =1;index<=totalColumn;index++) {
			String header = driver.findElement(By.xpath("//table[@id='table1']/thead//th["+index+"]")).getText();
			if(header.equalsIgnoreCase("Last Name")) {
				targetIndex=index;
				break;
			}
		}
		System.out.println("Column Index of Last Name column is "+targetIndex);
		Assert.assertEquals(targetIndex, 3);
	}
	
	
	@Test
	void printAllRows() {
		List<WebElement> list = driver.findElements(By.xpath("//table[@id='table1']"));
		for(WebElement wb : list) {
			System.out.println(wb.getText());
		}
	}
	
	@Test
	void getFirstNameByUserName() {
		String firstName = driver.findElement(By.xpath("//table[@id='table1']/tbody//td[text()='ppatro']/preceding-sibling::td[2]")).getText();
		Assert.assertEquals(firstName, "Priya");
	}
	
	@Test
	void getLastNameFromFirstName() {
		String lastName = driver.findElement(By.xpath("//table[@id='table1']/tbody//td[text()='Abhishek']/following-sibling::td[1]")).getText();
		Assert.assertEquals(lastName, "Sharma");
	}
	
	@Test
	void getUniqueSurnameFromTable() {
		List<WebElement> list = driver.findElements(By.xpath("//table[@id='table1']/tbody//td[3]"));
		Set<String> set = new HashSet();
		for(WebElement wb : list) {
			set.add(wb.getText());
		}
		System.out.println("Unique surnames from table is: "+set.size());
		Assert.assertEquals(set.size(),4);
	}
	
	@Test
	void getMapOfUserNameAndFirstName() {
		Map<String,String> map = new HashMap();
		int totalRows= driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size();
		for(int index=1;index<=totalRows;index++) {
			String userName=driver.findElement(By.xpath("//table[@id='table1']/tbody/tr["+index+"]/td[4]")).getText();
			String firstName=driver.findElement(By.xpath("//table[@id='table1']/tbody/tr["+index+"]/td[2]")).getText();
			map.put(userName, firstName);
		}
		System.out.println("Values of UserName and FirstName is :"+map);
		Assert.assertEquals(map.size(), 5);
		
	}
	
	@Test
	void isUserNamePresent() {
		boolean present = driver.findElement(By.xpath("//table[@id='table1']/tbody//td[text()='kkanani']")).isDisplayed();
		Assert.assertEquals(present, true);
	}
	
	
	
	@AfterClass
	void closeConnection() {
		driver.close();
	}
	

}
