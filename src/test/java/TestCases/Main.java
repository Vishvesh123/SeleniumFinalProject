package TestCases;

import Browser.browser;

import Pages.HomePage;
import Pages.SignUpPage;


public class Main {
	public static void main(String arg[]) throws Exception {
		browser.openBrowser();
		browser.navigateURL("Automation Exercise");
	
		HomePage.clickSignUp();
		SignUpPage.enterName("Suresh");
		SignUpPage.enterMail("suresh12@gmail.com");
		SignUpPage.clickButton();
	}
	
}
