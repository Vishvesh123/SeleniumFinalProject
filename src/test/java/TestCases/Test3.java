package TestCases;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import Browser.browser;
import Pages.CreateAccount;
import Pages.HomePage;
import Pages.SignUpPage;

public class Test3 {
	@BeforeMethod
	public void openBrowser() {
		browser.openBrowser();
	}
	@DataProvider(name="data3")
	public Object[][] data() throws Exception{
		Object[][] arrobj= {{"Automation Exercise","ENTER ACCOUNT INFORMATION","Suresh","suresh0062@gmail.com"}};
		return arrobj;
	}
	@Test(dataProvider="data3")
	public void clickSignUp(String wait,String verification,String name,String mail) {
		browser.extent.attachReporter(browser.reporter);
		browser.logger1=browser.extent.createTest("Clicking signup button");
		browser.logger1.log(Status.INFO, "Checking The Create Account Title");
		try {
			
		browser.navigateURL(wait);
		
		HomePage.clickSignUp();
		SignUpPage.enterName(name);
		SignUpPage.enterMail(mail);
		SignUpPage.clickButton();
		String text=CreateAccount.headingText();
		Assert.assertEquals(text, verification);
		browser.logger1.log(Status.PASS, "Create Account Title Verified");
		Reporter.log("Test case 3 Create Account heading Assertion passed");
		
		}catch(Exception e) {
			System.out.println("Test 3 Failed"+e);
			browser.logger1.log(Status.FAIL, "Create Account Title not Verified");
			
		}
		browser.extent.flush();
	}
	@AfterMethod
	public void close() throws Exception{
	   browser.closeBrowser();
	}

}
