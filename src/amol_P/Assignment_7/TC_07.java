package amol_P.Assignment_7;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/*7) print lastname of the employee whoes first name is Abhishek

for(int index=1;index<=totalRows;index++){
	String currentName = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr["+index+"]/td[2]")).getText();
	String output = "";
	if(name.equals(currentName)){
		output = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr["+index+"]/td[3]")).getText();
		break;
	}
}*/

public class TC_07 {
	WebDriver driver;

	@BeforeMethod()
	public void setup() throws InterruptedException {
		driver = PredefineAction.start();

	}

	@Test
	public void getEmployeeWithMatchingName_TC07() {
		String expectedLastName = "asharma";
		String actualLastName = "";
		int rowCount = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size();

		String firstName = "Abhishek";

		for (int index = 1; index <= rowCount; index++) {
			String name = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + index + "]/td[2]")).getText();

			if (name.equals(firstName)) {

				actualLastName = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + index + "]/td[4]"))
						.getText();
				System.out.println("Last name of " + name + " is " + actualLastName);
				break;
			}
		}
		Assert.assertEquals(actualLastName, expectedLastName);

	}
	
	

	@AfterMethod
	public void flush() {
		driver.quit();
	}
}
