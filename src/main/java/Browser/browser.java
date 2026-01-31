package Browser;

import java.time.Duration;


import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.util.HashMap;
import java.util.Map;
public class browser {
public static WebDriver driver;
public static WebDriverWait wait;
public static Actions action;
public static Select select;

public static ExtentReports extent = new ExtentReports();
public static ExtentSparkReporter reporter = new ExtentSparkReporter(
		System.getProperty("user.dir") + "\\target\\Reports\\extentReport.html");
public static ExtentTest logger1;
	//opening the browser
public static void openBrowser() {
	ChromeOptions options = new ChromeOptions();
	options.addArguments("--disable-gpu");
	options.addArguments("--no-sandbox");
	  options.addArguments("--disable-ads");
	options.addArguments("--disable-extensions");
	options.addArguments("--disable-infobars");
	options.addArguments("--disable-notifications");
	options.addArguments("--disable-popup-blocking");
	  options.addArguments("--incognito");
	
//		options.addArguments("--disable-logging");
//		options.addArguments("--blink-settings=imagesEnabled=false"); // disable image loading
//		options.addArguments("--headless=new"); // optional: fastest execution
//	
	  Map<String, Object> prefs = new HashMap<>();

	  prefs.put("profile.default_content_setting_values.notifications", 2); // block notifications
	  prefs.put("profile.default_content_setting_values.popups", 0);        // block popups
	  prefs.put("profile.default_content_setting_values.ads", 2);           // block ads

	  options.setExperimentalOption("prefs", prefs);
	
	try {
		String choice = utility.properties("browser"); //chrome
		if(choice.equalsIgnoreCase("Chrome")) {
			driver=new ChromeDriver(options);
			
		}
		else if(choice.equalsIgnoreCase("Edge")) {
			driver=new EdgeDriver();
		}
		else if(choice.equalsIgnoreCase("FireFox")) {
			driver=new FirefoxDriver();
		}
	}catch(Exception e) {
		System.out.println("Browser - openBrowser");
	}
}

// Navigate to the URL
public static void navigateURL(String title) {
	try {
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		//driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(10));
		
		driver.manage().window().maximize();
		driver.get(utility.properties("url")); //https://automationexercise.com/
		action = new Actions(driver);
		wait=new WebDriverWait(driver,Duration.ofSeconds(3));
		wait.until(ExpectedConditions.titleContains(title));
	}catch(Exception e) {
		System.out.println("Browser - navigateBrowser"+ e);
	}
}


//Close Browser

public static void closeBrowser() {
	try {
		driver.quit();
	}catch(Exception e) {
		System.out.println("Browser - close"+ e);
	}
}

}