package technocredits.testng.alwayRun;

import org.openqa.selenium.NoSuchElementException;
import org.testng.annotations.Test;

public class ExpectedExceptionExample {

	@Test(expectedExceptions=Exception.class)
	public void m1() {
		throw new NoSuchElementException("");
	}
}
