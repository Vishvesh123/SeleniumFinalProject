package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import Browser.browser;
import Locators.CheckoutPageLocators;

public class CheckOutPage extends browser {
	
	static CheckoutPageLocators obj;
	
	public static void clickViewCart() {
	    obj = PageFactory.initElements(driver, CheckoutPageLocators.class);
	    try {
	        // Wait until the modal with "View Cart" is visible
	        By modalCartLink = By.xpath("//u[normalize-space()='View Cart'] | //a[contains(text(),'View Cart')]");
	        wait.until(ExpectedConditions.visibilityOfElementLocated(modalCartLink));
	        
	        WebElement viewCart = driver.findElement(modalCartLink);
	        
	        // Scroll into view (in case it's hidden below)
	        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", viewCart);
	        
	        // Wait for it to be clickable
	        wait.until(ExpectedConditions.elementToBeClickable(viewCart));
	        
	        // Handle popup overlays if any
	       
	        
	        // Click using JS (more reliable for modal buttons)
	        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", viewCart);
	        System.out.println("Clicked on View Cart successfully");
	        
	    } catch (Exception e) {
	        System.out.println("View Cart link not interactable, retrying via fallback...");
	        try {
	            // Fallback: look for normal View Cart link on page
	            WebElement altViewCart = driver.findElement(By.xpath("//a[contains(text(),'Cart') or @href='/view_cart']"));
	            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", altViewCart);
	        } catch (Exception ex) {
	            System.out.println("Fallback click also failed: " + ex.getMessage());
	        }
	    }
	}

	
	public static void clickCheckout() {
		obj = PageFactory.initElements(driver, CheckoutPageLocators.class);
		wait.until(ExpectedConditions.elementToBeClickable(obj.proceedToCheckoutBtn));
	
		obj.proceedToCheckoutBtn.click();
	}
	
	public static void clickPlaceOrder() {
		obj = PageFactory.initElements(driver, CheckoutPageLocators.class);
		wait.until(ExpectedConditions.elementToBeClickable(obj.placeOrderBtn));
		
		obj.placeOrderBtn.click();
	}
	
	public static void enterPaymentDetails(String name, String card, String cvv, String month, String year) {
		obj = PageFactory.initElements(driver, CheckoutPageLocators.class);
		wait.until(ExpectedConditions.visibilityOf(obj.nameOnCard));
		obj.nameOnCard.sendKeys(name);
		obj.cardNumber.sendKeys(card);
		obj.cvc.sendKeys(cvv);
		obj.expMonth.sendKeys(month);
		obj.expYear.sendKeys(year);
	}
	
	public static void clickPayAndPlaceOrder() {
		obj.payAndConfirmBtn.click();
	}
	
	public static String getConfirmationMessage() {
		wait.until(ExpectedConditions.visibilityOf(obj.confirmationMsg));
		return obj.confirmationMsg.getText();
	}
}

