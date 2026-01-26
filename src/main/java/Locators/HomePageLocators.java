package Locators;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePageLocators {
	
@FindBy(xpath="//div[@class='logo pull-left']/a/img")
public WebElement logo;
@FindBy(xpath="//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a")
public WebElement signUpLink;
@FindBy(xpath="//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[2]/a")
public WebElement productLink;

//Delete Account link visible in header after login
	@FindBy(xpath = "//a[normalize-space()='Delete Account']")
	public WebElement deleteAccountLink;

	// Confirmation message after deletion
	@FindBy(xpath = "//b[normalize-space()='Account Deleted!']")
	public WebElement accountDeletedMessage;
}
