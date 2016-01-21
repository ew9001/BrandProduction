package shop.product;

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
public class Products {
	
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

		

	  @BeforeClass
	  @Parameters({"browser"})
	  public void beforeClass(String browser) throws IOException, InterruptedException
	  {	   
		  
		  
		  
		  
		  
		 if (browser.equals("galaxyS5")) {
			  driver=firefox();
			 
			}
		 else if (browser.equals("iPhone5S")){
			 driver=iPhone5S();
		 }
		}

		public WebDriver firefox() throws MalformedURLException  
	 {  
	  
		 System.out.println("Let me run in Firefox");
		 String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub.browserstack.com/wd/hub";
		 DesiredCapabilities caps = new DesiredCapabilities();
		 caps.setCapability("browserName", "Firfox");
		 caps.setCapability("browser", "Firefox");
		 caps.setCapability("browser_version", "43.0");
		 caps.setCapability("os", "Windows");
		 caps.setCapability("os_version", "10");
		 caps.setCapability("resolution", "1024x768");
		 caps.setCapability("browserstack.debug", "true");
		 caps.setCapability("browserstack.selenium_version", "2.47.1");
		 caps.setCapability("acceptSslCerts", "true");
		  driver = new RemoteWebDriver(new URL(URL), caps);
	      browser="galaxyS5";
	      driver.get(System.getProperty("BrandUrl"));
	      brand = System.getProperty("Brand");
	  

	  	System.out.println("The String is " +brand);
	      driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	      return driver;
	   
	    
	      
	 } 
		

