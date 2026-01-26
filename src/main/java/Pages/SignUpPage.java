package Pages;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import Browser.browser;

import Locators.SignUpPageLocators;

public class SignUpPage extends browser{
public static SignUpPageLocators obj;
public static String heading() {
	obj=PageFactory.initElements(driver, SignUpPageLocators.class);
	wait.until(ExpectedConditions.visibilityOf(obj.heading));
    return obj.heading.getText();
}

public static void enterName(String text) {
	obj=PageFactory.initElements(driver, SignUpPageLocators.class);
	obj.name.sendKeys(text);
}

public static void enterMail(String text) {
	obj.email.clear();
	obj.email.sendKeys(text);
}
public static void clickButton() {
	
	obj.button.click();
}


}
