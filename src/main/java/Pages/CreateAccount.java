package Pages;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.ExpectedConditions;

import Browser.browser;
import Locators.CreateAccountLocators;

public class CreateAccount extends browser {
	static CreateAccountLocators obj;
	
	public static String headingText() {
		obj = PageFactory.initElements(driver, CreateAccountLocators.class);
		wait.until(ExpectedConditions.visibilityOf(obj.enterAccountInfoHeading));
		return obj.enterAccountInfoHeading.getText();
	}
	
	public static void selectTitle() {
		obj = PageFactory.initElements(driver, CreateAccountLocators.class);
		obj.titleMr.click();
	}
	
	public static void enterPassword(String pwd) {
		obj.password.sendKeys(pwd);
	}
	
	public static void selectDOB(String day, String month, String year) {
		new Select(obj.days).selectByValue(day);
		new Select(obj.months).selectByValue(month);
		new Select(obj.years).selectByValue(year);
	}
	
	public static void checkBoxes() {
		obj.newsletterCheckbox.click();
		obj.offersCheckbox.click();
	}
	
	public static void enterAddress(String fname,String lname,String comp,String addr1,String addr2,
			String country,String state,String city,String zip,String mobile) {
		
		new Select(obj.country).selectByVisibleText(country);
		obj.firstName.sendKeys(fname);
		obj.lastName.sendKeys(lname);
		obj.company.sendKeys(comp);
		obj.address1.sendKeys(addr1);
		obj.address2.sendKeys(addr2);
		obj.state.sendKeys(state);
		obj.city.sendKeys(city);
		obj.zipcode.sendKeys(zip);
		obj.mobileNumber.sendKeys(mobile);
	}
	
	public static void clickCreateAccount() {
		obj.createAccountButton.click();
	}
	
	public static String accountCreatedMsg() {
		wait.until(ExpectedConditions.visibilityOf(obj.accountCreatedMsg));
		return obj.accountCreatedMsg.getText();
	}
	
	public static void contiue() {
		obj.continueButton.click();
	}
	
}
