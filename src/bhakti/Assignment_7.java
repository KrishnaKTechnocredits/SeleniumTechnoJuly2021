/*Assignment - 7 : 23th Oct'2021
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
package bhakti;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Assignment_7 {
	
WebDriver driver;
	
	@BeforeClass
	void star() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./resources/chromedriver.exe");
		System.out.println("Step- Open Browser");
		driver = new ChromeDriver();
		System.out.println("Step- Open URL");
		driver.get("http://automationbykrishna.com/#");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//a[@id='demotable']")).click();
		Thread.sleep(5000);
	}
	@AfterClass
	void closeBrowser() {
		 driver.quit();
	}
	
	//to get all EmployeeDetils Strore in ArrayList
	
	void getAllTableData() {
		System.out.println("Read data from table and add that in list ");
		ArrayList <Employee> employeeList= new ArrayList();
		int rowCOunt = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size();
		int cloumn=driver.findElements(By.xpath("//table[@id='table1']/thead//th")).size();
		for (int i=1; i<=rowCOunt; i++ ) {
			ArrayList<String> rowdata= new ArrayList();
			for (int j=1; j<=cloumn; j++) {
				rowdata.add(driver.findElement(By.xpath("//table[@id='table1']/tbody/tr["+i+"]/td["+j+"]")).getText()) ;
			}
			employeeList.add(new Employee(rowdata.get(0), rowdata.get(1), rowdata.get(2), rowdata.get(3) ));
		}
		System.out.println(employeeList);
	}
	//1) How many tables are there on the page
	@Test
	void gettotalNumberTables() {
		System.out.println("1) How many tables are there on the page");
		List<WebElement> n= driver.findElements(By.xpath("//table"));
		System.out.println("Number of tables--> "+n.size());
		int expectedTableCount=4;
		int actualTablecount= n.size();
		SoftAssert softAssert= new SoftAssert();
		softAssert.assertEquals(actualTablecount, expectedTableCount);
		softAssert.assertAll();
		
		
	}
	//2) How many rows are there in EMPLOYEE BASIC INFORMATION
	@Test
	int getTotalRows(String tableID) {
		System.out.println("2) How many rows are there in EMPLOYEE BASIC INFORMATION");
		//List<WebElement> rows=driver.findElements(arg0)
		int expectedRowcount =5;
		int actualRowcount=driver.findElements(By.xpath("//table[@id='table1']/tbody//tr")).size();
		System.out.println("Number if rows-->"+actualRowcount);
		SoftAssert softAssert= new SoftAssert();
		softAssert.assertEquals(actualRowcount, expectedRowcount);
		softAssert.assertAll();
		return driver.findElements(By.xpath("//table[@id='table1']/thead//th")).size();
		
	}
	 
	//3) how many columns are there in EMPLOYEE BASIC INFORMATION
	@Test
	void  getnumOfColumn() {
			System.out.println("3) how many columns are there in EMPLOYEE BASIC INFORMATION");
		 int column=driver.findElements(By.xpath("//table[@id='table1']/thead//th")).size();
		 System.out.println("Number of column->"+column);
		 int actual= column;
		 int excpected= 4;
		SoftAssert softAssert= new SoftAssert();
		softAssert.assertEquals(actual, excpected);
		softAssert.assertAll();
		  
	 }
	 //4) return first name of all the employees
	 @Test
	 void getFristNameListFromEmployeeTable() {
		 System.out.println("4) return first name of all the employees");
		 int rows=driver.findElements(By.xpath("//table[@id='table1']/tbody//tr")).size();
		 String[] actualNames= new String[rows];
		 String[] ExpectedNames= {"Maulik", "Krishna", "Dhara", "Abhishek", "Priya"};
		 for (int i=1; i<=rows; i++) {
			 String name=driver.findElement(By.xpath("//table[@id='table1']/tbody//tr["+i+"]/td[2]")).getText();
			 actualNames[i-1]=name;
		 }
		 SoftAssert softAssert= new SoftAssert();
		 softAssert.assertEquals(actualNames, ExpectedNames);
		 softAssert.assertAll();
	 }
	 
	 //5) return index of given column name
	 @Test
	 void getIndexOfGivenCloumn() {
		 System.out.println("5) return index of given column name");
		 int column= driver.findElements(By.xpath("//table[@id='table1']/thead/tr/th")).size();
		 String ExpectColum= "Last Name";
		 int expectedColum=3;
		 for (int i=1; i<=column; i++) {
			 String currentName= driver.findElement(By.xpath("//table[@id='table1']/thead/tr/th["+i+"]")).getText();
			 if (currentName.equals(ExpectColum)) {
				 SoftAssert softAssert= new SoftAssert();
				 softAssert.assertEquals(i, expectedColum);
				 softAssert.assertAll();
			 }
				 
		 }
	 }
	//6) print all rows
	 @Test
	 void printAllRows() {
		 int actualRowCOunt = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size();
		 int expectedRowCount=5;
		 System.out.println("6) print all rows");
		 for (int i=1; i<= actualRowCOunt; i++) {
			 System.out.println(driver.findElement(By.xpath("//table[@id='table1']/tbody/tr["+i+"]")).getText());
		 }
		 Assert.assertEquals(actualRowCOunt, expectedRowCount);
	 }
	 
	 
	 //7) print lastname of the employee whoes first name is Abhishek
	 @Test
	 void printLastNameOfAbhishek() {
		 System.out.println("7) print lastname of the employee whoes first name is Abhishek");
		 int actualRowCOunt = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size();
		 String expectedName="Abhishek";
		 String expectedLastName="Sharma";
		 String lastName="";
		 
		 for (int i=1; i<=actualRowCOunt; i++ ) {
			 String currentName= driver.findElement(By.xpath("//table[@id='table1']/tbody/tr["+i+"]/td[2]")).getText();
			 if (currentName.equals(expectedName)) {
				  lastName=driver.findElement(By.xpath("//table[@id='table1']/tbody/tr["+i+"]/td[3]")).getText();
				  System.out.println(lastName);
				 break;
			 }	 
		 }
		 //m2
	 System.out.println("Method 2-->"+ driver.findElement(By.xpath("//table[@id='table1']/tbody//td[text()='Abhishek']/following-sibling::td[1]")).getText());
		 
		 SoftAssert softAssert= new SoftAssert();
		 softAssert.assertEquals(lastName, expectedLastName);
		 softAssert.assertAll();	 
	 }
	 
	 //8) print the firstname of the employee whoes username is ppatro
	 @Test
	 void getFristName() {
		 System.out.println("8) print the firstname of the employee whoes username is ppatro " );
		 String actual=driver.findElement(By.xpath("//table[@id='table1']//tbody/tr/td[text()='ppatro']//preceding-sibling::td[2]")).getText();
		 String expected= "Priya";
		 System.out.println(actual);
		 SoftAssert softAssert= new SoftAssert();
		 softAssert.assertEquals(actual, expected);
		 softAssert.assertAll();	 
	 }
	 //9) how many unique surnames we have in EMPLOYEE BASIC INFORMATION (4)
	 @Test
	 void uniqueSurname() {
		 System.out.println("9) how many unique surnames we have in EMPLOYEE BASIC INFORMATION (4)");
		 int actualRowCOunt = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size();
		 HashSet<String> surnames= new HashSet();
		 for (int i=1; i<= actualRowCOunt; i++) {
			 surnames.add(driver.findElement(By.xpath("//table[@id='table1']//tbody/tr["+i+"]/td[3]")).getText());
		 }
		 System.out.println(surnames);
		 int actual= surnames.size();
		 int expected= 4;
		 SoftAssert softAssert= new SoftAssert();
		 softAssert.assertEquals(actual, expected);
		 softAssert.assertAll();	
		  
	 }
	 //10) return a map of firstname and username.
	 
	 @Test
	 void getMapFN_UN() {
		 System.out.println("10) return a map of firstname and username.");
		 int  rows = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size();
		  
		 HashMap <String, String> names= new HashMap();
		 for (int i= 1; i<= rows; i++) {
			 String fn= driver.findElement(By.xpath("//table[@id='table1']//tbody/tr["+i+"]/td[2]")).getText();
			String uN= driver.findElement(By.xpath("//table[@id='table1']//tbody/tr["+i+"]/td[4]")).getText();
			 names.put(uN,fn);
		 }
		 System.out.println(names);
	 }
	 //11) is table contains emplyee having username as kkanani.
	 @Test
	 void containEmpUn() {
		 System.out.println("11) is table contains emplyee having username as kkanani");
		 String str= driver.findElement(By.xpath("//table[@id='table1']//tbody/tr//td[text()='kkanani']")).getText();
		 boolean actual=false;
		 if (!str.isEmpty())
			 actual=true;
		 boolean expected= true;
		 SoftAssert softAssert= new SoftAssert();
		 softAssert.assertEquals(actual, expected);
		 softAssert.assertAll();
		 
	 }
	 
}
