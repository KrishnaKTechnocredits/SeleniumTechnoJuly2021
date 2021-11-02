package priti.Assingment_7;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestCase_1 {
	WebDriver driver;
	@BeforeClass
	void  start() {
		System.setProperty("webdriver.chrome.driver", "./resources/chromedriver.exe");
		driver = new ChromeDriver();
		System.out.println("Step : Launch Chrome Browser");
		driver.manage().window().maximize();
		System.out.println("Step :open Website -http://automationbykrishna.com/index.html");
		driver. get("http://automationbykrishna.com/");
		driver.findElement(By.xpath("//a [@id ='demotable']")).click();
	}

	int getTableCountOnDemoTable() {
		System.out.println("Step-1-How many tables are there on the page:");
		//int tablecount  = driver.findElements(By.xpath("//table")).size();
		int tablecount  = driver.findElements(By.tagName("table")).size();
		System.out.println("Total number of tables in DemoTable link:"+ tablecount);
		return tablecount;
	}
	@Parameters("exptableCount")
	@Test
	public void verifyTotalTablecount(int exptableCount) {
		//int exptableCount= 4;
		int actualTableCount= getTableCountOnDemoTable();
		System.out.println("Compare exppected and actual table count:");
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(exptableCount, actualTableCount);
		softAssert.assertAll();
		
	}
		
	int findtotalRowsInEmployeeBasicIinformation(){
		 System.out.println("Step-2-How many rows are there in EMPLOYEE BASIC INFORMATION:");
		 List<WebElement> list  = driver.findElements(By.xpath("//table [@id ='table1']/tbody/tr"));
		 System.out.println("Find total number of rows in Employee Basic Information table:");
		 int rowCount= driver.findElements(By.xpath("//table [@id ='table1']/tbody/tr")).size();
		 System.out.println("Total number of rows in Employee basic information table:"+ list.size());
		 return rowCount;
	 }
	@Parameters("expRowCount")
	@Test
	void verifyCountOFRowsInEmployeeBasicIinformation(int expRowCount) {
		 //int expRowCount = 5;
		 int actualRowCount = findtotalRowsInEmployeeBasicIinformation();
		 System.out.println("Step:compare expected and actual row count");
		 SoftAssert softAssert= new SoftAssert();
		 softAssert.assertEquals(actualRowCount, expRowCount, ("Expected row count is 5 but actual row count: "+actualRowCount));
		 softAssert.assertAll();
	 }
	
	int findTotalColInEmlpoyeeBasicInformation() {
		System.out.println("Step-3-how many columns are there in EMPLOYEE BASIC INFORMATION:");
		System.out.println("Find total number of Columns in Employee Basic Infromatiom table:");
		int totalColCount= driver.findElements(By.xpath("//table[@id ='table1']/thead/tr/th")).size();
		System.out.println("Total number of columns in Employee basic information table:"+ totalColCount);
		return totalColCount;
	}
	@Parameters("expColumnCount")
	@Test
	void verifyTotalColCountInEmployeeBasicInformation(int expColumnCount) {
		//int expColumnCount= 4;
		int actualColCount= findTotalColInEmlpoyeeBasicInformation();
		System.out.println("Step :compare expected and actual Column count");
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(expColumnCount, actualColCount);
		softAssert.assertAll();
		
	}
	
	@Test	
	void getFristNameListFromEmployeeTable() {
		 System.out.println("Step-4-Return first name of all the employees");
		 int rowCount=driver.findElements(By.xpath("//table[@id='table1']/tbody//tr")).size();
		 String[] actualEmpName = new String[rowCount];
		 int count =0;
		 String[] ExpEmpName= {"Maulik", "Krishna", "Dhara", "Abhishek", "Priya"};
		 for (int rowIndex =1; rowIndex<=rowCount;rowIndex++) {
			 String empName=driver.findElement(By.xpath("//table[@id='table1']/tbody//tr["+rowIndex+"]/td[2]")).getText();
			 actualEmpName[count]=empName;
			 count++;
		 }
		 SoftAssert softAssert= new SoftAssert();
		 softAssert.assertEquals(actualEmpName, ExpEmpName);
		 softAssert.assertAll();
	}
	@Parameters("exptagrgetIndex")
	@Test
	void returnIndexOfGivenColumName(int exptagrgetIndex) {
		System.out.println("Step-5-return index of given column name");
		String colName= "Last Name";
		//int exptagrgetIndex = 3;
		int actualTargetIndex=0;
		SoftAssert softAssert = new SoftAssert();
		int colCount= driver.findElements(By.xpath("//table[@id ='table1']/thead/tr/th")).size();
		for(int index=1;index<colCount;index++) {
			String headerText=
				driver.findElement(By.xpath("//table[@id ='table1']/thead/tr/th["+index+"]")).getText();
				if (headerText.equals(colName)) {
				actualTargetIndex = index;
				break;
			}
		}
		 softAssert.assertEquals(actualTargetIndex, exptagrgetIndex);
		 softAssert.assertAll();
	}
	
	

	/*void PrintAllRowsInEmployeebasicInformation(){
		System.out.println("Step-6-Print all rows:");
		int totalRows = driver.findElements(By.xpath("//table [@id ='table1']/tbody/tr")).size();
		System.out.println(totalRows);
		int totalCol = driver.findElements(By.xpath("//table[@id  ='table1']/thead/tr/th")).size();
		System.out.println(totalCol);
		for(int rowIndex=1;rowIndex<=totalRows ;rowIndex++) {
			for (int colIndex=1;colIndex<=totalCol ;colIndex++ ) {
				System.out.print(driver.findElement(By.xpath("//table[@id  ='table1']/tbody/tr["+rowIndex+"]/td["+colIndex+"]")).getText() +"-");
			}
			System.out.println();
		}
	}*/
	
	@Test
	void printallRows() {
	System.out.println("Step-6-Print all rows:");
	System.out.println(driver.findElement(By.xpath("//table[@id  ='table1']")).getText());
		
	}
	@Parameters("expfirstName")
	@Test //for this test in xml file pass paramter for the firstname.
	void printLastnameofEmpForGivenFirstName(String expfirstName) {
		//String expfirstName = "Abhishek";
		String actuallastName = "";
		 System.out.println("Step-7-print lastname of the employee whoes first name is Abhishek");
		 int totalRows = driver.findElements(By.xpath("//table [@id ='table1']/tbody/tr")).size();
		 System.out.println(totalRows);
		 for (int index=1 ;index<totalRows;index++) {
			 String actfirstName = 
					 driver.findElement(By.xpath("//table[@id ='table1']/tbody/tr["+index+"]/td[2]")).getText();
			 if (expfirstName.equals(actfirstName)) {
				 actuallastName = driver.findElement(By.xpath("//table[@id ='table1']/tbody/tr["+index+"]/td[3]")).getText();
				 System.out.println(actuallastName);
				 break;
			 }
			
		 }
		 System.out.println("FirstName name :"+ expfirstName +" Last name :"+ actuallastName+":");
	}	 
	@Parameters("expUserName")
	@Test
	void printFirstNamewithUserNameGiven(String expUserName) {
		System.out.println("Step-8-print the firstname of the employee whoes username is ppatro");
		String expFirstName = "Priya";
		//String expUserName = "ppatro";
		String actualFirstName = "";
		int totalRows = driver.findElements(By.xpath("//table [@id ='table1']/tbody/tr")).size();
		for (int index=1;index<=totalRows;index++) {
			String actualUserName= driver.findElement(By.xpath("//table[@id ='table1']/tbody/tr["+index+"]/td[4]")).getText();
			if (actualUserName.equals(expUserName)) {
				actualFirstName = driver.findElement(By.xpath("//table[@id ='table1']/tbody/tr["+index+"]/td[2]")).getText();
				break;
			}
		}
		 System.out.println("FirstName name:"+ actualFirstName +"  User name:"+ expUserName+":");
	}
	
	@Test
	void findUniqueSurname() {
		System.out.println("Step-9-how many unique surnames we have in EMPLOYEE BASIC INFORMATION:");
		int totalRows = driver.findElements(By.xpath("//table [@id ='table1']/tbody/tr")).size();
		LinkedHashSet<String> setofuniqueSurname = new LinkedHashSet<String>();
		for (int index=1;index<=totalRows ;index++) {
		String surName = driver.findElement(By.xpath("//table[@id ='table1']/tbody/tr["+index+"]/td[3]")).getText();
		setofuniqueSurname.add(surName);
		}
		System.out.println(setofuniqueSurname);
		int expUniqueSurname = 4;
		int actualUniqueSurname= setofuniqueSurname.size();
		System.out.println(actualUniqueSurname);
		SoftAssert softAssert= new SoftAssert();
		softAssert.assertEquals(actualUniqueSurname,expUniqueSurname);
		softAssert.assertAll();
	}
	
	@Test
	void returnMapOFFirstNameAndUserName() {
		System.out.println("Step-10-return a map of firstname and username");
		int rowCount = driver.findElements(By.xpath("//table[@id ='table1']/tbody/tr")).size();
		HashMap<String,String> hmap = new HashMap<String,String>();
		for(int index=1; index<=rowCount ;index++) {
		String FirsName = driver.findElement(By.xpath("//table[@id ='table1']/tbody/tr["+index+"]/td[2]")).getText();
		String userName = driver.findElement(By.xpath("//table[@id ='table1']/tbody/tr["+index+"]/td[4]")).getText();
		hmap.put(FirsName, userName);
		}
		System.out.println(hmap);
	}
	@Parameters("name")
	@Test
	void containsGivenUsername(String name) {
		System.out.println("Step-11-is table contains emplyee having username as kkanani");
		//String name = "kkanani";
		//int expectedCountOfUserName=1;
		int ActulacountOfUserName = driver.findElements(By.xpath("//table[@id ='table1']/tbody//td[text()='"+name+"']")).size();
		Assert.assertTrue(ActulacountOfUserName==1);
		
	}
				
	@AfterClass
	public void tearDown() {
		driver.close();
	}
}	

