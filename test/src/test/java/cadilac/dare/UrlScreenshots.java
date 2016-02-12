package cadilac.dare;

import org.testng.annotations.Test;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.Assert;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class UrlScreenshots extends QuickView {
	
	private WebDriver driver;  
    public String name;
    public static String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());

	  @BeforeClass
	  @org.testng.annotations.Parameters(value={"browser","version","platform"})
	  public void setUp(String browser, String version, String platform) throws Exception {
	    DesiredCapabilities capability = new DesiredCapabilities();
	    capability.setCapability("platform",platform);
	    capability.setCapability("browserVersion", version);
	    capability.setCapability("project", "Cadilac");
	    capability.setCapability("build", "1.0");
	    capability.setCapability("browserstack.debug", "true");
	    capability.setCapability("browserstack.selenium_version", "2.47.1");
	    capability.setCapability("acceptSslCerts", "true");
	    driver = new RemoteWebDriver(new URL("http://zaqwsx1:Fs54nwmULt7BaSTosZxi@hub.browserstack.com/wd/hub"),
	      capability);
	  }  

	  @Test
	  public void testSimple() throws Exception {
		  driver.get(System.getProperty("BrandUrl"));
	    System.out.println("Page title is: " + driver.getTitle());
	    
	   // String s = (String) ((JavascriptExecutor) driver).executeScript("return navigator.userAgent;");
	   // String[] parts = s.split("/");
       // System.out.println("Browser name : " + s);
        
	    name=""+ System.getProperty("Browser")+"/"+"_"+ browser + ".png";

	    takeScreeshot(name); 
	  }

	  @AfterClass  
	  public void tearDown() throws Exception {  
	    driver.quit();  
	  }

}
