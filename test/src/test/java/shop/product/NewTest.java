package shop.product;

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
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;

public class NewTest {
	
	private static WebDriver driver;
	 private SoftAssert softAssert = new SoftAssert();
	 public String tmp;
	 public static final String USERNAME = "zaqwsx1";
	  public static final String AUTOMATE_KEY = "Fs54nwmULt7BaSTosZxi";
	  public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub.browserstack.com/wd/hub";
	  public static String browser;
	public String brand;
	public static String name;
	public static int counter=1;
	public static int variant=1;
	
	
	 
	  
  @Test(priority=1)
  public  static void variantName() throws InterruptedException, IOException {
	  
	  System.out.println("Let me look at the drop down");
	  
	  WebElement pack_size=driver.findElement(By.id("phdesktopbody_0_phdesktopproductprimarycontentarea_0_ProductVariantsLeft1_ddlVariantionSelectorLeft"));
	  List<WebElement> pack  = pack_size.findElements(By.tagName("option"));
	  
	
	  for(int i=0;i<pack.size();i++)
	  {   
		  
		  String value = pack.get(i).getText();
	
		  System.out.println("For Pack Size#" +counter +" " +value);
		
		  new Select(driver.findElement(By.id("phdesktopbody_0_phdesktopproductprimarycontentarea_0_ProductVariantsLeft1_ddlVariantionSelectorLeft"))).selectByVisibleText(value);
		  counter+=1;
		  WebElement pack_variation=driver.findElement(By.id("phdesktopbody_0_phdesktopproductprimarycontentarea_0_ProductVariantsLeft2_ddlVariantionSelectorLeft"));
		  List<WebElement> variation  = pack_variation.findElements(By.tagName("option"));
		 
		  //for(int j=variation.size()-1;j>0;j--)
		 for(int j=0;j<variation.size();j++)
		  {
			  String value2 = variation.get(j).getText();
			  System.out.println("Variation #" + variant +" " +value2);
			  
			  
			  new Select(driver.findElement(By.id("phdesktopbody_0_phdesktopproductprimarycontentarea_0_ProductVariantsLeft2_ddlVariantionSelectorLeft"))).selectByVisibleText(value2);
			  
			  
			  name=""+ browser+"/" + value +"_"+ value2 + ".png";
			  Thread.sleep(1000);
			  takeScreeshot(name);
			  variant+=1;
			  if (variant==variation.size()-1)
			  {
				  variant=1;
				  break;
			  }
			  
			
			  
			  
		  }
		 
		
	  }
	  
  }
  


  // Reads and returns field

  
  @BeforeClass
  public void beforeClass() throws MalformedURLException {
	  
	  System.out.println("Let me run in Firefox");
		 String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub.browserstack.com/wd/hub";
		 DesiredCapabilities caps = new DesiredCapabilities();
		 caps.setCapability("browser", "Firefox");
		 caps.setCapability("browser_version", "43.0");
		 caps.setCapability("os", "OS X");
		 caps.setCapability("os_version", "Yosemite");
		 caps.setCapability("resolution", "1024x768");
		 caps.setCapability("browserstack.debug", "true");
		 caps.setCapability("browserstack.selenium_version", "2.48.2");
		 //caps.setCapability("browserstack.selenium_version", "2.47.1");
		 caps.setCapability("acceptSslCerts", "true");
		  driver = new RemoteWebDriver(new URL(URL), caps);
	      browser="Firefox42";
	      driver.get(System.getProperty("BrandUrl"));
	      brand = System.getProperty("Brand");
	  

	  	System.out.println("The brand is " +brand);
	      driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	      driver.manage().window().maximize();
  }

  @AfterClass
  public void afterClass() {
	  driver.quit();
  }
  
  public static WebDriver takeScreeshot(String name) throws IOException
	 {
		
		 WebDriver augmentedDriver = new Augmenter().augment(driver);
		//  System.out.println("Let me Rotate ");
	//	((Rotatable)augmentedDriver).rotate(ScreenOrientation.PORTRAIT);
	     System.out.println("Let me take a screenshot " +name);
	     driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

	    
		    File screenshot = ((TakesScreenshot)augmentedDriver).getScreenshotAs(OutputType.FILE);
		  
		   
		    
		    
		    driver.manage().timeouts().implicitlyWait(450000, TimeUnit.SECONDS);
		    
		    driver.manage().timeouts().implicitlyWait(450000, TimeUnit.SECONDS);
		    
		    driver.manage().timeouts().implicitlyWait(450000, TimeUnit.SECONDS);
		    
		    driver.manage().timeouts().implicitlyWait(450000, TimeUnit.SECONDS);
		    FileUtils.copyFile(screenshot, new File(name));
		    
		    return driver;
	 }

}
