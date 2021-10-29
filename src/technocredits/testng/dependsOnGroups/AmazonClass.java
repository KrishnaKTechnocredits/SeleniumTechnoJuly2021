package technocredits.testng.dependsOnGroups;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AmazonClass {

	@Test
	public void login() {
		Assert.fail();
	}

	@Test()
	public void addItemsTobucket() {
		System.out.println("Item Added");
	}

	@Test(dependsOnMethods = { "addItemsTobucket" })
	public void removeItemsFromBucket() {
		System.out.println("Item Removed");
	}

}
