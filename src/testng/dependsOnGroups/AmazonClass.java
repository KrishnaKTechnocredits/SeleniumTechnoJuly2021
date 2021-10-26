package testng.dependsOnGroups;

import org.testng.annotations.Test;

public class AmazonClass {

	@Test
	public void login() {
		System.out.println("login");
	}

	@Test
	public void addItemsTobucket() {
		System.out.println("Item Added");
	}

	@Test(dependsOnMethods = { "login", "addItemsTobucket" })
	public void removeItemsFromBucket() {
		System.out.println("Item Removed");
	}

}
