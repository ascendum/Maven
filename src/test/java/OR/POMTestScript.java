package OR;

import java.util.concurrent.TimeUnit;

import org.apache.bcel.verifier.structurals.ExceptionHandler;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class POMTestScript {
	WebDriver driver;
	POMLibraryFile ProjectLibrary;
		
 	
  @Test(priority=0,enabled=true)
  public void verifyGurupage() throws Exception{
	  driver.get("http://demo.guru99.com/V4/");
	  ProjectLibrary = new POMLibraryFile(); 
	  
	  driver.findElement(ProjectLibrary.GuruUserName).sendKeys("mngr13736");
	  driver.findElement(ProjectLibrary.GuruPassword).sendKeys("tuzutUq");
	  driver.findElement(ProjectLibrary.Guruloginbtn).click();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.MILLISECONDS);
	  
	  String loginPageTitle = driver.findElement(ProjectLibrary.GurutitleText).getText();
      Assert.assertTrue(loginPageTitle.toLowerCase().contains("guru99 bank"));
      
      Assert.assertTrue(driver.findElement(ProjectLibrary.GuruhomePageUserName).getText().toLowerCase().contains("manger id : mngr13736"));
      Reporter.log("Guru99 Home page verification completed");
   
      try {
    	  driver.findElement(ProjectLibrary.Gurulogoutbtn).click();
    	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
      }catch(Exception e){
    	   Reporter.log(e.toString());
    	   //driver.switchTo().alert().dismiss();	  
      }
      
          
      
  }
  
  @Test(priority=1,enabled=true)
  public void verifyWordWebPage() {
	  driver.get("http://demo.opensourcecms.com/wordpress/wp-login.php");
	  ProjectLibrary = new POMLibraryFile(); 
	  
	  driver.findElement(ProjectLibrary.DemoUsername).sendKeys("admin");
	  driver.findElement(ProjectLibrary.DemoPassword).sendKeys("demo123");
	  driver.findElement(ProjectLibrary.DemoSubmitbtn).click();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.MILLISECONDS);
	  
	  String loginPageTitle = driver.findElement(ProjectLibrary.DemoHomelnk).getText();
      Assert.assertTrue(loginPageTitle.toLowerCase().contains("home"));
      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
      driver.findElement(ProjectLibrary.DemoLogoutmainlnk).click();
           
      if(driver.findElement(ProjectLibrary.DemoLogoutmainlnk).isDisplayed()) {
    	  driver.findElement(ProjectLibrary.DemoLogoutlnk).click();
    	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.MILLISECONDS);
      }
      
   }
  @BeforeTest
  public void beforeTest() {
	  driver = new FirefoxDriver();
      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
      
  }

  @AfterTest
  public void afterTest() {
	 driver.quit();
  }

}
