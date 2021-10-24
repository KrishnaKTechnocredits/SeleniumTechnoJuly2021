package amrutaM;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.PredefinedActions;

public class WebElementAssignment {
	WebDriver driver;

	@BeforeClass
	public void beforeClass() {
		driver = PredefinedActions.start();
		driver.findElement(By.xpath("//a[text()='Demo Tables']")).click();
	}

	// 1) How many tables are there on the page
	@Test
	public void getTotalTables() {
		System.out.println("Total tables are --> " + driver.findElements(By.xpath("//table")).size());
		System.out.println("***************************************");
	}

	// 2) How many rows are there in EMPLOYEE BASIC INFORMATION
	@Test
	public void getRowCount() {
		System.out.println(
				"Total rows are --> " + driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size());
		System.out.println("***************************************");
	}

	// 3) how many columns are there in EMPLOYEE BASIC INFORMATION
	@Test
	public void getTotalColumns() {
		System.out.println(
				"Total columns are --> " + driver.findElements(By.xpath("//table[@id='table1']/thead/tr/th")).size());
		System.out.println("***************************************");
	}

	// 4) return first name of all the employees
	@Test
	public void getAllEmployeeNames() {
		System.out.println("First Name of all employees are displayed below: ");
		List<WebElement> fNames = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr/td[2]"));
		for (int index = 1; index < fNames.size(); index++) {
			System.out.println(fNames.get(index).getText());
		}
		System.out.println("***************************************");
	}

	// 5) return index of given column name
	@Test
	public void getColumnIndex() {
		String name = "Last Name";
		int col = driver.findElements(By.xpath("//table[@id='table1']/thead/tr/th")).size();
		for (int i = 1; i <= col; i++) {
			String currentName = driver.findElement(By.xpath("//table[@id='table1']/thead/tr/th[" + i + "]")).getText();
			if (name.equals(currentName))
				System.out.println(i + " is index of " + name);
		}
		System.out.println("***************************************");
	}

	// 6) print all rows
	@Test
	public void printAllRows() {
		int totalRows = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size();
		for (int rowIndex = 1; rowIndex <= totalRows; rowIndex++) {
			System.out.println("Row data is  --> "
					+ driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + rowIndex + "]")).getText());
		}
		System.out.println("***************************************");
	}

	// 7) print lastname of the employee whose first name is Abhishek
	@Test
	public void getCorrespondingLastName() {
		String name = "Abhishek";
		/*System.out.println("Last name of the Employess whose first name is " + name + " : " + driver.findElement(
				By.xpath("//table[@id='table1']/tbody/tr/td[contains(text(),\"" + name + "\")]/following-sibling::td[1]")).getText());*/
		for(int index=1;index<=4;index++){
			String currentName = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr["+index+"]/td[2]")).getText();
			String output = "";
			if(name.equals(currentName)){
				output = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr["+index+"]/td[3]")).getText();
				System.out.println("output -----> "+output);
				break;
			}
		}
		//return output;
		System.out.println("***************************************");
	}
	
	// 8) print the firstname of the employee whose username is ppatro
	@Test
	public void printFirstName() {
		String username = "ppatro";
		System.out.println("First name of the employee with username as pptro is : "+driver.findElement(By.xpath("//table[@id='table1']/tbody/tr/td[contains(text(),\""+username+"\")]/preceding-sibling::td[2]")).getText());
		System.out.println("***************************************");
	}
	
	// 9) how many unique surnames we have in EMPLOYEE BASIC INFORMATION (4)
	@Test
	public void getUniqueSurnames() {
		HashSet<String> uniqueSurnames = new HashSet<String>();
		List<WebElement> surnames = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr/td[3]"));
		for(WebElement surname:surnames) {
			
			uniqueSurnames.add(surname.getText());
		}
		System.out.println("Unique surnames are --> "+uniqueSurnames);
		System.out.println("***************************************");
	}
	
	// 10) return a map of firstname and username.
	@Test
	public void getMap() {
		HashMap<String, String> usersMap = new HashMap<>();
		//List<WebElement> firstName = 
		for(int index=1;index<=4;index++){
			String username = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr["+index+"]/td[4]")).getText();
			String firstName =driver.findElement(By.xpath("//table[@id='table1']/tbody/tr["+index+"]/td[2]")).getText(); 
			usersMap.put(username, firstName);
		}
		System.out.println("Users map of firstname and username : "+usersMap);
	}

	@AfterClass
	public void tearDown() {
		driver.close();
	}
}