		public WebDriver iPhone5S() throws MalformedURLException  
	 {  
	  
		 System.out.println("Let me run in iPhone 5S");
		 String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub.browserstack.com/wd/hub";
		 DesiredCapabilities caps = new DesiredCapabilities();
		 caps.setCapability("browserName", "iPhone");
		 caps.setCapability("platform", "MAC");
		 caps.setCapability("device", "iPhone 5S");
		 caps.setCapability("browserstack.debug", "true");
		 caps.setCapability("browserstack.selenium_version", "2.47.1");
		 caps.setCapability("acceptSslCerts", "true");
		  driver = new RemoteWebDriver(new URL(URL), caps);
	      browser="iPadMini";
	      driver.get(System.getProperty("BrandUrl"));
	      brand = System.getProperty("Brand");
	  

	  	System.out.println("Testing the following brand " +brand);
	      driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	      return driver;
	   
	    
	      
	 } 

	  
	  @Test(priority=1)
	  public void registerPage() throws IOException, InterruptedException{
		   name=""+ folder+"/" + brand +"_"+ browser +"_" + "expanded_menu.png";
	  	System.out.println("Let me take screenshot");
	  	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	
	   driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	   driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	   driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	   
	   
	   
	   
	   
	   
	   takeScreenshot(name);
	   
	  } 
	  /*
	   @Test(priority=2)
		  public void invalidLogin() throws IOException, InterruptedException{
		   System.out.println("Let me click on Login");
	   driver.findElement(By.className("icon-pics")).click();
	   driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	   driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	   driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	   driver.findElement(By.className("event_profile_login")).click();
	   driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	   driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	   driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  driver.findElement(By.id("phsmartphonebody_0_username")).clear();
	  driver.findElement(By.id("phsmartphonebody_0_username")).sendKeys("puck2stick@gma22il.com");
	  driver.findElement(By.id("phsmartphonebody_0_password")).clear();
	  driver.findElement(By.id("phsmartphonebody_0_password")).sendKeys("zaq12wsx");
	  driver.findElement(By.id("phsmartphonebody_0_submit")).click();

	  id="phsmartphonebody_0_Message";
	  actualText=driver.findElement(By.id(id)).getText();
	  actual="The email and password combination you entered is incorrect. Please try again, or click the link below to create an account.";
	  driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	  driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	  assertText();
     takeScreenshot(name);
	  
	  }
	  
	  @Test(priority=3)
	  public void validLogin() throws IOException{
		    name=""+ folder+"/" + brand +"_"+ browser +"_" + "valid_login.png";
		 
		  System.out.println("Let me check on valid login");
		   driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		   driver.findElements(By.className("event_profile_login"));

			  driver.findElement(By.id("phsmartphonebody_0_username")).clear();
			  driver.findElement(By.id("phsmartphonebody_0_username")).sendKeys("albert.golubev@pkt.com");
			  driver.findElement(By.id("phsmartphonebody_0_password")).clear();
			  driver.findElement(By.id("phsmartphonebody_0_password")).sendKeys("zaq12wsx");
			  driver.findElement(By.id("phsmartphonebody_0_submit")).click();

		  id="phsmartphonebody_0_lblDOBValue";
		  actualText=driver.findElement(By.id(id)).getText();
		  actual="12/1962";
		  driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		  driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		  assertText();
	      takeScreenshot(name);
		  
	  }
	  
	  @Test(priority=4)
	  public void editProfile() throws IOException{
	 
		    name=""+ folder+"/" + brand +"_"+ browser +"_" + "edit_profile.png";
		  System.out.println("Let me check on edit profile & error messages of profile");
		   driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 
		  driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		 
		  driver.findElement(By.id("phsmartphonebody_0_HlinkEdit")).click();
		  driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		  
		  driver.findElement(By.id("phsmartphonebody_0_grs_account[addresses][0][postalarea]")).clear();
		  
		  driver.findElement(By.id("phsmartphonebody_0_submit")).click();
		  
		  id="phsmartphonebody_0_grs_account[addresses][0][postalarea]errmsg";
		  actualText=driver.findElement(By.id(id)).getText();
		  actual="Please enter your ZIP/Postal area code.";
		  driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		  driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		  assertText();
	      takeScreenshot(name);
	      
	      driver.findElement(By.id("phsmartphonebody_0_grs_account[addresses][0][postalarea]")).sendKeys("11235");
	      
	      driver.findElement(By.id("phsmartphonebody_0_submit")).click();
		  
	  }
	  @Test(priority=5)
	  public void resetPassword() throws IOException{
		  
		    name=""+ folder+"/" + brand +"_"+ browser +"_" + "invalid_reset_password.png";
		  System.out.println("Let me reset password");
		   driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		   driver.findElement(By.id("phsmartphonebody_0_HlinkEdit")).click();
		  driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		 
		  driver.findElement(By.id("phsmartphonebody_0_HlinkReset")).click();
		  driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		  driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		  driver.findElement(By.name("phsmartphonebody_0$username")).clear();
		  driver.findElement(By.name("phsmartphonebody_0$username")).sendKeys("asfsaf2qao@sdasd.com");
		  driver.findElement(By.name("phsmartphonebody_0$zipcode")).clear();
		  driver.findElement(By.name("phsmartphonebody_0$zipcode")).sendKeys("11235");
		  driver.findElement(By.name("phsmartphonebody_0$LoginSubmitBtn")).click();
		  
		  id="phsmartphonebody_0_Message";
		  actualText=driver.findElement(By.id(id)).getText();
		  actual="We could not find an account with that Email address and Birthday/ZIP code.";
		  driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		  driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		  assertText();
	      takeScreenshot(name);
	        name=""+ folder+"/" + brand +"_"+ browser +"_" + "valid_reset_password.png";
	      driver.findElement(By.name("phsmartphonebody_0$username")).clear();
		  driver.findElement(By.name("phsmartphonebody_0$username")).sendKeys("albert.golubev@pkt.com");
		  driver.findElement(By.name("phsmartphonebody_0$zipcode")).clear();
		  driver.findElement(By.name("phsmartphonebody_0$zipcode")).sendKeys("11235");
		  driver.findElement(By.name("phsmartphonebody_0$LoginSubmitBtn")).click();
		  
		  id="phsmartphonebody_0_Header";
		  actualText=driver.findElement(By.id(id)).getText();
		  actual="Set Password";
		  driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		  driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		  assertText();
	      takeScreenshot(name);
	      
	     
	  
	  }
	  
	  @Test(priority=6)
	  public void setPassword() throws IOException{
		  
		    name=""+ folder+"/" + brand +"_"+ browser +"_" + "set_password.png";
		  System.out.println("Let me reset set password");
		   driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 
		  driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		 
		  driver.findElement(By.name("phsmartphonebody_0$showpassword")).click();
		  driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		  
		  driver.findElement(By.name("phsmartphonebody_0$password")).clear();
		  driver.findElement(By.name("phsmartphonebody_0$password")).sendKeys("alb");
		  driver.findElement(By.name("phsmartphonebody_0$ResetSubmitBtn")).click();
		  
		  id="phsmartphonebody_0_revpassword";
		  actualText=driver.findElement(By.id(id)).getText();
		  actual="The password must be minimum 8 characters, including at least 1 letter and 1 number.";
		  driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		  driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		  assertText();
	      takeScreenshot(name);
	        name=""+ folder+"/" + brand +"_"+ browser +"_" + "valid_set_password.png";
	      driver.findElement(By.name("phsmartphonebody_0$password")).clear();
		  driver.findElement(By.name("phsmartphonebody_0$password")).sendKeys("zaq12wsx");
		  driver.findElement(By.name("phsmartphonebody_0$ResetSubmitBtn")).click();
		  id="phsmartphonebody_0_Header";
		  actualText=driver.findElement(By.id(id)).getText();
		  actual="Your Password Has Been Reset";
		  driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		  driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		  assertText();
	      takeScreenshot(name);
	      
	       name=""+ folder+"/" + brand +"_"+ browser +"_" + "after_reset_password.png";
	       
	     
	      driver.findElement(By.name("phsmartphonebody_0$username")).sendKeys("albert.golubev@pkt.com");
		  driver.findElement(By.name("phsmartphonebody_0$password")).clear();
		  driver.findElement(By.name("phsmartphonebody_0$password")).sendKeys("zaq12wsx");
		  driver.findElement(By.name("phsmartphonebody_0$submit")).click();
		  driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		  driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		  id="phsmartphonebody_0_labelDOB";
		  actualText=driver.findElement(By.id(id)).getText();
		  actual="Birthday";
		  driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		  driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		  assertText();
	      takeScreenshot(name);
	      
	     
	  
	  }
	  @Test(priority=7)
	  public void loginAndLogout() throws IOException{
		  driver.findElement(By.className("icon-pics")).click();
		  driver.manage().timeouts().implicitlyWait(16, TimeUnit.SECONDS);
		  driver.findElement(By.id("phsmartphoneheader_0_HeaderSideMenu_phsmartphoneheadercrm_0_logOffLink")).click();
		  
		  driver.manage().timeouts().implicitlyWait(16, TimeUnit.SECONDS);

		  id="phsmartphonebody_0_logOffContinueLink";
		  actualText=driver.findElement(By.id(id)).getText();
		  actual="LOG OUT";
		  driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		  driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		  assertText();
	      takeScreenshot(name);
	  
	  }
	  */
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

	 public void assertText()
	 {
	 	 System.out.println("Assert that the text is present " +actual);
		  
	 	softAssert.assertEquals(actualText,actual,"Failed to assert an element");
		




	 }


	}



