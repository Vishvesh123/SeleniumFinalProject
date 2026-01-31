package TestCases;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.*;

import com.aventstack.extentreports.Status;

import Browser.browser;

import Pages.HomePage;
import Pages.LoginPage;


public class Test5 {
	
	@BeforeMethod
	public void openBrowser() {
		browser.openBrowser();
	}
	
	@DataProvider(name="data5")
	public Object[][] data() throws Exception {
		Object[][] arrobj = { 
			{
				"Automation Exercise", "Suresh",
				"suresh03@gmail.com", "Test@123",
			}
		};
		return arrobj;
	}
	
	@Test(dataProvider="data5")
	public void login(String wait, String verification,String mail, String pwd) throws Exception {
		
		browser.extent.attachReporter(browser.reporter);
		browser.logger1=browser.extent.createTest("Clicking Login Button");
		browser.logger1.log(Status.INFO, "Checking the Name as logged In");
		try {
		browser.navigateURL(wait);
		HomePage.clickSignUp();
		
	    LoginPage.enterMail(mail);
		LoginPage.enterPassword(pwd);
		LoginPage.clickButton();
		
		String name = LoginPage.loggedInName();
		System.out.print(name);
		Assert.assertEquals(name, verification);
		browser.logger1.log(Status.PASS, "Log In Success");
		Reporter.log("Test case 5 Login Assertion passed");
		}catch(Exception e) {
			System.out.println("Test 5 failed"+e);
			browser.logger1.log(Status.FAIL, "Log In Failed");
		}
		browser.extent.flush();
	}
	
	@AfterMethod
	public void close() throws Exception {
		browser.closeBrowser();
	}
}
