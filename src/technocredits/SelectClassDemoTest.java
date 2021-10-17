package technocredits;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import base.PredefinedActions;

public class SelectClassDemoTest {
	
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = PredefinedActions.start("http://automationbykrishna.com");
		System.out.println("STEP - Click Basic Elements Menu");
		//driver.findElement(By.id("basicelements")).click();
		driver.findElement(By.partialLinkText("Basic E")).click();
		
		Thread.sleep(3000);
		WebElement multiSelectDD = driver.findElement(By.xpath("//select[@class='form-control']"));
		try {
			if(multiSelectDD.getAttribute("multiple").equals("true"))
				System.out.println("Its a multi select dropdown");
		}catch(NullPointerException ne) {
			System.out.println("Its not a multi select dropdown");
		}
		
		Select multiSelect = new Select(multiSelectDD);
		
		multiSelect.selectByIndex(0);
		multiSelect.selectByVisibleText("3");
		
		List<WebElement> listOfSelectedOptions = (ArrayList<WebElement>)multiSelect.getAllSelectedOptions();
		System.out.println(listOfSelectedOptions.size());
		for(WebElement e : listOfSelectedOptions) {
			System.out.println(e.getText());
		}
		
		/*List<WebElement> listOfAllOptions = multiSelect.getOptions();
		listOfAllOptions.removeAll(listOfSelectedOptions); //3
		
		multiSelect.deselectAll();
		
		for(WebElement e : listOfAllOptions) {
			multiSelect.selectByVisibleText(e.getText());
		}*/
		
		List<WebElement> listOfAllOptions = multiSelect.getOptions();
		
		for(WebElement e : listOfAllOptions) {
			if(e.isSelected())
				multiSelect.deselectByVisibleText(e.getText());
			else
				multiSelect.selectByVisibleText(e.getText());
		}

		System.out.println(multiSelect.getAllSelectedOptions().size());
		
		List<WebElement> list = multiSelect.getAllSelectedOptions();
		
		driver.close();
	}
}
