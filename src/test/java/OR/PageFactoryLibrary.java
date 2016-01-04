package OR;

import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageFactoryLibrary {
	
	WebDriver driver;
	
	@FindBy(name="uid")
    WebElement GuruUserNamePF;
    
	@FindBy(name="password")
    WebElement GuruPasswordPF;
	
	@FindBy(className="barone")
    WebElement GurutitleTextPF;
	
	@FindBy(name="btnLogin")
    WebElement GuruloginbtnPF;
 
	@FindBy(xpath="//table//tr[@class='heading3']")
    WebElement GuruhomePageUserName;
	
	@FindBy(linkText="Log out")
    WebElement GurulogoutPF;
	
    public PageFactoryLibrary(WebDriver driver){
    	 
        this.driver = driver;
 
        //This initElements method will create all WebElements
         PageFactory.initElements(driver, this);
 
    }
    

}
