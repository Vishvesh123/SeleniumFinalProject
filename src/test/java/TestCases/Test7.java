package TestCases;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.*;

import com.aventstack.extentreports.Status;

import Browser.browser;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.ProductPage;
import ScreenShot.capture;

public class Test7 {
	
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
	
	@Test(dataProvider="data5", priority=1)
	public void login(String wait, String verification,String mail, String pwd) throws Exception {
		
		browser.extent.attachReporter(browser.reporter);
		browser.logger1=browser.extent.createTest("Login to add product on cart");
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
	
	@DataProvider(name="data6")
	public Object[][] data1() throws Exception {
		Object[][] arrobj = {
			{"Automation Exercise", "TSHIRTS", "1500", "Added"}
		};
		return arrobj;
	}

	@Test(dataProvider="data6" ,priority=2)
	public void filterProductAndAddToCart(String wait, String product, String price, String expectedText) throws Exception {
		browser.extent.attachReporter(browser.reporter);
		browser.logger1=browser.extent.createTest("Clicking Add to Cart button After Login");
		browser.logger1.log(Status.INFO, "Checking the Added Message");
		try {
//		//browser.navigateURL(wait);
//		Thread.sleep(2000);
//		browser.handlePopup();
//		Thread.sleep(3000);
		HomePage.clickProduct();
		
		ProductPage.searchProduct(product);

		boolean found = ProductPage.filterAndClickProductByPrice(price);
		Assert.assertTrue(found, "No product found with price: " + price);
		
		ProductPage.clickAddToCart();
		capture.screenShot("AddToCart");

		String msg = ProductPage.getAddMessage();
		Assert.assertTrue(msg.toLowerCase().contains(expectedText.toLowerCase()));
		browser.logger1.log(Status.PASS, "Product Added to the cart after login");
		Reporter.log("Test case 5: Product with price " + price + " added to cart successfully.");
		}catch(Exception e) {
			System.out.println("Test 5 failed"+e);
			browser.logger1.log(Status.FAIL, "Product not Added to the cart after login");
		}
		browser.extent.flush();
		
	}

	
	@AfterClass
	public void close() throws Exception {
		browser.closeBrowser();
	}
}
