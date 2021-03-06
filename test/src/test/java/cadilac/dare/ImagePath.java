package cadilac.dare;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class ImagePath {
	
    @Test
	public void getPath() throws IOException
    {
    	WebDriver driver;
    	driver=new FirefoxDriver();
    	driver.get("http://dare:P@blicis123@dare-greatly-qa.pkt-tech.com");
    	
    	
    	BufferedReader br =null;
	    String line="";
	    String url;
	    int counter =1;
	    String csvFileToRead;
		String local=(new java.io.File("").getAbsolutePath());
		String data="" + local + "/" + "crestpdp.csv";	
	    File dir = new File("/users/agolubev1/Desktop/RondAndroid");
	
	    int lineNumber = 0;
	    csvFileToRead = data;
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
	        
    	List<WebElement> allImages = driver.findElements(By.tagName("img"));
    	for(WebElement imageFromList:allImages){
    	     String ImageUrl=imageFromList.getAttribute("src");
    	     boolean  b = ImageUrl.startsWith("http://d1i4fq3vfx2gix.cloudfront.net"); 
    	     
    	     System.out.println("The Page " + driver.getTitle() + "looks good");
    	    
    	     if (false)
    	     {
    	    	 System.out.println(ImageUrl); //will get you all the image urls on the page
    	     }
    	     counter+=1;
    	     
    	}
    }
    }

}
