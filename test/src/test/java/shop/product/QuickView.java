package shop.product;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.io.Console;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
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
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;

public class QuickView {
	
	protected static WebDriver driver;
	 private static SoftAssert softAssert = new SoftAssert();
	 public String tmp;
	 public static final String USERNAME = "zaqwsx1";
	  public static final String AUTOMATE_KEY = "Fs54nwmULt7BaSTosZxi";
	  public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub.browserstack.com/wd/hub";
	  public static String browser;
	public String brand;
	public static String name;
	public static int counter=1;
	public static int variant=1;
	public static int socialCount;
	
 
	private boolean existsElement(String id) {
	    try {
	        driver.findElement(By.id(id));
	    } catch (NoSuchElementException e) {
	    	 
	        return false;
	       
	    }
	    return true;
	}
	
	public static void getSocialCount() throws IOException
	{
		 
		 List<WebElement> buttons = driver.findElements(By.xpath("//*[contains(@id, 'rptSMLinks_smHyperLink')]"));
		//*[@id="phdesktopbody_0_phdesktoparticlesharerecommend_1_rptSMLinks_smHyperLink_0"]
		    System.out.println("You have  " + buttons.size() + " social icon shares on the article page");
		    socialCount=buttons.size();
	}
	public static void testSocial(String component) throws IOException
	  {
		  boolean otherSocial=true;
	      
					 driver.get(System.getProperty("BrandUrl"));
		  //Get facebook
					
		  String timeStamp = new SimpleDateFormat("HHmmss").format(Calendar.getInstance().getTime());
		  driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
 
		  driver.findElement(By.id(component)).click();
		  driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		    name=""+ browser+"/" + "popup" +"_"+ timeStamp + ".png";
		    takeScreeshot(name); 
		  //*[@id="phdesktopbody_0_phdesktoparticlesharerecommend_1_rptSMLinks_smHyperLink_0"]
		 
		    String facebookURL= driver.findElement(By.id("anchrShareText")).getAttribute("href");
		   // String facebookURL= driver.findElement(By.xpath("//*[contains(text(), 'Share on')]")).getAttribute("href");
		    driver.get(facebookURL);
		    driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		    name=""+ browser+"/" + "inside" +"_"+ timeStamp + ".png";
		    takeScreeshot(name); 
		    driver.get(System.getProperty("BrandUrl"));
		    
		    
		    //Get Twitter
		    
		    
		    
	  }
	
	public static void brandArticle(String name1, String email1, String name2, String email2) throws IOException, InterruptedException
	  {
		
		  driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		  WebElement email = driver.findElement(By.cssSelector("a[href*='#share-overlay']"));
		  String alt = email.getCssValue("alt");
		  
		//*[@id="phdesktopbody_0_phdesktoparticlesharerecommend_2_anchrShareEmail"]
		  softAssert.assertEquals("email",alt);  
		  email.click();
		    driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
		
		    driver.findElement(By.xpath("//*[contains(text(), 'mail')]")).click();
		    name=""+ browser+"/" + "popup" +"_"+ "email" + ".png";
		    driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
		    takeScreeshot(name); 
		    
		    System.out.println("Let me look at the email popup");
		    
		   // driver.findElement(By.id("btnsend")).click();
		  //  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  //  name=""+ browser+"/" + "popup" +"_"+ "error" + ".png";
		//    takeScreeshot(name); 
		    
		    driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		    Thread.sleep(1000);
		    Thread.sleep(1000);
		    
		    JavascriptExecutor jse = (JavascriptExecutor)driver;
		    System.out.println("Let me look when I submit blank form");
		    jse.executeScript("document.getElementById('btnsend').click();");
		    
		    name=""+ browser+"/" + "popup" +"_"+ "errors" + ".png";
		    driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		    takeScreeshot(name); 
		    
		    driver.findElement(By.cssSelector("input[id$='txtYourName']")).sendKeys(name1);
		 
		    driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		    driver.findElement(By.cssSelector("input[id$='txtYourEmail']")).sendKeys(email1);
		    driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		    driver.findElement(By.cssSelector("input[id$='txtFriendName']")).sendKeys(name2);
		    driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		    driver.findElement(By.cssSelector("input[id$='txtFriendEmail']")).sendKeys(email2);
		    
			
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		    name=""+ browser+"/" + "popup" +"_"+ "ready_to_submit" + ".png";
		    takeScreeshot(name); 
		    driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		  //  driver.findElement(By.xpath("//*[contains(text(), 'Send')]")).click();
			
		   
		  
		    jse.executeScript("document.getElementById('btnsend').click();");
			driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
			 Thread.sleep(1000);
			    Thread.sleep(1000);
		    name=""+ browser+"/" + "popup" +"_"+ "next_popup" + ".png";
		    takeScreeshot(name); 
		 
		    driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		    
		    driver.findElement(By.id("phdesktopbody_0_phdesktoparticlesharerecommend_2_anchrEmailContinue")).click();
		    
		   
		   
		    
	  }
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
  
