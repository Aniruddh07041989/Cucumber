package com.test.main;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigFileReader {
	String result = "";
	InputStream inputStream;
	static Properties prop ;
	static String workingDir = System.getProperty("user.dir");
	public ConfigFileReader() throws IOException {
 
		try {
		    prop = new Properties();
			String propFileName = "Configuration.properties";
 
			inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
 
			if (inputStream != null) {
				prop.load(inputStream);
			} else {
				throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
			}
		} catch (Exception e) {
			System.out.println("Exception: " + e);
		} finally {
			inputStream.close();
		}
	}
	
	  public String getBrowserName() {
	        String browserName =  prop.getProperty("browserName");
	        if(browserName!= null) return browserName;
	        else throw new RuntimeException("browserName not specified in the Configuration.properties file.");    
	    }

	    public String getURL() {
	        String dematURL =  prop.getProperty("URL");
	        if(dematURL!= null) return dematURL;
	        else throw new RuntimeException("dematURL not specified in the Configuration.properties file.");    
	    }
	    
	    public String getReportConfigPath(){
	    	 String reportConfigPath =  prop.getProperty("reportConfigPath");
	    	 if(reportConfigPath!= null) return reportConfigPath;
	    	 else throw new RuntimeException("Report Config Path not specified in the Configuration.properties file for the Key:reportConfigPath"); 
	    	}
	   
}