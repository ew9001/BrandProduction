package project.facebook;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.io.Console;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;

public class startBrowser {
	
	protected static WebDriver driver;
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
	
 
	
	
  public static void getQuick(String typeProduct, String quickView) throws InterruptedException, IOException
  {
	  System.out.println("Let me look at Quick View from Search Page");
	  driver.get(System.getProperty("BrandUrl"));

		//*[@id="phdesktopbody_0_phdesktopproductresults_1_RptrProductList_imgProducts_1"]

	      WebElement element = driver.findElement(By.id(typeProduct));
	      Actions action = new Actions(driver);
	      
	    //*[@id="phdesktopbody_0_phdesktopproductresults_1_RptrProductList_imgProducts_0"]
	      action.moveToElement(element).perform();
	      
	      driver.manage().timeouts().implicitlyWait(45000, TimeUnit.SECONDS);	
	      driver.findElement(By.id(quickView)).click();
	      Thread.sleep(5000);
	      
	      name=""+ browser+"/" + "loaded" +"_"+ "1st quickview" + ".png";
	      
	      takeScreeshot(name); 
  }
  
 
	  
	 
	  
  
  
  public static void variantName(String productPackSize, String productPackVariation ) throws InterruptedException, IOException {
	  
	  System.out.println("Let me take a screenshot of the screen");
	  boolean exists = true;
	  exists = driver.findElements( By.id("phdesktopbody_0_phdesktopproductprimarycontentarea_0_anchrBuyNowLeft") ).size() != 0;
	  if(true) {
		  System.out.println( "Found Buy Now button ");
		  driver.findElement(By.id("phdesktopbody_0_phdesktopproductprimarycontentarea_0_anchrBuyNowLeft")).click();
		  Thread.sleep(5000);
		}
	  name=""+ browser+"/" + counter +"_"+ "buy_now" + ".png";
	  Thread.sleep(1000);
	  takeScreeshot(name);
	
	  exists = true;
	  exists = driver.findElements( By.id("phdesktopbody_0_phdesktopproductprimarycontentarea_0_imgBinModelClose") ).size() != 0;
	  if(true) {
		  System.out.println( "Found Close button ");
		  driver.findElement(By.id("phdesktopbody_0_phdesktopproductprimarycontentarea_0_imgBinModelClose")).click();
		  Thread.sleep(5000);
		}
	  
	  
	//*[@id="phdesktopbody_0_phdesktopproductprimarycontentarea_0_imgBinModelClose"]
	  
	  
	  WebElement pack_size=driver.findElement(By.id(productPackSize));
	  List<WebElement> pack  = pack_size.findElements(By.tagName("option"));
	  
	  for(int i=pack.size();i>0;i--)
	 // for(int i=0;i<pack.size();i++)
	  {   
		  
		  String value = pack.get(i-1).getText();
	
		  System.out.println("For Pack Size#" +counter +" " +value);
		
		  new Select(driver.findElement(By.id(productPackSize))).selectByVisibleText(value);
		  counter+=1;
		  Thread.sleep(5000);
		  boolean anotherName=true;
		  String quickProduct =driver.findElement(By.className("popup-product-title")).getText(); 
		  if (driver.getPageSource().contains(productPackVariation))
		  {
			  WebElement pack_variation=driver.findElement(By.id(productPackVariation));
			  Dimension dropDown = pack_variation.getSize();
			
			  List<WebElement> variation  = pack_variation.findElements(By.tagName("option"));
			  for(int j=variation.size();j>0;j--)
					
			  {   
				 
				  
				  String value2 = variation.get(j-1).getText();
				  System.out.println("Variation #" + variant +" " +value2);
				  
				  
				  new Select(driver.findElement(By.id(productPackVariation))).selectByIndex(j-1);
				  
				  
				 
				  
				  
				  name=""+ browser+"/" +quickProduct + "_" + value +"_"+ value2 + ".png";
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
		  
		  else
			  
		  {
			  name=""+ browser+"/" + quickProduct + "_" + value +"_"+ ".png";
			  
			  
			  Thread.sleep(1000);
			  takeScreeshot(name);
			  anotherName=false;
		  }
			  
			  
		  
		  
		 
		  
		
	  }
	  
  }
  


 

  
  @BeforeMethod
  public void beforeClass() throws MalformedURLException, InterruptedException {
	  
	  System.out.println("Let me run in Firefox");
		 String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub.browserstack.com/wd/hub";
		 DesiredCapabilities caps = new DesiredCapabilities();
		 caps.setCapability("browser", "Firefox");
		 caps.setCapability("browser_version", "43.0");
		 caps.setCapability("os", "Windows");
		 caps.setCapability("os_version", "7");
		 caps.setCapability("resolution", "1024x768");
		 caps.setCapability("browserstack.debug", "true");
		 caps.setCapability("browserstack.selenium_version", "2.48.2");
		 //caps.setCapability("browserstack.selenium_version", "2.47.1");
		 caps.setCapability("acceptSslCerts", "true");
		  driver = new RemoteWebDriver(new URL(URL), caps);
	      browser="Firefox42";
	      
	     

	 
	      driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	      Thread.sleep(1000);
	      Thread.sleep(1000);
	      driver.manage().window().maximize();
	      Thread.sleep(1000);
	      Thread.sleep(1000);
	      Thread.sleep(1000);
	      Thread.sleep(1000);
	      Thread.sleep(1000);
	      
	      
	      driver.get("http://facebook.com");
	      getFaceBook("pkt_zdesjro_qa@tfbnw.net","xswqaz");
	      getGmail("tester96010001@gmail.com","p@blicis!");
	      //driver.get(System.getProperty("BrandUrl"));
  }

  
  public void getPageSocialTest() throws InterruptedException
  {
	  driver.get("http://dare-greatly.com/explore/design/architecture/how-neumannsmith-architecture-is-redesignng-detroit-one-building-at-a-time");
	  Thread.sleep(10000);
	 
	  Thread.sleep(10000);
	  
	
		  System.out.println( "Found Buy Now button ");
		  Thread.sleep(50000);
		  WebDriverWait wait = new WebDriverWait(driver,15);
			 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='shareTwitter']")));
		  
		  
		
		  
		  driver.findElement(By.xpath("//*[@id='shareTwitter']")).click();
		  Thread.sleep(5000);
		
	  
	  
       Thread.sleep(5000);
       Thread.sleep(5000);
       Thread.sleep(5000);
     //*[@id="shareFacebook"]/i
    
	  Thread.sleep(5000);
	  name=""+ browser+"/" + driver.getTitle() + "twitter.png";
	  Thread.sleep(5000);
	  driver.switchTo().window("Share a link on Twitter");
  }
  

  public void getFaceBook(String username,String password) throws InterruptedException
  {
	  driver.get("http://facebook.com");
	  	driver.findElement(By.id("email")).clear();;
		driver.findElement(By.id("email")).sendKeys(username);
		driver.findElement(By.id("pass")).clear();
		driver.findElement(By.id("pass")).sendKeys(password);
		driver.findElement(By.id("loginbutton")).click();
	     Thread.sleep(1000);
  }
  
  
  public void getGmail(String username,String password) throws InterruptedException
  {
	  driver.get("http://gmail.com");
	 	driver.findElement(By.id("Email")).clear();;
			driver.findElement(By.id("Email")).sendKeys(username);
			Thread.sleep(1000);
			driver.findElement(By.id("next")).click();
			Thread.sleep(1000);
			driver.findElement(By.id("Passwd")).sendKeys(password);
			Thread.sleep(1000);
			driver.findElement(By.id("signIn")).click();
			
			Thread.sleep(1000);
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


