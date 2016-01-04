package OR;
 
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import OR.PageFactoryLibrary;
 
 
public class PagefactoryScript {
 
    WebDriver driver;
    PageFactoryLibrary Mylibrary;
         
    @BeforeTest
    public void setup(){
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://demo.guru99.com/V4/");
 
    }
 
    
    @Test(priority=0)
    public void test_Home_Page_Appear_Correct(){
 
        //Create Login Page object
    	Mylibrary = new PageFactoryLibrary(driver);
       //Verify login page title
       String loginPageTitle = Mylibrary.GurutitleTextPF.getText();
       Assert.assertTrue(loginPageTitle.toLowerCase().contains("guru99 bank"));
      //login to application
       Mylibrary.GuruUserNamePF.sendKeys("mngr13736");
       Mylibrary.GuruPasswordPF.sendKeys("tuzutUq");
       Mylibrary.GuruloginbtnPF.click();
       
       boolean homePageTitle=Mylibrary.GuruhomePageUserName.getText().contains("manger id : mngr13736");
       
       if(homePageTitle=true){
    	   Reporter.log("manger id : mngr13736 message is displayed");
       }
      
       try {
     	  Mylibrary.GurulogoutPF.click();
     	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
       }catch(Exception e){
     	   Reporter.log(e.getMessage());
     	   //driver.switchTo().alert().dismiss();  
       }
       
     }
    
    @AfterTest
    public void postcondition() {
    	driver.quit();
    }
   
}