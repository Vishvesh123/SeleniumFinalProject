package TestCases;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import Browser.browser;
import Pages.HomePage;
import ScreenShot.capture;

public class Test1 {
@BeforeMethod
public void openBrowser() {
	
	browser.openBrowser();
}
@DataProvider(name="data1")
public Object[][] data() throws Exception{
	Object[][] arrobj= {{"Automation Exercise","Exercise"}};
	return arrobj;
}
@Test(dataProvider="data1")
public void Navigate(String wait,String verification) throws Exception{
	browser.extent.attachReporter(browser.reporter);
	browser.logger1=browser.extent.createTest("Navigate to The URL");
	browser.logger1.log(Status.INFO, "Checking The Title");
	try {
	browser.navigateURL(wait);
	capture.screenShot("Navigate");
	boolean condition=HomePage.title().contains(verification);
	Assert.assertTrue(condition);
	browser.logger1.log(Status.PASS, "Title Verified");
	Reporter.log("Testcase 1 Title Asssertion pass");
	}catch(Exception e) {
		browser.logger1.log(Status.FAIL, "Title Verification Failed");
	}
	browser.extent.flush();
}
@AfterMethod
public void close() throws Exception{
   browser.closeBrowser();
}

}
