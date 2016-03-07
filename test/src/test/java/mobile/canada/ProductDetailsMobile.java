package mobile.canada;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
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
import org.openqa.selenium.firefox.FirefoxDriver;
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
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import brand.appium.StartBrowser;
import io.appium.java_client.android.AndroidDriver;
public class ProductDetailsMobile extends StartBrowser {
	

	 private SoftAssert softAssert = new SoftAssert(); 
	 public  WebDriver driver = new FirefoxDriver();
	  public String browser;
	  public String folder = "screenshots";
	  public String fail,error,url,name,actualText,id,actual,brand;
	  public String local=(new java.io.File("").getAbsolutePath());
		String data="" + local + "/" + "pdp.csv";	
		String csvFileToRead;
	 

		static String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
	    int counter=1;
	
		

	//	@Parameters({"browser"})

	    @BeforeMethod
		  public void loadBrowserOnDevice() throws MalformedURLException {
			  
			    DesiredCapabilities caps = new DesiredCapabilities();
				caps.setCapability("automationName","Appium");
				caps.setCapability("deviceName","Galaxy S4");
				caps.setCapability("platformVersion","4.4");
				caps.setCapability("appPackage", "com.android.chrome");
				caps.setCapability("appActivity","Main");
				caps.setCapability("autoAcceptAlerts",true);
				
				driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),caps);
				
				//driver.get(System.getProperty("BrandUrl"));
			      
				driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);	
		  }
	   
	   @Test
	    public void run() throws InterruptedException, IOException {
	    	String local=(new java.io.File("").getAbsolutePath());
			String data1="" + local + "/" + "canadaList.csv";	
	    	
			BufferedReader br =null;
		    String line="";
		    String ext = "png";
		    File dir = new File("/users/agolubev1/Desktop/RondAndroid");
		
		    int lineNumber = 0;
		    csvFileToRead = data1;
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
				   driver.manage().timeouts().implicitlyWait(450000, TimeUnit.SECONDS);
		        driver.findElement(By.linkText("ProductDetails"));
				   driver.manage().timeouts().implicitlyWait(450000, TimeUnit.SECONDS);
		        takeScreenshot(driver.getTitle() + ".png");
		    }
	   }
		

	


	}



