package vivek;

import java.util.TreeMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Assignment08 {

	WebDriver startBrowser(String url) {
		System.setProperty("webdriver.chrome.driver", "./resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
		return driver;
	}

	@Test
	public void employeeByDeptName() throws InterruptedException {
		System.out.println("Open Chrome browser and navigate to automationbykrishna");
		WebDriver driver = startBrowser("http://automationbykrishna.com/");
		System.out.println("Navigate to Demo Tables");
		driver.findElement(By.linkText("Demo Tables")).click();
		Thread.sleep(3000);
		int noOfRows = driver.findElements(By.xpath("//Table[@class='table table-striped']/tbody/tr")).size();
		System.out.println(noOfRows);
		System.out.println("Print count of employee by department name");
		TreeMap<String, Integer> map = new TreeMap<>();
		for (int index = 1; index <= noOfRows; index++) {
			String str = driver
					.findElement(By.xpath("//Table[@class='table table-striped']/tbody/tr[" + index + "]/td[5]"))
					.getText();
			if (map.containsKey(str)) {
				int cnt = map.get(str);
				map.put(str, cnt + 1);
			} else {
				map.put(str, 1);
			}
		}
		System.out.println(map);
	}
}
