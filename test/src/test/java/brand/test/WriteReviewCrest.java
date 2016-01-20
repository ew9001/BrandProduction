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
public class WriteReviewCrest {
	
	private static WebDriver driver;
	 private SoftAssert softAssert = new SoftAssert();
	 public static final String USERNAME = "zaqwsx1";
	  public static final String AUTOMATE_KEY = "Fs54nwmULt7BaSTosZxi";
	  public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub.browserstack.com/wd/hub";
	 
	 
	  public String browser,expectedText;
	  public String folder = "screenshots";
	  public String fail,error,url,name,actualText,id,actual,brand;
	 

		static String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
	    int counter=1;
		String local=(new java.io.File("").getAbsolutePath());
		String myTitle;

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
		  @Test(priority=1)
		  public void previewErrors() throws IOException{
			    name=""+ folder+"/" + brand +"_"+ browser +"_" + "errors.png";
			    driver.manage().timeouts().implicitlyWait(450000, TimeUnit.SECONDS);
			  System.out.println("Let me click on preview");
			  
			  WebElement element = driver.findElement(By.xpath(".//*[@id='phdesktopbody_0_ibtnPreview']"));
		        Actions action = new Actions(driver);
		        
		        
		        action.moveToElement(element).perform(); 
		        
		        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			  driver.findElement(By.id("phdesktopbody_0_ibtnPreview")).click();
		      takeScreenshot(name);
		      //driver.navigate().refresh();
			  
		  }
	      
	

	  
	  @Test(priority=2)
	  public void completeReview() throws IOException{
		  
		  String productName=driver.findElement(By.id("phdesktopbody_0_writeReviewProductInformation_lblProductDetailPageName")).getText();
		  System.out.println("Let me complete all required fields");
		    name=""+ folder+"/" + brand +"_"+ browser +"_" + "completeReview.png";
		  System.out.println("Let me complete review");
		  driver.navigate().refresh();
		  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		  
		  driver.findElement( By.cssSelector("*[id ^='phdesktopbody_0_rptProductReview_txtControlForProductReview_']")).clear();
		  driver.findElement( By.cssSelector("*[id ^='phdesktopbody_0_rptProductReview_txtControlForProductReview_']")).sendKeys("I will write review "+" for the p&g product " +brand);
		  
		  driver.findElement( By.cssSelector("*[id ^='phdesktopbody_0_rptProductReview_textareaControlForProductReview']")).clear();
		  driver.findElement( By.cssSelector("*[id ^='phdesktopbody_0_rptProductReview_textareaControlForProductReview']")).sendKeys("I want to write a revew for product " +productName +" for the p&g product" +" This review is to test how I like this product. This is a great product to use OK by QA");
		  
		 
		   
		  driver.findElement( By.cssSelector("*[id ^='phdesktopbody_0_rptProfileInformation_txtControl_']")).clear();
		  driver.findElement( By.cssSelector("*[id ^='phdesktopbody_0_rptProfileInformation_txtControl_']")).sendKeys("QaTester1978");
		  
		  driver.findElement(By.id("phdesktopbody_0_rptProductRating_rblControlForProductRating_0_0_0")).click();
		  
		  
		 
		 
		    
		    driver.findElement( By.cssSelector("*[id ^='phdesktopbody_0_rptProfileInformation_txtControl_1']")).sendKeys("Brooklyn,NY");
		    
		    
		    new Select(driver.findElement(By.id("phdesktopbody_0_rptProfileInformation_ddlControl_2"))).selectByVisibleText("2");
		    new Select(driver.findElement(By.id("phdesktopbody_0_rptProfileInformation_ddlControl_3"))).selectByVisibleText("1969");
		    driver.findElement(By.id("phdesktopbody_0_rptProfileInformation_txtControl_4")).clear();
		    driver.findElement(By.id("phdesktopbody_0_rptProfileInformation_txtControl_4")).sendKeys("albert.golubev@pkt.com");
		    driver.findElement(By.id("phdesktopbody_0_chkAgree")).click();
		    
			  driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			  
			  WebElement element = driver.findElement(By.xpath(".//*[@id='phdesktopbody_0_divOverallRatingInput']"));
		        Actions action = new Actions(driver);
		        
		        
		        action.moveToElement(element).perform();
		        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		        
		    driver.findElement(By.id("phdesktopbody_0_divOverallRatingInput")).click();
		    driver.findElement(By.id("phdesktopbody_0_rptSecondaryRatingWrite_imgSecondaryRatingStars_0")).click();
		    driver.findElement(By.id("phdesktopbody_0_rptSecondaryRatingWrite_imgSecondaryRatingStars_1")).click();
	        takeScreenshot(name);
	      
		  
	  }
	  @Test(priority=4)
	  public void previewPopup() throws IOException{
		  
		    name=""+ folder+"/" + brand +"_"+ browser +"_" + "previewPopup.png";
		  System.out.println("Let me see preview popup");
		  System.out.println("Let me click on preview");
		  
		  WebElement element = driver.findElement(By.xpath(".//*[@id='phdesktopbody_0_ibtnPreview']"));
	        Actions action = new Actions(driver);
	        
	        
	        action.moveToElement(element).perform();
	        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		  driver.findElement(By.id("phdesktopbody_0_ibtnPreview")).click();
		  takeScreenshot(name);
		  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	        name=""+ folder+"/" + brand +"_"+ browser +"_" + "popup.png";
	        takeScreenshot(name);
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


