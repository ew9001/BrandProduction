package brand.appium;

import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Screenshot {
	public static void takeSnapshot(String screenName){
		//
		String setName = "shell screencap -p /sdcard/"+ screenName;
		String pullName ="pull /sdcard/" + screenName;

		//in mac oxs
		//String command = "ping -c 3 " + domainName;

		//in windows
		String command1 = "/Users/pktqa/android-sdks/platform-tools/./adb " + setName;

		executeCommand(command1);

		String command2 = "/Users/pktqa/android-sdks/platform-tools/./adb " + pullName;

		executeCommand(command2);
	}

	private static String executeCommand(String command) {

		StringBuffer output = new StringBuffer();

		Process p;
		try {
			p = Runtime.getRuntime().exec(command);
			p.waitFor();
			BufferedReader reader = 
					new BufferedReader(new InputStreamReader(p.getInputStream()));

			String line = "";			
			while ((line = reader.readLine())!= null) {
				output.append(line + "\n");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return output.toString();

	}

}
