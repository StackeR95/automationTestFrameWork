
import org.openqa.selenium.WebDriver;
import PageObjects.* ;
public class PageManager {

    private LoginPage loginPage ;
    private WebDriver driver;

    public PageManager(WebDriver driver) {

        this.driver = driver;

    }



    public LoginPage getHomePage(){

        return (loginPage == null) ? loginPage = new LoginPage(driver) : loginPage;

    }


}
