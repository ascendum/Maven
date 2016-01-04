package OR;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class POMLibraryFile {
	WebDriver driver;
	
	//Guru99 page objects
    By GuruUserName = By.name("uid");
    By GuruPassword = By.name("password");
    By GurutitleText =By.className("barone");
    By Guruloginbtn = By.name("btnLogin");
    By GuruhomePageUserName = By.xpath("//table//tr[@class='heading3']");
    By Gurulogoutbtn = By.linkText("Log out");
    
    //Wordpress page objects
    By DemoUsername = By.id("user_login");
    By DemoPassword =By.id("user_pass");
    By DemoRemembermechk =By.id("rememberme");
    By DemoSubmitbtn =By.id("wp-submit");
    By DemoHomelnk =By.linkText("Home");
    By DemoLogoutmainlnk=By.id("wp-admin-bar-my-account");
    By DemoLogoutlnk =By.linkText("Log Out");
    
    
}
