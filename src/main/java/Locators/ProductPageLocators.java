package Locators;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPageLocators {

	@FindBy(css = "input#search_product")
	public WebElement searchBox;
	
	@FindBy(xpath = "//button[@id='submit_search']")
	public WebElement searchButton;
	
	@FindBy(xpath = "//div[@class='productinfo text-center']")
	public List<WebElement> productBlocks;
	
	@FindBy(xpath = "/html/body/section/div/div/div[2]/div[2]/div[2]/div/span/button")
	public WebElement addToCartBtn;
	
	@FindBy(xpath = "//*[@id=\"cartModal\"]/div/div/div[3]/button")
	public WebElement continueShoping;
	
	@FindBy(xpath = "ancestor::div[@class='col-sm-4']//a[contains(text(),'View Product')]")
	public WebElement selectedProduct;
	
	
	@FindBy(xpath = "//*[contains(text(),'Added') or contains(text(),'added to cart')]")
	public WebElement addedMsg;
	
	
	
	
}

