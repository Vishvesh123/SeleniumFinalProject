package TestCases;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.*;

import com.aventstack.extentreports.Status;

import Browser.browser;
import Pages.HomePage;
import Pages.ProductPage;
import ScreenShot.capture;

public class Test6 {

	@BeforeMethod
	public void openBrowser() {
		browser.openBrowser();
	}

	@DataProvider(name="data5")
	public Object[][] data() throws Exception {
		Object[][] arrobj = {
			{"Automation Exercise", "TSHIRTS", "1500", "Added"}
		};
		return arrobj;
	}

	@Test(dataProvider="data5")
	public void filterProductAndAddToCart(String wait, String product, String price, String expectedText) throws Exception {
		browser.extent.attachReporter(browser.reporter);
		browser.logger1=browser.extent.createTest("Clicking Add to Cart button");
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
			System.out.println("Test 5 failed"+e);
			browser.logger1.log(Status.FAIL, "Product not Added to the cart");
			
		}
		browser.extent.flush();
		
	}

	@AfterMethod
	public void close() throws Exception {
		browser.closeBrowser();
	}
}
