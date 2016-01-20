package brand.appium;

import org.openqa.selenium.By;

public class LoginTestCase extends StartBrowser {
	protected void loginUser(String userName,String password) {
	//	driver.findElement(By.linkText("Login")).click();

		waitElementsToAppear(25);
		driver.findElement(By.id("phsmartphonebody_0_username")).clear();;
		driver.findElement(By.id("phsmartphonebody_0_username")).sendKeys(userName);
		driver.findElement(By.id("phsmartphonebody_0_password")).clear();
		driver.findElement(By.id("phsmartphonebody_0_password")).sendKeys(password);
		driver.findElement(By.id("phsmartphonebody_0_submit")).click();
	}
}