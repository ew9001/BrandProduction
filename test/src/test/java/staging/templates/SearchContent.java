package staging.templates;


	
	import java.io.IOException;
	import java.util.List;
	import java.util.concurrent.TimeUnit;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.ui.Select;
	import org.testng.annotations.Test;

	public class SearchContent extends QuickView
	{
		@Test
		public void getContent() throws IOException, InterruptedException
		{
		
		driver.get(System.getProperty("BrandUrl"));
		 name=""+ System.getProperty("Browser")+"/" + "inside" +"_"+ timeStamp + ".png";
		    takeScreeshot(name); 
		    
		    
			  WebElement pack_size=driver.findElement(By.id("phdesktopbody_0_phdesktopproductresults_0_ddlSortBy"));
			  List<WebElement> pack  = pack_size.findElements(By.tagName("option"));
			  
			  for(int i=pack.size();i>0;i--)
			 // for(int i=0;i<pack.size();i++)
			  {   
				  
				  String value = pack.get(i-1).getText();
			
				  System.out.println("For Pack Size#" +counter +" " +value);
				
				  new Select(driver.findElement(By.id("phdesktopbody_0_phdesktopproductresults_0_ddlSortBy"))).selectByVisibleText(value);
				  counter+=1;
				  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				  name=""+ System.getProperty("Browser")+"/" + "sort" +"_"+ counter + ".png";
				  counter+=1;
				    takeScreeshot(name); 
				  
			  }
		    
		    driver.manage().timeouts().implicitlyWait(35, TimeUnit.SECONDS);
			  Thread.sleep(1000);
			  driver.findElement(By.id("phdesktopbody_0_phdesktopproductresults_0_imgListViewIcon")).click();
			  name=""+ System.getProperty("Browser")+"/" + "grid view" +"_"+ timeStamp + ".png";
			    takeScreeshot(name); 
			    
			  driver.manage().timeouts().implicitlyWait(35, TimeUnit.SECONDS);
			  Thread.sleep(1000);
			  driver.findElement(By.id("phdesktopbody_0_phdesktoptabheader_0_anchorContentResult")).click();
			  name=""+ System.getProperty("Browser")+"/" + "content" +"_"+ timeStamp + ".png";
			    takeScreeshot(name); 
			    
			    
			    
			  
			  
		}

	

}
