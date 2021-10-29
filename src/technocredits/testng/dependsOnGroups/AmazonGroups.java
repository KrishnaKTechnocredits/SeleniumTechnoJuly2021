package technocredits.testng.dependsOnGroups;

import org.testng.annotations.Test;

public class AmazonGroups {

	@Test(groups = "regression")
	public void login() {
		System.out.println("login");
	}

	@Test(groups = "smoke")
	public void addItemsTobucket() {
		System.out.println("Item Added");
	}

	@Test(groups = "smoke")
	public void logout() {
		System.out.println("logout");
	}

}
