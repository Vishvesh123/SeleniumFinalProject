package Pages;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import Browser.browser;
import Locators.LoginPageLocator;


public class LoginPage extends browser{
	public static LoginPageLocator obj;
	public static void enterMail(String text) {
		try {
		obj=PageFactory.initElements(driver, LoginPageLocator.class);
		obj.email.sendKeys(text);
		}catch(Exception e) {
			System.out.println("LoginPage-enterMail "+ e);
		}
	}
	
	public static void enterPassword(String text) {
		try {
		obj.password.sendKeys(text);
		}catch(Exception e) {
			System.out.println("LoginPage-enterPassword "+ e);
		}
	}
	public static void clickButton() {
		try {
		obj.button.click();
		}catch(Exception e) {
			System.out.println("LoginPage-clickbutton"+ e);
		}
	}
	
    public static String loggedInName() {
    	try {
		wait.until(ExpectedConditions.visibilityOf(obj.loggedInName));
    	}catch(Exception e) {
    		System.out.println("LoginPage-loggedInName "+ e);
    	}
	    return obj.loggedInName.getText();
	}
}
