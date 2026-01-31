package Pages;


import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import Browser.browser;
import Locators.CheckoutPageLocators;

public class CheckOutPage extends browser {
	
	static CheckoutPageLocators obj;
	
	public static void clickViewCart() {
	    obj = PageFactory.initElements(driver, CheckoutPageLocators.class);
	    wait.until(ExpectedConditions.elementToBeClickable(obj.viewCartLink));
	    obj.viewCartLink.click();
	}

	
	public static void clickCheckout() {
		wait.until(ExpectedConditions.elementToBeClickable(obj.proceedToCheckoutBtn));
	
		obj.proceedToCheckoutBtn.click();
	}
	
	public static void clickPlaceOrder() {
		wait.until(ExpectedConditions.elementToBeClickable(obj.placeOrderBtn));
		
		obj.placeOrderBtn.click();
	}
	
	public static void enterPaymentDetails(String name, String card, String cvv, String month, String year) {
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
	
	public static String getAccountDeletedMsg() {
		wait.until(ExpectedConditions.visibilityOf(obj.accountDeleatedMsg));
		return obj.accountDeleatedMsg.getText();
	}
}

