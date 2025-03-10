package com.MyShopV2.base;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import com.MyshopV2.drivers.DriverManager;

public class CommonToAllTest {
	
	public static WebDriver driver;
	
				 @BeforeMethod
			     public void setUp(){
			         DriverManager.init();
			     }
			
//			     @AfterMethod
//			     public void tearDown(){
//			         DriverManager.down();
//			     }
				 
				//user method to capture screen shot
					public void captureScreenShot(WebDriver driver,String testName) throws IOException
					{
						//step1: convert webdriver object to TakesScreenshot interface
						TakesScreenshot screenshot = ((TakesScreenshot)driver);
						//step2: call getScreenshotAs method to create image file
						File src = screenshot.getScreenshotAs(OutputType.FILE);
						File dest = new File(System.getProperty("user.dir") + "//Screenshots//" + testName + ".png");
						//step3: copy image file to destination
						FileUtils.copyFile(src, dest);
					}
}