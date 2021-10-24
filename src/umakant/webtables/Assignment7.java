/*
 1) How many tables are there on the page
-> driver.findElements(By.xpath("//table")).size();
or
  driver.findElements(By.tagName("table"));	
  
  driver.findElements(By.xpath("//button")).get(0).click();

2) How many rows are there in EMPLOYEE BASIC INFORMATION
-> HW

3) how many columns are there in EMPLOYEE BASIC INFORMATION
-> HW

4) return first name of all the employees
->	ArrayList<String> listOfFirstName = new ArrayList<String>();
	String[] arr = new String[totalRows];
	for(){
		String firstName = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr["+rowIndex+"]/td[2]")).getText();
		listOfFirstName.add(firstName);
		arr[rowIndex] = firstName;
	}
	return listOfFirstName;

5) return index of given column name
   ie. lastname -> 3 column index
   
   int getColIndex(String colName){
		int totalCol = 4;
		int targetIndex = 0;
		for(int index=1;index<totalCol;index++){
			String headerText = driver.findElement(By.xpath("//table[@id='table1']/thead/tr/th["+index+"]")).getText();
			if(headerText.equals(colName)){
				targetIndex = index;
				break;
			}
		}
		if(targetIndex == 0)
			throw new ColNotFoundException("User trying to find colName " + colName + " which is not a part of a table);
		return targetIndex;
   }
   
6) print all rows
->
for(int rowIndex=1;rowIndex<=totalRows;rowIndex++){
	for(int colIndex=1;colIndex<=totalCols;colIndex++){		    soprint(driver.findElement(By.xpath("//table[@id='table1']/tbody/tr["+rowIndex+"]/td["+colIndex+"]")).getText() + " - ");
	}
	soprintln();
}

or
	for(int rowIndex=1;rowIndex<=totalRows;rowIndex++){
		sop(driver.findElement(By.xpath("//table[@id='table1']/tbody/tr["+rowIndex+"]")).getText());
	}

or
//table[@id='table1']


7) print lastname of the employee whoes first name is Abhishek

for(int index=1;index<=totalRows;index++){
	String currentName = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr["+index+"]/td[2]")).getText();
	String output = "";
	if(name.equals(currentName)){
		output = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr["+index+"]/td[3]")).getText();
		break;
	}
}
return output;

8) print the firstname of the employee whoes username is ppatro
HW

9) how many unique surnames we have in EMPLOYEE BASIC INFORMATION (4)
HW

10) return a map of firstname and username.
HashMap<String,String> hm = new HashMap<String,String>();
for(){
	String username = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr["+index+"]/td[4]")).getText();
	String firstName =driver.findElement(By.xpath("//table[@id='table1']/tbody/tr["+index+"]/td[2]")).getText(); 
	hm.put(username, firstName);
}

11) is table contains emplyee having username as kkanani.
 //table[@id='table1']/tbody//td[text()='"+name+"']
*/

package umakant.webtables;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base.PredefinedActions;

public class Assignment7 {
	WebDriver driver;
	Map<String, Integer> headerIndexMap = new HashMap<String, Integer>();
	Map<String, String> lastNameMap = new HashMap<String, String>();
	Map<String, String> userNameMap = new HashMap<String, String>();

