package cadilac.mobile;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.appium.java_client.android.AndroidDriver;

public class Cart extends Screenshot {
	protected AndroidDriver driver;
	protected SoftAssert softAssert = new SoftAssert();
	public String local=(new java.io.File("").getAbsolutePath());
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
		takeSnapshot("explore_page.png");
		

        WebElement element = driver.findElement(By.xpath(".//*[@class='elm-button-text']"));
        Actions action = new Actions(driver);
        
        
        action.moveToElement(element).perform();
        Thread.sleep(1000);
		driver.manage().timeouts().implicitlyWait(35, TimeUnit.SECONDS);	
		takeSnapshot("Explore_Content.png");
        
       element.click();
        
       Thread.sleep(50);
		driver.manage().timeouts().implicitlyWait(35, TimeUnit.SECONDS);	
		
		takeSnapshot("spin.png");
		
		  Thread.sleep(50);
			driver.manage().timeouts().implicitlyWait(35, TimeUnit.SECONDS);	
			
			takeSnapshot("load_more.png");
  }

}