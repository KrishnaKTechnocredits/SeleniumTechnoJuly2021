package husain.SeleniumTest1.test;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.PredefinedActions;
import husain.SeleniumTest1.pages.LandingPage;
import husain.base.Prerequisites;

public class SignInDropdownTest {

	@BeforeMethod
	public void setup() {

		System.out.println("Step - Navigate to the URL");
		Prerequisites.start("https://www.snapdeal.com/");
	}

	@Test
	public void verifySignInOptions() {
		LandingPage landingPage = new LandingPage();
		List<String> actualList = landingPage.signInDropdown();
		List<String> expectedList = new ArrayList<String>();
		expectedList.add("Your Account");
		expectedList.add("Your Orders");
		expectedList.add("Shortlist");
		expectedList.add("SD Cash");

		System.out.println("Verify the actual List of options from Sign In dropdown matches with the expected List");
		Assert.assertEquals(actualList, expectedList, "The expected and actual list of options does not match");
	}
	
	@AfterMethod
	public void tearDown() {

		Prerequisites.closeBrowser();
	}

}
