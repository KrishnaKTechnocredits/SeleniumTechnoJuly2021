package technocredits.screenShotCode;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import base.PredefinedActions;

public class CapatureScreenShot {

	WebDriver driver;

	@Test
	public void capatureScreenShot() throws Exception {
		driver = PredefinedActions.start();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.id("registration2")).click();
		Assert.fail();
	}

	@AfterMethod
	public void afterMethod(ITestResult result) throws IOException {
		if (result.getStatus() == ITestResult.FAILURE) {
			TakesScreenshot ts = (TakesScreenshot) driver;
//			String file = ts.getScreenshotAs(OutputType.BASE64);
//			byte[] file = ts.getScreenshotAs(OutputType.BYTES);
			File file = ts.getScreenshotAs(OutputType.FILE);
			String methodName = result.getMethod().getMethodName();
			long miliSec = System.currentTimeMillis();
			System.out.println(miliSec);
			Date date = new Date(miliSec);
			//M - month
			//m - min
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("ss_mm_HH_dd_MM_yyyy");
			String timeStamp = simpleDateFormat.format(date);
			FileUtils.copyFile(file, new File("./" + methodName + timeStamp + ".jpeg"));
		}
		driver.quit();
	}

	public static void main(String[] args) {
		long miliSec = System.currentTimeMillis();
		System.out.println(miliSec);
		Date date = new Date(miliSec);
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMM dd HH:mm:ss");
		String timeStamp = simpleDateFormat.format(date);
		System.out.println(timeStamp);
	}
}
