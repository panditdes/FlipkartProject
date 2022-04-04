package baseClassess;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class BaseClass1 {
	

	//@Parameters("browser")
	
	public static WebDriver getWebDriver()// String a
	{
	   
	  //if(a.equals("chrome"))      //configuration--config.properties
	  // {
	        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\browser\\chromedriver.exe");
	    	
	    	
			WebDriver driver = new ChromeDriver();      //upcasting
			
			driver.get("https://www.flipkart.com/"); //get.(string url):void-webdriverpackage selenium;

			
			driver.manage().window().maximize();      //for maximize the method
			
			return driver;
	 //  }
//	   else
//	   {
//		   System.setProperty("webdriver.gecko.driver", "src\\main\\resources\\browser\\geckodriver.exe"); // Setting system properties of FirefoxDriver
//			
//		    WebDriver driver = new FirefoxDriver(); //Creating an object of FirefoxDriver
//				
//				driver.get("https://www.flipkart.com/"); //get.(string url):void-webdriverpackage selenium;
//
//				
//				driver.manage().window().maximize();      //for maximize the method
//				
//				return driver;   
//	   }
//	
//	
     }

}