/*Assignment - 7 : 23th Oct'2021
1) How many tables are there on the page
-> driver.findElements(By.xpath("//table")).size(); or  driver.findElements(By.tagName("table"));	   driver.findElements(By.xpath("//button")).get(0).click();
2)How many rows are there in EMPLOYEE BASIC INFORMATION-> HW
write a method with return type as "int"
3)how many columns are there in EMPLOYEE BASIC INFORMATION-> HW
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
				Break;
}
}
		if(targetIndex == 0)
			throw new ColNotFoundException("User trying to find colName " + colName + " which is not a part of a table);
		return targetIndex;
   }
6) print all rows->
for(int rowIndex=1;rowIndex<=totalRows;rowIndex++){
	for(int colIndex=1;colIndex<=totalCols;colIndex++){		    soprint(driver.findElement(By.xpath("//table[@id='table1']/tbody/tr["+rowIndex+"]/td["+colIndex+"]")).getText() + " - ");
	}
	soprintln();
}or
	for(int rowIndex=1;rowIndex<=totalRows;rowIndex++){		sop(driver.findElement(By.xpath("//table[@id='table1']/tbody/tr["+rowIndex+"]")).getText());
	}or
//table[@id='table1']
7) print lastname of the employee whoes first name is Abhishekfor(int index=1;index<=totalRows;index++){
	String currentName = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr["+index+"]/td[2]")).getText();
	String output = "";
	if(name.equals(currentName)){
		output = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr["+index+"]/td[3]")).getText();
		break;
	}
}
	return output;
8)print the firstname of the employee whoes username is ppatro-HW 

9)how many unique surnames we have in EMPLOYEE BASIC INFORMATION (4)-HW

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
