package staging.templates;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.concurrent.TimeUnit;
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
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ProductGroup extends QuickView {
	public int lineNumber=0;
	public String url,line;
	@Test
	public void productList() throws IOException, InterruptedException{
		
		  BufferedReader br =null;
		    String line="";
		    String ext = "png";
		   
		    String local=(new java.io.File("").getAbsolutePath());
		    String csvFileToRead ="" + local + "/" + "crestpdp.csv";
			
		    File dir = new File("/users/agolubev1/Desktop/RondAndroid");
		
		    int lineNumber = 0;

		    br = new BufferedReader(new FileReader(csvFileToRead));  
	
	 while ((line = br.readLine()) != null) {
	  	  
	        System.out.println("The URL is " + counter);
	        String [] nextLine = line.split(",");
	        // nextLine[] is an array of values from the line
	        System.out.println(nextLine[lineNumber]);
	        url=nextLine[lineNumber];
	        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	        System.out.println("The URL is " + url);	
	        
	        System.out.println("I went to URL  " + url);
	        driver.get(url);
	        setupSocial();
	  	  getSocialCount();
	  	  for(int i=0;i<socialCount;i++)
	  	  {
	  	  testSocial("phdesktopbody_0_phdesktopbreadcrumbtrail_1_rptSMLinks_smHyperLink_"+i);
	  	  }
	  	  getDropDown();
	       
	     
	       
	        
	        counter+=1;

	      }
	}

}
