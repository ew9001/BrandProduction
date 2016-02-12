package citi.thankyou;

import io.appium.java_client.android.AndroidDriver;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

public class StartBrowser {
	
	protected AndroidDriver driver;
	protected SoftAssert softAssert = new SoftAssert();
	
	 @BeforeMethod
	  public void loadBrowserOnDevice() throws MalformedURLException {
		  
		    DesiredCapabilities caps = new DesiredCapabilities();
			caps.setCapability("automationName","Appium");
			caps.setCapability("deviceName","Galaxy S4");
			caps.setCapability("platformVersion","4.4");
			caps.setCapability("appPackage", "com.android.chrome");
			caps.setCapability("appActivity","Main");
			caps.setCapability("autoAcceptAlerts",true);
			
			driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),caps);
			
			driver.get(System.getProperty("BrandUrl"));
		      
			driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);	
	  }

	  @AfterMethod
	  public void afterMethod() {
		  
		  driver.quit();
	  }
	  
	  // This functions talks to ScreenTest class to take screenshot through ADB
	  public void takeScreenshot(String screenName) throws IOException, InterruptedException
	  {
	  	 Screenshot.takeSnapshot(screenName);
	  	 System.out.println("took screenshot with name " +screenName); 
	  }
	  
	  protected void waitElementsToAppear(int seconds)
	  {
		  driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
	  }
	  
	  
	  public void softAssertText(String expectedText, String elementId) throws InterruptedException
	  {
		  Thread.sleep(100);
		  String actualText=driver.findElement(By.id(elementId)).getText();
		  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  	 System.out.println("Assert that the text is present " +expectedText);
	  	 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  	softAssert.assertEquals(actualText,expectedText,"Failed to assert an element");
	  	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  	
	  }
	  protected void waitForClickable(String elementId){
  
		  WebDriverWait wait1 = new WebDriverWait(driver, 35);
	  	wait1.until(ExpectedConditions.elementToBeClickable((By.id(elementId))));
	  }
	  
}