  public Boolean checkElement(String productPackVariation)
  {
	  try {
	        return driver.findElement(By.id(productPackVariation)).isDisplayed();
	      }
	  
	 catch (      NoSuchElementException ignored) {
	        return false;
	      }
	catch (      StaleElementReferenceException ignored) {
	        return false;
	      }
	  
	  
	 
	  
  }
  
  public static void getPrintArticle() throws IOException
  {
	  name=""+ browser+"/" + driver.getTitle() +"_"+ counter + "_" + "article_page.png";
      takeScreeshot(name);
      System.out.println("Image Name " +name);
	  driver.findElement(By.id("phdesktopbody_0_phdesktopprint_0_anchrPrint")).click(); 
	     driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	        driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
	        name=""+ browser+"/" + driver.getTitle() +"_"+ counter + "_" + "print.png";
	        takeScreeshot(name);
	        System.out.println("Image Name " +name);
	        driver.findElement(By.id("print-modal-mask")).click(); 
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	        
  }
  
  public static void shareEmail(String name1, String name2, String email1, String email2) throws IOException, InterruptedException
  {
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	  try{
		  WebElement email = driver.findElement(By.xpath("//td[contains(text(),'mail')]")) ;
		  email.click();
		  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		  driver.findElement(By.id("phdesktopbody_0_phdesktoparticlesharerecommend_2_txtYourName")).sendKeys(name1);
	  }catch(NoSuchElementException e)
	  {
		 
		  e.printStackTrace();
		  driver.quit();
	  
	  }
	  
	  Thread.sleep(15000);

	   name=""+ browser+"/" + driver.getTitle() +"_"+ counter + "_" + "email_popup.png";
       takeScreeshot(name);
       System.out.println("Image Name " +name);
       
       
       driver.findElement(By.id("btnsend")).click();
	   driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	   
	   name=""+ browser+"/" + driver.getTitle() +"_"+ counter + "_" + "email_errors.png";
       takeScreeshot(name);
       System.out.println("Image Name " +name);
       
       driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
       
	driver.findElement(By.id("phdesktopbody_0_phdesktoparticlesharerecommend_2_txtYourName")).sendKeys(name1);
	driver.findElement(By.id("phdesktopbody_0_phdesktoparticlesharerecommend_2_txtYourEmail")).sendKeys(email1);
	driver.findElement(By.id("phdesktopbody_0_phdesktoparticlesharerecommend_2_txtFriendName")).sendKeys(name2);
	driver.findElement(By.id("phdesktopbody_0_phdesktoparticlesharerecommend_2_txtFriendEmail")).sendKeys(email2);
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  
	  name=""+ browser+"/" + driver.getTitle() +"_"+ counter + "_" + "ready_2_submit.png";
      takeScreeshot(name);
      System.out.println("Image Name " +name);
      
      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
      
	driver.findElement(By.id("phsmartphonebody_0_submit")).click();
       
	 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  
	  name=""+ browser+"/" + driver.getTitle() +"_"+ counter + "_" + "ready_2_submit.png";
     takeScreeshot(name);
     System.out.println("Image Name " +name);
     
     driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	name=""+ browser+"/" + driver.getTitle() +"_"+ counter + "_" + "continue.png";
    takeScreeshot(name);
    System.out.println("Image Name " +name);
    driver.findElement(By.id("phdesktopbody_0_phdesktoparticlesharerecommend_2_anchrEmailContinue")).click();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    
  }
  
