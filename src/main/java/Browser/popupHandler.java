package Browser;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class popupHandler extends browser {
	public static void handlePopup() {
	    try {
	        // Wait for iframe to be present
	        wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("iframe")));
	        List<WebElement> iframes = driver.findElements(By.tagName("iframe"));
	        for (WebElement iframe : iframes) {
	            if (iframe.isDisplayed()) {
	               
	            	   driver.switchTo().frame(iframe);
	                JavascriptExecutor js = (JavascriptExecutor) driver;
	             
	                // Click at top-left corner (usually overlay, not ad)
	                js.executeScript("document.elementFromPoint(10, 10).click();");
	                
	                driver.switchTo().defaultContent();
	                
	                // Wait for popup to close
	                wait.until(ExpectedConditions.invisibilityOf(iframe));
	                break;
	            }
	        }

	    } catch (Exception e) {
	    	  System.out.println("Popup handler "+e);
	        try {
	            driver.switchTo().defaultContent();
	        } catch (Exception ex) {
	            // Ignore
	        }
	    }
	}
}
