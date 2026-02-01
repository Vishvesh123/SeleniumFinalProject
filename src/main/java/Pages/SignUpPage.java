package Pages;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import Browser.browser;

import Locators.SignUpPageLocators;

public class SignUpPage extends browser{
public static SignUpPageLocators obj;
public static String heading() {
	try {
	obj=PageFactory.initElements(driver, SignUpPageLocators.class);
	wait.until(ExpectedConditions.visibilityOf(obj.heading));
	}catch(Exception e) {
		System.out.println("SignUpPage-heading"+ e);
	}
    return obj.heading.getText();
}

public static void enterName(String text) {
	try {
	obj=PageFactory.initElements(driver, SignUpPageLocators.class);
	obj.name.sendKeys(text);
	}catch(Exception e){
		System.out.println("SignUpPage-enterName"+ e);
	}
}

public static void enterMail(String text) {
	try {
	obj.email.clear();
	obj.email.sendKeys(text);
	}catch(Exception e) {
		System.out.println("SignUpPage-enterMail"+ e);
	}
}
public static void clickButton() {
	try {
	obj.button.click();
	}catch(Exception e){
		System.out.println("SignUpPage-clickButton"+ e);
	}
}


}
