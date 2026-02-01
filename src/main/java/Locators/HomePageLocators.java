package Locators;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePageLocators {
	
@FindBy(xpath="//div[@class='logo pull-left']/a/img")
public WebElement logo;
@FindBy(css = "a[href='/login']")
public WebElement signUpLink;
@FindBy(css = "a[href='/products']")
public WebElement productLink;

//Delete Account link visible in header after login
	@FindBy(xpath = "//a[normalize-space()='Delete Account']")
	public WebElement deleteAccountLink;

	// Confirmation message after deletion
	@FindBy(xpath = "//b[normalize-space()='Account Deleted!']")
	public WebElement accountDeletedMessage;
}
