package shop.product;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;

public class ProductDetails {
	
	 private static WebDriver driver;
	 private SoftAssert softAssert = new SoftAssert();
	 public static final String USERNAME = "zaqwsx1";
	  public static final String AUTOMATE_KEY = "Fs54nwmULt7BaSTosZxi";
	  public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub.browserstack.com/wd/hub";
	 
	 
	  public String browser;
	  public String folder = "screenshots";
	  public String fail,error,url,name,actualText,id,actual,brand;
	 

		static String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
	    int counter=1;
		String local=(new java.io.File("").getAbsolutePath());
		String myTitle;

  @Test
  public void f() {
  }
  @BeforeMethod
  public void beforeMethod() {
  }

  @BeforeClass
  public void beforeClass() throws MalformedURLException {
	  
	  System.out.println("Let me run in Firofox 42 on Windows");
		 String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub.browserstack.com/wd/hub";
		 DesiredCapabilities caps = new DesiredCapabilities();
		 caps.setCapability("browserName", "Firfox");
		 caps.setCapability("browser", "Firefox");
		 caps.setCapability("browser_version", "43.0");
		 caps.setCapability("os", "Windows");
		 caps.setCapability("os_version", "10");
		 caps.setCapability("resolution", "1024x768");
		 caps.setCapability("browserstack.selenium_version", "2.47.1");
		 caps.setCapability("acceptSslCerts", "true");
		  driver = new RemoteWebDriver(new URL(URL), caps);
	      browser="iPadMini";
	      driver.get(System.getProperty("BrandUrl"));
	      brand = System.getProperty("Brand");
	  

	  	System.out.println("Testing the following brand " +brand);
	      driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
  }
  
  @Test(priority=1)
  public void registerPage() throws IOException, InterruptedException{
	   name=""+ folder+"/" + brand +"_"+ browser +"_" + "expanded_menu.png";
  	System.out.println("Let me load product details page ");
  	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

   driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
   driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
   driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
   
   
   driver.get(System.getProperty("BrandUrl"));;
   //driver.findElement(By.className("icon-pics")).click();
   
   
   name=""+ folder+"/" + brand +"_"+ browser +"_" + "register_menu.png";
   
   takeScreenshot(name);
   driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
   driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
   driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
   
   
  } 

  @AfterTest
  public void afterTest() {
  }
  
  public WebDriver takeScreenshot(String name) throws IOException
	 {
		
		 WebDriver augmentedDriver = new Augmenter().augment(driver);
		//  System.out.println("Let me Rotate ");
	//	((Rotatable)augmentedDriver).rotate(ScreenOrientation.PORTRAIT);
	     System.out.println("Let me take a screenshot " +name);
	     driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	
	    
		    File screenshot = ((TakesScreenshot)augmentedDriver).getScreenshotAs(OutputType.FILE);
		 
		    
		    
		    driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		    
		    driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		    FileUtils.copyFile(screenshot, new File(name));
		    
		    return driver;
	 }

}
