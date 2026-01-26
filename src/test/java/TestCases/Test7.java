package TestCases;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.*;

import com.aventstack.extentreports.Status;

import Browser.browser;
import Pages.CheckOutPage;
import Pages.CreateAccount;
import Pages.HomePage;
import Pages.ProductPage;
import Pages.SignUpPage;
import ScreenShot.capture;

public class Test7 {

	@BeforeClass
	public void openBrowser() {
		browser.openBrowser();
	}
	
	@DataProvider(name="data4")
	public Object[][] data2() throws Exception {
		Object[][] arrobj = { 
			{
				"Automation Exercise", "ACCOUNT CREATED!",
				"Suresh", "suresh8074@gmail.com", "Test@123",
				"10", "5", "1990", 
				"Suresh", "Kumar", "MyCompany",
				"123 Main Street", "Building 2", 
				"India", "Maharashtra", "Mumbai",
				"400001", "9876543210"
			}
		};
		return arrobj;
	}
	
	@Test(dataProvider="data4",priority=1)
	public void createAccount(String wait, String verification, String name, String mail, String pwd,
			String day, String month, String year,
			String fname, String lname, String comp,
			String addr1, String addr2, String country,
			String state, String city, String zip, String mobile) throws Exception {
		
		browser.extent.attachReporter(browser.reporter);
		browser.logger1=browser.extent.createTest("Creating Account for Placing Order");
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
		CreateAccount.contiue();
		}catch(Exception e) {
			System.out.println("Test 7.1 failed"+e);
			browser.logger1.log(Status.FAIL, "Account not Created");
		}
		browser.extent.flush();
		
		
	}
	

	@DataProvider(name="data5")
	public Object[][] data1() throws Exception {
		Object[][] arrobj = {
			{"Automation Exercise", "TSHIRTS", "1500", "Added"}
		};
		return arrobj;
	}

	@Test(dataProvider="data5", priority=2)
	public void filterProductAndAddToCart(String wait, String product, String price, String expectedText) throws Exception {
		browser.extent.attachReporter(browser.reporter);
		browser.logger1=browser.extent.createTest("Adding to Cart for placing order");
		browser.logger1.log(Status.INFO, "Checking the Added Message");
		try {
		browser.navigateURL(wait);
	
		HomePage.clickProduct();
		
		ProductPage.searchProduct(product);

		boolean found = ProductPage.filterAndClickProductByPrice(price);
		Assert.assertTrue(found, "No product found with price: " + price);
		
		ProductPage.clickAddToCart();
		capture.screenShot("AddToCart");

		String msg = ProductPage.getAddMessage();
		Assert.assertTrue(msg.toLowerCase().contains(expectedText.toLowerCase()));
		browser.logger1.log(Status.PASS, "Product Added to the cart");
		Reporter.log("Test case 5: Product with price " + price + " added to cart successfully.");
		}catch(Exception e) {
			System.out.println("Test 7.2 failed"+e);
			browser.logger1.log(Status.FAIL, "Product not Added to the cart");
		}
		browser.extent.flush();
	}


	@DataProvider(name="data7")
	public Object[][] data() throws Exception {
		Object[][] arrobj = {
			{"Automation Exercise", "Suresh Kumar", "1234567890123456", "321", "12", "2028", "Congratulations"}
		};
		return arrobj;
	}

	@Test(dataProvider="data7",priority=3)
	public void placeOrder(String wait, String cardName, String cardNumber, String cvc, String month, String year, String expected) throws Exception {
		
		
		browser.extent.attachReporter(browser.reporter);
		browser.logger1=browser.extent.createTest("Placing Oder");
		browser.logger1.log(Status.INFO, "Checking the Order Placed Message");
		try {
		// 1. Click on View Cart
		CheckOutPage.clickViewCart();
	
		// 2. Click Proceed To Checkout
		CheckOutPage.clickCheckout();
		//capture.screenShot("ProceedToCheckout");

		// 3. Click Place Order
		CheckOutPage.clickPlaceOrder();
		//capture.screenShot("PlaceOrderClicked");

		// 4. Enter Payment Details
		CheckOutPage.enterPaymentDetails(cardName, cardNumber, cvc, month, year);
		//capture.screenShot("PaymentDetailsEntered");

		// 5. Click Pay and Confirm Order
		CheckOutPage.clickPayAndPlaceOrder();
		//capture.screenShot("AfterPayment");

		// 6. Assert confirmation message
		String msg = CheckOutPage.getConfirmationMessage();
		Assert.assertTrue(msg.toLowerCase().contains(expected.toLowerCase()), 
				"Expected confirmation containing '" + expected + "' but got: " + msg);
		browser.logger1.log(Status.PASS, "Order Placed");
		Reporter.log("Test case 6: Order placed successfully and confirmation displayed.");
		HomePage.clickDeleteAccount();
		}catch(Exception e) {
			System.out.println("Test 7.3 failed"+e);
			browser.logger1.log(Status.FAIL, "Order not placed");
		}
		browser.extent.flush();
	}

	@AfterClass
	public void close() throws Exception {
		browser.closeBrowser();
	}
}

