package TestCases;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.*;

import com.aventstack.extentreports.Status;

import Browser.browser;
import Pages.CreateAccount;
import Pages.HomePage;
import Pages.SignUpPage;

public class Test4 {
	
	@BeforeMethod
	public void openBrowser() {
		browser.openBrowser();
	}
	
	@DataProvider(name="data4")
	public Object[][] data() throws Exception {
		Object[][] arrobj = { 
			{
				"Automation Exercise", "ACCOUNT CREATED!",
				"Suresh", "suresh03@gmail.com", "Test@123",
				"10", "5", "1990", 
				"Suresh", "Kumar", "MyCompany",
				"123 Main Street", "Building 2", 
				"India", "Maharashtra", "Mumbai",
				"400001", "9876543210"
			}
		};
		return arrobj;
	}
	
	@Test(dataProvider="data4")
	public void createAccount(String wait, String verification, String name, String mail, String pwd,
			String day, String month, String year,
			String fname, String lname, String comp,
			String addr1, String addr2, String country,
			String state, String city, String zip, String mobile) throws Exception {
		
		browser.extent.attachReporter(browser.reporter);
		browser.logger1=browser.extent.createTest("Clicking Create Account button");
		browser.logger1.log(Status.INFO, "Checking the Account Created Message");
		try {
		browser.navigateURL(wait);
		HomePage.clickSignUp();
		
		SignUpPage.enterName(name);
		SignUpPage.enterMail(mail);
		SignUpPage.clickButton();
		
		CreateAccount.selectTitle();
		CreateAccount.enterPassword(pwd);
		CreateAccount.selectDOB(day, month, year);
		CreateAccount.checkBoxes();
		CreateAccount.enterAddress(fname, lname, comp, addr1, addr2, country, state, city, zip, mobile);
		CreateAccount.clickCreateAccount();
	
		String text = CreateAccount.accountCreatedMsg();
		Assert.assertEquals(text, verification);
		browser.logger1.log(Status.PASS, "Account Created");
		Reporter.log("Test case 4 Account Assertion passed");
		}catch(Exception e) {
			System.out.println("Test 4 failed"+e);
			browser.logger1.log(Status.FAIL, "Account not Created");
		}
		browser.extent.flush();
	}
	
	@AfterMethod
	public void close() throws Exception {
		browser.closeBrowser();
	}
}

