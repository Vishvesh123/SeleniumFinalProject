package Locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignUpPageLocators {
@FindBy(xpath="//*[@id=\"form\"]/div/div/div[3]/div/h2")
public WebElement heading;

@FindBy(xpath="//input[@placeholder='Name']")
public WebElement name;
@FindBy(xpath="//*[@id=\"form\"]/div/div/div[3]/div/form/input[3]")
public WebElement email;

@FindBy(xpath="//*[@id=\"form\"]/div/div/div[3]/div/form/button")
public WebElement button;

}
