package manaswi;
import java.util.LinkedHashMap;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/*Return a map of Deptname and count of employee within each deptment.
o/p : 7001-Admin -> 2
      7002-Finance -> 2
	  7003-HR -> 2
	  7013-IT -> 3*/

public class Assignment_8 
{

	LinkedHashMap<String, Integer> getMap() throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
		System.out.println("STEP : Launch browser");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://automationbykrishna.com/#");

		System.out.println("STEP : Navigate to Demo tables");
		driver.findElement(By.linkText("Demo Tables")).click();

		Thread.sleep(3000);

		System.out.println("STEP : Get Department name and count of employee within each department");
		int totalRows = driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr")).size();
		String DeptName;
		LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
		for (int index = 1; index <= totalRows; index++) 
		{
			DeptName = driver
					.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr[" + index + "]/td[5]"))
					.getText();

			if (map.containsKey(DeptName))
				map.put(DeptName, map.get(DeptName) + 1);
			else
				map.put(DeptName, 1);
		}
		driver.close();
		return map;
	}

	public static void main(String[] args) throws InterruptedException
	{
		System.out.println(new Assignment_8().getMap());
	}
}
