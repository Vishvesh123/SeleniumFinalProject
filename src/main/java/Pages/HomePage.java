package Pages;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import Browser.browser;
import Locators.HomePageLocators;

public class HomePage  extends browser  {
	static HomePageLocators obj;
public static String title(){
	return driver.getTitle();
}

public static void clickProduct() {
	obj=PageFactory.initElements(driver, HomePageLocators.class);
	
	obj.productLink.click();
}


public static void clickSignUp() {
	   
	try {
		obj=PageFactory.initElements(driver, HomePageLocators.class);
		//obj=new Page1Object();
		wait.until(ExpectedConditions.visibilityOf(obj.logo));
		obj.signUpLink.click();
	}catch(Exception e) {
		System.out.println("HomePage-clickSignUp"+ e);
	}
}
public static void clickDeleteAccount() {
	obj = PageFactory.initElements(driver, HomePageLocators.class);
	wait.until(ExpectedConditions.elementToBeClickable(obj.deleteAccountLink));
	
	// close any ad overlay if present
	
	obj.deleteAccountLink.click();
}

public static String getDeleteConfirmation() {
	obj = PageFactory.initElements(driver, HomePageLocators.class);
	wait.until(ExpectedConditions.visibilityOf(obj.accountDeletedMessage));
	return obj.accountDeletedMessage.getText();
}

}
