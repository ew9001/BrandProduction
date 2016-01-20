package webdriver.test;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class brandPreferenceCenter {
	
	public static WebDriver driver;
	 private SoftAssert softAssert = new SoftAssert();
	 public String browser="iPhone5S";
	 public String folder = "screenshots";
	 public String fail,error,url,name,actualText,id,actual,brand;
	 
	 @Test
	 public void startDriver() throws IOException
	{
		 System.out.println("Start Server");
		
		driver = new RemoteWebDriver(new URL("http://192.168.2.8:3001/wd/hub"), DesiredCapabilities.iphone());
	    driver.get("http://crest.com");

	    
	    
		   name=""+ folder+"/" + brand +"_"+ browser +"_" + "expanded_menu.png";
	  	System.out.println("Let me click on Register");
	  	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	
	   driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	   driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	   driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	   
	   
	   
	   driver.findElement(By.className("icon-pics")).click();
	   
	   
	   takeScreenshot(name);
	   driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	   driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	   driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	   
	   name=""+ folder+"/" + brand +"_"+ browser +"_" + "register_menu.png";
	   
	   driver.findElement(By.className("event_profile_register")).click();
	   
	   
	
	   driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	   
	   
		  driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		  driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		  driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		  driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	   driver.findElement(By.id("phsmartphonebody_0_submit")).click();
	   
	   name=""+ folder+"/" + brand +"_"+ browser +"_" + "blank_register.png";
		  driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		  driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		  driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	   takeScreenshot(name);
	
		
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
