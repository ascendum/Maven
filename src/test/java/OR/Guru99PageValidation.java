package OR;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import OR.POMHomePage;
import OR.POMLoginPage;

//import pages.Guru99Login;

public class Guru99PageValidation {
	WebDriver driver;
	POMLoginPage objLogin;
 	POMHomePage objHomePage;
 
     @BeforeTest
     public void setup(){
         //driver = new FirefoxDriver();
    	 //driver = new InternetExplorerDriver();
    	 driver = new ChromeDriver();
    	 
         driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
         driver.get("http://demo.guru99.com/V4/");
         
    }
 
    /**
      * This test case will login in http://demo.guru99.com/V4/
      * Verify login page title as guru99 bank
      * Login to application
      * Verify the home page using Dashboard message
      */
 
    @Test(priority=0)
     public void test_Home_Page_Appear_Correct(){
 
        //Create Login Page object
        objLogin = new POMLoginPage(driver);
        objHomePage = new POMHomePage(driver);
       //Verify login page title
        driver.findElement(objLogin.userName).sendKeys("direct calling");
        driver.findElement(objLogin.userName).clear();
       String loginPageTitle = objLogin.getLoginTitle();
       Assert.assertTrue(loginPageTitle.toLowerCase().contains("guru99 bank"));
       //login to application
       objLogin.loginToGurudemo("mngr13736","tuzutUq");
      //Verify home page
      Assert.assertTrue(objHomePage.getHomePageDashboardUserName().toLowerCase().contains("manger id : mngr13736"));
      Reporter.log("Home page verification completed");
    }
    @AfterTest
    public void postcondition() {
    	driver.quit();
    }
    @BeforeSuite
    public void preconditions(){
    	
    }
}
