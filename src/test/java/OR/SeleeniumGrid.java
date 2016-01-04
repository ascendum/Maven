package OR;
import org.openqa.selenium.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
public class SeleeniumGrid {
	
	WebDriver driver;
	String baseurl,nodeurl;
	
	@BeforeTest
	public void setup() throws MalformedURLException{
		baseurl="http://demo.opensourcecms.com/wordpress/wp-login.php";
		/*nodeurl="http://172.16.1.189:5566/wd/hub";*/
		nodeurl="http://172.16.1.157:5566/wd/hub";
		
		DesiredCapabilities capability=DesiredCapabilities.firefox();
		//DesiredCapabilities capability=DesiredCapabilities.chrome();
		capability.setBrowserName("firefox");
		capability.setPlatform(Platform.WIN8);
		/*capability.setBrowserName("chrome");
		capability.setPlatform(Platform.WIN8);*/
		
		driver=new RemoteWebDriver(new URL(nodeurl),capability);
	}
	@AfterTest
	public void aftertest() {
		driver.quit();
	}
  @Test
  public void simpletest() {
	  driver.get(baseurl);
	  driver.findElement(By.id("user_login")).sendKeys("admin");
	  driver.findElement(By.id("user_pass")).sendKeys("demo123");
	  driver.findElement(By.id("wp-submit")).click();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.MILLISECONDS);
  }
}
