package brand.test;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Rotatable;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.HasInputDevices;
import org.openqa.selenium.interactions.Keyboard;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class BuyNow {
	
	private static WebDriver driver;
	 private SoftAssert softAssert = new SoftAssert();
	 public static final String USERNAME = "zaqwsx1";
	  public static final String AUTOMATE_KEY = "Fs54nwmULt7BaSTosZxi";
	  public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub.browserstack.com/wd/hub";
	  int lineNumber = 0;
	 
	 
	  public String browser,expectedText;
	  public String folder = "screenshots";
	  public String fail,error,url,name,actualText,id,actual,brand;
	    String local=(new java.io.File("").getAbsolutePath());
		String data="" + local + "/" + "Brand.csv";	
		
		
		String csvFileToRead;

		static String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
	    int counter=1;
		
		

		@Parameters({"browser"})

	  @BeforeClass
	  public void beforeClass(String browser) throws IOException, InterruptedException
	  {	   
		  
		  
		  
		  
		  
		 if (browser.equals("windows7IE10")) {
			  driver=windows7IE10();
			 
			}
		 
		 else if (browser.equals("firefox42MAC")) {
			  driver=firefox42MAC();
			 
			}
		}

		public WebDriver windows7IE10() throws MalformedURLException  
	 {  
	  
		 System.out.println("Let me run in Windows 7 IE11");
		 String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub.browserstack.com/wd/hub";
		 DesiredCapabilities caps = new DesiredCapabilities();
		 caps.setCapability("browser", "IE");
		 caps.setCapability("browser_version", "11.0");
		 caps.setCapability("os", "Windows");
		 caps.setCapability("os_version", "7");
		 caps.setCapability("resolution", "1024x768");
		 caps.setCapability("browserstack.debug", "true");
		 caps.setCapability("browserstack.selenium_version", "2.47.1");
		 caps.setCapability("acceptSslCerts", "true");
		  driver = new RemoteWebDriver(new URL(URL), caps);
	      browser="windows7IE10";
	      driver.get(System.getProperty("BrandUrl"));
	      brand = System.getProperty("Brand");
	  

	  	System.out.println("The String is " +brand);
	      driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	      driver.manage().timeouts().implicitlyWait(450000, TimeUnit.SECONDS);
		    
		   
	      return driver;
	   
	    
	      
	 } 
		
		public WebDriver firefox42MAC() throws MalformedURLException  
		 {  
		  
			 System.out.println("Let me run in MAC OS Firefox 42");
			 String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub.browserstack.com/wd/hub";
			 DesiredCapabilities caps = new DesiredCapabilities();
			 caps.setCapability("browser", "Firefox");
			 caps.setCapability("browser_version", "42.0");
			 caps.setCapability("os", "OS X");
			 caps.setCapability("os_version", "Yosemite");
			 caps.setCapability("resolution", "1024x768");
			 caps.setCapability("browserstack.debug", "true");
			 caps.setCapability("browserstack.selenium_version", "2.47.1");
			 caps.setCapability("acceptSslCerts", "true");
			  driver = new RemoteWebDriver(new URL(URL), caps);
		      browser="windows7IE10";
		      driver.get(System.getProperty("BrandUrl"));
		      brand = System.getProperty("Brand");
		  

		  	System.out.println("The String is " +brand);
		      driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		      return driver;
		   
		    
		      
		 } 
		  @SuppressWarnings("resource")
		@Test(priority=1)
		  public void previewErrors() throws IOException{
			   
			    driver.manage().timeouts().implicitlyWait(450000, TimeUnit.SECONDS);
			  System.out.println("Let me click on Buy Now");
			  
			 
			    csvFileToRead = data;
			    BufferedReader br =null;
			    String line="";
			    br = new BufferedReader(new FileReader(csvFileToRead));  
			  
			    while ((line = br.readLine()) != null) {
				  	  
			        System.out.println("The URL is " + counter);
			        String [] nextLine = line.split(",");
			        // nextLine[] is an array of values from the line
			        System.out.println(nextLine[lineNumber]);
			        url=nextLine[lineNumber];
			        driver.manage().timeouts().implicitlyWait(450000, TimeUnit.SECONDS);
			        System.out.println("The URL is " + url);
			        driver.get(url);
			        
			        WebElement element = driver.findElement(By.xpath(".//*[@id='phdesktopbody_0_phdesktopproductprimarycontentarea_0_anchrBuyNowLeft']"));
			        Actions action = new Actions(driver);
			        
			        
			        action.moveToElement(element).perform();
			        
			        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
				  driver.findElement(By.id("phdesktopbody_0_phdesktopproductprimarycontentarea_0_anchrBuyNowLeft")).click();
				  driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
				 
				  counter +=1;
				  name=""+ folder+"/" + brand +"_"+ browser +"_" + counter + "details_page_popup.png";
				  takeScreenshot(name);
				  
			    }
		      
		     
			  
		  }
	      
	

	  
	 
	  public WebDriver takeScreenshot(String name) throws IOException
	 {
		
		 WebDriver augmentedDriver = new Augmenter().augment(driver);
		//  System.out.println("Let me Rotate ");
	//	((Rotatable)augmentedDriver).rotate(ScreenOrientation.PORTRAIT);
	     System.out.println("Let me take a screenshot " +name);
	     driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	
	    
		    File screenshot = ((TakesScreenshot)augmentedDriver).getScreenshotAs(OutputType.FILE);
		 
		    
		    
		     driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		  
		    FileUtils.copyFile(screenshot, new File(name));
		    
		    return driver;
	 }

	 public void assertText()
	 {
	 	 System.out.println("Assert that the text is present " +actual);
		  
		Assert.assertEquals(actualText,actual,"Failed to assert an element");
		




	 }


	}



