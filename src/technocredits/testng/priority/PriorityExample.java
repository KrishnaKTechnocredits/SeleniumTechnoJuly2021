package technocredits.testng.priority;

import org.testng.annotations.Test;

public class PriorityExample {

	@Test(priority=-1)
	public void enter_pws() {
		System.out.println("pwd");
	}
	
	@Test(priority=0)
	public void enter_userName() {
		System.out.println("user_name");
	}

	@Test(priority=1)
	public void addItems() {
		System.out.println("Added Bucket");
	}

	@Test(priority=2)
	public void logout() {
		System.out.println("Logout");
	}

}
