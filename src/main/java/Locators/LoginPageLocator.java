package Locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPageLocator {

	@FindBy(xpath="//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[10]/a/b")
	public WebElement loggedInName;	
	
	@FindBy(xpath="//*[@id=\"form\"]/div/div/div[1]/div/form/input[2]")
	public WebElement email;

	@FindBy(xpath="//input[@placeholder='Password']")
	public WebElement password;

	@FindBy(xpath="//*[@id=\"form\"]/div/div/div[1]/div/form/button")
	public WebElement button;

}

