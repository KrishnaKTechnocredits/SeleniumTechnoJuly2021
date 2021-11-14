package technocredits.missingLink;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import base.PredefinedActions;

public class MissingLinks {

	@Test
	public void missingLink() {
		WebDriver driver = PredefinedActions.start(
				"file:///D:/TechnoCredits/Batches/July21/SeleniumTechnoJuly2021/resources/htmlForms/MissingLinks.html");

		List<WebElement> list = driver.findElements(By.xpath("//a"));

		for (WebElement element : list) {
			String link = element.getAttribute("href");
			if (link == null) {
				System.out.println("href is missing: " + element.getText());
			} else if (link.isEmpty()) {
				System.out.println("Missing Link : " + element.getText());
			}
		}
	}
}
