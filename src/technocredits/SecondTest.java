package technocredits;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SecondTest {

	@BeforeMethod
	public void beforeMethod() {
		System.out.println(1);
	}
	
	@AfterMethod
	public void afterMethod() {
		System.out.println(2);
	}
	
	@BeforeClass
	public void beforeClass() {
		System.out.println(3);
	}
	
	@AfterClass
	public void afterClass() {
		System.out.println(4);
	}
	
	@Test
	public void m1() {
		System.out.println(5);
	}
	
	@Test
	public void m2() {
		System.out.println(6);
	}
}
