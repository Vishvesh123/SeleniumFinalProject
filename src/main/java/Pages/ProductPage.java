package Pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import Browser.browser;
import Locators.ProductPageLocators;

public class ProductPage extends browser {

	static ProductPageLocators obj;
	
	public static void searchProduct(String productName){
		try {
		obj = PageFactory.initElements(driver, ProductPageLocators.class);
		wait.until(ExpectedConditions.visibilityOf(obj.searchBox));
		obj.searchBox.clear();
		obj.searchBox.sendKeys(productName);
		obj.searchButton.click();
		wait.until(ExpectedConditions.visibilityOfAllElements(obj.productBlocks));
		}catch(Exception e) {
			System.out.println("ProductPage-searchProduct "+ e);
		}
	}
	public static boolean filterAndClickProductByPrice(String price) {
	  
		try {
	    List<WebElement> blocks = obj.productBlocks;
	    for (WebElement block : blocks) {
	        String blockText = block.getText();
	        if (blockText.contains(price)) {
	            WebElement viewProduct = block.findElement(
	                    By.xpath("ancestor::div[@class='col-sm-4']//a[contains(text(),'View Product')]"));
	            
	            // Scroll the element into view and click using JavaScript
	            ((JavascriptExecutor) driver).executeScript(
	                "arguments[0].scrollIntoView({block: 'center'}); arguments[0].click();", 
	                viewProduct
	            );
	            
	            wait.until(ExpectedConditions.visibilityOf(obj.addToCartBtn));
	            return true;
	        }
	    }
		}catch(Exception e) {
			System.out.println("ProductPage- filterAndClickProductByPrice "+ e);
		}
	    return false;
	}
	public static void clickAddToCart() {
		try {
		obj.addToCartBtn.click();
		}catch(Exception e) {
			System.out.println("ProductPage- clickAddToCart "+ e);
		}
	}

	public static String getAddMessage() {
		try{
		wait.until(ExpectedConditions.visibilityOf(obj.addedMsg));
		}catch(Exception e) {
			System.out.println("ProductPage- getAddMessage "+ e);
		}
		return obj.addedMsg.getText();
	}
	
	public static void clickContinueShop() {
		try {
		obj.continueShoping.click();
		}catch(Exception e) {
			System.out.println("ProductPage- clickContinueShop "+ e);
		}
	}
}
