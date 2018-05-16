package com.raj.Base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;

import com.raj.Utils.TestUtil;
import com.raj.Utils.WebEventListener;



public class TestBase {

	
	public static WebDriver driver;
	public static Properties prop;
	
	public static EventFiringWebDriver event;
	public static WebEventListener listernerEvent;
	
	public TestBase() {
		try {
			prop = new Properties();

			FileInputStream fis = new FileInputStream(new File("/Users/rajeshm/eclipse-workspace/SamplePOM/src/main/java/com/raj/Config/configuration.properties"));
			prop.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	
	
	public static void init() {
		String browserName = prop.getProperty("browser");
		
		if(browserName.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/src/main/java/com/raj/Config/chromedriver");
			
			ChromeOptions op = new ChromeOptions();
			op.addArguments("headless");
			driver = new ChromeDriver(op);
		}
		else if(browserName.equalsIgnoreCase("ff"))
		{
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"/src/main/java/com/raj/Config/geckodriver");
			driver = new FirefoxDriver();
		}
		
		
		event = new EventFiringWebDriver(driver);
		listernerEvent = new WebEventListener();
		event.register(listernerEvent);
		driver = event;

		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
	}
	
	
	public static void tearDown() {
		driver.close();
		driver.quit();
	}

}
