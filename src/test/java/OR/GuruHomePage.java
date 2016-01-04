package OR;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class GuruHomePage {
 
    WebDriver driver;
    By homePageUserName = By.xpath("//table//tr[@class='heading3']");
  
     public GuruHomePage(WebDriver driver){
         this.driver = driver;
     }
 
     //Get the User name from Home Page
      public String getHomePageDashboardUserName(){
         return driver.findElement(homePageUserName).getText();
         }
 
}