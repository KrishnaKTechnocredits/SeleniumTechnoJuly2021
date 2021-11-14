package technocredits.missingLink;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import base.PredefinedActions;

public class BrokenLinks {

	@Test
	public void brokenLink() throws IOException {
		WebDriver driver = PredefinedActions.start(
				"file:///D:/TechnoCredits/Batches/July21/SeleniumTechnoJuly2021/resources/htmlForms/BrokenLink.html");

		List<WebElement> links = driver.findElements(By.tagName("a"));
		for (WebElement element : links) {
			String link = element.getAttribute("href");

			URL url = new URL(link);
			URLConnection utlConnection = url.openConnection();
			HttpURLConnection connection = (HttpURLConnection) utlConnection;
			connection.connect();
			if (connection.getResponseCode() >= 400) {
				System.out.println("Link is not working" + element.getText());
			}
		}
	}
}
