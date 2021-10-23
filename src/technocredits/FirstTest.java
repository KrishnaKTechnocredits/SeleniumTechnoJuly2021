package technocredits;

import org.testng.Assert;
import org.testng.annotations.Test;

public class FirstTest {

	@Test
	public void firstTest() {
		System.out.println("First Test");
		String expectedMessage = "Success!";
		String actualMessage = "Failed";
		Assert.assertEquals(actualMessage, expectedMessage, "Login Page Alter message should be Success!, we found " + actualMessage);
		System.out.println("End");
	}
	
	@Test
	public void secondTest() {
		System.out.println("Second Test");
		String expectedMessage = "Failed";
		String actualMessage = "Failed";
		Assert.assertEquals(actualMessage, expectedMessage);
	}
}
