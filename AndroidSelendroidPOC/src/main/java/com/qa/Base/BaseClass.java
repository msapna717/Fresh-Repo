package com.qa.Base;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.qa.Util.WebEventListener;



public class BaseClass {
	
	//public static AndroidDriver<MobileElement> driver;
	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	

	public BaseClass(){
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir") + "/src/main/java/com/qa/Config/Config.Properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	public static void initialization() throws MalformedURLException{
		String browser = prop.getProperty("BROWSERNAME");
		String apkfile=prop.getProperty("Apkfilepath");
		String Version=prop.getProperty("PlatformVersion");
		String Device=prop.getProperty("DeviceName");
		String pakage =prop.getProperty("AppPackage");
		String Activity=prop.getProperty("AppActivity");
		//String Server=prop.getProperty("AppiumServer");
		String platform=prop.getProperty("PlatformName");
				
		//Set up desired capabilities and pass the Android app-activity and app-package to Appium
		File file=new File(apkfile);
		//path=System.getProperty("user.dir");
		DesiredCapabilities capabilities = new DesiredCapabilities();
		//capabilities.setCapability("CapabilityType.BROWSER_NAME","Android");
		capabilities.setCapability("CapabilityType.BROWSER_NAME",browser);
		capabilities.setCapability("platformVersion", Version); 
		capabilities.setCapability("deviceName",Device);
		capabilities.setCapability("platformName",platform);
	    capabilities.setCapability("appPackage", pakage);
	    capabilities.setCapability("appActivity", Activity);
	   capabilities.setCapability(MobileCapabilityType.APP, file.getAbsolutePath());
	   //capabilities.setCapability("app",path+"//app//selendroid-test-app-0.17.0.apk");
	    System.out.println("Session is created");
	    
	    try{
	    	driver= new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
	  }catch(MalformedURLException e){
	    	e.printStackTrace();
	    }
	    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	    
	    
	    e_driver = new EventFiringWebDriver(driver);
	   eventListener = new WebEventListener();
	 e_driver.register(eventListener);
	 driver= e_driver;
	    
}	
	}








	