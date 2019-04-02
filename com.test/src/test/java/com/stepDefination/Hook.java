package com.stepDefination;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.test.main.ConfigFileReader;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hook {
	  public static WebDriver driver;
	   public WebDriverWait wait;
	   String workingDir = System.getProperty("user.dir");
	   

	      @Before
	        public void setup () throws InterruptedException, IOException {
	    	  ConfigFileReader cr = new ConfigFileReader();
		        ChromeOptions options = new ChromeOptions();
		        options.addArguments("--disable-notifications");
		        if(cr.getBrowserName().equalsIgnoreCase("Chrome")) {
	            System.setProperty("webdriver.chrome.driver", workingDir+"/drivers/chromedriver.exe");
	            driver = new ChromeDriver(options);
		        }else {
	                System.out.println("Please provide Browser ");    
	            }
	            driver.manage().window().maximize();
	            driver.get(cr.getURL());
	            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	        }
	      
	      @After
	        public void teardown () {
	            driver.quit();
	        }
}
