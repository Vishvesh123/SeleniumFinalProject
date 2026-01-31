package Locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutPageLocators {
	
	@FindBy(xpath = "//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[3]/a")
	public WebElement viewCartLink;
	
	@FindBy(xpath = "//a[normalize-space()='Proceed To Checkout']")
	public WebElement proceedToCheckoutBtn;
	
	@FindBy(xpath = "//a[normalize-space()='Place Order']")
	public WebElement placeOrderBtn;
	
	@FindBy(name = "name_on_card")
	public WebElement nameOnCard;
	
	@FindBy(name = "card_number")
	public WebElement cardNumber;
	
	@FindBy(name = "cvc")
	public WebElement cvc;
	
	@FindBy(name = "expiry_month")
	public WebElement expMonth;
	
	@FindBy(name = "expiry_year")
	public WebElement expYear;
	
	@FindBy(id = "submit")
	public WebElement payAndConfirmBtn;
	
	@FindBy(xpath = "//p[contains(text(),'Congratulations') or contains(text(),'Your order has been confirmed')]")
	public WebElement confirmationMsg;
	
	 @FindBy(xpath = "//*[@id=\"form\"]/div/div/div/h2/b")
	 public WebElement accountDeleatedMsg;
}

