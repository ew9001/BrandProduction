package citi.thankyou;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.appium.java_client.android.AndroidDriver;

public class Cart extends Screenshot {
	protected AndroidDriver driver;
	protected SoftAssert softAssert = new SoftAssert();
	@Test
	 public void loadBrowserOnDevice() throws MalformedURLException, InterruptedException {
		  
	    DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("automationName","Appium");
		caps.setCapability("deviceName","Galaxy S4");
		caps.setCapability("platformVersion","4.4");
		caps.setCapability("appPackage", "com.android.chrome");
		caps.setCapability("appActivity","Main");
		caps.setCapability("autoAcceptAlerts",true);
		
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),caps);
		
		driver.get(System.getProperty("BrandUrl"));
		Thread.sleep(1000);
		driver.manage().timeouts().implicitlyWait(35, TimeUnit.SECONDS);	
		takeSnapshot("cart.png");
  }

}
