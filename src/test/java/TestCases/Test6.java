package TestCases;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.*;

import com.aventstack.extentreports.Status;

import Browser.browser;
import Pages.CreateAccount;
import Pages.HomePage;
import Pages.ProductPage;
import Pages.SignUpPage;
import ScreenShot.capture;

public class Test6 {
	
	@BeforeClass
	public void openBrowser() {
		browser.openBrowser();
	}
	
	@DataProvider(name="data4")
	public Object[][] data() throws Exception {
		Object[][] arrobj = { 
			{
				"Automation Exercise", "ACCOUNT CREATED!",
				"Suresh", "suresh2004@gmail.com", "Test@123",
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
		browser.logger1=browser.extent.createTest("Creating Account again for Adding Product to user's cart");
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
			System.out.println("Test 6.1 failed"+e);
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

	@Test(dataProvider="data5")
	public void filterProductAndAddToCart(String wait, String product, String price, String expectedText) throws Exception {
		
		
		browser.extent.attachReporter(browser.reporter);
		browser.logger1=browser.extent.createTest("Clicking Add to Cart button After Creating Account");
		browser.logger1.log(Status.INFO, "Checking the Added Message");
		try {
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
		ProductPage.clickContinueShop();
		HomePage.clickDeleteAccount();
		}catch(Exception e) {
			System.out.println("Test 6.2 failed"+e);
			browser.logger1.log(Status.FAIL, "Product not Added to the cart");
		}
		browser.extent.flush();
	}

	
	@AfterClass
	public void close() throws Exception {
		browser.closeBrowser();
	}
}


