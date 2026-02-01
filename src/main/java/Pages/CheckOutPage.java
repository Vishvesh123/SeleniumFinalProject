package Pages;


import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import Browser.browser;
import Locators.CheckoutPageLocators;

public class CheckOutPage extends browser {
	
	static CheckoutPageLocators obj;
	
	public static void clickViewCart() {
		try {
	    obj = PageFactory.initElements(driver, CheckoutPageLocators.class);
	    wait.until(ExpectedConditions.elementToBeClickable(obj.viewCartLink));
	    obj.viewCartLink.click();
		}catch(Exception e) {
			System.out.println("CheckOutPage- clickViewCart "+ e);
		}
	}

	
	public static void clickCheckout() {
		try {
		wait.until(ExpectedConditions.elementToBeClickable(obj.proceedToCheckoutBtn));
	
		obj.proceedToCheckoutBtn.click();
		}catch(Exception e) {
			System.out.println("CheckOutPage- clickCheckout "+ e);
		}
	}
	
	public static void clickPlaceOrder() {
		try {
		wait.until(ExpectedConditions.elementToBeClickable(obj.placeOrderBtn));
		
		obj.placeOrderBtn.click();
		}catch(Exception e) {
			System.out.println("CheckOutPage- clickPlaceOrder "+ e);
		}
	}
	
	public static void enterPaymentDetails(String name, String card, String cvv, String month, String year) {
		try {
		wait.until(ExpectedConditions.visibilityOf(obj.nameOnCard));
		obj.nameOnCard.sendKeys(name);
		obj.cardNumber.sendKeys(card);
		obj.cvc.sendKeys(cvv);
		obj.expMonth.sendKeys(month);
		obj.expYear.sendKeys(year);
		}catch(Exception e) {
			System.out.println("CheckOutPage- enterPaymentDetails "+ e);
		}
	}
	
	public static void clickPayAndPlaceOrder() {
		try {
		obj.payAndConfirmBtn.click();
		}catch(Exception e) {
			System.out.println("CheckOutPage- clickPayAndPlaceOrder "+ e);
		}
	}
	
	public static String getConfirmationMessage() {
		try {
		wait.until(ExpectedConditions.visibilityOf(obj.confirmationMsg));
		}catch(Exception e) {
			System.out.println("CheckOutPage- getConfirmationMessage "+ e);
		}
		return obj.confirmationMsg.getText();
	}
	
	public static String getAccountDeletedMsg() {
		try {
		wait.until(ExpectedConditions.visibilityOf(obj.accountDeleatedMsg));
		}catch(Exception e) {
			System.out.println("CheckOutPage- getAccountDeletedMsg "+ e);
		}
		return obj.accountDeleatedMsg.getText();
	}
}

