package amol_P.Assignment_7;

import java.util.List;
/*5) return index of given column name
		   ie. lastname -> 3 column index
*/
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC_05 {
	static WebDriver driver;

	@BeforeMethod()
	public void setup() throws InterruptedException {
		driver = PredefineAction.start();

	}

	@Test
	void getIndex() {
		List<WebElement> b = driver.findElements(By.xpath("//table[@id='table1']/thead/tr/th"));
		System.out.println("Total Column size is " + b.size());
		int outputIndex = 0;
		for (int index = 0; index < b.size(); index++) {

			String expected = "Last Name";
			String Actual = b.get(index).getText();
			if (Actual.contains(expected)) {
				outputIndex = index + 1;
				System.out.println(Actual + " Index is : " + outputIndex);
				break;
			}

		}
		Assert.assertEquals(outputIndex, 3);
	}
	@AfterMethod
	public void flush()
	{
		driver.quit();
	}
}
