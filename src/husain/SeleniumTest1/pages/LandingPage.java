package husain.SeleniumTest1.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import husain.base.Prerequisites;

public class LandingPage extends Prerequisites {

	public List<String> signInDropdown() {

		WebElement move = driver.findElement(By.xpath("//div[@class='accountInner']/span[text()='Sign In']"));
		Actions action = new Actions(driver);

		System.out.println("Step - Hover over Sign In link");
		action.moveToElement(move).build().perform();
		List<String> elements = new ArrayList<String>();
		int rowCount = driver.findElements(By.xpath("//div[@class='dropdownAccountNonLoggedIn']/div/ul//li")).size();
		List<WebElement> list = driver.findElements(By.xpath("//div[@class='dropdownAccountNonLoggedIn']/div/ul/li"));

		System.out.println("Step - Get list of options in the Sign In dropdown");

		for (WebElement e : list) {
			
			elements.add(e.getText());
		}

		/*
		 * System.out.println(driver .findElement(By.xpath(
		 * "//div[@class='dropdownAccountNonLoggedIn']/div/ul//li[1]/a")) .getText());
		 * System.out.println(driver .findElement(By.xpath(
		 * "//div[@class='dropdownAccountNonLoggedIn']/div/ul//li[2]/a")) .getText());
		 * System.out.println(driver .findElement(By.xpath(
		 * "//div[@class='dropdownAccountNonLoggedIn']/div/ul//li[3]/a")) .getText());
		 * System.out.println(driver .findElement(By.xpath(
		 * "//div[@class='dropdownAccountNonLoggedIn']/div/ul//li[4]/a")) .getText());
		 */
		return elements;

	}

}
