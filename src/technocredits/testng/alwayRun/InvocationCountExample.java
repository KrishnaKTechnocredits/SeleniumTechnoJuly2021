package technocredits.testng.alwayRun;

import org.testng.annotations.Test;

public class InvocationCountExample {

	@Test(invocationCount=5)
	public void m1() {
		System.out.println("Hi..");
	}
}
