package technocredits.testng.alwayRun;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class AmazonClass {

	@Test
	public void login() {
		Assert.fail();
	}

	@Test(dependsOnMethods = "login", alwaysRun = true)
	public void addItemsTobucket() {
		System.out.println("Item Added");
	}

	@Test(dependsOnMethods = { "addItemsTobucket" })
	public void removeItemsFromBucket() {
		System.out.println("Item Removed");
	}

}
