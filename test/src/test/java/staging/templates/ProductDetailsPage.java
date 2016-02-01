package staging.templates;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;

public class ProductDetailsPage extends QuickView {
	

	
	
	 
	  
  @Test
  public void variantName()  throws InterruptedException, IOException {
	  
	
	 
	  getSocialCount();
	  for(int i=0;i<socialCount;i++)
	  {
	  testSocial("phdesktopbody_0_phdesktoparticlesharerecommend_1_rptSMLinks_smHyperLink_"+i);
	  }
	  getDropDown();
      
      
 
  }
  


  // Reads and returns field

  
  
 
  
  public static WebDriver takeScreeshot(String name) throws IOException
	 {
		
		 WebDriver augmentedDriver = new Augmenter().augment(driver);
		//  System.out.println("Let me Rotate ");
	//	((Rotatable)augmentedDriver).rotate(ScreenOrientation.PORTRAIT);
	     System.out.println("Let me take a screenshot " +name);
	     driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

	    
		    File screenshot = ((TakesScreenshot)augmentedDriver).getScreenshotAs(OutputType.FILE);
		  
		   
		    
		    
		    driver.manage().timeouts().implicitlyWait(450000, TimeUnit.SECONDS);
		   
		    FileUtils.copyFile(screenshot, new File(name));
		    
		    return driver;
	 }

}
