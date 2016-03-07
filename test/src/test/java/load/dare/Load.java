package load.dare;

import org.testng.annotations.Test;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.Assert;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Random;
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

public class Load {  
  
  private WebDriver driver;  


  @BeforeClass
  @org.testng.annotations.Parameters(value={"browser","version","platform"})
  public void setUp(String browser, String version, String platform) throws Exception {
    DesiredCapabilities capability = new DesiredCapabilities();
    capability.setCapability("platform",platform);
    capability.setCapability("browserName", browser);
    capability.setCapability("browserVersion", version);
    capability.setCapability("project", "P1");
    capability.setCapability("build", "1.0");
    capability.setCapability("browserstack.debug", "true");
    driver = new RemoteWebDriver(
      new URL("http://zaqwsx1:Fs54nwmULt7BaSTosZxi@hub.browserstack.com/wd/hub"),
      capability);
  }  

  @Test
  public void testSimple() throws Exception {
    driver.get("http://dare:P@blicis123@dare-greatly-qa.pkt-tech.com/dont-you-dare");
    System.out.println("Page title is: " + driver.getTitle());
    String baseUrl = "http://dare:P@blicis123@dare-greatly-qa.pkt-tech.com";
   
    driver.get(baseUrl + "/dont-you-dare");
    driver.findElement(By.id("daretofirst")).clear();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    driver.findElement(By.id("daretofirst")).sendKeys("WOW YES WE MADE IT GO NY 1234");
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    driver.findElement(By.id("submit_first")).click();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    driver.findElement(By.id("sumbit_no_image")).click();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    driver.findElement(By.id("first")).click();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    driver.findElement(By.id("first")).clear();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    driver.findElement(By.id("first")).sendKeys("ANDREJ-KRISTOF");
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    driver.findElement(By.id("last")).click();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    driver.findElement(By.id("last")).clear();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    driver.findElement(By.id("last")).sendKeys("GOLDERNEAS");
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    driver.findElement(By.id("daretodo")).click();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    driver.findElement(By.id("daretodo")).clear();
    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    driver.findElement(By.id("daretodo")).sendKeys(driver.getTitle() + "ASJFOJFOEWFJPWGJPWOEGJOWPEGJPOEWJGOPWEGJWEPGW\nWEGJWEGOPEWJGWEPGOWEG\nWEGJWEOJGOPWEJGWOEPGJEWOPGJWE\nGWEGJWEGPOJWEOPGJEEEWWEEERWER");
    driver.findElement(By.id("submitToDb")).click();
    driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
    takeScreenPortrait("clean.png");
    
  }
  
  public WebDriver takeScreenPortrait(String name) throws IOException
	 {
		
		 WebDriver augmentedDriver = new Augmenter().augment(driver);
		//  System.out.println("Let me Rotate ");
	//	((Rotatable)augmentedDriver).rotate(ScreenOrientation.PORTRAIT);
	     System.out.println("Let me take a screenshot " +name);
	     driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	     System.out.println("I want to rotate");
	    
		    File screenshot = ((TakesScreenshot)augmentedDriver).getScreenshotAs(OutputType.FILE);
		  
		    
		    
		    driver.manage().timeouts().implicitlyWait(450000, TimeUnit.SECONDS);
		    
		    driver.manage().timeouts().implicitlyWait(450000, TimeUnit.SECONDS);
		    
		    driver.manage().timeouts().implicitlyWait(450000, TimeUnit.SECONDS);
		    
		    driver.manage().timeouts().implicitlyWait(450000, TimeUnit.SECONDS);
		    FileUtils.copyFile(screenshot, new File(name));
		    
		    return driver;
	 }
  
  public static void main(String[] args) {
	    int c;
	    Random t = new Random();
	 
	    // random integers in [0, 100]
	 
	    for (c = 1; c <= 100; c++) {
	      System.out.println(t.nextInt(100));
	    }
	  }
	

  @AfterClass  
  public void tearDown() throws Exception {  
    driver.quit();  
  }
}