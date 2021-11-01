package amolVyas;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import amolVyas.Assignment_5.Action;
import net.bytebuddy.implementation.bytecode.ByteCodeAppender.Size;

public class Assignment_10 {
	WebDriver driver;

	@BeforeClass
	void start() {
		driver = Action.start();
		System.out.println("STEP-Navigate to Demo Tables");
		driver.findElement(By.xpath("//a[text()='Demo Tables']")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	void getCountOfEmpForEachManager() {
		Map<String, Integer> map = new HashMap();
		int totalRow = driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr")).size();
		for (int index = 1; index <= totalRow; index++) {
			String managerId = driver
					.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr[" + index + "]/td[4]"))
					.getText();
			if (map.containsKey(managerId)) {
				int count = map.get(managerId);
				map.put(managerId, ++count);

			} else
				map.put(managerId, 1);
		}
		System.out.println("Count of Emp with respective to Manager" + map);
	}

	@Test
	void listOfEmpForEachManager() {
		Map<String, ArrayList<String>> map = new HashMap();
		int totalRow = driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr")).size();
		for (int index = 1; index <= totalRow; index++) {
			String managerId = driver
					.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr[" + index + "]/td[4]"))
					.getText();
			String empName = driver
					.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr[" + index + "]/td[3]"))
					.getText();
			if (map.containsKey(managerId)) {
				ArrayList<String> name = map.get(managerId);
				name.add(empName);
				map.put(managerId, name);

			} else {
				ArrayList<String> name = new ArrayList();
				name.add(empName);
				map.put(managerId, name);
			}
		}
		System.out.println("Manager ID and thier Emp" + map);

	}

	@AfterClass
	void tearDown() {
		driver.close();
	}

}
