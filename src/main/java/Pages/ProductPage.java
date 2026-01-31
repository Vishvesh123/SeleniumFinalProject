package Pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import Browser.browser;
import Locators.ProductPageLocators;

public class ProductPage extends browser {

	static ProductPageLocators obj;

	public static void clickProductsLink() {
		obj = PageFactory.initElements(driver, ProductPageLocators.class);
		wait.until(ExpectedConditions.elementToBeClickable(obj.productsLink));
		obj.productsLink.click();
	}

	public static void searchProduct(String productName) {
		obj = PageFactory.initElements(driver, ProductPageLocators.class);
		wait.until(ExpectedConditions.visibilityOf(obj.searchBox));
		obj.searchBox.clear();
		obj.searchBox.sendKeys(productName);
		obj.searchButton.click();
		wait.until(ExpectedConditions.visibilityOfAllElements(obj.productBlocks));
	}

	public static boolean filterAndClickProductByPrice(String price) {
		obj = PageFactory.initElements(driver, ProductPageLocators.class);
		List<WebElement> blocks = obj.productBlocks;
		for (WebElement block : blocks) {
			String blockText = block.getText();
			if (blockText.contains(price)) {
				WebElement viewProduct = block.findElement(
						By.xpath("ancestor::div[@class='col-sm-4']//a[contains(text(),'View Product')]"));
				viewProduct.click();
				wait.until(ExpectedConditions.visibilityOf(obj.addToCartBtn));
				return true;
			}
		}
		return false;
	}

	public static void clickAddToCart() {
		obj.addToCartBtn.click();
	}

	public static String getAddMessage() {
		wait.until(ExpectedConditions.visibilityOf(obj.addedMsg));
		return obj.addedMsg.getText();
	}
	
	public static void clickContinueShop() {
		obj.continueShoping.click();
	}
}
