package Pages;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import Browser.browser;
import Locators.LoginPageLocator;


public class LoginPage extends browser{
	public static LoginPageLocator obj;
	public static void enterMail(String text) {
		obj=PageFactory.initElements(driver, LoginPageLocator.class);
		obj.email.sendKeys(text);
	}
	
	public static void enterPassword(String text) {
		obj=PageFactory.initElements(driver, LoginPageLocator.class);
		obj.password.sendKeys(text);
	}
	public static void clickButton() {
		obj.button.click();
	}
	
    public static String loggedInName() {
		wait.until(ExpectedConditions.visibilityOf(obj.loggedInName));
	    return obj.loggedInName.getText();
	}
}
