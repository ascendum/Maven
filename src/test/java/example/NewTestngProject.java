package example;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.openqa.selenium.By;      
import org.openqa.selenium.WebDriver;       
import org.openqa.selenium.firefox.FirefoxDriver;       
import org.testng.Assert;       
import org.testng.annotations.Test; 
import org.testng.annotations.BeforeTest;   
import org.testng.annotations.AfterTest;
public class NewTestngProject {
  
      private WebDriver driver;       
      @Test              
      public void testEasy() {    
    	  driver.get("https://en.wikipedia.org/wiki/Main_Page");
    	  driver.manage().window().maximize();
    	  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    	  
    	  String ExpectedTitle="Wikipedia, the free encyclopedia";
    	  String ActualTitle=driver.getTitle();
    	  Assert.assertEquals(ActualTitle, ExpectedTitle);
    	  String Expectedlink1="Main page";
    	  String Actuallink1=driver.findElement(By.id("n-mainpage-description")).getText();
    	  Assert.assertEquals(Actuallink1, Expectedlink1);
    	  driver.findElement(By.linkText("Arts")).click();
    	  driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
    	  
    	  String Expectedlink2="Portal:Arts";
    	  String Actuallink2=driver.findElement(By.id("firstHeading")).getText();
    	  Assert.assertEquals(Actuallink2, Expectedlink2);     
      }   
      @BeforeTest
      public void beforeTest() {  
          driver = new FirefoxDriver();  
      }       
      @AfterTest
      public void afterTest() {
          driver.quit();          
      }       
      
} 

  


