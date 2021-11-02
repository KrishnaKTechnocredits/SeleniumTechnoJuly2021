/*Assignment - 12: 24th Oct'2021
https://datatables.net/extensions/autofill/examples/initialisation/focus.html

Program 1 : Find unique Office location by navigating throw all pages.
URL : https://datatables.net/extensions/autofill/examples/initialisation/focus.html

program 2: print position per employee count by navigating throw all pages.

Program 3: find out the position with highest and lowest employees.

program 4 : sorting works on employee name or not.

program 5 : verfiy sorting works on position.

ArrayList<String> listOfPosition(){

	navigateToFirstPage();
}

void verifySortingOnPosition(){
    ArrayList<String> actualList= listOfPosition();
	Collections.sort(actualList);
	
	ClickOnHeader("Position");
	ArrayList<String> expectedList= listOfPosition();
	
	Assert.assertEquals(actualList, expectedList);
}


try{
	WebElement e = driver.findElement(By.xpath(""));
	if(e.isDisplay())
		return true;
	else
		return false;
}catch(NoSuchElementException ne){
	return false;
}

*/
package bhakti;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Assignment_12 {
	 
	WebDriver driver;
	SoftAssert softAssert ;
	
	@BeforeClass
	void start() throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "./resources/chromedriver.exe");
		System.out.println("Step- Opend chrome browser");
		driver = new ChromeDriver();
		System.out.println("Step- Open URL-https://datatables.net/extensions/autofill/examples/initialisation/focus.html");
		driver.get("https://datatables.net/extensions/autofill/examples/initialisation/focus.html");
		driver.manage().window().maximize();
		Thread.sleep(5000);
		 
	}
	@BeforeMethod
	void startAssert() {
		  softAssert = new SoftAssert();
	}
	@AfterMethod
	void afterAsser() {
		softAssert.assertAll();
		
	}
	
	@AfterClass
	void end() {
		driver.quit();
		
	}
	//Program 1 : Find unique Office location by navigating throw all pages.
	
	@Test (priority =1)
	void getUniqueofficeLocation() {
		System.out.println("Program 1 : Find unique Office location by navigating throw all pages.");
		HashSet<String> officeList= new HashSet();
		int page= driver.findElements(By.xpath("//div/span/a[@class='paginate_button ']")).size()+1;
		//    //span/a[@class='paginate_button current' or @class='paginate_button ']
		for (int j=2; j<=page; j++) {
			int rows=driver.findElements(By.xpath("//table[@id='example']/tbody/tr")).size();
			for (int i=1; i<=rows; i++) {
				String office= driver.findElement(By.xpath("//table[@id='example']/tbody/tr["+i+"]/td[3]")).getText();
				officeList.add(office);
			}
			driver.findElement(By.xpath("//div/span/a [text()='"+j+"']")).click();
		}
		System.out.println(officeList);
		String[] names= {"San Francisco", "New York","Singapore", "Tokyo", "London", "Edinburgh", "Sydney"};
		ArrayList<String> expected= new ArrayList(Arrays.asList(names));
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(officeList, expected);
		softAssert.assertAll();
	}
	//find Map for position : 
	HashMap<String, Integer> getPostionMap(){
		HashMap<String, Integer> positionMap = new HashMap();
		int page= driver.findElements(By.xpath("//span/a[@class='paginate_button current' or @class='paginate_button ']")).size();
		for (int j=2; j<=page; j++) {
			int rows= driver.findElements(By.xpath("//table[@id='example']/tbody/tr")).size();
			for (int i=1; i<= rows;i++) {
				String postion= driver.findElement(By.xpath("//table[@id='example']/tbody/tr["+i+"]/td[2]")).getText();
				if (positionMap.containsKey(postion)) {
					int count=positionMap.get(postion);
					positionMap.put(postion, ++count);
					
				}else {
					positionMap.put(postion, 1);
				}
			}
			driver.findElement(By.xpath("//div/span/a[text()='"+j+"']")).click();
		}
		return positionMap;
	}
	//program 2: print position per employee count by navigating throw all pages.
	@Test (priority =2)
	void findPositionPerEmpCount() {
		System.out.println("program 2: print position per employee count by navigating throw all pages.");
		HashMap <String, Integer> hm= getPostionMap();
		System.out.println(getPostionMap());
		Set<String> actual= hm.keySet();
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(actual.size(), 29);
		softAssert.assertAll();
	}
	//Program 3: find out the position with highest and lowest employees.
	@Test (priority =3)
	void getHighestLowestPostion() {
		System.out.println("Program 3: find out the position with highest and lowest employees.");
		HashMap <String, Integer> hm= getPostionMap();
		int max=0;
		String maxPosition="";
		String lowPosition="";
		int low=200;
		for (Entry<String, Integer> position: hm.entrySet()){
			if (position.getValue()>max) {
				max=position.getValue();
				maxPosition= position.getKey();
			}else if (position.getValue()<low)	{
				low=position.getValue();
				lowPosition= position.getKey();
			}
		}
		System.out.println("Department with lowest emp -"+lowPosition +" "+low);
		System.out.println("Department with Higest emp -"+maxPosition +" "+max);
		String positionLessemp="Data Coordinator";
		String positionMaxEmp="Regional Director";
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(lowPosition, positionLessemp);
		softAssert.assertEquals(maxPosition, positionMaxEmp);
		softAssert.assertAll();
	}
	// to get List of names from table 
	ArrayList<String> getNameList() {
		ArrayList<String> nameList = new ArrayList();
		int page= driver.findElements(By.xpath("//span/a[@class='paginate_button current' or @class='paginate_button ']")).size();
		for (int j=1; j<=page; j++) {
			driver.findElement(By.xpath("//div/span/a[text()='"+j+"']")).click();
			int rows= driver.findElements(By.xpath("//table[@id='example']/tbody/tr")).size();
			for (int i=1; i<= rows;i++) {
				String empName= driver.findElement(By.xpath("//table[@id='example']/tbody/tr["+i+"]/td[1]")).getText();
				nameList.add(empName);
			}	
		}
		return nameList;
	}
	//program 4 : sorting works on employee name or not.
	@Test  (priority =4)
	void checkSortingonEmpName() {
		System.out.println("program 4 : sorting works on employee name or not.");
		ArrayList<String> nameListbefore = new ArrayList();
		nameListbefore= getNameList();
		System.out.println("Orginal List-->" +nameListbefore.size()+" "+nameListbefore);//A-z
		Collections.sort(nameListbefore, Collections.reverseOrder()); //Z-A
		System.out.println("Post Collection sort->"  +nameListbefore.size()+" "+nameListbefore );
		driver.navigate().refresh();
		driver.findElement(By.xpath("//table[@id='example']/thead/tr/th[1]")).click();
		ArrayList<String> nameListAfter= new ArrayList<String>();
		nameListAfter = getNameList();
		System.out.println("Post Name sort      ->" +nameListAfter.size()+"  " +nameListAfter);
		softAssert.assertEquals(nameListbefore, nameListAfter);
		driver.navigate().refresh();
	}
	
	// to get List of position from table 
	ArrayList<String> getPositionList() {
		ArrayList<String> positionList = new ArrayList();
		int page= driver.findElements(By.xpath("//span/a[@class='paginate_button current' or @class='paginate_button ']")).size();
		for (int j=1; j<=page; j++) {
			driver.findElement(By.xpath("//div/span/a[text()='"+j+"']")).click();
			int rows= driver.findElements(By.xpath("//table[@id='example']/tbody/tr")).size();
			for (int i=1; i<= rows;i++) {
				String empName= driver.findElement(By.xpath("//table[@id='example']/tbody/tr["+i+"]/td[2]")).getText();
				positionList.add(empName);
			}	
		}
		return positionList;
	}
	
	//program 5 : verfiy sorting works on position.
	@Test (priority=5)
	void checkSortingWorkOnPosition() {
		System.out.println("//program 5 : verfiy sorting works on position.");
		ArrayList <String> orginalPositionList= new  ArrayList();
		orginalPositionList=getPositionList();
		System.out.println("Orginal list--> "+orginalPositionList.size()+" "+orginalPositionList);
		Collections.sort(orginalPositionList);
		System.out.println("after collection sorting"+orginalPositionList.size()+" "+ orginalPositionList);
		driver.navigate().refresh(); 
		driver.findElement(By.xpath("//table[@id='example']/thead/tr/th[2]")).click();
		ArrayList <String> afterPositionList=new  ArrayList();
		afterPositionList=getPositionList();
		System.out.println("after Position sorting"+afterPositionList.size()+" "+ afterPositionList);
		softAssert.assertEquals(orginalPositionList, afterPositionList);
		driver.navigate().refresh();
		
	}
}
