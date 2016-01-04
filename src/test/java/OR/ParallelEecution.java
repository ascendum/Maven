package OR;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class ParallelEecution {
  @Test(enabled=false)
  public void executSessionOne(){
          //First session of WebDriver
      	  //System.setProperty("webdriver.firefox.driver","chromedriver.exe");
          WebDriver driver = new FirefoxDriver();
          //Goto guru99 site
          driver.get("http://demo.guru99.com/V4/");
          //find user name text box and fill it
          driver.findElement(By.name("uid")).sendKeys("Driver 1");
           
      }
  
  @Test(enabled=false)   
  public void executeSessionTwo(){
      //Second session of WebDriver
	  System.setProperty("webdriver.chrome.driver","chromedriver.exe");
	  WebDriver driver = new ChromeDriver();
      //Goto guru99 site
	  driver.get("http://demo.guru99.com/V4/");
	  //find user name text box and fill it
	  driver.findElement(By.name("uid")).sendKeys("Driver 2");
   
  }
  @Test(enabled=true)   
  public void executeSessionThree()  throws MalformedURLException{
      //Second session of WebDriver
	  //System.setProperty("webdriver.chrome.driver","D:\\Selenium\\Jars\\chromedriver.exe");
	  WebDriver driver = new FirefoxDriver();
      String baseurl = "http://demo.opensourcecms.com/wordpress/wp-login.php";
	  String nodeurl = "http://172.16.1.189:5566/wd/hub";
		
		//DesiredCapabilities capability=DesiredCapabilities.firefox();
		DesiredCapabilities capability=DesiredCapabilities.chrome();
		capability.setBrowserName("firefox");
		capability.setPlatform(Platform.WIN8);
	
		/*capability.setBrowserName("chrome");
		capability.setPlatform(Platform.WIN8);*/
		
		driver=new RemoteWebDriver(new URL(nodeurl),capability);
		
	   driver.get(baseurl);
	   driver.findElement(By.id("user_login")).sendKeys("admin");
	   driver.findElement(By.id("user_pass")).sendKeys("demo123");
	   driver.findElement(By.id("wp-submit")).click();
	   driver.manage().timeouts().implicitlyWait(10, TimeUnit.MILLISECONDS);
  }
  
  @Test(enabled=true) 
  public void executeSessionFour()  throws MalformedURLException{
      //Second session of WebDriver
	  //System.setProperty("webdriver.chrome.driver","chromedriver.exe");
	  WebDriver driver = new FirefoxDriver();
      String baseurl = "http://demo.opensourcecms.com/wordpress/wp-login.php";
	  String nodeurl = "http://172.16.1.189:5566/wd/hub";
		
		DesiredCapabilities capability=DesiredCapabilities.firefox();
		//DesiredCapabilities capability=DesiredCapabilities.chrome();
		capability.setBrowserName("firefox");
		capability.setPlatform(Platform.WIN8);
		/*capability.setBrowserName("chrome");
		capability.setPlatform(Platform.WIN8);*/
		
		driver=new RemoteWebDriver(new URL(nodeurl),capability);
		
	   driver.get(baseurl);
	   driver.findElement(By.id("user_login")).sendKeys("admin");
	   driver.findElement(By.id("user_pass")).sendKeys("demo123");
	   driver.findElement(By.id("wp-submit")).click();
	   driver.manage().timeouts().implicitlyWait(10, TimeUnit.MILLISECONDS);
	   
  }
  
 
}
