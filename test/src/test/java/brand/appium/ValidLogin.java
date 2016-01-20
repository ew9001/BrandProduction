package brand.appium;

import org.testng.annotations.Test;
import java.io.IOException;

public class ValidLogin extends LoginTestCase {
	public String browser="chrome";
	public String folder = "screenshots";
	public String fail,error,url;
	public String name;
	public String brand;	

	@Test
	public void invalidLogin() throws IOException, InterruptedException {

		System.out.println("Let me look at valid login");
		Thread.sleep(2000);
		loginUser("albert.golubev@pkt.com", "zaq12wsx");
		Thread.sleep(2000);
		waitForClickable("phsmartphonebody_0_labelvaluegrs_consumer[firstname]");
		softAssertText("Konstantin-Alexander", "phsmartphonebody_0_labelvaluegrs_consumer[firstname]");
		Thread.sleep(2000);
		takeScreenshot("valid_login.png");

	}
}