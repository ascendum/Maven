package OR;

import java.util.concurrent.TimeUnit;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class junittestcase {
	WebDriver driver;
	@BeforeTest
    public void setup(){
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://demo.guru99.com/V4/");
        
   }
	 @Test
     public void test_Home_Page_Appear_Correct(){
 
		 driver.get("http://demo.opensourcecms.com/wordpress/wp-login.php");
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		 driver.findElement(By.id("user_login")).click();
		 driver.findElement(By.id("user_login")).sendKeys("admin");
		 driver.findElement(By.id("user_pass")).sendKeys("demo123");
		 driver.findElement(By.id("wp-submit")).click();
		 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		 
    }
	 @AfterTest
	    public void postcondition() {
	    	driver.quit();
	    }
}
