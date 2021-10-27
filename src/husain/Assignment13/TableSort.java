/*
 * Assignment-13: 
https://datatables.net/extensions/autofill/examples/initialisation/focus.html

Program : Verify whole table is sorted based on Employee age.
 */
package husain.Assignment13;

import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.PredefinedActions;

public class TableSort {

	WebDriver driver;
	ArrayList<SortData> unsortedList;

	@BeforeMethod
	void setup() {

		driver = PredefinedActions
				.start("https://datatables.net/extensions/autofill/examples/initialisation/focus.html");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	ArrayList<SortData> getTableData() {
		int paginationCount = driver.findElements(By.xpath("//span/a[@aria-controls='example']/following-sibling::a"))
				.size();
		ArrayList<SortData> sortedTable = new ArrayList<SortData>();
		System.out.println("STEP - Fetching table data");
		for (int i = 1; i <= paginationCount + 1; i++) {
			int rowCount = driver.findElements(By.xpath("//table[@id='example']/tbody/tr")).size();
			for (int index = 1; index <= rowCount; index++) {
				String name = driver.findElement(By.xpath("//table[@id='example']/tbody/tr[" + index + "]/td[1]"))
						.getText();
				String position = driver.findElement(By.xpath("//table[@id='example']/tbody/tr[" + index + "]/td[2]"))
						.getText();
				String office = driver.findElement(By.xpath("//table[@id='example']/tbody/tr[" + index + "]/td[3]"))
						.getText();
				String age = driver.findElement(By.xpath("//table[@id='example']/tbody/tr[" + index + "]/td[4]"))
						.getText();
				String startDate = driver.findElement(By.xpath("//table[@id='example']/tbody/tr[" + index + "]/td[5]"))
						.getText();
				String salary = driver.findElement(By.xpath("//table[@id='example']/tbody/tr[" + index + "]/td[6]"))
						.getText();
				sortedTable.add(new SortData(name, position, office, age, startDate, salary));
			}
			if (i != paginationCount + 1)
				driver.findElement(By.xpath("//a[@aria-controls='example']/following-sibling::a[" + i + "]")).click();
		}
		return sortedTable;
	}

	@Test
	void sortingUnsorteddata() {
		System.out.println("STEP - Sorting Unsorted Data");
		unsortedList = getTableData();
		Collections.sort(unsortedList);
	}

	@Test(dependsOnMethods = {"sortingUnsorteddata"})
	void sortedDataList() {
		System.out.println("STEP - Fetching sorted data from table");
		driver.findElement(By.xpath("//table[@id='example']/thead/tr/th[4]")).click();
		boolean flag = false;
		ArrayList<SortData> sortedList = new ArrayList<SortData>();
		sortedList = getTableData();
		System.out.println("STEP - Validating the two sorted lists");
		// Assert.assertEquals(unsortedList, sortedList, "Table sorting is not working
		// correctly");
		for (int index = 0; index < sortedList.size(); index++) {
			if (unsortedList.get(index).name.equals(sortedList.get(index).name)
					&& unsortedList.get(index).position.equals(sortedList.get(index).position)
					&& unsortedList.get(index).age == sortedList.get(index).age
					&& unsortedList.get(index).startDate.equals(sortedList.get(index).startDate)
					&& unsortedList.get(index).salary.equals(sortedList.get(index).salary))
				flag = true;
			else
				flag = false;
		}

		Assert.assertTrue(flag, "Sorted lists do not match");
	}

	@AfterMethod
	void windingDown() {
		driver.close();
	}

}