  public static void variantName(String productPackSize, String productPackVariation ) throws InterruptedException, IOException {
	  
	  System.out.println("Let me take a screenshot of the screen");
	  boolean exists = true;
	  exists = driver.findElements( By.id("phdesktopbody_0_phdesktopproductprimarycontentarea_0_anchrBuyNowLeft") ).size() != 0;
	  if(true) {
		  System.out.println( "Found Buy Now button ");
		  driver.findElement(By.id("phdesktopbody_0_phdesktopproductprimarycontentarea_0_anchrBuyNowLeft")).click();
		  Thread.sleep(15000);
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
  


 public  static void variantName() throws InterruptedException, IOException {
	 boolean exists = true;
	  System.out.println("Let me look at the drop down");
	  
	  WebElement pack_size=driver.findElement(By.id("phdesktopbody_0_phdesktopproductprimarycontentarea_0_ProductVariantsLeft1_ddlVariantionSelectorLeft"));
	  List<WebElement> pack  = pack_size.findElements(By.tagName("option"));
	  
	  for(int i=pack.size();i>0;i--)
	 // for(int i=0;i<pack.size();i++)
	  {   
		  
		  String value = pack.get(i-1).getText();
	
		  System.out.println("For Pack Size#" +counter +" " +value);
		
		  new Select(driver.findElement(By.id("phdesktopbody_0_phdesktopproductprimarycontentarea_0_ProductVariantsLeft1_ddlVariantionSelectorLeft"))).selectByVisibleText(value);
		  counter+=1;
		  Thread.sleep(5000);
		  WebElement pack_variation=driver.findElement(By.id("ProductVariants2_ddlVariantionSelector"));
		  List<WebElement> variation  = pack_variation.findElements(By.tagName("option"));
		 
		  for(int j=variation.size();j>0;j--)
		// for(int j=0;j<variation.size();j++)
		  {
			  String value2 = variation.get(j-1).getText();
			  System.out.println("Variation #" + variant +" " +value2);
			  
			  
			  new Select(driver.findElement(By.id("ProductVariants2_ddlVariantionSelector"))).selectByIndex(j-1);
			  
			  
			  name=""+ browser+"/" + value +"_"+ value2 + ".png";
			  
			  
			 
			  variant+=1;
			  if (variant==variation.size()-1)
			  {
				  variant=1;
				  break;
			  }
			  
			
			  
			  
		  }
		 
		
	  }
	  
  }

  
  @BeforeMethod

  public void beforeClass() throws InterruptedException, IOException {
	  
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
	      
			driver.findElement(By.id("email")).sendKeys("epaesye_shepardman_1453031335@tfbnw.net");
			driver.findElement(By.id("pass")).sendKeys("p@blicis1");
			driver.findElement(By.id("loginbutton")).click();
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			
			
		      driver.get("http://gmail.com");
		      
				driver.findElement(By.id("Email")).sendKeys("tester96010001@gmail.com");
				driver.findElement(By.id("next")).click();
			      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.findElement(By.id("Passwd")).sendKeys("p@blicis!");
				driver.findElement(By.id("signIn")).click();
				driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
				
				
				driver.get("https://www.pinterest.com/");
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				
				driver.findElement(By.xpath("//span[text()='Log in']")).click();
				//driver.findElement(By.linkText("Log in")).click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.findElement(By.name("username_or_email")).sendKeys("tester96010001@gmail.com");
			      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.findElement(By.name("password")).sendKeys("p@blicis!");
				 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				 //driver.findElement(By.linkText("Log in")).click();
				 driver.findElement(By.xpath("//span[text()='Log in']")).click();
				driver.manage().timeouts().implicitlyWait(85, TimeUnit.SECONDS);
				  Thread.sleep(1000);
				  Thread.sleep(1000);
				  Thread.sleep(1000);
				name=""+ browser+"/" + driver.getTitle() +"_"+ counter + "_" + "pintrest.png";
			    takeScreeshot(name);
	            driver.get(System.getProperty("BrandUrl"));
  }


  
  public static WebDriver takeScreeshot(String name) throws IOException
	 {
		
		 WebDriver augmentedDriver = new Augmenter().augment(driver);
		//  System.out.println("Let me Rotate ");
	//	((Rotatable)augmentedDriver).rotate(ScreenOrientation.PORTRAIT);
	     System.out.println("Let me take a screenshot " +name);
	     driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

	    
		    File screenshot = ((TakesScreenshot)augmentedDriver).getScreenshotAs(OutputType.FILE);
		  
		   
		    
		    
		  
		    
		    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		    FileUtils.copyFile(screenshot, new File(name));
		    
		    return driver;
	 }

}


