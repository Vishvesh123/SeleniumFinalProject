package Locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class CreateAccountLocators {

    // Heading "Enter Account Information"
    @FindBy(xpath = "//*[@id=\"form\"]/div/div/div/div/h2/b")
    public WebElement enterAccountInfoHeading;

    // Title radio buttons: Mr / Mrs
    @FindBy(xpath = "//input[@id='id_gender1']")
    public WebElement titleMr;

    @FindBy(xpath = "//input[@id='id_gender2']")
    public WebElement titleMrs;

    // Password
    @FindBy(xpath = "//input[@id='password']")
    public WebElement password;

    // Date of birth selects
    @FindBy(xpath = "//select[@id='days']")
    public WebElement days;

    @FindBy(xpath = "//select[@id='months']")
    public WebElement months;

    @FindBy(xpath = "//select[@id='years']")
    public WebElement years;

    // Checkboxes - newsletter and offers
    @FindBy(xpath = "//input[@id='newsletter']")
    public WebElement newsletterCheckbox;

    @FindBy(xpath = "//input[@id='optin']")
    public WebElement offersCheckbox;

    // Address info
    @FindBy(xpath = "//input[@id='first_name']")
    public WebElement firstName;

    @FindBy(xpath = "//input[@id='last_name']")
    public WebElement lastName;

    @FindBy(xpath = "//input[@id='company']")
    public WebElement company;

    @FindBy(xpath = "//input[@id='address1']")
    public WebElement address1;

    @FindBy(xpath = "//input[@id='address2']")
    public WebElement address2;

    @FindBy(xpath = "//select[@id='country']")
    public WebElement country;

    @FindBy(xpath = "//input[@id='state']")
    public WebElement state;

    @FindBy(xpath = "//input[@id='city']")
    public WebElement city;

    @FindBy(xpath = "//input[@id='zipcode']")
    public WebElement zipcode;

    @FindBy(xpath = "//input[@id='mobile_number']")
    public WebElement mobileNumber;

    // Create account button
    @FindBy(xpath = "//button[contains(text(),'Create Account')]")
    public WebElement createAccountButton;

    // Account Created message
    @FindBy(xpath = "//*[@id=\"form\"]/div/div/div/h2/b")
    public WebElement accountCreatedMsg;

    // Continue button after account created
    @FindBy(xpath = "//a[contains(text(),'Continue') or @data-qa='continue-button']")
    public WebElement continueButton;
}