	@BeforeClass
	void launchBrowser() {
		headerIndexMap.put("#", 1);
		headerIndexMap.put("First Name", 2);
		headerIndexMap.put("Last Name", 3);
		headerIndexMap.put("Username", 4);
		lastNameMap.put("Maulik", "Kanani");
		lastNameMap.put("Krishna", "Kanani");
		lastNameMap.put("Dhara", "Boda");
		lastNameMap.put("Abhishek", "Sharma");
		lastNameMap.put("Priya", "Kanani");
		userNameMap.put("Maulik", "mkanani");
		userNameMap.put("Krishna", "kkanani");
		userNameMap.put("Dhara", "dboda");
		userNameMap.put("Abhishek", "asharma");
		userNameMap.put("Priya", "ppatro");
		driver = PredefinedActions.start();
		driver.findElement(By.linkText("Demo Tables")).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	void numberOfTables() {
		int expectedResult = 4;
		int actualResult = driver.findElements(By.tagName("table")).size();
		Assert.assertEquals(actualResult, expectedResult);
	}

	@Test
	void numberOfRowsInEmployeeInformation() {
		int expectedResult = 5;
		int actualResult = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size();
		Assert.assertEquals(actualResult, expectedResult);
	}

	@Test
	void numberOfColumnsInEmployeeInformation() {
		int expectedResult = 4;
		int actualResult = driver.findElements(By.xpath("//table[@id='table1']/thead/tr/th")).size();
		Assert.assertEquals(actualResult, expectedResult);
	}

	@Test
	void listOfFirstNames() {
		ArrayList<String> expectedList = new ArrayList<String>();
		ArrayList<String> actualList = new ArrayList<String>();
		expectedList.add("Maulik");
		expectedList.add("Krishna");
		expectedList.add("Dhara");
		expectedList.add("Abhishek");
		expectedList.add("Priya");
		int rows = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size();
		for (int rowIndex = 1; rowIndex <= rows; rowIndex++) {
			String firstName = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + rowIndex + "]/td[2]"))
					.getText();
			actualList.add(firstName);
		}
		Assert.assertEquals(actualList, expectedList);
	}

	@Parameters("columnHeaderName")
	@Test
	void getColumnIndex(@Optional("Username") String columnHeaderName) {
		int columns = driver.findElements(By.xpath("//table[@id='table1']/thead/tr/th")).size();
		int expectedIndex = 0;
		for (int columnIndex = 1; columnIndex <= columns; columnIndex++) {
			String columnHeader = driver.findElement(By.xpath("//table[@id='table1']/thead/tr/th[" + columnIndex + "]"))
					.getText();
			if (columnHeader.equals(columnHeaderName)) {
				expectedIndex = columnIndex;
				break;
			}
		}
		Assert.assertEquals((int) headerIndexMap.get(columnHeaderName), expectedIndex);
	}

	@Parameters("firstName")
	@Test
	void getLastName(@Optional("Abhishek") String firstName) {
		int rows = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size();
		String lastName = "";
		for (int rowIndex = 1; rowIndex <= rows; rowIndex++) {
			String name = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + rowIndex + "]/td[2]"))
					.getText();
			if (name.equals(firstName)) {
				lastName = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + rowIndex + "]/td[3]"))
						.getText();
				break;
			}
		}
		Assert.assertEquals(lastNameMap.get(firstName), lastName);
	}

	@Test
	void verfiryFirstNameAndUserName() {
		Map<String, String> expectedMap = new HashMap<String, String>();
		int rows = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size();
		for (int rowIndex = 1; rowIndex <= rows; rowIndex++) {
			String name = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + rowIndex + "]/td[2]"))
					.getText();
			String userName = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + rowIndex + "]/td[4]"))
					.getText();
			expectedMap.put(name, userName);

		}
		Assert.assertEquals(userNameMap, expectedMap);

	}

	@Parameters("userName")
	@Test
	void verifyUserName(@Optional("kkanani") String userName) {
		int rows = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size();
		boolean isPresent = false;
		for (int rowIndex = 1; rowIndex <= rows; rowIndex++) {
			String username = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + rowIndex + "]/td[4]"))
					.getText();
			if (username.equals(userName)) {
				isPresent = true;
				break;
			}

		}
		Assert.assertTrue(isPresent);
	}

	@Test
	void uniqueSurname() {
		Set<String> uniqueSurname = new HashSet<String>();
		int rows = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size();
		for (int rowIndex = 1; rowIndex <= rows; rowIndex++) {
			String surname = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + rowIndex + "]/td[3]"))
					.getText();
			uniqueSurname.add(surname);
		}
		Assert.assertEquals(4, uniqueSurname.size());
	}

	@Parameters("userName")
	@Test
	void getFirstName(@Optional("ppatro") String userName) {
		int rows = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size();
		String firstName = "";
		for (int rowIndex = 1; rowIndex <= rows; rowIndex++) {
			String userId = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + rowIndex + "]/td[4]"))
					.getText();
			if (userId.equals(userName)) {
				firstName = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + rowIndex + "]/td[2]"))
						.getText();
				break;
			}
		}
		Assert.assertEquals("Priya", firstName);
	}

	@Test
	void verifyTable() {
		int rows = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size();
		int columns = driver.findElements(By.xpath("//table[@id='table1']/thead/tr/th")).size();
		System.out.println(driver.findElement(By.xpath("//table[@id='table1']")).getText());
		Assert.assertTrue(rows == 5 && columns == 4);
	}

	@AfterClass
	void closeBrowser() {
		driver.close();
	}

}
