package cadilac.dare;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class ImagePath {
	
    @Test
	public void getPath()
    {
    	WebDriver driver;
    	driver=new FirefoxDriver();
    	driver.get("http://www.daregreatly.com/");
    	List<WebElement> allImages = driver.findElements(By.tagName("img"));
    	for(WebElement imageFromList:allImages){
    	     String ImageUrl=imageFromList.getAttribute("src");
    	     System.out.println(ImageUrl); //will get you all the image urls on the page
    	}
    }

}
