package Pages;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import Browser.browser;
import Browser.popupHandler;
import Locators.HomePageLocators;

public class HomePage  extends browser  {
	static HomePageLocators obj;
public static String title(){
	return driver.getTitle();
}

public static void clickProduct() {
	try {
	obj=PageFactory.initElements(driver, HomePageLocators.class);
	obj.productLink.click();
	popupHandler.handlePopup();
	}catch(Exception e) {
		System.out.println("Home Page-Click Product " +e);
	}
}


public static void clickSignUp() {
	   
	try {
		obj=PageFactory.initElements(driver, HomePageLocators.class);
		wait.until(ExpectedConditions.visibilityOf(obj.logo));
		obj.signUpLink.click();
	}catch(Exception e) {
		System.out.println("HomePage-clickSignUp"+ e);
	}
}
public static void clickDeleteAccount() {
	try {
	obj = PageFactory.initElements(driver, HomePageLocators.class);
	wait.until(ExpectedConditions.elementToBeClickable(obj.deleteAccountLink));
	obj.deleteAccountLink.click();
	}catch(Exception e) {
		System.out.println("HomePage-clickDeleteAccount"+ e);
	}
}

public static String getDeleteConfirmation() {
	try {
	wait.until(ExpectedConditions.visibilityOf(obj.accountDeletedMessage));
	
	}catch(Exception e){
		System.out.println("HomePage-getDeleteConfirmation"+ e);
	}
	return obj.accountDeletedMessage.getText();
}

}
