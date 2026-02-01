package Pages;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.ExpectedConditions;

import Browser.browser;
import Locators.CreateAccountLocators;

public class CreateAccount extends browser {
	static CreateAccountLocators obj;
	
	public static String headingText() {
		try {
		obj = PageFactory.initElements(driver, CreateAccountLocators.class);
		wait.until(ExpectedConditions.visibilityOf(obj.enterAccountInfoHeading));
		return obj.enterAccountInfoHeading.getText();
		}catch(Exception e) {
			System.out.println("CreateAccountPage-headingText "+ e);
		}
		return obj.enterAccountInfoHeading.getText();
	}
	
	public static void selectTitle() {
		try {
		obj = PageFactory.initElements(driver, CreateAccountLocators.class);
		obj.titleMr.click();
		}catch(Exception e) {
			System.out.println("CreateAccountPage-selectTitle "+ e);
		}
	}
	
	public static void enterPassword(String pwd) {
		try {
		obj.password.sendKeys(pwd);
		}catch(Exception e) {
			System.out.println("CreateAccountPage-enterPassword "+ e);
		}
	}
	
	public static void selectDOB(String day, String month, String year) {
		try {
		new Select(obj.days).selectByValue(day);
		new Select(obj.months).selectByValue(month);
		new Select(obj.years).selectByValue(year);
		}catch(Exception e) {
			System.out.println("CreateAccountPage-slectDOB "+ e);
		}
	}
	
	public static void checkBoxes() {
		try {
		obj.newsletterCheckbox.click();
		obj.offersCheckbox.click();
		}catch(Exception e) {
			System.out.println("CreateAccountPage-checkBoxes "+ e);
		}
	}
	
	public static void enterAddress(String fname,String lname,String comp,String addr1,String addr2,
			String country,String state,String city,String zip,String mobile) {
		
		try {
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
		}catch(Exception e) {
			System.out.println("CreateAccountPage-enterAddress "+ e);
		}
	}
	
	public static void clickCreateAccount() {
		try {
		obj.createAccountButton.click();
		}catch(Exception e) {
			System.out.println("CreateAccountPage-clickCreateAccount "+ e);
		}
	}
	
	public static String accountCreatedMsg() {
		try {
		wait.until(ExpectedConditions.visibilityOf(obj.accountCreatedMsg));
		}catch(Exception e) {
			System.out.println("CreateAccountPage-accountCreatedMsg "+ e);
		}
		return obj.accountCreatedMsg.getText();
	}
	
	public static void contiue() {
		try {
		obj.continueButton.click();
		}catch(Exception e) {
			System.out.println("CreateAccountPage-continue "+ e);
		}
	}
	
}
