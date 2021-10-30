package swati.Assignment7;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Assignment7 {
	WebDriver driver;
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
	void test1() {
		//1) How many tables are there on the page.
		int totalTable=driver.findElements(By.xpath("//table")).size();
		System.out.println("Total tables on Page: "+totalTable);
		//driver.findElements(By.tagName("table")).size();		
	}
	@Test
	void test2() {
		//2) How many rows are there in EMPLOYEE BASIC INFORMATION
		int expectedValue=5;
		int result=driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size();
		System.out.println("Total rows in EMPLOYEE BASIC INFORMATION: "+result);
		Assert.assertEquals(result, expectedValue);
	}
	@Test
	void test3() {
		//3) how many columns are there in EMPLOYEE BASIC INFORMATION
		int expected=4;
		int actual=driver.findElements(By.xpath("//table[@id='table1']/thead/tr/th")).size();
		System.out.println("Total columns in EMPLOYEE BASIC INFORMATION: "+actual);
		Assert.assertEquals(actual, expected);
	}
	@Test
	void test4() {
		//4) return first name of all the employees
		int expected=5;
		int actual=returnFnameOfAllEmp().size();
		System.out.println(actual);
		Assert.assertEquals(actual, expected);
	}
	
	ArrayList<String> returnFnameOfAllEmp() {
		
		int totalrows=driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size();
		ArrayList<String> listOfFirstName = new ArrayList<String>();
		for(int index=1;index<=totalrows;index++) {
			String fname=driver.findElement(By.xpath("//table[@id='table1']/tbody/tr["+index+"]/td[2]")).getText();
			listOfFirstName.add(fname);		
		}
		//System.out.println(listOfFirstName);
		return listOfFirstName;
	}
	@Test
	void test5() {
		/*5) return index of given column name
		   ie. lastname -> 3 column index
		  */
		int expected=3;
		int totalcolumn=driver.findElements(By.xpath("//table[@id='table1']/thead/tr/th")).size();
		int actual=0;
		for(int index=1;index<=totalcolumn;index++) {
			String text=driver.findElement(By.xpath("//table[@id='table1']/thead/tr/th["+index+"]")).getText();
			if(text.equals("Last Name")) {
				actual=index;
				break;
			}
		}
		System.out.println("Index of Last Name :"+actual);
		Assert.assertEquals(actual, expected);
	}
	@Test
	void test6() {
		//6) print all rows
		int expected=5;
		int totalrows=driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size();
		for(int index=1;index<=totalrows;index++) {
			System.out.println(driver.findElement(By.xpath("//table[@id='table1']/tbody/tr["+index+"]")).getText());
		}
		int actual=totalrows;
		Assert.assertEquals(actual, expected);
		
	}
	@Test
	void test7() {
		//7) print lastname of the employee whoes first name is Abhishek
		//table[@id='table1']/tbody/tr[4]/td[3]
		String expected="Sharma";
		String actual="";
		int totalrow=driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size();
		//int totalCol=driver.findElements(By.xpath("//table[@id='table1']/thead/tr/th")).size();
		for(int index=1;index<=totalrow;index++) {
			String name=driver.findElement(By.xpath("//table[@id='table1']/tbody/tr["+index+"]/td[3]")).getText();
			if(name.equals(expected)) {
				actual=name;
				System.out.println("Last Name: "+name);
			}
		}
		Assert.assertEquals(actual, expected);
	}
	@Test
	void test8() {
		//8) print the firstname of the employee whoes username is ppatro
		//table[@id='table1']/tbody/tr[1]/td[2]
		String expected="Priya";
		String actual="";
		int totalrow=driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size();
		for(int index=1;index<=totalrow;index++) {
			String name=driver.findElement(By.xpath("//table[@id='table1']/tbody/tr["+index+"]/td[2]")).getText();
			if(name.equals(expected)) {
				actual=name;
				System.out.println("First Name: "+name);
			}
		}
		Assert.assertEquals(actual, expected);
	}
	
	@Test
	void test9() {
		//9) how many unique surnames we have in EMPLOYEE BASIC INFORMATION (4)
		////table[@id='table1']/tbody/tr[2]/td[3]
		int expected=4;
		int actual=0;
		Set <String> set= new LinkedHashSet<String>();
		int totalrow=driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size();
		for(int index=1;index<=totalrow;index++) {
			String name=driver.findElement(By.xpath("//table[@id='table1']/tbody/tr["+index+"]/td[3]")).getText();
			set.add(name);
		}
		actual=set.size();
		System.out.println("Unique surnames :"+actual);
		Assert.assertTrue(expected==actual);
	}
	@Test
	void test10() {
		//10) return a map of firstname and username.
		int expected=5;
		int actual=0;
		int totalrow=driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size();
		HashMap<String,String> map1 = new HashMap<String,String>();
		for(int index=1;index<=totalrow;index++) {
			String firstName=driver.findElement(By.xpath("//table[@id='table1']/tbody/tr["+index+"]/td[2]")).getText();
			String userName=driver.findElement(By.xpath("//table[@id='table1']/tbody/tr["+index+"]/td[4]")).getText();
			map1.put(firstName, userName);
		}
		actual=map1.size();
		System.out.println(map1);
		Assert.assertEquals(actual, expected);
	}
	@Test
	void test11() {
		//is table contains emplyee having username as kkanani.
		String expected="kkanani";
		boolean flag=false;
		int totalrow=driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size();
		for(int index=1;index<=totalrow;index++) {
			String userName=driver.findElement(By.xpath("//table[@id='table1']/tbody/tr["+index+"]/td[4]")).getText();
			if(userName.endsWith(expected)) {
				flag=true;
			}		
		}
		System.out.println("is table contains emplyee having username as kkanani: "+flag);
		Assert.assertTrue(flag);
		
	}
	@Test
	void end() {
		driver.close();
	}
	
	
}

