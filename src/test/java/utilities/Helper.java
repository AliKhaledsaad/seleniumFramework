package utilities;


import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


public class Helper {

	public static void captureScreenshot(WebDriver driver,String screenshotName)
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(src, new File("./Screenshots/"+screenshotName+".png" ));
		} catch (IOException e) {
			
			System.out.println("io exception : "+e.getMessage());
		}
	}
	
}
