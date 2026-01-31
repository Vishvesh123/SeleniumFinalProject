
package TestCases;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.*;

import com.aventstack.extentreports.Status;
import Browser.browser;
import Pages.CheckOutPage;
import Pages.HomePage;
import Pages.LoginPage;

import ScreenShot.capture;

public class Test8 {

	@BeforeClass
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
		browser.logger1=browser.extent.createTest("Login for placing order");
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
		Reporter.log("Test case 8.1 Login Assertion passed");
		}catch(Exception e) {
			System.out.println("Test 8.1 failed"+e);
			browser.logger1.log(Status.FAIL, "Log In Failed");
		}
		browser.extent.flush();
	}

	

	@DataProvider(name="data7")
	public Object[][] data2() throws Exception {
		Object[][] arrobj = {
			{"Automation Exercise", "Suresh Kumar", "1234567890123456", "321", "12", "2028", "Congratulations"}
		};
		return arrobj;
	}

	@Test(dataProvider="data7",priority=2)
	public void placeOrder(String wait, String cardName, String cardNumber, String cvc, String month, String year, String expected) throws Exception {
		
		
		browser.extent.attachReporter(browser.reporter);
		browser.logger1=browser.extent.createTest("Placing Oder");
		browser.logger1.log(Status.INFO, "Checking the Order Placed Message");
		try {
		//Click on View Cart
		CheckOutPage.clickViewCart();
	
		//Click Proceed To Checkout
		CheckOutPage.clickCheckout();
		capture.screenShot("ProceedToCheckout");

		//Click Place Order
		CheckOutPage.clickPlaceOrder();
		capture.screenShot("PlaceOrderClicked");

		// Enter Payment Details
		CheckOutPage.enterPaymentDetails(cardName, cardNumber, cvc, month, year);
		capture.screenShot("PaymentDetailsEntered");

		CheckOutPage.clickPayAndPlaceOrder();
		capture.screenShot("AfterPayment");

		String msg = CheckOutPage.getConfirmationMessage();
		Assert.assertTrue(msg.toLowerCase().contains(expected.toLowerCase()), 
				"Expected confirmation containing '" + expected + "' but got: " + msg);
		browser.logger1.log(Status.PASS, "Order Placed");
		Reporter.log("Test case 8.2: Order placed successfully and confirmation displayed.");
//		HomePage.clickDeleteAccount();
		}catch(Exception e) {
			System.out.println("Test 8.2 failed"+e);
			browser.logger1.log(Status.FAIL, "Order not placed");
		}
		browser.extent.flush();
	}
	
	@DataProvider(name="data8")
	public Object[][] data3() throws Exception {
		Object[][] arrobj = {
			{"ACCOUNT DELETED!"}
		};
		return arrobj;
	}
	@Test(dataProvider="data8",priority=3)
	public void deleteAccount(String verify) {
		browser.extent.attachReporter(browser.reporter);
		browser.logger1=browser.extent.createTest("Deleting Account");
		browser.logger1.log(Status.INFO, "Checking the Account Deleted Message");
		try {
			HomePage.clickDeleteAccount();
			String msg = CheckOutPage.getAccountDeletedMsg();
			Assert.assertEquals(msg, verify);
			browser.logger1.log(Status.PASS, "Account Deleted");
			Reporter.log("Test case 8.3: Account Deleted");
		}catch(Exception e) {
			System.out.println("Test 8.3 failed"+e);
			browser.logger1.log(Status.FAIL, "Account Deletion Failed");
		}
		browser.extent.flush();
	}

	@AfterClass
	public void close() throws Exception {
		browser.closeBrowser();
	}
}







