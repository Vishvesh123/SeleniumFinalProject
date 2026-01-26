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
import Pages.SignUpPage;
import ScreenShot.capture;

public class Test2 {
	@BeforeMethod
	public void openBrowser() {
		browser.openBrowser();
	}
	@DataProvider(name="data2")
	public Object[][] data() throws Exception{
		Object[][] arrobj= {{"Automation Exercise","New User Signup!"}};
		return arrobj;
	}
	@Test(dataProvider="data2")
	public void clickSignUp(String wait,String verification) throws Exception{
		browser.extent.attachReporter(browser.reporter);
		browser.logger1=browser.extent.createTest("Navigate to SignUP");
		browser.logger1.log(Status.INFO, "Checking the SignUp Heading");
		try {
		browser.navigateURL(wait);
		HomePage.clickSignUp();
		
		capture.screenShot("SignUp");
		String text=SignUpPage.heading();
		Assert.assertEquals(text,verification );
		browser.logger1.log(Status.PASS, "SignUp Heading Verified");
		Reporter.log("Testcase 2 Assertion passeed");
		}catch(Exception e) {
			System.out.println("Testcase 2 failed"+e);
			browser.logger1.log(Status.FAIL, "SignUp Heading Not Verified");
			
		}
	browser.extent.flush();
	}
	@AfterMethod
	public void close() throws Exception{
	   browser.closeBrowser();
	}
}
